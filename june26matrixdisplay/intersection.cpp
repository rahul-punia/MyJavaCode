#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
int main(int argc,char** argv){
    vector<int> v1 {3,1,2,2,2,1,5};
    vector<int> v2 {5,1,1,2,2,4,1};
   int i=0;
   int j=0;
   sort(v1.begin(),v1.end());
   sort(v2.begin(),v2.end());
   while(i<v1.size() && v2.size()){
       if(v1[i]==v2[j]){
        cout<<v1[i]<<" ";
        i++;
        j++;
       }else{
           if(v1[i]<v2[j]){
               i++;
           }else{
               j++;
           }
       }
   }
}