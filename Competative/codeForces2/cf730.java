import java.util.*;
import java.io.*;
import java.lang.*;


public class cf730 {
//HashSet<Integer> hs=new HashSet<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> lt=new ArrayList<>();
    static long mod=1000_000_007;

    public static void solve3() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();  //asb.append("\n");
		
       while(t-->0){
        int n =(int)Long.parseLong(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        // int k=Double.parseDouble(strs[0]),n=Double.parseDouble(strs[1]),m=Double.parseDouble(strs[2]),v=Double.parseDouble(strs[3]);
        //  String str=(br.readLine()).trim();
        int[] arr=new int[n];
        String[] sarr=new String[n];
        int[][] barr=new int[n][32];

        int[] res=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strs[i]);

            sarr[i]=Integer.toBinaryString(arr[i]);
            StringBuilder sb=new StringBuilder();
            for(int j=sarr[i].length()-1;j>=0;j--){
                sb.append(sarr[i].charAt(j));
            }

            sarr[i]=sb.toString();

            for(int j=0;j<sarr[i].length();j++){
                if(sarr[i].charAt(j)=='1'){  barr[i][j]=1; }
            }

            if(i>0){
                int[] b1=barr[i-1]  ,b2=barr[i];
                int y=0;
                for(int j=0;j<32;j++){
                    if(b1[j]==1 && b2[j]==0){
                        b2[j]=1;
                        y+=Math.pow(2, j);
                    }
                }
                res[i]=y;
            }
            // System.out.println(sarr[i]);
        }

         for(int i=0;i<n;i++){
             asb.append(res[i]+" ");
         }

         asb.append("\n");

         }

         System.out.println(asb);
    }
	

//******************************************************************************************************************** */
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    br.readLine();
    StringBuilder sb = new StringBuilder();
    while (t-- > 0) {
        String[] scn = (br.readLine()).trim().split(" ");
        int n = Integer.parseInt(scn[0]);
        int m = Integer.parseInt(scn[1]);
        long[] land = new long[n + 1];
        scn = (br.readLine()).trim().split(" ");
        String[] scn1 = (br.readLine()).trim().split(" ");

        //Imp min(tj+mod(aj-i))   here, mod(aj-i) is index difference only that why we add min+=1;

        for (int i = 0; i < m; i++) {
            int idx = (int) Long.parseLong(scn[i]);  //imp
            long temp = Long.parseLong(scn1[i]);
            land[idx] = temp;
        }
        long[] ans = new long[n + 1];
        long min = (long) (1e15);  
        System.out.println(min);
        for (int i = 1; i <= n; i++) {
            if (land[i] != 0) {
                min = Math.min(min, land[i]);
            }
            ans[i] = min;
            min += 1;  //v.imp
        }
        min = (long) (1e15);
        for (int i = n; i >= 1; i--) {
            if (land[i] != 0) {
                min = Math.min(min, land[i]);
            }
            ans[i] = Math.min(min, ans[i]);
            min += 1;   //v.imp
        }
        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] + " ");
        }
        sb.append("\n");
        if (t != 0) {
            br.readLine();
        }
    }
    System.out.println(sb);
    return;

}





public static void solve1() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();  //asb.append("\n");
    
   while(t-->0){
    String[] strs5=(br.readLine()).trim().split(" ");
    // int n =(int)Long.parseLong(br.readLine());
    String[] strs=(br.readLine()).trim().split(" ");
    int xa=Integer.parseInt(strs[0]),ya=Integer.parseInt(strs[1]);//,m=Double.parseDouble(strs[2]),v=Double.parseDouble(strs[3]);
    
    strs=(br.readLine()).trim().split(" ");
    int xb=Integer.parseInt(strs[0]),yb=Integer.parseInt(strs[1]);

    strs=(br.readLine()).trim().split(" ");
    int xf=Integer.parseInt(strs[0]),yf=Integer.parseInt(strs[1]);

    int ans=Math.abs(xb-xa) + Math.abs(yb-ya);

    if((xa==xb && xb==xf && yf>Math.min(ya, yb) && yf<Math.max(ya, yb)  ) || (ya==yb && yb==yf && xf>Math.min(xa, xb) && xf<Math.max(xa, xb))  ){
        ans+=2;
    }
    asb.append(ans+" \n");
    //  String str=(br.readLine()).trim();
   }

   System.out.println(asb);
}


public static void solve6() throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t = Integer.parseInt(br.readLine());
    StringBuilder asb=new StringBuilder();  //asb.append("\n");
    String mst="abcdefghijklmnopqrstuvwxyz";
    char[] mchrs=mst.toCharArray();


//    while(t-->0){
    // String[] strs5=(br.readLine()).trim().split(" ");
    // int n =(int)Long.parseLong(br.readLine());
    // String[] strs=(br.readLine()).trim().split(" ");
    String[] sarr=new String[t];
        
    for(int i=0;i<t;i++){
        sarr[i]=(br.readLine()).trim();
    }


     for(int i=0;i<t;i++){
         char[] chrs=sarr[i].toCharArray();
        int st=-1;
        int clen=chrs.length;

         for(int j=0;j<chrs.length;j++){
             if(chrs[j]=='a'){st=j;  break;}
         }

         if(st==-1){
             asb.append("NO");
         }else{
            int p1=st-1,  p2=st+1;
            int p3=1;
            boolean fg=true;
            while(p1>=0 || p2<clen){
                if(p1>=0 && chrs[p1]==mchrs[p3]){
                    p1--;  p3++;
                }else if(p2<clen && chrs[p2]==mchrs[p3]){
                    p2++;  p3++;
                }else{
                    fg=false;  break;
                }
            }
            
            if(fg){ asb.append("YES"); }
            else{ asb.append("NO"); }
         }

         asb.append("\n");
     }

//    }

   System.out.println(asb);
}

// public static void main(String[] args) throws Exception{
//         solve6();
//      }

     public static void solve2() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
        String[] strs5=(br.readLine()).trim().split(" ");
		
       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int k=Integer.parseInt(strs[0]),n=Integer.parseInt(strs[1]),m=Integer.parseInt(strs[2]);//,s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        strs=(br.readLine()).trim().split(" ");
        int[] a=new int[n];
        for(int i=0;i<n;i++){a[i]=Integer.parseInt(strs[i]);}

        strs=(br.readLine()).trim().split(" ");
        int[] b=new int[m];
        for(int i=0;i<m;i++){b[i]=Integer.parseInt(strs[i]);}

        if(t>0)strs=(br.readLine()).trim().split(" ");
        
        // System.out.println("tt "+t);

        ArrayList<Integer> lt=new ArrayList<>();

        int llen=k;

        int i=0,j=0;

        while(i<n && j<m){
            if(a[i]==0){llen++;  lt.add(0); i++; }
            else if(b[j]==0){llen++;  lt.add(0); j++; }
            else if(a[i]<=b[j]){
                if(llen>=a[i]){ lt.add(a[i]); i++; }
                else{ break; }
            } else if(a[i]>b[j]){
                if(llen>=b[j]){ lt.add(b[j]); j++; }
                else{ break; }
            }
        }

        while(i<n){
            if(a[i]==0){llen++;  lt.add(0); i++; }
            else{
                if(llen>=a[i]){ lt.add(a[i]); i++; }
                else{ break; }
            }
        }

        while(j<m){
            if(b[j]==0){llen++;  lt.add(0); j++; }
            else{
                if(llen>=b[j]){ lt.add(b[j]); j++; }
                else{ break; }
            }
        }

        if(lt.size()==(n+m)){
            for(int v:lt){
                // System.out.print(v+" ");
                asb.append(v+" ");
            }
            // System.out.println();
        }else{
            asb.append(-1+" ");
            // System.out.println(-1);
        }
        asb.append("\n");
        

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