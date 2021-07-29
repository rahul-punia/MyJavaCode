import java.io.*;
import java.util.*;
import java.lang.*;

//Q4-  See soln at codeforces
public class cf699 {
    static int [] ans;
    public static boolean bfs(char[][] am,int s,int i,int m,char ch){
        int n=am.length-1;
        if(i==(m+1)){
            return true;
        }

        for( int j=1;j<=n;j++){
            if(s!=j && (i==0 || am[s][j]==ch) && am[s][j]!='*'){
                ans[i]=s;
                if(bfs(am, j, i+1, m, am[s][j])){return true;}
                ans[i]=0;
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(ip);

        long  t=Integer.parseInt(br.readLine());

        while(t-->0){
            // String[] arrp = (br.readLine()).trim().split(" ");
            String[] arrp = (br.readLine()).trim().split(" ");

             int n=Integer.parseInt(arrp[0]);
             int m=Integer.parseInt(arrp[1]);
             char[][] am=new char[n+1][n+1];   //adjmat
             int pr1=-1,pr2=-1;
            int cta=0,ctb=0;
             for(int i=1;i<=n;i++){
                String str=(br.readLine());

            //  int[] a = new int[n];
               for (int j = 0; j < n; j++) {
                   char ch=str.charAt(j);;
                   am[i][j+1]=str.charAt(j);

                   if(ch=='a'){cta++;}
                   else{ctb++;}
                   if(pr1==-1 && i!=(j+1) && am[i][j+1]==am[j+1][i]){pr1=i; pr2=j+1;}
                }
             }
             boolean flag=true; 
             if(pr1!=-1){
                 System.out.println("YES");
                 
                 for(int i=0;i<=m;i++){
                     if(flag){System.out.print(pr1+" ");}
                     else{System.out.print(pr2+" ");}
                     flag=!flag;
                 }
                 System.out.println();
             }else{
                 if(m%2==1){
                     System.out.println("YES");
                     for(int i=0;i<=m;i++){
                        if(flag){System.out.print(1+" ");}
                        else{System.out.print(2+" ");}
                        flag=!flag;
                    }
                    System.out.println();
                 }else{
                    //  System.out.println("NO");
                    // if(cta<m && ctb<m){System.out.println("NO");}
                    // else{
                        ans=new int[m+1];
                        boolean af=false;
                        for(int i=1;i<=n;i++){
                            af=bfs(am,1,0,m,'c');
                            if(af){break;}
                        }
                        
                        if(!af){System.out.println("NO"); continue;}
                        for(int i=0;i<=m;i++){
                            System.out.print(ans[i]+" ");
                        }
                        System.out.println();
                    // }
                 }  
             }
            
            }
        }
    }

//Q3
    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br=new BufferedReader(ip);

    //     long  t=Integer.parseInt(br.readLine());

    //     while(t-->0){
    //         // String[] arrp = (br.readLine()).trim().split(" ");
    //         String[] arrp = (br.readLine()).trim().split(" ");

    //          int n=Integer.parseInt(arrp[0]);
    //          int m=Integer.parseInt(arrp[1]);
    //         String[] str=(br.readLine()).trim().split(" ");

    //          int[] a = new int[n];
    //          for (int i = 0; i < n; i++) {
    //             a[i] = Integer.parseInt(str[i]);
    //          }

    //          str=(br.readLine()).trim().split(" ");
    //          int[] b = new int[n];
    //          ArrayList<Integer>[] g=new ArrayList [n+1];//graph conatins required (color->with plank indexes)
             
    //          for (int i = 0; i <= n; i++) { g[i]=new ArrayList<>();}

    //          for (int i = 0; i < n; i++) {
    //             b[i] = Integer.parseInt(str[i]);
               
    //             if(a[i]!=b[i]){      //imp
    //                 (g[b[i]]).add(i);
    //             }
    //          }  

    //          str=(br.readLine()).trim().split(" ");
    //          int[] c = new int[m];
            
            
    //          for (int i = 0; i < m; i++) {
    //             c[i] = Integer.parseInt(str[i]);
    //          }
    //          int last=-1;
    //          if((g[c[m-1]]).size()>0){  //imp
    //              ArrayList<Integer> list=(g[c[m-1]]);
    //              last=list.get(list.size()-1); list.remove(list.size()-1);
    //          }else{
    //              for(int i=0;i<n;i++){
    //                  if(b[i]==c[m-1]){last=i; break;}
    //              }
    //          }
    //          if(last==-1){System.out.println("NO"); continue;}

    //          int[] ans=new int[m];
    //          ans[m-1]=last;
    //          for(int i=0;i<(m-1);i++){  //fill
    //             if((g[c[i]]).size()>0){
    //                 ArrayList<Integer> list=(g[c[i]]);
    //                 ans[i]=list.get(list.size()-1); list.remove(list.size()-1);
    //             }else{
    //                 ans[i]=last;
    //             }
    //          }
    //          boolean flag=false;
             
    //          for(int i=1;i<=n;i++){   
    //             if((g[i]).size()>0){ //when mismatch color plank greater than no of painters
    //               flag=true; break;  
    //             }
    //          }

    //          if(flag){System.out.println("NO"); continue;}

    //          System.out.println("YES");

    //          for(int i=0;i<m;i++){
    //              System.out.print((ans[i]+1)+" ");
    //          }

    //          System.out.println();
    //         }
    //     }
    // }

//Q2

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br=new BufferedReader(ip);

//         long  t=Integer.parseInt(br.readLine());

//         while(t-->0){
//             // String[] arrp = (br.readLine()).trim().split(" ");
//             String[] arrp = (br.readLine()).trim().split(" ");

//                         int n=Integer.parseInt(arrp[0]);
//                         int k=Integer.parseInt(arrp[1]);
//             String[] str=(br.readLine()).trim().split(" ");

//              int[] arr = new int[n];
//              boolean flag=true;
//              for (int i = 0; i < n; i++) {
//                 arr[i] = Integer.parseInt(str[i]);
//                 if(i>0 && arr[i-1]<arr[i]){flag=false;}
//              }

//              if(flag){System.out.println("-1"); continue;}

//              int ans=0;
//              for(int i=0;i<k;i++){
//                  flag=true;
//                  for(int j=0;j<(n-1);j++){
//                      if(arr[j]<arr[j+1]){arr[j]++; ans=j+1; flag=false; break;}
//                  }
//                  if(flag){break;}
//              }

//              if(flag){System.out.println("-1");}
//              else{System.out.println(ans);}
//         }
//     }
// }

//Q1

//        static int[][] arr={{0,1},{0,-1},{1,0},{-1,0}};  //u,d,r,l
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br=new BufferedReader(ip);

//         long  t=Integer.parseInt(br.readLine());

//         while(t-->0){
//             // String[] arrp = (br.readLine()).trim().split(" ");

//             // int px=Integer.parseInt(arrp[0]);
//             // int py=Integer.parseInt(arrp[1]);

//             String str=(br.readLine());
//             //  int[] arr = new int[n];
//             int cx=0,cy=0;
//             for(int i=0;i<str.length();i++){
//                 if(str.charAt(i)=='R' && px>0 && cx<px){
//                     cx++;
//                 }else if(str.charAt(i)=='L' && px<0 && cx>px){
//                     cx--;
//                 }else if(str.charAt(i)=='U' && py>0 && cy<py){
//                     cy++;
//                 }else if(str.charAt(i)=='D' && py<0 && cy>py){
//                     cy--;
//                 }
//                 if(cx==px && cy==py){break;}
//             }
//             if(cx==px && cy==py){System.out.println("YES");}
//             else{System.out.println("NO");}
         
//         }
//     }
// }


