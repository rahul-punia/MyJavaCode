import java.util.*;
import java.io.*;
import java.lang.*;


public class cf111 {
//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();
    static long mod=1000_000_007;

    //Must Do dry Run Before submitting soln. and think also about corner testcases will be passed or not.
    public static void solve1() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        int s =(int)Long.parseLong(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        int ans=1;
        int cs=1;
        int add=3;
           while(cs<s){

             if((cs+add)<=s){
                 cs+=add; add+=2; ans++;
             }else{
                ans++; break;
             }
           } 

           asb.append(ans+"\n");
         }

         System.out.println(asb);
    }

//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve3();
     }

     public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),a=Integer.parseInt(strs[1]),b=Integer.parseInt(strs[2]);//,s=Integer.parseInt(strs[3]);
         String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

          char c1=str.charAt(0),  cn=str.charAt(n-1);
          
          HashMap<Integer,Integer> hm=new HashMap<>();
          ArrayList<Integer> lt0=new ArrayList<>();
          ArrayList<Integer> lt1=new ArrayList<>();
            
          int fq=0;
          boolean val=true; //1
          for(int i=0;i<n;i++){
              char ch=str.charAt(i);

              if(i==0){
                //  fq++;
                 if(ch=='0'){val=false;}
              }

              if(ch=='1' && !val){
                 lt0.add(fq);  val=!val;  fq=0;
              }else if(ch=='0' && val){
                lt1.add(fq);  val=!val;  fq=0;
             }

             fq++;
          }

          if(!val){
            lt0.add(fq);  val=!val;  fq=1;
         }else if(val){
           lt1.add(fq);  val=!val;  fq=1;
        }

        long ans=0;
        if(a>=0 && b>=0){
            ans=((long)n*(long)a)+((long)n*(long)b);
        }else if(a<0 && b>=0){
            ans=((long)n*(long)a)+((long)n*(long)b);
        }else if(a>=0 && b<0){
            int min=Math.min(lt0.size(),lt1.size());
            ans=((long)n*(long)a)+((long)(min+1)*(long)b);
        }else if(a<0 && b<0){
            int min=Math.min(lt0.size(),lt1.size());
            ans=((long)n*(long)a)+((long)(min+1)*(long)b);
        }


          
        //   int ans=0;
        //   int fg=-1; 
          
        //   if(c1=='1' && cn=='1'){
        //       fg=1;
        //   }else if(c1=='0' && cn=='0'){
        //     fg=0;
        //  }


            asb.append(ans+"\n");
         }

         System.out.println(asb);
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
        int[] arr=new int[n];

        int mdiff=n;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++){ 
            arr[i]=Integer.parseInt(strs[i]);

            int li=hm.getOrDefault(arr[i], -1);
            if(li>-1){ mdiff=Math.min(mdiff, (i-li)); }
            hm.put(arr[i], i);
        }

        long nn=n;
        long ans=(nn*(nn+1))/(long)2 ;

        if(mdiff<n){
            long el=nn-(mdiff);  

            long sub=(el*(el+1))/(long)2;
            sub-=(el);

            if(mdiff>1){ sub--; }

            if(sub>0){ ans-=sub; }
        }
        // for(int ky:hm.keySet()){
        //     int f=hm.get(ky);
        //     if(f>1){
        //         ans-=(nn-2);
        //     }
        // }

            asb.append(ans+"\n");

         }

         System.out.println(asb);
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

