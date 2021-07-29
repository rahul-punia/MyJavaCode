import java.util.*;
import java.io.*;
import java.lang.*;

public class cf673 {

//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();

//V.Imp problem
//Time Comp-  O(N+N)
//See Explaination on YouTube- https://www.youtube.com/watch?v=pcuJCmkktBE

public static void solve() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    
   while(t-->0){
    int n =Integer.parseInt(br.readLine());
    String[] strs=(br.readLine()).trim().split(" ");
    // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
    //  String str=(br.readLine()).trim();

    ArrayList<Integer> [] array=new ArrayList [n+1];//Stores indexes in front of values from 1 to n.
    for(int i=1;i<=n;i++){
        array[i]=new ArrayList<>();
    }

    int[] arr=new int[n];
    for(int i=0;i<n;i++){ arr[i]=Integer.parseInt(strs[i]);
        array[arr[i]].add((i+1));
    }

    int[] ans=new int[n+2];//for n+1   Index 6 out of bounds for length 6
    Arrays.fill(ans, (2*n));
    for(int i=1;i<=n;i++){ //min value possible
        int lidx=0;
        int mx=0;  //Decide 'k' i.e size of segemnt

        for(int idx:array[i]){
            mx=Math.max(mx, (idx-lidx));
            lidx=idx;
        }

        mx=Math.max(mx, ((n+1)-lidx)); //for (n+1)-0 we need 'n+2' size 'ans' array.
        ans[mx]=Math.min(ans[mx], i);  //min value possible for 'mx=K' size subarray
    }

    int min=n+n;
    for(int i=1;i<=n;i++){
        min=Math.min(min, ans[i]);  //v.imp bcz previous min value is valid for all greater size segments/subarrays
        if(min>n){ asb.append(-1+" "); }
        else{ asb.append(min+" ");  }
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
	
   
//******************************************************************************************************************** */

    public static long modInverse1(long a, long m){
        // int g = gcd(a, m);
        // if(g!=1) {System.out.println("Inverse Doesnot Exist");}  
        return binexp(a, m - 2, m);
       }
   
    public  static long binexp(long a, long b, long m){
        if (b == 0)return 1; 
            
        long res = binexp(a, b / 2, m);
        if (b % 2 == 1) return (( (res*res)%m )*a) % m;
        else return (res*res)%m;
    }

    //binexp
    public static long binexp(long a,long b){
        if(b==0)return 1;

        long res=binexp(a, b/2);

        if(b%2==1){
            return (((res*res))*a);
        }else return (res*res);
    }

    //Comparator Interface
    public static class comp implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
    }

	//gcd using Euclid's Division Algorithm  
    public static long gcd(long a,long b){   
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
 
	public static void print(long[] dp) {//Method Overloading
		for (long val : dp) {
			System.out.print(val + " ");
		}
		System.out.println();
	}  
    //2d print
	public static void print(long[][] dp) {//Method Overloading
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


