import java.util.*;
public class  GenericTraverse{
    static class Tpair{
        Tpair left;
        Tpair right;
        int data;
        Tpair node;
        boolean selffdone=false;
        boolean leftdone=false;
        boolean rightdone=false;
        public Tpair(Tpair node){
          this.node=node;
        }
        public Tpair(int data,Tpair left,Tpair right){
            this.left=left;
            this.right=right;
            this.data=data;
        }
    }
    public static void genericTraversal(Tpair node){
        Stack<Tpair> st=new Stack<>();
        st.push(new Tpair(node));
        while(st.size()>0){
         Tpair gnode=st.peek();
         if(!gnode.selffdone){
             System.out.println(gnode.node.data);
            gnode.selffdone=true;
         }else if(!gnode.leftdone){
              gnode.leftdone=true;
              if(gnode.node.left!=null){
              st.push(gnode.node.left);
              }
         }else if(!gnode.rightdone){
            gnode.rightdone=true;
            if(gnode.node.right!=null){
            st.push(gnode.node.right);
            }
         }else{
           st.pop();
         }
        }
        

}

public static Tpair makebst(int[] arr,int lo,int hi){
    // if(lo==hi){
    //   Node nn=new Node(arr[lo], null, null);
    //   return nn;
    // }else
     if(lo>hi){
        return null;
    }
    int mid=(lo+hi)/2;  //(lo+hi)>>1 
    Tpair node=new Tpair(arr[mid], null, null);
    
    node.left=makebst(arr, lo,mid-1);
    node.right=makebst(arr,mid+1, hi);
    return node;
}
public static void main(String[] args){
    int[] arr={1,2,3,4,5,6,7,8,9,10,11};
    Tpair root=makebst(arr, 0, arr.length-1);
    // display(root);
  genericTraversal(root);
}
}