import java.util.*;

public class sortAlgo {

    public static void BubbleSort(int[] arr){//T(n)=O(n^2)
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j]>arr[j+1]){
                int temp=arr[j]; arr[j]=arr[j+1]; arr[j+1]=temp; //swap
                }
            }
        }

        for(int val:arr)System.out.print(val+"  ");
    }

    public static int[] mergesortedArr(int[] arr1,int[] arr2){
        int m=arr1.length; int n=arr2.length;
        int[] sortedArr=new int[m+n];
        int i=0,j=0,k=0;

        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                 sortedArr[k++]=arr1[i++];
            }else{
                sortedArr[k++]=arr2[j++];
            }
        }
        while(i<m){
            sortedArr[k++]=arr1[i++];
        }
        while(j<n){
            sortedArr[k++]=arr2[j++];
        }
        return sortedArr;
    }

    public static int[] mergeSort(int[] arr,int lo,int hi){//  T(n)=O(n*logn) space=o(n)
       if(lo==hi){
           return new int[]{arr[lo]};
       }
       int mid=(lo+hi)/2;
       int[] leftsortedArr=mergeSort(arr, lo, mid);
       int[] rightsortedArr=mergeSort(arr, mid+1, hi);

       int[] sortedArr=mergesortedArr(leftsortedArr,rightsortedArr);
       return sortedArr;
    }


    public static void merge(int[] arr,int lo,int mid,int hi){
        int m=mid-lo+1; int n=hi-mid;
        int[] arr1=new int[m];
        int[] arr2=new int[n];

        for(int i=0;i<m;i++){
            arr1[i]=arr[lo+i];
        }

        for(int i=0;i<n;i++){
            arr2[i]=arr[mid+i+1];
        }
        int i=0,j=0,k=0;
     
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                 arr[lo+k]=arr1[i++];  k++;
            }else{
                arr[lo+k]=arr2[j++];   k++;
            }
        }
        while(i<m){
            arr[lo+k]=arr1[i++];    k++;
        }
        while(j<n){
            arr[lo+k]=arr2[j++];   k++;
        }
    
    }

    public static void mergesort(int[] arr,int lo,int hi){//  T(n)=O(n*logn) space=o(1)
       if(lo==hi){
           return ;
       }
       int mid=(lo+hi)/2;
       mergesort(arr, lo, mid);
       mergesort(arr, mid+1, hi);

       merge(arr,lo,mid,hi);
    }
    public static void main(String[] args){
        BubbleSort(new int[]{2,3,-3,8,7,9,5,3,4});
        System.out.println();
        int[] arr1={2,3,-3,8,7,9,5,3,4};
        mergesort(arr1,0,arr1.length-1);
        for(int val:arr1)System.out.print(val+"  ");
        
    }
}