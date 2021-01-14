#include<iostream>

using namespace std;


void mergesort(int* arr,int lo,int hi,int ele){
    if(lo==hi){
        return;
    }
    int mid=(lo+hi)/2;
    mergesort(arr,lo,mid,ele);
    mergesort(arr,mid+1,hi,ele);

    mergetwosortarray(arr,lo,mid,hi);
}
int main(int argc,char** argv){
    int* arr=new int[8]{9,8,3,1,7,5,2};
    mergesort(arr,0,7,7);
    for(int i=0;i<8;i++){
        cout<<arr[i]<<endl;
    }
}