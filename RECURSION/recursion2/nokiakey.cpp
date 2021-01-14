#include<iostream>
#include<string>
#include<vector>
using namespace std;

string codes[10]={".","abc","def","ghi","jklm","no","pqrs","tu","vwxy","ez"};
static int ct=0;
vector<string> getkpc(string str){
    if(str.length()==0){
        vector<string> bres;
        bres.push_back("");
        ct++;
        return bres;
    }
    char ch=str[0];
    string ros=str.substr(1,str.length()-1);

    vector<string> mres;
    string code=codes[ch-'0'];//ch-48
  
  for(int i=0;i<code.length();i++){
    char chcode=code[i];
    vector<string> rres=getkpc(ros);//recursion result
    for(int j=0;j<rres.size();j++){
      string rstr=rres[j];
      mres.push_back(chcode+rstr);
    }
}

return mres;
}
int main(int argc,char** atgv){
    vector<string> words=getkpc("835");
    for(int i=0;i<words.size();i++){
        cout<<words[i]<<endl;
    }
    cout<<ct<<endl;
}