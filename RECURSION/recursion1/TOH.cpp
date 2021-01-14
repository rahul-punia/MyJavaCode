#include<iostream>

using namespace std;
static int ct=0;
void toh(int n,int st,int dt,int ht){
    if(n==0){
        return;
    }
     
      
    toh(n-1,st,ht,dt);
    cout<<"step-"<<++ct<<" movedisk"<<n<<"["<<st<<"-> "<<dt<<" ] via"<<ht<<endl;
    toh(n-1,ht,dt,st);
    // cout<<"1 [dt->st]"<<endl;
    // cout<<"2 [dt->ht]"<<endl;
    // cout<<"1 [st->ht]"<<endl;
    // cout<<"3 [st->dt]"<<endl;
    //  cout<<"1 [ht->st]"<<endl;
    // cout<<"2 [ht->dt]"<<endl;
    // cout<<"1 [st->dt]"<<endl;
 }

void toh2(int n,char st,char dt,char ht){
    if(n==0){
        return;
    }
    toh2(n-1,st,ht,dt);
    cout<<"step-"<<++ct<<"  "<<n<<"["<<st<<"->"<<dt<<"]"<<endl;
    toh2(n-1,ht,dt,st);
}

int main(int argc,char** argv){
toh(3,1,2,3);
toh2(3,'a','b','c');
}