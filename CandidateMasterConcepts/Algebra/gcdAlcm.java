import java.util.*;

public class gcdAlcm {
    
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args){
        long a=24; long b=36;
        long GCD=gcd(a, b);
        System.out.println("GCD="+GCD);

        long LCM=(a*b)/GCD;
        System.out.println("lcm="+LCM);
    }
}