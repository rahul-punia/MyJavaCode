import java.util.*;

public class makeBst{
    static class Node{
        Node left;
        Node right; 
        int data;
        int ht=0;
        int bal=0;
        public Node(int data,Node left,Node right){
            this.left=left;
            this.right=right;
            this.data=data;
        }
    }

    public static Node makebst(int[] arr,int lo,int hi){  //sorted array
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
//    public static void display(Node root){
//     if(root==null){
//         return;
//     }
//     System.out.println(root.data); 
//     if(root.left!=null)  
//     display(root.left);
//     if(root.right!=null)
//     display(root.right);

//    }

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




//Remove Data
public static int getmax(Node root){
    if(root.right==null){
        return root.data;
    }else{
       return getmax(root.right);
    }
}

public static int getmin(Node root){
    if(root.left==null){
        return root.data;
    }else{
       return getmin(root.left);
    }
}

public static Node removeData(Node root,int data){
    if(root.data==data){
        //My code
    //   if(root.left==null && root.right==null){
    //     return null;
    //   }else if(root.left!=null && root.right==null){
    //   int max=getmax(root.left);
    //   root.data=max;
    //   removeData(root.left, max);
    //   }else if(root.left==null && root.right!=null){
    //    int min=getmin(root.right);
    //    root.data=min;
    //    removeData(root.right, min);
    //   }else{
    //   int max=getmax(root.left);
    //   root.data=max;
    //   removeData(root.left, max);
    //   }
    //   return root;
    // }
    //OR short code
    if(root.left==null || root.right==null){
        return root.left==null?root.right:root.left;
    } else{
      int max=getmax(root.left);
      root.data=max;
      removeData(root.left, max);
      }
      return root;
    }

    if(data<root.data){
       root.left= removeData(root.left, data);
    }else{
       root.right =removeData(root.right, data);
    }
    return root;
}

//AVL TREE is a self-balancing BT like read-black tree=> Easy Code Implementation
//LL Rotation
public static Node ll(Node x){
    Node y=x.left;
    Node ykaRight=y.right;
    y.right=x;
    x.left=ykaRight;

    updateHeight_balance(x);
    updateHeight_balance(y);

    return y;
}

//RR Rotation
public static Node rr(Node x){
    Node y=x.right;
    Node ykaleft=y.left;
    y.left=x;
    x.right=ykaleft;

    updateHeight_balance(x);
    updateHeight_balance(y);

    return y;
}
public static void updateHeight_balance(Node node){//imp
    int lht=-1;
    int rht=-1;
    if(node.left!=null)lht=node.left.ht;
    if(node.right!=null)rht=node.right.ht;
    node.bal=lht-rht;
    node.ht= Math.max(lht,rht)+1;
    // System.out.println(node.ht+"    "+node.bal);
    
}
public static Node getRotate(Node node){
    if(node==null) return null;
    if(node.bal==2 && node.left!=null){//ll,lr
      if(node.left.bal==1){//ll
          return ll(node);
      }else{//lr
          node.left=rr(node.left);
          return ll(node);
      }
    }else if(node.bal==-2 && node.right!=null){//rr,rl
        if(node.right.bal==-1){//rr
            return rr(node);
        }else{ //rl
            node.right=ll(node.right);
            return rr(node);
        } 
    }

    // updateHeight_balance(node);
   
    return node;
}


public static Node addData(Node root ,int data){
    if(root==null){
        Node nn=new Node(data, null, null);
        return nn;
    }
    if(data<root.data){
    root.left=addData(root.left,data);
    }
    else{
        root.right=addData(root.right,data);
    }
    updateHeight_balance(root);
    root=getRotate(root);
    return root;
}
    public static void main(String[] args){
//    int[] arr={10,20,30,40,50,60,70,80,90};
     Node root=null; 
    //  root=makebst(arr,0, arr.length-1);
    //  display(root);
     root=addData(root, 10);
     root=addData(root, 20);
     root=addData(root, 30);
     root=addData(root, 40);
     root=addData(root, 50);
     root=addData(root, 60);
     root=addData(root, 70);
     root=addData(root, 80);
     display(root);
    //  removeData(root, 30);
     System.out.println("--------------------");
    //  display(root);
    }
}