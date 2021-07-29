import java.util.*;
import java.lang.*;
import java.io.*;



public class cf711 {

//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> list=new ArrayList<>();
//HashSet<Integer> hs=new HashSet<>();
//Stack<Integer> st=new Stack<>();
//Queue<Integer> q=new LinkedList<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
// static ArrayList<ArrayList<Integer>> gp=new ArrayList<>();
//int[] arr=new int[n];
//System.out.println("YES");
//1 hr- atleast 2 qs d-2
//Mt_do 3 qs d-2  
//Mt_do 4 qs d-3
//StringBuilder sb=new StringBuilder();

static long mod=1000000007;
static int[] sum;
public static void main(String[] args) throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t= Integer.parseInt(br.readLine());
    sum=new int[1001];

    // sum[1]=1;

    // for(int i=1;i<=1000;i++){
    //     sum[i]=sum[i-1]+i;
    // }

    while(t-->0){
    //    long n=Long.parseLong(br.readLine());//Integer.parseInt(strs[0]);
        String[] strs=(br.readLine()).trim().split(" ");
        int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,k=Integer.parseInt(strs[2]);

        if(n==1){
            if(k==1){
                System.out.println(1);
            }else{
                System.out.println(2);
            }
            continue;
        }
        if(k==1){
            System.out.println(1);
            continue;
        }

        long ans=1;
        // Queue<Integer> queue=new LinkedList<>();
        // queue.add(1);

        int[] freq=new int[n+1];
        int[] newfreq=new int[n+1];
        // freq[n]=1;
        
        for(int i=1;i<n;i++){
            freq[i]=i;
        }

        while(k-->0){
            int st=1;
            for(int j=n-1;j>=1;j--){
                for(int i=st;i<n;i++){
                    newfreq[j]+=freq[i];
               }
               st++;
            }
            
            for(int j=n-1;j>=0;j--){freq[j]=newfreq[j];  newfreq[j]=0;}
            // freq=newfreq;
            // newfreq=new int[n+1];
        }

        for(int i=1;i<n;i++){
            ans=(ans+((long)i*(long)freq[i])%mod)%mod;
        }

        System.out.println(ans);
        // while(k>0){

        //     int sz=queue.size();

        //     while(sz-->0){
        //         int ct=queue.remove();
        //         ans=ans+(long)(sum[n-1]-sum[(int)n-ct-1]);  ans=ans%mod;
        //         for(int i=0;i<ct;i++){
        //             queue.add((int)(n-1-i));
        //         }
        //     }

        //     k--;
        // }

        // System.out.println(ans);
    }
}
}



// public static long gcd(long a,long b){
//     if(b==0)return a;
//     else return gcd(b, a%b);
// }
// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//     //    long n=Long.parseLong(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),w=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         strs=(br.readLine()).trim().split(" ");
//          int[] arr=new int [n];

//          for(int i=0;i<n;i++){
//              arr[i]=Integer.parseInt(strs[i]);
//          }

//          Arrays.sort(arr);
//          int lo=0,hi=n-1;
//          while(lo<hi){
//              int tmp=arr[lo];  arr[lo]=arr[hi]; arr[hi]=tmp;  lo++; hi--;
//          }

//         PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
//          long ans=0;
//         for(int i=0;i<n;i++){

//             if(pq.size()==0){
//                 if((w-arr[i])>0){pq.add((w-arr[i]));}
//                 else{ans++;} 
//             }else{
//                 int sp=pq.peek();  

//                 if(sp>=arr[i]){
//                     pq.remove();
//                     if((sp-arr[i])>0){pq.add((sp-arr[i]));}
//                      else{ans++;}   
//                 }else{
//                     if((w-arr[i])>0){pq.add((w-arr[i]));}
//                      else{ans++;} 
//                 }
//             }
//         }

//         ans+=pq.size();

//         System.out.println(ans);
//     }
// }
// }

