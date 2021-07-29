import java.util.*;
import java.io.*;
import java.lang.*;

public class EasyExtendEucild {
    //https://www.hackerearth.com/practice/math/number-theory/basic-number-theory-1/tutorial/

    //In number theory, two integers a and b are coprime, relatively prime or mutually prime if the only positive integer that evenly divides both of them is 1.
    // coprime  gcd(a,b)=1;
    static int d, x, y;

        public static void extendedEuclid(int A, int B) {
            if(B == 0) {
                d = A;
                x = 1;
                y = 0;
            }
            else {
                extendedEuclid(B, A%B);
                int temp = x;
                x = y;
                y = temp - (A/B)*y;
            }
        }


        public static void main(String[] args) throws Exception{
            d=0;  x=0; y=0;
            extendedEuclid(16, 10);

            System.out.println("The GCD of 16 and 10 is "+d);
            System.out.println("Coefficients x and y are "+x+"  "+y);
        }

}
