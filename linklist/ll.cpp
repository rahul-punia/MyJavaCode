#include<iostream>

using namespace std;
class Node{
    public :
     int data;
     Node* next;

     Node(){     //default constructor
         this->data=0;
         this->next=NULL;
     }
     Node(int data,Node* next){     //parameterize constructor
         this->data=data;
         this->next=next;
     }

};
void display(Node* head){     //only pass pointer b/z here value donot change
    for(Node* i=head;i!=NULL;i=i->next){
        cout<<i->data<<" ";
    }
    cout<<endl;
}
void addfirst(Node*& head,Node*& tail,int data){
   if(head==NULL){
    head=tail=new Node(data,NULL);   
   }else{
        Node* nn=new Node(data,head);   //new node k next previous head hoga
        head=nn;                        //and new head point new node
   }
}

void addlast(Node*& head,Node*& tail,int data){  //pass pointer by refrence b/z value of head & tail changes
    if(head==NULL){
        head=tail=new Node(data,NULL);
    }else{
      Node* nn=new Node(data,NULL);   //new node k next addlast always null hoga
      tail->next=nn;    //old tail k next ma new node k address store hoga
      tail=nn;          //and new tail point new node
    }

}


void addAt(Node* head,Node* tail,int idx,int data){
    if(head==NULL){
        return ;
    }else{
         int j=0;      //j used to know node idx
    for(Node* i=head;i!=NULL;i=i->next){ //if(j>length of ll) then loop break b/z element donot present 
        if(j==idx-1){                      //so to detect this we use i loop 
            Node* nn=new Node(data,i->next);
            i->next=nn;
            return;
        }
        j++;
    }
    }
    
}
int getfirst(Node* head){
    if(head==NULL){
        return 0;
    }
    return head->data;
}


int getlast(Node* tail){
    if(tail==NULL){
        return 0;
    }
    return tail->data;
}
int getat(Node* head,int idx){
    if(head==NULL){
    return 0;
    }
    int j=0;      //j used to know node idx
    for(Node* i=head;i!=NULL;i=i->next){ //if(j>length of ll) then loop break b/z element donot present 
        if(j==idx){                      //so to detect this we use i loop 
            return i->data;
        }
        j++;
    }
    return 0;
}
Node* getNodeAt(Node* head,int idx){
     if(head==NULL){
      return NULL;
    }
    int j=0;
    for(Node* i=head;i!=NULL;i=i->next){
        if(j==idx){
            return i;
        }
        j++;
    }
    return NULL;
}
 

// void removefirst(Node*& head,Node*& tail){
//   if(head==NULL){
//       return;
//   }
//    Node* temp=head->next;
//   head->next=NULL;
//   head=temp;

// }

// void removelast(Node*& head,Node*& tail){
//   if(head==NULL){
//       return;
//   }
//   head=head->next;  
// }

// void removeat(Node* head,Node* tail,int idx,int data){
    
// }
int getSize(Node* head){
    int counter=0;
    Node* temp=head;

    while(temp!=NULL){
        temp=temp->next;
        counter++;
    }
    return counter;
}

   void ADDat(Node*& head,Node*& tail,int data,int idx){
       int sz=getSize(head);

       if(idx<0 || idx>sz){       //<0,>5
           cout<<"Invalid index"<<endl;
       }else if(idx==0){             //==0
           addfirst(head,tail,data);
       }else if(idx==sz){           //==5
           addlast(head,tail,data);
       }else{
           Node* nm1=getNodeAt(head,idx-1);  //1-4
           nm1->next=new Node(data,nm1->next);
       }
   }
   void Removefirst(Node*& head,Node*& tail){
      // int sz=getSize(head);

       if(head==NULL){

       }else if(head->next==NULL){
           Node* temp=head;
           head=tail=NULL;
           delete temp;    //to avoid memory leak
       }else{
           Node* temp=head;
           head=head->next;
           delete temp;
       }
   }

   void Removelast(Node*& head,Node*& tail){
     
       if(head==NULL){

       }else if(head->next==NULL){
           Node* temp=head;
           head=tail=NULL;
           delete temp;
       }else{
           int sz=getSize(head);
           Node* sl=getNodeAt(head,sz-2);
           sl->next=NULL;
           delete tail;
           tail=sl;
       }
   }
   void Removeat(Node*& head,Node*& tail,int idx){  //idx=position
       int sz=getSize(head);

       if(idx<0 || idx>=sz){
           cout<<"Invalid index"<<endl;
       }else if(idx==1){
           Removefirst(head,tail);
       }else if(idx==sz-1){
           Removelast(head,tail);
       }else{
           Node* m1=head;
           m1=getNodeAt(head,idx-1);
           Node* n=m1->next;
           Node* p1=n->next;
           delete n;
       }
   }
   void reverseDI(Node* head,Node* tail){
      int sz=getSize(head);
      int le=0;
      int ri=sz-1;

      while(le<ri){

          Node* n1=getNodeAt(head,le);
          Node* n2=getNodeAt(head,ri);
          int temp=n1->data;
          n1->data=n2->data;
          n2->data=temp;
          le++;
          ri--;
      } 
   }
   
   void reversePI(Node*& head,Node*& tail){  //v.important
     Node* prev=NULL;
     Node* curr=head;
     while(curr!=NULL){
        Node* temp=curr->next;
        curr->next=prev;
     
         prev=curr;
         curr=temp;
     }
     Node* temp=head;       //set head & tail
     head=tail;
     tail=temp;
     
   }
   void DisplayReverseRecursively(Node* head){
       if(head==NULL){
        return;
       }
       DisplayReverseRecursively(head->next);
       cout<<head->data<<" ";
   }

   void ReversePointerRecursively(Node*& head,Node*& tail,Node* temp,Node* prev,Node* curr){
    if(curr==NULL){
     Node* temp=head;
     head=tail;
     tail=temp;
     return;
    } 
    
         curr->next=prev;
         cout<<prev<<endl;
       ReversePointerRecursively(head,tail,temp->next,curr,temp); 
    
   }

   void reverseDataRecursive(Node*& left,Node* right,int floor,int& size){
       if(right==NULL){     //left pass by refrence       //size pass by refrence but floor pass by value
           return;
       }

       size++;
       reverseDataRecursive(left,right->next,floor+1,size);
       if(floor>=size/2){
           int temp=right->data;
          right->data=left->data;
          left->data=temp;
          left=left->next; // important
       }
   }
   
   bool ispalindrome(Node*& left,Node* right,int floor,int& size){
      if(right==NULL){
           return true;
       }

       size++;
       bool res=ispalindrome(left,right->next,floor+1,size);
       
       if(res==false){
           return false;
       } else{
       if(floor>=size/2){
           if(left->data!=right->data){
               return false;
           }
            left=left->next;
       }
       }
       return true;
   }

   int midNode(Node* head){
       Node* slow=head;
       Node* fast=head;

       while(fast->next!=NULL && fast->next->next!=NULL){
           slow=slow->next;
           fast=fast->next->next;
       }
       return slow->data;
   }

   void fold(Node*& left,Node* right,int floor,int& size,Node*& tail){
        if(right==NULL){
           return;
       }

       size++;
       fold(left,right->next,floor+1,size,tail);

       if(floor>size/2){
           Node* temp=left->next;
           left->next=right;
           right->next=temp;
           left=temp;
           }else if(floor==size/2){
               tail=right;
               tail->next=NULL;
           }
   }


   int klast(Node* head,int k){
       Node* slow=head;
       Node* fast=head;
       slow=slow->next;
      for(int i=1;i<=k;i++){
          fast=fast->next; 
          }
       while(fast->next!=NULL){
           slow=slow->next;
            fast=fast->next;
       }
       return slow->data;
   }

   Node* kreversehelper(Node* th,int k){
       Node* prev=NULL;
       Node* curr=th;

    for(int i=0;i<k;i++){
           Node* next=curr->next;
           curr->next=prev;
           prev=curr;
           curr=next;
       }
       th->next=curr;  //v.v.imp
       return prev;
   }

   void kreverse(Node*& head,Node*& tail,int k){
       int sz=getSize(head);

       if(sz<k){
           return;
       }
       int counter=0;

       Node* t1=head;          
       Node* t2=kreversehelper(t1,k);
       head=t2;                               //first set new head
       counter+=k;

       while(sz-counter>=k){
          Node* nt1=t1->next;
          Node* nt2=kreversehelper(nt1,k);
          t1->next=nt2;
          t1=nt1;
          counter+=k;
       }
       if(counter==sz){
           tail=t1;
       }

   }


   void kreverse2(Node*& head,Node*& tail,int k){
       int sz=getSize(head);
       if(sz<k){return;
       }

       Node* phead=NULL;    Node* ptail=NULL;
       Node* chead=NULL;    Node* ctail=NULL;
       
    for(int i=0;i<k;i++){
       int temp=head->data;
       Removefirst(head,tail);
       addfirst(chead,ctail,temp);
       phead=chead;
       ptail=ctail;
       sz--;
       }
     while(head!=NULL && sz>=k){
      chead=NULL;
      ctail=NULL;
      for(int i=0;i<k;i++){
       int temp=head->data;
       Removefirst(head,tail);
       addfirst(chead,ctail,temp);
       sz--;
       }
    ptail->next=chead;
    ptail=ctail;
    }
    if(sz==0){
        head=phead;
        tail=ctail;
    }else{
        ptail->next=head;
        head=phead;
      }
   }

   void segregateoddeven(Node*& head,Node*& tail){
    
    Node* ohead=NULL;
    Node* otail=NULL;
    Node* ehead=NULL;
    Node* etail=NULL;

    while(head!=NULL){
        int temp=head->data;

        Removefirst(head,tail);

        if(temp%2==0){
            addlast(ehead,etail,temp);
        }else{
            addlast(ohead,otail,temp);
        }
    }
    if(otail!=NULL && ehead!=NULL){ //contain odd and even both
        otail->next=ehead;
        head=ohead;
        tail=etail;
    }else if(otail!=NULL){   //contain odd only
         head=ohead;
         tail=otail;
    }else if(etail!=NULL){   //contain even only
      head=ehead;
      tail=etail;
    }
     }

   void removeduplicate(Node*& head,Node*& tail){
     Node* nh=NULL;
     Node* nt=NULL;

     while(head!=NULL){
         int temp=head->data;
         Removefirst(head,tail);
        if(nh==NULL || nt->data!=temp){
          addlast(nh,nt,temp);
        }
        }
        head=nh;
        tail=nt;
    }

   void detectandremoveCycle(Node* head){
      Node* slow=head;
      Node* fast=head;

      while(fast!=NULL && fast->next!=NULL){
          slow=slow->next;
          fast=fast->next->next;

          if(slow==fast){
              cout<<"Loop found"<<endl;
              if(slow==head){                  //only odd,even size circlular cycle present no straight line
                  while (slow->next!=head){
                      slow=slow->next;
                  }
              }else{
                  fast=head;                   //reset fast after meeting
                  while(slow->next!=fast->next){
                      slow=slow->next;
                      fast=fast->next;  //imp remember
                  }
              }
               slow->next=NULL;     //remove cycle
                  display(head);
                  break;
          }
      }
   }

   void mergetwosortlist(Node* h1,Node* h2,Node*& oh,Node*& ot){
    
    Node* t1=h1;
    Node* t2=h2;

    while(t1!=NULL && t2!=NULL){
        if(t1->data<t2->data){
            addlast(oh,ot,t1->data);
            t1=t1->next;
        }else{
          addlast(oh,ot,t2->data);
            t2=t2->next;   //removefirst
        }
    }

    while ((t1!=NULL)){
        addlast(oh,ot,t1->data);
            t1=t1->next;
    }
    while (t2!=NULL){
        addlast(oh,ot,t2->data);
            t2=t2->next;
    }
    
   }
   int findIntersectionPoint(Node* head1,Node* head2,Node* t1){

       int sz1=getSize(head1);
       int sz2=getSize(head2);
       int gap=abs(sz1-sz2);

       if(sz1>sz2){
       for(int i=1;i<=gap;i++){
           head1=head1->next;
       }
       }else if(sz1<sz2){
       for(int i=1;i<=gap;i++){
           head2=head2->next;
       }
       }

       while(head1!=head2){
           head1=head1->next;
           head2=head2->next;
       }
     return head1->data;   //or head2->data;
   }

   
 
// static int ct=0; 
// static Node* le=NULL;
// void reverseDataRecursively(int floor,Node* ri,Node* head){
//   if(ri==NULL){
//       le=head;
//       return;
//   }
//   reverseDataRecursively(floor,ri->next,head);  

//       if(ct<floor){
//           int temp=ri->data;
//           ri->data=le->data;
//           le->data=temp;
//           le=le->next;
//           ct++;
//          }

// }
// Node* kreverseh(Node* th,int k){
//     Node* prev=th;
//     Node* curr=th;

//     for(int i=0;i<k;i++){

//     }
// }
// void kreverse1(Node* head,Node* tail,int k){
//     int sz=getSize(head);
//     int ct=0;
    
//     Node* t1=head;
//     Node* t2=kreverseh(t1,k);
//     head=t2;
//     ct+=k;
//     while(sz-ct>=k){
//         Node* nt1=t1->next;
//         Node* nt2=krevrerseh(nt1,k);
//         t1->next=nt2;
//        t1=nt1;
//        ct+=k;
//     }
// }
Node* midNode(Node* head,Node* tail){
       Node* slow=head;
       Node* fast=head;

       while(fast!=tail && fast->next!=tail){
           slow=slow->next;
           fast=fast->next->next;
       }
       
       return slow;
   }

   void mergersort(Node*& head,Node*& tail){
       if(head==tail){
           Node* nn=new Node(head->data,NULL);
           head=tail=nn;
           return;
       }
       Node* mid=midNode(head,tail);
       Node* lh=head;
       Node* lt=mid;
       Node* rh=mid->next;
       Node* rt=tail;
       
       mergersort(lh,lt);
       mergersort(rh,rt);
       Node* fh=NULL;  //fullhead
       Node* ft=NULL;  //fulltail
       mergetwosortlist(lh,rh,fh,ft);
       head=fh;
       tail=ft;
   }

   void imergetwosortlist(Node* lh,Node* lt,Node* rh,Node* rt,Node*& oh,Node*& ot){
       Node* t1=lh;
       Node* t2=rh;

       while(t1!=NULL && t2!=NULL){
           Node* rem=NULL;     //remove node
           if(t1->data<t2->data){
               rem=t1;
               t1=t1->next;
               rem->next=NULL;
            if(oh==NULL){
                oh=ot=rem;
            }else{
               ot->next=rem;
               ot=rem;
            }
           }else{
               rem=t2;
               t2=t2->next;
               rem->next=NULL;
              if(oh==NULL){
                oh=ot=rem;
            }else{
                ot->next=rem;
                ot=rem;
            }  
           }
       }
       if(t1!=NULL){
           ot->next=t1;
           ot=lt;
       }else{
           ot->next=t2;
           ot=rt;
       }
   }

   void imergersort(Node*& head,Node*& tail){
       if(head==tail){
           return;
       }
       Node* mid=midNode(head,tail);
       Node* lh=head;
       Node* lt=mid;
       Node* rh=mid->next;
       Node* rt=tail;
       mid->next=NULL;
       
       mergersort(lh,lt);
       mergersort(rh,rt);
       Node* fh=NULL;  //fullhead
       Node* ft=NULL;  //fulltail
       imergetwosortlist(lh,lt,rh,rt,fh,ft);
       head=fh;
       tail=ft;
   }
   

int main(int argc,char** argv){
    Node* head=NULL;
    Node* tail=NULL;
    ADDat(head,tail,100,0);
    Removefirst(head,tail);
    addfirst(head,tail,1);
    addlast(head,tail,9);
    //addlast(head,tail,20);
    addlast(head,tail,7);
    addlast(head,tail,15);
    addlast(head,tail,8);
    addlast(head,tail,60);
    addlast(head,tail,90);
    display(head);
    // ADDat(head,tail,200,3);
    // ADDat(head,tail,900,4);
    // Removefirst(head,tail);
    // Removelast(head,tail);
    // Removeat(head,tail,3);
  // reverseDI(head,tail);
  reversePI(head,tail);
  display(head);
  //DisplayReverseRecursively(head);
//    Node* prev=NULL;
//    Node* curr=head;
//    ReversePointerRecursively(head,tail,curr->next,prev,curr);
     Node* left=head;
     Node* right=head;
     int floor=0;
     int size=0;
     //reverseDataRecursive(left,right,floor,size);
 // int floor=getSize(head)/2;
  
 // reverseDataRecursively(floor,head,head);
//  display(head);
 //removeduplicate(head,tail);
//  addlast(head,tail,32);
  
 // cout<<ispalindrome(left,right,floor,size)<<endl;
  fold(left,right,floor,size,tail);
  display(head);
 // addlast(head,tail,50);
 // cout<<midNode(head)<<endl;
  //kreverse(head,tail,2);
 // kreverse2(head,tail,3);
  //segregateoddeven(head,tail);
   //addlast(head,tail,45);
   Node* sh=head;
   Node* st=tail;
   //mergersort(sh,st);
   imergersort(sh,st);
   display(sh);
   display(head);
   Removelast(sh,st);
   display(sh);
   display(head);
 // cout<<klast(head,5)<<endl;
 //addlast(head,tail,80);
 //segregateoddeven(head,tail);
   //tail->next=getNodeAt(head,3);
  //detectandremoveCycle(head);
//   Node* oh=NULL;
//   Node* ot=NULL;
//   Node* h2=NULL;
//   Node* t2=NULL;
//   addlast(h2,t2,9);
//   addlast(h2,t2,9);
//   addlast(h2,t2,9);
//   addlast(h2,t2,9);
//   mergesort(head,h2,oh,ot);
 // display(oh);
  //  addfirst(head,tail,5);
   // addAt(head,tail,4,40);
  //  removefirst(head,tail);
  
   // display(head);
    // cout<<getfirst(head)<<endl;
    // cout<<getlast(tail)<<endl;
    // cout<<getat(head,3)<<endl;
    // cout<<getNodeAt(head,3)<<endl;
}