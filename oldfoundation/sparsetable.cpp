#include<iostream>
#include<vector>

using namespace std;

vector<vector<int> > sparse;
vector<int> logs;
int getlog(int n){
    int x=0;
    while((1<<x)<=n)
        x++;
        return x-1;
    
}
void build(vector<int> arr){
    logs=vector<int>(arr.size()+1);
    for(int i=1;i<=arr.size();i++){
        logs[i]=getlog(i);
       
    }
    int cols=getlog(arr.size()+1);
     int rows=arr.size()-1;
     sparse=vector<vector<int> >(arr.size(),vector<int>(cols,0));

     for(int j=0;j<cols;j++){
         for(int i=0;i<rows;i++){
           if(j==0){
               sparse[i][j]=arr[i];
           }else{
               if(i+(1<<(j-1))<arr.size()){
                   sparse[i][j]=min(sparse[i][j-1],sparse[i+(1<<(j-1))][j-1]);
               }
           }
         }
     }

}
int query(int l,int r){
    int n=r-l+1;
    int log=logs[n];
    int segment=1<<(log);
    return min(sparse[l][log],sparse[r-segment+1][log]);

}
int main(int argc,char** argv){
    vector<int> arr{2,4,-1,6,8,-4,7,12,5,4,-9,2,20,-16,4,11};
    build(arr);
    cout<<query(3,12)<<endl;
    cout<<query(0,15)<<endl;
    cout<<query(4,4)<<endl;
    cout<<query(6,12)<<endl;
}
