import java.util.*;
import java.lang.*;
import java.io.*;



public class cf706 {

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

//Template
   static int[] spf;

//    public static void primefactorize(int n){
//         spf=new int[n+1];   spf[1]=1;
//          ArrayList<Integer> primes=new ArrayList<>();   
//         for (int i = 2; i <= n; ++i) {
//             if (spf[i] == 0) {
//                 primes.add(i);
//                 spf[i] = i;
//             }
//             for (int x : primes) {
//                 if (x > spf[i] || ((long)x*(long)i) >(long)n) break;
//                 spf[x * i] = x;
//             }
//         }
//     }


    public static void primefactorize(int n){
        spf=new int[n+1];

        for(int i=1;i<=n;i++){
            spf[i]=i;
        }

        for(int i=4;i<=n;i+=2){
            spf[i]=2;
        }

        for(int i=3;i<=n;i++){

            if(spf[i]==i){
                long pd=(long)(i)*(long)(i);
                if(pd>(long)(n)){continue;}

                for(long j=i*i;j<=(long)n && j>=0;j+=i){
                    if(spf[(int)j]==(int)j){  spf[(int)j]=(int)i; }
                }
            }
        }

    }
public static void main(String[] args) throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t= Integer.parseInt(br.readLine());
    long[] vst=new long[10000001]; //10000_001  
    long counter=0;    
    primefactorize(10000000);  //10000_000

    while(t-->0){
    //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
        String[] strs=(br.readLine()).trim().split(" ");
        int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

        strs=(br.readLine()).trim().split(" ");

        // long[] vst=new long[10000001];  //Array declaration in java take o(n) time Due to this time limit is exceeded
                                           //V.V.Imp   link- https://stackoverflow.com/questions/5640850/java-whats-the-big-o-time-of-declaring-an-array-of-size-n#:~:text=Each%20of%20the%20elements%20of,take%20O(n)%20time.&text=Looking%20at%20the%20link%20amit,default%20value%2C%20in%20constant%20time.
        //I am pretty sure that it is O(n), as the memory is initialized when the array is allocated. It should not be
        // higher than O(n), and I can see no way to make it less than O(n), so that seems the only option                                       
        int ans=1;
        counter++;
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(strs[i]);
            int prevspf=-1;  int ct=0;
            int oddprod=1;
            while(x>1){
                if(prevspf==-1){prevspf=spf[x]; ct++;}
                else if(prevspf==spf[x]){ct++;}
                else{ if(ct%2==1){oddprod=oddprod*prevspf;}  ct=1; prevspf=spf[x];}
                x=x/spf[x];
            }
            
            if(ct%2==1){oddprod=oddprod*prevspf;}
          
            if(vst[oddprod]==counter){ans++; counter++; vst[oddprod]=counter; }
            else{vst[oddprod]=counter;}
        }
        System.out.println(ans);
    }
    }
}



        // int[] vst=new int[max+1]; //10000_001  

        // int ans=1;
        // primefactorize(max);  //10000_000   //mybiggest mistake make primefactorize call inside while loop
        // for(int i=0;i<n;i++){
        //     // int val=primefactorize(arr[i]);
        //     // HashMap<Integer,Integer> hm=new HashMap<>();
        //     int x=arr[i];
        //     int prevspf=-1;  int ct=0;
        //     int oddprod=1;
        //     while(x>1){
        //         // hm.put(spf[x], hm.getOrDefault(spf[x], 0)+1);  //optimize this part
        //         if(prevspf==-1){prevspf=spf[x]; ct++;}
        //         else if(prevspf==spf[x]){ct++;}
        //         else{ if(ct%2==1){oddprod=oddprod*prevspf;}  ct=1; prevspf=spf[x];}
        //         x=x/spf[x];
        //     }
            
        //     if(ct%2==1){oddprod=oddprod*prevspf;}
        //     // for(int key:hm.keySet()){  // //optimize this part
        //     //     if((hm.get(key))%2==1){
        //     //         oddprod=oddprod*key;
        //     //     }
        //     // }

        //     if(vst[oddprod]==ans){ans++; vst[oddprod]=ans; }
        //     else{vst[oddprod]=ans;}
        // }

//         System.out.println(ans);
//     }
//     }
// }









// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         strs=(br.readLine()).trim().split(" ");

//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//         }

//         int ans=1,st=0;

//         for(int i=1;i<n;i++){
//             boolean fg=false;

//             for(int j=st;j<i;j++){
//                 long prod=(long)(arr[i])*(long)(arr[j]);

//                 long sr=(long)Math.sqrt(prod);

//                 if((sr*sr)==prod){fg=true; st=i; ans++; break;}
//             }
//         }


//         System.out.println(ans);  //"a="+
//     }
//     }
// }










// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
//                 if(n==4){
//                     System.out.print(2+" ");
//                     n-=2;
//                     int d=n/2;
//                     System.out.println(d+" "+d);
//                     continue;
//                 }

//                 if(n%4==0){
//                     System.out.print((n/2)+" ");
//                     // n-=1;
//                     int d=n/4;
//                     System.out.println(d+" "+d);
//                     continue;
//                 }

//         if(n%2==1){
//             System.out.print(1+" ");
//             n-=1;
//             int d=n/2;
//             System.out.println(d+" "+d);
//         }else{
//             int sb=2;

//             // while((n-sb)%4!=0 && sb<n){
//             //     sb=2*sb;
//             // }
//             System.out.print(sb+" ");
//                 n-=sb;
//                 int d=n/2;
//                 System.out.println(d+" "+d);
//         }
        
//     }
// }
// }


// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         // String str=(br.readLine()).trim();
//         int[] arr=new int[n];
//         strs=(br.readLine()).trim().split(" ");

//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//         }

//         int[] mods=new int[100001];

//         for(int i=0;i<n;i++){
//             mods[(arr[i]%m)]++;
//         }

//         int ans=0;
//         for(int i=0;i<=(m/2);i++){
//             if(i==0 && mods[i]>0){ans++; continue;}
//             int v1=i,v2=m-i;
           
//             if(mods[v1]==0 && mods[v2]==0){continue;}
            
//             if(v1==v2){
//                 ans++;  continue;
//             }

           
//             int ct1=mods[v1],ct2=mods[v2];

//             if(ct1==ct2 || (ct1+1)==ct2 || ct1==(ct2+1)){ans++; continue;}

//             int max=Math.max(ct1, ct2);
//             int min=Math.min(ct1, ct2);

//             ans+=((max-1)-(min))+1;
//         }

//         System.out.println(ans);  //"a="+
//     }
//     }
// }


// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//        int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         // String str=(br.readLine()).trim();
//         int[] arr=new int[n];

//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//         }

//         Arrays.sort(arr);

//         int[] vst=new int[150];
//         for(int i=0;i<n;i++){
//             vst[arr[i]]++;
//         }

//         int st=0;
//         for(int i=0;i<=101;i++){
//             if(vst[i]==0){
//                 st=i;
//                 break;
//             }
//         }

        
//         for(int i=0;i<=101;i++){
//             if(vst[i]>0 && i>st){
//                 while(vst[i]>0 && i>st){
//                     System.out.print(i+" ");  vst[i]--;
//                 }
//             }else if(vst[i]>0){
//                 System.out.print(i+" ");
//                     vst[i]--;  
//             }
//         }

//         for(int i=0;i<st;i++){
//             if(vst[i]>0){
//                 while(vst[i]>0){
//                     System.out.print(i+" ");  vst[i]--;
//                 }
//             }
//         }

//         System.out.println();
//         }
//     }
// }










//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         // int t= Integer.parseInt(br.readLine());

//         // while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]);//,k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//             int[] arr=new int[n];

//             int ct=1;
//             int ct2=1;
//             PriorityQueue<Integer> pq=new PriorityQueue<>();
//             PriorityQueue<Integer> pq2=new PriorityQueue<>();
//             strs=(br.readLine()).trim().split(" ");

//             int k=(int)Math.ceil((n)/2.0);
//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);

//                 if(i>0 && arr[i-1]<arr[i]){ct++;  ct2=1;}
//                 if(i>0 && arr[i-1]>arr[i]){ct2++;  ct=1;}
//                  if(ct>=k){  
//                     if(pq.size()<2){pq.add(ct);}
//                     else if(pq.peek()<ct){pq.remove();   pq.add(ct);}
//                 }
               

//                 if(ct2>=k){  
//                     if(pq2.size()<2){pq2.add(ct2);}
//                     else if(pq2.peek()<ct2){pq2.remove();   pq2.add(ct2);} 
//                 }
//                 // else{ct=0;}
//             }

//             int sz=pq.size()+pq2.size();

//             // System.out.println(sz+" | "+k);
            
//             if(sz<=1){
//                 System.out.println(0);  return;
//             }
//             int[] ans=new int[sz];
//             int j=0;
//             while(pq.size()>0){ans[j++]=pq.remove();}
//             while(pq2.size()>0){ans[j++]=pq2.remove();}
            
//             Arrays.sort(ans);

//             int mans=ans[sz-2]-(k-1);

//             System.out.println(mans);  //"a="+
//         // }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]);//,k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
            
//             // String str=(br.readLine()).trim();

//             // strs=(br.readLine()).trim().split(" ");
//             int[] arr1=new int[n];   int[] arr2=new int[n];
//             int p1=0,p2=0;

//             for(int i=0;i<(2*n);i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int x=Integer.parseInt(strs[0]),y=Integer.parseInt(strs[1]);
//                 if(y==0){
//                     arr1[p1++]=Math.abs(x);
//                 }else{
//                     arr2[p2++]=Math.abs(y);    
//                 }
//             }

//             Arrays.sort(arr1);
//             Arrays.sort(arr2);

//             double ans=0;
//             for(int i=0;i<n;i++){
//                 ans+=Math.sqrt((Math.pow(arr1[i], 2))+(Math.pow(arr2[i], 2)));
//             }
            
//             System.out.println(ans);  //"a=="+
//         }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
            
//             // String str=(br.readLine()).trim();

//             strs=(br.readLine()).trim().split(" ");
//             int[] arr=new int[n];
            
//             int max=0;
//             // HashSet<Integer> hs=new HashSet<>();
//             boolean[] vst=new boolean[100003];
//             for(int i=0;i<n;i++){
//                 arr[i]=Integer.parseInt(strs[i]);
//                 max=Math.max(max, arr[i]);
//                 if(arr[i]<(100003)){ vst[arr[i]]=true; }
//             }
            
            
//             // Arrays.sort(arr);

//             int ct=0;
//             // int[] arr=ne

//             int mex=0;

//             for(int i=0;i<(100003);i++){
//                 if(!vst[i]){mex=i; break;}
//             }

//             // int i=0;
//             // while(i<n && arr[i]==mex){mex++; i++;}

//             long ans=n;
//             if(k==0){System.out.println(ans); continue;}

//             if(mex>max){
//                 ans+=(long)k;
//                 System.out.println(ans);  
//             }else if(mex<max){
//                 boolean f=false;
//                 int val=(int)Math.ceil((max+mex)/2.0);
//                 for(int r=0;r<n;r++){
//                     if(arr[r]==val ){f=true; break;}
//                 }

//                 if(!f)ans++;

//                 System.out.println(ans);  //"a1="+
//             }
            
//             // for(int j=0;j<k;j++){
//             //     int val=(int)Math.ceil((max+mex)/2.0);

//             //     if(val==mex){
//             //         mex++;  ans++;
//             //         while(i<n && arr[i]==mex){mex++; i++;}
//             //     }else{
//             //         ans++;
//             //         if(mex%2==max%2){break;}
//             //     }
//             // }

//             // System.out.println("a3="+ans);
//         }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
            
//             String str=(br.readLine()).trim();

//             int s=0,e=n-1,ct=0;

//             while(s<e && ct<=k){
//                 if(str.charAt(s)==str.charAt(e)){
//                     ct++;
//                 }else{break;}
//                 s++; e--;
//             }

//             if(ct<k || n<=(2*k)){
//                 System.out.println("NO");
//             }else {
//                 System.out.println("YES");
//             }
//         }
//     }
// }
