import java.util.*;

public class SieveofEro {
    
    public static void SOE(int n){
        int[] sieve=new int[n+1];

        System.out.println("All prime number from 1 to n:-");
        
        for(int x=2;x<=n;x++){
            if(sieve[x]!=0){  //Not prime number
                continue;
            }
            System.out.print(x+"  ");
            for(int u=2*x;u<=n;u+=x){
                sieve[u]=x;
            }
        }
    }
  public static void main(String[] args){
       int n=20;
       SOE(n);
    }
}