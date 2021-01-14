#include<iostream>

using namespace std;

void gcdrecursion(int n1,int n2,int rem){
   if(rem==0){
       cout<<n2<<endl;
       return;
   }
   
   rem=n2%n1;
   n2=n1;
   n1=rem;
   gcdrecursion(n1,n2,rem);

}

int main(int argc,char** argv){
   cout<<"Enter two number"<<endl;
   int n1,n2;
   cin>>n1>>n2;
   gcdrecursion(n1,n2,n1%n2);
}