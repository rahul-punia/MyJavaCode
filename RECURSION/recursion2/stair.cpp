#include<iostream>
#include<string>
#include<vector>
using namespace std;
vector<string> gsp(int src){
    if(src==0){
       vector<string> bp;
       bp.push_back("");
       return bp; 
    }else if(src<0){
       vector<string> bp;
       return bp; 
    }
 vector<string> stod;
    for(int step=1;step<=3;step++){ //options
        int nbr=src-step;                       //if(src>=step)
        vector<string> ntod=gsp(nbr);
     for(int i=0;i<ntod.size();i++){
        string ntodpath=ntod[i];
        string stodpath=to_string(step)+ntodpath;
        stod.push_back(stodpath);
    }
    }
    return stod;
}
int main(int argc,char** argv){
   vector<string> ppath=gsp(7);
   for(int i=0;i<ppath.size();i++){
       cout<<ppath[i]<<endl;
   }
   cout<<ppath.size()<<endl;
}

