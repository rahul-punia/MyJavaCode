#include<iostream>

using namespace std;


void downheapify(int* arr,int i,int l){
    int li=2*i+1;
    int ri=2*i+2;
    
    int mi=i;

    if(arr[li]>arr[mi])
       mi=li;

       if(arr[ri]>arr[mi])
       mi=ri;

       if(mi!=i){
           swap(arr[mi],arr[i]);
           downheapify(arr,mi,l);
         }
       }
       void hs(int* arr,int n){
           for(int i=n/2-1;i>=0;i--){
               downheapify(arr,i,0);
           }
           for(int i=1;i<=n-1;i++){
               swap(arr[0],arr[n-1]);
               downheapify(arr,0,n-i-1);
           }
       }
       int main(int argc,char** argv){
         int* arr=new int[8] {9,2,1,5,0,6,4,7};
         hs(arr,8);
         for(int i=0;i<8;i++){
             cout<<arr[i]<<" ";
         }
       }
