#include<iostream>
#include<queue>
#include<vector>
using namespace std;

void demo1(){
    priority_queue<int,vector<int>,greater<int>> pq;
      pq.push(10);
      pq.push(20);
      pq.push(40);
      pq.push(30);

      while(pq.size()>0){
          int val=pq.top();
          cout<<val<<" ";
          pq.pop();
      }
}

void downheapify(vector<int>& pq,int idx,int ve){
     int lci=2*idx+1;
     int rci=lci+1;
     int hpi=idx;    //let high priority index be idx
     if(lci<=ve && pq[lci]>pq[hpi]){  //compare hpi(not idx) with lci 
         hpi=lci;
     }
      if(rci<=ve && pq[rci]>pq[hpi]){       //compare hpi(not idx) with rci 
         hpi=rci;
     }
     if(hpi!=idx){
         swap(pq[hpi],pq[idx]);
         downheapify(pq,hpi,ve);
     }
    }
    void heapsort(vector<int>& arr){
        for(int i=arr.size()/2-1;i>=0;i--){
            downheapify(arr,i,arr.size()-1);
        }
        for(int i=1;i<=arr.size()-1;i++){
            swap(arr[0],arr[arr.size()-i]);
            downheapify(arr,0,arr.size()-i-1);
        }
    }
void ksmallest(int k,vector<int>& nums){
priority_queue<int> maxpq;  
for(int i=0;i<k;i++){
    maxpq.push(nums[i]);
}
for(int i=k;i<nums.size();i++){
    if(nums[i]<maxpq.top()){
        maxpq.pop();
        maxpq.push(nums[i]);
    }
}
while(maxpq.size()>0){
          int val=maxpq.top();
          cout<<val<<" ";
          maxpq.pop();
      }
}
int main(int argc,char** argv){
   // demo1();
    cout<<endl;
    vector<int> nums{2,45,76,9,-1,0,3};
   // ksmallest(3,nums);
    heapsort(nums);
    for(int i=0;i<nums.size();i++){
        cout<<nums[i]<<" ";
    }
}