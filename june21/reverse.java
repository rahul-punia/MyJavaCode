import java.util.*;

public class reverse{
    public static void main(String [] args){
       // Scanner scn=new Scanner(System.in);
      //  int data=scn.nextInt();
        int arr []={10,20,30,40,50,60};
        Arrays.sort(arr);
        rev(arr);
        display(arr);
       
       
    }
    public static void display(int [] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
         }
    }
    public static void rev(int [] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            swap(arr, left, right); 
            left++;
            right--;
        }
    }
    public static void swap(int [] arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
 
    }

}