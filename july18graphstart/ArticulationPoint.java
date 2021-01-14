import java.util.*;
//MyKAArma company Question
public class ArticulationPoint{

    static ArrayList<ArrayList<Integer>> mgraph=new ArrayList<>();
    
    public static void addEdge(int v1,int v2){
        // Edge e1=new Edge(v2, wht);
        mgraph.get(v1).add(v1);
        // Edge e2=new Edge(v1, wht);
        mgraph.get(v2).add(v1);
    }
   //T.C=>o(v*(v+E))
    
    public static void dfs(int c,int s,boolean[] visited){
        Stack<Integer> st=new Stack<>();
        st.push(s);

        while(st.size()>0){
            int rem=st.pop();

            visited[rem]=true;

            for(int nbr:mgraph.get(rem)){
                if(visited[nbr]==false && nbr!=c){
                    st.push(nbr);
                }
            }
        }
    }


    //T.C=>o(v+E)
//  A O(V+E) algorithm to find all Articulation Points (APs)
// The idea is to use DFS (Depth First Search). In DFS, we follow vertices in tree form called DFS tree. In DFS tree, a vertex u is parent of another vertex v, if v is discovered by u (obviously v is an adjacent of u in graph). In DFS tree, a vertex u is articulation point if one of the following two conditions is true.
// 1) u is root of DFS tree and it has at least two children.
// 2) u is not root of DFS tree and it has a child v such that no vertex in subtree rooted with v has a back edge to one of the ancestors (in DFS tree) of u.


    // A recursive function that find articulation points using DFS 
    // u --> The vertex to be visited next 
    // visited[] --> keeps tract of visited vertices 
    // disc[] --> Stores discovery times of visited vertices 
    // parent[] --> Stores parent vertices in DFS tree 
    // ap[] --> Store articulation points 
    // low[]  //store lowest discovery time including childs and parent itself
        
    static int time=0;
    public static void APdfs(int u, boolean visited[], int disc[],int low[], int parent[], boolean ap[]){
         // Count of children in DFS Tree 
         int children = 0; 
  
         // Mark the current node as visited 
         visited[u] = true; 
   
         // Initialize discovery time and low value 
         disc[u] = low[u] = ++time;

         for(int v:mgraph.get(u)){  //v=nbr or child
            if (!visited[v]){ 
                children++; 
                parent[v] = u; 
                APdfs(v, visited, disc, low, parent, ap); 
  
                // Check if the subtree rooted with v has a connection to 
                // one of the ancestors of u 
                low[u]  = Math.min(low[u], low[v]); //if child have backEdge then parent also have backEdge
                                            //beta ke fayde parent ko bhi hone chahiye connnections ke        
                // u is an articulation point in following cases 
  
                // (1) u is root of DFS tree and has two or more children. 
                if (parent[u] ==-1 && children > 1) 
                    ap[u] = true; 
  
                // (2) If u is not root and low value of one of its child 
                // is more than discovery value of u. 
                if (parent[u] != -1 && low[v] >= disc[u]) 
                    ap[u] = true; 
            } // Update low value of u for parent function calls. 
            else if (v != parent[u]){ 
                low[u]  = Math.min(low[u], disc[v]); 
            }
         }
    }

   public static  void AP(){ 
        // Mark all the vertices as not visited 
        int V=mgraph.size();
        boolean visited[] = new boolean[V]; 
        int disc[] = new int[V]; 
        int low[] = new int[V]; //store lowest discovery time including childs and itself
        int parent[] = new int[V]; 
        boolean ap[] = new boolean[V]; // To store articulation points 
        Arrays.fill(parent, -1);
        // // Initialize parent and visited, and ap(articulation point) 
       
        // for (int i = 0; i < V; i++) 
        // { parent[i] = NIL; visited[i] = false;  ap[i] = false;}
       
        // Call the recursive helper function to find articulation 
        // points in DFS tree rooted with vertex 'i' 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                APdfs(i, visited, disc, low, parent, ap); 
  
        // Now ap[] contains articulation points, print them 
        for (int i = 0; i < V; i++) 
            if (ap[i] == true) 
                System.out.print(i+" "); 
    } 

//Bridges in a graph
// A O(V+E) algorithm to find all Bridges
// The idea is similar to O(V+E) algorithm for Articulation Points. We do DFS traversal of the given graph. 
// In DFS tree an edge (u, v) (u is parent of v in DFS tree) is bridge if there does not exist any other 
// alternative to reach u or an ancestor of u from subtree rooted with v. As discussed in the previous post, 
// the value low[v] indicates earliest visited vertex reachable from subtree rooted with v. The condition for 
// an edge (u, v) to be a bridge is, “low[v] > disc[u]”. but for Articulation Points “low[v] >=disc[u]”.


//q-2 Managing tasks or Minimum number of groups of nodes such that no ancestor is present in the same group
//Given a tree of N nodes. The task is to form the minimum number of groups of nodes such that every node 
// belong to exactly one group, and none of its ancestors are in the same group. The parent of each node is 
// given (-1 if a node does not have a parent).

//Approach: The groups can be made by grouping nodes on the same level together (A node and any of it’s 
//ancestors cannot be on the same level).So the minimum number of groups will be the maximum depth of the tree.



public static void managingTasks(int[] task){
    ArrayList<Integer> list=new ArrayList<>();
    for(int i=0;i<task.length;i++){
        if(task[i]==-1){
            list.add(i);
        }
    }
    Queue<Integer> queue=new LinkedList<>();
    int ans=-1;
    System.out.println("rahul");
    for(int i=0;i<list.size();i++){
        int s=list.get(i);
        queue.add(s);
        int level=0;
        System.out.println("rahul1");
    
        while(queue.size()>0){
            int sz=queue.size();
            for(int r=0;r<sz;r++){
            int rem=queue.remove();
            System.out.println("rahul2");
        
            for(int j=0;j<task.length;j++){
                if(task[j]==rem){
                    queue.add(j);
                }
            }
        }
        level++;
      }
    ans=Math.max(ans, level);
    }
    System.out.println(ans);
}
    public static void main(String[] args){
        // int[][] graph={{0,1,1,0,0,0,0},
        //                {1,0,0,1,1,0,0},
        //                {1,0,0,0,0,0,0},
        //                {0,1,0,0,1,0,1},
        //                {0,1,0,1,0,0,1},
        //                {0,0,0,0,0,0,1},
        //                {0,0,0,1,1,1,0}};
        
        // for(int i=0;i<graph.length;i++){
        //     mgraph.add(new ArrayList<>());
        // }

        // for(int i=0;i<graph.length;i++){
        //     for(int j=0;j<graph.length;j++){
        //         if(graph[i][j]==1){
        //             addEdge(i, j);
        //         }
        //     }
        // }
        // int ans=0;
        // for(int i=0;i<graph.length;i++){
        //     boolean[] visited=new boolean[graph.length];
        //     int ct=0;
        //     for(int j=0;j<graph.length;j++){
        //         if(i!=j && visited[j]==false){
        //             dfs(i,j,visited);
        //             ct++;
        //         }
        //         if(ct>1){
        //             ans++; break;
        //         }
        //     }
        // }
        // System.out.println(ans);

        // AP();

        // int[] task={-1,8,6,0,7,3,8,9,-1,6};
        int[] task={ 0, -1, 1, 1, 2, 2, 5,6};
        managingTasks(task);
    }
}