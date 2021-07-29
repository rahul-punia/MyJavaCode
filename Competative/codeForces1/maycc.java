
import java.util.*;
import java.io.*;
import java.lang.*;

public class maycc {
//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();

static long mod=1000_000_007;

// for(int i=0;i<pf.size();i++){
//     long v1=pf.get(i); //long cnt=last/v1;   ans+=(cnt*pf.get(i));  tcnt+=cnt;
    
//     if(v2>v1){
//         long fp=((v2-3)/2)+1;  long freq2=(last-fp)/v2;
//         ans+=(freq*v1);  tcnt-=freq2;
//     }
//     long fp=((v1-3)/2)+1;  long freq=(last-fp)/v1;
//     ans+=(freq*pf.get(i));  tcnt+=freq;
//     for(int j=i+1;j<pf.size();j++){
//         long v2=gcd/pf.get(j);
//         int val=pf.get(i)*pf.get(j);
//         long cnt=last/val;   ans+=(cnt*val);  tcnt+=cnt;
//     }
// }


public static void msolve() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    
   while(t-->0){
    // int n =Integer.parseInt(br.readLine());
    String[] strs=(br.readLine()).trim().split(" ");
    int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
    
    // HashMap<Integer,Integer> hm=new HashMap<>();

    // int max=0;
    long ans2=0;
    int[] arr=new int[n+1];
    Arrays.fill(arr, 1);
    for(int b=2;b<=n;b++){
        int a=m%b;  // max=Math.max(max, mod);    hm.put(b, mod);
        ans2+=arr[a];
       
        for(int fa=a;fa<=n ;fa+=b){  //&& fa<b
            arr[fa]++;
        }
    }

    System.out.println(ans2);

    }
}
public static void solve4() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    
   while(t-->0){
    long k =Integer.parseInt(br.readLine());
    // String[] strs=(br.readLine()).trim().split(" ");
    // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
    //  String str=(br.readLine()).trim();
    // int[] arr=new int[n];
    // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}
    long rsum=0;
    for(int i=1;i<=(2*k);i++){   
        long p1=(i*i)+k;   long p2=((i+1)*(i+1)) + k;
        long gcd= gcd(p1,p2);
        rsum=(rsum+gcd)%mod;   
    } 
    asb.append(rsum);  asb.append("\n");
   }
   System.out.println(asb);
}


static ArrayList<ArrayList<Integer>> gp=new ArrayList<>();
static long[] dp;
static long[] tot;
public static void dfs(int cur,boolean[] vst){
    dp[cur]=1;  tot[cur]=1;
    long sum=0,cnt=0;

    for(int nbr:gp.get(cur)){
        if(!vst[nbr]){
            vst[nbr]=true;
            dfs(nbr, vst);
            dp[cur]+=(2*dp[nbr])%mod;    dp[cur]=dp[cur]%mod;   cnt++;
            tot[cur]+=tot[nbr];         tot[cur]=tot[cur]%mod;
            tot[cur]+=dp[nbr];          tot[cur]=tot[cur]%mod;
            sum+=dp[nbr];
            vst[nbr]=false;
        }
    }


    for(int nbr:gp.get(cur)){
        if(!vst[nbr]){
            vst[nbr]=true;
            tot[cur]+=(dp[nbr]*((sum-dp[nbr]+mod)%mod))%mod;
            tot[cur]=tot[cur]%mod;
            vst[nbr]=false;
        }
    }
}


public static void solve6() throws Exception{
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
    gp=new ArrayList<>();
    for(int i=0;i<=n;i++){
        gp.add(new ArrayList<>());
    }

    for(int i=0;i<n-1;i++){
        String[] strs=(br.readLine()).trim().split(" ");
        int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
        gp.get(u).add(v);   gp.get(v).add(u);
    }
       
    dp=new long[n+1];  tot=new long[n+1];
    boolean[] visited=new boolean[n+1];
    visited[1]=true;
    dfs(1,visited);
    long ans=tot[1]%mod;

    System.out.println(ans);
   }
}


static int[] spf;
public static void sieve(int n){
        spf=new int[n+1];

        for(int i=1;i<=n;i++){
            spf[i]=i;
        }

        for(int i=4;i<=n;i+=2){
            spf[i]=2;
        }

        for(int i=3;i<=n;i++){
            if(spf[i]==i){
                long pd=(long)(i)*(long)(i);
                if(pd>(long)(n)){continue;}

                for(long j=(long)(i)*(long)(i);j<=(long)n && j>=0;j+=i){
                    if(spf[(int)j]==(int)j){  spf[(int)j]=(int)i; }
                }
            }
        }

}

public static ArrayList<Integer> primefactorize(int x){
    ArrayList<Integer> ans=new ArrayList<>();
    while(x!=1){
        ans.add(spf[x]);
        x=x/spf[x];
    }

    return ans;
}

public static void solvefnl() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    sieve(1000_0000);

   while(t-->0){
    long k =Integer.parseInt(br.readLine());
    long last=(2*k);
    long al=(last*last)+k,   al1=((last+1)*(last+1))+k;
    int gcd=(int)(gcd(al, al1));

    ArrayList<Integer> pf=primefactorize(gcd);

    long ans=0;
    long tcnt=0;

    Collections.sort(pf);
    System.out.println(pf);
    HashSet<Long> hs=new HashSet<>();
    for(int i=0;i<pf.size() && pf.size()>1;i++){
        long v1=pf.get(i); //long cnt=last/v1;   ans+=(cnt*pf.get(i));  tcnt+=cnt;
        if(hs.add(v1)){
            long fp1=((v1-3)/2)+1;  long freq1=(last-fp1)/v1;
            ans+=(freq1*v1);  tcnt+=freq1;
        }
        long v2=gcd/v1;
        
        if(hs.add(v2)){
            long fp2=((v2-3)/2)+1;  long freq2=(last-fp2)/v2;
            ans+=(freq2*v2);  tcnt+=freq2;
        }
    }
    ArrayList<Long> lt=new ArrayList<>();
    for(long val:hs){lt.add(val);}

    Collections.sort(lt);
    for(int i=0;i<lt.size() && lt.size()>1;i++){
        long v1=lt.get(i); //long cnt=last/v1;   ans+=(cnt*pf.get(i));  tcnt+=cnt;
        
        for(int j=i+1;j<lt.size();j++){
            long v2=lt.get(j);
            if(v2>v1 && v2%v1==0){
                long fp=((v2-3)/2)+1;  long freq2=(last-fp)/v2;  //System.out.println("fq2 "+freq2);
                ans-=(freq2*v1);  tcnt-=freq2;
            }
        }
    }
    ans=ans+gcd+(last-tcnt-1);
    asb.append(ans);  asb.append("\n");
   }
   System.out.println(asb);
}

public static void solve5() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();
    
   while(t-->0){
    long k =Integer.parseInt(br.readLine());
    // String[] strs=(br.readLine()).trim().split(" ");
    // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
    //  String str=(br.readLine()).trim();
    // int[] arr=new int[n];
    // for(int i=0;i<n;i++){arr[i]=Integer.parseInt(strs[i]);}
    long rsum=0;
    for(int i=1;i<=(2*k);i++){   
        long p1=(i*i)+k;   long p2=((i+1)*(i+1)) + k;   long diff=p2-p1;
        long gcd= gcd(p1,p2);
        System.out.println(gcd+"  i="+i+"   p1= "+p1+"   p2= "+p2 +"  diff= "+diff);
        rsum=(rsum+gcd)%mod;   
    } 

    long rsum2=0;
    ArrayList<Long[]> list=new ArrayList<>(); 
    for(long i=1;i<=(2*k);i++){   
        long p1=((i*i)+k);   long p2=(((i+1)*(i+1)) + k);   long diff=p2-p1;  //2*k +  
        long mod1=p1%diff;
        if((p1%diff)==(p2%diff) && mod1==0){//&& (mod1+(k%diff))%diff==0
            //(p1+p2)%diff==0
            System.out.println(i+" "+diff);
            list.add(new Long[]{i,diff});  
            rsum2+=diff;
        }
    } 

    long end=(2*k)-1;
    
    long tcnt=0;
    long oans=0;
    for(Long[] arr:list){
        long cnt=((end-arr[0]+1)/arr[1]);   tcnt+=cnt;  long cval=(cnt*arr[1]);
        if(arr[0]==(2*k)){ oans+=arr[1]; }
        System.out.println(arr[0]+"  ||    cnt="+cnt+"     "+arr[1]);
        oans+=(cnt*arr[1]);
    }

    oans+=(end-tcnt);

    // asb.append(rsum);  asb.append("\n");
    asb.append(rsum+" "+rsum2+" "+oans);  asb.append("\n");
   }
   System.out.println(asb);
    }
    

public static void tle() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
        
       while(t-->0){
        long k =Integer.parseInt(br.readLine());
         long rsum=0;
        for(int i=1;i<=(2*k);i++){   
            long p1=(i*i)+k;   long p2=((i+1)*(i+1)) + k;   
            long gcd= gcd(p1,p2);
            rsum=(rsum+gcd)%mod;   
        } 
        
        asb.append(rsum);  asb.append("\n");
       }
       System.out.println(asb);
    }
        
    static int[] msieve;
    static int[] strg;
    public  static void sieveOfEronthesis(){
        int maxn=4000_002;  //maxn=4*maxk
        msieve=new int[maxn];  strg=new int[maxn];
        for(int i=0;i<maxn;i++){  msieve[i]=i;}

        for(int i=2;i<maxn;i++){
            if(msieve[i]==i){
                msieve[i]--;

                for(int j=2*i;j<maxn;j+=i){
                    msieve[j]=(msieve[j]/i)*(msieve[i]);
                }
            }
        }

        for(int v1=1;v1<maxn;v1++){
            strg[v1]+=(v1-1);
            for(int v2=2*v1;v2<maxn;v2+=v1){
                strg[v2]+=v1*((1+msieve[v2/v1])/2);
            }
        }
    }
    public static void ISS() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
        sieveOfEronthesis();

       while(t-->0){
        int k =Integer.parseInt(br.readLine());
         long sum=strg[(4*k)+1];
        asb.append(sum);   asb.append("\n");
       }
       System.out.println(asb);
    }

//******************************************************************************************************************** */
    public static void main(String[] args) throws Exception{
        // solvefnl();
        // tle();
        // solve5();
        ISS();
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


