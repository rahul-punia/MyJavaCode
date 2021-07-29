import java.util.*;

class Base {
    public void foo() { System.out.println("Base"); }
}
 
class Derived extends Base {
 
    // compiler error  Cannot reduce the visibility of the inherited method from Base
    private void foo() { System.out.println("Derived"); }
}


public class concept3 {
    public static void main(String args[])
    {
        Derived d = new Derived();
        d.foo();
    }
}
