import java.util.*;
import java.io.*;
import java.lang.*;

public class cf104 {
    
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
        // StringBuilder sb = new StringBuilder();
        // ArrayList<Integer> list=new ArrayList<>();

       while(t-->0){
        // int n = Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");

        long n=(long)(Integer.parseInt(strs[0]));
        long k=(long)(Integer.parseInt(strs[1]));

        if(n%2==0){
            System.out.println(((k-1)%n)+1);
        }else{
            long ans=((k-1)+(k-1)/(n/2))%n+1;
            System.out.println(ans);
        }
       }
    }
}



//         if(n%2==0){
//             long ans=k;
//             if(ans>n){ans=ans%k;}
//             System.out.println(ans);
//         }else{
//             long hf=(n/2);

//             if(k<=hf){
//                 System.out.println(k);
//             }else{
//                 long ans=1000000000000L;
//                 ans=k;// ( (k-(hf+1))/(hf) )  )+1;
//                 k--;
//                 ans+=((k)/(hf));
//                 // if(k>=n){ans=(k+(k/(hf+1)));}
//                 if(ans%n==0){
//                     ans=n;
//                 }else{
//                     ans=ans%n;
//                 }
//                 System.out.println(ans);
//             }
//         }
//        }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         int t = Integer.parseInt(br.readLine());
//         // StringBuilder sb = new StringBuilder();
//         // ArrayList<Integer> list=new ArrayList<>();

//        while(t-->0){
//         int n = Integer.parseInt(br.readLine());
//         String[] strs=(br.readLine()).trim().split(" ");
        
//         HashMap<Integer,Integer> hm=new HashMap<>();
//         int min=Integer.MAX_VALUE;
//         for(int i=0;i<n;i++){
//             int val=Integer.parseInt(strs[i]);
//             hm.put(val,hm.getOrDefault(val,0)+1);
//             min=Math.min(val,min);
//         }

//         int ans=n-hm.get(min);

//         System.out.println(ans);
//        }
//     }

// }
