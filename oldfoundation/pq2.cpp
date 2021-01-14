#include<iostream>
#include<vector>
#include<queue>

#include<String>
#include<iterator>
using namespace std;
template<class T>
class pq2{
    private:
    vector<int>list;
    bool type;
    bool(* comptor)(const T&o1,const T& o2);
    pq(* comptor)(const T&o1,const T& o2);
     
     void swap(int i,int j){
        int ith=list[i];
        int jth=list[j];
        list[i]=jth;
        list[j]=ith;
    }
     bool ishp(int i,int j){
        if(this->type==true){
            return list[i]<list[j];
        }else{
           return list[i]>list[j]; 
        }
    }
    void upheapify(int i){
        if(i==0){
            return ;
        }
        int pi=(i-1)/2;
        if(ishp(i,pi)==true){
            swap(i,pi);
            upheapify(pi);
        }
    } 
    void downheapify(int i){
        int li=2*i+1;
        int ri=2*i+2;
        int hpi=i;
        if(li<list.size() && ishp(li,hpi)==true ){
            hpi=li;
        }
        if(ri<list.size() && ishp(ri,hpi)==true ){
            hpi=ri;
        }
        if(hpi!=i){
            swap(i,hpi);
            downheapify(hpi);
        }
    } 
     
   
    public:
    pq(bool type){
        this->type=type;
    }
     void push(int val){
     list.push_back(val);
     upheapify(list.size()-1);

    }
    void pop(){
        swap(0,list.size()-1);
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
int main(int argc,char** argv){
    pq q(true);
    q.push(7);
    q.push(10);
    q.push(20);
    q.push(30);
    q.push(5);
    while(q.size()>0){
        int val=q.top();q.pop();
        cout<<val<<endl;

    }



}
