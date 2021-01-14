#include<iostream>
#include<vector>
#include<queue>

using namespace std;
class Event{
    public:
    int s;
    int e;

    bool operator<(const Event& other)const{
        return this->s<other.e;
    }
};
void demo3(){
    priority_queue<Event,vector<Event>,greater<Event>> pq;
    Event e1;
    e1.s=1000;
    e1.e=1020;
    pq.push(e1);

    Event e2;
    e2.s=1010;
    e2.e=1050;
    pq.push(e2);

    Event e3;
    e3.s=1020;
    e3.e=1060;
    pq.push(e3);

    Event e4;
    e4.s=1030;
    e4.e=1120;
    pq.push(e4);

    Event e5;
    e5.s=1045;
    e5.e=1055;
    pq.push(e5);

    while(pq.size()>0){
        Event e=pq.top();
        pq.pop();
         e1.operator<(e2);
        cout<<e.s<<" "<<e.e<<endl;
    }
}
void demo1(){
 //priority_queue<int>pq;
  priority_queue<int,vector<int>,less<int>>pq;
    pq.push(10);
    pq.push(20);
    pq.push(50);
    pq.push(40);
    pq.push(30);

    while(pq.size()>0){
        int val=pq.top();
        pq.pop();
        cout<<val<<endl;
    }

}
void demo2(){
  priority_queue<int,vector<int>,greater<int>>pq;
    pq.push(10);
    pq.push(20);
    pq.push(50);
    pq.push(40);
    pq.push(30);

    while(pq.size()>0){
        int val=pq.top();
        pq.pop();
        cout<<val<<endl;
    }

}
int main(int argc,char** argv){
   demo3();
  
}