#include<iostream>

using namespace std;

int getlog(int n){
    int x=0;
    while((1<<x)<=n)
        x++;
        return x-1;
    
}
class lst{
    int* oa;
    int oas;
    int* sa;
    int* la;
    int sas;
    


    public:
    lst(int* arr,int n){
      this->oa=oa;
      this->oas=n;
       int h=getlog(oas)+1;
            this->sas=(1<<h)-1;
            this->sa=new int[sas];
            this->la=new int[sas];
            
            build(0,oas-1,0);
       
    }
    void build(int ss,int se,int si){
        if(ss==se){
            sa[si]=oa[ss];
            la[si]=0;
            return;
        }
        int mid=(ss+se)/2;
        build(ss,mid,2*si+1);
        build(mid+1,se,2*si+2);
        //sa[si]=sa[2*si+1]+sa[2*si+2];
        sa[si]=opr->operation(sa[2*si+1],sa[2*si+2]);
    }

    void update(int idx,int nv,int ss,int se,int si){
        int mid=(ss+se)/2;
        if(ss==se && idx==se){
           // sa[si]+=delta;
           sa[si]=nv;
            return;
        }
        if(idx<=mid){
            update(idx,nv,ss,mid,2*si+1);
        }else{
            update(idx,nv,mid+1,se,2*si+2);
       
        }
       // sa[si]=sa[2*si+1]+sa[2*si+2];
            sa[si]=opr->operation(sa[2*si+1],sa[2*si+2]);
   
    }
    int query(int qs,int qe,int ss,int se,int si){
        if(ss>=qs && se<=qe){
            return sa[si];
        }else if(se<qs || ss>qe){
            return opr->identity();
        }else{
            int mid=(ss+se)/2;
            int lc=query(qs,qe,ss,mid,2*si+1);
            int rc=query(qs,qe,mid+1,se,2*si+2);
            return opr->operation(lc,rc);
            
        }
       
    }
}