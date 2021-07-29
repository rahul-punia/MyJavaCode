import java.util.*;
import java.lang.*;
import java.io.*;



public class marchlt {

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
//StringBuilder sb=new StringBuilder();

public static void main(String[] args) throws Exception{
    // long v1=(int)200000000;  long v2=(int)200000000;
                 
    // long  ml=v1*v2; 40000000000000000   
    // System.out.println(ml);


    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    // int t= Integer.parseInt(br.readLine());
    
    // while(t-->0){
        // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
        String[] strs=(br.readLine()).trim().split(" ");
        int n=(int)Long.parseLong(strs[0]);long k=Long.parseLong(strs[1]);//,m=(int)Long.parseLong(strs[2]);//(int)
        // String str=(br.readLine()).trim();
        
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            strs=(br.readLine()).trim().split(" ");
            int st=(int)Long.parseLong(strs[0]),et=(int)Long.parseLong(strs[1]),val=(int)Long.parseLong(strs[2]);
            arr[i][0]=st;  arr[i][1]=et;  arr[i][2]=val;
        }

        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1])return  a[1]-b[1]; 
             return a[0]-b[0];
        });

        long[][] dp=new long[n][3];
        long ans=0;//Long.MIN_VALUE;//2000000_000000_000000L; //Long.MIN_VALUE;

        for(int i=0;i<n;i++){
            // int mp=Integer.MIN_VALUE;
            // int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            long min=arr[i][0],max=arr[i][1];
            long mp=(long)arr[i][2]-(long)((max-min)*k);
            
            for(int j=0;j<i;j++){
                long cmin=Math.min(dp[j][0], (long)arr[i][0]);
                long cmax=Math.max(dp[j][1], (long)arr[i][1]);
                long diff=dp[j][1]-dp[j][0];
                long actualdiff=(cmax-cmin)-diff;
                long cp=dp[j][2]+(long)arr[i][2]-((actualdiff)*k);

                // System.out.println(ans+"   arr= "+arr[i][0]+"  "+arr[i][1]+"  "+arr[i][2]+"    cp="+cp);
                if(mp<cp){
                    max=cmax;  min=cmin;  mp=cp;
                }
            }
            

            long rmin=arr[i][0],rmax=arr[i][1];
            long rmp=(long)arr[i][2]-(long)((max-min)*k);
            for(int j=0;j<i;j++){
                long rcmin=Math.min(dp[j][0], (long)arr[i][0]);
                long rcmax=Math.max(dp[j][1], (long)arr[i][1]);

                if(arr[j][0]>=rmin && arr[j][1]<=rmax){
                    rmp+=arr[j][2];
                }else{
                    long ex=0;
                    if((rmin-arr[j][0])>0){
                        ex+=(rmin-arr[j][0]);
                    }
                    if((arr[j][1]-rmax)>0){
                        ex+=(arr[j][1]-rmax);
                    }
                    
                    if((long)arr[j][2]>((ex*k))){
                        rmp+=arr[j][2];
                        rmin=Math.min(rmin, arr[j][0]);  rmax=Math.max(rmax, arr[j][1]);
                    }
                }
                
            }               
            if(mp<rmp){
                max=rmax;  min=rmin;  mp=rmp;
            }

            dp[i][0]=min;  dp[i][1]=max;  dp[i][2]=mp;
            ans=Math.max(ans, dp[i][2]);
            // System.out.println(ans+"   arr= "+arr[i][0]+"  "+arr[i][1]);
        }

        System.out.println(ans);
    //    }
    }
}

// 3 2
// 2 3 1
// 3 5 1
// 2 10 50


//     //Ques-4
//     static long mod=998244353;
//     static int[] parent;
//     //Disjoint Set Union of clubs not for students
//     public static int find_ldr(int a){
//         if(parent[a]!=a){
//            return find_ldr(parent[a]);
//         }else{
//             return parent[a];
//         }
//     }

//     public static void set_union(int a,int b){
//         int la=find_ldr(a);
//         int lb=find_ldr(b);

//         parent[la]=lb;
//     }

//     public static long binexp(long a,long n){
//         if(n==0)return 1;

//         long res=binexp(a, n/2);

//         if(b%2==1){
//             //return (res*res*a)%mod;  mymistake didnot use mod properly
//             return (((res*res)%mod)*a)%mod;
//         }else{
//             return  (res*res)%mod;
//         }
//     }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         int t= Integer.parseInt(br.readLine());
        
//         while(t-->0){
//             // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             long c=Long.parseLong(strs[0]),n=Long.parseLong(strs[1]),m=Long.parseLong(strs[2]);//(int)
//             // String str=(br.readLine()).trim();
            
            
//             // int[] arr=new int[(int)n];
//             // ArrayList<int[]> list=new ArrayList<>();
//             // long diff=0;

//             ArrayList<int[]> plist=new ArrayList<>();


//             for(int i=0;i<c;i++){
//                 int xi=Integer.parseInt(br.readLine());
//                 strs=(br.readLine()).trim().split(" ");
                
//                 for(int j=0;j<(2*xi);j+=2){
//                     int li=(int)Long.parseLong(strs[j]),ri=(int)Long.parseLong(strs[j+1]);
//                     int[] pr=new int[]{i,li,ri};
//                     plist.add(pr);
//                 }
//             }

            

//             Collections.sort(plist,new Comparator<int[]>(){
//                public int compare(int[] a1,int[] a2){
//                    if(a1[1]!=a2[1])return a1[1]-a2[1];
//                    return a1[2]-a2[2];
//                } 
//             });

//             parent=new int[(int)c];
//             for(int i=0;i<(int)c;i++){
//                 parent[i]=i;
//             }

//             // int prev_st=0;
//             int prev_ed=0;
//             int p_club=0;

//             int res=0;
//             for(int i=0;i<plist.size();i++){
//                 int[] pr=plist.get(i);
//                 int cclub=pr[0];

//                 if(prev_ed>=pr[1]){
//                     set_union(p_club, cclub);
//                     prev_ed=Math.max(prev_ed, pr[2]);
//                 }else{
//                     res+=pr[1]-prev_ed-1;
//                     prev_ed=pr[2];
//                 }
//                 p_club=cclub;
//             }

//             res+=n-prev_ed;

//             HashSet<Integer> hs=new HashSet<>();

//             for(int i=0;i<(int)c;i++){
//                 hs.add(find_ldr(i));
//             }

//             long diff=res+hs.size();

//             long ans=binexp(m, diff);

//             System.out.println(ans);
//         }

//     }
// }








//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         int t= Integer.parseInt(br.readLine());
        
//         while(t-->0){
//             // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             long c=Long.parseLong(strs[0]),n=Long.parseLong(strs[1]),m=Long.parseLong(strs[2]);//(int)
//             // String str=(br.readLine()).trim();
            
            
//             // int[] arr=new int[(int)n];
//             ArrayList<int[]> list=new ArrayList<>();
//             long diff=0;

//             for(int i=0;i<c;i++){
//                 int xi=Integer.parseInt(br.readLine());

//                 strs=(br.readLine()).trim().split(" ");

                

//                 boolean  flag=true;

//                 for(int j=0;j<(2*xi);j+=2){
//                     int li=(int)Long.parseLong(strs[j]),ri=(int)Long.parseLong(strs[j+1]);

//                     for(int k=0;k<list.size() && flag;k++){
//                         int[] rg=list.get(k);
//                         int oli=rg[0],ori=rg[1];

//                         if(oli>li){
//                             int tmp=oli; oli=li;  li=tmp;
//                         }
//                         // if(oli<=li){
//                             if(ori>=li){flag=false;  break;}
//                         // }
//                     }
//                 }

//                 if(flag){diff++;   diff=diff%mod;}
//                 // diff++;

                
//                 for(int j=0;j<(2*xi);j+=2){
//                     int li=(int)Long.parseLong(strs[j]),ri=(int)Long.parseLong(strs[j+1]);
//                     list.add(new int[]{li,ri});
//                 }

//                 // System.out.println("ii=="+diff);
//             }


//             // System.out.println("dd=="+diff);

//             Collections.sort(list,(a,b)->a[0]-b[0]);

//                 int len=list.size();
//                 int emax=0;
//                 for(int i=0;i<len && emax<n;i++){
//                     int[] arr=list.get(i);
//                     if(i==0){
//                         diff+=(arr[0]-1-emax);  emax=Math.max(emax, arr[1]);
//                     }else if(i==len-1){
//                         diff+=(n-emax);   emax=Math.max(emax, arr[1]);
//                     }else{
//                         if((arr[0]-1-emax)>0){diff+=(arr[0]-1-emax);  emax=Math.max(emax, arr[1]);}     
//                     }
//                     diff=diff%mod;

//                     // System.out.println(i+"  loop="+diff+"   "+arr[0]+"   "+arr[1]);
//                 }


//                 // System.out.println("dd"+diff);

//                 long ans=1;
//                 for(int i=0;i<diff;i++){
//                     ans=(ans*m)%mod;
//                 }

//            System.out.println(ans);
//             // System.out.println(diff+" diff "+ans);
//         }
//     }

// }














// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//         int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         // long x=Long.parseLong(strs[0]),r=Long.parseLong(strs[1]),m=Long.parseLong(strs[2]);//(int)
//         // String str=(br.readLine()).trim();
        

//         int[] hts=new int[n];

//         for(int i=0;i<n;i++){
//             hts[i]=Integer.parseInt(strs[i]);
//         }

//         Stack<Integer> st=new Stack<>();
//         int[] ans=new int[n];

//         st.push(0);

//         for(int i=1;i<n;i++){

//             while(st.size()>0 && hts[st.peek()]<hts[i]){
//                 st.pop();
//             }

//             if(st.size()>0 &&  hts[st.peek()]==hts[i]){
//                 ans[i]=ans[st.peek()]+1;  st.pop();
//             }

//             st.push(i);
//         }


//         st=new Stack<>();
//         st.push(n-1);
//         int[] ans2=new int[n];
//         for(int i=n-2;i>=0;i--){

//             while(st.size()>0 && hts[st.peek()]<hts[i]){
//                 st.pop();
//             }

//             if(st.size()>0 &&  hts[st.peek()]==hts[i]){
//                 ans2[i]=ans2[st.peek()]+1;  st.pop();
//             }

//             st.push(i);
//         }

//         for(int i=0;i<n;i++){
//             int val=(ans[i]+ans2[i]);
//             // if(val>0){val++;}

//             System.out.print(val+" ");
//         }

//         System.out.println();
//         // r=r*60;  m=m*60;

//         // long val=Math.min(x, r);
        
//         // if((r-x)>0){
//         //     val+=2*(r-x);
//         // }

//         // if(val<=m){
//         //     System.out.println("YES");
//         // }else{
//         //     System.out.println("NO");
//         // }


//         // long ans=0;
//         // PriorityQueue<Integer> pq=new PriorityQueue<>();

//         // long min=0;
//         // long ans=0;            
//         // if(a<y){
//         //     min=Math.min(y, a);
//         //     ans=(min*x)+1;
//         // }else{
//         //     min=Math.min(y, a);
//         //     ans=(min*x);
//         // }

//         // System.out.println(ans);
//     }
//  }
// }






//marchlt