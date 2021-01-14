import java.util.*;
//Time Complexity : O(V * (V + E))
public class AllLongestPath {
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
static int[] maxdist=new int[7];
static int maxlen=0;
 public static void dfsTree(int s,int pn,int len){
    if(len>maxlen){    //pn=>previous visited vertex so that visit each vertex only once 
        maxlen=len;
    }
    for(Edge nbrEdge:graph.get(s)){
       if(nbrEdge.nbr!=pn){
           dfsTree(nbrEdge.nbr,s,len+1);
       }
    }
}


public static void longestLength(int n){

  for(int i=1;i<=n;i++){
      maxlen=0;
      dfsTree(i,0,0);
      System.out.println(i+"  "+maxlen);
  }
}
    public static void main(String[] args) {
        int n=6;
    for(int i=1;i<=n+1;i++){
        graph.add(new ArrayList<Edge>());
    }
    addEdge(1,3,1);
    addEdge(1,2,1);
    addEdge(1,4,1);
    addEdge(2,5,1);
    addEdge(2,6,1);

    longestLength(n);
    }
}