import java.util.*;

public class Wrongsegment {
    
    public static void buildForSumQuery(int node, int start, int end,int[] tree,int[] A){
                if(start == end)
                {
                    // Leaf node will have a single element
                    tree[node] = A[start];
                }
                else{
                    int mid = (start + end) / 2;
                    // Recurse on the left child
                    buildForSumQuery(2*node, start, mid,tree,A);
                    // Recurse on the right child
                    buildForSumQuery(2*node+1, mid+1, end,tree,A);
                    // Internal node will have the sum of both of its children
                    tree[node] = tree[2*node] + tree[2*node+1];
                }
            }

            public static void buildForMinQuery(int node, int start, int end,int[] tree,int[] A){
                if(start == end)
                {
                    // Leaf node will have a single element
                    tree[node] = A[start];
                }
                else{
                    int mid = (start + end) / 2;
                    // Recurse on the left child
                    buildForMinQuery(2*node, start, mid,tree,A);
                    // Recurse on the right child
                    buildForMinQuery(2*node+1, mid+1, end,tree,A);
                    // Internal node will have the sum of both of its children
                    tree[node] = Math.min(tree[2*node], tree[2*node+1]);
                }
            }       

    public static int rangeSum(int l,int r,int n,int[] tree){
        l+=n; r+=n;
        int sum=0;
        while(l<=r){
            if(l%2==1){sum+=tree[l++];}
            if(r%2==0){sum+=tree[r--];}
            l/=2; r/=2; 
        }

        return sum;
    }
    public static int rangeMin(int l,int r,int n,int[] tree){
        l+=n; r+=n;
        int ans=Integer.MAX_VALUE;
        while(l<=r){
            if(l%2==1){ans=Math.min(ans,tree[l++]);}
            if(r%2==0){ans=Math.min(ans,tree[r--]);}
            l/=2; r/=2; 
        }

        return ans;
    }
    //The following function increases the array value at position k by diff:
    public static void addOrUpdate(int k, int diff,int n,int[] tree) {
        k += n;
        tree[k] += diff;
        for (k /= 2; k >= 1; k /= 2) {
           tree[k] = tree[2*k]+tree[2*k+1]; //left child + right child;
        }
    }
    public static void main(String[] args){
        // int[] tree={0,39,22,17,13,9,9,8,5,8,6,3,2,7,2,6};
        // int[] tree={0,0,0,0,0,0,0,5,8,6,3,2,7,2,6};
        //int[] A={5,8,6,3,1,7,2,6};
        int[] A={1,5,2,4,3};
        int n=A.length;
        // int[] tree=new int[(2*n)];

        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
  
        //Maximum size of segment tree 
        int max_size = 2 * (int) Math.pow(2, x); 
  
        int[] tree = new int[max_size]; // Memory allocation 
  
        
        buildForSumQuery(1, 0, n-1, tree,A);  //O(n)
        // //treeNode indexing start from 1 but intial array have indexing from 0 to (n-1)
        // for(int val:tree){System.out.print(val+" ");}
        // System.out.println();
        System.out.println(rangeSum(0,2,n,tree));//O(logn)
        // int k=2;
        // int diff=10-tree[k+n];
        // addOrUpdate(k,diff,n,tree);
        // for(int val:tree){System.out.print(val+" ");}
        
        buildForMinQuery(1, 0, n-1, tree, A);
        for(int val:tree){System.out.print(val+" ");}

        int ans=rangeMin(0,2, n, tree);
        System.out.println();
        System.out.println(ans);
    }
}


