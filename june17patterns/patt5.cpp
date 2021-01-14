#include<iostream>

using namespace std;
int main(int argc,char** argv){
    int n=5;

    int nst=1;
    int nsp=n/2+1;
   
    for(int r=1;r<=n;r++){
        for(int i=1;i<=nsp;i++){
            cout<<"* ";
        }
         for(int i=1;i<=nst;i++){
            cout<<"  ";
           
        }
         for(int i=1;i<=nsp;i++){
            cout<<"* ";
        }


        if(r<=n/2){
            nsp--;
            nst+=2;
        }else{
            nsp++;
            nst-=2;
        }
        cout<<endl;
    }
}