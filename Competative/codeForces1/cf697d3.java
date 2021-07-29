    import java.util.*;

    public class cf697d3 {
        static long mod=100000_0000+7;

        public static long  bin_exp(long A, long N)		//modInv=(a^(MOD-2))%MOD by Fermat’s little theorem
        {
            long res=1;
            while (N>0)
            {
                if (N%2==1)
                    res=(res*A)%mod;
                A=(A*A)%mod;
                N/=2;
            }
            return res;
        }
        public static void main(String[] args) {
            Scanner scn=new Scanner(System.in);
            long t=scn.nextLong();
            
            while(t-->0){
                int n=scn.nextInt();
                int k=scn.nextInt();

                int[] arr=new int[n];

                for(int i=0;i<n;i++){arr[i]=scn.nextInt();}

                Arrays.sort(arr);
                int lo=0,hi=n-1;
                while(lo<=hi){int tmp=arr[lo]; arr[lo]=arr[hi]; arr[hi]=tmp; lo++; hi--;}
                // Arrays.reverse(arr);

                int l=k-1;
                int r=k-1;
                int lct=0,rct=0;
                while(l>0 && arr[l-1]==arr[l]){lct++; l--;}
                while(r<(n-1) && arr[r]==arr[r+1]){rct++; r++;}

                lct++;
                long nn=(long)(lct+rct);
                // if(r==n-1 && arr[r-1]==arr[r] && r!=(k-1)){nn++;}
                int min=Math.min(lct,(int)(nn-lct));

                long num=1,den=1;
                long fact=1;
                for(int i=0;i<min;i++){
                    // System.out.println(num+"  "+den);
                    num=(num*nn)%mod;  nn--;
                    den=(den*fact)%mod; fact++;
                    // if(num%den==0){num=num/den; den=1;}
                    // while(num%2==0 && den%2==0){num=num/2; den=den/2;}
                }
                long ans=(num*bin_exp(den, mod-2))%mod;
                // double ans=((fact(nn)*1.0)/((fact(nn-(lct+1)))))*(double)((1.0)/(fact(lct+1)));
                System.out.println(ans);
            }
        }
    }



//     static class my_number {
//         // public member variable
//         public long number;
//         // default constructor
//         public my_number(long number){
//           this.number = number;
//         }
//       }

//     public static long fact(int n){
//         if(n==0 || n==1)return 1;
//         return (n*fact(n-1))%mod;
//     }

// //   public static long x=0,y=0;

//   public static long gcd(long a,long b,my_number x,my_number y){
//       if(b==0){x.number=1; y.number=0; return a;}

//     //   long x1=0,y1=0;
//         my_number x1=new my_number(0);
//         my_number y1=new my_number(0);
//       long d=gcd(b, a%b,x1,y1);
//       x.number=y1.number;
//       y.number=x1.number-((y1.number)*(a/b));
//     //   System.out.println(x1.number+" "+y1.number);
//       return d;
//   }






    //     public static void main(String[] args) {
    //         Scanner scn=new Scanner(System.in);
    //         long t=scn.nextLong();
            
    //         while(t-->0){
    //             int n=scn.nextInt();
    //             long m=scn.nextLong();
                
    //             int[] arr=new int[n];
    //             long sum=0;
    //             for(int i=0;i<n;i++){
    //                 arr[i]=scn.nextInt();
    //                 if(sum<m){sum+=(long)arr[i];}
    //             }

                
    //             ArrayList<Integer> one=new ArrayList<>();
    //             ArrayList<Integer> two=new ArrayList<>();
                
    //             for(int i=0;i<n;i++){
    //                 int val=scn.nextInt();
    //                 if(val==1){
    //                     one.add(arr[i]);
    //                 }else{  two.add(arr[i]); }
    //             }

    //             if(sum<m){System.out.println(-1); continue;}
                
    //             Collections.sort(one);  Collections.reverse(one);
    //             Collections.sort(two);  Collections.reverse(two);
                
    //             int i=0,j=0;
    //             long rsum=0;
    //             int ans=0;
    //             while(i<one.size() && j<two.size() && rsum<m){
    //                 double val1=one.get(i);
    //                 double val2=two.get(j)/2.0;
                    
    //                 if(val1>=val2){rsum+=one.get(i); i++; ans++;}
    //                 else{rsum+=two.get(j); j++;  ans+=2; }
    //             }

    //             while(i<one.size()  && rsum<m){
    //                 int val1=one.get(i);
    //                 rsum+=val1; i++; ans++;
    //             }

    //             while(j<two.size() && rsum<m){
    //                 int val2=two.get(j);
    //                 rsum+=val2; j++;  ans+=2;
    //             }
    //             if(rsum>m && i>0 && (rsum-one.get(i-1))>=m){ans--;}
    //             else if(rsum>m && j>0 && (rsum-two.get(j-1))>=m){ans-=2;}
    //             else if(rsum>m && j>0 && i<one.size() && (rsum-two.get(j-1)+one.get(i))>=m){ans-=1;}
    //             System.out.println(ans);
    //         }
    //     }
    // }






    // public static boolean bsearch(int mid,double[][] arr,int mem){
    //     double sum=0;
    //     double rem=0;
    //     int i=0;
    //     int n=arr.length;

    //     while(i<n && (rem+arr[i][1])<=mid){
    //         // System.out.print(arr[i][0]+" "+arr[i][1]+" "+rem+"  "+mid+"////");
    //         sum+=arr[i][0];
    //         rem+=arr[i][1];
    //         i++;
    //     }
    //     // System.out.println();
    //     if(sum>=mem)return true;
    //     else return false;
    //     // return sum>=mem; 
    // }
    // static class comp implements  Comparator<double[]>{

    //     public int compare(double[] a,double[] b){
    //         if(b[0]/b[1]>a[0]/a[1])return 1;
    //         else return -1;
    //         // return (int)Math.ceil(b[0]/b[1]-a[0]/a[1]);
    //     }
    // }





    //             int[][] dp=new int[m][n];






    //             if(sum<m){System.out.println(-1); continue;}
    //             Arrays.sort(arr,new comp());

    //             int[] omax=new int[n];
    //             int lmax=0;

    //             for(int i=n-1;i>=0;i--){
    //                 omax[i]=lmax;
    //                 if(arr[i][1]==1)lmax=Math.max(lmax,(int)arr[i][0]);
    //             }


    //         double rsum=0;
    //         double rem=0;
    //         int i=0;
    //         // if(omax[0]>=m){rsum=omax[0];}    
    //         while(i<n && rsum<m){
    //             if((rsum+omax[i])>=m){rem++; rsum+=omax[i]; break;}
    //             rsum+=arr[i][0];
    //             rem+=arr[i][1];
    //             i++;
    //             System.out.println(rsum+" "+rem);
    //         }

    //         // if(rsum>=m){System.out.println();}
    //         System.out.println(rem);
    //         // continue;
    //         //     //bs
    //         //     int lo=1,hi=(int)(range);
    //         //     int ans=Integer.MAX_VALUE;
    //         //     while(lo<=hi){
    //         //         int mid=lo+(hi-lo)/2;

    //         //         if(bsearch(mid,arr,m)){
    //         //             hi=mid-1;
    //         //             ans=Math.min(ans,mid);
    //         //         }else{lo=mid+1;}
    //         //         // System.out.println("ans "+ans);
    //         //     }

    //         //     System.out.println(ans);
    //         }
    //     }
    // }


    //     public static void main(String[] args) {
    //         Scanner scn=new Scanner(System.in);
    //         long t=scn.nextLong();
            

    //         while(t-->0){
    //             int a=scn.nextInt();
    //             int b=scn.nextInt();
    //             int k=scn.nextInt();
                
    //             int[] aarr=new int[k];
    //             int[] barr=new int[k];
                
    //             int[] cnta=new int[a+1];
    //             int[] cntb=new int[b+1];
                
    //             for(int i=0;i<k;i++){aarr[i]=scn.nextInt(); cnta[aarr[i]]++;}
    //             for(int i=0;i<k;i++){barr[i]=scn.nextInt(); cntb[barr[i]]++;}
                
    //             long ans=0;//(long)(((long)k*(long)(k-1))/2);
    //               for(int i=0;i<k;i++){
    //                  ans+=k-cnta[aarr[i]]-cntb[barr[i]]+1;
    //                 }
    //             // for(int i=1;i<=b;i++){
    //             //     if(arr2[i]>1){ans-=(arr2[i]-1);}
    //             // }
    //             // for(int i=0;i<k;i++){
    //             //     for(int j=i+1;j<k;j++){
    //             //         if(aarr[i]!=aarr[j] && barr[i]!=barr[j]){ans++;}
    //             //     }
    //             // }

    //             System.out.println(ans/2); // to remove duplicacy ans=ans/2
    //         }
    //     }
    // }
   






//     static int x=0,y=0;
//     public static int gcd(int a, int b) {//, int x, int y) {
//         if (b == 0) {
//             x = 1;
//             y = 0;
//             return a;
//         }
//         int x1=0, y1=0;
//         int d = gcd(b, a % b);
//         x = y1;
//         y = x1 - y1 * (a / b);
//         return d;
//     }

//     static int x0=0,y0=0,g=0;
//     public static boolean find_any_solution(int a, int b, int c) {
//         x=x0; y=y0;
//         g = gcd(Math.abs(a), Math.abs(b));
//         if (c % g==0) {
//             return false;
//         }
    
//         x0 *= c / g;
//         y0 *= c / g;
//         if (a < 0) x0 = -x0;
//         if (b < 0) y0 = -y0;

//         // if(((2020*x0)+(2021*y0))==c)return true;
//         // else return false;

//         return true;
//     }

//     public static void solveSimultaneousEquations(double a, double b, double c, double d, double e, double f) {
//         double det = ((a) * (d) - (b) * (c));  //instead of 1/
//         double x = ((d) * (e) - (b) * (f)) / det;
//         double y = ((a) * (f) - (c) * (e)) / det;
//         System.out.print("x=" + x + " y=" + y);
//     }

//     public static void main(String[] args) {
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();
        

//         while(t-->0){
//             int n=scn.nextInt();

//             int rem=n%2020;

//             int qt=n/2020;

//             if(rem<=qt && n>=2020){
//                 System.out.println("YES");
//             }else{
//                 System.out.println("NO");
//             }
//         }
//     }
// }


            // solveSimultaneousEquations(220,221,1,1, n, 441);


            // int g=0;//gcd(2020,2021,0,0);
            // int x=0,y=0;
            // boolean res=find_any_solution(2020, 2021, n);
            // int val=((2020*x0)+(2021*y0));
            // System.out.println(val);

            // if(((2020*x)+(2021*y))==n){System.out.println("YES");}
            // else{System.out.println("NO");}
            // if(res){
            //     System.out.println("YES");
            // }else{
            //     System.out.println("NO");
            // }
//         }
//     }
// }

//Q1
// public static void main(String[] args) {
//     Scanner scn=new Scanner(System.in);
//     long t=scn.nextLong();
    

//     while(t-->0){
//         long n=scn.nextLong();

//         while(n%2==0){n=n/2;}

//         if(n==1){
//             System.out.println("NO");
//         }else{System.out.println("YES");}
//     }
// }