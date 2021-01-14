import java.util.*;

public class TopologicalSort{
    private static class Edge{
        int nbr,wt;
        
        public Edge(int nbr,int wt){
            this.nbr=nbr; this.wt=wt;
        }
    }
   
 static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
 
 private  static void addDircEdge(int v1,int v2,int wht){
    Edge e=new Edge(v2, wht);
    graph.get(v1).add(e);
    // Edge e2=new Edge(v2, wht);
    // graph.get(v1).add(e2);
 }

 public static void topologicalSort(boolean[] visited,int s,Stack<Integer> ToplSort){
    visited[s]=true;

    if(graph.contains(s)){
    for(Edge nbrEdge:graph.get(s)){
        if(visited[nbrEdge.nbr]==false){
            topologicalSort(visited,nbrEdge.nbr,ToplSort);
        }
    }
   }
    // System.out.print(s+" ");
    ToplSort.push(s);
 }

    public static void main(String[] args) {
        int n=6;
    for(int i=1;i<=n+1;i++){
        graph.add(new ArrayList<Edge>());
    }
    addDircEdge(1,2,1);
    addDircEdge(2,3,1);
    addDircEdge(3,6,1);
    addDircEdge(4,5,1);
    addDircEdge(4,1,1);
    addDircEdge(5,2,1);
    addDircEdge(5,3,1);
   boolean[] visited=new boolean[7];
   Stack<Integer> ToplSort=new Stack<>(); 
   
   for(int i=1;i<=n;i++){
       if(visited[i]==false){
        topologicalSort(visited,i,ToplSort);
       }
   }

   while(ToplSort.size()>0){
       System.out.print(ToplSort.pop()+"  ");
   }
  }
}