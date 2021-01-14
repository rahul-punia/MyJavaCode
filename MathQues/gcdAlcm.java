import java.util.*;

public class gcdAlcm {
    
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args){
        int a=24; int b=36;
        int GCD=gcd(a, b);
        System.out.println("GCD="+GCD);

        int LCM=(a*b)/GCD;
        System.out.println("lcm="+LCM);
    }
}