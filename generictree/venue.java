import java.util.*;
public class venue {
    // static int ans=0;
    public static long perm(int[] arr,int csum){
        // if(csum<0)return;
        // if(csum==0){
        //     ans++;
        //     return;
        // }
        // for(int i=0;i<arr.length;i++){
            long[] strg=new long[csum+1];
            strg[0]=1;
            
            for(int i=1;i<=csum;i++){
                for(int j=0;j<arr.length;j++){
                 if((i-arr[j])>=0){
                     strg[i]+=strg[i-arr[j]];
                 }    
                }
            }
            return strg[csum];
    }
    public static long comb(int[] arr,int csum){
        long[] strg=new long[csum+1];
            strg[0]=1;
            for(int j=0;j<arr.length;j++){
            for(int i=1;i<=csum;i++){
                 if((i-arr[j])>=0){
                     strg[i]+=strg[i-arr[j]];
                 }    
                }
            }
            return strg[csum];
    }
    public static long pythagorasTriplet(){
        long a = 0, b=0 , c=0;
    
        for(long divisor=1; divisor<1000; divisor++){
            if( ((500000-(1000*divisor))%(1000-divisor)) ==0){
                a = (500000 - (1000*divisor))/(1000-divisor);
                b = divisor;
                c = (long)Math.sqrt(a*a + b*b);
                System.out.println("a is " + a + " b is: " + b + " c is : " + c);
                break;
            }
        }
        return a*b*c;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
    //     int[] arr={10,20,50,100,200,500,1000,2000};//{2,3,5,6}//
    //    long ans=perm(arr, 2000);
    //     System.out.println(ans);
    //     long ans1=comb(arr, 2000);
    //     System.out.println(ans1);
   long ans=pythagorasTriplet();
   System.out.println(ans);
    }
}
