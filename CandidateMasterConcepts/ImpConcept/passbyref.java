
import java.util.*;

//                                Title-  Passbyrefrence in Java
//for more explaination read this link- https://www.educative.io/edpresso/how-to-pass-by-reference-in-java
public class passbyref {
    static class my_number {
        // public member variable
        public long number;
        // default constructor
        public my_number(long number){
          this.number = number;
        }
      }

      public static long gcd(long a,long b,my_number x,my_number y){
        if(b==0){x.number=1; y.number=0; return a;}

          my_number x1=new my_number(0);
          my_number y1=new my_number(0);
         
        long d=gcd(b, a%b,x1,y1);
        x.number=y1.number;
        y.number=x1.number-((y1.number)*(a/b));
        return d;
    }
      public static void main(String[] args) {
          my_number x=new my_number(0);
          my_number y=new my_number(0);
          gcd(55, 80,x,y);

          System.out.println(x.number+" "+y.number);
      }
}

//Notes- How to pass by reference in Java

// One of the biggest confusions in Java is whether it is pass by value or pass by reference.

// Java is always a pass by value; but, there are a few ways to achieve pass by reference:

// Making a public member variable in a class
// Return a value and update it
// Create a single element array

// Ways to create a pass by reference

// 1. Making a public member variable in a class:
// In this method, an object of a class passes in the function and updates the public member variable
// of that object; ​changes are visible in the original memory address.
