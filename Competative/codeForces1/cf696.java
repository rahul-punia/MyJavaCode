import java.util.*;
//Note-V.V.Imp
//String Concept Java
// Strings are very common in the interview questions. In this section, we will cover some common 
//string manipulation techniques, and solve some typical problems.

// String concatenation
// What do you think is the time complexity of the following code in Java?

// final int N = ...

// String s = "";        
// for (int i = 0; i < N; i++)
//     s = s + "x";
// It can be a bit surprising, but this code actually runs in O(N^2) time. The reason is that in Java 
//strings are immutable, and as a result, each time you append to the string new string object is
// created. The loop in the code does 1 + 2 + 3 + ... + N = N * (N + 1) / 2 = O(N2) operations.

// To avoid this, in Java you should use StringBuilder class. The following code runs in O(N) time:

// final int N = ...

// StringBuilder sb = new StringBuilder();
// for (int i = 0; i < N; i++)
//     sb.append("x");

// String s = sb.toString();
// In C++, strings are mutable, but you still should be careful with concatenation. As a rule of 
//thumb, you should use += operator or append method (they append to the original string object), and avoid + operator (it creates a new string object):


public class cf696 {
    //Q-3
    //T.C=>O(n^2) as 𝑛 (1≤𝑛≤1000). so take max time 1sec
    //from T.C we many times get an idea how to implement question.
    static int[] count=new int[1000001];//(1≤𝑎𝑖≤106) 
      public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
                long t=scn.nextLong();

                while(t-->0){
                   int n=scn.nextInt();
                    int[] a=new int[2*n];

                    for(int i=0;i<2*n;i++){a[i]=scn.nextInt(); count[a[i]]++;}

                    Arrays.sort(a);
                    boolean flag=false;
                    for(int i=0;i<2*n-1;i++){
                        flag=false;
                        ArrayList<int[]> ans=new ArrayList<>(); 
                        count[a[i]]--; count[a[2*n-1]]--;
                        ans.add(new int[]{a[i],a[2*n-1]});
                       int x=a[2*n-1];
                        int j=0;
                        for (j=2*n-1; j>=0; j--){
                            if(count[a[j]]==0){continue;}
                            count[a[j]]--;
                            if(count[x-a[j]]==0){count[a[j]]++; break;}
                            count[x-a[j]]--;
                            ans.add(new int[]{a[j],x-a[j]});
                            x=a[j];
                        }

                        if(j<0){
                            flag=true;
                            int intialX=a[i]+a[2*n-1];
                            System.out.println("YES");
                            System.out.println(intialX);

                            for(int[] pair:ans){System.out.println(pair[0]+" "+pair[1]);}
                        }
                        for(int[] pair:ans){count[pair[0]]++; count[pair[1]]++;} 
                        if(flag){break;}
                    }

                    if(!flag){System.out.println("NO");}
                    for(int i=0;i<2*n;i++){count[a[i]]=0;}
         }
    }
}

    // //Q-2
    // static ArrayList<Integer> list=new ArrayList<>();
    // public static void SOE(int n){
    //     int[] sieve=new int[n+1];

    //     // System.out.println("All prime number from 1 to n:-");
        
    //     for(int x=2;x<=n;x++){
    //         if(sieve[x]!=0){  //Not prime number
    //             continue;
    //         }
    //         // System.out.print(x+"  ");
    //         list.add(x);
    //         for(int u=2*x;u<=n;u+=x){  //v.imp
    //             sieve[u]=x;
    //         }
    //     }
    // }

    // public  static int bs(int targ){
    //     int lo=0,hi=list.size()-1;

    //     while(lo<hi){
    //         int m=lo+(hi-lo)/2;
    //         if(list.get(m)==targ){return m;}else
    //         if(list.get(m)>targ){
    //             hi=m;
    //         }else{
    //             lo=m+1;
    //         }
    //     }
    //     return hi;
    // }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
    //             SOE(10000001);

    //             while(t-->0){
    //                int d=scn.nextInt();
                   
    //                int tg=d+1;
    //                int idx=bs(tg);
    //                 int val1=list.get(idx);
    //                 int idx2=bs(val1+d);
    //                 int val2=list.get(idx2);
    //                 long ans=(long)((long)val1*(long)val2);

    //                 // System.out.println(ans+" "+val1+" "+val2);
    //                 System.out.println(ans);
    //             }
    //         }
    //     }

    //Q-1  
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();

    //             while(t-->0){

    //                int n=scn.nextInt();
    //                String str=scn.next();
    //                 String nstr=""+1;
    //                 int prev=-1;
    //                 int[] arr=new int[n];

    //                 char[] ans=new char[n];
    //             if(str.charAt(0)=='1'){arr[0]+=1;}
                    
    //                arr[0]+=1;
    //                ans[0]='1';
    //                for(int i=1;i<n;i++){
    //                 if(str.charAt(i)=='1'){
    //                     arr[i]=1;
    //                 }
    //                   if(arr[i-1]!=arr[i]+1){
    //                      arr[i]+=1;  ans[i]='1';
    //                   }else{
    //                     // nstr+='0';
    //                     ans[i]='0';
    //                   }
    //                }
    //                StringBuilder sbf = new StringBuilder();
    //                sbf.append(ans);
    //             //    nstr=Arrays.toString(ans);
    //                System.out.println(sbf);
    //             }
    //         }
    //     }


