import java.util.*;

public class kcon {
    public static long maxsum(ArrayList<Integer> arr){
        long cs=-10000000; long bs=Integer.MIN_VALUE;  //V.imp
             for(int j=0;j<arr.size();j++){
         //  System.out.print(arr[j]+" ");
           cs=Math.max(arr.get(j),cs+arr.get(j));
           bs=Math.max(cs,bs);
             }
           return bs;
   } 

   public static void main(String[] args){
       // your code goes here
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		
		for(int i=0;i<t;i++){
		    int n=scn.nextInt();
		    int k=scn.nextInt();
		   ArrayList<Integer> arr=new ArrayList<>();
		    for(int j=0;j<n;j++){
                int val=scn.nextInt();
		        arr.add(val);
		    }
		    if(k==1){
		   System.out.println(maxsum(arr));
		   }else{
		       long sum=0;
               for(int j=0;j<n;j++){sum+=arr.get(j); 
                arr.add(arr.get(j));}
		    //    System.out.println("rahul");
		       long ans=maxsum(arr);
		       if(sum>0){
		           ans+=sum*(k-2);
		       }
		   System.out.println(ans);     
		   }
		}
   }


}