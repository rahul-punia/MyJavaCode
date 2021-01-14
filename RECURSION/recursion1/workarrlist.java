import java.util.*;
public class workarrlist{
    public static void printrotations(ArrayList<Integer> list,int k){
       for(int i=0;i<k;i++){
        int val=list.get(list.size()-1);
        list.remove(list.size()-1);
        list.add(i,val);
        System.out.println(list);
   
       }
    }
    public static void main(String [] argc){
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        printrotations(list,3);
     }
}
