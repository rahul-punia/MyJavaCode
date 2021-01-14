import java.util.*;

public class Binarytree{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(){
 }
 public Node(int data,Node left,Node right){
   this.data=data;
   this.left=left;
   this.right=right;
 }
    }
    static Node construct(int[] arr){
      Node root=null;
      Stack<Node> st=new Stack<>();

      for(int val:arr){
          if(val==-1){
              st.pop();
          }else{
              Node node=new Node();
              node.data=val;
              if(st.isEmpty()){
                  root=node;
              }else{
               if(st.peek().left==null){
                   st.peek().left=node;
               }else{
                   st.peek().right=node;
               }
              }
              st.push(node);
          }
      }
      return root;
    }
    static int cts=0;
 public static void getsize(Node node){
     if(node==null){
         return ;
     }
     cts++;
     getsize(node.left);//display2(node.left);   //dfs
    getsize(node.right);//display2(node.right); //dfs
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

        display(node.left);             //dfs
        display(node.right);

    }

   
    public static int size(Node node){
        if(node==null){
            return 0;
        }
       int le= size(node.left);
        int ri=size(node.right);    //dfs
        
        return le+ri+1;     
    }
    public static int max(Node node){
        if(node==null){
            return Integer.MIN_VALUE;  //identity
        }
        int lm=max(node.left);
        int rm=max(node.right);         //dfs
        int max=Math.max(node.data,Math.max(lm, rm));
        return max;
    }
    
    
    

    public static int min(Node node){
        if(node==null){
            return Integer.MAX_VALUE;     //identity
        }
        int lm=min(node.left);
        int rm=min(node.right);         //dfs
        int min=Math.min(node.data,Math.min(lm, rm));
        return min;
    }
    public static int height(Node root){
        if(root==null){
            return 0; //or -1
        }

        int lh=height(root.left);
        int rh=height(root.right);          //dfs
        int maxht=Math.max(lh, rh)+1;

        return maxht;
    }
    public static boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data==data){
            return true;
        }
        boolean lf=find(node.left, data);
        if(lf==true){
            return true;
        }
        boolean rf=find(node.right, data);      //dfs
        if(rf==true){
            return true;
        }
       
      return false;
    }
    public static ArrayList<Integer> nodetoroot(Node node,int data){        //dfs
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data==data){
            ArrayList<Integer> list=new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> n2lcp=nodetoroot(node.left, data);//node to left children path
       if(n2lcp.size()>0){
           n2lcp.add(node.data);
           return n2lcp;
       }
       ArrayList<Integer> n2rcp=nodetoroot(node.right, data);//node to right children path
       if(n2rcp.size()>0){
        n2rcp.add(node.data);
        return n2rcp;
       }
       return new ArrayList<>();   //blank vs null
    }
    
    // wrong code for remove leaf
    public static void removeleavesw1(Node node){
     if(node==null){
         return;
     }
     if(node.left==null && node.right==null){
         node=null;
         return;
     }
     removeleavesw1(node.left);
     removeleavesw1(node.right);
    }
    
    //easy to learn
    public static void removeleavesR1(Node node){
        
        if(node.left!=null){
            if(node.left.left==null && node.left.right==null){
                node.left=null;
            }else{
                removeleavesR1(node.left);
            }
        }
        if(node.right!=null){
           if(node.right.left==null && node.right.right==null){
               node.right=null;
           }else{
               removeleavesR1(node.right);
           }
        }
    }
    //Easy to code and understand
    public static Node removeleavesR2(Node node){
        if(node==null){
            return null;
        }else if(node.left==null && node.right==null){
         return null;
        }else{
            node.left=removeleavesR2(node.left);
            node.right=removeleavesR2(node.right);

        }
        return node;
    }
    public static Node removeleavesR3(Node node){
        if(node.left!=null && node.right!=null){
            node.left=removeleavesR3(node.left);
            node.right=removeleavesR3(node.right);
            return node;
        }else if(node.left!=null){
            node.left=removeleavesR3(node.left);
         return node;
        }else if(node.right!=null){
            node.right=removeleavesR3(node.right);
            return node;
        }else{
            return null;
            }

    }
    public static void printinrange(Node node,int lo,int hi,int ssf,String psf){
        if(node==null){                                     //sum so far
            return;
        }
        if(node.left==null && node.right==null){
            ssf+=node.data;
            psf+=" "+node.data;
            if(ssf>=lo && ssf<=hi){
                System.out.println(psf);
            }
            return;
        }

        printinrange(node.left, lo, hi, ssf+node.data, psf+" "+node.data);//dfs
        printinrange(node.right, lo, hi, ssf+node.data, psf+" "+node.data);
    }


    // public static Node transformLD(Node node){
    //     if(node==null)return node;

    //     node.left=transformLD(node.left);
    //     node.right=transformLD(node.right);

    //     Node nn=new Node(node.data, node.left, null);

    //     node.left=nn;
    //     return node;
    // }




    public static Node transformLD(Node node){  //transformLeftduplicated
      
        if(node==null){
            return null;
        }
        node.left=transformLD(node.left);
        node.right=transformLD(node.right);
        node.left=new Node(node.data, node.left,null);
       
        return node;
    }
    public static Node transformfromled(Node node){//transform left duplicated in to original tree
        if(node==null){
            return null;
        }

        node.left=transformfromled(node.left.left); //imp
        node.right=transformfromled(node.right);
        return node;
    }
    public static Node construct2(int[] pre,int psi,int pei,int[] in,int isi,int iei){
      if(isi>iei || psi>pei){
          return null;
      }
      Node node=new Node();
      node.data=pre[psi];
      int x=0;

      for(int i=isi;i<=iei;i++){
          if(in[i]==pre[psi]){
              x=i;
              break;
          }
      }
       int lhs=x-isi;
        node.left=construct2(pre, psi+1, psi+lhs, in, isi, x-1);
        node.right=construct2(pre, psi+lhs+1, pei, in, x+1, iei);
        return node;
    }

   public static Node construct3(int[] post,int psi,int pei,int[] in,int isi,int iei){
    if(isi>iei || psi>pei){
        return null;
    }

    Node node =new Node();
    node.data=post[pei];
    
    int x=0;
    for(int i=isi;i<=iei;i++){
        if(post[pei]==in[i]){
            x=i;
            break;
        }
    }
    int lhs=x-isi;
    node.left=construct3(post, psi, psi+lhs-1, in, isi, x-1);
    node.right=construct3(post, psi+lhs, pei-1, in, x+1, iei);

    return node;
   }
   public static Node construct4(int[] pre,int psi,int pei,int[] post,int ptsi,int ptei){
    if(psi+1<pei){
        return null;
    }
    Node node=new Node();
    node.data=pre[psi];
    int x=0;

    for(int i=ptsi;i<ptei;i++){
        if(pre[psi+1]==post[i]){
            x=i;
            break;
        }
    }
    
    node.left=construct4(pre, psi+1, pei, post, ptsi, x-1);
    node.right=construct4(pre, psi, pei, post, ptsi, ptei);

    return node;
   }
   
   static class Pair{
       Node node;
       int state=0;
       Pair(){

       }
       Pair(Node node,int state){
           this.node=node;
           this.state=state;
       }
   }
   public static void iterativelydftraversal(Node node){
       ArrayList<Integer> pre=new ArrayList<>();
       ArrayList<Integer> in=new ArrayList<>();
       ArrayList<Integer> post=new ArrayList<>();

       Stack<Pair> st=new Stack<>();
       Pair rtp=new Pair(node, 0);

       st.push(rtp);
       while(!st.isEmpty()){
        Pair top=st.peek();
           if(top.node==null){
             st.pop();
             continue;
           }
        
       if(top.state==0){
        pre.add(top.node.data);
        top.state++;
        st.push(new Pair(top.node.left, 0));
       
       }else if(top.state==1){
       in.add(top.node.data);
       top.state++;
       st.push(new Pair(top.node.right, 0));
       }else if(top.state==2){
        post.add(top.node.data);
        st.pop();
       }
       }
       System.out.println("pre ->"+pre);
       System.out.println("in ->"+in);
       System.out.println("post ->"+post);
      
   }


  //*************************** Diameter *********************** */ 
   public static int diameter1(Node node){  //T.C=O(n^2)
       if(node==null){
           return 0;  //for edge return -1;
       }

       int lh=height(node.left);//maximum distance b/w left & deepest left node
       int rh=height(node.right);//maximum distance b/w right & deepest right node
       int f1=lh+rh+1;     //for edge lh+rh+2;      for vertex lh+rh+1;

       //if both farthest node live in left subtree
       int ld=diameter1(node.left);
       //if both farthest node live in right subtree
       int rd=diameter1(node.right);

       return Math.max(f1,Math.max(ld, rd));
   }

   //Method-2  More Efficent
   static class Dipair{
       int ht;   //height
       int dt;  //diameter
   }
   public static Dipair daimeter2(Node node){ //TC=O(n)
    if(node==null){
    Dipair bp=new Dipair();
    bp.ht=0;
    bp.dt=0;
    return bp;
    }
    Dipair lp=daimeter2(node.left);
    Dipair rp=daimeter2(node.right);

    Dipair mp=new Dipair();
    mp.dt=Math.max(lp.ht+rp.ht+1, Math.max(lp.dt, rp.dt));
    mp.ht=Math.max(lp.ht, rp.ht)+1;
    return mp;

   }
   
   static int dia=Integer.MIN_VALUE;
   public static int heightfordia(Node node){
    if(node==null){
        return 0;
    }
    int lh=heightfordia(node.left);
    int rh=heightfordia(node.right);
    
    if((lh+rh+1)>dia){
        dia=lh+rh+1;
    }
    return Math.max(lh, rh)+1;
}

//Balanced Tree 
   static class bpair{
    boolean isbal;
    int ht;
   }
    public static bpair isbalance(Node node){
      if(node==null){
          bpair bp=new bpair();
          bp.ht=0;
          bp.isbal=true;    //identity
         return bp;
      }
      bpair lp=isbalance(node.left);
      bpair rp=isbalance(node.right);

      bpair mp=new bpair();
      if(lp.isbal && rp.isbal && Math.abs(lp.ht-rp.ht)<=1) //imp
      mp.isbal=true;
      else
      mp.isbal=false;
      
      mp.ht=Math.max(lp.ht, rp.ht);
      mp.ht+=1;
      return mp;
    }
    
    static boolean isbal=true;
//Not used anywhere
    // public static int heightforisbal(Node node){
    //     if(node==null){
    //         return 0;
    //     }
    //     int lh=heightforisbal(node.left);
    //     int rh=heightforisbal(node.right);
        
    //     if(Math.abs(lh-rh)>1){
    //         isbal=false;
    //     }
    //     return Math.max(lh, rh)+1;   // important
    // }

    // static class bstpair{
    //     int max;
    //     int min;
    //    
    //     boolean isbs;
    // }
    // public static bstpair isbst(Node node){
    //  if(node==null){
    //      bstpair bp=new bstpair();
    //      bp.min=Integer.MAX_VALUE;
    //      bp.max=Integer.MIN_VALUE;
    //     
    //      bp.isbs=true;
    //      return bp;
    //  }
    //  bstpair lp=isbst(node.left);
    //  bstpair rp=isbst(node.right);
    //  bstpair mp=new bstpair();
    //  mp.min=Math.min(node.data, Math.min(lp.min,rp.min));
    //  mp.max=Math.max(node.data,Math.min(lp.max,rp.max));
    //  mp.isbs=lp.isbs && rp.isbs && node.data>lp.max && node.data<rp.min;
     
    //  return mp;
    // }

    static class bstpair{
        int max;
        int min;
        int size;             //size of largest bst possible
        Node lbstroot;       //root of largest bst possible
        boolean isbs;        //is bst
    }
    //Important
    public static bstpair isbst(Node node){
     if(node==null){
         bstpair bp=new bstpair();
         bp.min=Integer.MAX_VALUE;//
         bp.max=Integer.MIN_VALUE;//
         bp.size=0;          //largest bst size
         bp.isbs=true;       //check bst
         bp.lbstroot=null;  //largest bst root
         return bp;
     }
     bstpair lp=isbst(node.left);
     bstpair rp=isbst(node.right);

     bstpair mp=new bstpair();   //mypair
     mp.min=Math.min(node.data, Math.min(lp.min,rp.min));//
     mp.max=Math.max(node.data,Math.max(lp.max,rp.max));//
     mp.isbs=lp.isbs && rp.isbs && node.data>lp.max && node.data<rp.min;    //imp
    
     if(mp.isbs==true){
         mp.lbstroot=node;
         mp.size=lp.size+rp.size+1;
     }else{
         if(lp.size>rp.size){
             mp.lbstroot=lp.lbstroot;
             mp.size=lp.size;
         }else{
            mp.lbstroot=rp.lbstroot;
             mp.size=rp.size; 
         }
     }
     
     return mp;
    }

    static void printkdown(Node tnode,Node blocker,int k){
        if(tnode==null || tnode==blocker || k<0){
            return;
        }
        if(k==0){
         System.out.print(tnode.data+" ");
         return;
        }

        printkdown(tnode.left,blocker, k-1);
        printkdown(tnode.right,blocker, k-1);

    } 
    public static ArrayList<Node> nodetoroot2(Node node,int data){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data==data){
            ArrayList<Node> list=new ArrayList<>();
            list.add(node);
            return list;
        }
        ArrayList<Node> n2lcp=nodetoroot2(node.left, data);//node to left children path
       if(n2lcp.size()>0){
           n2lcp.add(node);
           return n2lcp;
       }
       ArrayList<Node> n2rcp=nodetoroot2(node.right, data);//node to right children path
       if(n2rcp.size()>0){
        n2rcp.add(node);
        return n2rcp;
       }
       
       return new ArrayList<>();   //blank vs null
    }

    static void printkfar(Node node,int data,int k){
      
        ArrayList<Node> path=nodetoroot2(node, data);
        printkdown(path.get(0), null, k);

        for(int i=1;i<path.size();i++){
            printkdown(path.get(i), path.get(i-1), k-i);
        }

    }
    public static void printsinglechild(Node node){
        // if(node.left==null && node.right!=null && node.right.left==null && node.right.right==null){
        //     System.out.print(node.right.data+" ");
        //     return;
        // }else if((node.left!=null && node.right==null && node.left.left==null && node.left.right==null)){
        //     System.out.print(node.left.data+" ");
        //     return;
        // }
        if(node==null)return ;

        if((node.left==null && node.right!=null) || (node.left!=null && node.right!=null)){
            System.out.print(node.data+" ");
            return;
        }else if(node.left==null && node.right==null){
            return;
        }
        printsinglechild(node.left);
        printsinglechild(node.right);
    }
    public static void main(String[] args){
     int[] arr={50,25,12,-1,37,30,-1,40,-1,-1,-1,75,62,60,-1,70,-1,-1,87,-1,-1,-1};
       int[] pre={50,25,12,37,30,75,62,70,87};
       int[] in={12,25,30,37,50,62,70,75,87};
       //int[] post={12,30,37,25,70,62,87,75,50};
       Node root=construct2(pre,0,pre.length-1,in,0,in.length-1);
       //Node root=construct3(post, 0, post.length-1,in, 0, in.length-1);
    //    display(root);
      // iterativelydftraversal(root);
      // System.out.println(diameter1(root));
      Dipair ap=daimeter2(root);
      System.out.println("Diameter="+ap.dt);
    //   heightfordia(root);
    //   System.out.println(dia);
    //    heightforisbal(root);
    //    System.out.println("isbal -"+isbal);
    //    bpair rp=isbalance(root);
    //    System.out.println(rp.isbal);

    //    bstpair rtp=isbst(root);
    //    System.out.println(rtp.isbs);
    //    System.out.println(rtp.size);
    //    System.out.println(rtp.lbstroot.data);
      // printkfar(root, 25, 1);
      // char[] p1="".toCharArray();
      // int[] a;
      
    
     Node root2=construct(arr);
      // System.out.println(root2.data+"  "+root2.left.data+" "+root2.right.data+" "+root2.left.left.data+" "+root2.right.right.data);
        display(root2);
       // display(root);
        System.out.println(size(root2));
        getsize(root2);
        System.out.println(cts);
        // System.out.println(max(root));
        // System.out.println(min(root));
        // System.out.println(height(root));
        // System.out.println(find(root, 50));
        // System.out.println(nodetoroot(root, 62));
        // printinrange(root, 150, 250, 0, "");
       // pir(root, 0, "", 150, 250);
        // removeleavesR2(root);
        // display(root);
        //root=transformLD(root);
      // display(root);

       // removeleavesw1(root);   //wrong method 
       // display(root);
        //removeleavesR1(root);   //right method 1
        //display(root);
        
        // root=removeleavesR2(root);    //right method 2
        //display(root1);

        // root=removeleavesR3(root);  ////right method 3
       // display(root2);
    }
}