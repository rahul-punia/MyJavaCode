import java.util.*;

public class mykruskal {
   
    static class Edge{
        int nbr,wt;
        Edge(int nbr,int wt){
            this.nbr=nbr; this.wt=wt;
        }
    }
   static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
    
    public static void addEdge(ArrayList<ArrayList<Edge>> mgraph,int v1,int v2,int wht){
        Edge e1=new Edge(v2, wht);
        mgraph.get(v1).add(e1);
        Edge e2=new Edge(v1, wht);
        mgraph.get(v2).add(e2);
    }
   public static class KEdge implements Comparable<KEdge>{      //Syntax  Imp
        int u,v,ct;
        KEdge(int u,int v,int ct){
            this.u=u; this.v=v; this.ct=ct;
        }
        public int compareTo(KEdge other){
            return this.ct-other.ct;
        }
    }


    public static int  findLeader(int[] link,int x){
        while(x!=link[x]){x=link[x];}
        return x;
    }
    public static boolean isLeaderSame(int a,int b,int[] link){
        return findLeader(link, a)==findLeader(link, b);
    }
    
    public static void mergeSet(int[] link,int[] size,int u,int v){ //UniteSet
        int a=findLeader(link, u);
        int b=findLeader(link, v);
        if(size[a]<size[b]){
            int temp=a; a=b; b=temp;
        }
        size[a]+=size[b]; //make large size set setleader as leader of combined set
        link[b]=a; //b point a
    }
    public static void kruskal(ArrayList<ArrayList<Edge>> graph){
        PriorityQueue<KEdge> pq=new PriorityQueue<>();
        ArrayList<ArrayList<Edge>> mst=new ArrayList<>();
        int[] size=new int[graph.size()];
        int[] link=new int[graph.size()];

        for(int i=0;i<graph.size();i++){
            size[i]=1; link[i]=i;
            mst.add(new ArrayList<>());
        }
       
        for(int v=0;v<graph.size();v++){
            for(int n=0;n<graph.get(v).size();n++){
                Edge ne=graph.get(v).get(n);
                if(v<ne.nbr){      //to addEdge only one time like add 0--1 but dont add 1--0
                    KEdge ke=new KEdge(v, ne.nbr, ne.wt);
                    pq.add(ke);
                }
            }
        }
        System.out.println();
//************Kruskal **************************** */
        while(pq.size()>0){
            KEdge ke=pq.peek(); pq.remove();

            if(!isLeaderSame(ke.u,ke.v,link)){
                addEdge(mst, ke.u, ke.v, ke.ct);
                mergeSet(link,size,ke.u,ke.v);
            }
        }
       display(mst);
    }

    static void display(ArrayList<ArrayList<Edge>> g){
        for(int v=0;v<g.size();v++){
            System.out.print(v+"->");
            for(int n=0;n<g.get(v).size();n++){
                Edge ne=g.get(v).get(n);
                System.out.print("["+ne.nbr+"-"+ne.wt+"]");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        for(int i=0;i<=6;i++){
            graph.add(new ArrayList<Edge>());
        }
        addEdge(graph,0,1,20);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,20);
        addEdge(graph,0,3,40);
        // addEdge(graph,2,5,5);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,3);
        addEdge(graph,5,6,3);
        addEdge(graph,4,6,8);
      display(graph);
      kruskal(graph);
    }
}