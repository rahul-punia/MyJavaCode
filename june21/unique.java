import java.util.*;

public class unique{
    public static void main(String [] args){
        Scanner scn=new Scanner(System.in);
        int data=scn.nextInt();
        int arr []={10,40,20,90,60,40,68};
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=arr[i+1]){
             System.out.priitln(arr[i]);
             return;
            }else{
                i++;
            }
        }
    }}