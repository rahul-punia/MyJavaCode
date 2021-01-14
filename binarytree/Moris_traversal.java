import java.util.*;
public class Moris_traversal{
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(){

        }
        public Node(int data,Node left,Node right){
            this.left=left;
            this.right=right;
            this.data=data;
        }
    }
    public static Node makebst(int[] arr,int lo,int hi){
        // if(lo==hi){
        //   Node nn=new Node(arr[lo], null, null);
        //   return nn;
        // }else
         if(lo>hi){
            return null;
        }
        int mid=(lo+hi)/2;  //(lo+hi)>>1 
        Node node=new Node(arr[mid], null, null);
        
        node.left=makebst(arr, lo,mid-1);
        node.right=makebst(arr,mid+1, hi);
        return node;
    }
    // static Node construct(int[] arr){
    //     Node root=null;
    //     Stack<Node> st=new Stack<>();
  
    //     for(int val:arr){
    //         if(val==-1){
    //             st.pop();
    //         }else{
    //             Node node=new Node();
    //             node.data=val;
    //             if(st.isEmpty()){
    //                 root=node;
    //             }else{
    //              if(st.peek().left==null){
    //                  st.peek().left=node;
    //              }else{
    //                  st.peek().right=node;
    //              }
    //             }
    //             st.push(node);
    //         }
    //     }
    //     return root;
    //   }

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
    public static Node FindrightNode(Node node,Node curr){
        while(node.right!=null && node.right!=curr){
            node=node.right;
        }
       return node;
    }

    public static void InOrder(Node node){
        Node current=node;
        while(current!=null){

            if(current.left==null){
               System.out.print(current.data+" ");
               current=current.right;
               continue;
            }

            Node rightmost=FindrightNode(current.left,current);
             if(rightmost.right==null){
                 rightmost.right=current;  //make thread
                current=current.left;
             } else{
                 rightmost.right=null;   //destroy thread
                 System.out.print(current.data+" "); //print  
                 current=current.right;
             } 
        }
    }
    public static void PreOrder(Node node){
        Node current=node;
        while(current!=null){
            if(current.left==null){
               System.out.print(current.data+" ");
               current=current.right;
               continue;
            }

            Node rightmost=FindrightNode(current.left,current);
             if(rightmost.right==null){
                 rightmost.right=current;  //make thread
                 System.out.print(current.data+" "); //print
                 current=current.left;
             } else{
                 rightmost.right=null;
                 current=current.right;
             } 
        }
    }
    
   
 public static void main(String[] args){
      int[] arr={1,2,3,4,5,6,7,8,9,10,11};
      Node root=makebst(arr, 0, arr.length-1);
      display(root);
      InOrder(root);
      System.out.println();
      PreOrder(root);
    }
}