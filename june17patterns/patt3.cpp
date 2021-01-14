#include<iostream>

using namespace std;

int main(int argc,char** argv){
int n=8;
int n1=1;
 int sp=2*n-3;
     int no=1;
    for(int r=1;r<=n;r++){
    n1=1;

     for(int j=1;j<=no;j++){
         cout<<n1;
        if(j<no){
         n1++;
         }
     }
      for(int j=1;j<=sp;j++){
         cout<<" ";
        
     }
    if(r==n){
        n1=n1-1;
        no=no-1;
    }
      for(int j=1;j<=no;j++){
         cout<<n1;
         n1--;
     }
     
     sp-=2;
     no++;
    
    cout<<endl;
}}