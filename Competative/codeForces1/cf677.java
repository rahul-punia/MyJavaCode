
import java.util.*;
import java.lang.*;
import java.io.*;


public class cf677 {
    static long[] fact=new long[21];


    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int n = Integer.parseInt(br.readLine());
        fact[0]=1;
        for(int i=1;i<=20;i++){long val=i;  fact[i]=fact[i-1]*val;}
       
        long ans=((fact[n])/(2*(n/2)*(n/2)));
        System.out.println(ans);
    //    while(t-->0){
    //     int n =Integer.parseInt(br.readLine());
    //     String[] strs=(br.readLine()).trim().split(" ");
    //     // int st=n,e=0;
    //     int[] arr=new int[n];
    //     for(int i=0;i<n;i++){
    //         arr[i]=Integer.parseInt(strs[i]);
    //     }
    //     boolean flag=false;
    //     boolean[] vst=new boolean[n];
    //     ArrayList<int[]> list=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         flag=true;
    //         for(int j=0;j<n;j++){
    //             if(arr[i]!=arr[j]  && !vst[j]){
    //                 vst[j]=true;
    //                 vst[i]=true;
    //                 // System.out.println((i+1)+" "+(j+1));
    //                 list.add(new int[]{i+1,j+1});
    //             }
    //             if((vst[j]==false) && list.size()<(n-1)){flag=false;}
    //         }
    //         // vst[i]=true;
    //         if(flag){break;}
    //     }

    //     if(list.size()==(n-1)){
    //         System.out.println("YES");
    //         for(int[] carr:list){
    //             System.out.println(carr[0]+" "+carr[1]);
    //         }
    //     }else{
    //         System.out.println("NO");
    //     }
    //     }
}
}



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
       
//        while(t-->0){
//         int n =Integer.parseInt(br.readLine());
//         String[] strs=(br.readLine()).trim().split(" ");
//         // int st=n,e=0;
//         int[] arr=new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//         }
//         int ans=-1;
//         int max=-1;
//         int mi=-1;
//         for(int i=0;i<n;i++){
//             if((i>0 && arr[i-1]<arr[i] && arr[i]>max) || ((i+1)<n && arr[i]>arr[i+1]  && arr[i]>max)){
//                 max=Math.max(arr[i], max);  mi=i;
//             }
//         }
//         if(max>0){
//             ans=mi+1;
//         }
//         System.out.println(ans);
//        }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
       
//        while(t-->0){
//         int n =Integer.parseInt(br.readLine());
        
//         //  int[] arr=new int[n];
//         // HashMap<Integer,Integer> hm=new HashMap<>();
//         int rem=n%10;
//         int tmp=n;
//         int ct=0;
//         while(tmp>0){
//             ct++; tmp=tmp/10;
//         }

//         int ans=10*(rem-1)+(ct*(ct+1))/2;

//         System.out.println(ans);
//        }
//     }

// }
