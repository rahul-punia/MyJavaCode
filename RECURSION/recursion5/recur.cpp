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
    
   
    for(int stp=1;stp<=dc-sc;stp++){
    vector<string> hpath=gmp(sr,sc+stp,dr,dc);
    
     for(int i=0;i<hpath.size();i++){
       tpath.push_back("h"+to_string(stp)+hpath[i]);
   
   }
    }
    for(int stp=1;stp<=dr-sr;stp++){
    
    vector<string> vpath =gmp(sr+stp,sc,dr,dc);
  for(int i=0;i<vpath.size();i++){
       tpath.push_back("v"+to_string(stp)+vpath[i]);
        }
    
    }

    for(int stp=1;stp<=dc-sc&&stp<= dr-sr;stp++){
    
      vector<string> dpath =gmp(sr+stp,sc+stp,dr,dc);
     for(int i=0;i<dpath.size();i++){
       tpath.push_back("d"+to_string(stp)+dpath[i]);
  }
    
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
