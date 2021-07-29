import java.util.*;
import java.io.*;
import java.lang.*;


public class cf721 {
//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();

    static long mod=1000_000_007;

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
        int[] arr=new int[n];
        for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        sort(arr);
        // int ct0=0,ctp=0,ctn=0;
        int[] mins=new int[n];
        int[] Abarr=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            Abarr[i]=Math.abs(arr[i-1]-arr[i]);
            min=Math.min(min, Abarr[i]);
            mins[i]=min;
            // if(arr[i]>0){ctp++;}
            // else if(arr[i]<0){ctn++;}
            // else{ ct0++; }
        }

        int ans=1;
        for(int i=n-1;i>0;i--){
            if(mins[i]>=arr[i]){ans=i+1;  break;}
        }
        // int ans=ct0+ctn;
        // if(ctp>0 && ct0<2){ans++;}

            asb.append(ans);    asb.append("\n");
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
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        int[] arr=new int[n];

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);
        hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
     }

     long ans=1;
     boolean fg=false;
        for(int key:hm.keySet()){
            long ct=(long)(hm.get(key));
            long len=(long)((n-ct)+1);

            long vv=((ct)*(ct-1))/2;

            if(vv>0 && ct>0){ fg=true;
                ans=ans*(vv*len);
            }
            
        }
        if(!fg){ ans=0;}
        asb.append(ans);  asb.append("\n");
       }
       
         System.out.println(asb);
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

