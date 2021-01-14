#include<iostream>

using namespace std;
int main(int argc,char** argv){
    int n=5;
    int nst=1;
    int nsp=n/2;
    int no=1;

    for(int r=1;r<=n;r++){
        for(int i=1;i<=nsp;i++){
            cout<<" ";
        }
         for(int i=1;i<=nst;i++){
            cout<<no;
            if(i<=nst/2){
                no++;
            }else if(i<nst){
                no--;
            }
        }
         for(int i=1;i<=nsp;i++){
            cout<<" ";
        }


        if(r<=n/2){
            nsp--;
            nst+=2;
            no++;
        }else{
            nsp++;
            nst-=2;
            no--;
        }
        cout<<endl;
    }
}