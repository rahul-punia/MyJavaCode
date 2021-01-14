import java.util.*;

public class fibpat{
    public static void main(String [] args){
        int n=4;
        int a=0;
        int b=1;
        int c=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(a+" ");
                c=a+b;
                a=b;
                b=c;
                
            }
            System.out.println(); 
        }
    }
}