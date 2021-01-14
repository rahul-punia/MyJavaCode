import java.util.*;
public class recursionwitharray{
    public static void main(String [] argc){
        int [] arr={10,20,30,40,50};
        display(arr,0);
        reversedisplay(arr,0);

    }
    public static void display(int [] arr,int idx){

        if(idx==arr.length){
            return;
        }
        System.out.println(arr[idx]);

        display(arr,idx+1);

    }
    public static void reversedisplay(int [] arr,int idx){

        if(idx==arr.length){
            return;
        }

        reversedisplay(arr,idx+1);
        System.out.println(arr[idx]);

       

    }
}