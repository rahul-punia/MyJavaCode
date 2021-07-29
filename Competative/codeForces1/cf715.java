import java.util.*;
import java.io.*;
import java.lang.*;

public class cf715 {
    //javac cf715.java

    public static long memo(int i,int j,long[][] dp,long[] arr){
    if(i==j)return 0;    
    //Or
    // if(j==i+1)   return arr[j]-arr[i];
    if(dp[i][j]!=-1)    return dp[i][j];

    return dp[i][j]=(arr[j]-arr[i]) + Math.min(memo(i+1,j,dp,arr),memo(i,j-1,dp,arr));
    }


    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

    //    while(t-->0){
        int n =Integer.parseInt(br.readLine());       //Long.parseLong(strs[i])
        String[] strs=(br.readLine()).trim().split(" "); 
        // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        // String str=(br.readLine()).trim();
		long[] arr=new long[n];
        // long mmax=Long.MIN_VALUE,mmin=Long.MAX_VALUE;

        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(strs[i]);
        }

        sort(arr);

        long[][] dp=new long[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }


        if(n==1){
            System.out.println(0);   
        }else{
            System.out.println(memo(0, n-1, dp,arr));
        }
        
    }

           
//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve();
     }
     public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        // int n =Integer.parseInt(br.readLine());       //Long.parseLong(strs[i])
        String[] strs=(br.readLine()).trim().split(" "); 
        int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        // String str=(br.readLine()).trim();
		
		
       }
    }
     
	//gcd
	public static long gcd(long a,long b){   //gcd using division method
        if(b==0)return a;
        else return gcd(b, a%b);
    }

	//check prime in root(n)
    public static int isprime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return i;
        }

        return -1;   //means n is prime
    }

	//SOE
	static  int[] sieve;
	public static void SOE(int n){
        sieve=new int[n+1];

        // System.out.println("All prime number from 1 to n:-");
        
        for(int x=2;x<=n;x++){
            if(sieve[x]!=0){  //Not prime number
                continue;
            }
            // System.out.print(x+"  ");
            for(int u=2*x;u<=n;u+=x){
                sieve[u]=x;
            }
        }

		//If  sieve[i]=0 means 'i' is primr else 'i' is not prime 
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


