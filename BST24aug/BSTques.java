import java.util.*;

public class BSTques{
    static class Node{
        Node left;
        Node right;
        int data;
        Node(Node left,Node right,int data){
            this.left=left;
            this.right=right;
            this.data=data;
     }
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
    public static boolean search(Node root,int data){
        if(root.data==data){
            return true;
        }
        boolean res=false;
        if(data<root.data){
           res=search(root.left, data);
        }else{
            res=search(root.right, data);
        }
        return res;
    }

    public static Node FindLca(Node node,int a,int b){
        if(node==null)return null;
      if(node.data<a){
          return FindLca(node.right, a, b);
      }else if(b<node.data){
          return FindLca(node.left, a, b);
      }else {//node.data>=a  && b>=node.data

        //   return node;   3Logn
        //OR
        //optimize logn
          if(search(node,a) && search(node,b)){
              return node;
          }
      }
      return null;
    }

    //same as LCA
    public static void PrintinRange(Node  node,int a,int b){
        if(node==null)return ;
        if(node.data<a){
            PrintinRange(node.right, a, b);
        }else if(b<node.data){
            PrintinRange(node.left, a, b);
        }else {
         
            System.out.println(node.data);

         PrintinRange(node.right, a, b);
          PrintinRange(node.left, a, b);
            }
      }
    public static Node makebst(int[] arr,int lo,int hi){
         if(lo>hi){
            return null;
        }
        int mid=(lo+hi)/2;  //(lo+hi)>>1 
        Node node=new Node(null, null,arr[mid]);
        
        node.left=makebst(arr, lo,mid-1);
        node.right=makebst(arr,mid+1, hi);
        return node;
    }
    //General Function to find left and right width
     public static int width(Node node,boolean isleftwidth){
       if(node==null) return -1;
        //Agar left ki width nikalna chachta hai or (int left) he call lage rha hai to add 1 kar denge  else -1. 
         //Agar right ki width nikalna chachta hai or (int right) he call lage rha hai to add 1 kar denge  else -1. 
       int left=width(node.left, true)+(isleftwidth?1:-1);//If leftwidth is true It means we want to find left width for that we add 1 else add -1.
       int right=width(node.right, false)+(isleftwidth?-1:1);//If leftwidth is false it means we want to find right width for that we add 1 else add -1.

       return Math.max(left,right);
     }
    public static void VerticalSum(Node node){
        int lw=width(node, true);
        int rw=width(node, false);
        int[] arr=new int[lw+rw+1];
     
        add_data(node, arr, lw);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void add_data(Node node,int[] arr,int idx){
        if(node==null){
            return ;
        }
        arr[idx]+=node.data;
         add_data(node.left, arr, idx-1);
        add_data(node.right, arr, idx+1);
        
    }
    static int maxlen=0;
    public static void LCSS(Node node,int potentialvalue,int currentlength){
      if(node==null) return;

      if(node.data==potentialvalue){
        currentlength++;
        maxlen=Math.max(maxlen,currentlength);
      }else{
        currentlength=1;
      }
      LCSS(node.left, node.data+1,currentlength);
      LCSS(node.right, node.data+1,currentlength);
    }

    public static int LCSSWithoutStatic(Node node,int potentialvalue,int currentlength){
        if(node==null) return -1;
  
        if(node.data==potentialvalue){
          currentlength++;
         }else{
          currentlength=1;
        }
        int max1=LCSS(node.left, node.data+1,currentlength);
        int max2=LCSS(node.right, node.data+1,currentlength);
        return Math.max(currentlength,Math.max(max1, max2));
      }


      public static void MinimumCamera(Node root){

      }
    public static void BstQues(Node root){
        // 3 logn
        // if(search(node,a) && search(node,b)){
        //     Node LcaNode=FindLca(root,40,60);
        // }  
        //oR logn
        // Node LcaNode=FindLca(root,40,60);
        // System.out.println(LcaNode.data);
        // PrintinRange(root, 10,30);
        VerticalSum(root);
        LCSS(root,root.data,0);
        System.out.println(maxlen);
    }
    public static void main(String []args){
        int[] arr={10,20,30,40,50,60,70,80,90};
       Node root= makebst(arr,0,arr.length-1);
        display(root);
        BstQues(root);
    }
}