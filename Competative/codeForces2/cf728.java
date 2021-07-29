import java.util.*;
import java.io.*;
import java.lang.*;


public class cf728 {
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
        int n =(int)Long.parseLong(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}


           int ans=0;
           int[] arr=new int[n+1];

           for(int i=1;i<=n;i++){
               arr[i]=i;
           }

           if(n%2==1){
            
            for(int i=1;i<=(n-3);i+=2){
                int tp=arr[i];  arr[i]=arr[i+1];  arr[i+1]=tp;
           }

           
            for(int i=n-2;i<n;i++){
                arr[i]=i+1;
            }
            arr[n]=n-2;
            }else{
               ans=n;

               for(int i=1;i<=n;i+=2){
                    int tp=arr[i];  arr[i]=arr[i+1];  arr[i+1]=tp;
               }
           }

        //    System.out.println(ans);

           for(int i=1;i<=n;i++){
              asb.append(arr[i]+" ");
            }

            asb.append("\n");
         }

         System.out.println(asb);
    }
	

//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve2();
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
        long[][] arr=new long[n+1][2];
        ArrayList<int[]> list=new ArrayList<>();
        // list.add(new int[]{0,0});
        for(int i=1;i<=n;i++){arr[i][0]=Integer.parseInt(strs[i-1]);  arr[i][1]=i;
            // list.add(new int[]{arr[i][0],arr[i][1]});
        }

        
        // long ans=0;
        // for(int j=2;j<=n;j++){
        //      int i=arr[j]-(j%arr[j]);
        
        //      if(i>0 && i<j && (arr[i]*arr[j])==(i+j) ){
        //          ans++;
        //      }
        // }


        //Method-1  TLE
        // long ans=0;
        //Arrays.sort(arr,(a,b)->a[0]-b[0]);   //o(n^2)  TLE      use quicksort  
        // Collections.sort(list,(a,b)->a[0]-b[0]);    // o(nlogn)   use mergesort  TLE
        // sortComp(arr);    //o(nlogn)    TLE
        
        // for(int i=0;i<=n;i++){
        //     // int[] pr=list.get(i);
        //     // arr[i][0]=pr[0];  arr[i][1]=pr[1];
        //     // System.out.print(arr[i][0]+" ");
        // }
        
        // for(int i=1;i<=n;i++){
        //     for(int j=i+1;j<=n;j++){
        //         long prod=arr[i][0]*arr[j][0];

        //         if(prod>(2*n))break;

        //         long sum=arr[i][1]+arr[j][1];

        //         if(sum==prod){ans++;}
        //     }
        // }

        //Method-2
        // long ans=0;     
        // HashSet<String> hs=new HashSet<>();    
        // for (long i = 1; i <= n; i++) {
		// 	long x = arr[(int)i][0];
		// 	for (long j = x; j <= 2 * n; j += x) {
		// 		long c = j;
		// 		c -= i;
		// 		if (c >= 1 && c <= n && c != i) {
		// 			if ((arr[(int)c][0]*arr[(int)i][0]) == (i + c)) {
        //                 long min=Math.min(c,i),   max=Math.max(c,i);  hs.add(min+"$"+max);
		// 				// hs.insert(mp(min(c, i), max(c, i)));
		// 			}
		// 		}
		// 	}
		// }
        // ans=hs.size();

        //Method-3  TLE
        long ans=0;
        for (int i = 1; i <= n; i++) {

            for(int j=i+1;j<=n;j++){
                long prod=arr[i][0]*arr[j][0];

                if(prod==(i+j)){
                    ans++;
                }
            }
        }

        asb.append(ans+"\n");

    }

       System.out.println(asb);
    }





//     bool cmp(pair<lli,lli> a,pair<lli,lli> b)
// {
//     return a.fi<b.fi;
// }
 
// void solve()
// {
//     lli n;
//     cin>>n;
//     vector<pair<lli,lli>> vp;
//     for(lli i=0;i<n;i++)
//     {
//         lli x;
//         cin>>x;
//         vp.push_back({x,i+1});
//     }
//     sort(vp.begin(),vp.end(),cmp);
//     lli ans=0;
//     for(lli i=0;i<n;i++)
//     {
//         for(lli j=i+1;j<n;j++)
//         {
//             lli x=vp[i].fi*vp[j].fi;
//             if(x>2*n)
//                 break;
//             //cout<<x<<" ";
//             lli y=vp[i].se+vp[j].se;
//             if(x==y) ans++;
//         }
//     }
//     cout<<ans<<endl;
// }



	
    public static void solve3() throws Exception{
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
    public static void sortComp(int[][] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			int temp = arr[i][0];  arr[i][0] = arr[idx][0]; arr[idx][0] = temp;  //swap
             temp = arr[i][1];  arr[i][1] = arr[idx][1]; arr[idx][1] = temp;   //mymistake
		}
		Arrays.sort(arr,(a,b)->(a[0]-b[0]));
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

