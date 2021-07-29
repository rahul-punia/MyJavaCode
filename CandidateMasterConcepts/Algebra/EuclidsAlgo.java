import java.util.*;


public class EuclidsAlgo{

    //gcd using Euclid's Division Algorithm  
    //Euclid's Division Algorithm is a technique to compute the Highest Common Factor (HCF) of two given positive integers. HCF of two positive integers a and b is the largest positive integer d that divides both a and b
	
    //a-ander b-bher
//https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/
    public static long  gcd(long a,long b){
        if(b==0)return a;
        return gcd(b,a%b);
    }


}