import java.util.*;
import java.io.*;
import java.lang.*;

public class ecf108 {
    
   static ArrayList<ArrayList<Integer>> gp;
    
   public static int bfs(int a,int u,boolean[] vst1,int ci,int cd){
       if(ci==u){
           return cd;
       }
       vst1[ci]=true;

       for(int nb:gp.get(ci)){
           if(!vst1[nb]){
               int vl=bfs(a, u, vst1, nb, cd+1);
               if(vl>=0)return vl;
           }
       }

       return -1;
   }

    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
       
       while(t-->0){
        StringBuilder asb=new StringBuilder();
        ArrayList<Integer> lt=new ArrayList<>();
       
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),a=Integer.parseInt(strs[2]);//,s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();

        strs=(br.readLine()).trim().split(" ");
        int[] sn=new int[n];
        for(int i=0;i<k;i++){sn[i]=Integer.parseInt(strs[i]);}

        gp=new ArrayList<>();
        for(int i=0;i<=n;i++){
            gp.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            strs=(br.readLine()).trim().split(" ");

            int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
            gp.get(u).add(v);  gp.get(v).add(u);
        }


        //bfs
        // int max=
        int[] arr1=new int[n+1];
        int[] arr2=new int[n+1];
        Arrays.fill(arr1, n);
        
        for(int i=0;i<k;i++){
            int u=sn[i];    
            boolean[] vst1=new boolean[n+1];
            int fau=bfs(a,u,vst1,a,0);
            boolean[] vst=new boolean[n+1];
        
            Queue<Integer> q=new LinkedList<>();
            q.add(u);
            int lvl=0;

            while(q.size()>0){
                int sz=q.size();

                while(sz-->0){
                    int rem=q.remove();

                    lt.add(u);
                    if(vst[rem])continue;
                    vst[rem]=true;

                    

                    int dif=fau-lvl;
                    // asb.append(dif+" ");
                    if(dif>arr1[rem] || arr1[rem]==n){
                        arr1[rem]=dif;
                        arr2[rem]=u;
                    }
                    
                    for(int nbr:gp.get(rem)){
                        if(!vst[nbr]){ q.add(nbr); }
                    }
                }
                lvl++;
            }

        }

        // System.out.println(asb);
        for(int i=1;i<=n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i=1;i<=n;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();

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
        // int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}


       }
    }
	


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

