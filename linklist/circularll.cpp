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
void insertbeg(Node*& start,int data){
    if(start==NULL){
        Node* nn=new Node(data,NULL);
        nn->next=nn;
        start=nn;
    }else if(start->next==NULL){
        Node* nn=new Node(data,NULL);
        nn->next=start;
        start->next=nn;
        start=nn;
        }
    else{ 
        Node* nn=new Node(data,NULL);   
         Node* ptr=start->next;
        while(ptr->next!=start){
      ptr=ptr->next;
    }
    ptr->next=nn;
    nn->next=start;
    start=nn;
    }
}

void insertend(Node*& start,int data){
   if(start==NULL){
       Node* nn=new Node(data,NULL);
       nn->next=nn;
        start=nn;
    }else if(start->next==start){
        Node* nn=new Node(data,NULL);
        nn->next=start;
        start->next=nn;
    }else{
    Node* ptr=start;
    Node* nn=new Node(data,NULL);
    while(ptr->next!=start){
      ptr=ptr->next;
    }
    ptr->next=nn;
    nn->next=start;
    }
}

int getsize(Node* start){
    int size=1;
    if(start->next==start){
        return size;
    }else{
        for(Node* i=start->next;i!=start;i=i->next){
            size++;
        }
    }
    return size;
}

void insertspecific(Node* start,int idx,int val){
    if(idx<0 || idx>=getsize(start)){
     cout<<"Invalid Index"<<endl;
    }else if(idx==0){
        insertbeg(start,val);
    }else if(idx==getsize(start)-1){
        insertend(start,val);
    }else{
         int j=0;
    for(Node* i=start;;i=i->next){
       if(j==idx-1){
        Node* nn=new Node(val,i->next);
        i->next=nn;
        return;
       }
       j++;
    }
    }
}

void deletebeg(Node*& start){
    if(start==NULL){
        
    }else if(start->next==start){
        Node* temp=start;
        start=NULL;
        delete temp;
    }else if(start->next->next==start){
        Node* temp=start;
        start=start->next;
        start->next=start;
        delete temp;
    }else{
    Node* ptr=start;
    Node* temp=start;
    while(ptr->next!=start){
      ptr=ptr->next;
    }
    start=ptr->next->next;
    ptr->next=temp->next;
    delete temp;
}}

void deleteend(Node*& start){
    if(start==NULL){
        
    }else if(start->next==start){
        Node* temp=start;
        start=NULL;
        delete temp;
    }else if(start->next->next==start){
        Node* temp=start->next;
        start->next=start;
        delete temp;
    }else{
    Node* ptr=start;
    while(ptr->next->next!=start){
      ptr=ptr->next;
    }
    Node* temp=ptr->next;
    ptr->next=start;
    delete ptr->next;
}}

void deletespecific(Node*& start,int index){
    if(index<=0 ||index>=(getsize(start)-1)){
        cout<<"Invalid Index"<<endl;
        return;
    }else{
int j=0;
for(Node* i=start;;i=i->next){
    if(j==index-1){
      i->next=i->next->next;
      return;
    }
    j++;
}
    }}

void display(Node* start){
    if(start==NULL){
        cout<<"Empty Linked list"<<endl;
    }else if(start->next==start){
        cout<<start->data<<endl;
    }else{ 
        Node* i=start;
    while( i->next!=start){
        cout<<i->data<<" ";
         i=i->next;
    }
    cout<<i->data<<" ";
    cout<<endl;
    }
}
int main(int argc,char** argv){
Node* start=NULL;
insertbeg(start,20);
insertbeg(start,10);
display(start);
insertend(start,30);
insertend(start,40);
display(start);
insertspecific(start,2,50);
insertspecific(start,3,60);
display(start);
deletebeg(start);
display(start);
deleteend(start);
display(start);
deletespecific(start,2);
display(start);
}

