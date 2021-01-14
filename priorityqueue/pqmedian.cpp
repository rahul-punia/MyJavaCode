#include<iostream>
#include<queue>
using namespace std;

class medianpq{
    private:
    priority_queue<int> left;
    priority_queue<int ,vector<int>,greater<int>> right;
    void handle(){
        if(left.size()-right.size()==2){
         int val=left.top();
         left.pop();
         right.push(val);
        }else if(right.size()-left.size()==2){
           int val=right.top();
         right.pop();
         left.push(val); 
        }
    }
    public:
    void push(int val){
    
    if(left.size()>0 && val<left.top()){
        left.push(val);
    }else{
        right.push(val);
    }
    handle();
    }
    void pop(){
      if(left.size()>=right.size()){
          left.pop();
      }else{
          right.pop();
      }
    }
    int top(){
    if(left.size()>=right.size()){
         return left.top();
      }else{
        return right.top();
      }
    }
};
int main(){
    medianpq pq;
    pq.push(20);
    pq.push(5);
    pq.push(3);
    pq.push(17);
    pq.push(8);
    cout<<pq.top()<<endl;
    pq.push(9);
    pq.push(19);
    cout<<pq.top()<<endl;
    pq.push(11);
    cout<<pq.top()<<endl;
    pq.pop();
    pq.push(15);
    cout<<pq.top()<<endl;
    pq.pop();
    pq.push(77);
    pq.push(32);
    
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
    cout<<pq.top()<<endl;
    pq.pop();
}