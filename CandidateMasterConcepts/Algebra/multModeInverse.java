import java.util.*;
import java.io.*;
import java.lang.*;

//https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/

// Given two integers ‘a’ and ‘m’, find modular multiplicative inverse of ‘a’ under modulo ‘m’.
// The modular multiplicative inverse is an integer ‘x’ such that. 

// a x ≅ 1 (mod m)
// The value of x should be in { 1, 2, … m-1}, i.e., in the range of integer modulo m. 
//( Note that x cannot be 0 as a*0 mod m will never be 1 )
// The multiplicative inverse of “a modulo m” exists if and only if a and m are relatively prime
// (i.e., if gcd(a, m) = 1).

//Method 1 (Naive) 
//A Naive method is to try all numbers from 1 to m. For every number x, check if (a*x)%m is 1. 
// Time Complexity: O(m)

// Method 2 (Works when m and a are coprime)   Time Complexity: O(Log m)
// The idea is to use Extended Euclidean algorithms that takes two integers ‘a’ and ‘b’,
// finds their gcd and also find ‘x’ and ‘y’ such that 

// ax + by = gcd(a, b)
// To find multiplicative inverse of ‘a’ under ‘m’, we put b = m in above formula. Since we know that a and m are relatively prime, we can put value of gcd as 1.

// ax + my = 1
// If we take modulo m on both sides, we get

// ax + my ≅ 1 (mod m)
// We can remove the second term on left side as ‘my (mod m)’ would always be 0 for an integer y. 

// ax  ≅ 1 (mod m)
// So the ‘x’ that we can find using Extended Euclid Algorithm is the multiplicative inverse of ‘a’

// Method 3 (Works when m is prime)   Time Complexity: O(Log m)
// If we know m is prime, then we can also use Fermats’s little theorem to find the inverse. 

// am-1 ≅ 1 (mod m)
// If we multiply both sides with a-1, we get 

// a-1 ≅ a m-2 (mod m)



public class multModeInverse {
    //T.C- O(logm)
    
    static long modInverse1(long a, long m){
        // int g = gcd(a, m);
        // if(g!=1) {System.out.println("Inverse Doesnot Exist");}  
        return binexp(a, m - 2, m);
       }
   
      static long binexp(long a, long b, long m){
        if (b == 0)return 1; 
            
        long res = binexp(a, b / 2, m);
        if (b % 2 == 1) return (( (res*res)%m )*a) % m;
        else return (res*res)%m;
    }

//******************************************************************************************************************** */
public static void main(String[] args) throws Exception{
      long a=3,m=11;  //m-prime mode
      System.out.println(modInverse1(a,m));

      System.out.println(modInverse2(a,m));
 }
//******************************************************************************************************************** */

    //T.C- O(m)
    static long modInverse2(long a, long m){
        long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }

}
