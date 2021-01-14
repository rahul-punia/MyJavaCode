#include<iostream>

using namespace std;

class Node{
public:
Node* next;
int data;
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
    Node* nn=new Node(data,NULL);
    if(head==NULL){
        head=nn;
        return;
    }
    auto i=head;
    while(i->next!=NULL){
        i=i->next;
    }
    i->next=nn;
}
void display(Node* head){
    for(auto i=head;i!=NULL;i=i->next){
        cout<<i->data<<"->";
    }
    cout<<endl;
}
int getSize(Node* head){
    int counter=0;
    Node* temp=head;

    while(temp!=NULL){
        temp=temp->next;
        counter++;
    }
    return counter;
}
Node* getnode(Node*& head,int idx){
    int size=-1;
    for(auto i=head;i!=NULL;i=i->next){
         size++;
         if(size==idx){
          return i;
      }
    }
    return NULL;
}
void reverseData(Node* head){
int size=getSize(head);
cout<<size<<endl;
int le=0;
int ri=size-1;
while(le<ri){
    Node* lenode=getnode(head,le);
    Node* rinode=getnode(head,ri);
    cout<<rinode->data<<endl;
    int temp=rinode->data;
    rinode->data=lenode->data;
    lenode->data=temp;
    le++;
    ri--;
}
}
void reversepointeriterative(Node*& head){
   Node* prev=NULL;
   Node* curr=head;
    while(curr->next!=NULL){
      Node* temp=curr->next;
      curr->next=prev;
      prev=curr;
      curr=temp;
    //   cout<<prev->data<<endl;
      if(curr->next==NULL){
          curr->next=prev;
          prev=curr;
          head=prev;
          return ;
      }
    //   delete temp;
     }
}



void displayreverserecursively(Node* head){
    if(head==NULL){
        return;
    }
    displayreverserecursively(head->next);
    cout<<head->data<<"->";
}
void reversepointerrecursive(Node*& head,Node* prev,Node* curr,Node* temp){
if(temp==NULL){
     curr->next=prev;
     prev=curr;
    head=prev;
    cout<<endl;
    display(prev);
    return ;
}
    //   temp=curr->next;
      curr->next=prev;
      cout<<curr->data;
    //   prev=curr;
    //   temp=curr;
      reversepointerrecursive(head,curr,temp,temp->next);
}

void reversedataRecursive(Node*& left,Node* right,int floor,int& size){
    if(right==NULL){
        return;
    }

    size++;
    reversedataRecursive(left,right->next,floor+1,size);
    if(floor>=size/2){
        int temp=right->data;
        right->data=left->data;
        left->data=temp;
        left=left->next;
    }
}

bool IsPalindrome(Node*& left,Node* right,int floor,int& size){
    if(right==NULL){
        return true;
    }

    size++;
    bool res=IsPalindrome(left,right->next,floor+1,size);
    if(res==false){
        return false;
    }else{
    if(floor>=size/2){
        if(right->data!=left->data){
            return false;
        }
        left=left->next;
    }
    }
    return true;
}

void fold(Node*& left,Node* right,int floor,int& size){
    if(right==NULL){
        return;
    }

    size++;
    fold(left,right->next,floor+1,size);
    if(floor>size/2){
        Node* temp=left->next;
        left->next=right;
        right->next=temp;
        left=temp;
    }else if(floor==size/2){
       right->next=NULL;
    }
}

int main(int argc,char** argv){
Node* head=NULL;
addlast(head,10);
addlast(head,20);
addlast(head,30);
addlast(head,40);
addlast(head,50);
addlast(head,60);
addlast(head,70);
display(head);
// displayreverserecursively(head);
// reversepointerrecursive(head,NULL,head,head->next);
// reverseData(head);
display(head);
// reversepointeriterative(head);
Node* left=head;
Node* right=head;
int size=0;
int floor=0;
// reversedataRecursive(left,right,floor,size);
fold(left,right,floor,size);
display(head);
// cout<<IsPalindrome(left,right,floor,size)<<endl;
}