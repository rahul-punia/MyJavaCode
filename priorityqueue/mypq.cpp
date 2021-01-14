#include<iostream>
#include<vector>
using namespace std;

class mypq{
    private:
    vector<int> list;  //work as array in cpp
    bool minormax;
    void upheapify(int idx){
       if(idx==0){
       return;
       }
       int pi=(idx-1)/2;
       if(isHigherpriority(idx,pi)){
           swap(list[pi],list[idx]);
           upheapify(pi);
       }
     
    }
    void downheapify(int idx){
     int lci=2*idx+1;
     int rci=lci+1;
     int hpi=idx;    //let high priority index be idx
     if(lci<list.size() && isHigherpriority(lci,hpi)==true){  //compare hpi(not idx) with lci 
         hpi=lci;
     }
      if(rci<list.size() && isHigherpriority(rci,hpi)){       //compare hpi(not idx) with rci 
         hpi=rci;
     }
     if(hpi!=idx){
         swap(list[hpi],list[idx]);
         downheapify(hpi);
     }
    }
    bool isHigherpriority(int i,int j){
        if(minormax==true){  //minpq
       return list[i]<list[j];
        }else{
        return list[i]>list[j];
        }
    
    }
    
    public:
    mypq(bool minormax){       //constructor to set min or max priorityqueue
        this->minormax=minormax;
    }
    mypq(bool minormax,vector<int>& data){
        this->minormax=minormax;

        for(int i=0;i<data.size();i++){
            list.push_back(data[i]);
        }
        for(int i=list.size()/2-1;i>=0;i--){
            downheapify(i);
        }
    }
    void push(int val){
     list.push_back(val);
      upheapify(list.size()-1);
    }
    void pop(){
       swap(list[0],list[list.size()-1]);
       list.pop_back();
       downheapify(0);
    }
    int top(){
    return list[0];
    }
    int size(){
        return list.size();
    }  
};
int main(){
    vector<int> data{10,50,40,70,90,80,30};
    mypq pq(true,data);
    // pq.push(10);
    // pq.push(50);
    // pq.push(40);
    // pq.push(70);
    // pq.push(90);
    // pq.push(80);
    // pq.push(30);
    while(pq.size()>0){
        cout<<pq.top()<<" ";
        pq.pop();
    }
}