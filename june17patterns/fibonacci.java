import java.util.*;

public class fibonacci{
    public static void main(String [] args){
        int n=10;
        int a=0;
        int b=1;
        int c=0;
        for(int i=0;i<n;i++){
         System.out.print(a+" ");
            c=a+b;
            a=b;
            b=c;
            

        }
    }
}