import java.util.*;

public class binarysearch{
    public static void main(String [] args){
        System.out.println(" Enter the data to find  ");
        Scanner scn=new Scanner(System.in);
        int data=scn.nextInt();
        int arr []={10,10,10,20,20,20,30,30,40,40,50,50};
        Arrays.sort(arr);
        int le=0;
        int ri=arr.length-1;
        int result=-1;
       
        while(le<=ri){
            int mid=(le+ri)/2;
            if(data<arr[mid]){
                ri=mid-1;
            }else if(data>arr[mid]){
                le=mid+1;
            }else{
                result=mid;
                ri=mid-1;              //for first index
              //  le=mid+1;          //for last index
              //  System.out.println("data found at "+mid);
               // return;
            }


        }

       // System.out.println("data not found");
       if(result==-1){
        System.out.println("data not found");
       }else{
        System.out.println("data first found at "+result);
       
       // System.out.println("data last found at "+result);
       }

    }
}