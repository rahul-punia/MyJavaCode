#include<iostream>
#include<stack>
#include<cmath>
#include<vector>
// #include<string>
using namespace std;

bool hasDuplicateBrackets(string& exp){
     stack<char> st;
     for(int i=0;i<exp.size();i++){
         char ch=exp[i];
         if(ch==')'){
            if(st.top()=='('){
                return true;
            }else{
                while(st.top()!='('){
                    st.pop();
                }
                st.pop();//extra pop
            }
         }else{
             st.push(ch);
         }
     }
     return false;
}
bool isBalancedBracket(string& exp){
stack<char> st;
for(int i=0;i<exp.size();i++){
    char ch=exp[i];
    if(ch=='}' || ch==']' ||ch==')'){
      if(ch=='}'){
        while(st.top()!='{'){
            if(st.top()=='[' ||st.top()=='(' ){  //use this condition also--|| st.size()
                return false;
            }
            st.pop();
        }
        st.pop();
      }else if(ch==']'){
         while(st.top()!='['){
            if(st.top()=='{' ||st.top()=='('){
                return false;
            }
            st.pop();
        }
        st.pop();
      }else if(ch==')'){
       while(st.top()!='('){
            if(st.top()==']' ||st.top()=='{'){
                return false;
            }
            st.pop();
        }
        st.pop();
      }
    }else{
        st.push(ch);
    }
    }
    if(st.size()==0){
        return true;
    }else{
        return false;
    }
}
// bool isBalancedBracket2(string& exp){
// stack<char> st;
// for(int i=0;i<exp.size();i++){
//     char ch=exp[i];
//     if(ch=='{' || ch=='[' ||ch=='('){
//         st.push(ch);
//     }else{
//         if(ch=='}'){
//          if(st.size()==0 || st.top()!='{'){
//            return false;
//          }else{
//              st.pop();
//          }
//         }else if(ch==']'){
//          if(st.size()==0 || st.top()!='['){
//            return false;
//          }else{
//              st.pop();
//          }
//         }else if(ch==')'){
//          if(st.size()==0 || st.top()!='('){
//            return false;
//          }else{
//              st.pop();
//          }
//         }
//     }
// }
// if(st.size()!=0){
//     return false;
// }else{
//     return true;
// }
// }
void NextGreaterElement(vector<int>& arr){
    stack<int> st;
    stack<int> st2;
    st.push(arr[0]);
    for(int i=1;i<arr.size();i++){
        while(st.size()!=0 && st.top()<arr[i]){
            st.pop();
            st2.push(arr[i]);
           // cout<<arr[i]<<" ";
        }
        st.push(arr[i]);
    }
    while(st2.size()>0){
        int val=st2.top();
        st.pop();
        cout<<val<<" ";
    }
}
vector<int> NextGreaterElement1(vector<int>& arr){//LtoR
    stack<int> st;
    vector<int> res(arr.size());
    for(int i=0;i<arr.size();i++){
        while(st.size()>0 && arr[st.top()]<arr[i]){
         res[st.top()]=arr[i];//fill nge not idx but in sliding window fill idx
         st.pop();           //but stack in both is index stack
        }
        st.push(i);
    }
    while(st.size()>0){
        res[st.top()]=-1;
        st.pop();
    }
    return res;
}

vector<int> NextGreaterElement2(vector<int>& arr){
    stack<int> st;
    vector<int> res(arr.size());
    res[arr.size()-1]=-1;
    st.push(arr[arr.size()-1]);
    for(int i=arr.size()-2;i>=0;i--){
        while(st.size()>0 && arr[i]>st.top())
        st.pop();

        res[i]=st.size()==0?-1:st.top();
        st.push(arr[i]);
    }
    return res;
}

vector<int> NextsmallerElement1(vector<int>& arr){
    stack<int> st;
    vector<int> res(arr.size());
    for(int i=0;i<arr.size();i++){
        while(st.size()>0 && arr[st.top()]>arr[i]){
         res[st.top()]=arr[i];
         st.pop();
        }
        st.push(i);
    }
    while(st.size()>0){
        res[st.top()]=arr.size();
        st.pop();
    }
    return res;
}

vector<int> NextsmallerElement2(vector<int>& arr){
    stack<int> st;
    vector<int> res(arr.size());
    res[arr.size()-1]=arr.size();
    st.push(arr[arr.size()-1]);
    for(int i=arr.size()-2;i>=0;i--){
        while(st.size()>0 && arr[i]<st.top())
        st.pop();

        res[i]=st.size()==0?arr.size():st.top();
        st.push(arr[i]);
    }
    return res;
}
void largestAreaHistogram(vector<int>& ht){
    vector<int> rb=NextsmallerElement1(ht);
    vector<int> lb=NextsmallerElement2(ht);
    vector<int> width(ht.size());
    int maxarea=-1;
    for(int i=0;i<width.size();i++){
        width[i]=rb[i]-lb[i]-1;
        int area=width[i]*ht[i];
        if(area>maxarea){
            maxarea=area;
        }
    }
    cout<<maxarea<<endl;
}

vector<int> slidingWindowMax(vector<int>& arr,int k){
//NGE
stack<int> st;
vector<int>nge(arr.size());//make next greater element index array
for(int i=0;i<arr.size();i++){
  while(st.size()>0 && arr[st.top()]<arr[i]){
      nge[st.top()]=i;  //fill index of next greater element
      st.pop();
      
  }
  st.push(i);
}
while(st.size()>0){
        nge[st.top()]=arr.size();
        st.pop();
    }

// sliding window
vector<int>res(arr.size()-k+1);
int i=0;
int j=0;
while(i<res.size()){ //loop on every window
    if(i>j){
        j=i;
    }
  while(nge[j]<(i+k)){ //if nge is inside the window size then jump to nge idx
        j=nge[j];      //and so on until nge found outside window
    }
 res[i]=arr[j];    //fill maxgreater element of each window
 i++;
}
return res;
}
void smallestNum(string& str){
    stack<int> st;
    int num=1;
    for(int i=0;i<str.size();i++){
      char ch=str[i];
      if(ch=='d'){
      st.push(num++);
      }else{
       st.push(num++);
       while(st.size()>0){
           int val=st.top();
           st.pop();
           cout<<val<<" ";
       }
      }
    }
    st.push(num++);
    while(st.size()>0){
           int val=st.top();
           st.pop();
           cout<<val<<" ";
       }
}
int getvalue(int v1,int v2,char op){
    switch(op){
        case '+':
        return v1+v2;
        break;
        case '-':
        return v1-v2;
        break;
        case '*':
        return v1*v2;
        break;
        case '/':
        return v1/v2;
        break;
        case '%':
        return v1%v2;
        break;
        case '^':
        return pow(v1,v2);
        break;
        default:
        break;
    }
    return 0;
}
int getpriority(char op){
    switch(op){
        case '+':
        case '-':
        return 1;
        break;
        case '*':
        case '/':
        case '%':
        return 2;
        break;
        case '^':
        return 3;
        break;
        default:
        break;
    }
    return 0;
}
int infix123(string exp){
    stack<int> vs;
    stack<char> os;
    for(int i=0;i<exp.length();i++){
        char ch=exp[i];
        if(ch>='0' && ch<='9'){
            vs.push(ch-48);
        }else if(ch=='('){
            os.push(ch);
        }else if(ch==')'){
            while(os.top()!='('){
                int v2=vs.top();vs.pop();
                int v1=vs.top();vs.pop();
                char op=os.top();os.pop();
                int res=getvalue(v1,v2,op);
            vs.push(res);
            }
            os.pop();
        }else{
            while(os.size()!=0 && os.top()!='(' && getpriority(os.top())>=getpriority(ch)){
                 int v2=vs.top();vs.pop();
                int v1=vs.top();vs.pop();
                char op=os.top();os.pop();
                int res=getvalue(v1,v2,op);
                  vs.push(res);
            }
            os.push(ch);
        }
    }
    while(os.size()!=0){
    int v2=vs.top();vs.pop();
                int v1=vs.top();vs.pop();
                char op=os.top();os.pop();
                int res=getvalue(v1,v2,op);
                  vs.push(res);
    }
    return vs.top();
}
inline int largest(int a,int b,int c){
    return ((a>=b && a>=c)?a:(b>=c && b>=a)?b:c);
}
int main(){
    // int a,b,c;
    // cout<<"Enter"<<endl;
    // cin>>a>>b>>c;
    // cout<<largest(a,b,c)<<endl;
    string exp="8+3^(4/(3-1))";
    cout<<infix123(exp)<<endl;
    // string exp="(a+(b+c+(d+e)))";
    // cout<<hasDuplicateBrackets(exp)<<endl;
     
    //  string exp="[a+{b_(d+e})]";
    //  cout<<isBalancedBracket(exp)<<endl;
//    vector<int>v{5,9,8,3,2,7,16,4,14,19,3};
//    vector<int>res=  NextGreaterElement1(v);

// for(int i=0;i<res.size();i++){
//    cout<<res[i]<<" ";
// }
// cout<<endl;
// vector<int>res1=  NextGreaterElement2(v);
// for(int i=0;i<res1.size();i++){
//    cout<<res1[i]<<" ";
// }
// cout<<endl;
// vector<int>ress1=  NextsmallerElement1(v);
// for(int i=0;i<ress1.size();i++){
//    cout<<ress1[i]<<" ";
// }
// cout<<endl;
// vector<int>ress2=  NextsmallerElement2(v);
// for(int i=0;i<ress2.size();i++){
//    cout<<ress2[i]<<" ";
// }
// cout<<endl;
// vector<int> ht{6,2,5,4,5,1,6};
// largestAreaHistogram(ht);
vector<int>arr2{5,9,3,1,8,6,7,2,11,4,17};
vector<int> res3=slidingWindowMax(arr2,5);
for(int i=0;i<res3.size();i++){
   cout<<res3[i]<<" ";
}
cout<<endl;
// string str="iiiiiiii";
// smallestNum(str);
}