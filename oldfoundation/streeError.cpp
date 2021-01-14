#include<iostream>

using namespace std;

int getlog(int n){
    int x=0;
    while((1<<x)<=n)
        x++;
        return x-1;
    
}
class Ioperator{
private :
public :
virtual int operation(int lhs,int rhs)=0;
virtual int identity()=0;
};
class sumoperator:public Ioperator{
public:
int operation(int lhs,int rhs){
    return lhs+rhs;
}
int identity(){
    return 0;
}
};
class productoperator:public Ioperator{
public:
int operation(int lhs,int rhs){
    return lhs*rhs;
}
int identity(){
    return 1;
}
};
class maxoperator:public Ioperator{
public:
int operation(int lhs,int rhs){
    return max(lhs,rhs);
}
int identity(){
    return INT_MAX;
}
};
class minoperator:public Ioperator{
public:
int operation(int lhs,int rhs){
    return min(lhs,rhs);
}
int identity(){
    return INT_MIN;
}
};
class stree
{
    private:
    Ioperator* opr;
    int* oa;
    int oas;
    int* sa;
    int sas;
    


    public:
    void build(int ss,int se,int si){
        if(ss==se){
            sa[si]=oa[ss];
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
     stree(Ioperator* opr,int* oa,int oas){
           this->opr=opr; 
            this->oa=oa;
            this->oas=oas;
            int h=getlog(oas)+1;
            this->sas=(1<<h)-1;
            this->sa=new int[sas];
            build(0,oas-1,0);
        }

};
int main(int argc,char** argv){
    int* oa=new int[8]{2,5,3,6,7,14,1,9};
   // stree st(oa,8);
    stree* st=NULL;
    int choice;
    cin>>choice;
    if(choice==1){
        Ioperator* opr=new sumoperator();
        stree(opr,oa,8);
    }else if(choice==2){
        Ioperator* opr=new productoperator();
        stree(opr,oa,8);
    }else if(choice==3){
        Ioperator* opr=new maxoperator();
        stree(opr,oa,8);
    }else if(choice==4){
        Ioperator* opr=new minoperator();
        stree(opr,oa,8);
    }
    cout<<st->query(2,5,0,7,0)<<endl;
    cout<<st->query(5,7,0,7,0)<<endl;
    st->update(4,10,0,7,0);
    cout<<st->query(2,5,0,7,0)<<endl;
    cout<<st->query(5,7,0,7,0)<<endl;
    
}
