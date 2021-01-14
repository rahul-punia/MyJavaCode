import java.util.*;

public class Intuit {
    //Time limit Excedded
   public static int MinCost(int[] cost,int n,int[] dp,int ind){
        if(ind<0)
             return Integer.MAX_VALUE;
        if(ind>n-1)
             return Integer.MAX_VALUE;
    
        if(dp[ind]!=-1)
             return dp[ind];

        System.out.println("Rahul");
        // dp[ind]=Math.min(cost[ind-2]+MinCost(cost,n,dp,ind-2),cost[ind+1]+MinCost(cost,n,dp,ind+1));
        int fnm2=MinCost(cost,n,dp,ind-2);
        int fnp1=MinCost(cost,n,dp,ind+1);
        dp[ind]=cost[ind]+Math.min(fnm2,fnp1);
        return dp[ind];
    
    }
    public static void main(String[] args){
        // int[] arr={1,2,3,6,4,9,7,6,5,100};

        // System.out.println(MinCost(arr, n , dp, n-1));
 
        // An array of costs was given. You can either take two jumps forward or one jump backward. 
        // If you land on a particular index, you have to add the cost to your total. Find the minimum 
        // cost needed to cross the array or reach the end of the array.

        //Correct Solution from stack Overflow 
        int arr[]={1,2,3,4,100};//{9,4,6,8,5};
        int startIndex=0;
        int DP[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            DP[i]=100000;//I just take this as maximum value .you can change it. 
        }
        DP[startIndex] = arr[startIndex]   ;
        DP[startIndex+2] = arr[startIndex] + arr[startIndex+2] + Math.min(arr[startIndex+2], arr[startIndex]);
    
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            if ((i+1)<n)
                DP[i] = Math.min(DP[i], (DP[i+1]) + arr[i]);
            if ((i + 2 )< n)                 
                DP[i+2] = DP[i] + arr[i+2];
        }
        System.out.println(Math.min(DP[arr.length-1],DP[arr.length-2]));
        
        for(int i=0;i<n;i++){
            System.out.print(DP[i]+"  ");
        }
    }
}
