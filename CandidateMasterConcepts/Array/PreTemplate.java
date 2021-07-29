import java.util.*;
import java.io.*;
import java.lang.*;

public class PreTemplate {


    public static void sort(long[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			long temp = arr[i];  arr[i] = arr[idx];  arr[idx] = temp;  //swap
		}
		Arrays.sort(arr);
	}
 
	public static void sort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int idx = (int) Math.random() * n;
			int temp = arr[i];  arr[i] = arr[idx]; arr[idx] = temp;  //swap
		}
		Arrays.sort(arr);
	}
 
	public static void print(long[][] dp) {
		for (long[] a : dp) {
			for (long val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
 
	public static void print(int[][] dp) {
		for (int[] a : dp) {
			for (int val : a) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
 
	public static void print(int[] dp) {
		for (int val : dp) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
 
	public static void print(long[] dp) {
		for (long val : dp) {
			System.out.print(val + " ");
		}
		System.out.println();
	}  
    
    
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
