import java.util.*;
import java.io.*;
import java.lang.*;


public class pascalTraingle {
        //https://www.hackerearth.com/practice/math/combinatorics/basics-of-combinatorics/tutorial/
        //https://www.geeksforgeeks.org/pascal-triangle/
         //Pascal Triangle-   
        // 1 
        // 1 1 
        // 1 2 1 
        // 1 3 3 1 
        // 1 4 6 4 1 
        // 1 5 10 10 5 1 
        // 1 6 15 20 15 6 1
        //int C=1;   
        //C = C * (i - j) / j;
       public static void pt(int n){
           int[][] dp=new int[n][n];

        //    dp[0][(n/2)-1]=1;

           for(int i=0;i<n;i++){
               for(int j=0;j<=i;j++){  //imp j<=i  
                   if(i==j || j==0){ dp[i][j]=1; }
                   else {dp[i][j]=dp[i-1][j-1]+dp[i-1][j];}
               }
           }

           for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==0){
                    System.out.print(" "+" ");
                }else{
                    System.out.print(dp[i][j]+" ");
                }
            }
            System.out.println();
        }


       } 

       public static void main(String[] args) throws Exception{
        pt(6);
     }

}
