import java.util.*;
import java.io.*;
import java.lang.*;


public class cf713 {
    
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        // fill();

       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]);//,c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);
        // String str=(br.readLine()).trim();    

        int[] arr=new int[n+2];

        for(int i=0;i<n+2;i++){
            arr[i]=Integer.parseInt(strs[i]);
        }

        Arrays.sort(arr);
        int msum1=0,msum2=0;


        for(int i=0;i<n+1;i++){
                msum1+=arr[i];
        }

        for(int i=0;i<n+2;i++){
            if(i!=n)msum2+=arr[i];
         }


        int sum1=arr[n+1];
        int sum2=arr[n];

        int r1=-1,r2=-1;
        for(int i=0;i<(n+1);i++){
            if((msum1-arr[i])==sum1){
                r1=n+1;  r2=i;  break;
            }
        }

        

        for(int i=0;i<(n+2) && r1<0 && r2<0;i++){
            if(i!=n && (msum2-arr[i])==sum2){
                r1=n;  r2=i;  break;
            }
         }

         if(r1>=0 && r2>=0){
            for(int i=0;i<n+2;i++){
                if(i!=r1 && i!=r2)System.out.print(arr[i]+" ");
            } 
         }else{
             System.out.print(-1);
         }
          
        System.out.println();
       }
    }
}



//     public static boolean ispal(String s){
//         int n=s.length();
//         int lo=n/2,hi=n/2;

//         if(n%2==0){
//             lo--;
//         }
//         boolean f=true;
//         while(lo>=0){
//             if(s.charAt(lo)!=s.charAt(hi) || s.charAt(lo)=='?'){f=false;  break;}
//             lo--; hi++;
//         }

//         return f;
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
//         // fill();

//        while(t-->0){
//         // int n =Integer.parseInt(br.readLine());
//         String[] strs=(br.readLine()).trim().split(" ");
//         int a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]);//,c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);
//         String str=(br.readLine()).trim();    

//         char[] arr=str.toCharArray();

        
//          int ct0=0,ct1=0;
         
//          for(char ch:arr){
//              if(ch=='1'){ct1++;}else if(ch=='0'){ct0++;}
//          }

//         int n=str.length();
//         int lo=n/2,hi=n/2;

//         if(n%2==0){
//             lo--;
//         }
//         a-=ct0;  b-=ct1;

//         if(a<0 || b<0){
//             System.out.println(-1);  continue;
//         }

//         while(lo>=0){
//             if(lo==hi && arr[lo]=='?'){
                
//             }else if(arr[lo]=='?'){
//                 if(arr[hi]=='1' && b>0){
//                     arr[lo]='1';  b-=1;
//                 }else if(arr[hi]=='0' && a>0){
//                     arr[lo]='0';   a-=1;
//                 }
//             }else if(arr[hi]=='?'){
//                 if(arr[lo]=='1' && b>0){
//                     arr[hi]='1';  b-=1;
//                 }else if(arr[lo]=='0' && a>0){
//                     arr[hi]='0';   a-=1;
//                 }
//             }

//             lo--; hi++;
//         }
        
        

//         lo=n/2;  hi=n/2;
        
//         if(n%2==0){
//             lo--;
//         }
//         while(lo>=0){
//             if(lo==hi && arr[lo]=='?'){
//                 if(a%2==1 && a>0){arr[lo]='0'; a--;}
//                 else if(b%2==1 && b>0){ arr[lo]='1'; b--; }
//             }else if(arr[lo]=='?' && arr[hi]=='?'){
//                 if(a>=b && a>1){
//                     arr[lo]='0';  arr[hi]='0';  a-=2;
//                 }else if(b>a && b>1){
//                     arr[lo]='1';  arr[hi]='1';  b-=2;
//                 }
//             }
//             lo--; hi++;
//         }

//         StringBuilder sb=new StringBuilder();

//         for(char ch:arr){
//             sb.append(ch);
//         }
//         String ans=sb.toString();

//         if(ispal(ans)){
//             System.out.println(ans);  //"ans="+
//         }else{
//             System.out.println(-1);
//             // System.out.println(-1+"  "+ans);
//         }

//     }
//     }
// }



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
//         // fill();

//        while(t-->0){
//         int n =Integer.parseInt(br.readLine());
//         // String[] strs=(br.readLine()).trim().split(" ");
//         // long a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);
        
//         char[][] arr=new char[n][n];
//         int[][] post=new int[2][2]; int p=0;

//         for(int i=0;i<n;i++){
//             String str=(br.readLine()).trim();

//             int j=0;
//             for(char ch:str.toCharArray()){
//                 arr[i][j]=ch;   

//                 if(ch=='*'){
//                     post[p][0]=i; post[p][1]=j;   p++;  
//                 }
//                 j++;
//             }

//         }

//         Arrays.sort(post,(a,b)->a[0]-b[0]);
//         //     if(a[0]!=b[0])return a[0]-b[0];
//         //     return a[1]-b[1];
//         // });           


//          int r1=post[0][0],r2=post[1][0];
//          int c1=post[0][1],c2=post[1][1];
        
//          if(post[0][0]==post[1][0]){
//             //left
//             // int r=r1-1;
//             if(r1>0){
//                 arr[r1-1][c1]='*';  arr[r1-1][c2]='*';  
//             }else if((r1+1)<n){
//                 arr[r1+1][c1]='*';  arr[r1+1][c2]='*';  
//             }
            
//         }else if(post[0][1]==post[1][1]){
//             if(c1>0){
//                 arr[r1][c1-1]='*';  arr[r2][c1-1]='*';  
//             }else if((c1+1)<n){
//                 arr[r1][c1+1]='*';  arr[r2][c1+1]='*';  
//             }
//         }else{
            
//             if(c1<c2){
            
//                 arr[r2][c1]='*';  arr[r1][c2]='*';
//             }else{
//                 // System.out.println(r1+" "+c2+"   "+r2+" "+c1);
//                 arr[r1][c2]='*';  arr[r2][c1]='*';
//             }
//         }


//         // System.out.println("ans");

//         for (char[] a : arr) {
// 			for (char val : a) {
// 				System.out.print(val);
// 			}
// 			System.out.println();
// 		}


//        }
//     }
// }



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
//         // fill();

//        while(t-->0){
//         int n =Integer.parseInt(br.readLine());
//         String[] strs=(br.readLine()).trim().split(" ");
//         // long a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);
       
//         int[] arr=new int[n];

//         HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();

//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//             ArrayList<Integer> lt= hm.getOrDefault(arr[i],new ArrayList<>());
//             lt.add(i+1);
//             hm.put(arr[i], lt);
//         }

//         for(int key:hm.keySet()){
//             if((hm.get(key)).size()==1){
//                 System.out.println((hm.get(key)).get(0)); //"a "+
//                 break;
//             }
//         }

//         }
//     }

// }
