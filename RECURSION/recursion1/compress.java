import java.util.*;
public class compress{
      public static void removeduplicate(ArrayList<Integer> list){
          for(int i=1;i<list.size();i++){
              if(list.get(i)==list.get(i-1)){
                  list.remove(i);
                  i--;             
              }
          }
      }
     
      public static void removeduplicatesir(ArrayList<Integer> list){
        for(int i=list.size()-2;i>=0;i--){             // run reverse loop
            if(list.get(i)==list.get(i+1)){
                list.remove(i+1);
            }
        }
    }
    public static void removeduplicatesum(ArrayList<Integer> list){
        int sum=0;
        for(int i=list.size()-2;i>=0;i--){              // run reverse loop
            if(list.get(i)==list.get(i+1)){
                int val=list.remove(i+1);
                sum+=val;
            }else{
                int val=list.get(i+1);
                val+=sum;
                list.set(i+1,val);
                sum=0;
            }
        }
        int val=list.get(0);
                val+=sum;
                list.set(0,val);
                sum=0;
    }
      public static void duplicatesum(ArrayList<Integer> list){
          int sum=0;
          for(int i=list.size()-1;i>=1;i--){
            if(list.get(i)==list.get(i-1)){
                int val=list.remove(i);
                sum+=val;
            }else{
                list.add(i,list.remove(i)+sum);
           sum=0;
            }
          }
          list.add(0,list.remove(0)+sum);
      }
    public static void main(String [] args){
     ArrayList<Integer> list=new ArrayList<>();
     list.addAll(Arrays.asList(5,5,2,2,2,3,3,2,2,2,5,6,6,7,7,7,8,8));
     duplicatesum(list);
    System.out.println(list);
   // removeduplicatesum(list);
    System.out.println(list);
     
      // duplicatesum(list);
      // System.out.println(list);
     
    }
}