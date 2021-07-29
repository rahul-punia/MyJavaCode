
import java.util.*;
import java.io.*;
import java.lang.*;

public class cfpract {
    static int mod=10000_00007;

    static class comp implements Comparator<int[]>{
         public int compare(int[] a,int[] b){return b[1]-a[1];}
    }

    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),x=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        strs=(br.readLine()).trim().split(" ");
        int[] arr=new int[n];
        for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        sort(arr);

        int min=Integer.MAX_VALUE;

        int len=0,ans=0;
        for(int i=n-1;i>=0;i--){
            len++;
            min=Math.min(arr[i], min);

            if(x<=(min*len)){
                ans++;   min=Integer.MAX_VALUE;  len=0;
            }
        }

        System.out.println(ans);

       }
    }

    
  
    //******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve();
        // sec();
     }

     public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
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


    public static int isprime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
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


