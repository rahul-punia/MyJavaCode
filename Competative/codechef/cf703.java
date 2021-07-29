import java.util.*;
import java.lang.*;
import java.io.*;


public class cf703 {
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t= Integer.parseInt(br.readLine());

        while(t-->0){
           int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
            // String[] strs=(br.readLine()).trim().split(" ");
            String[] strs=(br.readLine()).trim().split(" ");
            int[] arr=new int[n];

            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(strs[i]);
            }

            int ll1=-1,ll2=-1,ii=0;
            Stack<Integer> s1=new Stack<>();  Stack<Integer> s2=new Stack<>();
            int[] nfm=new int[n];   int[] nsm=new int[n];
            Arrays.fill(nfm, -1);  Arrays.fill(nsm, -1);
            while(ii<n){//(l1!=-1 || l2!=-1){

                if(arr[ii]>arr[ll1]){
                    ll2=ll1; ll1=ii;  //ff=true;

                    while(s1.size()>0 && arr[s1.peek()]<ll1){
                        nfm[s1.pop()]=ll1;
                    }
                    while(s2.size()>0 && arr[s2.peek()]<ll2){
                        nsm[s2.pop()]=ll2;
                    }
                }else if(arr[ii]>arr[ll2]){
                    ll2=ii;
                    while(s2.size()>0 && arr[s2.peek()]<ll2){
                        nsm[s2.pop()]=ll2;
                    }
                }
                ii++;

                }


            // boolean ff=false,sf=false;
            HashSet<Integer> hs=new HashSet<>();
            for(int j=0;j<n;j++){
                int l1=-1,l2=-1,i=j;
            while(i<n){//(l1!=-1 || l2!=-1){

                if(arr[i]>l1){
                    l2=l1; l1=arr[i];  //ff=true;
                }else if(arr[i]>l2){
                    l2=arr[i];
                }
                i=nfm;
                if(nsm[i]<nfm[i]){i=nsm[i];}
                else{i=nfm[i];}
                
                if(l1!=-1 && l2!=-1){
                    hs.add(Math.abs(l1-l2));
                }
                if(ll1==l1 && ll2==l2){break;}
                }
            }
            
            System.out.println(hs.size());


        }
    }
}


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // int[] arr=new int[n];
//             // int l=Integer.parseInt(strs[0]),r=Integer.parseInt(strs[1]);

//             // int ans=10000007;
//             // System.out.println(ans);


//             String strs=(br.readLine()).trim();
            
//             // HashMap<Character,Integer> hm=new HashMap<>();
//             int[] arr=new int[26];
//             for(int i=0;i<strs.length();i++){
//                 char ch=strs.charAt(i);
//                 arr[ch-'a']++;
//                 // hm.put(ch, hm.getOrDefault(ch, 0)+1);
//             }

//             int ec=0,oc=0;

//             for(int i=0;i<26;i++){
//                 int ct=arr[i];
//                 if(ct%2==1){
//                             oc++;
//                  }
//               ec+=(ct/2);
//             }
//             // for(char key:hm.keySet()){
//             //     int ct=hm.get(key);
//             //     if(ct%2==1){
//             //         oc++;
//             //     }
//             //     ec+=(ct/2);
//             // }

//             if(ec>=oc){
//                 System.out.println("YES");
//             }else{
//                 System.out.println("NO");
//             }
//         }
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
//             String strs=(br.readLine()).trim();
//             int[] arr=new int[n];
//             HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
//             hm.put(0, new ArrayList<>());
//             hm.put(1, new ArrayList<>());
            
//             for(int i=0;i<n;i++){
//                 if(strs.charAt(i)=='1'){arr[i]=1;}
//                 else{arr[i]=0;}
//             }
//             int[] ans=new int[n];

//             int tc=1;
//             for(int i=0;i<n;i++){

//                 if(arr[i]==1){
//                     ArrayList<Integer> list=hm.get(0);
//                     if(list.size()>0){
//                         int ct=list.remove(list.size()-1);
//                         ArrayList<Integer> list2=hm.get(1);
//                         list2.add(ct);
//                         hm.put(0, list);  hm.put(1, list2);
//                         ans[i]=ct;
//                     }else{
//                         ArrayList<Integer> list2=hm.get(1);
//                         list2.add(tc); ans[i]=tc; tc++;  hm.put(1, list2);
//                     } 
//                 }else{
//                     ArrayList<Integer> list=hm.get(1);
//                     if(list.size()>0){
//                         int ct=list.remove(list.size()-1);
//                         ArrayList<Integer> list2=hm.get(0);
//                         list2.add(ct);
//                         hm.put(1, list);  hm.put(0, list2);
//                         ans[i]=ct;
//                     }else{
//                         ArrayList<Integer> list2=hm.get(0);
//                         list2.add(tc); ans[i]=tc; tc++;  hm.put(0, list2);
//                         // list.add(tc); ans[i]=tc;  tc++;  hm.put(1, list);
//                     } 
//                 }

//             }


//             System.out.println((tc-1));
//             for(int i=0;i<n;i++){
//                 System.out.print(ans[i]+" ");
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
//            int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");

//             int[] arr=new int[n];
//             HashMap<Integer,Integer> hm=new HashMap<>();

//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//                 hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
//             }

//             if(n==1){
//                 System.out.println(0);  continue;
//             }
//             Arrays.sort(arr);

//             int mins=arr[0]+arr[1],maxs=arr[n-2]+arr[n-1];
//             int ans=0;
//             for(int sum=mins;sum<=maxs;sum++){
//                 int ct=0;
//                 for(int kk=1;kk<=(sum/2);kk++){
//                     int rem=sum-kk;
//                     if(rem==kk){
//                         ct+=(hm.getOrDefault(kk, 0))/2;
//                     }else{
//                         ct+=Math.min(hm.getOrDefault(kk, 0),hm.getOrDefault(rem, 0));
//                     }
//                 }
//                 ans=Math.max(ans, ct);
//             }

//             System.out.println(ans);
//         }
//     }
// }






//      public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//            int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             int[] arr=new int[n];
//             int mina=Integer.MAX_VALUE,minb=Integer.MAX_VALUE;

//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//                 mina=Math.min(mina,arr[i]);
//             }
//             strs=(br.readLine()).trim().split(" ");
//             // int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             int[] arrb=new int[n];
            
//             for(int i=0;i<n;i++){
//                 arrb[i]=Integer.parseInt(strs[i]);
//                 minb=Math.min(minb,arrb[i]);
//             }
//             long ans=0;
//             for(int i=0;i<n;i++){
//                 ans+=Math.max(Math.abs(arr[i]-mina), Math.abs(arrb[i]-minb));
//             }
//             System.out.println(ans);
//             // System.out.println("a "+ans);
//             // Arrays.sort(arr);
//             // boolean f=true;
//             // for(int i=1;i<n;i++){
//             //     if(arr[i-1]==arr[i] || (arr[i-1]+1)==arr[i]){

//             //     }else{
//             //         f=false;
//             //     }
//             // }

//             // if(f){System.out.println("YES");}
//             // else{System.out.println("NO");}
//         }

// }
// }
    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     // int t= Integer.parseInt(br.readLine());

    //     // while(t-->0){
    //     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);

    //         HashMap<Integer,HashSet<Integer>> gp=new HashMap<>();
    //         boolean fg=false;
            
    //         for(int i=0;i<m;i++){
    //             strs=(br.readLine()).trim().split(" ");
    //             int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
    //             // if(u==v){
    //                 HashSet<Integer> hs=gp.getOrDefault(u, new HashSet<>());
    //                 hs.add(i);  gp.put(u, hs);
    //                 if(hs.size()==m){fg=true;}    
    //             // }
    //             if(u!=v){
    //                 HashSet<Integer> hs2=gp.getOrDefault(v, new HashSet<>());
    //                 hs2.add(i);  gp.put(v, hs2);
    //                 if(hs2.size()==m){fg=true;}
    //             }
    //         }

    //         if(fg){System.out.println("YES"); return;}

    //         boolean f=false;
    //         // int[] kl=(gp.keySet()).toArray( );
    //        ArrayList<Integer> kl=new ArrayList<>();
    //        kl.addAll((gp.keySet()));  //imp

    //         // for(int key1:gp.keySet()){
    //             for(int i=0;i<kl.size();i++){
    //             int key1=kl.get(i);
    //             HashSet<Integer> hs1=gp.get(key1);
    //             int[] vst=new int[m];
    //             for(int idx:hs1){vst[idx]=1;}
                
    //             // for(int key2:gp.keySet()){
    //                 for(int j=i+1;j<kl.size();j++){
    //                     int ct=hs1.size();   
    //                     int key2=kl.get(j);
    //                 HashSet<Integer> hs2=gp.get(key2);
                    
    //                 if((hs1.size()+hs2.size())<m){continue;}
                    
    //                 for(int idx:hs2){if(vst[idx]!=1){vst[idx]=2; ct++;}}

    //                 // HashSet<Integer> chs=new HashSet<>();
    //                 // chs.addAll(hs1);  chs.addAll(hs2);
    //                 if(ct>=m){
    //                     f=true;
    //                     System.out.println("YES"); break;
    //                 }
    //             }
    //             if(f){break;}
    //         }

    //         if(!f){System.out.println("NO");}
    //     }
    // }







// //  In fact, you don't really need to consider the path Bob wanders. A priority queue is enough for this problem. When Bob visits a node, add its adjacent nodes into the priority queue. Every time he visits a new node, it will be one with the smallest index in the priority queue.
// //  Time complexity: (𝑚log𝑛)

//         static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
//         // static int ans=0;
//         // static int len=0;
//         // static boolean iscycle=false;
//         static int[] ans;
//         static PriorityQueue<Integer> pq=new PriorityQueue<>();
//         public static void dfs(int s,boolean[] vst){
            
//             ArrayList<Integer> list=graph.get(s);
//             // if(list.size()!=2){iscycle=false;}

//             System.out.print(s+" ");
//             // for(int nbr:list){pq.add(nbr)}
//             // Collections.sort(list);
//             for(int nbr:list){
//                 if(!vst[nbr]){
//                     vst[nbr]=true;
//                     pq.add(nbr);
//                 }
//             }

//             if(pq.size()>0){
//                 int nbr=pq.remove();
//                 dfs(nbr, vst);
//             }
            
//         }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         // int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//            // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]);//,b=Integer.parseInt(strs[1]);
//             int m=Integer.parseInt(strs[1]);//,y=Long.parseLong(strs[2]);

//                     for(int i=0;i<=(n);i++){graph.add(new ArrayList<>());}

//                         for(int i=0;i<m;i++){
//                             strs=(br.readLine()).trim().split(" ");
//                             int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
            
//                             graph.get(u).add(v);
//                             graph.get(v).add(u);
//                         }
            
//                         boolean[] vst=new boolean[n+1];
                        
//                         // for(int i=1;i<=n;i++){
//                             // if(!vst[i]){
//                                 vst[1]=true;
//                                 dfs(1, vst);
//                             // }
//                         // }
                        
//                         // System.out.println(ans);
//         }
//     }
















    // public static int rec(int[] arr,int s,int t,Integer[][] dp){
    //     int n=arr.length;
    //     if(s==n){return 0;}
        
    //     // if(dp[s][t]!=null){return dp[s][t];}

    //     int r1=rec(arr, s+1,t==0?1:0, dp)+arr[s];
    //     int r2=0;   // if(t==0){r2=n;}  
    //     if((s+1)<n){ r2=rec(arr, s+2,t==0?1:0, dp)+arr[s]+arr[s+1]; }
        
    //     if(t==0){
    //         if(((s+1)<n)){  dp[s][t]=Math.min(r1, r2); }
    //         else{dp[s][t]=(r1);}
    //         // dp[s][t]=Math.min(r1, r2);
    //     }else{
    //         if(((s+1)<n)){r2=r2-(arr[s]+arr[s+1]);}

    //         if(((s+1)<n)){  dp[s][t]=Math.min(r1-arr[s], r2); }
    //         else{dp[s][t]=(r1-arr[s]);}
    //     }

    //     return dp[s][t];
    // }


    // public static int rec(int[] arr,int s,int t,Integer[][] dp){
    //     int n=arr.length;
    //     if(s==n){return 0;}
        
    //     if(dp[s][t]!=null){return dp[s][t];}

    //     int r1=rec(arr, s+1,t==0?1:0, dp);
    //     int r2=0;   
    //     if((s+1)<n){ r2=rec(arr, s+2,t==0?1:0, dp); }
        
    //     if(t==0){   //Add skip Point only for this
    //         if(((s+1)<n)){  dp[s][t]=Math.min(r1+arr[s], r2+arr[s]+arr[s+1] ); }
    //         else{ dp[s][t]=(r1+arr[s]); }
    //     }else{
    //         if(((s+1)<n)){  dp[s][t]=Math.min(r1, r2); }
    //         else{dp[s][t]=r1;}
    //     }

    //     return dp[s][t];
    // }

    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     int t= Integer.parseInt(br.readLine());

    //     while(t-->0){
    //         int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         // int n=Integer.parseInt(strs[0]);//,b=Integer.parseInt(strs[1]);
    //         // int m=Integer.parseInt(strs[1]);//,y=Long.parseLong(strs[2]);

    //         int[] arr=new int[n];

    //         for(int i=0;i<n;i++){
    //             arr[i]=Integer.parseInt(strs[i]);
    //         }
    //         Integer[][] dp=new Integer[n][2];
    //         int ans=rec(arr, 0, 0, dp);
    //         System.out.println(ans);
    //         // boolean f=true;
    //         // int i=0,ans=0;
    //         // while(i<n){
    //         //     if(f){
    //         //         if(arr[i]==1){ans++;}
    //         //         i++;
    //         //         if(i<n && arr[i]==0){i++;}
    //         //     }else{
    //         //         i++;
    //         //         if(i<n && arr[i]==1){i++;}
    //         //     }
    //         //     f=!f;
    //         // }
    //         // System.out.println(ans);
    //         // System.out.println("aa=="+ans);
    //     } 
    //     }
    // }








    // static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    //     static int ans=0;
    //     static int len=0;
    //     static boolean iscycle=false;
    //     public static void dfs(int os,int s,boolean[] vst){
            
    //         ArrayList<Integer> list=graph.get(s);
    //         if(list.size()!=2){iscycle=false;}
            
    //         for(int nbr:list){
    //             // if(nbr==os && len>=2){ return;}
    //             if(!vst[nbr]){
    //                 len++;
    //                 vst[nbr]=true;
    //                 dfs(os,nbr, vst);
    //             }
    //         }
    //     }
    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     // int t= Integer.parseInt(br.readLine());

    //     // while(t-->0){
    //        // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         int n=Integer.parseInt(strs[0]);//,b=Integer.parseInt(strs[1]);
    //         int m=Integer.parseInt(strs[1]);//,y=Long.parseLong(strs[2]);

    //                 for(int i=0;i<=(n);i++){graph.add(new ArrayList<>());}

    //                     for(int i=0;i<m;i++){
    //                         strs=(br.readLine()).trim().split(" ");
    //                         int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
            
    //                         graph.get(u).add(v);
    //                         graph.get(v).add(u);
    //                     }
            
    //                     boolean[] vst=new boolean[n+1];
                        
    //                     for(int i=1;i<=n;i++){
    //                         if(!vst[i]){
    //                             iscycle=true; len=0;  vst[i]=true;
    //                             dfs(i,i, vst);
    //                             if(iscycle){ans++;}
    //                             // System.out.println(iscycle+" "+i+"  "+ans);
    //                         }
    //                     }
                        
    //                     System.out.println(ans);
    //     }
    // }











    // public static void main(String[] args) throws Exception{
    //     InputStreamReader ip=new InputStreamReader(System.in);
    //     BufferedReader br = new BufferedReader(ip);
    //     // Scanner scn=new Scanner(System.in);
    //     // int t= Integer.parseInt(br.readLine());

    //     // while(t-->0){
    //        // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
    //         String[] strs=(br.readLine()).trim().split(" ");
    //         int n=Integer.parseInt(strs[0]);//,b=Integer.parseInt(strs[1]);
    //         int m=Integer.parseInt(strs[1]);//,y=Long.parseLong(strs[2]);

    //         int[] dp=new int[m+1];

    //         for(int i=1;i<=m;i++){

    //             if(i<=n){dp[i]=n-i;}
    //             else{
    //                 int min=Integer.MAX_VALUE;

    //                 for(int j=i;j>=1;j--){
    //                     if((2*j)<i){break;}
    //                     min=Math.min(min,(dp[j]+1+((2*j)-i)));
    //                 }
    //                 dp[i]=min;
    //             }
    //         }

    //         int ans=dp[m];

    //         System.out.println(ans);
    //     }
    // }





//     static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
//     static int ans=0;

//     public static void dfs(int s,boolean[] vst,int cc,int m,int[] arr){
//         if(cc>m){return;}

//         ArrayList<Integer> list=graph.get(s);
//         if(list.size()==1 && s!=1 && cc<=m){ans++;}

//         for(int nbr:list){
//             if(!vst[nbr]){
//                 int oc=cc;
//                 if(arr[nbr]==1){cc++;}else{cc=0;}
//                 vst[nbr]=true;
//                 dfs(nbr, vst, cc,m,arr);
//                 cc=oc;
//             }
//         }
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         // int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//            // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]);//,b=Integer.parseInt(strs[1]);
//             int m=Integer.parseInt(strs[1]);//,y=Long.parseLong(strs[2]);
           
//             int[] arr=new int[n+1];
//             strs=(br.readLine()).trim().split(" ");
//             for(int i=0;i<n;i++){
//                 arr[i+1]=Integer.parseInt(strs[i]);
//             }

//             for(int i=0;i<=(n);i++){graph.add(new ArrayList<>());}

//             for(int i=0;i<(n-1);i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);

//                 graph.get(u).add(v);
//                 graph.get(v).add(u);
//             }

//             boolean[] vst=new boolean[n+1];
//             vst[1]=true;
//             dfs(1, vst,arr[1]==1?1:0, m,arr);

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
//            // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             long n=Long.parseLong(strs[0]);//,b=Integer.parseInt(strs[1]);
//             long s=Long.parseLong(strs[1]);//,y=Long.parseLong(strs[2]);
//             String n1=strs[0],n2=strs[1];
//             int i=0;
//             int cs=0,os=0;

//             while(i<n1.length()){
//                 int d=(int)(n1.charAt(i)-'0');
//                 os+=d;  i++;
//             }

//             if(os<=s){System.out.println(0); continue;}
//             i=0;
//             while(i<n1.length()){
//                 int d=(int)(n1.charAt(i)-'0');
//                 if((cs+d)<s){
//                    cs+=d; i++;
//                 }else{break;}
//             }
            
//             // int zc=n1.length()-i;
//             // int i=0;
//             long max=1;
//             long cnum=0;
//             while(i<n1.length()){
//                 max=max*10;
//                 int d=(int)(n1.charAt(i)-'0');
//                 cnum=cnum*10+d;
//                 i++;
//             }

//             long ans=max-cnum;
//             System.out.println(ans);
//             // System.out.println("a="+ans);
//         }
//     }
// }



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//            // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             long n=Long.parseLong(strs[0]);//,b=Integer.parseInt(strs[1]);
//             long x=Long.parseLong(strs[1]),y=Long.parseLong(strs[2]);
//             // int n=Integer.parseInt(strs[4]);

//             long lo=1,hi=(y-x);    
//             long ans=Integer.MAX_VALUE;
//             long end=Integer.MAX_VALUE;
//             while(lo<=hi){
//                 long mid=lo+(hi-lo)/2;
//                 long r=mid*(n-1);
                
//                 if((y-r)>0 && (y-r)<=x){
//                     end=Math.min(end, y);
//                       ans=mid;
//                       break;  
//                 }else if((y-r)<0 && (x+r)>=y && (y-r)<=x){
//                     end=Math.min(end, x+r);
//                     ans=Math.min(ans, mid);
//                     hi=mid-1;
//                 }else if((y-r)>x && (x+r)<y){
//                     lo=mid+1;
//                 }else{
//                     break;
//                 }
//             }

//             int ct=0;
//             long curr=end;

//             while(ct<n){
//                 System.out.print(curr+" ");
//                 curr-=ans;
//                 ct++;
//             }
//             System.out.println("aa");
//             // int a1=a,b1=b,n1=n;
//             // int r1=a-x;
//             // int r2=b-y;

//             // if(r1<n && n>0){
//             //     n-=r1;
//             //     a=x;
//             // }else if(n>0){
//             //      a=a-n;  n=0;
//             // }

//             // if(r2<n && n>0){
//             //     n-=r2;
//             //     b=y;
//             // }else if(n>0){
//             //     b=b-n;  n=0;
//             // }

//             // //type=2
//             // if(r2<n1 && n1>0){
//             //     n1-=r2;
//             //     b1=y;
//             // }else if(n1>0){
//             //     b1=b1-n1;  n1=0;
//             // }

//             // if(r1<n1 && n1>0){
//             //     n1-=r1;
//             //     a1=x;
//             // }else if(n1>0){
//             //     a1=a1-n1;  n1=0;
//             // }

            

//             // long ans=((long)(a))*((long)(b));
//             // ans=Math.min(ans,(((long)(a1))*((long)(b1))));
//             // System.out.println(ans);
//             // if((r1+r1)<=n){
//             //     a=x; b=y;
//             // }else
//             // if(r1<n && r2<n && (r1+r2)>n){
//             //     if(a<b){a-=n;}
//             //     else{b-=n;}
//             // }else if(r1>n && r2>n){
//             //     if(a<b){a-=n;}
//             //     else{b-=n;}
//             // }else if(r1>n){
//             //     a-=n;
//             // }else if(r2>n){
//             //     b-=n;  
//             // }else{
//             //     if(a<b){
//             //         n=n-(a-x); a=x;
//             //         b-=n;
//             //     }else{
//             //         n=n-(b-y); b=y;
//             //         a-=n;     
//             //     }
//             // }
            
//             // int la=a,lb=b;
//             // if((a-x)>=n && ((b-y)<n || a<=b)){la=a-n; }
//             // else if((b-y)>=n){lb=b-n; }   

//             // while(n>0){
//             //     if(a==x && b==y){break;}

//             //     if((a<b || b==y) && a>x){
//             //         if((a-x)<n){n=n-(a-x); a=x;}
//             //         else{a=a-n; n=0;}
//             //     }else{
//             //         if((b-y)<n){n=n-(b-y); b=y; }//System.out.println("r");}
//             //         else{b=b-n; n=0;}
//             //     }
//             // }
//             // long ans=((long)(a))*((long)(b));
//             // ans=Math.min(ans,((long)(la))*((long)(lb)));

//             // System.out.println(ans);
            
//         }
//     }    
// }
