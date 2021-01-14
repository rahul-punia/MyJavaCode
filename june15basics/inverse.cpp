#include<iostream>
#include<cmath>
using namespace std;
int main(int argc,char** argv){
    int n=215634;
    int rs=0;
    int ct=0;

    while(n!=0){
        int rem=n%10;
        ct++;
        rs+=ct*pow(10,(rem-1));
        n=n/10;
    }
    cout<<rs<<endl;
}