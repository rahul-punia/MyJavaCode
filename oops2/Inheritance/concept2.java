import java.util.*;

public class concept2 {
    
// A Java program to demonstrate that both super class
// and subclass constructors refer to same object
//https://www.geeksforgeeks.org/gfact-52-java-object-creation-of-inherited-classes/
  
// super class
static class Fruit
{
    public Fruit()
    {
        System.out.println("Super class constructor");
        System.out.println("Super class object hashcode :" +
                           this.hashCode());
        System.out.println(this.getClass().getName());
    }
}
  
// sub class
static class Apple extends Fruit
{
    public Apple()
    {
        System.out.println("Subclass constructor invoked");
        System.out.println("Sub class object hashcode :" +
                           this.hashCode());
        System.out.println(this.hashCode() + "   " +
                           super.hashCode());
  
        System.out.println(this.getClass().getName() + "  " +
                           super.getClass().getName());
    }
}
  
// driver class

    public static void main(String[] args)
    {
        Apple myApple = new Apple();

//My Expected  O/p1-

// Subclass constructor invoked
// Sub class object hashcode :1297685781
// 1297685781   1297685781
// concept2$Apple  concept2$Apple
// Super class constructor
// Super class object hashcode :1297685781
// concept2$Apple

//My Expected  O/p2-
// Subclass constructor invoked
// Sub class object hashcode :1297685781
// 1297685781   1297685781
// concept2$Apple  concept2$Apple



//But Actual O/P-

// Super class constructor
// Super class object hashcode :1297685781
// concept2$Apple
// Subclass constructor invoked
// Sub class object hashcode :1297685781
// 1297685781   1297685781
// concept2$Apple  concept2$Apple
}

}
