import java.util.*;

public class binaryTree {
    
    static class Node{
        int val=0;
        Node left;
        Node right;
        Node(int val,Node left,Node right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }

    public static Node Constructor(int[] arr){
       Node root=null;
       Stack<Node> st=new Stack<>();

       for(int i=0;i<arr.length;i++){
           if((arr[i]==-1)){
             st.pop();
           }else{
               if(arr[i]==-2){
                 //Either no left or no right child
               }else{
               Node nn=new Node(arr[i], null, null);
               if(root==null){
                   root=nn;
               }else{
                   Node pn=st.peek();
                   if(pn.left==null){
                     pn.left=nn;
                   }else if(pn.right==null){
                       pn.right=nn;
                   }
                }
                st.push(nn);
               }
           }
       }
       return root;
    }
   
    public static void display(Node root){
        if(root==null)return;

        if(root.left!=null){System.out.print(root.left.val+"->");}
        System.out.print("--"+root.val+"--");
        if(root.right!=null){System.out.print("<-"+root.right.val);}
        
        System.out.println();

        if(root.left!=null)display(root.left);
        if(root.right!=null)display(root.right);
   }


  public static Node RemoveLeaves(Node root){
      if(root.left==null && root.right==null){
          return null;
      }


      if(root.left!=null){
          root.left=RemoveLeaves(root.left);
      }
      if(root.right!=null){
          root.right=RemoveLeaves(root.right);
      }
      return root;
  }

  public static void singleChild(Node root){
    if(root.left==null && root.right==null){
        return ;
    }
     
    
    
    if(root.left!=null){
        if(root.right==null){System.out.println(root.left.val+"  ");}//single child
       singleChild(root.left);
    }
    if(root.right!=null){
        if(root.left==null){System.out.println(root.right.val+"  ");}//single child
        singleChild(root.right);
    }
 }

 public static void oneChildNode(Node root){
    if(root.left==null && root.right==null){
        return ;
    }
     
    
    
    if(root.left!=null){
        if(root.right==null){System.out.println(root.val+"  ");}//single child parent
        oneChildNode(root.left);
    }
    if(root.right!=null){
        if(root.left==null){System.out.println(root.val+"  ");}//single child parent
        oneChildNode(root.right);
    }
 }

 public static Node leftduplicated(Node root){
     if(root==null)return root;

     if(root.left!=null){
        root.left=leftduplicated(root.left);  //give leftduplicated subtree of left side
    }
    if(root.right!=null){
        root.right=leftduplicated(root.right);  //give leftduplicated subtree of right side
        }

      Node nn=new Node(root.val,root.left,null); //v.imp meet faith and expectation 
      root.left=nn;
    
    return root;
 }

 public static Node leftduplicatedTransformBack(Node root){
    if(root==null)return root;

    if(root.left!=null){
        root.left=root.left.left;    //v.v.imp
      }
    //   else if(root.right!=null){
    //     root.right=root.right.left;
    //   }  

    if(root.left!=null){
       root.left=leftduplicatedTransformBack(root.left);  //give leftduplicated subtree of left side
    }
   if(root.right!=null){
       root.right=leftduplicatedTransformBack(root.right);  //give leftduplicated subtree of right side
    
    }
  //not transform done here     
   return root;
}
    public static void main(String[] args){
        int[] arr={50,25,12,-1,37,30,-1,40,-1,-1,-1,75,62,60,-1,70,-1,-1,87,-1,-1,-1};//all nodes have 2 or 0 child
        // int[] arr={50,25,12,-1,37,30,-1,40,-1,-1,-1,75,62,60,-1,-1,-1,-1};//for single child

        Node root=Constructor(arr);
        display(root);
        // root=RemoveLeaves(root);
        System.out.println("****************");
        display(root);
        singleChild(root);;
        oneChildNode(root);
        System.out.println("****************");
        leftduplicated(root);
        // display(root);
        System.out.println("****************");
        leftduplicatedTransformBack(root);
        display(root);
    }
}