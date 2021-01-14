import java.util.*;

public class ll {
   static class Node{
       int val;
       Node next;

       Node(int val,Node next){
           this.val=val;
           this.next=next;
       }
    }
    public static void display(Node root){
        for(Node i=root;i!=null;i=i.next){
            System.out.print(i.val+"->");
        }
    }
    public static int findsize(Node root){
        int size=0;
        for(Node i=root;i!=null;i=i.next){
        size++;
        }
        return size;
    }
    public static Node addLast(Node root,int data){
       Node nn=new Node(data,null);
       if(root==null){return nn;}
        for(Node i=root;i!=null;i=i.next){
            if(i.next==null){
               i.next=nn;
               break;
            }
        }

        return root;
    }
    
    public static Node addFirst(Node root,int data){
        Node nn=new Node(data,null);
        if(root==null){return nn;}

         nn.next=root;
 
         return nn;
     }

     public static Node addAt(Node root,int data,int at){
        Node nn=new Node(data,null);
        if(root==null){
           if(at==0) return nn;
           else{System.out.println("Invalid Input"); return null;}
        }
        if(at==0){return addFirst(root, data);}
        int idx=0;
        for(Node i=root;i!=null;i=i.next){
            if(idx==at-1){
              nn.next=i.next;
              i.next=nn;
              return root;
            }
            idx++;
        }
        System.out.println("Invalid Idx");
         return root;
     }

    public static Node removeFirst(Node root){
        if(root==null)return null;

        return root.next;
    }

    public static Node removeLast(Node root){
        if(root==null){return root;}

         for(Node i=root;i.next!=null;i=i.next){
             if(i.next.next==null){
                i.next=null;
                break;
             }
         }
         return root;
     }


     public static Node removeAt(Node root,int at){
        if(root==null){
           return null;
        }
        if(at==0){return removeFirst(root);}
        int idx=0;
        for(Node i=root;i.next!=null;i=i.next){
            if(idx==at-1){
              i.next=i.next.next;
              return root;
            }
            idx++;
        }
        System.out.println("Invalid Idx");
         return root;
     }

     public static Node getNodeAt(Node root,int at){ //v.imp
        if(root==null){
           return null;
        }
        if(at==0){return root;}
        int idx=0;
        for(Node i=root;i!=null;i=i.next){
            if(idx==at){
              return i;
            }
            idx++;
        }
        System.out.println("Invalid Idx");
         return root;
     }

     public static Node reverseDatall(Node root){
        int left=0;
        int right=findsize(root)-1;
        System.out.println(left+" "+right);
        while(left<right){
            Node leftn=getNodeAt(root, left);   //
            Node rightn=getNodeAt(root, right);
        System.out.println(leftn.val+" "+rightn.val);

            int temp=leftn.val;
            leftn.val=rightn.val;
            rightn.val=temp;
            left++; right--;
        }
        return root;
     }
     public static Node reversePointerll(Node root){
        if(root==null || root.next==null)return root;

         Node prev=null;
         Node curr=root;
         Node currknext=curr.next;
         while(curr!=null){
         currknext=curr.next;
             curr.next=prev;
             prev=curr;
             curr=currknext;
         }
         return prev;
     }

     public static void displayrr(Node root){
         if(root==null)return;

         displayrr(root.next);
         System.out.print(root.val+"->");
     }

     static Node nroot=null;
     public static void reversePointerRec(Node prev,Node curr){
        if(curr==null)return;

        reversePointerRec(curr,curr.next);
        if(curr.next==null){
            nroot=curr;
        }
           curr.next=prev;
    }
    static int sz=0;  //static
    static Node left=null;
    public static void reverseDataRec(Node right,int rsz){
        if(right==null)return;
         sz++;
        reverseDataRec(right.next,rsz+1);
           if(rsz>=sz/2){
              int temp=right.val;
              right.val=left.val;
              left.val=temp;
              left=left.next;     //imp
           }
    }

    public static boolean Ispalindrome(Node right,int rsz){
        if(right==null){return true;}

         sz++;
         boolean res=Ispalindrome(right.next,rsz+1);
           if(rsz>=sz/2 && res){
            if(right.val!=left.val)return false;

            left=left.next;
           }
        return res;   
    }

    public static void foldLL(Node right,int rsz){
        if(right==null)return;
         sz++;
         foldLL(right.next,rsz+1);
         if(rsz>=sz/2){
                  Node leftkN=left.next; //imp
                  left.next=right;
                  right.next=leftkN;
                  left=leftkN;
                if(rsz==sz/2){
                    right.next=null;
                } 
         }
        //    if(rsz>=Math.ceil((double)sz/2)){
        //        System.out.println(rsz+"=>"+Math.ceil((double)sz/2)+" "+left.val+" "+right.val);
        //       Node leftkN=left.next;
        //       left.next=right;
        //       right.next=leftkN;
        //       left=leftkN;
        //        if(leftkN.next==right.next){ // ll having even no of nodes
        //           leftkN.next=null;
        //       }else if(leftkN.next==right){ // ll having odd no of nodes
        //         leftkN.next=null;
        //       }
        //    }
    }

   public static Node midNode(Node root){
       Node slow=root;
       Node fast=root;

       while(fast.next!=null && fast.next.next!=null){
          slow=slow.next;
          fast=fast.next.next;
       }
       return slow;
   }

   public static Node kthlast(Node root,int k){
    Node slow=root;
    Node fast=root;
    for(int i=0;i<k;i++){
        fast=fast.next;
    }
    while(fast!=null){
       slow=slow.next;
       fast=fast.next;
    }
    return slow;
}

public static Node kreverseLL(Node root,int k){
    if(k==1 || k==0)return root;
     
    int size=findsize(root);
    int left=0;
    int right=k-1;
    int nleft=0;
    
    while(right<size){
        nleft=right+1;
        while(left<right){
           Node leftn=getNodeAt(root,left);
           Node rightn=getNodeAt(root, right);
           System.out.println(leftn.val+"  "+rightn.val);
           int temp=leftn.val;
           leftn.val=rightn.val;
           rightn.val=temp;
           left++; right--;
        }
        left=nleft;
        right=nleft+k-1;
    }
    return root;
}

public static Node kreverseLLon(Node root,int k){
    if(k==1 || k==0)return root;
    
    Stack<Node> st=new Stack<>();
    int size=findsize(root);
    Node nhead=null;
    Node nroot=null;
    while(size>=k){
        for(int i=0;i<k;i++){
          st.push(root);
          root=root.next;
        }
        for(int i=0;i<k;i++){
            if(nroot==null){
                nroot=st.pop();
                nhead=nroot;
            }else{
                nroot.next=st.pop();
                nroot=nroot.next;
            }
            size--;
        }
    }
    nroot.next=null;
    return nhead;
}
    public static void main(String[] args){
         Node root=null;
        // root=addFirst(root, 60);
        // root=addFirst(root, 90);
        root=addLast(root, 10);
        root=addLast(root, 20);
        root=addLast(root, 30);
        root=addLast(root, 40);
        root=addLast(root, 50);
        // root=addLast(root, 60);
        // root=addLast(root, 10);

        // root=addFirst(root, 50);
        // root=addAt(root, 48,4);
        display(root);
        System.out.println();
        // root=removeFirst(root);
        // root=removeLast(root);
        // root=removeAt(root, 7);
        // display(root);
        // System.out.println();
        // root=reversell(root);
        // root=reverseDatall(root);
        // displayrr(root);
        // reversePointerRec(null, root);
        // display(nroot);
        // left=root;sz=0;
        // reverseDataRec(root, 0);
        // display(root);

        //isPalindrome
        // left=root; sz=0;
        // System.out.println(Ispalindrome(root, 0));
        
        left=root; sz=0;
        foldLL(root, 0);
        display(root);
        // System.out.println();
        // Node midnode=midNode(root);
        // System.out.println(midnode.val);
        // Node kthlastN=kthlast(root, 4);
        // System.out.println(kthlastN.val);
        // Node n=getNodeAt(root, 0);
        // System.out.println(n.val);
        
        // kreverseLL(root, 3);
        // root=kreverseLLon(root,3);
        // display(root);
    }
}