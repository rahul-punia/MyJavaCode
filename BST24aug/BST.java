import java.util.*;

public class BST{
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
    static Node construct(int[] sa,int lo,int hi){
        if(lo>hi){
            return null;
        }
    
        Node node=new Node();
        int mi=(lo+hi)/2;
        node.data=sa[mi];
        node.left= construct(sa, lo, mi-1);
        node.right=construct(sa, mi+1, hi);
        return node;
    }
    static int min(Node node){
        if(node.right==null && node.left==null){
            return node.data;
        }else{
            return min(node.left);
        }
    }
    static int max(Node node){  //doubt if bst is height=n;
        if(node.left==null && node.right==null){
            return node.data;
        }else{
            return max(node.right);
        }
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
      //
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
        }else{ //node.data=data
          if(node.left==null && node.right==null){     //if(node.left==null || node.right==null){
              return null;                             //return node.left==null?node.right:node.left;
          }else if(node.left==null){                   //}
              return node.right;
          }else if(node.right==null){
              return node.left;
          }else{
              int lmax=max(node.left);
              node.data=lmax;             //to preserve bst property
             node.left=remove(node.left,lmax);
          }
        }
        return node;  
    }
    static int sum=0;
    public static void sumofgreater(Node node){
      if(node==null){
          return;
      }
        sumofgreater(node.right);
         int temp=node.data;
         node.data=sum;
         sum+=temp;
        sumofgreater(node.left);


    }
    public static boolean find(Node root,int data){
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }

        boolean lr=find(root.left, data);
        if(lr){
            return true;
        }
        boolean rr=find(root.right, data);
        if(rr){
            return true;
        }
        return false;
    }

    public static void targetsumpair(Node node,int targ,Node root){
      if(node==null){
          return;
      }
      int complement=targ-node.data;
      if(complement>node.data && find(root,complement)){
          System.out.println(node.data+"   "+(complement));
      }

        targetsumpair(node.left, targ,root);
        targetsumpair(node.right, targ,root);
    }
    public static void targetsumpair2(Node node,int targ,ArrayList<Integer> strg){
        if(node==null){
            return ;
        }
        targetsumpair2(node.left, targ, strg);
        strg.add(node.data);
        targetsumpair2(node.right, targ, strg);
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


    public static void targetsumpair3(Node node,int targ){
            Stack<Pair> lst=new Stack<>();
            Pair rtp=new Pair(node, 0);
            lst.push(rtp);

            Stack<Pair> rst=new Stack<>();
                Pair rtp2=new Pair(node, 0);
                rst.push(rtp2);

                int lv=0;
                int rv=0;
                boolean lm=true;
                boolean rm=true;
    while(true){
            while(  lm==true && !lst.isEmpty()){
             Pair top=lst.peek();
                if(top.node==null){
                  lst.pop();
                  continue;
                }
             
            if(top.state==0){
             top.state++;
             lst.push(new Pair(top.node.left, 0));
            
            }else if(top.state==1){
            top.state++;
            lst.push(new Pair(top.node.right, 0));
            lv=top.node.data;
            break;
            }else if(top.state==2){
             lst.pop();
            }
            }
          
                
             while(rm==true && !rst.isEmpty()){
                 Pair top=rst.peek();
                    if(top.node==null){
                      rst.pop();
                      continue;
                    }
                 
                if(top.state==0){
                 top.state++;
                 rst.push(new Pair(top.node.left, 0));
                
                }else if(top.state==1){
                top.state++;
                rst.push(new Pair(top.node.right, 0));
                rv=top.node.data;
                }else if(top.state==2){
                 rst.pop();
                }}
                
                if(lv>=rv){
                    break;
                }else if(lv+rv<targ){
                    lm=true;
                    rm=false;
                }else if(lv+rv>targ){
                    lm=false;
                    rm=true;
                }else{
                    System.out.println(lv+" "+rv);
                    lm=true;
                    rm=true;
                }
               
            }
        }
           
        
    
    public static void main(String [] args){
       // int[] sa={12,25,37,50,62,75,87};
       int[] sa={10,20,30,50,60,70,80};
       
        Node root=construct(sa,0,sa.length-1);
        root=add(root, 25);
        root=add(root, 35);
        root=add(root, 55);
        root=add(root, 65);
      //  display(root);
      //  System.out.println(max(root));
      //  System.out.println(min(root));
        //root=add(root, 40);
        //display(root);
        System.out.println("---------");
       // remove(root, 75);
        display(root);
        System.out.println("---------");
        //sumofgreater(root);
        //display(root);
        targetsumpair(root, 125, root);
        System.out.println("---------");
        ArrayList<Integer> strg=new ArrayList<>();
        int targ=125;
        targetsumpair2(root,targ,strg);
        int left=0;
        int ri=strg.size()-1;
        while(left<ri){
            int sum=strg.get(left)+strg.get(ri);
            if(sum<targ){
                left++;
            }else if(sum>targ){
                ri--;
            }else{
                System.out.println(strg.get(left)+" "+strg.get(ri));
                left++;
                ri--;
            }
        }
        System.out.println("---------");
        
        targetsumpair3(root, 110);

    }
}
