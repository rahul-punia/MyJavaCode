import java.util.*;
import java.io.*;
import java.lang.*;

public class cf615 {


    // public static void solve(){
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     int t = Integer.parseInt(br.readLine());
       
    //    while(t-->0){
    //     int n =Integer.parseInt(br.readLine());
    //     // String[] strs=(br.readLine()).trim().split(" ");
    //     // long a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);
    //     // int[][] arr=new int[n][2];
    //    }
    // }


    ////Always remember Donot Intialize static variables outside function but Intialize inside function to avoid mistakes that i Had done many times     
    static int len;
    static ArrayList<Integer> list;
    static boolean flag;

    public static void findpath(boolean[][] tab,int[] arr,int i,int j){
         if(list.size()==len && j==0){
             flag=false;
             return ;
         }
         if(list.size()>len)return;
         if(j<=0 || i<=0)return;

         if(arr[i-1]<=j && tab[i-1][j-arr[i-1]] && flag){
             list.add(arr[i-1]);
             findpath(tab, arr, i-1, j-arr[i-1]);
             if(flag)list.remove(list.size()-1);
         }

         if(tab[i-1][j] && flag){
            // list.add(arr[i-1]);   //mymistake-1
            findpath(tab, arr, i-1, j);
            // if(flag)list.remove(list.size()-1);
         }
    }


    public static boolean subsetSum(int arr[], int n, int sum){
        boolean[][] tab=new boolean[n + 1][sum + 1];
        tab[0][0] = true;
        for (int i = 1; i <= sum; i++)
            tab[0][i] = false;
        for (int i = 1; i <= n; i++)
            tab[i][0] = true;
     
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= sum; j++){
              // if the value is greater than the sum
                if(arr[i-1]>j){tab[i][j]=tab[i-1][j];}
                else if(tab[i-1][j] || tab[i-1][j-arr[i-1]]){
                    tab[i][j]=true;
                }
            }
        }
     
        // System.out.println("Raa2");

        if(tab[n][sum]){
            findpath(tab,arr,n,sum);
        }

        // System.out.println("Raa3");
        return tab[n][sum];
    }

    public static void solve() throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        int t = Integer.parseInt(br.readLine());
       
       while(t-->0){
        // int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),l=Integer.parseInt(strs[1]),r=Integer.parseInt(strs[2]),s=Integer.parseInt(strs[3]);
        len=(r-l)+1;

        boolean[] vst=new boolean[n+1];
        int[] ans=new int[n+1];
        int[] arr=new int[n];
        for(int i=0;i<n;i++){arr[i]=i+1;}    
        list=new ArrayList<>();   //mymistake-2   //Always remember reintialize static variables again
        flag=true;  //mymistake-3    
        // System.out.println("Raa1");
        
        
        boolean issubset=subsetSum(arr, n, s);

        if((s/len)<=n && (s/len)>0 && issubset && list.size()==len){
            // System.out.println(list);

            for(int val:list){
                vst[val]=true;
                ans[l++]=val;
            }

            int j=1;
            for(int i=1;i<=n;i++){
                if(ans[i]>0){continue;}

                while(j<=n && vst[j]){j++;}
                if(ans[i]==0){
                    ans[i]=j;  j++;
                }
            }

            for(int i=1;i<=n;i++){
                System.out.print(ans[i]+" ");
            }

            System.out.println();

        }else{
            System.out.println(-1);
        }

       }
    }

    public static void main(String[] args) throws Exception{
       solve();
    }
}










    // public static boolean isprime(int num,int v1){
    //     boolean flag = true;
    // for (int i = 2; i <=( num / 2); i++) {
    //   // condition for nonprime number
    //   if (num % i == 0 && i!=v1) {
    //     flag = false;
    //     break;
    //   }
    // }
    // return flag;
    // }

//    public static boolean isprime(int n,int t)
//     {
//         // Corner cases
//         if (n <= 1)
//             return false;
//         if (n <= 3)
//             return true;
  
//         // This is checked so that we can skip
//         // middle five numbers in below loop
//         if (n % 2 == 0 || n % 3 == 0)
//             return false;
  
//         for (int i = 5; i * i <= n; i = i + 6)
//             if (n % i == 0 || n % (i + 2) == 0)
//                 return false;
  
//         return true;
//     }

//     int len=0;
//     ArrayList<Integer> list=new ArrayList<>();


//     public int subsetSum(int a[], int n, int sum)
//     {
//         // Initializing the matrix
//         int[][] tab=new int[n + 1][sum + 1];
//       // Initializing the first value of matrix
//         tab[0][0] = 1;
//         for (int i = 1; i <= sum; i++)
//             tab[0][i] = 0;
//         for (int i = 1; i <= n; i++)
//             tab[i][0] = 1;
     
//         for (int i = 1; i <= n; i++)
//         {
//             for (int j = 1; j <= sum; j++)
//             {
//               // if the value is greater than the sum
//                 if (a[i - 1] > j)
//                     tab[i][j] = tab[i - 1][j];
//                 else
//                 {
//                     tab[i][j] = tab[i - 1][j] + tab[i - 1][j - a[i - 1]];
//                 }
//             }
//         }
     
        
//         if(sum==tab[n][sum]){

//         }
//         return tab[n][sum];
//     }


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
//         // int[][] arr=new int[n][2];

//         int ct=0;
//         int div=2;
//         int num=n;
//         HashSet<Integer> list=new HashSet();
//         int v1=-1;
        
//         while(ct<2 && div<num){
//             if(isprime(num,v1)){
//                 break;
//             }

//             while(div<(num-1) && num%div!=0 && div!=v1){
//                 div++;
//             }

//             if(num%div==0 && v1!=(num/div) && v1!=div){
//                 v1=div;
//                list.add(div);  ct++; num=num/div;    div++;
//             }else{
//                 div++;
//             }
//             // System.out.println(div);
//         }

//         list.add(num);
//         if(list.size()>=3){
//             System.out.println("YES");
//             // System.out.println(list.get(0)+" "+list.get(1)+" "+num);
//             for(int val:list){
//                 System.out.print(val+" ");
//             }
//             System.out.println();
//         }else{
//             System.out.println("NO");
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
//         int[][] arr=new int[n][2];

       

//         for(int i=0;i<n;i++){
//             String[] strs=(br.readLine()).trim().split(" ");
//             int x=Integer.parseInt(strs[0]),y=Integer.parseInt(strs[1]);

//             arr[i][0]=x;  arr[i][1]=y;
//         }

//         Arrays.sort(arr,(a,b)->{
//             if(a[0]!=b[0])return a[0]-b[0];
//             return a[1]-b[1];
//         });

//         int cx=0,cy=0;
//         StringBuilder sb=new StringBuilder();
//         int ct=0;
//         for(int i=0;i<n;i++){

//             while(cx<arr[i][0]){
//                 cx++;
//                 sb.append('R');
//             }

//             while(cy<arr[i][1]){
//                 cy++;
//                 sb.append('U');
//             }

//             if(cx==arr[i][0] && cy==arr[i][1]){ ct++; }
//         }

//         if(ct==n){
//             System.out.println("YES");
//             System.out.println(sb.toString());
//         }else{
//             System.out.println("NO");
//         }
       
//        }
//     }
// }




//         public static void main(String[] args) throws Exception{
//             InputStreamReader ip=new InputStreamReader(System.in);
//             BufferedReader br = new BufferedReader(ip);
//             // Scanner scn=new Scanner(System.in);
//             int t = Integer.parseInt(br.readLine());
//             // fill();
    
//            while(t-->0){
//             // int n =Integer.parseInt(br.readLine());
//             String[] strs=(br.readLine()).trim().split(" ");
            

//             long a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),c=Integer.parseInt(strs[2]),n=Integer.parseInt(strs[3]);

//             long sum=a+b+c+n;

            

//             long div=sum/3;

//             if(sum%3!=0 || a>div || b>div || c>div){
//                 System.out.println("NO");
//                 continue;
//             }else{
//                 System.out.println("YES");
//             }
//            }        
//     }
// }
