#include<iostream>
#include<vector>

using namespace std;
bool isodd(int num){
if(num%2==1){
    return true;
}else{
    return false;
}
}
vector<int> check(int n){
    vector<int> res;
    for(int i=1;i<=n;i++){
        int num;
        cout<<"Enter"<<i<<"th number";
        cin>>num;

        bool flag=isodd(num);
        if(flag==true){
            res.push_back(num);
        }
    }
    return res;

}
int main(int argc,char** argv){
int n;
cout<<"Enter the count";
cin>>n;
vector<int> v=check(n);
for(int i=0;i<v.size();i++){
    cout<<v[i]<<" ";
}
cout<<endl;
}