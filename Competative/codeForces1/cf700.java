import java.util.*;
import java.lang.*;
import java.io.*;


public class cf700 {
    //Q2
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
 
		while (t-- > 0) {
			// int[] arr = new int[n];
            String[] arrp = (br.readLine()).trim().split(" ");

             int A=Integer.parseInt(arrp[0]);
             int B=Integer.parseInt(arrp[1]);
            int n=Integer.parseInt(arrp[2]);
            String[] str=(br.readLine()).trim().split(" ");

            int[]a=new int[n];
            int[]b=new int[n];
            
            
            for(int i=0;i<n;i++){
                int val=Integer.parseInt(str[i]);
                a[i]=val;
            }
            str=(br.readLine()).trim().split(" ");
            long max=-1;
            long rh=0;
            
            long total=0;
            for(int i=0;i<n;i++){
                int val=Integer.parseInt(str[i]);
                b[i]=val;
                double vv=(b[i]*1.0)/A;
                // System.out.println(vv);
                rh=((long)(Math.ceil(vv)))*a[i];
                total+=rh;
                // if(max<rh){max=Math.max(rh,max);}  // && max<b[i]
            }
            
            boolean flag=false;
            int ct=0;
            for(int i=0;i<n;i++){
                long curr=(int)(total-(long)a[i]);
                if((((long)B-curr)>0){
                    flag=true;
                    break;
                }
            }
                // if(B<=0){flag=false;   break;}
                // double vv=(b[i]*1.0)/A;
                // rh=((long)(Math.ceil(vv)))*a[i];
                // sum+=(rh);

                // if(A<b[i] && B<rh){flag=false; break;}
                // if(max==rh && ct<1){
                //     ct++; 
                //     continue;
                // }
                
                // B=B-(int)rh;
                // if(B<=0 && ct>0){flag=false;   break;}
                // System.out.println(rh+" "+B);
            // }

            // if(B>=total){System.out.println("YES"); continue;}

            if(flag){   //((long)(B)-sum)>=0 &&
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        }
    }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
 
// 		while (t-- > 0) {
// 			String str = (br.readLine());
//             // int[] arr = new int[n];
            
//             StringBuilder nstr=new StringBuilder();
// 			for (int i = 0; i <str.length(); i++) {
//                 if(i%2==0){
//                     if(str.charAt(i)=='a'){nstr.append("b");}
//                     else{nstr.append("a");}
//                 }else{
//                     if(str.charAt(i)=='z'){nstr.append("y");}
//                     else{nstr.append("z");}
//                 }
//             }
            
//             String st=nstr.toString();

//             System.out.println(st);
//         }
//     }
// }
