#include<iostream>
#include<unordered_map>
#include<string>
#include<vector>
#include<queue>
#include<cmath>
using namespace std;

 class ListNode {
     public:
     int val;
      ListNode* next;
      ListNode(int val,ListNode* next) {this->val=val;
      this->next=next;}
  };
 

    int getsize(ListNode* head){
        int size=0;
        for(ListNode* i=head;i!=NULL;i=i->next){
            size++;
        }
        return size;
    }

    void addfirst(ListNode*& head,int val){
   if(head==NULL){
    head=new ListNode(val,NULL);   
   }else{
        ListNode* nn=new ListNode(val,head);   //new node k next previous head hoga
        head=nn;                        //and new head point new node
   }
}
    // ListNode* removeZeroSumSublists(ListNode* head) {
    //     // ListNode* ohead=NULL;
    //     int osize=0;
    //     do{
    //        osize=getsize(head);
    //     if(head->val+head->next->val==0){
    //         head=head->next->next;
    //     }
    //     ListNode *prev=head;
    //     ListNode *curr=NULL;
    //     if(head->next->next!=NULL){
    //     curr=head->next->next;
    //     }
        
    //     while(curr->next!=NULL){
    //         if((prev->next->val+curr->val)==0){
    //             if(curr->next!=NULL){
    //             prev->next=curr->next;
    //             curr=curr->next;
    //             if(curr->next!=NULL){
    //                 curr=curr->next;
    //             }
    //             }else{
    //                 prev->next=NULL;
    //             }
    //             continue;
    //         }
    //         cout<<"rahul"<<endl;
    //         prev=prev->next;
    //         curr=curr->next;
    //     }
    //      cout<<osize<<" "<<getsize(head)<<endl;   
    //     }while(osize!=getsize(head));
        
    //     return head;
    // }
     ListNode* removeZeroSumSublists(ListNode* head) {
        
        ListNode* root =new ListNode(0,head);
        // root->next=head;
        unordered_map<int,ListNode*>um;
        um[0]=root;
        int ac=0;
        queue<int> q;
        while(head!=NULL){
            ac+=head->val;
            
            //found value
            if(um.find(ac)!=um.end()){
                ListNode* prev= um[ac];
                ListNode* start= prev;
                // cout<<"ra-"<<ac<<endl;
                //delete bad references
                int aux = ac;
                while(prev!=head){
                    prev=prev->next;
                    aux+=prev->val;
                    if(prev!=head)um.erase(aux);
                }
                
                start->next = head->next;
            }else{
                um[ac]= head;
            }
            cout<<"rahul"<<endl;
            head=head->next;
        }
        
        return root->next;
    }
    
    int main(){
        ListNode* head=NULL;
        // addfirst(head,-2);
        // addfirst(head,-3);
        // addfirst(head,3);
        // addfirst(head,2);
        // addfirst(head,1);
        addfirst(head,-6);
        addfirst(head,5);
        addfirst(head,1);
        addfirst(head,1);
        addfirst(head,-6);
        addfirst(head,2);
        addfirst(head,4);
        addfirst(head,3);
        // cout<<getsize(head)<<endl;
        removeZeroSumSublists(head);
        // cout<<getsize(head)<<endl;
    }