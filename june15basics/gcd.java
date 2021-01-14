import java.util.*;

public class gcd{
    public static void main(String [] args){
        int n1=14;
        int n2=21;
        int rem=n2%n1;

         while(rem!=0){
            n2=n1;
             n1=rem;
             
             rem=n2%n1;

         }
         System.out.println(n1);
    }
}