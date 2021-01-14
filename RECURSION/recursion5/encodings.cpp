#include<iostream>
#include<vector>
using namespace std;

void encodings(string ques,string asf){
    if(ques.size()==0){
        cout<<asf<<endl;
        return;
     }else if(ques.size()==1){
      char ch0=ques[0];
      string roq0=ques.substr(1,ques.length()-1);
     if(ch0!='0'){
      int num=ch0-48;
      char code='a'+num-1;
      encodings(roq0,asf+code);
     }
    }else{
     char ch0=ques[0];
    string roq0=ques.substr(1,ques.length()-1);
     if(ch0!='0'){
      int num=ch0-48;
      char code='a'+num-1;
      encodings(roq0,asf+code);
  }
  char ch1=ques[1];
  string roq1=ques.substr(2,ques.length()-2);
     if(ch0!='0'){
            int num=(ch0-48)*10+(ch1-48);
            if(num>=10 &&num<=26){
                char code='a'+num-1;
                encodings(roq1,asf+code);
            }
       }
    } 
  
}
// void mango(vector<string> dictionarty, string str){

// }
int main(int argc,char** argv){
  //encodings("1123","");
  encodings("1021","");
  string str="ilikesamsungmango";
 // vector<string> dic={"like","sung","go","man","mango","sum","samsung","i"};
 // mango(dic,str);

  //converting string in to integer -start
//   string s="1123 456";
//   stringstream sin(s);
//   int i=0;
//   int j=0;
//   sin>>i>>j;
//   cout<<i<<j<<endl;
//converting string to integer -end
}