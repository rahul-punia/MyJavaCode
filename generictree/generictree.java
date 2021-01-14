import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
public  class generictree{
   public static class Node{
        int data=0;
        ArrayList<Node>children =new ArrayList<>();
        public Node(int data){
            this.data=data;
        }
    }
    // #include<list> pushfront(x),pushback(x)
    public static Node constructor(int[] arr){
        LinkedList<Node> st=new LinkedList<>();
        Node root=null;  //root=new Node(arr[0]);-donot use this b\z for empty array give error

        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                st.removeFirst();
            }else{
             Node node=new Node(arr[i]);
             if(st.size()==0){                    //root
                 root=node;
             }else{
                 st.getFirst().children.add(node);  //meaning-get Top node of stack and out of data and  Children-arraylist we add nn node address in chidren arrayList.
                 System.out.println();
             }
             st.addFirst(node);                     //doubt
            }
        }
        return root;
    }

    public static void display(Node root){

        System.out.print(root.data+"->");
        for(Node child:root.children){      //foreach loop run only forward
            System.out.print(child.data+" ");
        }
        System.out.println(".");
        for(Node child:root.children){
            display(child);
        }
    }
    public static boolean find(Node root,int data){
     
        if(root.data==data){
            return true;
        }
            for(Node child:root.children){
                boolean res=find(child, data);  //dfs
                if(res==true){
                    return true;
                }
            }
        return false;
    }
    public static int min(Node root){
            int minoverall=root.data;
            for(Node child:root.children){
                int recmin=min(child);  //dfs
                minoverall=Math.min(minoverall, recmin);
            }
            return minoverall;
    }
    public static int max(Node root){
      int maxoverall=root.data;
      for(Node child:root.children){
          int recmax=max(child);   //dfs
        maxoverall=Math.max(maxoverall, recmax);
      }
      return maxoverall;
    }
    //static int ct=1;
    public static int size(Node root){
       int sz=0;
        for(Node child:root.children){
            sz+=size(child);
        }
     return sz+1;
    }
    public static int height(Node root){
        int ht=-1;
        for(Node child:root.children){
        int recans=height(child); //dfs
        ht=Math.max(ht,recans);
        }
       return ht+1;
 
    }
    public static int lowestcommonancestor(int n1,int n2,Node root){

        boolean res1=find(root,n1);
        boolean res2=find(root, n2);
        if(res1==true && res2==true){

        }else{
            return -1;
        }
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
       path1=roottonode(n1, root);
       path2=roottonode(n2, root);
       int i=path1.size()-1;
       int j=path2.size()-1;
        while(i>=0 && j>=0){
        if(path1.get(i).data==path2.get(j).data){
            i--;
            j--;
        }else{
            break;
        }
        }
        // if(i<0){        //No need of this code
        //     return path1.get(0).data;
        // }else  if(j<0){
        //     return path2.get(0).data;
        // }
        return path1.get(i+1).data;//or path2.get(j+1).data
}
     
    public static ArrayList<Node> roottonode(int dataf,Node root){
        if(root.data==dataf){
        ArrayList<Node> base=new ArrayList<>();
        base.add(root);
        return base;
        }
     for(Node child:root.children){
        ArrayList<Node> recans=roottonode(dataf, child);   //faith-give path children to node
        if(recans.size()>0){     
            recans.add(root);
            return recans;
        }
    }
    return new ArrayList<>();//null
}
// public static ArrayList<Integer> levelorder(Node root){
   

//     for(Node child:root.children){
//         ArrayList<Integer> recans=levelorder(child);
//     }
// }

public static void  levelorder(Node root){
   LinkedList<Node> queue=new LinkedList<>();

   queue.addLast(root);
   
    while(!queue.isEmpty()){
        Node rnode=queue.removeFirst(); //remove a node
        System.out.print(rnode.data+" ");
        for(Node child:rnode.children){
        queue.addLast(child);
    }
   }
}

public static void  levelorderlinewise1(Node root){
    LinkedList<Node> queue1=new LinkedList<>();
    LinkedList<Node> queue2=new LinkedList<>();
 
    queue1.addLast(root);
    
     while(!queue1.isEmpty()){
         Node rnode=queue1.removeFirst();
         System.out.print(rnode.data+" ");
         for(Node child:rnode.children){
         queue2.addLast(child);
       }
       if(queue1.size()==0){       //swap
           LinkedList<Node> temp=queue1;
           queue1=queue2;
           queue2=temp;
           System.out.println();
       }
       
    }
 }
 public static void  levelorderlinewise2(Node root){
    LinkedList<Node> queue=new LinkedList<>();
    queue.addLast(root);
    queue.addLast(null);

    while(queue.size()>1){
        Node rnode=queue.removeFirst();
        System.out.print(rnode.data+" ");

        for(Node child:rnode.children){
            queue.addLast(child);
          }
          if(queue.getFirst()==null){       
              System.out.println();
              queue.removeFirst();  //remove null from front & add in last
              queue.addLast(null);
          }
    }

 }
 public static void levelorderlinewise3(Node root){
     LinkedList<Node> queue=new LinkedList<>();
     queue.addLast(root);

     while(queue.size()>0){
         int size=queue.size();
         while(size>0){
             Node rnode=queue.removeFirst();
             System.out.print(rnode.data+" ");
             for(Node child:rnode.children){
                 queue.addLast(child);
             }
             size--;
         }
         System.out.println();
     }
 }

 public static void levelorderlinewisezigzag3(Node root){
    LinkedList<Node> queue=new LinkedList<>();
    queue.addLast(root);
    int flag=0;

    while(queue.size()>0){
        int size=queue.size();
        while(size>0){
            Node rnode=queue.removeFirst();
            System.out.print(rnode.data+" ");
            for(Node child:rnode.children){
                queue.addLast(child);
            }
            size--;
        }
        System.out.println();
    }
}
 
public static void linewisezigzag(Node root){
    LinkedList<Node> queue1=new LinkedList<>();  //parent queue
    LinkedList<Node> queue2=new LinkedList<>();  //childrens queue
    int flag=0;
    queue1.addLast(root);

    while(!queue1.isEmpty()){
    
    Node rnode=queue1.removeFirst();
    System.out.print(rnode.data+" ");
      for(Node child:rnode.children){
        if(flag==0){
            queue2.addLast(child);
        }else if (flag==1){
            queue2.addFirst(child);
          }
      }
      if(queue1.size()==0){
          LinkedList<Node> temp=queue1;
          queue1=queue2;
          queue2=temp;
          System.out.println(".");
          if(flag==0){
          flag=1;}
          else {
          flag=0;
          }
      }
    }
    
  }

  public static void linewisezigzag1(Node root){
    LinkedList<Node> st1=new LinkedList<>();  //parent st
    LinkedList<Node> st2=new LinkedList<>();  //childrens st
    boolean flag=false;
    st1.addFirst(root);

    while(!st1.isEmpty()){
    Node rnode=st1.removeFirst();
    System.out.print(rnode.data+" ");
    if(flag){
      for(Node child:rnode.children){ //forward loop
            st2.addFirst(child);
      }
    }else{
      for(int i=rnode.children.size()-1;i>=0;i--){ //reverse loop
        st2.addFirst(rnode.children.get(i));
             }
      }
      if(st1.size()==0){
          LinkedList<Node> temp=st1;
          st1=st2;
          st2=temp;
          //flag=!flag;   
          flag=flag==true?false:true;
          System.out.println(".");
      }
    }
  }
 
 
  public static class HMpair{
      int max=Integer.MIN_VALUE;
      int min=Integer.MAX_VALUE;
      boolean find=false;
      int pred=-1;
      int succ=-1;
      int prev=-1;
      int floor=Integer.MIN_VALUE;
      int ceil=Integer.MAX_VALUE;
  }
  public static void multisolver(Node root,int data,HMpair pair){
   if(pair.find==false && root.data==data){
       pair.find=true;
       pair.pred=pair.prev;   
   }
   if(pair.find==true && pair.prev==data){
          pair.succ=root.data;
   }
   pair.prev=root.data;

   pair.max=Math.max(pair.max,root.data);
   pair.min=Math.min(pair.min, root.data);
    
   if(root.data>data){
       pair.ceil=Math.min(pair.ceil,root.data);
   }

   if(root.data<data){
    pair.floor=Math.max(pair.floor,root.data);
}
   for(Node child:root.children){
       multisolver(child, data, pair);
   }
  }



  public static void klargest(Node root,int k){    //using class
      int largest=Integer.MAX_VALUE;
      HMpair pair=new HMpair();
      for(int i=0;i<k;i++){
          multisolver(root, largest, pair);
          largest=pair.floor;
          pair.floor=Integer.MIN_VALUE;
      }
      System.out.println(largest);
  }
  public static void kthsmallest(Node root,int k){       //using class
      int smallest=Integer.MIN_VALUE;
    HMpair pair=new HMpair();
      for(int i=0;i<k;i++){
          multisolver(root, smallest, pair);
          smallest=pair.ceil;
          pair.ceil=Integer.MAX_VALUE;   //so same value of ceil donot come again and again
      }
      System.out.println(smallest);
  }

  
    public static void kthlargest(Node root,int k){   //using function
        int ans=0;
        int larg=Integer.MAX_VALUE;
        int kthlargest=Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
         ans= helper(root,kthlargest , larg);
         larg=ans;
         kthlargest=Integer.MIN_VALUE;
        }
        System.out.println(larg);
      
    }
    public static int helper(Node root,int kthlargest,int larg){
        if(root.data<larg){
            kthlargest=Math.max(kthlargest,root.data);
        }

        for(Node child:root.children){
            int rec=helper(child, kthlargest,larg);
            kthlargest=Math.max(kthlargest, rec);
        }
        return kthlargest;
    }

    
    public static void main(String[] args){
        int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=constructor(arr);
        //display(root);
       //multisolver(root, 80,pair);
        
        // System.out.println(find(root, 30));
        // System.out.println(max(root));
        // System.out.println(min(root));
        // System.out.println(size(root));
        // System.out.println(height(root));
        System.out.println(lowestcommonancestor(30, 80, root));
        //levelorderlinewise2(root);
       // levelorderlinewise3(root);
       // levelorder2(root);
        System.out.println();
        //levelorderlinewise1(root);
        linewisezigzag1(root);
        HMpair pair=new HMpair();  //allocate memory in heap
        multisolver(root, 10, pair);
        System.out.println(pair.pred+"  "+pair.succ);
        System.out.println(pair.floor+" "+pair.ceil);
        klargest(root, 3);
        kthsmallest(root, 3);
        kthlargest(root, 3);
   }
 }