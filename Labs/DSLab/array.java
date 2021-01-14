//Cf-Round-648(div-2)

//D.Solve the Maze by Bfs
import java.io.*;
import java.util.*;
 
import static java.lang.Math.*;
 
public class array {
	// static int gCount=0;
    static int n, m;
    static char[][] mat;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
 
	static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
 
    static String solve() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
				// if (mat[i][j] == 'G'){gCount++;}
				// else
				 if (mat[i][j] != 'B') continue;
                for (int k = 0; k < 4; k++) {  //block adjacent walls of bad person
                    int x = i + dx[k], y = j + dy[k];
                    if (isValid(x, y)) {
                        if (mat[x][y] == 'B') continue;
                        else if (mat[x][y] == 'G') return "No";
                        else mat[x][y] = '#';  //block wall
                    }
                }
            }
        }
      //Run BFS
        Queue<int[]> queue = new ArrayDeque<>();
        boolean vis[][] = new boolean[n][m];
        if (mat[n - 1][m - 1] != '#') {
            queue.add(new int[]{n - 1, m - 1});
			vis[n - 1][m - 1] = true;
	    }
 
        while (!queue.isEmpty()) {
			int p[] = queue.poll();
			// if(mat[p[0]][p[1]]=='G'){gCount--;}
            for (int k = 0; k < 4; k++) {
                int x = p[0] + dx[k], y = p[1] + dy[k];
                if (isValid(x, y) && !vis[x][y] && mat[x][y] != '#') {
                    vis[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }
		
		// System.out.println(gCount+"ct");
        // if(gCount>0)return "No";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'G' && !vis[i][j]) {
                    return "No";
                }
            }
        }
 
        return "Yes";
    }
 
    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            n = in.nextInt();
            m = in.nextInt();
            mat = new char[n][m];
            for (int i = 0; i < n; i++) {
                mat[i] = in.next().toCharArray();
            }
            pw.println(solve());
        }
 
        pw.close();
    }
 }



//D.Solve the Maze by dfs
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
 
// public class array{
// 	int gCount = 0;
// 	public char[][] board;
// 	public int n,m;
// 	private static final int NEXT[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
 
//     public void dfs(int x, int y){
// 		if(x < 0 || y <0 || x> n-1 || y>m-1 || board[x][y] == '#'
// 				|| board[x][y] == 'v')return;
// 		if(board[x][y] == 'G')gCount--;
// 		board[x][y] = 'v';
// 		for(int k = 0;k<4;k++){
// 			int nx = x + NEXT[k][0];
// 			int ny = y + NEXT[k][1];
// 			dfs(nx, ny);
// 		}
// 	}

// 	public String reachable(){
// 		gCount = 0;
// 		for(int i =0;i<n;i++){
// 			for(int j=0;j<m;j++){
// 				if(board[i][j] == 'G')gCount++;
// 				else if(board[i][j] == 'B'){
// 					// mark all adjacent r and c as wall
// 					for(int k = 0;k<4;k++){
// 						int x = i + NEXT[k][0];
// 						int y = j + NEXT[k][1];
// 						if(x < 0 || y <0 || x>n-1 || y>m-1 ||board[x][y] == 'B'){
// 						}else if(board[x][y] == 'G'){
// 							return "No";
// 						}else{
// 							board[x][y] = '#';
// 						}
// 					}
// 				}
// 			}
// 		}
// 		dfs(n-1, m-1);
// 		if(gCount > 0)
// 		    return "No";
// 		else{
// 			return "Yes";
// 		}
// 	}
// 	public static void main(String[] args)throws Exception{
// 		BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
// 		String lineNo = obj.readLine();
// 		int lines = Integer.parseInt(lineNo);
// 		while(lines-- > 0 ){
// 			array sd = new array();
// 			String line = obj.readLine();
// 			String[] d = line.split(" ");
// 			sd.n = Integer.parseInt(d[0]);
// 			sd.m = Integer.parseInt(d[1]);
// 			sd.board = new char[sd.n][sd.m];
// 			for(int i = 0; i < sd.n; i++){
// 				line = obj.readLine();
// 				sd.board[i] = line.toCharArray(); 
// 			}
// 			System.out.println(sd.reachable());
// 		}
// 	}
 
// }



//     //C.Rotate Matching cf Round-648(div-2)
// import java.util.*;
// public class array{
//      public static void main(String []args){
//         Scanner s=new Scanner(System.in);
//             int n=s.nextInt();
//             HashMap<Integer,Integer> map=new HashMap<>();//store value & position
// 			HashMap<Integer,Integer> c=new HashMap<>();  //shift by position index and count
// 			for(int i=0;i<n;i++)
// 			{
// 				map.put(s.nextInt(),i+1);
// 			}
// 			int[] a=new int[n];
// 			int ans=1;
// 			for(int i=0;i<n;i++)
// 			{
// 				a[i]=s.nextInt();
//                 int temp=(map.get(a[i])-i+n)%n;//position shift for a[i]
//                 System.out.println((map.get(a[i])-i+n));
// 				if(!c.containsKey(temp))
// 				{
// 					c.put(temp,1);
// 				}
// 				else
// 				{
// 					c.put(temp,c.get(temp)+1); //count increase if position shift is same
// 				}
// 				ans=Math.max(c.get(temp),ans);
// 			}
// 			System.out.println(ans);
//      }
// }





// import java.io.*;
// import java.util.*;
// public class array
// {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		int n, i, val, ans;
// 		n=sc.nextInt();
// 		ans=0;
// 		Map<Integer, Integer> b = new HashMap<>();
// 		int[] a = new int[n];
// 		for(i=0; i<n; i++)
//             a[i]=sc.nextInt();
            
// 		for(i=0; i<n; i++)
//             b.put(sc.nextInt(), i);
            

// 		Map<Integer, List<Integer>> offset = new HashMap<>();
// 		for(i=0; i<n; i++)
// 		{
// 			if(b.get(a[i])<i){
//                 val=n-i+b.get(a[i]);
//                 //System.out.print(b.get(a[i])+"<"+i+"="+val+" ");
//             }else{
//                 val=b.get(a[i])-i;
//                // System.out.print(b.get(a[i])+">"+i+"="+val+" ");
//             }
// 			List<Integer> l = offset.getOrDefault(val, new ArrayList<Integer>());
// 			l.add(a[i]);
// 			offset.put(val, l);
// 			ans=Math.max(ans, l.size());
//         }
//         System.out.println();
// 		System.out.println(ans);
// 	}
// }


