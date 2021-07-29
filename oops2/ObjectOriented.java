import java.util.*;
import java.io.*;
import java.lang.*;


class D{
    int a=40;

    public void print4(){
        System.out.println(a);
    }    
}


public class ObjectOriented {
    
    
    public class A{
        int x=10;

        public void print1(){
            System.out.println(x);
        }
    }

    public class B extends A{  //Single level Inheritance 
        int y=20;

        public void print2(){
            System.out.println(y);
        }
    }

    public class C extends B{  //Multi level Inheritance
        int z=30;

        public void print3(){
            System.out.println(z);
        }
    }

    public void print(int a,int b){
        System.out.println(a+"  "+b);

        A obj1;
        obj1=new A();
        obj1.print1();

        B obj2=new B();
        obj2.print1();  obj2.print2();

        C obj3=new C();
        obj3.print3();  obj3.print1();
    }

    public static void main(String[] args) {
        ObjectOriented obj=new ObjectOriented();
        obj.print(2, 10);

        D obj4=new D();
        obj4.print4();


        Complex c1 = new Complex(10, 15);
        Complex c2 = new Complex(10, 15);
        if (c1.equals(c2)) {
            System.out.println("Equal ");
        }else {
            System.out.println("Not Equal ");
        }


       }


       
    //Concept-  Overriding equals method in Java
    class Complex {
        private double re, im;   //Data Encapsulation or Data hiding making all data members private and methods private.
      
        public Complex(double re, double im) {
            this.re = re;
            this.im = im;
        }
      
        // Overriding equals() to compare two Complex objects
        @Override
        public boolean equals(Object o) { //Here Object is a super class of all data type classes
      
            // If the object is compared with itself then return true  
            if (o == this) return true;
      
            /* Check if o is an instance of Complex or not
              "null instanceof [type]" also returns false */
            if (!(o instanceof Complex)) return false;
              
            // typecast o to Complex so that we can compare data members 
            Complex c = (Complex) o;
              
            // Compare the data members and return accordingly 
            return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
        }
    }

    class complex2{
        private int a,b;

        public complex2(int a,int b){
            this.a=a; this.b=b;
        }


        @Override  public boolean equals(Object o){
             if(o==this)return true;

             if(!(o instanceof complex2))return false;

             complex2 c=(complex2)(o);

             return Integer.compare(a, c.a)==0 && Integer.compare(b, c.b)==0;
        }
    }

}
