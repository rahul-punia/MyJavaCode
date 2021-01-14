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
int getSize(Node* head){
    int counter=0;
    Node* temp=head;

    while(temp!=NULL){
        temp=temp->next;
        counter++;
    }
    return counter;
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
       }else if(idx==0){
           Removefirst(head,tail);
       }else if(idx==sz-1){
           Removelast(head,tail);
       }else{
             int j=0;      //j used to know node idx
    for(Node* i=head;i!=NULL;i=i->next){ //if(j>length of ll) then loop break b/z element donot present 
        if(j==idx-1){    
                              //so to detect this we use i loop 
            i->next=i->next->next;
            return;
        }
        j++;
    }
        
       }
   }

int main(int argc,char** argv){
    Node* head=NULL;
    Node* tail=NULL;
    addfirst(head,tail,2);
    addfirst(head,tail,1);
    display(head);
    addlast(head,tail,3);
    addlast(head,tail,4);
    display(head);
    addAt(head,tail,2,5);
    addAt(head,tail,1,6);
    display(head);
    Removefirst(head,tail);
    display(head);
    Removelast(head,tail);
    display(head);
    Removeat(head,tail,1);
    
    display(head);
    Removeat(head,tail,2);
    display(head);
}   