import java.util.*;
import java.io.*;
import java.lang.*;

public class cf714 {

//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> list=new ArrayList<>();
//HashSet<Integer> hs=new HashSet<>();
//Stack<Integer> st=new Stack<>();
//Queue<Integer> q=new LinkedList<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
// static ArrayList<ArrayList<Integer>> gp=new ArrayList<>();
//int[] arr=new int[n];
//1 hr- atlst 2 qs d-2
//Mt_do 3 qs d-2  
//Mt_do 4 qs d-3

//StringBuilder sb=new StringBuilder();

static long mod=1000000007;


public static long fact(long n){

    long ans=1;

    for(long i=1;i<=n;i++){
        ans=(ans*i)%mod;
    }
    return ans;
}

public static void solve() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
   
   while(t-->0){
    int n =Integer.parseInt(br.readLine());
    String[] strs=(br.readLine()).trim().split(" ");
    // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
    //  String str=(br.readLine()).trim();
        int[] arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strs[i]);
        }

        // sort(arr);

        int[] pre=new int[n];
        int[] suf=new int[n];

        pre[0]=arr[0];  suf[n-1]=arr[n-1];

        for(int i=1;i<n;i++){
            pre[i]=(arr[i] & pre[i-1]);
        }

        for(int i=n-2;i>=0;i--){
            suf[i]=(suf[i+1] & arr[i]);
        }

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }

        HashMap<Integer,Integer> shm=new HashMap<>();
        // ArrayList<Integer> list=new 

        long ans=0;
        // long ct=1;

        for(int i=0;i<n-1;i++){
            shm.put(arr[i], shm.getOrDefault(arr[i], 0)+1);
            // if(i>0 && arr[i]==arr[i-1]){
            //     ct++;
            // }else{ct=1;}

            if(pre[i]==suf[i+1]){
                System.out.println(i+"  "+pre[i]+"  "+suf[i+1]);
                 long f1=fact(i+1);
                 long f2=fact(n-(i+1));
                

                //  for(int key:hm.keySet()){
                //      long fq=hm.get(key);
                //      long ct=shm.getOrDefault(key, 0);

                //      f1=f1/fact(ct);
                //     f2=f2/fact(fq-ct);
                //     //  if(key<arr[i]){
                //     //      f1=f1/fact(fq);
                //     //  }else if(key>arr[i]){
                //     //     f2=f2/fact(fq-ct);
                //     // }else{
                //     //     f1=f1/fact(ct);
                //     //     f2=f2/fact(fq-ct);
                //     // }
                //  }

                 ans=(ans+(f1*f2)%mod)%mod;  // ans=(ans+f2)%mod;  
                 System.out.println(ans);
            }

        }

        System.out.println(ans);
   }
}

//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve3();
     }

     public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        
        long[] arr=new long[200500];

        for(int i=0;i<10;i++){arr[i]=1;}

        for(int i=10;i<200500;i++){
            arr[i]=arr[i-10]+arr[i-9];  arr[i]=arr[i]%mod;
        }
        
        StringBuilder sb=new StringBuilder();

       while(t-->0){
       
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
         String st=(strs[0]).trim();
         long m=Long.parseLong(strs[1]);
            long ans=0;

            char[] str=st.toCharArray();

            for(char ch:str){
                long tt=ch-'0';
                ans=ans+arr[(int)(tt+m)];
                ans+=mod;  ans%=mod;
            }
            sb.append(ans);
            sb.append("\n");
            // System.out.println(ans);
        }

        System.out.println(sb);
    }
    //sort
     public static void sort(long[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			long temp = arr[i];  arr[i] = arr[idx];  arr[idx] = temp;  //swap
		}
		Arrays.sort(arr);
	}
    public static void solve3() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        
       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        long[] arr = new long[n];
        long ans = 0, count = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(strs[i]);
            if (i == 0) {
                ans = arr[i];
            } else {
                ans = (ans & arr[i]);
            }
        }
    
    
        for (long ele : arr) {
            if (ele == ans)
                count++;
        }
    
    
        if (count < 2) {
            sb.append("0");
        } else {
            
            long res = (count * (count - 1)) % mod;
            //fact(n-2)
            for (long i = 1; i < n-1; i++) {
                res = (res * i)%mod;
            }
            sb.append(res);
        }
    
    
    
        // long[] suff = new long[n];
        // suff[n - 1] = arr[n - 1];
        // for (int i = n - 2; i >= 0; i--) {
        //     suff[i] = suff[i + 1] & arr[i];
        // }
        // for (int i = 0; i < n - 1; i++) {
        //     ans = 1;
        // }
        sb.append("\n");
        }
    
        System.out.println(sb);
    }
	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			int temp = arr[i];  arr[i] = arr[idx]; arr[idx] = temp;  //swap
		}
		Arrays.sort(arr);
	}
    //1d print
    public static void print(int[] dp) {
		for (int val : dp) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
 
	public static void print(long[] dp) {
		for (long val : dp) {
			System.out.print(val + " ");
		}
		System.out.println();
	}  
    //2d print
	public static void print(long[][] dp) {
		for (long[] a : dp) {
			for (long val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
 
	public static void print(int[][] dp) {
		for (int[] a : dp) {
			for (int val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
 
	
}
