import java.util.*;
import java.io.*;
import java.lang.*;

public class cf712 {
    
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        // int t = Integer.parseInt(br.readLine());
        // fill();

    //    while(t-->0){
        int n =Integer.parseInt(br.readLine());
        // String[] strs=(br.readLine()).trim().split(" ");
        // String str=(br.readLine()).trim();
        
        ArrayList<int[]> []arr=new ArrayList [2];

        arr[0]=new ArrayList<>();
        arr[1]=new ArrayList<>();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                (arr[(i+j)%2]).add(new int[]{i,j});
            }
        }
        int black=0,white=1;

        //1-white  ,2-black  , 3-black or white
        for(int tr=1;tr<=(n*n);tr++){
            int a=0, b=0, i=0, j=0, col=0;
            // a=Integer.parseInt(strs[tr-1]);
            a =Integer.parseInt(br.readLine());
            // br.readLine();

            if(a==1){
                if((arr[black]).size()>0){
                    col=black;   b=2;
                }else{
                    col=white;   b=3;
                }
            }else if(a==2){
                if((arr[white]).size()>0){
                    col=white;   b=1;
                }else{
                    col=black;   b=3;
                }
            }else{
                if((arr[black]).size()>0){
                    col=black;       b=2;
                }else{
                    col=white;       b=1;    
                }
            }

            int[] cord=(arr[col]).remove((arr[col]).size()-1);

            System.out.println(b+" "+cord[0]+" "+cord[1]);
            // System.out.println();
            System.out.flush();  //Imp
        }

    //    }
    }
}



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t = Integer.parseInt(br.readLine());
//         // fill();

//        while(t-->0){
//         int n =Integer.parseInt(br.readLine());
//         // String[] strs=(br.readLine()).trim().split(" ");
//         String str=(br.readLine()).trim();
        
//         StringBuilder sba=new StringBuilder(),sbb=new StringBuilder();

//         int ct0=0,ct1=0;

//         for(char ch:str.toCharArray()){
//             if(ch=='1'){
//                 ct1++;
//             }else{  ct0++; }
//         }

//         if((ct1&1)==1){
//             System.out.println("NO");
//             continue;
//         }

//         boolean f=true;
//         int oct=0,cct1=0,cct2=0;
//         boolean ans=true;
//         for(int i=0;i<n;i++){
//             if(str.charAt(i)=='0'){
//                 if(f){
//                     sba.append('(');    sbb.append(')');  cct1++;  cct2--;
//                 }else{
//                     sba.append(')');    sbb.append('(');  cct1--;  cct2++;
//                 }
//                 f=!f;
//             }else{
//                 if(oct<(ct1/2)){
//                     sba.append('(');    sbb.append('(');   cct1++;  cct2++;
//                 }else{
//                     sba.append(')');    sbb.append(')');   cct1--;  cct2--;
//                 }
//                 oct++;
//             }
//             if(cct1<0 || cct2<0){ans=false; break;}
//         }


//         if(ans){
//             System.out.println("YES");
//             String stra=sba.toString();  String strb=sbb.toString();
//             System.out.println(stra);
//             System.out.println(strb);
//         }else{
//             System.out.println("NO");
//         }

//      }
//   }
// }




//         int oba=0;
//         int obb=0;

//         int oba0=0;
//         int obb0=0;

        
//         for(int i=0;i<n;i++){
//             if(str.charAt(i)=='1'){
//                 if(oba==0 || obb==0){sba.append('(');   sbb.append('(');  oba++; obb++;}
//                 else{ sba.append(')');   sbb.append(')');  oba--; obb--; 
//             }
//             }else{
//                 if(oba==0){
//                     sba.append('(');   sbb.append(')');  oba++; obb--;
//                 }else if(obb==0){
//                     sba.append(')');   sbb.append('(');  oba--; obb++;
//                 }else{
//                     if(oba>=obb){
//                         sba.append(')');   sbb.append('(');  oba--; obb++;
//                     }else{
//                         sba.append('(');   sbb.append(')');  oba++; obb--; 
//                     }
//                 }
//             }
//         }




//         String stra=sba.toString();  String strb=sbb.toString();
            
//         // System.out.println(stra+" tt "+strb);

//         boolean flag=true;
//         int ct=0;

//         for(char ch:stra.toCharArray()){
//             if(ch=='('){ct++;}
//             else{ct--;}
//             if(ct<0){flag=false; break;}
//         }

        
//         ct=0;
//         for(char ch:strb.toCharArray()){
//             if(!flag){break;}
//             if(ch=='('){ct++;}
//             else{ct--;}
//             if(ct<0){flag=false; break;}
//         }

//         if(sba.length()==n && flag){
//             System.out.println("YES");
//             System.out.println(stra);
//             System.out.println(strb);
//         }else{
//             System.out.println("NO");
//         }

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
    //         // String[] strs=(br.readLine()).trim().split(" ");
    //         String stra=(br.readLine()).trim();
    //         String strb=(br.readLine()).trim();

    //         int[] ct0=new int[n];
    //         int[] ct1=new int[n];
    //         char []arr1=stra.toCharArray();
    //         char []arr2=strb.toCharArray();

    //         int i=0;
    //         for(int ch:arr1){
    //             if(ch=='0'){
    //                 ct0[i]++;
    //             }else{
    //                 ct1[i]++;
    //             }
    //             if(i>0){ct0[i]+=ct0[i-1];  ct1[i]+=ct1[i-1];  }
    //             i++;
    //         }

    //         int flip=0;

    //         int e1=n-1;//,e2=n-1;
    //         boolean flag=true;

    //         while(e1>=0){

    //             if(flip%2==1){
    //                 if(arr1[e1]=='0'){ arr1[e1]='1'; }
    //                 else{ arr1[e1]='0';  }
    //             }

    //             if(arr1[e1]!=arr2[e1]){
    //                 if(ct0[e1]==ct1[e1]){flip++;}
    //                 else{flag=false; break;}
    //             }
    //             e1--;
    //         }


    //         if(!flag){
    //             System.out.println("NO");  //"a1"+
    //         }else{
    //             System.out.println("YES");  
    //         }
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
//         // int n =Integer.parseInt(br.readLine());
//         // String[] strs=(br.readLine()).trim().split(" ");
//         String str=(br.readLine()).trim();
//         int ct=0;
//         for(char ch:str.toCharArray()){
//             if(ch=='a'){ct++;}
//         }

//         if(ct==str.length()){
//             System.out.println("NO");
//         }else{
//             System.out.println("YES");
//             int n=str.length();
//             // StringBuilder sb=new StringBuilder();
//             // sb.append(str);

//             int lo=0,hi=0;
//             String last=str+'a';
//             boolean isp=true;
//             n++;
//             if(n%2==0){
//                 lo=(n-1)/2;  hi=n/2;
//             }else{
//                 lo=n/2; hi=n/2;
//             }

//             while(lo>=0 && hi<n){
//                 if(last.charAt(lo)!=last.charAt(hi)){
//                     isp=false;  break;
//                 }
//                 lo--; hi++;
//             }

            
//             if(!isp){
//                 System.out.println(last);    //"l="+
//             }else{
//                 String first='a'+str;
//                 System.out.println(first);   //"f="+
//             }

            

//             // if(n%2==0){
//             //     lo=(n-1)/2;  hi=n/2;
//             // }else{
//             //     lo=n/2; hi=n/2;
//             // }

//             // while(lo>=0 && hi<n){
//             //     if(first.charAt(lo)!=first.charAt(hi)){
//             //         isp=false;  break;
//             //     }
//             //     lo--; hi++;
//             // }

//             // System.out.println(first);


//             // String ans="";
//             // while(lo>=0 && hi<n){
//             //     if(last.charAt(lo)!='a'){
//             //         ans=str.substring(0, hi)+'a'+str.substring(hi);  break;
//             //     }else if(str.charAt(hi)!='a'){
//             //         ans=str.substring(0, lo)+'a'+str.substring(lo);  break;
//             //     }
//             //     lo--; hi++;
//             // }

//             // System.out.println("a="+ans);
//         }
//        }
//     }

// }
