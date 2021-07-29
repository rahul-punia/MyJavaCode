import java.util.*;
import java.io.*;
import java.lang.*;




public class cfpract3 {
     
    class bicycle{
        int tyre,brake,speed,cost;
    }
    static int mod=10000_00007;
    static long oans=0,pw=0;
    static boolean fg=true;
    //Coding is like a game.

    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

    //    while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        
        strs=(br.readLine()).trim().split(" ");
        long[] arr=new long[n];
        for(int i=0;i<n;i++){   arr[i]=Integer.parseInt(strs[i]);   }

        int d=1;

        long[] dp=new long[n];
        int cm=0;

        // Arrays.sort(arr,(a,b)->b-a);

        for(int i=0;i<n;i++){
            if(cm==(m+1)){
                d++;   cm++;
            }

            // dp[i]=
        }

    //    }
    }

    public static void solve4() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        int[] arr=new int[4*n];

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<4*n;i++){arr[i]=Integer.parseInt(strs[i]); hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1); }

        boolean fg=true;

        int[] arr1=new int[2*n];//l,b
        int l=0;
        for(int key:hm.keySet()){
            int fq=hm.get(key);
            if(fq%2==1){fg=false; break;  }
            else{
                for(int r=0;r<(fq/2);r++){
                    arr1[l++]=key;
                }
            }
        }

        if(!fg){
            System.out.println("NO");
        }else{
            sort(arr1);

            long pa=-1;

            int le=0,rt=(2*n)-1;

            while(le<rt){
                long ar=arr1[le]*arr1[rt];  
                if(ar!=pa && pa!=-1){
                    fg=false;  break;
                }
                pa=ar;  le++; rt--;
            }

            if(!fg){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }

       }
    }
	
    public static void euler(int n) {
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0){
                    n /= i;
                }
                    
                result -= result / i;
                System.out.println(result+"  "+n+"  i= "+i);
            }
        }
        if (n > 1)
            result -= result / n;
        

      System.out.println(result);      
    }


    public static long high(long n,long k){
        long s1=((n)*(n+1))/2;   long s2=((n-k)*((n-k)+1))/2;
        return s1-s2;
    }
    public static long low(long k){
        long s1=((k)*(k+1))/2;   
        return s1;
    }
  //  It is easy to show that if we choose 𝑘 numbers from a permutation of length 𝑛, then the minimum sum of 𝑘 numbers is 𝑘(𝑘+1)2, 
  //the maximum sum is 𝑘(2𝑛+1−𝑘)2 and any sum between them is achievable 
  //(that is, you can choose exactly 𝑘 numbers from 𝑛 so that their sum is equal to the desired one).

  
    public static void solve10() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        int[] ans=new int[n+1];
        HashSet<Integer> hs=new HashSet<>();
        int k=(r-l)+1;
        for(int i=n;i>=1 && k>0;i--){
            if(high(i, k)>=s && (s-i)>=low(k-1)){
              s-=i; hs.add(i); k--;
            }
        }

        

        if(k!=0){
            asb.append("-1");
        }else{
            int pt=l;
            for(int vl:hs){ans[pt++]=vl;}
            int cnt=1;
            for(int i=1;i<=n;){
                if(i>=l && i<=r){ i++; continue;}

                if(hs.add(cnt)){
                    ans[i]=cnt;  i++; cnt++;
                }else{
                    cnt++;
                }
            }

            for(int i=1;i<=n;i++){
                asb.append(ans[i]+" ");
            }
        }

        asb.append("\n");
       }

       System.out.println(asb);
    }

  

    public static void solve11() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // int[] arr=new int[n];
        // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        if(n%2==1){

            for(int i=1;i<=n;i++){

                for(int j=i+1;j<=n;j++){

                    if((j-i)<=(n/2)){
                       asb.append(1+" ");// System.out.print(1+" ");
                    }else{
                        asb.append(-1+" ");// System.out.print(-1+" ");
                    }
                }
            }
        }else{

            for(int i=1;i<=n;i++){
                for(int j=i+1;j<=n;j++){
                    if((j-i)<(n/2)){
                        asb.append(1+" ");//  System.out.print(1+" ");
                    }else if((j-i)==(n/2)){
                        asb.append(0+" ");// System.out.print(0+" ");
                    }else{
                        asb.append(-1+" ");// System.out.print(-1+" ");
                    }
                }
            }
        }
        // System.out.println();
        asb.append("\n");
       }
       System.out.println(asb);
    }

    

    public static void solve12() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        int[] xcor=new int[n];
        int[] ycor=new int[n];

        for(int i=0;i<n;i++){
            String[] strs=(br.readLine()).trim().split(" ");
            xcor[i]=Integer.parseInt(strs[0]);  ycor[i]=Integer.parseInt(strs[1]);
        }

        sort(xcor);  sort(ycor);

        long xcnt=(xcor[n/2]-xcor[(n-1)/2]) +1;
        long ycnt=(ycor[n/2]-ycor[(n-1)/2]) +1;

        long ans=xcnt*ycnt;
        asb.append(ans);   asb.append("\n");
       }
       System.out.println(asb);
    }

    public static void solve13() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        int[] arr=new int[n];
        strs=(br.readLine()).trim().split(" ");
        for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}

        int p=n-1;
        double ans=1.0;  //failure probability
        while(p>=0 && arr[p]==(p+1)){
            p--;
        }

        if(p==-1){
            ans=0.0;
            for(int i=0;i<m;i++){
                strs=(br.readLine()).trim().split(" ");
            }
        }else{

            for(int i=0;i<m;i++){
                strs=(br.readLine()).trim().split(" ");
                double ri=Integer.parseInt(strs[0]);  double pb=Double.parseDouble(strs[1]);

                if(ri>=(p+1)){
                    ans=ans*(1-pb);  //failure probability
                }
            }
        }

        asb.append((1.0-ans));   asb.append("\n");
       }
       System.out.println(asb);
    }

    //******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        solve13();
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


    public static long isprime(long n){
        for(long i=2;i<=Math.sqrt(n);i++){
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
	public static void print(long[][] dp) {  //Method Overloading
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



