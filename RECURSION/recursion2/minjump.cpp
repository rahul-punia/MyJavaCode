#include<iostream>
#include<string>
#include<vector>
//#include<bits/stdc++.h>
using namespace std;
vector<string> gmj(vector<int>& arr,int idx){
    if(idx==arr.size()-1){
        vector<string> bres;
       bres.push_back("");
       return bres;
    }else if(idx>arr.size()-1){        //int nbr=src+i;
        vector<string> bres;          //if(nbr>)
      return bres;
    }
    vector<string> ntod;
     vector<string> stod;

for(int i=1;i<=arr[idx];i++){
    ntod=gmj(arr,idx+i);
    for(int j=0;j<ntod.size();j++){
      stod.push_back(to_string(i)+ntod[j]);
    }
}

return stod;
}

int main(int argc,char** argv){
    vector<int> arr{3,2,0,4,1,2,0,2,3,0,1};
    vector<string> allpath=gmj(arr,0); 
    for(int i=0;i<allpath.size();i++){
         cout<<allpath[i]<<endl;
     }
     cout<<allpath.size()<<endl;
    }