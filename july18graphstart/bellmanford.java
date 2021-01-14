import java.util.*;

public class bellmanford {
	private static class Edge {
		int u,v,wt;
		Edge(int u, int v, int wt) {
			this.u = u;  this.v = v;   this.wt = wt;
		}
	}

	private static class Pair { //store distance from starting node to given nodes
		int dist;  String path;

		Pair(int dist, String path) {
			this.dist = dist;
			this.path = path;
		}
	}

	private static Pair[] solve(Integer[][] graph, int src) {
		Pair[] spairs = new Pair[graph.length];//store distance from starting node to all nodes
		ArrayList<Edge> edges = new ArrayList<>();// contain all edges  //V.IMp

		for (int u = 0; u < graph.length; u++) {
			for (int v = 0; v < graph.length; v++) {
				if (graph[u][v] != null) {// or 0
					edges.add(new Edge(u, v, graph[u][v]));
				}
			}
		}

		for (int i = 0; i < spairs.length; i++) {
			spairs[i] = new Pair(Integer.MAX_VALUE, null);
		}
		spairs[src] = new Pair(0, src + "");

		// after 1st iteration all paths of length 1 has been considered and
		// hence
		// we have shortest paths of length 1
		// after 2nd iteration all paths of length 2 has been considered and
		// hence
		// we have shortest paths of length 2
		// hence this run for v - 1 times because the longest "acyclic"
		// path (in terms of edges) can be atmost of length v - 1.//where v is total no of vertices
		for (int counter = 0; counter < (graph.length - 1); counter++) {// run (n-1) rounds where n-> no of vertex
			// sv = su + uv; sv has length one longer than su
			for (Edge e : edges) {
				if (spairs[e.u].path != null && (spairs[e.u].dist + graph[e.u][e.v]) < spairs[e.v].dist) {
					//spairs[e.u].path != null not necessary condition
					spairs[e.v].dist = spairs[e.u].dist + graph[e.u][e.v];//shortest distance //graph[e.u][e.v]=e.wt;
					spairs[e.v].path = spairs[e.u].path + e.v;//path
				}
			}
		}

		// considering all paths of length v now (cyclic paths)
		for (Edge e : edges) { //A negative cycle can be detected using the Bellman–Ford algorithm by running the algorithm for n rounds.
			// if another optimisation happens, indicates negative cycle
			if ((spairs[e.u].dist + graph[e.u][e.v])< spairs[e.v].dist) {
				System.out.println("Negative cycle");
				return null;
			}
		}

		return spairs;
	}

	public static void main(String[] args) {
		Integer[][] graph = new Integer[4][4];
		graph[0][1] = 10;
		graph[0][2] = 20;
		graph[1][2] = 4;
		graph[1][3] = 8;
		graph[2][3] = -3;
		graph[3][0] = -10;
		Pair[] pairs = solve(graph, 0);
		if (pairs != null) {
			for (Pair pair : pairs) {
				System.out.println(pair.path + "@" + pair.dist);
			}
		}
	}
}
