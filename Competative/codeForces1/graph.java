import java.util.*;
import java.io.*;
import java.lang.*;


public class graph {
    // static ArrayList<ArrayList<int[]>> graph=new ArrayList<>();
    // static HashSet<Integer> hs=new HashSet<>();
    // // static int ct=0;
    // public static void dfs(int s,int targ,int lc,boolean[] vd){
    //     if(s==targ){
    //         hs.add(lc);
    //         // ct++;
    //         return ;
    //     }

    //     for(int[] nbr:graph.get(s)){

    //         if(!vd[nbr[0]] && (nbr[1]==lc || lc==-1)){
    //             vd[nbr[0]]=true;
    //             dfs(nbr[0], targ, nbr[1], vd);
    //             vd[nbr[0]]=false;
    //         }
    //     }
    // }

    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        // StringBuilder sb = new StringBuilder();
        // ArrayList<Integer> list=new ArrayList<>();

       while(t-->0){
        String[] strs=(br.readLine()).trim().split(" ");
        
        int n=Integer.parseInt(strs[0]);
        int q=Integer.parseInt(strs[1]);
        int m=Integer.parseInt(strs[2]);
        

        int[] a=new int[n];
        strs=(br.readLine()).trim().split(" ");

        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(strs[i]);
        }

        int[] b=new int[1000001];

        HashMap<int[],Integer> hm=new HashMap<>();

        while(q-->0){
            strs=(br.readLine()).trim().split(" ");
            int l=Integer.parseInt(strs[0]);
            int r=Integer.parseInt(strs[1]);
            l--; r--;
            if(a[l]>m){
                continue;
            }else if(a[l]<=m && a[r]>m){
                b[a[l]]++; b[m+1]--;
            }else{
                b[a[l]]++;  b[m+1]--;
                int[] pr=new int[]{a[l],a[r]};
                hm.put(pr,hm.getOrDefault(pr, 0)+1);
            }
        }

        for(int[] pr:hm.keySet()){
            int ai=pr[0],bi=pr[1];
            int ci=bi+2*ai;
            b[bi+ai]-=1; b[ci]++;

            while((ci+bi)<=m){
                ci+=bi;
                b[ci]--;
                b[ci+ai]++;
                ci+=ai;
            }
        }

        int max=0;

        for(int i=1;i<=m;i++){
            b[i]+=b[i-1];
            max=Math.max(max, b[i]);
        }

        System.out.println(max);
       }

    }
}


//     public static void main(String[] args) throws Exception{
//                 InputStreamReader ip=new InputStreamReader(System.in);
//                 BufferedReader br = new BufferedReader(ip);
//         		// int n = Integer.parseInt(br.readLine());
//         		// StringBuilder sb = new StringBuilder();
//                 // ArrayList<Integer> list=new ArrayList<>();
        
//                 String[] strs=(br.readLine()).trim().split(" ");
                
//                 int n=Integer.parseInt(strs[0]);
//                 int m=Integer.parseInt(strs[1]);

//                 for(int i=0;i<=n;i++){ graph.add(new ArrayList<>());}
              

//                for(int i=0;i<m;i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int u=Integer.parseInt(strs[0]);
//                 int v=Integer.parseInt(strs[1]);
//                 int w=Integer.parseInt(strs[2]);

//                 (graph.get(u)).add(new int[]{v,w});
//                 (graph.get(v)).add(new int[]{u,w});
//                }
               
//                int q=Integer.parseInt(br.readLine());

//                boolean[] vd=new boolean[n+1];
//                for(int i=0;i<q;i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int u=Integer.parseInt(strs[0]);
//                 int v=Integer.parseInt(strs[1]);
//                 // ct=0;
//                 hs=new HashSet<>();
//                 vd[u]=true;
//                 dfs(u,v,-1,vd);
//                 vd[u]=false;
//                 // ans+=ct;
//                 System.out.println(hs.size());
//                }

               
//     }

// }


//     static long mod=10000_00007;
//     // Approach
//     // Property: Look at one tree and take its diameter. Name its endpoints A and B. 
//     //For each vertex u from this component, p[u] = A or p[u] = B. It's easy to prove that.
//     //We can just count number of different elements in P and divide it by two.
//    //Special case : Isolated vertices (those with p[i] = i).
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int n = Integer.parseInt(br.readLine());
// 		// StringBuilder sb = new StringBuilder();
//         ArrayList<Integer> list=new ArrayList<>();

//         String[] strs=(br.readLine()).trim().split(" ");

//         int[] arr=new int[n];
//         HashSet<Integer> hs=new HashSet<>();

//         long ans=0;
//         for(int i=0;i<n;i++){
//             int val=Integer.parseInt(strs[i]);
//             if(val==(i+1)){ans++;}
//             else{hs.add(val);}
//         }
//         ans+=(hs.size()/2);
//         System.out.println(ans);
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int n = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
//         ArrayList<Integer> list=new ArrayList<>();

//         if(n%4==0 || n%4==2){
//             for(int i=1;i<=n;i++){
//                 if(i%4==1 || i%4==0){
//                    list.add(i); // System.out.print(i+" ");
//                 }
//             }
//         }else if(n%4==1){
//             for(int i=1;i<=(1+(n/4));i++){
//                 list.add(i);//System.out.print(i+" ");
//             }
//             for(int i=((n-(n/4))+1);i<=(n);i++){
//                 list.add(i);// System.out.print(i+" ");
//             }
//         }else if(n%4==3){
//             for(int i=1;i<=((n/4));i++){
//                 list.add(i);// System.out.print(i+" ");
//             }
//             for(int i=((n-(n/4)));i<=(n);i++){
//                 list.add(i); //System.out.print(i+" ");
//             }
//         }
//         if(n%4==0 || n%4==3){System.out.println(0);}
//         else{System.out.println(1);}
        
//         System.out.print(list.size()+" ");
//         for(int val:list){System.out.print(val+" ");}
//         System.out.println();
//     }
// }






    // public static int find(int a,int[] p){
    //     if(a!=p[a]){return p[a]=find(p[a], p);}
    //     else{return a;}
    // }
    // public static int findrank(int a,int[] p,int [] r){
    //     if(a!=p[a]){return findrank(p[a], p,r);}
    //     else{return r[a];}
    // }
    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
	// 	// int t = Integer.parseInt(br.readLine());
	// 	StringBuilder sb = new StringBuilder();
 
	// 	// while (t-- > 0) {
    //         String[] str = (br.readLine()).trim().split(" ");
    //         int n = Integer.parseInt(str[0]);
    //         int m=Integer.parseInt(str[1]);
    //         int[] parent=new int[n+1];
    //         int[] rank=new int[n+1];
    //         for(int i=0;i<=n;i++){parent[i]=i; rank[i]=1;}

    //         for(int i=0;i<m;i++){
    //             str = (br.readLine()).trim().split(" ");

    //             int k=Integer.parseInt(str[0]);

    //             for(int j=2;j<str.length;j++){
    //                 int a=Integer.parseInt(str[j-1]);
    //                 int b=Integer.parseInt(str[j]);
    //                 int la=find(a, parent),lb=find(b, parent);
    //                 if(la!=lb){
    //                     if(rank[la]<rank[lb]){int tmp=la; la=lb; lb=tmp;}

    //                     rank[la]+=rank[lb];
    //                     parent[lb]=la;
    //                 }
    //             }
    //         }

    //         for(int i=1;i<=n;i++){
    //             int ans=findrank(i,parent,rank);
    //             System.out.print(ans+" ");  //" r="+rank[i]+"  "
    //         }
    //         System.out.println();
    //     }
    // }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		// int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
 
// 		// while (t-- > 0) {
//             String[] str = (br.readLine()).trim().split(" ");
//             int n = Integer.parseInt(str[0]);
//             int m=Integer.parseInt(str[1]);
//             int k = Integer.parseInt(str[2]);
            
//             int[][] arr=new int[m][3];

//             for(int i=0;i<m;i++){
//                 str = (br.readLine()).trim().split(" ");
//                 arr[i][0]=Integer.parseInt(str[0]);
//                 arr[i][1]=Integer.parseInt(str[1]);
//                 arr[i][2]=Integer.parseInt(str[2]);
//             }
            
//             if(k==0){
//                 System.out.println(-1); 
//                 return;
//             }

//             boolean[] flr=new boolean[n+1];
//             str = (br.readLine()).trim().split(" ");
//             for(int i=0;i<k;i++){
//                 int idx=Integer.parseInt(str[i]);
//                 flr[idx]=true;
//             }

//             int ans=Integer.MAX_VALUE;

//             for(int i=0;i<m;i++){
//                 if((flr[arr[i][0]] && !flr[arr[i][1]]) || (!flr[arr[i][0]] && flr[arr[i][1]])){
//                     ans=Math.min(ans,arr[i][2]);
//                 }
//             }

//             if(ans==Integer.MAX_VALUE){
//                 System.out.println(-1);
//             }else{
//                 System.out.println(ans);
//             }
//         // }
//     }
// }



    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
	// 	int t = Integer.parseInt(br.readLine());
	// 	StringBuilder sb = new StringBuilder();
 
	// 	while (t-- > 0) {
    //         int n = Integer.parseInt(br.readLine());
    //         String str = (br.readLine()).trim();

    //         int cw=0,acw=0,bh=0;
    //         int ans=0;
    //         for(int i=0;i<n;i++){
    //             if(str.charAt(i)=='-'){
    //                 if(str.charAt(((i-1)+n)%n)==str.charAt(i)){
    //                     ans++;
    //                 }else{
    //                     ans+=2;
    //                 }
    //                 bh++;
    //             }else if(str.charAt(i)=='>'){
    //                 cw++;
    //             }else{
    //                 acw++;
    //             }
    //         }

    //         if(acw==n || cw==n || bh==n){
    //             System.out.println(n);
    //         }else if((acw+bh)==n || (cw+bh)==n){
    //             System.out.println(n);
    //         }else{
    //             System.out.println(ans);
    //         }
    //     }
    //     }

    // }


//      public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		// int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
 
// 		// while (t-- > 0) {
// 			String[] arrp = (br.readLine()).trim().split(" ");
           
//             int n = Integer.parseInt(arrp[0]);
//             int m= Integer.parseInt(arrp[1]);
            
//             String[] str = (br.readLine()).trim().split(" ");
//             int[] cost=new int[n+1];
//             for(int i=0;i<n;i++){
//                 cost[i+1]=Integer.parseInt(str[i]);
//             }
//             long ans=0;
//             for(int i=0;i<m;i++){
//                 str = (br.readLine()).trim().split(" ");

//                 int u=Integer.parseInt(str[0]);
//                 int v=Integer.parseInt(str[1]);
//                 ans+=Math.min(cost[u],cost[v]);
//             }

//             System.out.println(ans);
//         // }
//     }
// } 
    
//     public static long binexp(long a,long b){
//         long res=1;
//         while(b>0){
//             if((b&1)==1){
//                 res=res*a;  res=res%mod;
//             }
//             a=a*a; a=a%mod;
//             b>>=1;
//         }
//         return res;
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int n = Integer.parseInt(br.readLine());
//         // StringBuilder sb = new StringBuilder();
        
//         long fact=1;
//         for(int i=1;i<=n;i++){
//             fact=((long)(fact*(long)(i)));
//             fact=fact%mod;
//         }

//         long ump=binexp(2, n-1);//(long)(Math.pow(2, n-1));
//         ump=ump%mod;
//         long ans=fact-ump;
//         if(ans<0){ans+=mod;}
//         System.out.println(ans);
//     }
// }



    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
	// 	// int t = Integer.parseInt(br.readLine());
	// 	StringBuilder sb = new StringBuilder();
 
	// 	// while (t-- > 0) {
	// 		String[] arrp = (br.readLine()).trim().split(" ");
           
    //         int n = Integer.parseInt(arrp[0]);
    //         int m= Integer.parseInt(arrp[1]);
            
    //         boolean[] invalid=new boolean[n+1];
    //         for(int i=0;i<m;i++){
    //             String[] pr = (br.readLine()).trim().split(" ");
    //             int val=Integer.parseInt(pr[0]);
    //             invalid[val]=true;
    //             val=Integer.parseInt(pr[1]);
    //             invalid[val]=true;
    //         }
    //         int valid=-1;
    //         for(int i=1;i<=n;i++){
    //             if(!invalid[i]){valid=i; break;}
    //         }            

    //         System.out.println(n-1);
    //         for(int i=1;i<=n;i++){
    //             if(i!=valid){System.out.println(valid+" "+i);}
    //         }
    //     }
    // }



  //Q1  
//     static int mcost=0;
//     public static void dfs(ArrayList<ArrayList<Integer>> graph,int s,boolean[] visited,int[] cost){
//         mcost=Math.min(mcost,cost[s-1]);
//         visited[s]=true;
//         for(int nbr:graph.get(s)){
//             if(visited[nbr]==false){
//                 dfs(graph,nbr,visited,cost);
//             }
//         }
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		// int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
 
// 		// while (t-- > 0) {
// 			String[] arrp = (br.readLine()).trim().split(" ");
           
//             int n = Integer.parseInt(arrp[0]);
//             int m= Integer.parseInt(arrp[1]);
            
//             String[] strs = (br.readLine()).trim().split(" ");
//             int[] cost=new int[n];
//             ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
//             graph.add(new ArrayList<>());
//             for(int i=0;i<n;i++){
//                 cost[i]=Integer.parseInt(strs[i]);
//                 graph.add(new ArrayList<>());
//             }

            
//             for(int i=0;i<m;i++){
//                 arrp = (br.readLine()).trim().split(" ");
//                 int u = Integer.parseInt(arrp[0]);
//                 int v= Integer.parseInt(arrp[1]);

//                 (graph.get(u)).add(v);
//                 (graph.get(v)).add(u);
//             }

//             //dfs
//             boolean[] visited=new boolean[n+1];
//             long ans=0;
//             for(int i=1;i<=n;i++){
//                 if(visited[i]==false){
//                     mcost=Integer.MAX_VALUE;
//                     dfs(graph,i,visited,cost);
//                     ans+=mcost;
//                 }
//             }

//             System.out.println(ans);
//         // }
//     }
// }


