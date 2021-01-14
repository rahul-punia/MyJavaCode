#include<iostream>

using namespace std;
int fact(int n){

       if(n==0 || n==1){
           
           return 1;
       }
    
     
    int fnm1=fact(n-1);
    int fact=n*fnm1;
    return fact;
    
}
int main(int argc,char** argv){
int ans=fact(5);
cout<<ans<<endl;
}