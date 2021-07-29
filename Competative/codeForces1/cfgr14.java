import java.util.*;
import java.io.*;
import java.lang.*;

public class cfgr14 {

    //my soln- (nlogn)  due to sorting but It can be solved in O(n) without sorting using array storing frequency of color at color index
    public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]);//,s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        strs=(br.readLine()).trim().split(" ");
        // int[] arr=new int[n];

        ArrayList<Integer> lft=new ArrayList<>(n);
        ArrayList<Integer> rt=new ArrayList<>(n);
        
        for(int i=0;i<l;i++){ lft.add(Integer.parseInt(strs[i])); }

        for(int i=l;i<n;i++){
            rt.add(Integer.parseInt(strs[i]));
        }
        // System.out.println(t+" t "+lft.size()+"   "+rt.size());

        Collections.sort(lft);
        Collections.sort(rt);

        
        int ls=lft.size() ,rs=rt.size();

        ArrayList<Integer> lft1=new ArrayList<>(n);
        ArrayList<Integer> rt1=new ArrayList<>(n);
        
        //add 0
        int i=0,j=0;
        while(i<ls && j<rs){
            while(i<ls && j<rs && lft.get(i)<rt.get(j)){
               lft1.add(lft.get(i)); i++;  
            }

            while(i<ls && j<rs && lft.get(i)>rt.get(j)){
                rt1.add(rt.get(j)); j++;
            }

            while(i<ls && j<rs && lft.get(i)==rt.get(j)){
                i++; j++;
            }
            
        }

        while(i<ls){
            lft1.add(lft.get(i)); i++;  
         }

         while(j<rs){
            rt1.add(rt.get(j)); j++;
        }
        // System.out.println(lft1); System.out.println(rt1);
        //add1
        // Collections.sort(lft1);
        // Collections.sort(rt1);  
        // ArrayList<Integer> lft2=new ArrayList<>();
        // ArrayList<Integer> rt2=new ArrayList<>();
        long ans=0;
        int cnt=1;
        int lrm=0;
        int lft1sz=lft1.size() ,rt1sz=rt1.size();
        
        for(int ii=1;ii<lft1sz;ii++){
            if(lft1.get(ii-1)==lft1.get(ii)){
                cnt++;
            }else{  
                ans+=((cnt/2)*1);   lrm+=((cnt/2)*2);   cnt=1;
            }
        }

        // System.out.println(ans);
        ans+=((cnt/2)*1);   lrm+=((cnt/2)*2);   cnt=1;
        // System.out.println(ans);

        int rrm=0;
        cnt=1;
        for(int ii=1;ii<rt1sz;ii++){
            if(rt1.get(ii-1)==rt1.get(ii)){
                cnt++;
            }else{  
                ans+=((cnt/2)*1);   rrm+=((cnt/2)*2);  cnt=1;
            }
        }

        // System.out.println(ans);
        ans+=((cnt/2)*1);   rrm+=((cnt/2)*2);  cnt=1;
        // System.out.println("Ans= "+ans+"  lrm="+lrm+"  rrm="+rrm);

        int lremain=lft1sz-lrm;
        int rremain=rt1sz-rrm;
        
        int com=Math.min(lremain,rremain);
        ans+=(com*1);

        int lastr=Math.max(lremain, rremain)-com;
        ans+=(2*(lastr/2));

        
        int v5=rrm;
        if(lft1sz>rt1sz){
            v5=lrm;
        }



        int mmax=Math.max(lft1sz, rt1sz),  mmin=Math.min(lft1sz, rt1sz);

        // System.out.println(mmax +"    "+mmin);

        int my=( ((mmax-mmin)-v5)>0?( 2*(((mmax-mmin)-v5)/2) )+(v5/2)  :  (mmax-mmin)/2 );
        long fct=mmin   + my;
        //(v5/2+(mmax-mmin-(v5/2)))
        // System.out.println("fct  "+fct+"   "+my);
        ans=Math.min(ans,fct);

        asb.append(ans);
        asb.append("\n");   
       }

       System.out.println(asb);
    }
	
   
//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve2();
     }

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
