import java.util.*;

public class cf697 {
    static long mod=10000007;
    static class pair{
        long first,second;
        pair(long first,long second){
            this.first=first; this.second=second;
        }
    }

    public static pair fib (long n) {
        if (n == 0){
            pair bp=new pair(0, 1);
            return bp;
        }

            // return {0, 1};
    
        pair p = fib(n >> 1);
        long c = p.first * ((2 * p.second) - p.first);
        long d = p.first * p.first + p.second * p.second;
        if ((n & 1)==1){
            pair np=new pair(d, c+d);
            return np;
        }else{
            pair np=new pair(c, d);
            return np;
        }
        //     return {d, c + d};
        // else
        //     return {c, d};
    }

    public static long binpow(long a,long n){
        long res=1; 
        while(n>0){
            if((n&1)==1){res=res*a;}
            a=a*a;  n>>=1;  res=res%10000007; a=a%10000007;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        long n=scn.nextLong();
        // long num=(long)((1+Math.pow(5, 0.5))/2);
        // double den=Math.pow(5, 0.5);

        // double fnum=binpow(num, n);
        // long ans=(long)(fnum/den);
        // System.out.println(ans);
        // long a=System.currentTimeMillis();
        pair pr=fib((n));
        System.out.println(pr.first+"    "+pr.second);
        // System.out.println(Math.pow(pr.first,0.5)+"  "+Math.pow(pr.second,0.5));
        // long b=System.currentTimeMillis();
        // System.out.println(b-a);
    }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     // long t=scn.nextLong();

    //     while(true){
    // //ans=n^k+2(n-1)^k+2(n-1)^(n-1)+n^n careful about mod and evaluate this exp
    //         long n=scn.nextLong();
    //         long k=scn.nextLong();
    //         if(n==0 && k==0){break;}
    //         long sn=0,ans=0;
    //         long pn=0;
    //         long zn=0,zn1=0,zn2=0;
            
    //         // for(int r=0;r<3;r++){
    //         //     for(int i=1;i<=n-r;i++){
    //         //         if(r==0){zn+=binpow(i, k);}
    //         //         if(r==1){zn1+=binpow(i, k);}
    //         //         if(r==2){zn2+=binpow(i, k);}
    //         //     }
    //         //     for(int i=1;i<=n-r;i++){
    //         //         if(r==0){zn+=binpow(i, i);}
    //         //         if(r==1){zn1+=binpow(i, i);}
    //         //         if(r==2){zn2+=binpow(i, i);}
    //         //     }        
    //         // }
            
    //         zn=(binpow(n,k)+binpow(n, n));
    //         zn1=(2*binpow(n-1, k)+2*binpow(n-1, n-1));
    //         ans=(zn+zn1)%1000000007;
    //         // ans=ans%mod;
    //         ans=(zn+zn1-2*zn2)%mod;
    //         System.out.println(ans);
    //     }            
    // }
    
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//                 long t=scn.nextLong();
//     //Solution Article-V.V.Imp                
//    //https://palak001.medium.com/spoj-locker-magic-of-the-locker-a758bccf432f
//                 while(t-->0){
//                     long n=scn.nextLong();
                    
//                     if(n<3){System.out.println(n); continue;}

//                     long ans=1; 
//                     if(n%3==1){
//                         long n1=(n-4)/3;
//                         ans=4*binpow(3, n1);
//                     }else if(n%3==2){
//                         long n1=(n-2)/3;
//                         ans=2*binpow(3, n1);}
//                     else{
//                         ans=binpow(3, n/3);
//                     }
//                     ans=ans%mod;
//                     System.out.println(ans);
//                 }
//     }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();

    //             while(t-->0){
    //                 long a=scn.nextLong(),n=scn.nextLong();
    //                 long be=binpow(a, n);
    //                 System.out.println((be%10));
    //             }
    // }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long n=scn.nextLong();
            
    //         long ans=0;    
    //          long be1=binpow(4,n-2-1);
    //          ans=be1*3;
    //         //  System.out.println(ans);
    //          ans=2*ans;
               
    //          if(n>3){
    //             //  be1=be1*2;
    //             long be2=binpow(4,n-2-2);
    //             ans+=be2*3*3*(n-3);
    //         }
             
    //           ans=ans*4;
    //          System.out.println(ans);
    //       } 
}
