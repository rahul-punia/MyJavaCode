#include<iostream>

using namespace std;

int get(int* a,int* b,int n,int m,int i){    //to check priority of greater number
if(i<n){
    return a[i];
}else{
    return b[i-n];
}
}

void set(int* a,int* b,int n,int m,int i,int val){
   if(i<n){
       a[i]=val;
       }else{
           b[i-n]=val;
       }
   }
 void myswap(int* a,int* b,int n,int m,int i,int j){
           int vi=get(a,b,n,m,i);   //value at i
           int vj=get(a,b,n,m,j);   //value at j
           set(a,b,n,m,i,vj);       //set value of j at i
           set(a,b,n,m,j,vi);       //set value of i at j
       }

void downheapify(int* a,int* b,int n,int m,int i,int last){
    int li=2*i+1;
    int ri=2*i+2;
    int mi=i;

    if(li<=last && get(a,b,n,m,li)>get(a,b,n,m,mi))
       mi=li;

    if(ri<=last && get(a,b,n,m,ri)>get(a,b,n,m,mi))
       mi=ri;

    if(mi!=i){
           myswap(a,b,n,m,mi,i);
           downheapify(a,b,n,m,mi,last); //d
       }
 }
void heapsort(int* a,int* b,int n,int m){
           int vl=n+m;                         //virtual length
           for(int i=vl/2-1;i>=0;i--){
               downheapify(a,b,n,m,i,vl-1);
           }
           for(int i=1;i<=vl-1;i++){
               myswap(a,b,n,m,0,vl-i);
               downheapify(a,b,n,m,0,vl-i-1);
           }
       }
       

       int main(int argc,char** argv){
           int a[]={7,4,9,0};
           int b[]={11,14,3,1,5,8,2};
           heapsort(a,b,4,7);
           for(int i=0;i<4;i++){
               cout<<a[i]<<" ";
           }
           cout<<endl;
           for(int j=0;j<7;j++){
               cout<<b[j]<<" ";
           }
           cout<<endl;
       }