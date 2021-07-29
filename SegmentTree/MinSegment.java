import java.util.*;
//Range Minimum Query => HackerEarth Problem
//testcase
// 5 5
// 1 5 2 4 3
// q 1 5
// q 1 3
// q 3 5
// u 3 6
// q 1 5
public class MinSegment {
    //ss-> segemnt start , se-> segement end  , node-> current tree node
    public static void buildForMinQuery(int node, int ss, int se,int[] tree,int[] A){
        if(ss == se){
            // Leaf node will have a single element
            tree[node] = A[ss];
        }else{
            int mid = (ss + se) / 2;
            // Recurse on the left child
            buildForMinQuery(2*node, ss, mid,tree,A);
            // Recurse on the right child
            buildForMinQuery(2*node+1, mid+1, se,tree,A);
            // Internal node will have the sum of both of its children
            tree[node] = Math.min(tree[2*node], tree[2*node+1]);
        }
    }  

    public static  void update(int node, int ss, int se, int idx, int val,int[] tree,int[] A){
        if(ss == se){
            // Leaf node
            A[idx] += val;
            tree[node] += val;
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
            tree[node] = Math.min(tree[2*node],tree[2*node+1]);
        }
    }

    public static  int rangeMin(int node, int ss, int se, int l, int r,int[] tree){
        if(r < ss || se < l){
            // range represented by a node is completely outside the given range
            return Integer.MAX_VALUE;
        }
        if(l <= ss && se <= r){
            // range represented by a node is completely inside the given range
            return tree[node];
        }
        // range represented by a node is partially inside and partially outside the given range
        int mid = (ss + se) / 2;
        int p1 = rangeMin(2*node, ss, mid, l, r,tree);
        int p2 = rangeMin(2*node+1, mid+1, se, l, r,tree);
        return Math.min(p1, p2);
    }

    public static void main(String args[] ){
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int q=scn.nextInt();
        int[] arr=new int[n+1];
        //V.V.Imp Note-In both array I used 1 base indexing
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x); 
        int[] tree = new int[max_size]; // Memory allocation 
        // tree[0]=Integer.MAX_VALUE;
        
        for(int i=1;i<=n;i++){arr[i]=scn.nextInt();}
        Arrays.fill(tree,Integer.MAX_VALUE);
        buildForMinQuery(1,1,n,tree,arr);

         while(q-->0){
            char query=(scn.next()).charAt(0);
            int l=scn.nextInt();
            int r=scn.nextInt();
            // System.out.println(query+" "+l+" "+r);

            if(query=='q'){
                // l--; r--;
            int ans=rangeMin(1,1,n,l,r,tree);
            System.out.println(ans);
            }else{
                int diff=r-arr[l];//tree[l+n-1];
                // arr[l]=r;
                update(1,1,n,l,diff,tree,arr);
            }
         }
    }


}
