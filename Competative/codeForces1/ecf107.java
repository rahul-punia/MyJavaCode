import java.util.*;
import java.io.*;
import java.lang.*;

public class ecf107 {
    //  javac ecf107.java          java ecf107 
    static long[][] arr;

    public static void pre(){ 
        arr=new long[9*9*9][5];  // a b c x y

        int r=0;
        for(int a=1;a<=9;a++){
            for(int b=1;b<=9;b++){
                int min=Math.min(a, b);
               for(int c=1;c<=9;c++){

                if(c>min){r++; continue;}
                

                arr[r][0]=a;  arr[r][1]=b;   arr[r][2]=c;  

                

                long l1=1; int h1=1;
                long l2=1,h2=1;
        
                for(int i=0;i<a;i++){
                    if(i<(a-1))l1=l1*10;
                    h1=h1*10;
                }
        
                for(int i=0;i<b;i++){
                    if(i<(b-1))l2=l2*10;
                    h2=h2*10;
                }
                
                if(a==b && b==c){
                    arr[r][3]=l1; arr[r][4]=l1;   continue; 
                }
        
                boolean f=true;
                for(long x=l1;x<h1  && f;x++){
        
                    for(long y=l2;y<h2 && f;y++){
                        long g=gcd(x, y);
                        
                        int d=0;
                        while(g>0){
                            g=g/10; d++;  
                        }
        
                        if(d==c){f=false;  arr[r][3]=x; arr[r][4]=y; break;}
                        // if(d==c){f=false;  asb.append(x); asb.append(" "); asb.append(y);   asb.append("\n");  break;}
                    }
                }
                
                        r++;
               } 
        }
        }
    }
    public static long gcd(long a,long b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    static  ArrayList<Integer> slist=new ArrayList<>();

    public static void SOE(int n){
          int[] sieve=new int[n+1];
       

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

        
        for(int x=2;x<=n;x++){
            if(sieve[x]==0){
                slist.add(x);
            }
        }
    }

    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();
        //pre
        // pre();
        // SOE(10000_000);


       while(t-->0){
        // int n =Integer.parseInt(br.readLine());       //Long.parseLong(strs[i])
        String[] strs=(br.readLine()).trim().split(" "); 
        int a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),c=Integer.parseInt(strs[2]);//,s=Integer.parseInt(strs[3]);
        // String str=(br.readLine()).trim();

        
			long lefta = (long) Math.pow(10, a - 1);
			long leftb = (long) Math.pow(10, b - 1);
			long leftc = (long) Math.pow(10, c - 1);
 
			asb.append(lefta + " " + (leftb + leftc));
			asb.append("\n");

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
        // int t = Integer.parseInt(br.readLine());
        StringBuilder asb=new StringBuilder();

    //    while(t-->0){
        // int n =Integer.parseInt(br.readLine());
          String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),q=Integer.parseInt(strs[1]);//,r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        //  String str=(br.readLine()).trim();
        // ArrayList<Integer> alist=new ArrayList<>();
        // ArrayList<Integer> qlist=new ArrayList<>();
        int[] qr=new int[q];
        int[] arr=new int[n];
        
        strs=(br.readLine()).trim().split(" ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(strs[i]);
            // alist.add(Integer.parseInt(strs[i]));
        }

        strs=(br.readLine()).trim().split(" ");
        for(int i=0;i<q;i++){
            qr[i]=Integer.parseInt(strs[i]);
        }


        for(int i=0;i<q;i++){
            int cd=qr[i];
            int prev=arr[0];

            int post=0;
            for(int j=0;j<n;j++){
                if(cd==arr[j]){
                    arr[0]=arr[j];
                    arr[j]=prev;
                    post=j;  break;
                }else{
                    int nprev=arr[j];  arr[j]=prev;  prev=nprev;
                }
            }

            asb.append(post+1);  asb.append(" ");
            // alist.remove(post); alist.add(0,cd);
        }

        System.out.println(asb);


    //    }
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


