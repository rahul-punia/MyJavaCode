#include<iostream>
#include<cmath>
using namespace std;
int main(int argc,char** argv){
    int n1=14;
    int n2=21;

    while(n1!=0){
        int rem=n2%n1;
        n2=n1;
        n1=rem;


    }
    cout<<n2<<endl;
}