import java.util.*;
public class floydwarshall {

	public static void main(String[] args) {
		Integer[][] graph = new Integer[6][6];
		graph[0][1] = 2;
		graph[0][2] = 7;
		graph[1][2] = 4;
		graph[1][4] = 7;
		graph[2][4] = 5;
		graph[2][3] = 1;
		graph[3][5] = 6;
		graph[4][5] = 2;
		
		Integer[][] matrix = solve(graph);
		for(int s = 0; s < matrix.length; s++){
			for(int d = 0; d < matrix.length; d++){
				System.out.print(matrix[s][d] + "\t");
			}
			System.out.println();
		}
	}
	
	private static Integer[][] solve(Integer[][] graph){
		Integer[][] res = new Integer[graph.length][graph.length];
		
		for(int s = 0; s < graph.length; s++){
			for(int d = 0; d < graph.length; d++){
				res[s][d] = graph[s][d];
			}
		}
		
		for(int i = 0; i < graph.length; i++){
			for(int s = 0; s < graph.length; s++){
				for(int d = 0; d < graph.length; d++){
					if(i == s || i == d){
						continue;
					} else if(res[s][i] == null || res[i][d] == null){
						continue;
					} else {
						res[s][d] = min(res[s][d], res[s][i] + res[i][d]);
					}
				}
			}
		}
		
		return res;
	}
	
	private static Integer min(Integer o, Integer t){
		if(o == null){
			return t;
		} else {
			return Math.min(o, t);
		}
	}

}
