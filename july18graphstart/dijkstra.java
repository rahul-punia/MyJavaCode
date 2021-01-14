import java.util.*;
//My solution=> v.imp
public class dijkstra {

private static class Edge{
    int nbr,wt;
    
    public Edge(int nbr,int wt){
        this.nbr=nbr; this.wt=wt;
    }
    }

private static class DPair{
    public int node,dist;  //v.imp
    
    public DPair(){}
    public DPair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
    
}
//v.imp
static class DPairComparator implements Comparator<DPair>{ 
    public int compare(DPair dp1,DPair dp2){
    //     if(dp1.dist<dp2.dist){
    //      return -1;
    //     } if(dp1.dist>dp2.dist){
    //       return 1;
    //     }
    //     return 0;
    // }  
    //OR
    return dp1.dist-dp2.dist;
    }      
}

static class ppair{
    int v,av,c;
    ppair(int v,int av,int c){
        this.v=v; this.av=av; this.c=c;
    }
}



static class PrimsComparator implements Comparator<ppair>{   //Syntax  Imp 
    public int compare(ppair dp1,ppair dp2){
    //     if(dp1.dist<dp2.dist){
    //      return -1;
    //     } if(dp1.dist>dp2.dist){
    //       return 1;
    //     }
    //     return 0;
    // }  
    //OR
    return dp1.c-dp2.c;
    }      
}

static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();

private  static void addEdge(int v1,int v2,int wht){
   Edge e1=new Edge(v1, wht);
   graph.get(v2).add(e1);
   Edge e2=new Edge(v2, wht);
   graph.get(v1).add(e2);
}

public  static void addEdgeC(ArrayList<ArrayList<Edge>> mst ,int v1,int v2,int wht){
    Edge e1=new Edge(v2, wht);
    mst.get(v1).add(e1);
    // Edge e2=new Edge(v2, wht);
    // mst.get(v1).add(e2);
 }


private  static void dijkstraAlgo(int src){
    PriorityQueue<DPair> pq=new PriorityQueue<DPair>(graph.size(),new DPairComparator());//imp

    int[] distance=new int[graph.size()];//shortest distance to each node
    
    for(int i=0;i<graph.size();i++)distance[i]=Integer.MAX_VALUE;

    distance[src]=0;
    pq.add(new DPair(src,0));  //DPair contains int node,dist;
    boolean[] visited=new boolean[graph.size()];

    while(pq.size()>0){
     DPair remNode=pq.peek();//log(m) //take min distance node
     pq.remove();
     if(visited[remNode.node])continue;
     int u=remNode.node;
     visited[remNode.node]=true;
     
     for(Edge nbrEdge:graph.get(u)){
        int v=nbrEdge.nbr;
        int W=nbrEdge.wt;
        if((distance[u]+W)<distance[v]){
            distance[v]=distance[u]+W;
            pq.add(new DPair(v, distance[v]));
        }
     }
    }

    for(int i=0;i<distance.length;i++){
        System.out.println((i)+"  "+distance[i]);
    }
}


public static void prims(){
    ArrayList<ArrayList<Edge>> mst=new ArrayList<>(); 
    for(int i=0;i<graph.size();i++){
        mst.add(new ArrayList<Edge>());
    }
    int mincostToConnectAllNodes=0;
    boolean[] visited=new boolean[graph.size()];
    System.out.println("Prims"+" "+graph.size());
    PriorityQueue<ppair> pq=new PriorityQueue<>(graph.size(),new PrimsComparator());
    ppair rtp=new ppair(1, -1, 0);
    pq.add(rtp);

    while(pq.size()>0){
        ppair rem=pq.peek(); pq.remove();// take locally best wt edge
        
        if(visited[rem.v]==true){
            continue;
        }
        if(rem.av!=-1){
            addEdgeC(mst,rem.av,rem.v,  rem.c);
            mincostToConnectAllNodes+=rem.c;
        }

        visited[rem.v]=true;

        for(Edge edge:graph.get(rem.v)){
            if(visited[edge.nbr]==false){//take locally best wt edge 
                ppair np=new ppair(edge.nbr,rem.v,edge.wt);
                pq.add(np);
            }
        }
    }
    // ArrayList<Edge> list=mst.get(1);
    // System.out.println(list.get(0).nbr+" "+list.get(0).wt);
    System.out.println("mincostToConnectAllVertex=>"+mincostToConnectAllNodes);
    display(mst);

}
public static void display(ArrayList<ArrayList<Edge>> graph){

    for(int v=1;v<graph.size();v++){
        System.out.print(v+" ");
        // cout<<v<<"->";
        for(int n=0;n<graph.get(v).size();n++){
            Edge ne=graph.get(v).get(n);      //nbr edge
            System.out.print("["+ne.nbr+" "+ne.wt+"]");
            // cout<<"["<<ne.nbr<<"-"<<ne.wt<<"]";
        }
        System.out.println();
        // cout<<"."<<endl;
    }
}
public static void main(String[] args){
   int n=5;
   for(int i=1;i<=n+1;i++){
       graph.add(new ArrayList<Edge>());
   }
   addEdge(1,2,5);
   addEdge(1,4,9);
   addEdge(1,5,1);
   addEdge(2,3,2);
   addEdge(3,4,6);
   addEdge(4,5,2);
    display(graph);
//    dijkstraAlgo(1);

   prims();
 }
 
}