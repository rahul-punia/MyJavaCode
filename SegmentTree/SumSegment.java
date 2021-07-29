import java.util.*;
import java.io.*;
import java.lang.*;

//Range Minimum Query => HackerEarth Problem
//testcase
// 5 5
// 1 5 2 4 3
// q 1 5
// q 1 3
// q 3 5
// u 3 6
// q 1 5
public class SumSegment {
    //ss-> segemnt start , se-> segement end  , node-> current tree node
    public static void buildForSumQuery(int node, int ss, int se,int[] tree,int[] A){
        if(ss == se){
            // Leaf node will have a single element
            tree[node] = A[ss];
        }else{
            int mid = (ss + se) / 2;
            // Recurse on the left child
            buildForSumQuery(2*node, ss, mid,tree,A);
            // Recurse on the right child
            buildForSumQuery(2*node+1, mid+1, se,tree,A);
            // Internal node will have the sum of both of its children
            tree[node] = tree[2*node]+tree[2*node+1];
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
            tree[node] =tree[2*node]+tree[2*node+1];
        }
    }

    public static  int rangeSum(int node, int ss, int se, int l, int r,int[] tree){
        if(r < ss || se < l){
            // range represented by a node is completely outside the given range
            return 0;
        }
        if(l <= ss && se <= r){
            // range represented by a node is completely inside the given range
            return tree[node];
        }
        // range represented by a node is partially inside and partially outside the given range
        int mid = (ss + se) / 2;
        int s1 = rangeSum(2*node, ss, mid, l, r,tree);
        int s2 = rangeSum(2*node+1, mid+1, se, l, r,tree);

        return s1+s2;
    }

    public static void main(String args[] ) throws Exception{  
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ip);

        String[] strs=(br.readLine()).trim().split(" ");

        // Scanner scn = new Scanner(System.in);
        // int n=scn.nextInt();
        // int q=scn.nextInt();

        int n=Integer.parseInt(strs[0]),  q=Integer.parseInt(strs[1]);
        int[] arr=new int[n+1];
        //V.V.Imp Note-In both array I used 1 base indexing
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        //Maximum size of segment tree 

        int max_size = 2 * (int) Math.pow(2, x); 
        int[] tree = new int[max_size]; // Memory allocation 
        // tree[0]=Integer.MAX_VALUE;
        
        strs=(br.readLine()).trim().split(" ");

        for(int i=0;i<n;i++){arr[i+1]=Integer.valueOf(strs[i]); }


        // int[] marr={0,2,-4,10,-3,7};
        
        Arrays.fill(tree,Integer.MAX_VALUE);
        buildForSumQuery(1,1,n,tree,arr);

         while(q-->0){
            strs=(br.readLine()).trim().split(" ");
            int l=Integer.parseInt(strs[0]),  r=Integer.parseInt(strs[1]);
            int query=Integer.parseInt(strs[2]);
            // System.out.println(query+" "+l+" "+r);

            if(query==1){
                // l--; r--;
            int ans=rangeSum(1,1,n,l,r,tree);
            System.out.println(ans);
            }else{
                int diff=r-arr[l];//tree[l+n-1];
                // arr[l]=r;
                update(1,1,n,l,diff,tree,arr);
            }
         }
    }
}

//testcase
// 5 5
// 1 5 2 4 3
// 1 5  1
// 1 3 1 
// 3 5 1
// 3 6 2
// 1 5 1