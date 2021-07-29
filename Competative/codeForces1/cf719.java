import java.util.*;
import java.io.*;
import java.lang.*;

public class cf719 {

    public static void guess() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        Scanner scn=new Scanner(System.in);
        // int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
        boolean fg=true;

       long lo=1 ,hi=1000_000; 
       long ans=1;
       long ct=0;
       boolean mfg=true;
       while(lo<hi && ct<25){
           ct++;
            long mid=lo+(long)((hi-lo)/2);
            System.out.println(mid);
            if(!scn.hasNextLine()){ fg=false;  break;}
            String strs=scn.nextLine();
            
            if(strs.equals(">=")){
                lo=mid; ans=mid;  mfg=true;
            }else if(strs.equals("<")){
                hi=mid-1;   mfg=false;  ans=hi;
            }
        
     }
    //  if(!mfg){}
     System.out.println("! "+ans);
    }
	
      public static int query(int l,int r) throws Exception{
          if(l>r)return -1;

          InputStreamReader ip=new InputStreamReader(System.in);
          BufferedReader br = new BufferedReader(ip);
          
          System.out.println("? "+l+" "+r);
          int ans=Integer.parseInt(br.readLine());

          return ans;
      }

     
   
//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        guess();
     }

     public static void solve3() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        
        //Rearrange Given Expression-   a𝑗−a𝑖=𝑗−𝑖    =>  aj-j == ai-i
        int[] arr=new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<n;i++){ arr[i]=Integer.parseInt(strs[i]);
        hm.put((arr[i]-i), hm.getOrDefault((arr[i]-i), 0)+1); }

        
        long ans=0;
        for(int key:hm.keySet()){
            long ct=hm.get(key);
            ans+=(ct*(ct-1))/2;
        }
        
        // System.out.println(ans+" ct "+ct);
        System.out.println(ans);
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

