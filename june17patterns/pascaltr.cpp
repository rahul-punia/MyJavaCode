#include<iostream>

using namespace std;
int main(int argc,char** argv){
    int n1=6;
    
    
    for(int n=0;n<n1;n++){
        int nck=1;
        for(int k=0;k<=n;k++){
            cout<<nck;
            nck=nck*(n-k)/(k+1);
        }
        cout<<endl;
    }
    }

