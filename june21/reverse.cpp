#include<iostream>

using namespace std;
void rev(int* arr,int n){
    int left=0;
    int right=n-1;
    while(left<right){
        swap(arr,left,right);
        left++;
        right--;

    }
}
void swap(int* arr,int left,int right){
    int temp=arr[left];
    arr[left]=arr[right];
    arr[right]=temp;
}
void display(int* arr,int n){
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" "<<endl;

    }
    cout<<endl;
}
int main(int argc,char** argv){
    int* arr=new int[6]{10,20,30,40,50,60};
    rev(arr,6);
    display(arr,6);




   

}