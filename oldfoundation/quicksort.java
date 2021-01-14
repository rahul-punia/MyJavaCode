import java.util.*;
public class quicksort{
    public static class Node{
        char data;
        HashMap<character,Node> children;
        boolean eow;
        Node(char data){
            this.data=data;
            children=new HashMap<>();
            this.eow=false;
        }
    }

    public static void add(Node node,String word){
        if(word.length()==0){
            node.eow=true;
            return;
        }
        char ch=word.charAt(0);
        String row=word.substring(1);
        Node child=node.children.get(ch);
        if(child==null){
           child=new Node(ch);
           node.children.put(ch,child);
           add(node, row);
        }else{
            add(node, row);
        }
    }

    public static boolean search(Node node,String word){
        if(word.length()==0){
            return node.eow;
        }
        char ch=word.charAt(0);
        String row=word.substring(1);
        Node child=node.children.get(ch);
        if(child!=null){
            return search(node, row);
        }else{
            return false;
        }
    }

    public static void remove(Node node, String word){
      if(word.length()==0){
          node.eow=false;
          return;
      }
      
      char ch=word.charAt(0);
      String row=word.substring(1);
      Node child=node.children.get(ch);
      
      if(child==null){
          return;
      }else {
           remove(node, row);
          if(child.eow==false && child.children.size()==0){
          node.children.remove(ch);
      }
    }
    }

    public static void normaldisplay(Node node){
    String str=node.data;
    ArrayList<Character> keys=new ArrayList<>(node.children.keyset());
     for(char key:keys){
         Node child =node.children.get(key);
         str+="->"+child.data+(child.eow==true?"*":"")+",";
     }
     str+=".";
     System.out.println(str);
     for(char key:keys){
         Node child=node.children.get(key);
         normaldisplay(child);
     }
    } 

    public static void displayallword(Node node,String asf){
      if(node.eow==false){
          System.out.println(asf);
      }
      ArraysList<character> keys=new ArrayList<>(node.children.keyset());

      for(char key:keys){
          Node child=node.children.get(key);
          displayallword(child, asf+key);
      }
    }
    public static void quicksort1(int [] arr,int lo,int hi){
       if(lo>=hi){
           return;
       }
        int pi=partition(arr,lo,hi);//pivotindex
        
        quicksort1(arr, lo,pi-1);   //left portion 
        quicksort1(arr, pi+1, hi);  //right portion
       
    }
   public static int partition(int [] arr,int lo,int hi){
        int i=lo;
        int j=lo;
        while(j<=hi){
            if(arr[j]>arr[hi]){
                j++;
            }else{
                int temp=arr[i];    //swap
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j++;
            }
        }
        return i-1;
    }

    public static void main(String [] args){
     Node node=new Node('$');

       int [] arr={5,8,2,9,7,3,6};//{1,5,2,3,8,4,9,0};
       quicksort1(arr, 0, arr.length-1);
       for(int val:arr){
           System.out.print(val+" ");
       }
       System.out.println();
    }
}