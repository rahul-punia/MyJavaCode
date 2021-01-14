#include<iostream>
 using namespace std;
 void oddeven(int n){
     if(n==0){
         return;
     }
     if(n%2==1){
         cout<<n<<endl;
     }
     oddeven(n-1);
     if(n%2==0){
       cout<<n<<endl;
     }
 }
 int main(int argc,char** argv){
     oddeven(6);
 }
