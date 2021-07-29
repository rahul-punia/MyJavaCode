import java.util.*;
import java.io.*;
import java.lang.*;


public class cf702 {

    static long[] cubes=new long[100001];

    public static void fill(){

        for(int i=1;i<=100000;i++){
           
            long val=(long)i;
            cubes[i]=(long)(val*val*val);
        }
    }
    public static class node{
        int val;
        node left;
        node right;
        node(int val,node left,node right){this.val=val;  this.left=left; this.right=right;}
    }
    static int[] ans;
    public static node buildtree(int[] arr,int st,int end,node root,int level){
        if(st>end){
            return null;
        }  
        int max=0;
        int mi=-1;
        for(int i=st;i<=end;i++){
            if(max<arr[i]){max=arr[i]; mi=i;}
        }

        root=new node(max, null, null);
        root.left=buildtree(arr, st, mi-1,root,level+1);
        root.right=buildtree(arr, mi+1,end,root,level+1);
        ans[mi]=level;
        return root;
    }



    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
        // fill();

       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        String[] strs=(br.readLine()).trim().split(" ");

        int[][] arr=new int[n][2];
        long sum=0;
        for(int i=0;i<n;i++){
            arr[i][0]=Integer.parseInt(strs[i]);
            arr[i][1]=i+1;
            // if(i<(n-1)){sum+=arr[i][0];}
        }
        
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        for(int i=0;i<(n-1);i++){sum+=arr[i][0];}
        
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(arr[n-1][1]);

        for(int i=n-2;i>=0;i--){
            if(sum<arr[i+1][0]){break;}
            list.add(arr[i][1]);
            sum-=arr[i][0];
            // System.out.println(sum);
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
 }
}


        // int i=0;
        // int psum=0;
        // int st=n-1;
        // for(;i<(n-1);i++){
        //     psum+=arr[i][0];
        //     if(psum>=arr[i+1][0]){  st=Math.min(st, i);}
        //     else{st=n-1;}
        //     // System.out.print(ans[i]+" ");
        // }
        // int[][] ans=new int[n-st][2];
        // int j=0;
        // for(i=st;i<n;i++){
        //     ans[j][0]=arr[i][0];
        //     ans[j][1]=arr[i][1];
        //     j++; 
        // }
        // Arrays.sort(ans,(a,b)->a[1]-b[1]);
        // System.out.println(ans.length);
        // for(int k=0;k<ans.length;k++){
        //     System.out.print(ans[k][1]+" ");
        // }
//         System.out.println();
//        }
//     }
// }










//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
//         fill();

//        while(t-->0){
//         long x =Long.parseLong(br.readLine());
                    
//         boolean flag=false;
       
//         for(int i=1;i<=100000;i++){
//             long rem=x-cubes[i];
//             if(rem<0){break;}
//             if(rem==cubes[i]){flag=true; break;}
           
//             //bs
//             int lo=1,hi=100000;
           
//             while(lo<=hi){
//                 int mid=lo+(hi-lo)/2;

//                 if(cubes[mid]==rem){
//                     flag=true; break;
//                 }else if(rem<cubes[mid]){
//                     hi=mid-1;
//                 }else{
//                     lo=mid+1;
//                 }
//             }
//             if(flag){break;}
//         }

//         if(flag){System.out.println("YES");}
//         else{System.out.println("NO");}
//        }
//     }
// }
// 1
// 7036 5751 9796
    
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         int t = Integer.parseInt(br.readLine());
//         // StringBuilder sb = new StringBuilder();
//         // ArrayList<Integer> list=new ArrayList<>();

//        while(t-->0){
//         int n = Integer.parseInt(br.readLine());
//         String[] strs=(br.readLine()).trim().split(" ");

//         // long n=(long)(Integer.parseInt(strs[0]));
//         int [] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=(Integer.parseInt(strs[i]));
//         }
//         int ans=0;
//         int[] rems=new int[3];
//         for(int i=0;i<(n);i++){
//             int rem=arr[i]%3;
//             rems[rem]++;
//         }

//         if(rems[0]==rems[1] &&  rems[1]==rems[2]){
//             System.out.println(0);
//         }else{
//             // int min=2*rems[1]+rems[2];
//             // min=Math.min(min,2*rems[2]+rems[0]);
//             // min=Math.min(min,2*rems[0]+rems[1]);
//             // System.out.println("aa=="+min);

//             int ct=n/3;
//             int i=0;
//             while(rems[0]!=rems[1] ||  rems[1]!=rems[2]){
//                 if(rems[i]>ct){
//                     rems[(i+1)%3]+=rems[i]-ct;
//                     ans+=rems[i]-ct;
//                     rems[i]=ct;
//                 }
//                 i++;
//                 i=i%3;    
//             }

//             System.out.println(ans);
//         }
        
//        }
//     }


// }


// // import java.util.*;
// // import java.io.*;
// // import java.lang.*;


// // public class cf702 {
    
// //     public static void main(String[] args) throws Exception{
// //         InputStreamReader ip=new InputStreamReader(System.in);
// //         BufferedReader br = new BufferedReader(ip);
// //         int t = Integer.parseInt(br.readLine());
// //         // StringBuilder sb = new StringBuilder();
// //         // ArrayList<Integer> list=new ArrayList<>();

// //        while(t-->0){
// //         int n = Integer.parseInt(br.readLine());
// //         String[] strs=(br.readLine()).trim().split(" ");

// //         // long n=(long)(Integer.parseInt(strs[0]));
// //         int [] arr=new int[n];

// //         for(int i=0;i<n;i++){
// //             arr[i]=(Integer.parseInt(strs[i]));
// //         }
// //         int ans=0;
// //         for(int i=0;i<(n-1);i++){
// //             int max=Math.max(arr[i],arr[i+1]);
// //             int min=Math.min(arr[i],arr[i+1]);
// //             // 
// //             int ct=0;
// //             if(max<=(2*min)){

// //             }else{
// //                 while(max>(2*min)){
// //                     // if(max%2==0){max=max/2;}
// //                     // else{max=(max/2)+1;}
// //                     if(min>1){
// //                         min=(2*min)-1;
//                     }else{
//                         min=(2*min);
//                     }
                    
                    
//                     ct++;
//                     System.out.println(ct);
//                 }
//             }
//             ans+=ct;
//         }

//         // if(ans>0){ans--;}
//         System.out.println("aa="+ans);
//        }
//     }


// }
