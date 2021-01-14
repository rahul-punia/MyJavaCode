import java.util.*;

public class practise{
    public static int stockskt(int[] prices,int k,int n){
        int[][] profit=new int[k+1][n];

        for(int i=0;i<=k;i++){
            int prevdiff=Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    profit[i][j]=0;
                }else if(i==0 ){
                    profit[i][j]=0;
                }else if(j==0){
                    profit[i][j]=0;
                }else{
                    
                    prevdiff=Math.max(prevdiff, profit[i-1][j-1]-prices[j-1]);
                    profit[i][j]=Math.max(profit[i][j-1], prevdiff+prices[j]);
                }
            }
        }
        for(int i=0;i<profit.length;i++){
            for(int j=0;j<profit[0].length;j++){
                System.out.print(profit[i][j]+" ");
            }
            System.out.println();
        }
        return profit[profit.length-1][profit[0].length-1];
        
    }

    public static void main(String[] args){
        int [] prices={2, 30, 15, 10, 8, 25, 80};//{10,22,5,75,65,80};
        int  k=2;
        int n=prices.length;
        System.out.println(stockskt(prices, k, n));
    }
}