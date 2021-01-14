import java.util.*;

public class cc3 {

    public static boolean isvalid(int[] arr,int div){

        for(int i=0;i<arr.length;i++){
            if(arr[i]%div!=0)return false;
        }

        return true;
    }

    public static int  getcost(int[] arr,int div){
        int len=0;
        for(int i=0;i<arr.length;i++){
            len+=arr[i]/div;
        }

        return len;
    }

    public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
        int n=scn.nextInt();
        int[] arr=new int[n];
        int min=Integer.MAX_VALUE;
        boolean flag=true; long sum=0;
            
         for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
            sum+=arr[i];
            min=Math.min(min,arr[i]);
         }

         int lo=1,hi=min;
         int ans=0;
         while(lo<=hi){
            //  int mid=lo+(hi-lo)/2;
             if(isvalid(arr,lo)){
                ans=lo;
             }
             lo++;
         }
         int cost=getcost(arr, ans);
         System.out.println(ans+" "+cost);

        }
    }
}




        //  if(!flag){
        //      System.out.println(sum+" "+sum);
        //  }else{

        //     int ans=1,div=2,len=sum;

        //     boolean fg=true;

        //     while(fg){

        //         for(int i=0;i<n;i++){
        //             if(arr[i]%div!=0){fg=false;  break;}
        //         }
        //         if(fg){ans=div; len=sum/div; div*=2;}
        //     }

        //     System.out.println(ans+" "+len);
        //  }
        // }
        


        // for(int i=0;i<n;i++){
        //     int num=scn.nextInt();
        //     int os=0,es=0;
        //     while(num>0){
        //         int rem=num%10;

        //         if(rem%2==0){
        //             es+=rem;
        //         }else{
        //             os+=rem;
        //         }
        //         num=num/10;
        //     }

        //     if(os%3==0 || es%4==0){
        //         System.out.println("Yes");
        //     }else{
        //         System.out.println("No");
        //     }
        //     // String str=""+num;

        //     // for(int i=0;i)
        // }

		// int m=scn.nextInt();
		// int n=scn.nextInt();
		// int a=scn.nextInt();
		
        // double ans=Math.ceil(m*1.0/a)*Math.ceil(n*1.0/a);
        // System.out.println((int)ans);
   

		// your code goes here
// 		Scanner scn=new Scanner(System.in);
		
// 		int n=scn.nextInt();
        
//        HashMap<Integer,Integer> hm=new HashMap<>();

//        for(int i=0;i<n;i++){
//            int val=scn.nextInt();
//            hm.put(val, hm.getOrDefault(val, 0)+1);
//        }
//        int ans=-1;
//        for(int i=0;i<(n+1);i++){
//         int val=scn.nextInt();
//         if(hm.getOrDefault(val, 0)>0){
//             hm.put(val, hm.getOrDefault(val, 0)-1);
//         }else{
//             ans=val;
//         }
//     }

//     System.out.println(ans);
//     }
// }

//         int k=scn.nextInt();
		
// 		for(int i=0;i<k;i++){
		    
// 		    if(n%10==0){
// 		        n=n/10;
// 		    }else{
// 		        n--;
// 		    }
// 		}
		
// 	System.out.println(n);
// 	}
// }
