import java.util.*;

public class kruskals{
    public static class Edge{
        int nbr;
        int wt;

        Edge(int nbr,int wt){
            this.nbr=nbr;
            this.wt=wt;
        }
    }
  
       
   public static class KEdge implements Comparable<KEdge>{  //doubt
        int v1;
        int v2;
        int wt;
        KEdge(int v1,int v2,int wt){
            this.v1=v1;
            this.v2=v2;
            this.wt=wt;
        }
        //this>other return positive
        //this==other return zero
        //this<other return negative
        public int compareTo(KEdge other){
            return this.wt-other.wt;
        }
    }
    static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();

    static void addEdge(ArrayList<ArrayList<Edge>> g,int v1,int v2,int wt){
       Edge e1=new Edge(v2, wt);
       g.get(v1).add(e1);
       Edge e2=new Edge(v1, wt);
       g.get(v2).add(e2);
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
   
    static void merge(int v1sl,int v2sl,int [] pa,int [] ra){
      if(ra[v1sl]<ra[v2sl]){
          pa[v1sl]=v2sl;
      }else if(ra[v2sl]<ra[v1sl]){
         pa[v2sl]=v1sl;
      }else{
          pa[v1sl]=v2sl;
          ra[v2sl]++;
      }
    }
    static int find(int [] pa,int v){
        if(pa[v]==v){
            return v;
        }else{            //else if(pa[v]!=v)
           return  find(pa,pa[v]);
        }
    }
    static void kruskal(ArrayList<ArrayList<Edge>> g){
        ArrayList<ArrayList<Edge>> mst=new ArrayList<>();
        int [] pa=new int[g.size()];//pointer array
        int [] ra=new int[g.size()];//rank array

        for(int v=0;v<g.size();v++){
            pa[v]=v;   ra[v]=1;
            mst.add(new ArrayList<Edge>());
        }
        PriorityQueue<KEdge> pq=new PriorityQueue<>();

        for(int v=0;v<g.size();v++){
            for(int n=0;n<g.get(v).size();n++){
                Edge ne=g.get(v).get(n);
                if(v<ne.nbr){  //one edge add only one time  //V.Imp
                    KEdge ke=new KEdge(v, ne.nbr, ne.wt);//make edge b/w vertex & nbr
                    pq.add(ke);
                }
            }
        }
        while(pq.size()>0){
            KEdge ke=pq.remove();//low cost come out first
            int v1=ke.v1;
            int v2=ke.v2;

            int v1sl=find(pa,v1);   //set leader of vertex 1
            int v2sl=find(pa,v2);

            if(v1sl!=v2sl){
                addEdge(mst, v1, v2, ke.wt);//make edge b\w vertexes
                merge(v1sl,v2sl,pa,ra);//merge set leader
            }

        }
        display(mst);

    }
    
    

    public static void main(String [] args){
        Scanner scn=new Scanner(System.in);
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());
        graph.add(new ArrayList<Edge>());

        addEdge(graph,0,1,20);
        addEdge(graph,1,2,10);
        addEdge(graph,2,3,20);
        addEdge(graph,0,3,40);
        addEdge(graph,2,5,5);
        addEdge(graph,3,4,2);
        addEdge(graph,4,5,3);
        addEdge(graph,5,6,3);
        addEdge(graph,4,6,8);
        //  display(graph);
        kruskal(graph);
    }
}
        // int n=scn.nextInt();
        // int[][] cake=new int[n][n];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         cake[i][j]=scn.nextInt();
        //     }
        // }
        // int ct=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         if(cake[i][j]==1){
        //             ct++;
        //         }
        //     }
        // }
        // System.out.println(ct);}}
     