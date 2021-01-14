import java.util.*;

public class practisebt{
 static class Node{
     int data;
     Node left;
     Node right;
    public Node(){

    }
     public Node(int data,Node left ,Node right){
         this.left=left;
         this.data=data;
         this.right=right;
     }
 }

  static Node constructor(int []arr){
     Stack<Node> st=new Stack<>();
     Node root=null;

     for(int val:arr){
         if(val==-1){
             st.pop();
         }else{
             Node nn=new Node();
             nn.data=val;
             if(st.isEmpty()){
              root=nn;
             }else{
                 if(st.peek().left==null){
                  st.peek().left=nn;
                 }else{
                     st.peek().right=nn;
                 }
             }
              st.push(nn);
         }
     }
    return root;
 }
  public static void display2(Node node){
    if(node==null){
        return;
    }
    System.out.println((node.left==null?".":node.left.data)+"-->"+node.data+"<--"+(node.right==null?".":node.right.data));
    display2(node.left);
    display2(node.right);
 }
 static int cts=0;
 public static void getsize(Node node){
     if(node==null){
         return ;
     }
     cts++;
     getsize(node.left);
    getsize(node.right);
 }
static int max=Integer.MIN_VALUE;
 public static void getmax(Node node){
     if(node==null){
         return ;
     }
    max=Math.max(max,node.data); 
    getmax(node.left);
    getmax(node.right);
 }

 static int min=Integer.MAX_VALUE;
 public static void getmin(Node node){
     if(node==null){
         return ;
     }
    min=Math.min(min,node.data); 
    getmin(node.left);
    getmin(node.right);
 }

    public static void display(Node node){
        if(node==null){
            return;
        }
        String str="";
        str=node.left!=null?node.left.data+"->":".->";
        str+=node.data;
        str+=node.right!=null?"<-"+node.right.data:"<- .";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static int getheight(Node node){
        if(node==null){
            return 0;
        }
        int lh=getheight(node.left);
        int rh=getheight(node.right);
        return Math.max(lh,rh)+1;

    }
    public static boolean getdata(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        
        if(getdata(node.left, data)){
            return true;
        }
        if(getdata(node.right, data)){
            return true;
        }
    
    return false;
    }
    public static int size(Node node){
        if(node==null){
            return 0;
        }

        int ls=size(node.left);
        int rs=size(node.right);
        return ls+rs+1;
    }

    public static int height(Node node){
        if(node==null){
            return 0;
        }

        int lh=height(node.left);
        int rh=height(node.right);
        return Math.max(lh, rh)+1;
    }
    public static int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;  //base case
        }

        int lm=max(node.left);
        int rm=max(node.right);
        return Math.max(Math.max(lm, rm),node.data);
    }

    public static void getnodetoroot(Node node,int data,String list){
        if(node==null){
            return;
        }else if(node.data==data){
            System.out.println(list+node.data);
            return;
        }
        getnodetoroot(node.left, data, list+node.data+" ");
        getnodetoroot(node.right, data,list+node.data+" ");
    }
    public static int min(Node node){
        if(node==null){
            return Integer.MAX_VALUE;
        }

        int lm=min(node.left);
        int rm=min(node.right);
        return Math.min(Math.min(lm, rm),node.data);
    }
    public static boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        if(find(node.left, data)){
            return true;
        }
        if(find(node.right, data)){
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> nodetoroot(Node node,int data){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data==data){
            ArrayList<Integer> ba=new ArrayList<>();
            ba.add(node.data);
            return ba;
        }
        ArrayList<Integer> lc2np=nodetoroot(node.left, data);
        if(lc2np.size()>0){
            lc2np.add(node.data);
            return lc2np;
        }

         ArrayList<Integer> rc2np=nodetoroot(node.right, data);
        if(rc2np.size()>0){
            rc2np.add(node.data);
            return rc2np;
        }
        return new ArrayList<>();
    }
     
    public static Node removeleaf2(Node node){
        if(node==null){
            return null;
        }
        if(node.left==null && node.right==null){
            //node=null;
            return null;
        }
        
       node.left= removeleaf2(node.left);
        node.right=removeleaf2(node.right);
        return node;
    }

    public static void printrange(Node node,String str,int sum){
        if(node.left==null && node.right==null){
            sum+=node.data; 
            if(sum>=150 && sum<=250){
                System.out.println(str+node.data);
            }
            sum-=node.data;
            return;
        }
        printrange(node.left, str+node.data+" ", sum+node.data);
         printrange(node.right, str+node.data+" ", sum+node.data);
    }

    public static ArrayList<Integer> nodetorootpath(Node node,int data){
        if(node==null){
            return new ArrayList<>();
        }
     if(node.data==data){
         ArrayList<Integer> ba=new ArrayList<>();
         ba.add(node.data);
         return ba;
     }
 
     ArrayList<Integer> lc2np=nodetorootpath(node.left, data);
     if(lc2np.size()>0){
         lc2np.add(node.data);
         return lc2np;
     }

     ArrayList<Integer> rc2np=nodetorootpath(node.right, data);
     if(rc2np.size()>0){
         rc2np.add(node.data);
         return rc2np;
     }
    return new ArrayList<>();
    }

    public static Node removeleaf(Node node){
    if(node.left==null &&node.right==null){
        return null;
    }
    node.left=removeleaf(node.left);
    node.right=removeleaf(node.right);
    return node;
    }

    public static Node leftduplicated(Node node){
        if(node==null){
            return null;
        }
        node.left=leftduplicated(node.left);
        node.right=leftduplicated(node.right);
        node.left=new Node(node.data, node.left,null);
        return node;
    }
        
    public static void printsingle(Node node){
        if(node.left==null && node.right!=null && node.right.left==null && node.right.right==null){
            System.out.print(node.right.data+" ");
            return;
        }else if((node.left!=null && node.right==null && node.left.left==null && node.left.right==null)){
            System.out.print(node.left.data+" ");
            return;
        }else if(node.left==null && node.right==null){
            return;
        }
        printsingle(node.left);
        printsingle(node.right);
    } 
    public static void main(String[] args){
    int[] arr={50,25,12,-1,37,30,-1,40,-1,-1,-1,75,62,60,-1,70,-1,-1,87,-1,-1,-1};
    Node root =constructor(arr);
//    display2(root);
    getsize(root);
    System.out.println(cts);
    getmax(root);
    System.out.println(max);
    getmin(root);
    System.out.println(min);
    System.out.println(getheight(root));
    System.out.println(getdata(root, 30));
   getnodetoroot(root,60, "");
   System.out.println(nodetoroot(root,60));
  // removeleaf2(root);
  // display2(root);
   printrange(root, "", 0);
    root=leftduplicated(root);
    display2(root);
//     System.out.println(size(root));
//     System.out.println(height(root));
//     System.out.println(max(root));
//     System.out.println(min(root));
//     System.out.println(find(root, 400));
//     System.out.println(nodetorootpath(root, 30));
//    root=removeleaf(root);
//     display(root);
//     printsingle(root);

    }
}