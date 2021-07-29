import java.util.*;
import java.io.*;
import java.lang.*;
import java.sql.Array;


public class febchal {
    static int[] ans;
    static int mod=998244353;
    // public static void Allsubseq(int[] arr,int cv,int cl, int ci){
    //     if(ci>=arr.length){
    //         ans[cl]=(ans[cl]+cv)%mod; //  ans[cl]
    //         return ;
    //     }

    //     Allsubseq(arr, cv^arr[ci],cl+1, ci+1);
    //     Allsubseq(arr, cv,cl, ci+1);
    // }
    static int[][] dp;
    public static void Allsubseq2(int[] arr){
        int n=arr.length;
        for(int gap=0;gap<n;gap++){
            boolean flag=true;
            int r=0;
            for(int i=0,j=gap;j<n;i++,j++){

                if(gap==0){
                    dp[i][j]=arr[j];
                    ans[gap+1]+=dp[i][j];
                }else{
                    dp[i][j]=dp[i][j-1]^dp[j][j];
                    if(flag){ r=(n-j);}

                    if(gap==1){
                        for(int k=j;k<(n);k++){
                            ans[gap+1]=(ans[gap+1]+(dp[i][j-1]^arr[k]))%mod;
                            // if(gap==1){System.out.println(((dp[i][j-1]^arr[k])+" ** "));}
                        }
                        if(flag){r--; flag=false;}
                    }else{
                        for(int k=j;k<(j+r);k++){
                            ans[gap+1]=(ans[gap+1]+(dp[i][j-1]^arr[k%n]))%mod;
                            // if(gap==1){System.out.println(((dp[i][j-1]^arr[k%n])+" ** "));}
                        }
                        if(flag){r--; flag=false;}
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
                InputStreamReader ip=new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(ip);
        		// int t = Integer.parseInt(br.readLine());
        		// StringBuilder sb = new StringBuilder();
                // while(t-->0){
                    int n = Integer.parseInt(br.readLine());
                    String[] strs=(br.readLine()).trim().split(" ");
                    int[] arr=new int[n];

                    for(int i=0;i<n;i++){
                        arr[i]=Integer.parseInt(strs[i]);
                    }
                    
                    int q = Integer.parseInt(br.readLine());
                    dp=new int[n][n];
                    ans=new int[n+1];
                    Allsubseq2(arr);
                    
                    for(int i=0;i<q;i++){
                        int m = Integer.parseInt(br.readLine());
                        long xor=0;
                        // for(int j=1;j<=m;j++){
                        //     System.out.print(ans[j]+" ");
                        // }
                        System.out.println();
                        for(int j=1;j<=m;j++){
                            xor+=(long)ans[j];
                            
                            xor=xor%mod;
                        }
                        System.out.println(xor);
                    }

                   
                    // }
            }
        }           

//     static int mod=10000_00007;
//     static long[] factorials=new long[10000_01];
//     public static long fact(int n){
//         long ans=1;
//         for(int i=1;i<=n;i++){
//             ans=ans*(long)(i); ans=ans%mod;
//             factorials[i]=ans;
//         }
//         return ans;
//     }
//     static int[] sieve;

//     public static void SOE(int n){
//         sieve=new int[n+1];

//         for(int x=2;x<=n;x++){
//             if(sieve[x]!=0){continue;}
//             for(int u=2*x;u<=n;u+=x){
//                 sieve[u]=x;
//             }
//         }
//     } 
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();
//         fact(10000_00);
//         SOE(10000_00);
//         while(t-->0){
//             String[] pr=(br.readLine()).trim().split(" ");
//             int x=Integer.parseInt(pr[0]);
//             int y=Integer.parseInt(pr[1]);
            
//             int fact=(int)factorials[x];
//             long div=y;
         
//             HashSet<Integer> hs=new HashSet<>();

//             if(sieve[fact]==0){System.out.println("Chef"); continue;}

//             System.out.println(fact);
//             // while(fact>1){
//             //     hs.add(sieve[(int)fact]);
//             //     if(sieve[fact]==0){break;}
//             //     fact=fact/sieve[(int)fact];
//             // }    
//             if(hs.size()>y){
//                 System.out.println("Divyam");
//             }else{
//                 System.out.println("Chef");
//             }
//         }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();

//         while(t-->0){
//             int n = Integer.parseInt(br.readLine());
//             String[] str=(br.readLine()).trim().split(" ");

//             HashMap<String,ArrayList<Character>> hm1=new HashMap<>();
//             // HashMap<Character,Integer> hm2=new HashMap<>();
//            // String[] arr=new String[n];
//             // int[] chrs=new int[26];
//             // int max=0;
//             for(int i=0;i<n;i++){
//                 String s=str[i]; // arr[i]=s;
                
//                 char ch=s.charAt(0);
//                 String sstr=s.substring(1);
//                 ArrayList<Character> list=hm1.getOrDefault(sstr,new ArrayList<>());
//                 list.add(ch);
//                 hm1.put(sstr,list);
//                 // chrs[ch-'a']++;
//                 // max=Math.max(chrs[ch-'a'], max);
//                 // hm2.put(ch,hm2.getOrDefault(ch,0)+1);
//             }
//             ArrayList<String> list=new ArrayList<>();
//             list.addAll((hm1.keySet()));//imp
//             long ans=0;
//             for(int i=0;i<list.size();i++){
//                 ArrayList<Character> l1=hm1.get(list.get(i));
//                 for(int j=i+1;j<list.size();j++){
//                     HashSet<Character> hs=new HashSet<>();
//                     ArrayList<Character> l2=hm1.get(list.get(j));
//                     hs.addAll(l1);
//                     hs.addAll(l2);
//                     // int tsz=l1.size()+l2.size();
//                     int distinct=hs.size();
//                     int fact=(distinct-l1.size())*(distinct-l2.size());
//                     ans+=fact;
//                 }
//             }

//             System.out.println((2*ans));
//         }
//     }
// }





//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();

//         while(t-->0){
//             int n = Integer.parseInt(br.readLine());
//             String[] str=(br.readLine()).trim().split(" ");

//             HashMap<String,Integer> hm1=new HashMap<>();
//             HashMap<Character,Integer> hm2=new HashMap<>();
//             // HashSet<String> hs1=new HashSet<>();
//             // HashSet<Character> hs2=new HashSet<>();
//             // HashSet<String> hs1=new HashSet<>();
//             String[] arr=new String[n];
//             int[] chrs=new int[26];
//             int max=0;
//             for(int i=0;i<n;i++){
//                 String s=str[i];
//                 arr[i]=s;
//                 char ch=s.charAt(0);
//                 String sstr=s.substring(1);
//                 hm1.put(s,1);
//                 chrs[ch-'a']++;
//                 max=Math.max(chrs[ch-'a'], max);
//                 hm2.put(ch,hm2.getOrDefault(ch,0)+1);
//                 // hs1.add(sstr);
//                 // hs2.add(ch);
//             }

//             if(max==n){System.out.println(0); continue;}

//             // if(hs1.size()==1 || hs2.size()==1){
//             //     System.out.println(0);
//             //     continue;
//             // }    

//             long ans=0;
//             for(int i=0;i<n;i++){
//                 String s=arr[i];
//                 char ch1=s.charAt(0);
//                 String sstr1=s.substring(1);

//                 int ct=n;
//                 for(char k:hm2.keySet()){
//                     String sp1=k+sstr1;
//                     if(hm1.getOrDefault(sp1,0)==1){
//                         ct-=hm2.get(k);
//                     } 
//                 }
//                 if(ct>0)ans+=ct;
//             }
//                 // for(int j=i+1;j<n;j++){
//                 // String s2=arr[j];
//                 // char ch2=s2.charAt(0);
//                 // String sstr2=s2.substring(1);
//                 // String sp1=ch1+sstr2;
//                 // String sp2=ch2+sstr1;

//                 //     if(hm1.getOrDefault(sp1,0)==0 && hm1.getOrDefault(sp2,0)==0){
//                 //         ans++;
//                 //     }
//                 // }
//             // }
            
//             System.out.println((ans));
//         }
//     }
// }
//             for(int i=0;i<n;i++){
//                 String s=arr[i];
//                 char ch=s.charAt(0);
//                 String sstr=s.substring(1);
//                 int ct=(n+1)-(hm1.get(sstr)+hm2.get(ch));
//                 ans+=ct;
//             }
//             if(ans<0){ans=0;}
//             System.out.println((ans));

//             // long ts=hs2.size()*hs1.size();

//             // long vs=ts-n;

//             // long ans=((vs)*(vs-1));

//             // System.out.println(ans);
//         }
//     }
// }

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();

//         while(t-->0){
//             int n = Integer.parseInt(br.readLine());
//             String[] str=(br.readLine()).trim().split(" ");

//             int[][] arr=new int[n][3];

//             // HashSet<Integer> hs=new HashSet<>();
//             for(int i=0;i<n;i++){
//                 arr[i][0]=Integer.parseInt(str[i]);
//                 arr[i][1]=i+1;
//             }

//             str=(br.readLine()).trim().split(" ");
            
//             for(int i=0;i<n;i++){
//                 arr[i][2]=Integer.parseInt(str[i]);
//             }

//             Arrays.sort(arr,(a,b)->a[0]-b[0]);
//             int ans=0;
//             for(int i=1;i<n;i++){
//                 int lp=arr[i-1][1];
//                 if(arr[i][1]>lp){continue;}

//                 int hit=(((lp-arr[i][1])+1)+(arr[i][2]-1))/arr[i][2];
//                 ans+=hit;
//                 arr[i][1]+=hit*arr[i][2];
//             }

//             System.out.println(ans);
//         }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
// 		int t = Integer.parseInt(br.readLine());
// 		StringBuilder sb = new StringBuilder();

//         while(t-->0){
//             int n = Integer.parseInt(br.readLine());
//             String[] str=(br.readLine()).trim().split(" ");

//             // int[] arr=new int[n];

//             HashSet<Integer> hs=new HashSet<>();
//             long max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
//             for(int i=0;i<n;i++){
//                 int val=Integer.parseInt(str[i]);
//                 max=Math.max(max,val);  min=Math.min(min,val);
//                 hs.add(val);
//             }
//             // System.out.println(hs.size());

//             if(hs.size()==1){
//                 System.out.println(0);
//             }else{
//                 long ans=2*Math.abs((long)max-(long)min);
//                 System.out.println(ans);
//             }
//         }
//     }
// }

