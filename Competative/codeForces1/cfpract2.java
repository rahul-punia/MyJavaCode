
import java.util.*;
import java.io.*;
import java.lang.*;

public class cfpract2 {
    static int mod=10000_00007;
    static long oans=0,pw=0;
    static boolean fg=true;
    //Coding is like a game.
    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        int n =Integer.parseInt(br.readLine());       //Long.parseLong(strs[i])
        String[] strs=(br.readLine()).trim().split(" "); 
        int[] arr=new int[n];
        for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        boolean fg=true;
        int pmi=0;
        while(fg && pmi<n){
            int mi=pmi;

            for(int i=pmi;i<n;i++){
                if(arr[i]<arr[mi]){
                    mi=i;
                }
            }

            if(mi==pmi){pmi++;}
            else{
                int p1=0,p2=arr[pmi];
                for(int j=pmi+1;j<=mi;j++){
                    if(j==mi){ arr[pmi]=arr[mi]; }
                    p1=arr[j];
                    arr[j]=p2;
                    p2=p1;
                }
                pmi=mi;
            }
        }

        for(int val:arr){
            asb.append(val+" ");
        }
        asb.append("\n");
       }
       System.out.println(asb);
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
        // int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

       }
    }

    
    //binexp
    public static long binexp(long a,long b){
        if(b==0)return 1;

        long res=binexp(a, b/2);

        if(b%2==1){
            return (((res*res))*a);    //%mod;
        }else return (res*res);
    }
    //gcd
    public static long gcd(long a,long b){   //gcd using division method
        if(b==0)return a;
        else return gcd(b, a%b);
    }


    public static long isprime(long n){
        for(long i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return i;
        }

        return -1;
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



