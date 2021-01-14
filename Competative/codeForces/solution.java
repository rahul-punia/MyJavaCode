import java.lang.reflect.Array;
import java.util.*;

public class solution {
    
 
    public static void sieveofEr(int n){
      int[] sieve=new int[n+1];
      int ans=0;
      for(int x=2;x<=n;x++){
          if(sieve[x]!=0)continue; //prime number
            ans+=x;
          for(int u=2*x;u<=n;u=u+x){
              sieve[u]=x;
          }
      }
       System.out.println(ans);
  }

  //MAX NO OF CANDY
	// public static void main (String[] args) throws java.lang.Exception
	// {
	// 	// your code goes here
	// 	   Scanner scn=new Scanner(System.in);
         
  //         // System.out.println(Math.pow(2,30));

  //         int t=scn.nextInt();
          
  //         for(int i=0;i<t;i++){
  //             int n=scn.nextInt();
  //             int m=scn.nextInt();
  //             int x=scn.nextInt();
  //             int y=scn.nextInt();
  //           //   int[][] strg=new int[n][m];
  //           //  for(int j=0;j<n;j++){
  //           //    for(int k=0;k<m;k++){
  //           //    strg[j][k]=scn.nextInt();
  //           //    }
  //           //  }
  //            int ans=0;
  //            if(m%2==0){//col even
  //               if(y%2==0){//max cand
  //                 if(x>=y/2){
  //                   ans=n*m*(y/2);
  //                 }else{
  //                   ans=n*m*(x);
  //                 }
  //               }else {
  //                 if(x>=y/2){
  //                   ans=n*(m/2)*(y);
  //                 }else{
  //                   ans=n*m*(x);
  //                 }  
  //               }
  //            }else{
  //             if(y%2==0){//max cand
  //               if(x>=y/2){
  //                 ans=n*m*(y/2);
  //               }else{
  //                 ans=n*m*(x);
  //               }
  //             }else {
  //               if(x>=y/2){
  //                  ans=n*(m/2)*(y);
  //                  ans+=(y*(n/2));    
  //                  if(n%2==1){
  //                      ans+=y/2+1;
  //                  }
  //               }else{
  //                 ans=n*m*(x);
  //               }  
  //             }
  //           }
  //           System.out.println(ans);
  //           }
	// }

//MAX CONCAT
//   public static long bnum(String str){
//     long ans=0;
//     long pw=0;
//     for(int i=str.length()-1;i>=0;i--){
//         ans+=(int)(str.charAt(i)-'0')*(int)Math.pow(2,pw);
//         pw++;
//     }
//     return ans;
//   }

//   public static long BinaryConcatenation(int X, int Y){
//   String binX = Integer.toBinaryString(X);
//   String binY = Integer.toBinaryString(Y);
// //   System.out.println(binX+"b"+binY);
//   String binXplusY = binX + binY;
//   String binYplusX = binY + binX;

//   long XplusY =bnum(binXplusY);
//   long YplusX = bnum(binYplusX);
// //   System.out.println(XplusY+" "+YplusX);
//   return XplusY - YplusX;
//   }
// public static void main (String[] args) throws java.lang.Exception
// {
// // your code goes here
//  Scanner scn=new Scanner(System.in);
     
//       int t=scn.nextInt();
      
//       for(int i=0;i<t;i++){
//           int n=scn.nextInt();
//           int[] arr=new int[n];
//          for(int j=0;j<n;j++){
//            arr[j]=scn.nextInt();
//          }
//         // Arrays.sort(arr);
//         long ans=0;
//         for(int r=0;r<n;r++){
//             long cval=0;
//             for(int c=0;c<n;c++){
//                 // if(r!=c){
//                 cval=BinaryConcatenation(arr[r],arr[c]);
//                 ans=Math.max(ans,cval);
//                 // }
//             }
//         }
        
//         // long ans=BinaryConcatenation(arr[0],arr[arr.length-1]);
//         System.out.println(ans);
//       }
// }


public long findArea(long N, long M, long X, long Y) {
  long og = X;
  if (Y < X) {
      X = Y;
  }
  long diff = (Y - X) > X ? X : (Y - X);
  if (M < N) {
      long temp = N;
      N = M;
      M = temp;
  }
  if (M == 1 && N == 1) {
      return og;
  }
  if (M % 2 == 0) {
      long row = ((M / 2) * X) + ((M / 2) * diff);
      return row * N;
  } else {
      M = M - 1;
      long row = (((M) / 2) * X) + (((M) / 2) * diff);
      long square = row * N;
      long edge = 0;
      if (N % M == 0) {
          edge = row * (N / M);
      } else {
          long small = diff * (N / 2);
          long big = X * (N - (N / 2));
          edge = (big + small);
      }
      return square + edge;
  }
}




  // int d=scn.nextInt();
  //          String str="a";
  //          boolean flag=false;
  //          for(int n=2;n<=26;n++){
  //            str=str+(char)(97+(n-1));
  //             int num=((n*(n+1))/2)-n;
  //             System.err.print(num+"  ");

  //             if(d==num){
  //               System.err.println(n);
  //              System.out.println(str);
  //              flag=true;
  //              break;
  //             }
  //          }

  //          if(flag)continue;


//   int  n=scn.nextInt();
//   int[] arr=new int[n];
  
//   for(int i=0;i<arr.length;i++){
//       arr[i]=scn.nextInt();
//   }
//  ArrayList<Pair> list=new ArrayList<>();

//  for(int i=0;i<arr.length-2;i++){
//    for(int j=i+1;j<arr.length-1;j++){
//      for(int k=j+1;k<arr.length;k++){
//        if(arr[i]+arr[j]>arr[k] && arr[j]+arr[k]>arr[i] && arr[k]+arr[i]>arr[j]){
//          if(arr[i]>arr[j] && arr[i]>arr[k]){
//            if(arr[j]>arr[k]){
//             list.add(new Pair(arr[i],arr[j],arr[k]));
//            }else if(arr[k]>arr[j]){
//             list.add(new Pair(arr[i],arr[k],arr[j]));
//            }
//          }else if(arr[j]>arr[i] && arr[j]>arr[k]){
//           if(arr[i]>arr[k]){
//             list.add(new Pair(arr[j],arr[i],arr[k]));
//           }else if(arr[k]>arr[i]){
//             list.add(new Pair(arr[j],arr[k],arr[i]));
//           }
//         }else if(arr[k]>arr[j] && arr[k]>arr[i]){
//           if(arr[j]>arr[i]){
//             list.add(new Pair(arr[k],arr[j],arr[i]));
//           }else if(arr[i]>arr[j]){
//             list.add(new Pair(arr[k],arr[i],arr[j]));
//           }
//         }
//        }
//      }
//    }
//  }

//  if(list.size()>0){
//    System.out.println("YES");
//  }else{
//    System.out.println("NO");
//    return;
//  }
//  Pair ans=new Pair(0,0,0);

//  for(int i=0;i<list.size();i++){
//     Pair rem=list.get(i);
//     if(rem.x>ans.x && rem.y>ans.y && rem.z>ans.z){
//       ans=rem;
//     }
//  }
 
//  System.out.println(ans.x+" "+ans.y+" "+ans.z);

  // static class Pair{
  //   int x,y,z;
  //   Pair(int x,int y,int z){
  //     this.x=x;
  //     this.y=y; this.z=z;
  //   }
  // }
 //   if(arr[0]==1 && ct1==1 && act>=1){
      //     System.out.println("Second");
      //   }

      // if(act==0){
      //   if(ct1%2==0){
      //    System.out.println("Second");
      //     }else{
      //     System.out.println("First");
      //   }
      // }else if(ct1==0){
      //      System.out.println("First");
      // }else if(arr[0]==1){
      //       if(ct1%2==1){
      //         System.out.println("Second");
      //       }else{
      //     System.out.println("First");
      //       }
      // }else{

      // }
  
      public static long bnum(String str){
        long ans=0;
        long pw=0;
        for(int i=str.length()-1;i>=0;i--){
            ans+=(int)(str.charAt(i)-'0')*(int)Math.pow(2,pw);
            pw++;
        }
        return ans;
      }

      public static long BinaryConcatenation(int X, int Y){
      String binX = Integer.toBinaryString(X);
      String binY = Integer.toBinaryString(Y);
      System.out.println(binX+"b"+binY);
      String binXplusY = binX + binY;
      String binYplusX = binY + binX;

      long XplusY =bnum(binXplusY);
      long YplusX = bnum(binYplusX);
      System.out.println(XplusY+" "+YplusX);
      return XplusY - YplusX;
      }
    public static void main(String[] args){
        // Scanner scn=new Scanner(System.in);
          // your code goes here
          Scanner scn=new Scanner(System.in);
         
          // System.out.println(Math.pow(2,30));

          int t=scn.nextInt();
          
          for(int i=0;i<t;i++){
              int n=scn.nextInt();
              int m=scn.nextInt();
              int x=scn.nextInt();
              int y=scn.nextInt();
            //   int[][] strg=new int[n][m];
            //  for(int j=0;j<n;j++){
            //    for(int k=0;k<m;k++){
            //    strg[j][k]=scn.nextInt();
            //    }
            //  }
             int ans=0;
             if(m%2==0){//col even
                if(y%2==0){//max cand
                  if(x>=y/2){
                    ans=n*m*(y/2);
                  }else{
                    ans=n*m*(x);
                  }
                }else {
                  if(x>=y/2){
                    ans=n*(m/2)*(y);
                  }else{
                    ans=n*m*(x);
                  }  
                }
             }else{
              if(y%2==0){//max cand
                if(x>=y/2){
                  ans=n*m*(y/2);
                }else{
                  ans=n*m*(x);
                }
              }else {
                if(x>=y/2){
                  ans=n*(m/2)*(y);
                  ans+=(y*(n/2));    
                  if(n%2==1){
                      ans+=y/2+1;
                  }
                }else{
                  ans=n*m*(x);
                }  
              }
            }
            System.out.println(ans);
            }
            // Arrays.sort(arr);
            // int ans=BinaryConcatenation(arr[0],arr[arr.length-1]);
            // long ans=0;
            // for(int r=0;r<n;r++){
            //     long cval=0;
            //     for(int c=0;c<n;c++){
            //         if(r!=c){
            //         cval=BinaryConcatenation(arr[r],arr[c]);
            //         ans=Math.max(ans,cval);
            //         }
            //     }
            // }

            // System.out.println(ans);
              // for(int j=0;j<n;j++){
              //     arr[j]=scn.nextInt();
              //     if(arr[j]%k==0){
              //       str+="1";
              //     }else{
              //       str+="0";
              //     }
              // }
          
          // System.out.println(str);
          // }
        
        // int tc=scn.nextInt();
        // // long[] res=new long[tc];
        
        // for(int i=0;i<tc;i++){
        // int n=scn.nextInt();
        // int[] arr=new int[n];
        // int ct1=0; int act=0;
        // long sum=0;

        // for(int j=0;j<n;j++){
        //   arr[j]=scn.nextInt();
        //   // if(arr[j]==1){ct1++;
        //   // }else{
        //   //   act++;
        //   // }
        // }
        // for(int j=0;j<n;j++){
        //   sum=sum^arr[j];
        // }
        //   System.out.println(sum);
        // if(sum==0){
        //   System.out.println("Second");
        // }else{
        //   System.out.println("First");
        // }


        // long sum=0;
      //   long[] sumarr=new long[n];
      //    sumarr[n-1]=arr[n-1];
      //   for(int j=n-2;j>=0;j--){
      //     sumarr[j]=arr[j]^arr[j+1];
      //   }
      //  boolean flag1=true;
      //   for(int j=0;j<n;j++){
      //     for(int c=1;c<=arr[j];c++){
      //       if(arr[j]==1){
      //         flag1=!flag1;
      //       }else if((c^sumarr[j+1])==0){

      //       }else{
      //         flag1=!flag1;
      //       }
      //     }
      //   }

      //   if(flag1==true){
      //     System.out.println("Second");
      //   }else{
      //     System.out.println("First");
      //   }

     
        // if(ct1==0){
        //   System.out.println("First");
        //   continue;
        // }else if(act==0){
        //    if(ct1%2==1){
        //      System.out.println("First"); 
        //      continue;
        //    }else{
        //      System.out.println("Second");
        //      continue;
        //    }
        // }


      //   boolean flag=true;// 1 t
      //   for(int j=0;j<n;j++){
      //     if((ct1==1 && act>1 && arr[j]!=1) || (ct1==0)){
      //         if(flag)System.out.println("First");
      //         else System.out.println("Second");
      //         break;
      //     }

      //     if(flag){
      //       if(n-j>1){
      //         if(arr[j]>1){
      //           if(ct1%2==0 && act%2==1){
      //             flag=false; 
      //           }   //else both get
      //           act--; 
      //         }else{
      //          flag=false;   ct1--;
      //         }
      //       }else{
      //         System.out.println("First");
      //       }
      //     }else if(flag==false){
      //       if(n-j>1){
      //         if(arr[j]>1){
      //           if(ct1%2==0 && act%2==1){
      //             flag=true; 
      //           }
      //           act--;
      //         }else{
      //          flag=true; ct1--;
      //         }
      //       }else{
      //         System.out.println("Second");
      //       }
      //     }
      //   }
      // }
    }
}













// import java.util.*;
// public class solution {
    
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
        
//           int k=scn.nextInt();
          
//           String str="s";
//           System.out.print("codeforces");
//           for(int i=0;i<k-1;){
//               if(str.length()<=(k-i-1)){
//                   System.out.print(str);
//                   i+=str.length();
//                    str+=str;
//                   if(str.length()>(k-i-1) && (k-i-1)>0){
//                     // System.out.println("tt"+str+" "+(k-i-1));
//                    str=str.substring(0,k-i-1);  
//                    System.out.print(str);
//                    i=k;
//                   }
//               }
//           }
//           System.out.println();
//       }
//  }



//  sssssssssssss

// import java.util.*;
// public class solution {
//     public static int function1(int a,int b,int n){
//       int ct1=0;
//     //   int ia=a;
//     //   int ib=b;
//     //   int ct2=0;
//     //   int ct3=0;
//     //   while(ia<=n){
//     //       ia+=b;
//     //       ct2++;
//     //   }
      
//     //   while(ib<=n){
//     //       ib+=a;
//     //       ct3++;
//     //   }
      
//     //   int ct=Math.min(ct2,ct3);
      
//       while(b<=n && a<=n){

//         if(a+b>b+a){

//         }
//         //   a+=b;
//         //   ct1++;
//         //   if(a>n)return ct1;
          
//         //   b+=a;
//         //   ct1++;
//       }
      
//       return Math.min(ct1,ct);
//   }
    
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         int tc=scn.nextInt();
//         int[] res=new int[tc];
        
//         for(int i=0;i<tc;i++){
//           int a=scn.nextInt();
//           int b=scn.nextInt();
//           int n=scn.nextInt();
          
// 	     res[i]=function1(a,b,n);
//         }
        
//         for(int i=0;i<tc;i++){
//              System.out.println(res[i]);
//         }
//     }
// }







// // import java.util.*;
// // public class solution {
    
// //     public static void main(String[] args){
// //         Scanner scn=new Scanner(System.in);
        
// //           int k=scn.nextInt();
          
// //           String str="codeforces";
          
// //           String s="s";
          
// //           for(int i=0;i<k-1;){
// //               int diff=str.length()-9;
// //               if((diff)<=(k-i-1)){
// //                   i+=diff;
// //                    str+=str.substring(9);
// //                    System.out.println(str+" "+diff+"  i="+i);
// //               }else{
// //                    str+=str.substring(9,9+(k-i-1));
// //                    i=k;
// //               }
// //           }
          
// //         //   for(int i=0;str.length()<(10+k-1);i++){
// //         //       if((str.length()+s.length())<=(10+k-1)){
// //         //           str+=s;
// //         //           s+="s";
// //         //       }else{
// //         //           str+="s";
// //         //           s="ss";
// //         //       }
// //         //   }
// // 	     System.out.println(str);
// //       }
// //  }







// // import java.util.*;
// // public class solution {
// //     public static int function1(int a,int b,int n){
// //       int ct1=0;
// //       int ia=a;
// //       int ib=b;
// //       int ct2=0;
// //       int ct3=0;
// //       while(ia<=n){
// //           ia+=b;
// //           ct2++;
// //       }
      
// //       while(ib<=n){
// //           ib+=a;
// //           ct3++;
// //       }
      
// //       int ct=Math.min(ct2,ct3);
      
// //       while(b<=n && a<=n){
// //           a+=b;
// //           ct1++;
// //           if(a>n)return ct1;
          
// //           b+=a;
// //           ct1++;
// //       }
      
// //        return Math.min(ct1,ct);
// //    }
    
// //     public static void main(String[] args){
// //         Scanner scn=new Scanner(System.in);
// //         int tc=scn.nextInt();
// //         int[] res=new int[tc];
// //         long start=System.currentTimeMillis();
// //         for(int i=0;i<tc;i++){
// //           int a=scn.nextInt();
// //           int b=scn.nextInt();
// //           int n=scn.nextInt();
          
// // 	     res[i]=function1(a,b,n);
// //         }
        
// //         for(int i=0;i<tc;i++){
// //              System.out.println(res[i]);
// //         }
// //         long end=System.currentTimeMillis();
// //        System.out.println(end-start+"  ms");
// //     }
// // }