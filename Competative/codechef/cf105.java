import java.util.*;
import java.lang.*;
import java.io.*;

//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> list=new ArrayList<>();
//HashSet<Integer> hs=new HashSet<>();
//Stack<Integer> st=new Stack<>();
//Queue<Integer> q=new LinkedList<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
// static ArrayList<ArrayList<Integer>> gp=new ArrayList<>();
//int[] arr=new int[n];
//System.out.println("YES");
//1 hr- atleast 2 qs d-2
//Mt_do 3 qs d-2  
//Mt_do 4 qs d-3


public class cf105 {
    
    public static int get(int val,int k){
        return (k-val%k)%k;
    }
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t= Integer.parseInt(br.readLine());

        while(t-->0){
        //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
            String[] strs=(br.readLine()).trim().split(" ");
            // // String strs=(br.readLine()).trim();
            int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

           String str=(br.readLine()).trim();

           if(n%k!=0){System.out.println(-1); continue;}

           int[] cnt=new int[26];

           for(char ch:str.toCharArray()){
               cnt[ch-'a']++;
           }

           int sum=0;

           for(int i=0;i<26;i++){
               sum+=get(cnt[i],k);
           }

           if(sum==0){
               System.out.println(str);  continue;
           }
           char[] s=str.toCharArray();
           boolean f=true;

           for(int i=n-1;i>=0 && f;i--){
            sum-=get(cnt[s[i]-'a'],k);
            cnt[s[i]-'a']--;
            sum+=get(cnt[s[i]-'a'],k);

            for(int j=(s[i]-'a')+1;j<26 && f;j++){
                int osum=sum;
                sum-=get(cnt[j],k);
                cnt[j]++;
                sum+=get(cnt[j],k);

                if(sum<=(n-(i+1))){
                    for(int r=0;r<i;r++){
                        System.out.print(s[r]);  //mymistake  s[i]
                    }

                    System.out.print((char)('a'+j));
                    String add="";
                    for(int r=0;r<26;r++){
                        int req=get(cnt[r], k);
                        char ch=(char)('a'+r);
                        while(req-->0){
                            add+=ch;//System.out.print(ch);
                        }
                    }

                    int cta=(n-(i+1))-add.length();//sum;
                    
                    while(cta-->0){add+='a';}

                    char[] aarr=add.toCharArray();

                    Arrays.sort(aarr);

                    for(char c1:aarr){System.out.print(c1);}

                    System.out.println();
                    f=false;
                    break;
                }
                cnt[j]--;
                sum=osum;
            }
           }
        }
    }
}




//      static int[] valid={1,1,1,0,0,1,0,0,1,0},rev={0,1,5,0,0,2,0,0,8,0};//my mistake
//     public static boolean check(int cm){
//         boolean f=true;
//         while(cm>0){
//             int r=cm%10;
//             cm=cm/10;
//             if(r==0 || r==1 || r==2 || r==5 || r==8){}
//             else{f=false; break;}
//         }

//         return f;
//     }
//     // static char ch='m';
//     public static int refn(int i){   //reflection
//         StringBuilder sb=new StringBuilder();
//         sb.append(""+i);
//         String ref1=sb.reverse().toString();
//         while(ref1.length()<2){ref1+='0';} //my mistake
//         String revs="";
//         for(char ch:ref1.toCharArray()){
//             revs+=rev[ch-'0'];   //my mistake
//         }
//         int val=Integer.valueOf(revs);
//         return val;
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             // int[] arr=new int[n+1];
//             int h=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//             strs=(br.readLine()).trim().split(":");
//             int hh=Integer.parseInt(strs[0]),mm=Integer.parseInt(strs[1]);

//             int i=hh;
//             int j=mm;
//             boolean of=false;
//             int ah=0,am=0;
//             int run=0;
//             while(i<h && !of){
//                 boolean f11=check(i);
//                 boolean f22=check(j);
//                 int hr2=refn(j),mn2=refn(i);
//                     if(f11 && f22 && hr2<h && mn2<m && i<h && j<m){
//                         ah=i; am=j; of=true; break;
//                     }

//                 while(j<m){
//                     j++;  run++;
//                     boolean f1=check(i);
//                     boolean f2=check(j);
                    
//                     int hr=refn(j),mn=refn(i);
//                     if(f1 && f2 && hr<h && mn<m && i<h && j<m){
//                         ah=i; am=j; of=true; break;
//                     }
//                 }
//                 if(of){break;}
//                 if(j==m){i++; j=0; run++;}
//             }

//             //c2
//             //  i=hh; j=mm;   of=false;
//             // int ah2=0,am2=0;  int run2=0;
            
//             // while(i>=0 && !of){
//             //     boolean f11=check(i);
//             //     boolean f22=check(j);
//             //     int hr2=refn(j),mn2=refn(i);
//             //         if(f11 && f22 && hr2<h && mn2<m && i<h && j<m){
//             //             ah2=i; am2=j; of=true; break;
//             //         }

//             //     while(j>0){
//             //         j--;  run2++;
//             //         boolean f1=check(i);   boolean f2=check(j);
//             //         int hr=refn(j),mn=refn(i);
//             //         if(f1 && f2 && hr<h && mn<m && i<h && j<m){
//             //             ah2=i; am2=j; of=true; break;
//             //         }
//             //     }
//             //     if(of){break;}
//             //     if(j==0){i--; j=m; run2++;}
//             // }
//             String s1=""+ah,s2=""+am; 
//             while(s1.length()<2){s1='0'+s1;}   while(s2.length()<2){s2='0'+s2;}

//             // if(run<run2){
//                 System.out.println(s1+":"+s2);
//             // }else{
//             //     System.out.println(ah2+" ans "+am2);
//             // }
           
//         }
//     }
// }







//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             // int[] arr=new int[n+1];
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//             int sum=0;
//             int ct=0,cv=1;
//             ArrayList<Integer> list=new ArrayList<>();
//             int st=(int)(Math.ceil((k*1.0)/2));
//             // while((sum+cv)<k){
//             //     sum+=cv;
//             //     list.add(cv);  cv++;  ct++;
//             // }
//             ct+=k-(st);
//             ct+=n-(k);
//             if(ct<0){ct=0;}

//             System.out.println(ct);
//             for(int i=st;i<k;i++){
//                 System.out.print(i+" ");
//             }
//             // for(int val:list){
//             //     System.out.print(val+" ");
//             // }
//             for(int i=k+1;i<=n;i++){
//                 System.out.print(i+" ");
//             }
//             System.out.println();
//         }
//     }
// }




//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");

//             int a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]);
//             int oa=a,ob=b;
//             int ct=0;

//             if(b<2){b++; ct++;}
            
//             while(a>0){
//                 ct++;
//                 a=a/b;
//                 if(a==b){b++; ct++;}
//             }
//             int ans=ct;
//             int ict=ct;
//             for(int i=1;i<ict;i++){

//                 b=ob+i;
//                 a=oa;  ct=i;
//                 while(a>0){
//                     ct++;
//                     a=a/b;
//                     if(a==b){b++; ct++;}
//                 }
//                 ans=Math.min(ans, ct);
//             }
//             System.out.println(ans);
//         }
//     }
// }
    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     // int t= Integer.parseInt(br.readLine());

    //     // while(t-->0){
    //     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         // String[] strs=(br.readLine()).trim().split(" ");
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         // // String strs=(br.readLine()).trim();
    //         // int[] arr=new int[n+1];
    //         int n=Integer.parseInt(strs[0]),q=Integer.parseInt(strs[1]),k=Integer.parseInt(strs[2]);

    //         long[] arr=new long[n+1];
    //         // Arrays.fill(arr, 10000_00000);
    //         strs=(br.readLine()).trim().split(" ");
    //         for(int i=0;i<n;i++){
    //             arr[i+1]=Long.parseLong(strs[i]);
    //         }
            
    //         long[] psum=new long[n+1];
    //         Arrays.fill(psum, 0L);
    //         for(int i=1;i<=(n);i++){
    //             if(i>1 && i<(n)){
    //                 psum[i]+=psum[i-1]+  (arr[i]-arr[i-1])+(arr[i+1]-arr[i])-2 ;
    //             }else if(i==1 && n>1){
    //                 psum[i]+=(arr[i+1]-2);
    //             }else if(i==(n) && n>1){
    //                 psum[i]+=psum[i-1]+k-(arr[i-1])-1;
    //             }
    //         }
            
    //         for(int j=0;j<q;j++){
    //             strs=(br.readLine()).trim().split(" ");
    //             long ans=0L;

    //             int l=Integer.parseInt(strs[0]),r=Integer.parseInt(strs[1]);
    //              if(l==r){System.out.println(k-1); continue;}

    //             if((r-1)>l){
    //                 ans+=psum[r-1]-psum[l];
    //             } 
    //             ans+=(arr[l+1]-2);
    //             ans+=k-(arr[r-1])-1;
    //             System.out.println(ans);
    //             // System.out.println("a= "+ans);
    //         }
            
    //     //  }   
    //     }
    // }

    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     // int t= Integer.parseInt(br.readLine());

    //     // while(t-->0){
    //     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         // String[] strs=(br.readLine()).trim().split(" ");
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         // // String strs=(br.readLine()).trim();
    //         // int[] arr=new int[n+1];
    //         int a=Integer.parseInt(strs[0]),b=Integer.parseInt(strs[1]),k=Integer.parseInt(strs[2]);
            
    //         int[] arrx=new int[a+b];
    //         int[] arry=new int[a+b];
    //         int n=a+b;
    //         arrx[0]=1; arry[0]=1;  b--;

    //         int i=n-1,ct=b;
    //         while(i>=0 && ct>0){
    //             arrx[i]=1; arry[i]=1;
    //             ct--; i--;
    //         }

    //         for(int i=0;i<a;i++){

    //         }
    //     }
    // }
    

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         // int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             // int[] arr=new int[n+1];
//             int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);

//             String s=(br.readLine()).trim();
//             String tt=(br.readLine()).trim();
            
//             int[] left=new int[m];
//             int[] right=new int[m];
//             int j=0;
//             for(int i=0;i<n;i++){
//                 if(s.charAt(i)==tt.charAt(j)){
//                     left[j]=i;
//                     j++;
//                     if(j>=m)break;
//                 }
//             }
//             j=m-1;
//             for(int i=n-1;i>=0;i--){
//                 if(s.charAt(i)==tt.charAt(j)){
//                     right[j]=i;
//                     j--;
//                     if(j<=0)break;
//                 }
//             }
//             int ans=0;
//             for(int i=0;i<m-1;i++){
//                 ans=Math.max(ans,(right[i+1]-left[i]));
//             }

//             System.out.println(ans);
//         // }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//            int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int[] arr=new int[n+1];
//             // long p=Long.parseLong(strs[0]);   arr[0]=Long.parseLong(strs[1]);
//             // arr[1]=Long.parseLong(strs[2]);     arr[2]=Long.parseLong(strs[3]);
//             // strs=(br.readLine()).trim().split(" ");

            
//             int[] lmax=new int[n];
//             int max=0,mi=0;
//             for(int i=0;i<n;i++){
//                 lmax[i]=mi;
//                 arr[i]=Integer.parseInt(strs[i]);
//                 max=Math.max(max,arr[i]);    
//                 if(max>arr[mi]){
//                     mi=i;  lmax[i]=mi; 
//                 }
//             }

//             int s=0,i=n-1;
//             int e=n-1;
//             ArrayList<Integer> list=new ArrayList<>();
//             while(s>=0 && i>=0){
//                 s=lmax[i];
//                 for(int j=s;j<=e;j++){
//                     list.add(arr[j]);
//                 }
//                 i=s-1;
//                 e=s-1;
//             }

//             for(int val:list){
//                 System.out.print(val+" ");
//             }
//             System.out.println();
//         }
//     }
// }


    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     int t= Integer.parseInt(br.readLine());

    //     while(t-->0){
    //     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         // String[] strs=(br.readLine()).trim().split(" ");
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         // // String strs=(br.readLine()).trim();
    //         long[] arr=new long[3];
    //         long p=Long.parseLong(strs[0]);   arr[0]=Long.parseLong(strs[1]);
    //         arr[1]=Long.parseLong(strs[2]);     arr[2]=Long.parseLong(strs[3]);
    //         // strs=(br.readLine()).trim().split(" ");

    //         long ans=Long.MAX_VALUE;
    //         for(int i=0;i<3;i++){
    //             long v1=p%arr[i];
    //             if(v1==0){ans=0; break;}
    //             ans=Math.min(ans, (arr[i]-v1));
    //         }
    //         // long ans1=((long)Math.ceil(((p*1.0))/a))*a  - p;
    //         // long ans2=((long)Math.ceil(((p*1.0))/b))*b - p;
    //         // long ans3=((long)Math.ceil(((p*1.0))/c))*c   - p;
    //         // long ans=Math.min((ans1), Math.min((ans2), (ans3)));

    //         System.out.println(ans);
    //     }
    //     }
    // }
    //100 0000 0000 0000 0000

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             // // int n=Integer.parseInt(strs[0]);
//             // strs=(br.readLine()).trim().split(" ");

//             while(q-->0){
//                 String[] strs=(br.readLine()).trim().split(" ");
//                 int s=Integer.parseInt(strs[0]);  int d=Integer.parseInt(strs[1]);

//                 boolean f=false;
//                 while(s!=u){
//                     //Recursion Backtracking
//                     for(int v=1;(s+v)<=d;v++){
//                         if((u&v)==v){
//                             u=u+v;
//                             break;
//                         }
//                     }
//                 }
//             }
//         // }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]);

//             strs=(br.readLine()).trim().split(" ");

//             int[] arr=new int[n];

//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//             }

//             int st=0;
//             long ans=0l;
//             while(st<n){
//                 while(st<n && arr[st]==1){st++;}
//                 if(st>=n){break;}    
//                 int j=st;

//                 for(int i=st+1;i<Math.min(n,st+arr[st]);i++){

//                 }
//                 while(j<n){
//                     int lj=j;
//                     j=j+arr[j];
//                     arr[lj]=Math.max(1, arr[lj]-1);
//                 }
//                 ans++;
//             }

//             System.out.println(ans);
//         }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]);
//             int u=Integer.parseInt(strs[1]);
//             int v=Integer.parseInt(strs[2]);
            
//             boolean f=false;
//             strs=(br.readLine()).trim().split(" ");
//             int[] arr=new int[n];
//             int ans=Integer.MAX_VALUE;
//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//                 if(i>0){ 
//                     if(Math.abs(arr[i]-arr[i-1])>=2){ans=0;}
//                     if(Math.abs(arr[i]-arr[i-1])==1){ans=Math.min(ans, Math.min(u, v));}
//                     if(Math.abs(arr[i]-arr[i-1])==0){ans=Math.min(ans, v+Math.min(u, v));}
//                  }//ct++;}
//             }
            
//             System.out.println(ans);
//         }
//     }
// }


            // int ans=Math.min((u+v), (2*v));  //same colm
            // if(f){
            //     ans=Math.min(u, ans);
            //     if(n==2 && (arr[0]==1 && arr[1]==2 || (arr[n-1]==1000000 && arr[n-2]==199999))){

            //     }else{
            //         ans=Math.min(v, ans);
            //     }
            // }
            // System.out.println(ans);
    //         }
    //     }
    // }





//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         // int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String[] strs=(br.readLine()).trim().split(" ");
//             // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]);
//             int q=Integer.parseInt(strs[1]);

//             strs=(br.readLine()).trim().split(" ");
//             int[] arr=new int[n];
//             int ct0=1;
//             int ct1=0;
//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//                 if(arr[i]==1){ct1++;}else{ct0++;}
//             }

//             for(int i=0;i<q;i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int tp=Integer.parseInt(strs[0]);  int x=Integer.parseInt(strs[1]);

//                 if(tp==1){
//                     x--;
//                     if(arr[x]==0){ct1++; ct0--; arr[x]=1-arr[x];}
//                     else{ct1--; ct0++; arr[x]=1-arr[x];}
                    
//                 }else{
//                     if(ct1>=x){System.out.println(1);}
//                     else{System.out.println(0);}
//                 }
//             }
//         }
//     // }
// }


    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     int t= Integer.parseInt(br.readLine());

    //     while(t-->0){
    //     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         // String[] strs=(br.readLine()).trim().split(" ");
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         // String strs=(br.readLine()).trim();
    //         int n=Integer.parseInt(strs[0]);
    //         int u=Integer.parseInt(strs[1]);
    //         int r=Integer.parseInt(strs[2]);
    //         int d=Integer.parseInt(strs[3]);
    //         int l=Integer.parseInt(strs[4]);


    //         // if(u>1 && r>1 && d>1 && l>1){System.out.println("YES"); continue;};
    //         // if(u==1 && r==1 && d==1 && l==1){System.out.println("YES"); continue;};
    //         // if(u==0 && r==0 && d==0 && l==0){System.out.println("YES"); continue;};
            
    //         // boolean[][] dp=new boolean[n][n];
    //         int ou=u,or=r,od=d,ol=l;

    //         if(u>=(n-1)){
    //             int df=(u-(n-2));

    //             if(df==2){r--; l--; df=0;}

    //             while(df>0){
    //                 if(r>l){r--;}
    //                 else{l--;}
    //                 df--;
    //             }
    //         }

    //         if(d>=(n-1)){
    //             int df=(d-(n-2));
    //             if(df==2){r--; l--; df=0;}

    //             while(df>0){
    //                 if(r>l){r--;}
    //                 else{l--;}
    //                 df--;
    //             }
    //         }
           
    //         if(r<0 || l<0){System.out.println("NO"); continue;}
    //         u=ou;   r=or;  d=od;  l=ol;
    //         if(l>=(n-1)){
    //             int df=(l-(n-2));

    //             if(df==2){d--; u--; df=0;}
    //             while(df>0){
    //                 if(u>d){u--;}
    //                 else{d--;}
    //                 df--;
    //             }
    //         }

    //         if(r>=(n-1)){
    //             int df=(r-(n-2));
    //             if(df==2){d--; u--; df=0;}
                
    //             while(df>0){
    //                 if(u>d){u--;}
    //                 else{d--;}
    //                 df--;
    //             }
    //         }

    //         if(r<0 || l<0 || u<0 || d<0){System.out.println("NO");}
    //         else{System.out.println("YES");}





            // //c1
            // boolean f=true;
            // if(u>=(n-1)){
            //     if(u==n){
            //         if(l<1 || r<1){f=false;}
            //         if(d==n && (l<2 || r<2)){f=false;}
            //     }

            //     if(u==n-1){
            //         if(d==(n-1) && ((r+l)<2)){
            //             f=false;
            //         }
            //         // if(d==n){}
            //         if((r+l)<1){f=false;}
            //     }
            // }

            // if(!f){System.out.println("NO"); continue;}
            // //c2
            // if(d>=(n-1)){
            //     if(d==n){
            //         if(l<1 || r<1){f=false;}
            //         if(u==n && (l<2 || r<2)){f=false;}
            //     }

            //     if(d==n-1){
            //         if(u==(n-1) && ((r+l)<2)){
            //             f=false;
            //         }
            //         if((r+l)<1){f=false;}
            //     }
            // }
            // if(!f){System.out.println("NO"); continue;}
            // //c3
            // if(l>=(n-1)){
            //     if(l==n){
            //         if(l<1 || r<1){f=false;}
            //         if(r==n && (u<2 || d<2)){f=false;}
            //     }

            //     if(l==n-1){
            //         if(r==(n-1) && ((u+d)<2)){
            //             f=false;
            //         }
            //         if((u+d)<1){f=false;}
            //     }

            // }
            // if(!f){System.out.println("NO"); continue;}
            // //c4
            // if(r>=(n-1)){
            //     if(r==n){
            //         if(l<1 || r<1){f=false;}
            //         if(l==n && (u<2 || d<2)){f=false;}
            //     }

            //     if(r==n-1){
            //         if(l==(n-1) && ((d+u)<2)){
            //             f=false;
            //         }
            //         if((u+d)<1){f=false;}
            //     }
            // }

            // if(!f){System.out.println("NO"); continue;}
            // else{System.out.println("YES");}
//         }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // String[] strs=(br.readLine()).trim().split(" ");
//             String strs=(br.readLine()).trim();
            
//             // int[] arr=new int[n];
//             int ca=0,cb=0,cc=0;
//             for(int i=0;i<strs.length();i++){
//                if(strs.charAt(i)=='A'){
//                    ca++;
//                }else if(strs.charAt(i)=='B'){
//                 cb++;
//                 }else{
//                     cc++;
//                 }
//             }

//             if((ca+cb)==cc || (cc+cb)==ca || (ca+cc)==cb){
//                 Stack<Integer> st=new Stack<>();
//                 char f1='A',f2='B',f3='C';
//                 // if((ca+cb)==cc){
//                 //     f1=ca; f2=cb; f3=cc;
//                 // }else 
//                 if((cc+cb)==ca){
//                     f1='C'; f2='B'; f3='A';
//                 }else if((ca+cc)==cb){
//                     f1='A'; f2='C'; f3='B';
//                 }

//                 int ct=0;
//                 boolean f=true;
//                 for(char ch:strs.toCharArray()){
//                     if(strs.charAt(0)==f1 || strs.charAt(0)==f2){
//                         if(ch==f1 || ch==f2){ct++;}
//                         else{ct--;}
//                     }else{
//                         if(ch==f3){ct++;}
//                         else{ct--;}
//                     }
//                     if(ct<0){f=false; break;}
//                 }                

//                 if(f){
//                     System.out.println("YES");
//                 }else{
//                     System.out.println("NO");
//                 }
//             }else{
//                 System.out.println("NO");
//             }
            
//         }
//     }
// }
