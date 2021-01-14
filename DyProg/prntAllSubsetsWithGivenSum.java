// Perfect Sum Problem (Print all subsets with given sum)
// Given an array of integers and a sum, the task is to print all subsets of given array with sum equal to given sum.

// Examples:

// Input : arr[] = {2, 3, 5, 6, 8, 10}
//         sum = 10
// Output : 5 2 3
//          2 8
//          10

// Input : arr[] = {1, 2, 3, 4, 5}
//         sum = 10
// Output : 4 3 2 1 
//          5 3 2 
//          5 4 1 

// This problem is mainly an extension of Subset Sum Problem. Here we not only need to find if there is a subset with given sum, but also need to print all subsets with given sum.

// Like previous post, we build a 2D array dp[][] such that dp[i][j] stores true if sum j is possible with array elements from 0 to i.
// After filling dp[][], we recursively traverse it from dp[n-1][sum]. For cell being traversed, we store path before reaching it and consider two possibilities for the element.
// 1) Element is included in current path.
// 2) Element is not included in current path.

// Whenever sum becomes 0, we stop the recursive calls and print current path.

// Below is implementation of above idea.

import java.util.*; 
public class prntAllSubsetsWithGivenSum 
{ 
    // dp[i][j] is going to store true if sum j is 
    // possible with array elements from 0 to i. 
    static boolean[][] dp; 
       
    static void display(ArrayList<Integer> v) 
    { 
       System.out.println(v); 
    } 
       
    // A recursive function to print all subsets with the 
    // help of dp[][]. Vector p[] stores current subset. 
    static void printallSubsetsRec(int arr[], int i, int sum,  
                                         ArrayList<Integer> p) 
    { 
        // If we reached end and sum is non-zero. We print 
        // p[] only if arr[0] is equal to sum OR dp[0][sum] 
        // is true. 
        if (i == 0 && sum != 0 && dp[0][sum]) 
        { 
            p.add(arr[i]); 
            display(p); 
            p.clear(); 
            return; 
        } 
       
        // If sum becomes 0 
        if (i == 0 && sum == 0) 
        { 
            display(p); 
            p.clear(); 
            return; 
        } 
       
        // If given sum can be achieved after ignoring 
        // current element. 
        if (dp[i-1][sum]) 
        { 
            // Create a new vector to store path 
            ArrayList<Integer> b = new ArrayList<>(); 
            b.addAll(p); 
            printallSubsetsRec(arr, i-1, sum, b); 
        } 
       
        // If given sum can be achieved after considering 
        // current element. 
        if (sum >= arr[i] && dp[i-1][sum-arr[i]]) 
        { 
            p.add(arr[i]); 
            printallSubsetsRec(arr, i-1, sum-arr[i], p); 
        } 
    } 
      
    


    // Prints all subsets of arr[0..n-1] with sum 0. 
    static void printAllSubsets(int arr[], int n, int sum) 
    { 
        if (n == 0 || sum < 0) 
           return; 
       
        // Sum 0 can always be achieved with 0 elements 
        dp = new boolean[n][sum + 1]; 
        for (int i=0; i<n; ++i) 
        { 
            dp[i][0] = true;   
        } 
       
        // Sum arr[0] can be achieved with single element 
        if (arr[0] <= sum) 
           dp[0][arr[0]] = true; 
       
        // Fill rest of the entries in dp[][] 
        for (int i = 1; i < n; ++i) 
            for (int j = 0; j < sum + 1; ++j) 
                dp[i][j] = (arr[i] <= j) ? (dp[i-1][j] || 
                                           dp[i-1][j-arr[i]]) 
                                         : dp[i - 1][j]; 
        if (dp[n-1][sum] == false) 
        { 
            System.out.println("There are no subsets with" +  
                                                  " sum "+ sum); 
            return; 
        } 
       
        // Now recursively traverse dp[][] to find all 
        // paths from dp[n-1][sum] 
        ArrayList<Integer> p = new ArrayList<>(); 
        printallSubsetsRec(arr, n-1, sum, p); 
    } 
      
    //Driver Program to test above functions 
    public static void main(String args[]) 
    { 
        int arr[] = {1, 2, 3, 4, 5}; 
        int n = arr.length; 
        int sum = 10; 
        printAllSubsets(arr, n, sum); 
    } 
} 