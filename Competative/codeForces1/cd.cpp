//#include "/Users/akshaypuniya/Desktop/Inter-prep-Books/stdc++.h"
//using namespace std;
//int compare(string arr1[][100],string a,int q){
//for(int i=0;i<q;i++){
//if(arr1[i][0]==a||a=="#"){
//return 0;}}
//return 1;}
//set<string>setunion(set<string>a,set<string> b){
//set<string>::iterator it;
//for(it=b.begin();it!=b.end();it++){
//a.insert(*it);}
//return a;}
//
//set<string> break1(string a){
//set<char> b;
//size_t n=a.length();
//
////size_t n = strlen(a);
//
//for(int z=0;z<n;z++){
//if(a[z]!=',')
//b.insert(a[z]);}
//set<string> d;
//set<char>::iterator it;
//for(it=b.begin();it!=b.end();it++){
//string c="";
//c=c+*it;
//d.insert(c);
//}
//return d;}
//set<string>epslon(string arr[][100],int i,int m){
//set<string> final1;
//if(arr[i][m-1]=="#"){
//final1.insert(arr[i][0]);
//return final1;}
//else{
//set<string> b;
//b=break1(arr[i][m-1]);
//queue<string> q;
//set<string>::iterator it;
//for(it=b.begin();it!=b.end();it++){
//if(*it=="#"){
//continue;}
//final1.insert(*it);
//q.push(*it);}
//while(!q.empty()){
//string s=q.front();
//q.pop();
//set<string> e;
//e=break1(arr[s[0]-48][m-1]);
//set<string>::iterator it;
//for(it=b.begin();it!=b.end();it++){
//if(*it=="#"||final1.find(*it)!=final1.end()){
//continue;}
//final1.insert(*it);
//q.push(*it);
//}
//}
//final1.insert(arr[i][0]);}
//return final1;}
//void removeextra(string arr1[][100],int m,int q){
//int flag=0;
//for(int j=1;j<m;j++){
//string a=arr1[q][j];
//set<char> b;
//size_t n=a.length();
//for(int z=0;z<n;z++){
//if(a[z]!=',')
//b.insert(a[z]);}
//if(b.size()>1){
//flag=1;}
//set<char>::iterator it;
//arr1[q][j]="";
//for(it=b.begin();it!=b.end();it++){
//if(flag==1&&*it=='#'){
//continue;
//}
//arr1[q][j]=arr1[q][j]+*it;
//arr1[q][j]=arr1[q][j]+",";}
//arr1[q][j].pop_back();
//b.clear();
//flag=0;
//}
//}
//void transition(string arr[][100],string arr1[][100],int q,string a,int m){
//size_t z=a.length();
//string p="";
//vector<string> v;
//for(int i=0;i<z;i++){
//if(a[i]==','){
//v.push_back(p);
//p="";}
//else{
//p=p+a[i];}}
//v.push_back(p);
//p="";
//z=v.size();
//int j=1;
//int flag=0;
//while(j<m){
//for(int i=0;i<z;i++){
//int s=atoi(v[i].c_str());
//if(arr[s][j]=="#"&& flag==1){
//continue;}
//else{
//p=p+arr[s][j]+",";
//flag=1;
//}
//}
//p.pop_back();
//arr1[q][j]=p;
//p="";
//j++;
//flag=0;
//}
//}
//int main(){
//int m,n;
//cout<<"Enter the no of states and  no of inputs\n";
//cin>>n>>m;
//string arr[100][100];
//for(int i=0;i<n;i++){
//for(int j=0;j<m+1;j++){
//cin>>arr[i][j];}}
//vector<set<string>> e;
//for(int i=0;i<n;i++){
//set<string> f;
//f=epslon(arr,i,m+1);
//e.push_back(f);}
//m--;
//for(int i=0;i<n;i++){
//for(int j=1;j<m+1;j++){
//set<string> final1;
//set<string> result;
//set<string> g=e[i];
//set<string>::iterator it;
//set<string> temp1;
//string stemp;
//for(it=g.begin();it!=g.end();it++){
//if(arr[(*it)[0]-48][j]=="#"){
//continue;}
//stemp=arr[(*it)[0]-48][j];
//temp1=break1(stemp);
//final1=setunion(final1,temp1);}
//set<string>::iterator it1;
//set<string> temp;
//for(it1=final1.begin();it1!=final1.end();it1++){
//temp=e[(*it1)[0]-48];
//result=setunion(result,temp);}
//set<string>::iterator it2;
//arr[i][j]="";
//for(it2=result.begin();it2!=result.end();it2++){
//arr[i][j]=arr[i][j]+*it2;
//arr[i][j]=arr[i][j]+",";}
//if(arr[i][j]==""){
//arr[i][j]="#,";}
//arr[i][j].pop_back();}}
////int n1=2^n;
//string arr1[100][100];
//int init,fin;
//cout<<"Enter the initial state and  final state\n";
//cin>>init>>fin;
//arr1[0][0]=init+48;
//for(int i=1;i<m+1;i++){
//arr1[0][i]=arr[init][i];}
//    int z=1;//,flag=0;
////int x=z-1;
////int y=0;
//for(int i=0;i<z;i++){
//for(int j=1;j<m+1;j++){
//if(compare(arr1,arr1[i][j],z)==1){
//arr1[z][0]=arr1[i][j];
//transition(arr,arr1,z,arr1[z][0],m+1);
//z++;
//removeextra(arr1,m+1,i+1);}}}
//for(int i=0;i<z;i++){
//for(int j=0;j<m+1;j++){
//cout<<arr1[i][j]<<"\t";}
//cout<<endl;}
//return 0;
//}
//







// #include "/Users/akshaypuniya/Desktop/Inter-prep-Books/stdc++.h"
// using namespace std;

// int main()
// {
//     // your code goes here
//     int tss;
//     cin>>tss;
//     while(tss--)
//     {
//         int n;
//         cin>>n;
//         vector<int>vc(n),left(n,-1),right(n,-1);
//         unordered_map<int,int>m;
//         for(int i=0; i<n; i++)cin>>vc[i];
//         stack<int>s;
//         for(int i=0; i<n; i++)
//         {
//             while(!s.empty() && s.top()<vc[i])
//             {
//                 s.pop();
//             }
//             if(s.empty())left[i]=-1;
//             else left[i]=s.top();
//             s.push(vc[i]);
//         }
//         while(!s.empty())s.pop();
//         for(int i=n-1; i>=0; i--)
//         {
//             while(!s.empty() && s.top()<vc[i])s.pop();
//             if(!s.empty())right[i]=s.top();
//             s.push(vc[i]);
//         }
//         for(int i=0; i<n; i++)
//         {
//             int x=left[i];
//             int y=right[i];
//             if(x!=-1)
//             {
//                 m[x-vc[i]]++;
//             }
//             if(y!=-1)
//             {
//                 m[y-vc[i]]++;
//             }
//         }
//         cout<<m.size()<<endl;
//     }
//     return 0;
// }