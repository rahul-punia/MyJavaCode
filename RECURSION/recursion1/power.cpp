#include<iostream>
using namespace std;
int power(int x,int n){
    if(n==0){
        return 1;
    }
    int powm1=power(x,n-1);
    return x*powm1;

}
int powbtr(int x,int n){
    if(n==0){
        return 1;
    }
    int xpnb2=powbtr(x,n/2);
    int xpn=xpnb2*xpnb2;
    if(n%2==1){          //for odd power
        xpn=xpn*x;
    }
    return xpn;
}
int main(int argc,char** argv){
int ans=power(3,3);
cout<<ans<<endl;
 ans=power(3,3);
cout<<ans<<endl;

}