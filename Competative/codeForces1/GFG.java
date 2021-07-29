import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();

	public static void addEdge(int v1,int v2){
		graph.get(v1).add(v2);
		graph.get(v2).add(v1);
	}
 static int v1=0,v2=0;
 
 public static boolean bfs(int s){
	ArrayList<Integer> list=graph.get(s);
	
	for(int i=0;i<list.size();i++){
		for(int j=i+1;j<list.size();j++){
			int val1=list.get(i); int val2=list.get(j);
				if(graph.get(val1).contains(val2) && graph.get(val2).contains(val1)){
					v2=val2; v1=val1;
					return true;
				}
		}
	}
	return false;
 }

	public static void bestTrio(int f_n,ArrayList<Integer> from,ArrayList<Integer> to){
	  
		for(int i=0;i<=f_n;i++){
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<from.size();i++){
			addEdge(from.get(i),to.get(i));
		}
		int minscore=Integer.MAX_VALUE;
		for(int i=1;i<graph.size();i++){
			ArrayList<Integer> list=graph.get(i);
            int score=0;
			if(list.size()>=2){
				if(bfs(i)){
					if(graph.get(i).size()>2){
						score+=graph.get(i).size()-2;
					}
					if(graph.get(v1).size()>2){
						score+=graph.get(v1).size()-2;
					}
					if(graph.get(v2).size()>2){
						score+=graph.get(v2).size()-2;
					}
					minscore=Math.min(minscore,score);
					System.out.println(i+" "+score);
				}
				// System.out.println(minscore);
			}
		}
		if(minscore==Integer.MAX_VALUE){
			minscore=-1;
		}
		System.out.println(minscore);
	}


	public static void countgoodsubarray(int[] arr,int B){
		int[] strg=new int[arr.length];
		int[] sarr=new int[arr.length];
		for(int i=0;i<arr.length;i++){sarr[i]=arr[i];}
        HashSet<Integer> hs=new HashSet<>();
		Arrays.sort(sarr);
		for(int i=0;i<arr.length;i++){
			int dist=1;
			hs=new HashSet<>();
			for(int j=i;j<arr.length;j++){
				// if((j-1)>=i && sarr[j-1]!=sarr[j]){
				// 	dist++;
				// }
				hs.add(arr[j]);
				if(hs.size()>B)break;

				strg[j-i]+=1;
			}
		}
		for(int val:strg)System.out.println(val+" ");
	}


	static int mod=((int)(Math.pow(10,9))+7);
	static int mans=0;
	
	public static void dfs(int s,int lp,int csf,boolean[] visited,boolean[] primes){
			if(csf==(graph.size()-1)){
				// System.out.println("rahul");
				mans=(mans+1)%mod;
				return ;
			}
			System.out.println("rahul"+csf);
			visited[s]=true;
			for(int nbr:graph.get(s)){
				if(!visited[nbr]){
					for(int p=2;p<100;p++){
						if(lp==-1){
							if(!primes[p]){
								dfs(nbr, p, csf+1, visited, primes);
							}
						}else if(!primes[p] && primes[p+lp]){
							dfs(nbr, p, csf+1, visited, primes);
						}
					}
				}
			}
			visited[s]=false;
	}
	
   public static void zerSubarraySum(int[] A){
	   HashMap<Integer,Integer> hm=new HashMap<>();
//     HashMap<Long,Long> hm2=new HashMap<>();
// In Java, types with generic type parameters, such as HashMap, only accept types that inherit 
//from Object. long does not inherit from Object, so you can't use it with HashMap. You can 
//however use Long, which is a boxed version of long.
	   int sum=0; int ans=0;
	   for(int i=0;i<A.length;i++){
		   sum+=A[i];
		   if(sum==0){
			   ans++;
		   }
		   int freq=0;
		   if(hm.containsKey(sum)){
				freq=hm.get(sum);
				ans+=freq;
		   }
		   freq+=1;
		//    ans+=freq;
		   hm.put(sum, freq);
	   }
	   System.out.println(ans);
   }
   static class Pair  
   { 
	   int first, second; 
	   Pair(int a, int b)  
	   { 
		   first = a; 
		   second = b; 
	   } 
   } 

   public static int findSubArrays(int[] arr, int n) 
    { 
            // create an empty map  
            HashMap<Integer,ArrayList<Integer>> map = new HashMap<>(); 
  
            // create an empty vector of pairs to store  
            // subarray starting and ending index  
            ArrayList<Pair> out = new ArrayList<>(); 
  
            // Maintains sum of elements so far 
            int sum = 0; 
  
            for (int i = 0; i < n; i++){ 
                // add current element to sum  
                sum += arr[i]; 
  
                // if sum is 0, we found a subarray starting  
                // from index 0 and ending at index i  
                if (sum == 0){ 
					out.add(new Pair(0, i)); //ans++;
				}
                ArrayList<Integer> al = new ArrayList<>(); //int freq=0;
                  
                // If sum already exists in the map there exists  
                // at-least one subarray ending at index i with  
                // 0 sum  
                if (map.containsKey(sum)){ 
                    // map[sum] stores starting index of all subarrays 
                    al = map.get(sum);   //freq=map.et(sum);
                    for (int it = 0; it < al.size(); it++){ 
                            out.add(new Pair(al.get(it) + 1, i)); //start to end 
                    } 
                } 
                al.add(i); //hm.put(sum,freq+1);
                map.put(sum, al); 
            } 
            return out.size(); 
	}  
	

  //Q1-Samsung Test Questions
  //Insert Minimum character at the end of string to make given string palindrome
   public static void convertPalindrome(String str){
	   int n=str.length();
	int lo=0,hi=str.length()-1;	
	String nstr="",str2="";	
	while(lo<=hi){
		if(str.charAt(lo)==str.charAt(hi)){str2=str.charAt(lo)+str2; lo++; hi--;}
		else{
			nstr=str.charAt(lo)+str2+nstr;
			lo++; hi=n-1;
			str2="";
		}
	}
	System.out.println(nstr);
   }
   //Q2-Given n and m where n=no of stairs,m=max jump size find no of ways to reach from zero to
   //nth stair for ex-n=4,m=3 Ans=7, here m=3 means we can take  1,2 3 size step 
   //Q3-Maximum sum subarray with no adjacent element-DP Problem
	public static void main (String[] args) {
		int[] arr={1,0};//{2,-2,3,0,4,-7};
		convertPalindrome("abcdeaaababbaaba");
		// zerSubarraySum(arr);
	//   int ans=findSubArrays(arr, arr.length);
	//   System.out.println(ans);
		// int n=5;
		// for(int i=0;i<=n;i++){graph.add(new ArrayList<>());}

		// addEdge(1, 5); addEdge(1, 3); addEdge(1, 2); addEdge(2,4); 
		// boolean[] visited=new boolean[n+1];
		// boolean[] primes=new boolean[200];

		// for(int x=2;x<200;x++){
		// 	if(primes[x])continue;
		// 	System.err.print(x+" ");
		// 	for(int i=2*x;i<200;i+=x){
		// 		primes[i]=true;
		// 	}
		// }
		// dfs(1, -1, 0, visited, primes);
		// System.out.println(mans);
		//code
	//    int[] arr={1,2,2,3,1};
	//    countgoodsubarray(arr, 2);
	//    int f_n=5;
	//    ArrayList<Integer> from=new ArrayList<>(); 
	//    ArrayList<Integer> to=new ArrayList<>();
	//    from.add(1);  from.add(2); from.add(2); from.add(3); from.add(4); from.add(1); from.add(3);
	// 	to.add(2);   to.add(3);  to.add(4);     to.add(4); to.add(5);  to.add(3);     to.add(5);     
     
    //     bestTrio(f_n, from, to);
		// Scanner scn=new Scanner(System.in);
		// int t=scn.nextInt();
		
		// for(int r=0;r<t;r++){
		//     int n=scn.nextInt();
		    
		//     int[] arr=new int[n];
		    
		//     for(int i=0;i<n;i++){
		//         arr[i]=scn.nextInt();
		//     }
		    
		//     int[] strg=new int[n];
		  
		//     int omax=arr[0];
		//     strg[0]=arr[0];
		//     for(int i=1;i<n;i++){
		//         int mmax=0;
		//         for(int j=0;j<i;j++){
		//             if(arr[j]<arr[i]){
		//                 mmax=Math.max(mmax,strg[j]);
		//             }
		//           }
		// 		//   Arrays.sort(arr,(val1,val)=>Integer.compare(x, y));
		//         strg[i]=mmax+arr[i];
		//         omax=Math.max(omax,strg[i]);
		//     }
		//     System.out.println(omax);
		// }
	}
}