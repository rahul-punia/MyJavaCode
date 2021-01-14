#include<iostream>

using namespace std;

int mergetwosortarray(int* arr,int lo,int hi){
    int* aux=new int[hi-lo+1];
    int inv=0;
    int mid=(lo+hi)/2;
    int i=lo;
    int j=mid+1;
    int k=0;

    while(i<=mid && j<=hi){
        if(arr[i]<arr[j]){
            aux[k++]=arr[i++];
        }else if(arr[i]>arr[j]){
            aux[k++]=arr[j++];
            inv+=mid+1-i;
        }
    }
     while(i<=mid){
         aux[k++]=arr[i++];
     }
     while(j<=hi){
         aux[k++]=arr[j++];
     }
     for(i=0;i<hi-lo+1;i++){
         arr[lo+i]=aux[i];
     }
     return inv;

}
int mergesort(int* arr,int lo,int hi){
    if(lo==hi){
        return 0;
    }
    int mid=(lo+hi)/2;
    int li=mergesort(arr,lo,mid);
    int ri=mergesort(arr,mid+1,hi);

    int si=mergetwosortarray(arr,lo,hi);
    return li+ri+si;
}
int main(int argc,char** argv){
    int* arr=new int[8]{4,5,3,2,8,7,9,1};
   int count= mergesort(arr,0,7);
    for(int i=0;i<8;i++){
        cout<<arr[i]<<endl;
    }
    cout<<count<<endl;
}