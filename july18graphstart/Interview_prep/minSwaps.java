import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;


public class minSwaps {
    

//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
//https://www.geeksforgeeks.org/minimum-swaps-to-make-two-array-identical/

    public static int findminSwaps(int[] arr){
        
        int[][] sarr=new int[arr.length][2];

        int n=arr.length;
        for(int i=0;i<n;i++){
            sarr[i][0]=arr[i];
            sarr[i][1]=i;
        }

        Arrays.sort(sarr,(a,b)->{return a[0]-b[0];});

        boolean[] vst=new boolean[n];

        int ans=0;
        for(int i=0;i<n;i++){
            if(!vst[i] && sarr[i][1]!=i){
                int j=i;
                int ct=0;

                while(sarr[j][1]!=j && !vst[j]){
                    vst[j]=true;
                    j=sarr[j][1];
                    ct++;
                }

                ans+=(ct-1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
         //Question-1
        // int[] arr={1,4,5,3,2,6,9,8,7};
        int[] arr={4,3,2,1};    
        int ans=findminSwaps(arr);
        System.out.println(ans);

        //Question-2
        int[] a={3, 6, 4, 8};
        int[] b={4, 6, 8, 3};
        int n=b.length;
        HashMap<Integer,Integer> hm=new HashMap<>();  //to find a[i] in array 'b' in O(1).

        for(int i=0;i<n;i++){
            hm.put(b[i],i);
        }

        int[] nb=new int[b.length];

        for(int i=0;i<n;i++){
            nb[i]=hm.get(a[i]);
        }
        
        int ans2=findminSwaps(nb);
        System.out.println(ans2);
    }
}
