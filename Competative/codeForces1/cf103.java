import java.util.*;

public class cf103 {
    

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        long t=scn.nextLong();
        

        while(t-->0){
            int n=scn.nextInt();
            long[] c=new long[n];
            
            long[] a=new long[n];
            long[] b=new long[n];
            for(int i=0;i<n;i++){c[i]=scn.nextLong();}
            for(int i=0;i<n;i++){a[i]=scn.nextLong();}
            for(int i=0;i<n;i++){b[i]=scn.nextLong();}
            
            // int max=0;
            // int cct=0;
            // for(int i=1;i<n;i++){
            //     if(i==1){
            //         cct=Math.abs(a[i]-b[i]);
            //         cct+=2;
            //         max=Math.max(max,cct+(c[i]-1));
            //     }else{
            //         if(a[i]!=b[i])cct+=(c[i-1]-1-Math.abs(a[i]-b[i]));//Math.abs(a[i]-b[i])+
            //         cct+=2;
            //         if(a[i]==b[i]){cct=2;}

            //         max=Math.max(max,cct+(c[i]-1));
            //     }
            // }

        long ans = 0, best_len = Math.abs(a[1] - b[1]);
 
		for (int i = 1; i < n; ++i)
		{
			ans = Math.max(ans, best_len + c[i] + 1);
 
			if (i < n - 1 && a[i + 1] != b[i + 1])
				best_len = Math.max(best_len + 1 + c[i] - Math.abs(a[i + 1] - b[i + 1]), Math.abs(a[i + 1] - b[i + 1]));
 
			else
				best_len = 0;
        }
            
            System.out.println(ans);
        }
    }
}  


//     public static void main(String[] args) {
//         Scanner scn=new Scanner(System.in);
//         // long t=scn.nextLong();
//         // String str=scn.next();
//         // int n=scn.nextInt();

//         // while(t-->0){
//             int n=scn.nextInt();
//             int m=scn.nextInt();
//             int k=scn.nextInt();
            
//             String[] patts=new String[n];
//             String[] strs=new String[m];

//             for(int i=0;i<n;i++){patts[i]=scn.next();}
//             int[] mtj=new int[m];
//             for(int i=0;i<m;i++){strs[i]=scn.next(); mtj[i]=scn.nextInt();}
//              int ans=1;
//              ArrayList<Integer>[] poss=new ArrayList[m];
             
             
//             for(int i=0;i<m;i++){
//                 ArrayList<Integer> list=new ArrayList<Integer>();
//                 String str=strs[i];  
//                 for(int j=0;j<n;j++){
//                     String patt=patts[j]; 
//                     boolean flag=true;
//                     for(int r=0;r<k;r++){
//                          if(patt.charAt(r)=='_' || patt.charAt(r)==str.charAt(r)){}
//                          else{flag=false; break;}
//                      }
//                      if(flag){list.add(j);}
                     
//                 }
//                 if(list.size()==0){ans=-1; break;}
//                 poss[i]=list;
//             }

//             if(ans==-1){System.out.println("NO");}
//             else{System.out.println("YES");}

//         // }
//     }
// }
//     public static void main(String[] args) {
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();
//         // String str=scn.next();
//         // int n=scn.nextInt();

//         while(t-->0){
//             int n=scn.nextInt();
//             double k=scn.nextDouble(); 
//             double[] arr=new double[n];

//             for(int i=0;i<n;i++){arr[i]=scn.nextDouble();}

//             double ans=0;//20.0/3;6.666666666666667
//             double sum=arr[0];
//             double kp=k/(100);
//             for(int i=1;i<n;i++){
//                 System.out.println(i+" ==== "+sum+"    "+k+"        "+ans);
//                 if((arr[i]/sum)>kp){
//                     double nsum=Math.ceil((arr[i]*100.0)/k);
//                     ans+=Math.ceil(nsum-sum);
//                     sum=nsum;
//                     // continue;
//                 }
//                 sum+=arr[i];
//             }

//             System.out.println((long)ans);
//         }
//     }

// }

//     public static void main(String[] args) {
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();
//         // String str=scn.next();
//         // int n=scn.nextInt();

//         while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt(); 
//             int ans=0;
//             if(n<=k){
//                 ans=(int)Math.ceil((k*(1.0))/n);
//             }else{
//                 int ik=k;
//                 while(k<n){
//                     k=ik+k;
//                 }
//                 ans=(int)Math.ceil((k*(1.0))/n);
//             }
//             System.out.println(ans);
//         }

//     }
// }
