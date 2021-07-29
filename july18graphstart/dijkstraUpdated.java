
import java.util.*;

public class dijkstraUpdated {
  //Application 1786. Number of Restricted Paths From First to Last Node  //v.imp question
   static ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
    
    //find min distance of each node from node src using dijkstraAlgo and fill in distance array
    public  static void dijkstraAlgo(int src){
    PriorityQueue<int[]> pq=new PriorityQueue<>(graph.size(),new Comparator<>(){
        public int compare(int[] a1,int[] a2){
            return a1[1]-a2[1];
        }
    });//imp

    int[] distance=new int[graph.size()];//shortest distance to each node
    
    for(int i=0;i<graph.size();i++)distance[i]=Integer.MAX_VALUE;

    distance[src]=0;
    pq.add(new int[]{src,0});  //DPair contains int node,dist;
    boolean[] visited=new boolean[graph.size()];

    while(pq.size()>0){
     int[] remNode=pq.peek();   pq.remove();//log(m) //take min distance node
     
    if(visited[remNode[0]])continue;
     int u=remNode[0];
     visited[remNode[0]]=true;
     
     for(int[] nbrEdge:graph.get(u)){
        int v=nbrEdge[0];   int W=nbrEdge[1];
        
        if((distance[u]+W)<distance[v]){
            distance[v]=distance[u]+W;
            pq.add(new int[]{v, distance[v]});
        }
     }
    }

    for(int i=0;i<distance.length;i++){
        System.out.println((i)+"  "+distance[i]);
    }
    }

    public static void main(String[] args){
        int n=5;
        int[][] edges = {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}};
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        //MAke graph
        for(int[] ed:edges){
            int u=ed[0],v=ed[1],wt=ed[2];
            (graph.get(u)).add(new int[]{v,wt});
            (graph.get(v)).add(new int[]{u,wt});
        }
        dijkstraAlgo(n);

    }

}
