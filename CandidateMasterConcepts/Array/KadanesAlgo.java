import java.util.*;

public class KadanesAlgo {
    public static void kadanesAll(int[] arr){
        int ci=-1,bi=-1,cj=-1,bj=-1,cs=0,bs=0; //take 6 variable

        for(int i=0;i<arr.length;i++){
            if(cs+arr[i]>arr[i]){
                cs=cs+arr[i];  cj=i;
                if(cs>bs){
                    bs=cs; bi=ci; bj=cj;
                }
            }else{
                cs=arr[i];
                ci=i; cj=i;
            }
        }

        System.out.println("Maximum subarray sum="+bs);
        System.out.println("i="+bi+"  j="+bj);
    }

    public static void kadaneMaxSum(int[] arr){

        int cs=0,bs=0;
        for(int val:arr){
            cs=Math.max(val,cs+val);
            bs=Math.max(bs,cs);
        }
        System.out.println("Max Sum="+bs);
    }
    public static void main(String[] args) {
        int[] arr={-1,2,4,-3,5,2,-5,2};
        kadanesAll(arr);
        kadaneMaxSum(arr);
    }
}