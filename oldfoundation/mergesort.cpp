#include<iostream>
#include<vector>
using namespace std;
class Interval{
    public:
    int start;
    int end;
    Interval(int start,int end){
        this->start=start;
        this->end=end;
    }
    bool operator<(const Interval& o)const{
        return this->start<o.start;
    }
};
void overlapping(vector<int>& starts,vector<int>& ends){
    vector<Interval> intvs;
    for(int i=0;i<starts.size();i++){
       Interval intv(starts[i],ends[i]);
       intvs.push_back(intv);
    }
    sort(intvs.begin(),intvs.end());
    for(int j=0;j<intvs.size();j++){
     // cout<<intvs.start<<" "<<intvs.end<<endl;
    }
}




//Merge sort
void mergetwosortarray(int* arr,int lo,int mid,int hi){
    int* aux=new int[hi-lo+1]; //make a auxiliary array
    //int mid=(lo+hi)/2;
    int i=lo;
    int j=mid+1;
    int k=0;

    while(i<=mid && j<=hi){
        if(arr[i]<arr[j]){
            aux[k++]=arr[i++];         // aux[k]=arr[i];i++;;k++
        }else if(arr[i]>arr[j]){
            aux[k++]=arr[j++];  
          //  ct++;     // aux[k]=arr[j];j++;;k++
        }
    }
     while(i<=mid){            
         aux[k++]=arr[i++];       // aux[k]=arr[i];i++;;k++
     }
     while(j<=hi){
         aux[k++]=arr[j++];      // aux[k]=arr[j];j++;;k++
     }

     for(i=0;i<hi-lo+1;i++){  //Important
         arr[lo+i]=aux[i];
     }

}

void mergesort(int* arr,int lo,int hi){
    if(lo==hi){          //base case
        return;
    }
    int mid=(lo+hi)/2;
    mergesort(arr,lo,mid);
    mergesort(arr,mid+1,hi);

    mergetwosortarray(arr,lo,mid,hi);
}
int main(int argc,char** argv){
    vector<int> starts={22,11,19,2,6,12,3};
   vector<int> ends={26,20,23,4,9,15,7};
   overlapping(starts,ends);

    //Merge Sort
    int* arr=new int[8]{4,5,3,2,8,7,9,1};
    mergesort(arr,0,7);
    for(int i=0;i<8;i++){
        cout<<arr[i]<<endl;
    }
}