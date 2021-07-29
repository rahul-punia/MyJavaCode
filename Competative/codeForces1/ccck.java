import java.util.*;
import java.io.*;
import java.lang.*;

public class ccck {
    
    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
		
       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int x=Integer.parseInt(strs[0]),y=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
       
        int lvl=1;
        int ml=-1;
        int ofx=0,ofy=0;

        int mx=0,my=0;

        if(x<y){ asb.append("NO");  asb.append("\n"); continue; }

        int tlvl=0;
        int mfx=0,mcx=0;
        while(true){
            int fx= 2*((lvl-1)/2) + 1 ;  int fy=2*((lvl)/2);  //even,odd pr
            ofx+=fx;  ofy+=fy;
            int cx=x-ofx;  int cy=y-ofy;

            // System.out.println(ofx+"  "+ofy);
            if(cx==0 && cy==0){ ml=lvl; mfx=fx; mx=cx; mcx=cx;  my=cy; tlvl=lvl;  break; }


            if(lvl>1 && cy%fy==0){  //cx%fx==0 &&

                boolean fg=false;  int nd=1;
                while((cx-(nd*fx)-(2*(nd-1)))>=0){
                     if((cx-(nd*fx)-(2*(nd-1)))==0){fg=true;  break;}
                     cx-=(2*(nd-1));
                     nd++;
                }
                
               if(fg){ ml=lvl; mfx=fx; mx=cx; mcx=cx;  my=cy; tlvl=lvl+nd;  break;}
            }
            if(ofx>=x || ofy>=y)break;
            
            lvl++;  //imp
        }

        if(ml==-1){
            asb.append("NO");  asb.append("\n");
        }else{
            asb.append("YES");   asb.append("\n");
            asb.append(tlvl);    asb.append("\n");
            int i=1;
            for(i=1;i<ml;i++){
                asb.append(i+" "+(i+1));   asb.append("\n");
            }

               i=ml; 
              int nd=1;
            while((mcx-(nd*mfx)-(2*(nd-1)))>0){
                asb.append((ml-1)+" "+(i+1));  i++;   asb.append("\n");
                if((mcx-(nd*mfx)-(2*(nd-1)))==0){break;}
                mcx-=(2*(nd-1));
                nd++;
            }
        }

       }

       System.out.println(asb);
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
        // int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();

       }
    }
	
    //Comparator Interface
    public static class comp implements Comparator<int[]>{
        public int compare(int[] a,int[] b){
            return a[0]-b[0];
        }
    }

	//gcd
	public static long gcd(long a,long b){   //gcd using division method
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


