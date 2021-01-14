import java.util.*;
public class maxarr{
    public static void main(String [] argc){
        int [] arr={10,20,30,40,50};
       
        System.out.println( max(arr,0));
    }
    static int max=0;
    public static int max(int [] arr,int idx){
     if(idx==arr.length-1){
         
         return arr[idx];
     }

      

        int mnm1=max(arr,idx+1);
        if(mnm1<arr[idx]){
            max=arr[idx];
        }else{
            max=mnm1;
        }
        return max;
    }
}