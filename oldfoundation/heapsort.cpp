#include<iostream>

using namespace std;

// int get(int* a,int n,int i){    //to check priority of greater number
// if(i<n){
//     return a[i];
// }else{
//     return b[i-n];
// }
// }

// void set(int* a,int* b,int n,int m,int i,int val){
//    if(i<n){
//        a[i]=val;
//        }else{
//            b[i-n]=val;
//        }
//    }
//  void myswap(int* a,int n,int i,int j){
//            int vi=get(a,n,i);   //value at i
//            int vj=get(a,n,j);   //value at j
//            set(a,n,i,vj);       //set value of j at i
//            set(a,n,j,vi);       //set value of i at j
//        }

void downheapify(int* a,int i,int last){
    int li=2*i+1;    //left child idx
    int ri=2*i+2;   //right child idx
    int mi=i;       // mid parent idx

    if(li<=last && a[li]>a[mi])
       mi=li;

    if(ri<=last && a[ri]>a[mi])
       mi=ri;

    if(mi!=i){
           swap(a[i],a[mi]);
           downheapify(a,mi,last); //d
       }
 }
void heapsort(int* a,int n){
           for(int i=n/2-1;i>=0;i--){   //first make max heap & then swap first & last then again make max heap
               downheapify(a,i,n-1);   // & swap first , last-1,& so on.....
           }
           for(int i=1;i<=n-1;i++){
               swap(a[0],a[n-i]);
               downheapify(a,0,n-i-1);
           }
       }
       

       int main(int argc,char** argv){
           int a[]={7,4,9,0};
           int b[]={11,14,3,1,5,8,2};
           heapsort(b,7);
           for(int i=0;i<7;i++){
               cout<<b[i]<<" ";
           }
           cout<<endl;
        }