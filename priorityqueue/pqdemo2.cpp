#include<iostream>
#include<queue>
using namespace std;

class mycl{
    public:
   int li;
   int di;
   int val;

  mycl(){}
   mycl(int li,int di,int val){
       this->li=li;
       this->di=di;
       this->val=val;
   }
   bool operator>(const mycl& other) const{
     return this->val>other.val;
   }
   
};

void mergeKsortedLists(vector<vector<int>>& lists){
    priority_queue<mycl,vector<mycl>,greater<mycl>> pq;
    for(int i=0;i<lists.size();i++){
        mycl mp(i,0,lists[i][0]);
        pq.push(mp);
    }  

    while(pq.size()>0){
        mycl tp=pq.top();pq.pop();
         
         cout<<tp.val<<" ";
         tp.di++;
         if(tp.di<lists[tp.li].size()){
             tp.val=lists[tp.li][tp.di];
             pq.push(tp);
         } 
    }
}
void almostSorted(vector<int>& list,int k){
    priority_queue<int,vector<int>,greater<int>> pq;
    for(int i=0;i<=k;i++){
        pq.push(list[i]);
    }

    for(int i=k+1;i<list.size();i++){
        cout<<pq.top()<<" ";
        pq.pop();
        pq.push(list[i]);
    }
    while(pq.size()>0){
        cout<<pq.top()<<" ";
        pq.pop();
    }

}
int main(){
    vector<vector<int>> lists{{2,9,19,25,35},
                              {1,5,7,2},
                              {6,14,49,54,66,77},
                              {4,12,20}};

    //  mergeKsortedLists(lists);                        
  vector<int> list{5,14,2,8,15,25,35,20,40,50,42};
  almostSorted(list,2);
}