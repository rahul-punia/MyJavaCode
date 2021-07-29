import java.util.*;
import java.io.*;
import java.lang.*;



public class cf690 {
        public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
       
       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");

        // int[] arr=new int[n];
        ArrayList<Integer> list=new ArrayList<>();

        // boolean flag=true;
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(strs[i]);
            list.add(val);
        }

        boolean flag=true;
        int ct=0;
        while(flag){
            flag=false;
            int min=list.get(0);
            int mi=0;
            for(int i=1;i<list.size();i++){
                if(list.get(i-1)!=list.get(i)){flag=true;}
                if(list.get(i)<min){min=list.get(i); mi=i;}
            }
            if(!flag){break;}
            // System.out.println(ct+" "+list.size()+"  "+mi);
            ct++;
            if(mi>0 && (mi+1)<list.size()){
                if(list.get(mi-1)<list.get(mi+1)){
                    list.set(mi-1,(list.get(mi-1)+list.get(mi)));    list.remove(mi);
                }else{
                    list.set(mi+1,list.get(mi+1)+list.get(mi));    list.remove(mi);
                }
            }else if(mi>0){
                list.set(mi-1,list.get(mi-1)+list.get(mi));    list.remove(mi);
            }else if((mi+1)<list.size()){
                // System.out.println("rr");
                list.set(mi+1,list.get(mi+1)+list.get(mi));    list.remove(mi);
            }
        }

        System.out.println(ct);
     }
    }
}




//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
       
//        while(t-->0){
//         int sum =Integer.parseInt(br.readLine());

//         if(sum>45){
//             System.out.println(-1);
//             continue;
//         }
//         int dig=9;
//         String num="";
//         while(sum>0 && dig>0){

//             if(sum>=dig){
//                 num=dig+num;
//                 sum-=dig;
//                  dig--;
//             }else{
//                 dig--;
//             }
//         }

//         if(sum==0){
//             System.out.println(num);
//         }else{
//             System.out.println(-1);
//         }
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
//         // String[] strs=(br.readLine()).trim().split(" ");

//         // int[] arr=new int[n];
//         String str=br.readLine();

//         int ed=(n-4)-1;
//         int st=0;
//         boolean flag=false;
//         while(ed<n){
//             String s=str.substring(0,st)+str.substring(ed+1);
//             // System.out.println(st+" "+ed+" "+s);
//             st++; ed++;
//             if(s.equals("2020")){
//                 flag=true;
//                 break;
//             }
//         }
//         // if(flag){System.out.println("YES"); continue;}
        

//         if(flag){System.out.println("YES");}
//         else{System.out.println("NO");}
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
//         String[] strs=(br.readLine()).trim().split(" ");

//         int[] arr=new int[n];

//         boolean flag=true;
//         int s=0,e=n-1;
//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//         }
//         int[] ans=new int[n];
//         for(int i=0;i<n;i++){
//             if(flag){
//                 ans[i]=arr[s++];
//             }else{
//                 ans[i]=arr[e--];
//             }
//             flag=!flag;
//         }

//         for(int i=0;i<n;i++){
//             System.out.print(ans[i]+" ");
//         }
//         System.out.println();
//        }
//     }

// }
