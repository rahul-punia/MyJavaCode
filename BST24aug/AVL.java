import java.util.*;

public class AVL{

    static class Node{
        int data;
        Node left;
        Node right;
        int ht=1;
        int bal=0;
        public Node(){

 }
 public Node(int data,Node left,Node right){
   this.data=data;
   this.left=left;
   this.right=right;
 }
    }
    public static void display(Node node){
      
        if(node==null){
            return;
        }

        String str="";
        str+=node.left!=null?node.left.data+"->":".->";
        str+=node.data+"_"+node.ht+"_"+node.bal;
        str+=node.right!=null?"-<"+node.right.data:"<-.";
        System.out.println(str);

        display(node.left);
        display(node.right);

    }
    static int getht(Node node){
        int lh=node.left!=null?node.left.ht:0;
        int rh=node.right!=null?node.right.ht:0;
        return Math.max(lh, rh)+1;
    }
    static int getbl(Node node){
        int lh=node.left!=null?node.left.ht:0;
        int rh=node.right!=null?node.right.ht:0;
        return lh- rh;
    }
    static int max(Node node){
        if(node.right==null){
            return node.data;
        }else{
            return max(node.right);
        }
    }
    static Node construct(int[] sa,int lo,int hi){
        if(lo>hi){
            return null;
        }
    
        Node node=new Node();
        int mi=(lo+hi)/2;
        node.data=sa[mi];
        node.left= construct(sa, lo, mi-1);
        node.right=construct(sa, mi+1, hi);
        node.bal=getbl(node);
        node.ht=getht(node);
        return node;
    }
    static Node add(Node node,int data){
        if(node==null){
            return new Node(data, null, null);
        } 

        if(data<node.data){
            node.left=add(node.left, data);
        }else if(data>node.data){
            node.right=add(node.right, data);
        }else{
        
        }
        node.ht=getht(node);
        node.bal=getbl(node);
        if(node.bal>1){
        if(node.left.bal>=0){   
            node=rightRotation(node);//ll
        }else{
            node.left=leftRotation(node.left);   //lr
            node=rightRotation(node);
        }
        }else if(node.bal<-1){
          if(node.right.bal<=0){
              node=leftRotation(node);
          }else{
              node.right=rightRotation(node.right);
              node=leftRotation(node);
          }
        }
        return node;
    }

    public static Node remove(Node node,int data){
        if(node==null){
            return null;
        } 

        if(data<node.data){
            node.left=remove(node.left, data);
        }else if(data>node.data){
            node.right=remove(node.right, data);
        }else{
          if(node.left==null || node.right==null){     
            node=node.left==null?node.right:node.left;   //changes - receive in node                     
          }else{
              int lmax=max(node.left);
              node.data=lmax;
             node.left=remove(node.left,lmax);
          }
        } 
        if(node!=null){               //condition-for one node
            node.ht=getht(node);
        node.bal=getbl(node);
        if(node.bal>1){
        if(node.left.bal>=0){   
            node=rightRotation(node);//ll
        }else{
            node.left=leftRotation(node.left);   //lr
            node=rightRotation(node);
        }
        }else if(node.bal<-1){
          if(node.right.bal<=0){
              node=leftRotation(node);
          }else{
              node.right=rightRotation(node.right);
              node=leftRotation(node);
          }
        }
        }
        return node;  
    }
    static Node leftRotation(Node x){
        Node y=x.right;    //given node x-first find y & t2 using node x then arrange
        Node t2=y.left;
        y.left=x;
        x.right=t2;

        x.ht=getht(x);
        x.bal=getbl(x);
        y.ht=getht(y);
        y.bal=getbl(y);

        return y;
    }

    static Node rightRotation(Node x){
        Node y=x.left;
        Node t3=y.right;
        y.right=x;
        x.left=t3;

        x.ht=getht(x);
        x.bal=getbl(x);
        y.ht=getht(y);
        y.bal=getbl(y);

        return y;  
    }
   

    public static void main(String [] args){
        // int[] sa={12,25,37,50,62,75,87};
        int[] sa={12,25,37,50,62,75,87};
        Node root=construct(sa, 0, sa.length-1);
         add(root, 30);
         add(root, 28);
        add(root, 29);
        remove(root, 12);
        remove(root, 25);
        remove(root, 62);
        remove(root, 37);
        
         display(root);
      
    } 
}