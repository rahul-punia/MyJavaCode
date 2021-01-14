#include<iostream>

using namespace std;
void swap(int* a,int* b){
        int temp=*a;
        *a=*b;
        *b=temp;
    }

void reverse(int* arr,int l,int r){
    while(l<r){
        swap(&arr[l],&arr[r]);
        l++;
        r--;
    }
}
    

void display(int* arr,int n){
    for(int i=0;i<n;i++){
        cout<<arr[i];
    }
    cout<<endl;

}
void rotate(int* arr,int n,int k){
    k=k%n;
    k=k<0?k+n:k;      //ifk=-2 then k=-2+7=5 sa rotate
    reverse(arr,0,n-k-1);
    reverse(arr,n-k,n-1);
    reverse(arr,0,n-1);

}

int main(int argc,char** argv){
    // int* arr = new int[7];
    // arr[0]=1;
    // arr[1]=2;
    // arr[2]=3;
    // arr[3]=4;
    // arr[4]=5;
    // arr[5]=6;
    // arr[6]=7;
    
    int* arr=new int[7] {1,2,3,4,5,6,7};
    rotate(arr,7,3);
    display(arr,7);
    rotate(arr,7,51);     //2 rotate
    display(arr,7);
    rotate(arr,7,30);   // 30%7=2rotate 
    display(arr,7);
     rotate(arr,7,-3);
    display(arr,7);
   
    
    return 1;
}