import java.util.*;

public class Diameter {
    private static class Edge{
        int nbr,wt;
        
        public Edge(int nbr,int wt){
            this.nbr=nbr; this.wt=wt;
        }
    }
static ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
    static int maxlen=-1;
    static int FarNode=0;
    
    public static void dfsTree(int s,int pn,int len){
        if(len>maxlen){    //pn=>previous visited vertex so that visit each vertex only once 
            maxlen=len; FarNode=s;
        }
        for(Edge nbrEdge:graph.get(s)){
           if(nbrEdge.nbr!=pn){
               dfsTree(nbrEdge.nbr,s,len+1);
           }
        }
    }

    private  static void addEdge(int v1,int v2,int wht){
        Edge e1=new Edge(v1, wht);
        graph.get(v2).add(e1);
        Edge e2=new Edge(v2, wht);
        graph.get(v1).add(e2);
     }

     public static int FindDiameter(){
       int dia=0;
       dfsTree(3,0,0);
    //    ans+=maxlen;
       maxlen=-1;
       dfsTree(FarNode,0,0);
       dia=maxlen;
       return dia;
     }
 public static void main(String[] args) {
    int n=7;
    for(int i=1;i<=n+1;i++){
        graph.add(new ArrayList<Edge>());
    }
    addEdge(1,3,1);
    addEdge(1,2,1);
    addEdge(1,4,1);
    addEdge(2,5,1);
    addEdge(2,6,1);
    addEdge(4,7,1);
     System.out.println(FindDiameter());
 }     
}