import java.util.*;

public class KthAncestor {
    private static class Edge{
        int nbr,wt;
        
        public Edge(int nbr,int wt){
            this.nbr=nbr; this.wt=wt;
        }
    }
   
 static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
 
 private  static void addEdge(int v1,int v2,int wht){
    Edge e1=new Edge(v1, wht);
    graph.get(v2).add(e1);
    Edge e2=new Edge(v2, wht);
    graph.get(v1).add(e2);
 }
static boolean flag=false;
static int level=0;

 public static void KthAnc(int x,int k,int s,int l,int pn){
  if(k==0){System.out.println(x); return;}
  
  if(x==s){
      flag=true;
      level=l;
      return;
  }
  
  for(Edge nbrEdge:graph.get(s)){
      if(nbrEdge.nbr!=pn && flag==false){
          KthAnc(x, k,nbrEdge.nbr,l+1,s);
        if(level-l==k && flag){
          System.out.println(s);
        }
      }
  }
 }
 public static void main(String[] args) {
    int n=8;
for(int i=1;i<=n+1;i++){
    graph.add(new ArrayList<Edge>());
}
addEdge(1,4,1);
addEdge(1,5,1);
addEdge(1,2,1);
addEdge(2,6,1);
addEdge(4,3,1);
addEdge(4,7,1);
addEdge(7,8,1);

KthAnc(8,0,1,0,0);
 }
}