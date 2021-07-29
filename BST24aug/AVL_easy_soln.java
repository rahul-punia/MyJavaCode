import java.util.*;

public class AVL_easy_soln{
    static class Node{
        Node left;
        Node right;
        int data;
        int ht=0;
        int bal=0;
        Node(Node left,Node right,int data){
            this.left=left;
            this.right=right;
            this.data=data;
        }
    }

    // LL Rotation
   public static Node LL(Node x){
       Node y=x.left;
       Node ykaRight=y.right;
       y.right=x;
       x.left=ykaRight;

       updateHeight_Balance(x);
       updateHeight_Balance(y);
       return y;
   }

//    RR Rotation
    public static Node RR(Node x){
        Node y=x.right;
        Node ykaleft=y.left;
        y.left=x;
        x.right=ykaleft;

        updateHeight_Balance(x);
        updateHeight_Balance(y);
        return y;
    }

   public static void updateHeight_Balance(Node node){
    int lht=-1;
    int rht=-1;
    if(node.left!=null){
      lht=node.left.ht;
    }
    if(node.right!=null){
      rht=node.right.ht;
    }
    node.bal=lht-rht;
   node.ht=Math.max(lht,rht)+1; 
   }
public static Node getRotate(Node node){
      if(node.bal==2){//ll,lr
          if(node.left.bal==1){//ll
           return LL(node);
          }else{
              node.left=RR(node.left);
              return LL(node);
          }
      }else if(node.bal==-2){//rr,rl
       if(node.right.bal==-1){
           return RR(node);
       }else{
           node.right=LL(node.right);
           return LL(node);
       }
    }
  return node;
}

    public static Node addElement(Node node,int data){
     if(node==null){
         Node nn=new Node(null, null, data);
         return nn;
     }

     if(data<node.data){
        node.left=addElement(node.left, data);
     }else{
         node.right=addElement(node.right, data);
     }

     updateHeight_Balance(node);
     node=getRotate(node);
     return node;
    }


    public static void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+=node.left!=null?node.left.data+"->":".->";
        str+=node.data;
        str+=node.right!=null?"-<"+node.right.data:"<-.";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args){
     Node root=null;
     root=addElement(root,10);
     root=addElement(root,20);
     root=addElement(root,30);
     root=addElement(root,40);
     root=addElement(root,50);
     root=addElement(root,60);
     root=addElement(root,5);
     root=addElement(root,3);
     display(root);
    }
}


    
//     public Node LL(Node x){
//         Node y=x.left;
//         Node ykr=y.right;
//         x.left=ykr;
//         y.right=x;
        
//         upHB(x);
//         upHB(y);
//         return x;
//     }
    
//     public void upHB(TreeNode node){
//         int lht=-1;
//         int rht=-1;
        
//         if(node.left!=null){
//             lht=node.left.ht;
//         }
        
//         if(node.right!=null){
//             rht=node.right.ht;
//         }
        
//         node.bal=lht-rht;
//         node.ht=Math.min(lht,rht)+1;
        
//     }
    
//     public Node getRotate(Node node){
//         if(node.bal==2){//ll ,lr
//             if(node.left.bal==1){
//                 return LL(node);
//             }else{
//                 node.left=RR(node.left);
//                 return LL(node);
//             }
//         }else if(node.bal==-2){
//             if(node.right.bal==-1){
//                 return RR(node);
//             }else{
//                 node.right=LL(node.right);
//                 return RR(node);
//             }
//         }
        
//         return node;
//     }
    
//     public TreeNode addElement(TreeNode root,int val){
//         if(root==null){
//             TreeNode nn=new TreeNode(val,null,null);
//             return root;
//         }
        
//         if(data<root.val){
//             root.left=addElement(root.left,val);
//         }else{
//             root.right=addElement(root.right,val);
//         }
        
//         upHB(root);
//         root=getRotate(root);
//         return root;
//     }