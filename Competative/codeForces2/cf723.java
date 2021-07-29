import java.util.*;
import java.io.*;
import java.lang.*;


public class cf723 {
//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();
    static long mod=1000_000_007;

    //Must Do dry Run Before submitting soln. and think also about corner testcases will be passed or not.
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
        int[] arr=new int[2*n];
        for(int i=0;i<(2*n);i++){arr[i]=Integer.parseInt(strs[i]);}

        sort(arr);

        int[] ans=new int[2*n];

        int j=0;
        for(int i=0;i<2*n;i+=2){
            ans[i]=arr[j++];
        }

        for(int i=1;i<2*n;i+=2){
            ans[i]=arr[j++];
        }

        for(int i=0;i<2*n;i++){
            asb.append(ans[i]+" ");
            // System.out.print(ans[i]+" ");
        }

        asb.append("\n");
        // System.out.println();
         }

         System.out.println(asb);
    }
	

    public static boolean recursion(long n,long[] arr,int ci){
        if(n==0)return true;

        for(int i=ci;i<arr.length;i++){
            long nn=(n%arr[i]);
            boolean res=recursion(nn, arr, i+1);
            if(res)return true;
        }

        return false;
    }

    public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		long[] arr={11111_11111,111111111,11111111,1111111,111111,11111,1111,111,11};

       while(t-->0){
        long x =Long.parseLong(br.readLine());
        boolean res=false;
            // long nx=x%11;

            for(int d=0;d<11 && x>=0;d++){
                if(x%11==0){res=true;  break;}
                x-=111;
            }
        
        if(res){asb.append("YES");}
        else{ asb.append("NO"); }

        asb.append("\n");
       }

       System.out.println(asb);
    }
	
   
    public static void solve3() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
        //USING THE CONCEPT OF MINIMUM REFUELING STOPS

        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){ arr[i]=Integer.parseInt(strs[i]);}


        //Method-1 Using two variables with PQ
        // PriorityQueue<Long> pq=new PriorityQueue<>();
        // int ans=0;
        // long pos=0,neg=0;
        // for(int i=0;i<n;i++){

        //     if(arr[i]>=0){
        //         pos+=arr[i];  ans++;
        //     }else{
        //         if(pos>=(neg+Math.abs(arr[i]))){
        //             pq.add(arr[i]);  ans++;  neg+=Math.abs(arr[i]);
        //         }else{
        //             if(pq.size()>0 && pq.peek()<arr[i]){
        //                 neg=neg-Math.abs(pq.remove())+Math.abs(arr[i]);
        //                 pq.add(arr[i]);
        //             }
        //         }
        //     }
        // }


        //Method-2 1variable csum with PQ   ===>    Easy To Remember and Implement
        PriorityQueue<Long> pq=new PriorityQueue<>();
        int ans=0;
        int i=0;    
        long csum=0;    

        while(i<n){

            if(csum<0){
                if(!pq.isEmpty()){
                    csum-=pq.remove();  ans--;
                }
            }else{
                csum+=arr[i];  ans++;
                if(arr[i]<0){
                    pq.add(arr[i]);
                }
                i++;
            }
        }

        if(csum<0){ans--;}
        // asb.append(ans)
        System.out.println(ans);
    //    }
    }

//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve3();
     }

     public static void solve4() throws Exception{
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

