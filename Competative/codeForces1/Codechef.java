// /* package codechef; // don't place package name! */

import java.util.*;
public class Codechef{

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();
        
        for(int i=0;i<t;i++){
            int n=scn.nextInt();
            int[] arr=new int[n];
            int max=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                arr[j]=scn.nextInt();
                if(j>0)max=Math.max(max, arr[j]);
            }
            long ans=0;
            for(int j=1;j<n;j++){
                ans+=max-arr[j];
            }
            ans-=arr[0];
            if(ans<0)ans=0;

            if(arr[0]%2==1 && n%2==1)ans++;

            System.out.println(ans);
        }
    }
}

//     public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
        
//         for(int i=0;i<t;i++){
//             String str=scn.next();
//             long ans=0; long b1=0,b2=0;
//             for(int j=0;j<str.length();j++){
//                 char ch=str.charAt(j);

//                 if(ch=='('){
//                     b1++;
//                 }else if(ch==')' && b1>0){
//                     b1--; ans++;
//                 }else if(ch=='['){
//                     b2++;
//                 }else if(ch==']' && b2>0){
//                     b2--; ans++;
//                 }
//             }
//             System.out.println(ans);

//         //     int x=scn.nextInt();
//         //     int y=scn.nextInt();

//         //     if(x==y){
//         //         System.out.println(x+y);
//         //         continue;
//         //     }
//         //    long ans=0;
//         //     int dt=Math.min(x,y);
//         //     int nd=Math.max(x, y)-dt;

//         //     ans=2*dt+nd+(nd-1);
//         //     System.out.println(ans);
//         }
//     }
// }




    // public static boolean recursion(int[] arr,boolean[] visited,double cs,double ct,int m){
    //         if(ct==(arr.length+1)){
    //             if(cs==m)return true;
    //             return false;
    //         }
    //         System.out.println(cs+" "+ct);
    //         // System.out.println(cs);
    //         for(int i=0;i<arr.length;i++){
    //             if(visited[i]==false){
    //                 visited[i]=true;
    //                 double val=(ct*(arr[i]/ct));
    //                 // System.out.println("v:"+val);
    //                 cs+=val;
    //                 if(recursion(arr, visited,cs, ct+1, m))return true;
    //                 visited[i]=false;
    //                 cs-=val;
    //             }
    //         }

    //         return false;
    // }
//     public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
        
//         for(int i=0;i<t;i++){
//             int n=scn.nextInt();
//             int m=scn.nextInt();
        
//             int[] arr=new int[n];
//             for(int j=0;j<n;j++){
//                 arr[j]=scn.nextInt();
//             }
//             boolean[] visited=new boolean[n];
            
//             if(recursion(arr, visited, 0, 1, m)){System.out.println("Yes");}
//             else{System.out.println("No");}
           
//         }
//     }
// }        

//     static class pair{
//         int val,idx;
//         pair(int val,int idx){this.val=val; this.idx=idx;}
//     }
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
        
//         for(int i=0;i<t;i++){
//             int n=scn.nextInt();
//             int m=scn.nextInt();
//             int[] inrat=new int[n];
//             for(int j=0;j<n;j++){
//                 inrat[j]=scn.nextInt();
//             }
//             int[][] arr=new int[n][m];
//             for(int j=0;j<n;j++){
//                 for(int k=0;k<m;k++){
//                     int val=scn.nextInt();
//                     arr[j][k]=val+inrat[j]; inrat[j]=arr[j][k];
//                 }
//             }
//             int[][] rankarr=new int[n][m];
            
//            for(int j=0;j<m;j++){
//             pair[] row=new pair[n];   
//             for(int k=0;k<n;k++){
//                   row[k]=new pair(arr[k][j],k);  
//                 }

//              Arrays.sort(row,(p1,p2)->p1.val-p2.val);
//              int rk=1;
//              rankarr[row[n-1].idx][j]=rk;
//              for(int k=n-2;k>=0;k--){
//                  if(row[k].val!=row[k+1].val){
//                      rk=n-k; rankarr[row[k].idx][j]=rk;
//                  }else{
//                     rankarr[row[k].idx][j]=rk;
//                  }
//              }   
//             }
//                 for(int j=0;j<n;j++){
//                 for(int k=0;k<m;k++){
//                     System.out.print(arr[j][k]+"  ");
//                 }
//                 System.out.println();
//             }
//             for(int j=0;j<n;j++){
//                 for(int k=0;k<m;k++){
//                     System.out.print(rankarr[j][k]+"  ");
//                 }
//                 System.out.println();
//             }
           
//             int ans=0;
//             for(int j=0;j<n;j++){
//                 int maxrat=Integer.MIN_VALUE; int maxrk=Integer.MAX_VALUE; int omrt=-1; int omrk=-1;
//                 for(int k=0;k<m;k++){
//                     if(arr[j][k]>=maxrat){
//                         if(arr[j][k]==maxrat){
//                             if(omrt==omrk){maxrat=arr[j][k]; omrt=k;}
//                             }else{
//                            maxrat=arr[j][k]; omrt=k; 
//                            }
//                     }
//                     if(rankarr[j][k]<maxrk){
//                         if(rankarr[j][k]==maxrk ){
//                             if(omrt==omrk){
//                             maxrk=rankarr[j][k]; omrk=k;}
//                         }else{
//                         maxrk=rankarr[j][k]; omrk=k;
//                         }
//                     }
//                 }
//                 if(omrk>=0 && omrt>=0 && omrk!=omrt){
//                     ans++;
//                 }
//             }   
//             System.out.println(ans); 
//         }
//         //  for(int i=0;i<t;i++){
//         //      System.out.println(res[i]);
//         //  }
// 	}
// }







//  class Codechef{

//     static class pair{
//         int val,idx;
//         pair(int val,int idx){this.val=val; this.idx=idx;}
//     }
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
        
//         for(int i=0;i<t;i++){
//             int n=scn.nextInt();
//             int m=scn.nextInt();
//             int[] inrat=new int[n];
//             for(int j=0;j<n;j++){
//                 inrat[j]=scn.nextInt();
//             }
//             int[][] arr=new int[n][m];
//             for(int j=0;j<n;j++){
//                 for(int k=0;k<m;k++){
//                     int val=scn.nextInt();
//                     arr[j][k]=val+inrat[j]; inrat[j]=arr[j][k];
//                 }
//             }
//             int[][] rankarr=new int[n][m];
            
//            for(int j=0;j<m;j++){
//             pair[] row=new pair[n];   
//             for(int k=0;k<n;k++){
//                   row[k]=new pair(arr[k][j],k);  
//                 }

//              Arrays.sort(row,(p1,p2)->p1.val-p2.val);
//              int rk=1;
//              rankarr[row[n-1].idx][j]=rk;
//              for(int k=n-2;k>=0;k--){
//                  if(row[k].val!=row[k+1].val){
//                      rk=n-k; rankarr[row[k].idx][j]=rk;
//                  }else{
//                     rankarr[row[k].idx][j]=rk;
//                  }
//              }   
//             }

//             // for(int j=0;j<n;j++){
//             //     for(int k=0;k<m;k++){
//             //         System.out.print(arr[j][k]+"  ");
//             //     }
//             //     System.out.println();
//             // }
//             // for(int j=0;j<n;j++){
//             //     for(int k=0;k<m;k++){
//             //         System.out.print(rankarr[j][k]+"  ");
//             //     }
//             //     System.out.println();
//             // }

//             int ans=0;
//             for(int j=0;j<n;j++){
//                 int maxrat=Integer.MIN_VALUE; int maxrk=Integer.MAX_VALUE; int omrt=-1; int omrk=-1;
//                 for(int k=0;k<m;k++){
//                     if(arr[j][k]>=maxrat){
//                         maxrat=arr[j][k]; omrt=k; 
//                     }
//                     if(rankarr[j][k]<maxrk){
//                         maxrk=rankarr[j][k]; omrk=k; 
//                     }
//                 }
//                 if(omrk>=0 && omrt>=0 && omrk!=omrt){
//                     ans++;
//                 }
//             }   
//             System.out.println(ans); 
//         }
//         //  for(int i=0;i<t;i++){
//         //      System.out.println(res[i]);
//         //  }
// 	}
// }

// Arrays.sort(arr);
//             HashMap<Integer,Integer> hm=new HashMap<>();
//             int ct=1;
//             for(int j=1;j<n;j++){
//                 if(arr[j-1]!=arr[j]){
//                     if(hm.containsKey(ct)){
//                         hm.put(ct,hm.get(ct)+1);
//                     }else{ hm.put(ct,1);}
//                     ct=1;
//                 }else{
//                     ct++;
//                 }
//             }
//             if(hm.containsKey(ct)){
//                 hm.put(ct,hm.get(ct)+1);
//             }else{ hm.put(ct,1);}

//             int ans=0; int max=0;
//             for(int key:hm.keySet()){
//                    if(hm.get(key)>=max){
//                        if(hm.get(key)==max){
//                            if(key<ans){ans=key;}
//                        }else{ans=key;}
//                        max=hm.get(key);
//                    } 
//             }












// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
//  public static String function1(int m,int tc,int th){
//         int ct=0;
//         while(ct<m){
            
//             if(tc<th){
//                 tc+=2;
//                 th-=1;
//             }else if(tc>th){
//                 tc-=1;
//                 th+=2;
//             }
//             ct++;
//             if(tc==th)return "Yes";
//         }
//       return "No";  
//     }
    
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
//         String[] res=new String[t];
        
        
//         for(int i=0;i<t;i++){
//             int a=scn.nextInt();
//             int b=scn.nextInt();
//             int c=scn.nextInt();
//             res[i]=function1(a,b,c);
//         }
//          for(int i=0;i<t;i++){
//              System.out.println(res[i]);
//          }
// 	}
// }


// /* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
//  public static int function1(int[] arr){
//      int n=arr.length;
//      int ct=0;
//      int div=1000000000;
     
//      for(int i=0;i<n;i++){
//          int sum=0;
//          for(int j=i;j<n;j++){
//              sum+=arr[j];
//              if(sum%div==0){
//                  ct++;
//              }
//          }
//      }
//      return ct;
//     }
    
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
//         int[] res=new int[t];
        
        
//         for(int i=0;i<t;i++){
//             int n=scn.nextInt();
//             int[] arr=new int[n];
            
//             for(int j=0;j<n;j++){
//             arr[j]=scn.nextInt();
//             }
            
//             res[i]=function1(arr);
//         }
//          for(int i=0;i<t;i++){
//              System.out.println(res[i]);
//          }
// 	}
// }


/* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
// //  public static String function1(int m,int tc,int th){
// //      if((th-tc)%3==0)return "No";
     
// //       return "Yes";  
// //     }
    
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 		Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
//         String[] res=new String[t];
        
        
//         for(int i=0;i<t;i++){
//             int a=scn.nextInt();
//             int b=scn.nextInt();
//             int c=scn.nextInt();
//             res[i]=((c-b)%3==0?"No":"Yes");
//         }
//          for(int i=0;i<t;i++){
//              System.out.println(res[i]);
//          }
// 	}
// }






// // /* package codechef; // don't place package name! */

// // import java.util.*;
// // import java.lang.*;
// // import java.io.*;

// // /* Name of the class has to be "Main" only if the class is public. */
// // class Codechef
// // {
// //     public static String function1(int m,int tc,int th){
// //         int ct=0;
// //         while(ct<m){
            
// //             if(tc<th){
// //                 tc+=2;
// //                 th-=1;
// //             }else if(tc>th){
// //                 tc-=1;
// //                 th+=2;
// //             }
// //             ct++;
// //             if(tc==th)return "No";
// //         }
// //       return "Yes";  
// //     }
    
// // 	public static void main (String[] args) throws java.lang.Exception
// // 	{
// // 		// your code goes here
// // 		Scanner scn=new Scanner(System.in);
// //         int t=scn.nextInt();
// //         String[] res=new String[t];
        
        
// //         for(int i=0;i<t;i++){
// //             int a=scn.nextInt();
// //             int b=scn.nextInt();
// //             int c=scn.nextInt();
// //             res[i]=function1(a,b,c);
// //         }
// //          for(int i=0;i<t;i++){
// //              System.out.println(res[i]);
// //          }
// // 	}
// // }
