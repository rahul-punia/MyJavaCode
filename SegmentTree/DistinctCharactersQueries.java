import java.util.*;
//Problem
//https://codeforces.com/problemset/problem/1234/D

//use 26 size array to avoid timelimitExceded bcz some operations of Hashmap are O(n)
public class DistinctCharactersQueries {
    //ss-> segemnt start , se-> segement end  , node-> current tree node
    static int maxDistinct=0;
    public static void buildForDCQuery(int node, int ss, int se,HashSet<Character>[] tree,char[] A){
        if(ss == se){
            // Leaf node will have a single element
            // tree[node] = A[ss];
              (tree[node]).add(A[ss]);
        }else{
            int mid = (ss + se) / 2;
            // Recurse on the left child
            buildForDCQuery(2*node, ss, mid,tree,A);
            // Recurse on the right child
            buildForDCQuery(2*node+1, mid+1, se,tree,A);
            // Internal node will have the sum of both of its children
            for(char ch:tree[2*node]){(tree[node]).add(ch);}
            for(char ch:tree[2*node+1]){(tree[node]).add(ch);}
            maxDistinct=Math.max(maxDistinct,tree[node].size());
            // tree[node] = Math.min(tree[2*node], tree[2*node+1]);
        }
    }  

    public static  void update(int node, int ss, int se, int idx, char val,HashSet<Character>[] tree,char[] A){
        if(idx<ss || idx> se) return;
        if(ss == se){
            // Leaf node
            char old=A[idx];
            A[idx]=val;
            (tree[node]).remove(old);
            (tree[node]).add(val);
        }else{
            int mid = (ss + se) / 2;
            if(ss <= idx && idx <= mid){
                // If idx is in the left child, recurse on the left child
                update(2*node, ss, mid, idx, val,tree,A);
            }else{
                // if idx is in the right child, recurse on the right child
                update(2*node+1, mid+1, se, idx, val,tree,A);
            }
            // Internal node will have the sum of both of its children

            // tree[node] = Math.min(tree[2*node],tree[2*node+1]);
            tree[node]=new HashSet<>();
            for(char ch:tree[2*node]){(tree[node]).add(ch);}
            for(char ch:tree[2*node+1]){(tree[node]).add(ch);}

            maxDistinct=Math.max(maxDistinct,tree[node].size());
        }
    }
    static HashSet<Character> ans;
    public static  void rangeMin(int node, int ss, int se, int l, int r,HashSet<Character>[] tree){
        if(r < ss || se < l){
            // range represented by a node is completely outside the given range
            return ;
        }
        if(l <= ss && se <= r){
            // range represented by a node is completely inside the given range
            for(Character ch:tree[node]){ans.add(ch);}
            return ;//  //optional
        }
        // range represented by a node is partially inside and partially outside the given range
        int mid = (ss + se) / 2;

        if(ans.size()==maxDistinct){return;}  //optimization

         rangeMin(2*node, ss, mid, l, r,tree);
         rangeMin(2*node+1, mid+1, se, l, r,tree);
        
        return ;
    }

    public static void main(String args[] ){
        Scanner scn = new Scanner(System.in);
        String str=scn.next();
        int n=str.length();
        char[] arr=new char[n+1];
        for(int i=0;i<n;i++){arr[i+1]=str.charAt(i);}
        
        //V.V.Imp Note-In both array I used 1 base indexing
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x); 
        HashSet<Character>[] tree = new HashSet[max_size]; // Memory allocation 
        int q=scn.nextInt();
        
        for(int i=0;i<max_size;i++){tree[i]=new HashSet<Character>();}

        // Arrays.fill(tree,new HashSet<>());
        buildForDCQuery(1,1,n,tree,arr);

        // for(HashSet<Character> chs:tree){
        //     System.out.println(chs);
        // }

         while(q-->0){
            int query=scn.nextInt();
           
            if(query==2){
                int l=scn.nextInt();
                int r=scn.nextInt();
                ans=new HashSet<>();
                rangeMin(1,1,n,l,r,tree);
            System.out.println(ans.size());
            }else{
                int p=scn.nextInt();
                char diff=(scn.next()).charAt(0);
            
                // int diff=r-arr[l];//tree[l+n-1];
                // arr[l]=r;
                update(1,1,n,p,diff,tree,arr);
            }
         }
    }
}

//C++ Implementation using 26 size array to avoid timelimitExceded bcz some operations of Hashmap are O(n)

// #include <bits/stdc++.h>
// using namespace std;
// #define ll long long
// const int nax=1e5+5;
// vector<vector<bool>> seg(4*nax);
// string s;
// bool b[26];
// void build(int ci, int st, int end){
//     seg[ci].resize(26,0);
//     if(st==end){
//         seg[ci][s[st]-'a']=true; return ;
//     }
//     int mid=(st+end)/2;
//     build(2*ci+1,st,mid);
//     build(2*ci+2,mid+1,end);
//     for(int i=0;i<26;i++){
//         seg[ci][i]=seg[2*ci+1][i]|seg[2*ci+2][i];
//     }
// }
// void update(int ci, int st , int end,int p, int g){
//     if(p<st || p> end) return;
//     if(st==end){
//         for(int i=0;i<26;i++){
//             if(i==g) seg[ci][i]=true;
//             else seg[ci][i]=false;
//         }
//         return ;
//     }
//     int mid=(st+end)/2;
//     update(2*ci+1,st,mid,p,g);
//     update(2*ci+2,mid+1,end,p,g);
//     for(int i=0;i<26;i++){
//         seg[ci][i]=seg[2*ci+1][i]|seg[2*ci+2][i];
//     }
// }
// void query(int ci, int st, int end, int l, int r){
//     if(l>end || r<st) return ;
//     if(l<=st && r>=end){
//         for(int i=0;i<26;i++){
//             b[i]|=seg[ci][i];
//         }
//         return ;
//     }
//     int mid=(st+end)/2;
//     query(2*ci+1,st,mid,l,r);
//     query(2*ci+2,mid+1,end,l,r);
// }
// int main() {
//     #ifndef ONLINE_JUDGE
//     freopen("input.txt","r",stdin);
//     freopen("output.txt","w",stdout);
//     #endif
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL); cout.tie(NULL);
//     cin>>s;
//     int n=s.size();
//     int q;
//     cin>>q;
//     build(0,0,n-1);
//     while(q--){
//         int tt; cin>>tt;
//         if(tt==1){
//             int l; cin>>l; l--;
//             char g; cin>>g;
//             update(0,0,n-1,l,g-'a');
//         }
//         else{
//             int l,r; cin>>l>>r; l--; r--;
//             for(int i=0;i<26;i++){
//                 b[i]=false;
//             }
//             query(0,0,n-1,l--,r--);
//             int ans=0;
//             for(int i=0;i<26;i++){
//                 if(b[i]) ans++;
//             }
//             cout<<ans<<"\n";
//         }
//     }
// }




// dfcbbcfeeedbaea
// 16
// 2 6 8
// 1 6 e
// 1 4 b
// 2 6 14
// 1 7 b
// 1 12 c
// 2 6 8
// 2 1 6
// 1 7 c
// 1 2 f
// 1 10 a
// 2 7 9
// 1 10 a
// 1 14 b
// 1 1 f
// 2 1 11