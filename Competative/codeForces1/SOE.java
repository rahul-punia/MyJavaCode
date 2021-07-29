import java.util.*;

public class SOE {
   public static void sieveofEr(int n){
       int[] sieve=new int[n+1];
       System.out.print("All Prime numbers from 2 to n=>");
       int ans=0;
       for(int x=2;x<=n;x++){
           if(sieve[x]!=0)continue; //Not prime number
          System.out.print(x+" ");
           for(int u=2*x;u<=n;u=u+x){
               sieve[u]=x;
           }
       }
       System.out.println();
   }
    public static void main(String[] args){
        int n=22;
        sieveofEr(n);
    }
}