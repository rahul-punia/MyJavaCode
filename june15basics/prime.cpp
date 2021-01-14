#include<iostream>

using namespace std;

int main(int argc,char** argv){
    int n;
    cout<<"please enter a number"<<endl;
    cin >> n;

    bool flag=true;
    for(int div=2;div*div<=n;div++){
        if(n%div==0){
            flag=false;
            break;
        }
    }
    if(flag==false){
        cout<<n<<"is not prime"<<endl;

    }else{
       cout<<n<<"is prime"<<endl; 
    }
}