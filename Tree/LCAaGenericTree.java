import java.util.*;

//Lowest common ancestor =>Time complexity=(O(2*DFS)+O(height of tree))  = (2*(V+E)+O(V))=  O(N),>where n is no of vertex
public class LCAaGenericTree {

    static class Node{
        int val=0;
        ArrayList<Node> children=new ArrayList<>();

        Node(int val){
            this.val=val;
        }
    }

  public static Node Constructor(int[] arr){
    Node root=null;
    Stack<Node> st=new Stack<>();

    for(int i=0;i<arr.length;i++){
     
        if(arr[i]==-1 && st.size()>0){
         st.pop();
        }else{
            Node nn=null;
        if(root==null){
             nn=new Node(arr[i]);
            root=nn;
        }else{
           Node pn=st.peek();//Parent node
            nn=new Node(arr[i]);//new child 
           pn.children.add(nn);
        }
       st.push(nn);
     }
    }
    return root;
 }

public static void display(Node root){
   if(root==null){
       return;
   }
   System.out.print(root.val+"=>");
   for(Node child:root.children){
      System.out.print(child.val+",");
   }
    System.out.println();
   for(Node child:root.children){
      display(child);  
   }
}
static int maxele=Integer.MIN_VALUE;
static int minele=Integer.MAX_VALUE;
public static void maxElementDFS(Node root){
    if(root==null){
        return;
    }
    maxele=Math.max(root.val,maxele);
    minele=Math.min(root.val,minele);

    for(Node child:root.children){
        maxElementDFS(child);  
    }
 }

 public static int HeightDFS(Node root){
    if(root==null){
        return -1;
    }
    int ht=-1;
    for(Node child:root.children){
       ht=Math.max(ht,HeightDFS(child));  
    }
    return ht+1;
 }

 public static Node makeStraightTree(Node root){
    if(root==null){
        return root;
    }
    
    for(int i=root.children.size()-1;i>=0;i--){//right to left
         Node child=root.children.get(i);
        //  System.out.println(child.val);
        Node nn=makeStraightTree(child);
        if(i-1>=0){
            (root.children.get(i-1)).children.add(nn);//v.v.imp
            if(i!=0)root.children.remove(i);
        }
   }
    return root;
 }

 public static ArrayList<Integer> dfsRec(Node root,boolean[] visited,int targ,ArrayList<Integer> list){
    if(root.val==targ){
       ArrayList<Integer> bl=new ArrayList<>(list);
       return bl;
    } 

    for(Node child:root.children){
        if(visited[child.val]==false){
            visited[child.val]=true;
            list.add(child.val);
            ArrayList<Integer> rr=dfsRec(child, visited,targ,list);
            if(rr.size()>1){return rr;} //root to node path found
            list.remove(list.size()-1);
            visited[child.val]=false;
        }
    }
    return new ArrayList<Integer>();
 }

 public static void main(String[] args){
     int n=8;
     int[] arr={1,2,5,-1,6,8,-1,-1,-1,3,-1,4,7,-1,-1,-1};
     Node root=Constructor(arr);
     display(root);
    //******************Generic Tree Queries******************** */
     maxElementDFS(root);
     System.out.println("max="+maxele+"   min="+minele);
     System.out.println("Height="+HeightDFS(root));
     makeStraightTree(root);  //V.Imp
     display(root);

    //******************To find LCA b/w two nodes******************** */
     ArrayList<Integer> list=new ArrayList<>();
     list.add(root.val);
     boolean[] visited=new boolean[n+1];
     ArrayList<Integer> al1=dfsRec(root, visited, 5, list);
     visited=new boolean[n+1];
     list=new ArrayList<>();
     list.add(root.val);
     ArrayList<Integer> al2=dfsRec(root, visited, 7, list);
   
    if(al1.size()==0 || al2.size()==0){
        System.out.println("Nodes are not present in tree(Invalid Input)");
    }
    //******************To find LCA b/w two nodes******************** */
    int ans=-1;
    for(int i=0;i<Math.min(al1.size(),al2.size());i++){
     if(al1.get(i)!=al2.get(i)){
         System.out.println(ans);
         break;
     }else{ans=al1.get(i);}
    }


    //******************To find Distance b/w two nodes******************** */
    for(int i=0;i<Math.min(al1.size(),al2.size());i++){
        if(al1.get(i)!=al2.get(i)){
            int dist=  (al1.size()-i)  +  (al2.size()-i);
            System.out.println(dist);
            break;
        }
    }
   }

}