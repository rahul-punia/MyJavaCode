import java.util.*;
import java.io.*;

//We can achieve multiple inheritance using interfaces

public class multipleInherit {
    
    public static interface first{

        public void print1();
    }

    public static interface second{

        public void print2();  //Abstract methods do not specify a body
        public void print3();
    }

    public static interface three extends first,second{
        public void print4();
    }

    static class myclass implements three{

        @Override public void print1(){
            System.out.println("I overrided print1");
        }

        @Override public void print2(){
            System.out.println("I overrided print2");
        }
        @Override public void print3(){//error: multipleInherit.myclass is not abstract and does not override abstract method print3() in second
            System.out.println("I overrided print3");
        }

        @Override public void print4(){
            System.out.println("I overrided print4");
        }
    }

    public static void main(String[] args) {
        // Scanner scn=new Scanner(System.in);
        // int n=scn.nextInt();

        myclass obj=new myclass();

        obj.print1();
        obj.print2();
        obj.print4();
        
    }

}
