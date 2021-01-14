#include<iostream> 
#include<vector>

using namespace std;
// void filter(vector<int>* v){

//     for(int i=v->size()-1;i>=0;i--){
//         if(v[i]>50){
//         v->erase(v->begin()+i);
//         }
//     }
//     for(int i=0;i<v->size();i++){
//         cout<<v[i]<<" ";
//     }
//     cout<<endl;
// }
// void filter(vector<int>& v){

//     for(int i=v.size()-1;i>=0;i--){
//         if(v[i]>50){
//         v.erase(v.begin()+i);
//         }
//     }
//     for(int i=0;i<v.size();i++){
//         cout<<v[i]<<" ";
//     }
//     cout<<endl;
// }
void filter(vector<int>& v){

    for(int i=0;i<v.size();i++){
        if(v[i]>50){
        v.erase(v.begin()+i);
        i--;
        }
    }
    for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    cout<<endl;
}
int main(int argc,char** argv){
    vector<int> v {10,20,90,40,70,80,5};
    filter(v) ;
     for(int i=0;i<v.size();i++){
        cout<<v[i]<<" ";
    }
    cout<<endl;
}