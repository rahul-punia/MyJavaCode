import java.util.*;
import java.io.*;
import java.lang.*;


public class thouses {
        //HashSet<Integer> hs=new HashSet<>();
        //PriorityQueue<Integer> pq=new PriorityQueue<>();
        //HashMap<Integer,Integer> hm=new HashMap<>();
        //ArrayList<Integer> lt=new ArrayList<>();
         
static long mod=1000_000_007;



public static void dfssize1(int s,long[] szs, ArrayList<ArrayList<Integer>> gp,long[] outdegree){
    if((gp.get(s)).size()==0){
         return;
    }

    long size=0;   long ct=1;
    
    for(int nbr:(gp.get(s))){
        szs[nbr]=ct;  ct++;  //szs[s]*ct;  //biggest Mistake Call at wrong place
        dfssize1(nbr, szs, gp,outdegree);
        size+=szs[nbr];
    }
    
    
    szs[s]=(szs[s]+size);
}


public static void dfssize(int s,int[] hts, ArrayList<ArrayList<Integer>> gp){
        if((gp.get(s)).size()==0){
            hts[s]=1;  return;
        }

        int size=0;
        for(int nbr:(gp.get(s))){
            dfssize(nbr, hts, gp);
            size+=hts[nbr];
        }
        hts[s]=size+1;
    }

 
public static void dfssize(int s,long[] szs, ArrayList<ArrayList<Integer>> gp,long[] outdegree,boolean[] vst){
        if((gp.get(s)).size()==1){
            szs[s]=1;
             return;
        }
    
        long size=0;
        for(int nbr:(gp.get(s))){
            if(!vst[nbr]){
                vst[nbr]=true;
                dfssize(nbr, szs, gp,outdegree,vst);
                size+=szs[nbr];     
            }
        }
     
        szs[s]=size+1;
     }
    

//using size only 2 testcases donot pass
public static void solve() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    
   while(t-->0){
    // int n =Integer.parseInt(br.readLine());
    String[] strs=(br.readLine()).trim().split(" ");
    int n=Integer.parseInt(strs[0]);
    long x=Integer.parseInt(strs[1]);
    
    ArrayList<ArrayList<Integer>> gp=new ArrayList<>();

    for(int i=0;i<=n;i++){
        gp.add(new ArrayList<>());
    }

    long[] outdegree=new long[n+1];
    // long[] last=new long[n+1];
    // long[] valA=new long[n+1];
    
    for(int i=0;i<(n-1);i++){
        strs=(br.readLine()).trim().split(" ");
        int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);  
        outdegree[u]++;
        (gp.get(u)).add(v);   (gp.get(v)).add(u);
        // last[u]++;  valA[v]=last[u];
    }

    //find sizes
    long[] sizes=new long[n+1];
    // sizes[1]=1;
    // dfssize1(1,sizes,gp,outdegree);
    // int[] sizes=new int[n+1];
    boolean[] vst=new boolean[n+1];
    vst[1]=true;
    dfssize(1,sizes,gp,outdegree,vst);
    // System.out.println(Arrays.toString(sizes));
    //bfs
    
    long[] values=new long[n+1];
    values[1]=x;
    Queue<Long> q=new LinkedList<>();    
    q.add((long)1);

    vst=new boolean[n+1];
    vst[1]=true;

    while(q.size()>0){
        int sz=q.size();

        while(sz-->0){
            long rem=q.remove();
            
            // ArrayList<int[]> outdglt=new ArrayList<>(); //store heights
            ArrayList<long[]> szlt=new ArrayList<>(); //store heights
            
            
            for(int nbr:gp.get((int)rem)){
                // outdglt.add(new int[]{nbr,outdegree[nbr]});
                if(!vst[nbr]){
                    vst[nbr]=true;
                szlt.add(new long[]{nbr,sizes[nbr],outdegree[nbr]});
                }
            }
            // Collections.sort(szlt,(a,b)->{
            //     if(a[1]!=b[1])return (int)(b[1]-a[1]);
            //     else return (int)(b[2]-a[2]);
            // });
            //  Collections.sort(szlt,(a,b)->{
            //     return (int)(b[1]-a[1]);
            // });

            Collections.sort(szlt,new Comparator<long []>(){
                public int compare(long[] a,long[] b){
                    return Long.compare(a[1], b[1]);//(int)(a[1]-b[1]);
                }
            });

            long ct=1;   long val=values[(int)rem];  //parent value
            
            for(long[] nbr:szlt){  //Order V.Imp
                    values[(int)nbr[0]]=(ct*val)%mod;      ct++;
                    q.add(nbr[0]);
            }
        }
    }

    long ans=0;
    for(int i=1;i<=n;i++){
        ans=(ans+values[i])%mod;
    }

    // long ans2=solve2(outdegree,gp,n,x);
    // ans=Math.min(ans,ans2);
    // System.out.println("ans= "+ans);
    System.out.println(ans);
   }
   
}
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    solve();
		// your code goes here
	}
}

