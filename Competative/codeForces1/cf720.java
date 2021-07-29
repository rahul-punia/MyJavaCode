import java.util.*;
import java.io.*;
import java.lang.*;

public class cf720 {
  
   
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
        long[] arr=new long[n];
        int midx=0;
        for(int i=0;i<n;i++){ arr[i]=Integer.parseInt(strs[i]);
            if(arr[i]<arr[midx]){
                midx=i;
            }
         }

        ArrayList<long[]> lt=new ArrayList<>();

       
        // asb.append(n-1);       asb.append("\n");
        System.out.println(n-1);
         for(int i=0;i<n;i++){
             if(i!=midx){
                System.out.println((i+1)+" "+(midx+1)+" "+(arr[midx]+Math.abs(i-midx))+" "+arr[midx]);  //v.imp
             }
         }
        }
    }

//          for(int i=n-2;i>=0;i--){
//              if(arr[i]>arr[i+1]){
//                 long mmin=Math.min(arr[i], arr[i+1]);
//                 arr[i]=mmin+1;  arr[i+1]=mmin;
//                 lt.add(new long[]{i+1,i+2,mmin+1,mmin});
//              }
//          }
//          asb.append(lt.size());       asb.append("\n");

//         for(long[] rr:lt){
//             asb.append(rr[0]+" "+rr[1]+" "+rr[2]+" "+rr[3]);       asb.append("\n");   
//         }
//         // System.out.println(Arrays.toString(arr));
//        }
//        System.out.println(asb);
// }
     


    //     if(n==2){
    //         long mmin=Math.min(arr[0], arr[1]);

    //         lt.add(new long[]{1,2,mmin,mmin+1});
    //     }else{
    //     int st=0,end=n-1;
    //     int ct=0;
    //     long p1=-1,p2=-1,p3=5;

    //     for(long i=arr[midx];i<=2000_000_000 && (p1==-1 || p2==-1 );i++){
    //         if(isprime(i)==-1){
    //             if(p1==-1){
    //                 p1=i;
    //             }else{
    //                 p2=i;
    //             }
    //         }
    //     }

    //     //swap
    //     if(midx!=(n-1)){
    //         long mp=0;
    //         if(midx%2==0){ mp=p1; }
    //         else{ mp=p2; }
    //         arr[end]=arr[midx];    arr[midx]=mp;  
    //         lt.add(new long[]{midx+1,end+1,arr[midx],arr[end]});
    //     }
        
    //     while(st<end){
    //         if(st==midx){st++;  continue; } 
            
    //         if(st%2==0){ arr[st]=p1; lt.add(new long[]{st+1,end+1,arr[st],arr[end]});}
    //         else{ arr[st]=p2; lt.add(new long[]{st+1,end+1,arr[st],arr[end]}); }

    //         st++;  
    //     }

    //     if(n>2 && arr[n-2]==arr[n-1] && n>2){ arr[n-1]=arr[n-3];lt.add(new long[]{n-3,n-1,arr[n-3],arr[n-1]}); }  
    // }

    //     asb.append(lt.size());       asb.append("\n");

    //     for(long[] rr:lt){
    //         asb.append(rr[0]+" "+rr[1]+" "+rr[2]+" "+rr[3]);       asb.append("\n");   
    //     }

    //    }
    //    System.out.println(asb);
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
    public static long isprime(long n){
        for(long i=2;i<=Math.sqrt(n);i++){
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


