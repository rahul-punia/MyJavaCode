#include<iostream>

using namespace std;

class Node{
  public:
  int data;
  Node* next;
  Node(){
   this->data=0;
         this->next=NULL;
  }
  Node(int data,Node* next){
      this->data=data;
      this->next=next;
  }
};
void addlast(Node*& head,int data){
    if(head==NULL){
       Node* nn=new Node(data,NULL);
       head=nn;
    }else{
         Node* nn=new Node(data,NULL);
         while(head->next!=NULL){
             head=head->next;
         }
         head->next=nn;
    }
}
void display(Node* head){

    for(Node* n=head;n!=NULL;n=n->next){
      cout<<n->data<<"->";
    }
    cout<<endl;
}

void reverse(Node*& head){
     Node* start=head;
     Node* temp=NULL;
    while(start!=NULL){
       if(start==head){
           temp=start;
            start->next=NULL;
           start=temp->next;
       }else{
            start->next=temp;
            temp=start;
            start=temp->next;
       }
    }
    head=start;
}
void insertE(Node*& head,int data){
     if(head->next==NULL){
         Node* nn=new Node(data,NULL);
         head->next=nn;
         return ;
     }
     insertE(head->next,data);
}

void deleteE(Node*& head){
     if(head->next->next==NULL){
         head->next=NULL;
         return ;
     }else if(head->next==NULL){
        head->next=NULL;
        return;
     }
     deleteE(head->next);
}

void midDelete(Node*& prev,Node*& curr,int data){
   if(curr->data==data){
    prev->next=curr->next;
    delete(curr);
    return;
   }
   midDelete(curr,curr->next,data);
}
int getsize(Node* head){
    int counter=0;
    while(head!=NULL){
        counter++;
        head=head->next;
        }
        return counter;
}
void midInsert(Node*& head,int data){
    int sz=getsize(head);
    

    for(int i=1;i<sz/2;i++){
     head=head->next;

    }
    Node* temp=head->next;
    Node* nn=new Node(data,NULL);
    head->next=nn;
    nn->next=temp;
}
int main(int argc,char** argv){
 Node* head=NULL;
 addlast(head,10);
 addlast(head,20);
 addlast(head,30);
 addlast(head,40);
 addlast(head,50);
 display(head);
 
}