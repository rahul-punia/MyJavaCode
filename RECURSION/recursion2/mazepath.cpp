#include<iostream>
#include<string>
#include<vector>
using namespace std;
vector<string> gmp(int sr,int sc,int dr,int dc){
    if(sr==dr && sc==dc){
        vector<string> bp;
        bp.push_back("");
        return bp;
    }
    vector<string> tpath;
    vector<string> hpath;
    vector<string> vpath;
    if(sc<dc){
   hpath =gmp(sr,sc+1,dr,dc);
    }
    if(sr<dr){
  vpath =gmp(sr+1,sc,dr,dc);
    }
   for(int i=0;i<hpath.size();i++){
       string hst=hpath[i];
       string chst="h"+hst;
       tpath.push_back(chst);
       

   }
    for(int i=0;i<vpath.size();i++){
       string vst=vpath[i];
       string cvst="v"+vst;
       tpath.push_back(cvst);
        }
        return tpath;

}
int main(int argc,char** argv){
    vector<string> allpath=gmp(0,0,3,4);
     for(int i=0;i<allpath.size();i++){
         cout<<allpath[i]<<endl;
     }
     cout<<allpath.size()<<endl;
    }
