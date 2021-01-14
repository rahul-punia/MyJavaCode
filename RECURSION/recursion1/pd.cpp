#include<iostream>

using namespace std;
void pd(int n){
    if(n==0){
        return;
    }
    cout<<n<<endl;
    pd(n-1);
    cout<<n<<endl;
    
    
}
int main(int argc,char** argv){
pd(5);
}