import java.util.*;
public class countandradix
{
    static int [] countsort(int [] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int [] fm=new int[max+1];               //frequency map
        for(int i=0;i<arr.length;i++){
            fm[arr[i]]++;
        }

        for(int i=1;i<=max;i++){              //prefix sum array frequency map
            fm[i]+=fm[i-1];
        }
        int [] out=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int idx=fm[arr[i]]-1;
            out[idx]=arr[i];
            fm[arr[i]]--;
            }
        return out;
    }
    static int [] csforradix(int [] arr,int d){
        
        int [] fm=new int[10];
        for(int i=0;i<arr.length;i++){          //step-2 
            fm[arr[i]/d%10]++;
        }

        for(int i=1;i<10;i++){
            fm[i]+=fm[i-1];
        }
        int [] out=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            int idx=fm[arr[i]/d%10]-1;
            out[idx]=arr[i];
            fm[arr[i]/d%10]--;
            
        }
        return out;
    }
    static void radix(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(arr[i], max);
        }
        int div=1;
        while(max/div>0){
            arr=csforradix(arr, div);
            div*=10;
     }
     System.out.println(Arrays.toString(arr));
        for(int val:arr){
        System.out.print(val+" ");
    }
    System.out.println();
    
    }

    
    public static void main(String [] args){
       // int [] arr={4,1,2,7,4,9,1,8,0,2,1,5,0,8};
       // int [] res=countsort(arr);
    //    for(int val:res){
    //     System.out.print(val+" ");
    // }
    // System.out.println();
    
       int [] arr={576,282,77,34,981,62,11,348,7,412,69,438,992,324,287,76};
       radix(arr);
        
    }
}