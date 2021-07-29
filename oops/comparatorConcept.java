import java.util.*;


public class comparatorConcept {
    
    static class student implements Comparable<student>{
        int age,roll;
        String name;

        public student(int age,int roll,String name){
            this.age=age;  this.roll=roll;  this.name=name;
        }

        public String toString(){
            return "\n"+roll+"\t"+age+""+name;
        }

        //Important
        public int compareTo(student other){
            return this.age-other.age;
        }

    }
    // An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. A class implements an interface, thereby inheriting the abstract methods of the interface.
    // Along with abstract methods, an interface may also contain constants, default methods, static methods, and nested types. Method bodies exist only for default methods and static methods.
    // Writing an interface is similar to writing a class. But a class describes the attributes and behaviors of an object. And an interface contains behaviors that a class implements.
    // Unless the class that implements the interface is abstract, all the methods of the interface need to be defined in the class
    static class comp implements Comparator<student>{

        public int compare(student s1,student s2){
            return s1.name.compareTo(s2.name);
        }
    }
    public static void main(String[] args){
        student[] students={new student(17,3,"rahul"),new student(19,1,"akshay"),new student(21,2,"ram")};

        // Arrays.sort(students);

        // System.out.println(Arrays.toString(students));

        Arrays.sort(students,new comp());
        System.out.println(Arrays.toString(students));


    }
}
