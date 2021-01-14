#include<iostream>
#include<vector>
#include<climits>
#include<queue>
#include<stack>
using namespace std;
// class mpair{
// public:
// int i;
// int j;
// string psf;
// mpair(int i,int j,string psf){
//     this->i=i;
//     this->j=j;
//     this->psf=psf;
// }
// };    
class Edge{       // Edge is a data type having type neighbour & weight
 public:          //public b/z to use anywhere in program
 int nbr;         //Here public ,private,protected are specifiers
 int wt;
};
class bipair{
    public: 
    int v;
    int l; //level represent odd & even set

};

// int[][] graph={{0,1,1,0,0,0,0},
//                        {1,0,0,1,1,0,0},
//                        {1,0,0,0,0,0,0},
//                        {0,1,0,0,0,0,1},
//                        {0,0,0,1,0,0,1},
//                        {0,0,0,0,0,0,1},
//                        {0,0,0,1,0,1,0}};

class Dpair{
    public:
    int v;//vertex
    int c;//cost
    string p;//path so far
    Dpair(int v,int c,string p){ //constructor & class have same name
        this->v=v;
        this->c=c;
        this->p=p;
    }
    Dpair(){         //default constructor
    }
    bool operator>(const Dpair& other) const{  //operator over loading
        return this->c>other.c;              //compare on the basis of cost-small come out first
    }
    bool operator<(const Dpair& other) const{ //operator overloading
        return this->c<other.c;              //compare on the basis of cost-large come out first
    }
};
class KEdge{
    public:
        int v1;
        int v2;
        int wt;
        KEdge(int v1,int v2,int wt){
            this->v1=v1;
            this->v2=v2;
            this->wt=wt;
        }
        KEdge(){

        }
        //this>other return positive
        //this==other return zero
        //this<other return negative
         bool operator>(const KEdge& other) const{  //operator over loading
        return this->wt>other.wt;              //compare on the basis of cost-small come out first
         }
        // public int compareTo(KEdge other){
        //     return this.wt-other.wt;
        // }
    };
class PPair{
    public:
    int v;
    int av;
    int c;
    PPair(int v,int av,int c){
        this->v=v;
        this->av=av;
        this->c=c;

    }
    PPair(){
    }

    bool operator>(const PPair& other) const{
        return this->c>other.c;
    }

};

vector<vector<Edge>> graph;  // Edge is a data type
vector<vector<Edge>> dag;  // Edge is a data type
// void mazebfs(vector<vector<int>> strg){
//     vector<vector<bool>> visited;//(strg.size(),false);
//     queue<mpair> q;
//     mpair r(0,0,"");
//     q.push(r);
    
//     while(q.size()>0){
//         mpair rem=q.front();
//         q.pop();


//     }

// }
void addEdgedirected(int v1,int v2,int wt){
  Edge e1;
  e1.nbr=v2;
  e1.wt=wt;
  dag[v1].push_back(e1);

 
};
void addEdge(int v1,int v2,int wt){
  Edge e1;
  e1.nbr=v2;
  e1.wt=wt;
  graph[v1].push_back(e1);

  Edge e2;
  e2.nbr=v1;
  e2.wt=wt;
  graph[v2].push_back(e2);

};
void display(){

    for(int v=0;v<graph.size();v++){
        cout<<v<<"->";
        for(int n=0;n<graph[v].size();n++){
            Edge ne=graph[v][n];      //nbr edge
            cout<<"["<<ne.nbr<<"-"<<ne.wt<<"]";    
        }
        cout<<"."<<endl;
    }
}
bool  haspath(int s,int d,vector<bool>& visited){
        if(s==d){
            return true;
        }
       visited[s]=true;
        for(int n=0;n<graph[s].size();n++){
            Edge ne=graph[s][n];      //nbr edge
            if(visited[ne.nbr]==false){
           bool hpfntd= haspath(ne.nbr,d,visited); //dfs
           if(hpfntd==true){    
               return true;
           }}
          
      }
      return false;

}

void printallpathonly(int s,int d,vector<bool>& visited,string& asf,int dsf){
        if(s==d){    //base case                            //pass string by refrence
            cout<<asf+to_string(s)<<"@"<<dsf<<endl;
            return;
                }
       visited[s]=true;          //node pre
        for(int n=0;n<graph[s].size();n++){   //loop on neighbours
            Edge ne=graph[s][n];      //nbr edge  // edge pre
            if(visited[ne.nbr]==false){
                asf=asf+to_string(s);
            printallpathonly(ne.nbr,d,visited,asf,dsf+ne.wt);
            asf.erase(asf.length()-1,1);
           }
      }
      visited[s]=false;    //node post
}


int sd=INT_MAX;    //smallest distance
string sdp;        //smallest distance path

int ld=INT_MIN;    //largest distance
string ldp;        //largest distance path

int cd=INT_MAX;     //ceil distance
string cdp;          //ceil distance path

int fd=INT_MIN;    //floor distance
string fdp;        //floor distance path

//printallpath use DFS

void printallpath(int s,int d,vector<bool>& visited,string& asf,int dsf,int factor){
        if(s==d){    //base case                            //pass string by refrence
            cout<<asf+to_string(s)<<"@"<<dsf<<endl;
            if(dsf<sd){
                sd=dsf;
                sdp=asf;
            }
            if(dsf>factor && dsf<cd){ //dsf distance so far
                cd=dsf;       //ceil
                cdp=asf;
            }
            if(dsf<factor && dsf>fd){
                fd=dsf;         //floor distance
                fdp=asf;
            }
            if(dsf>ld){
                ld=dsf;     //longest distance path
                ldp=asf;
            }
            return;
                }
       visited[s]=true;          //node pre
        for(int n=0;n<graph[s].size();n++){
            Edge ne=graph[s][n];      //nbr edge  // edge pre
            if(visited[ne.nbr]==false){
                asf=asf+to_string(s);
            printallpath(ne.nbr,d,visited,asf,dsf+ne.wt,45);
            asf.erase(asf.length()-1,1);
           }
      }
      visited[s]=false;    //node post
}
//Hamitonian use DFS
void hamitonian(int s,vector<bool>& visited,string& asf,int dsf,int counter,int os){
        if(counter==graph.size()-1){    //base case                            //pass string by refrence
            cout<<asf+to_string(s);
           for(int n=0;n<graph[s].size();n++){
             Edge ne=graph[s][n];
             if(ne.nbr==os){
                 cout<<"hc"<<endl;
                 return;
             }
             
           }
            cout<<"hp"<<endl;
            return;
                }
       visited[s]=true;          //node pre

        for(int n=0;n<graph[s].size();n++){
            Edge ne=graph[s][n];      //nbr edge  // edge pre
            if(visited[ne.nbr]==false){
                asf=asf+to_string(s);
            hamitonian(ne.nbr,visited,asf,dsf+ne.wt,counter+1,os);  //dfs
            asf.erase(asf.length()-1,1);
           }
      }
      visited[s]=false;    //node post
}



bool bfs(int s,int d){       // also used to find has path
vector<bool> visited(graph.size(),false);
queue<int> q;               //queue is FIFO.
q.push(s);

while(q.size()>0){
    int rem=q.front();   //get
    q.pop();          //remove
    if(visited[rem]==true){
        continue;
    }
    visited[rem]=true;  //mark
   
   if(rem==d){
       return true;     //work
   }

   for(int n=0;n<graph[rem].size();n++){
       Edge ne=graph[rem][n];
       if(visited[ne.nbr]==false){
           q.push(ne.nbr);  //add
       }
   }
}
return false;
 }
 
 
  string gscc(int r,vector<bool>& visited){//master function
      string comp="";
      queue<int> q;
      q.push(r);
      while(q.size()>0){               //get remove mark add print
          int rem=q.front();
          q.pop();
          if(visited[rem]==true){
              continue;
          }
          visited[rem]=true;
          comp+=to_string(rem);
          for(int n=0;n<graph[rem].size();n++){
              Edge ne=graph[rem][n];
              if(visited[ne.nbr]==false){
                  q.push(ne.nbr);
              }
          }
      }
      return comp;
  }
    
    
 vector<string> gcc(){ //deriving function
      vector<string> comps;
      vector<bool> visited(graph.size(), false);
      for(int v=0;v<graph.size();v++){
          //cout<<"123";
          if(visited[v]==false){
              string comp=gscc(v,visited);
              
              comps.push_back(comp);
          }
      }
     return comps;
     }


     bool isconnected(){   //deriving function
         int counter=0;
         vector<bool> visited(graph.size(),false);

         for(int v=0;v<graph.size();v++){
             if(visited[v]==false){
                 gscc(v,visited);
                 counter++;
                 if(counter==2){
                     return false;
                 }
             }
         }
         return true;
     }
    
     bool iscompcyclic(int r,vector<bool>& visited){ //master function
         queue<int> q;
         q.push(r);
         while(q.size()>0){     
             int rem=q.front();
             q.pop();

             if(visited[rem]==true){
                 return true;
             }
             visited[rem]=true;
             for(int n=0;n<graph[rem].size();n++){
                 Edge ne=graph[rem][n];
                 if(visited[ne.nbr]==false){
                     q.push(ne.nbr);
                 }
             }
         }
         return false;
     }

     bool iscyclic(){
         vector<bool> visited (graph.size(),false);
         for(int v=0;v<graph.size();v++){
             if(visited[v]==false){
            bool isccyclic=iscompcyclic(v,visited);
            if(isccyclic==true){
                return true;
            }
             }
         }
         return false;
     }
     //Bipartite grmwa=>grwma
      bool iscompbipartite(int s,vector<int>& visited){
         queue<bipair> q;
         bipair bp;
         bp.v=s;
         bp.l=1; //level 
         q.push(bp);
         
          while(q.size()>0){
             bipair rem=q.front();//get
             q.pop(); //remove

            //do work before mark
             if(visited[rem.v]!=0){
                 int ol=visited[rem.v];//old level  Important=>how to find old level & new level of same vertex
                 int nl=rem.l;//new level of vertex
                 if(ol%2!=nl%2){
                     return false;
                 }
             }
             visited[rem.v]=rem.l;//store node visited level //mark
             for(int n=0;n<graph[rem.v].size();n++){
                 Edge ne=graph[rem.v][n];
                 if(visited[ne.nbr]==0){
                     bipair np;
                     np.v=ne.nbr;
                     np.l=rem.l+1;//give same level number to all childs of a parent
                     q.push(np);
                 }
             }
         }
         return true;
     }

      bool isbipartite(){
         vector<int> visited (graph.size(),0);
         for(int v=0;v<graph.size();v++){
             if(visited[v]==0){
            bool iscbipartite=iscompbipartite(v,visited);
            if(iscbipartite==false){
                return false;
            }
             }
         }
         return true;
     }

//see java implementation of dijikstra
     void djikstra(int s){
         priority_queue<Dpair,vector<Dpair>,greater<Dpair>> pq;
         Dpair rtp(s,0,to_string(s));//root pair
         pq.push(rtp);
          vector<bool> visited(graph.size(),false);
         while(pq.size()>0){
             Dpair rem=pq.top();
             pq.pop();
             if(visited[rem.v]==true){
                 continue;
             }
             visited[rem.v]=true;
             cout<<rem.v<<" @ "<<rem.c<<" via "<<rem.p<<endl;

             for(int n=0;n<graph[rem.v].size();n++){
                 Edge ne=graph[rem.v][n];
                 if(visited[ne.nbr]==false){
                     Dpair np(ne.nbr,rem.c+ne.wt,rem.p+to_string(ne.nbr));
                     pq.push(np);
                 }
             }

         }
     }



     void addEdge(vector<vector<Edge>>& g,int v1,int v2,int wt){
  Edge e1;
  e1.nbr=v2;
  e1.wt=wt;
  g[v1].push_back(e1);

  Edge e2;
  e2.nbr=v1;
  e2.wt=wt;
  g[v2].push_back(e2);

};
void display(vector<vector<Edge>>& g){

    for(int v=0;v<g.size();v++){
        cout<<v<<"->";
        for(int n=0;n<g[v].size();n++){
            Edge ne=g[v][n];      //nbr edge
            cout<<"["<<ne.nbr<<"-"<<ne.wt<<"]";
        }
        cout<<"."<<endl;
    }
}
void prims(){
    vector<vector<Edge>> mst(graph.size(),vector<Edge>());//pass graph by reference
    vector<bool> visited(graph.size(),false);
     priority_queue<PPair,vector<PPair>,greater<PPair>> pq;//take locally min cost value
    PPair rtp(0,-1,0);//rootpair
     pq.push(rtp);

     while(pq.size()>0){
         PPair rem=pq.top();//take locally min cost value out of all value present in priority queue
         pq.pop();


     if(visited[rem.v]==true)continue;
     
    //  if(rem.v==-1){ mst.push_back(rem.v);}
   
     if(rem.av!=-1){
         addEdge(mst,rem.v,rem.av,rem.c);//agar -1 k equal nhi ha to edge bna danga acquringvertex & vertex k beech
     }
     visited[rem.v]=true;
     for(int n=0;n<graph[rem.v].size();n++){
         Edge ne=graph[rem.v][n];
         if(visited[ne.nbr]==false){
             PPair np(ne.nbr,rem.v,ne.wt);
             pq.push(np);
         }
      }
     }
 display(mst);
}


//Topological sort
void topologicalcomp(vector<bool>& visited,stack<int>& st,int v){
    visited[v]=true;
    for(int n=0;n<dag[v].size();n++){
        Edge ne=dag[v][n];
        if(visited[ne.nbr]==false){
         topologicalcomp(visited,st,ne.nbr);
        }
    }
    st.push(v);//push when no child of parent or all child visited-i.e INdependent
}
void topological(){
    stack<int> st;
    vector<bool> visited(dag.size(),false);
    for(int v=0;v<dag.size();v++){//for(int v=dag.size()-1;v>=0;v--){}answer-0125463
        if(visited[v]==false){
            topologicalcomp(visited,st,v);
        }
    }
    while(st.size()>0){
        int v=st.top();
        st.pop();
        cout<<v;
    }
  cout<<endl;
}

void floydwarshall(){
     vector<vector<int>> res(graph.size(),vector<int>(graph.size(),INT_MAX));
     
     for(int i=0;i<graph.size();i++){
         for(int n=0;n<graph[i].size();n++){
        Edge ne=graph[i][n];
        res[i][ne.nbr]=ne.wt;
         }
     }

     for(int k=0;k<graph.size();k++){
         for(int i=0;i<graph.size();i++){
             for(int j=0;j<graph.size();j++){
                 if(k==i ||k==j|| i==j){
                     if(i==j){
                          res[i][j]=0;
                     }
                     continue;
                 }else if(res[i][k]==INT_MAX ||res[k][j]==INT_MAX){
                    continue;
                 }else{
                     if(res[i][k]+res[k][j]<res[i][j]){
                         res[i][j]=res[i][k]+res[k][j];
                     }
                 }
             }
         }
     }

     for(int i=0;i<res.size();i++){
         for(int j=0;j<res[i].size();j++){
             cout<<res[i][j]<<" ";
         }
         cout<<endl;
     }
 }
 
void bellmanford(vector<vector<Edge>>& graph,int src){
    vector<int> res(graph.size(),INT_MAX);
    res[src]=0;
    vector<KEdge> alledge;
   // priority_queue<KEdge> pq;
    //PriorityQueue<KEdge> pq;
    for(int v=1;v<=graph.size();v++){
        for(int n=0;n<graph[v].size();n++){
            Edge ne=graph[v][n];
            KEdge ke(v,ne.nbr,ne.wt);
             alledge.push_back(ke);

        }
    }
    for(int i=0;i<alledge.size()-1;i++){
        for(int j=0;j<alledge.size();j++){
            KEdge ke=alledge[j];
            if(res[ke.v1]!=INT_MAX){
            if(res[ke.v1]+graph[ke.v1][ke.v2].wt<res[ke.v2]){
                res[ke.v2]=res[ke.v1]+graph[ke.v1][ke.v2].wt;
            }
        }
        }
        for(int j=0;j<alledge.size();j++){
            KEdge ke=alledge[j];
            if(res[ke.v1]!=INT_MAX){
            if(res[ke.v1]+graph[ke.v1][ke.v2].wt<res[ke.v2]){
                cout<<"Negative cycle"<<endl;
                return;
            }
        }
        }

    }

     for(int i=0;i<res.size();i++){
         cout<<res[i]<<endl;
     }
}
 
// void kosaraju(){};
//void bridges&articulationpoint(){};
int main(int argc,char** argv){
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());
//     dag.push_back(vector<Edge>());

//     addEdgedirected(0,1,1);
//    addEdgedirected(1,2,1);
//    addEdgedirected(2,3,1);
//    addEdgedirected(4,3,1);
//    addEdgedirected(5,4,1);
//    addEdgedirected(6,3,1);
//    topological();
//    dag.push_back(vector<Edge>());
//    dag.push_back(vector<Edge>());
//    dag.push_back(vector<Edge>());
//    dag.push_back(vector<Edge>());

//     addEdgedirected(1,2,2);
//     addEdgedirected(2,4,3);
//     addEdgedirected(1,3,4);
//     addEdgedirected(3,4,5);
//     addEdgedirected(4,2,6);
//     addEdgedirected(4,3,1);
//        graph.push_back(vector<Edge>());
//    graph.push_back(vector<Edge>());
//    graph.push_back(vector<Edge>());

// //    addEdge(0,1,10);
// //    addEdge(1,2,10);
// //    addEdge(2,3,10);
// //    addEdge(0,3,40);
// //    addEdge(3,4,2);
// //    addEdge(4,5,3);
// //    addEdge(5,6,3);
// //    addEdge(6,4,8);
//   //addEdge(2,5,5);
//   //display();
//   bellmanford(dag,1);
//    addEdge(0,1,20);
//    addEdge(1,2,10);
//    addEdge(2,3,20);
//    addEdge(0,3,40);
//    addEdge(3,4,2);
//    addEdge(4,5,3);
//    addEdge(5,6,3);
//    addEdge(6,4,8);
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
      graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());

    //floyd warshall
      addEdge(1,2,5);
      addEdge(2,3,2);
      addEdge(3,4,7);
      addEdge(1,4,9);
      addEdge(4,5,2);
      addEdge(5,1,1);
   display();
   floydwarshall();

// //   prims();
//  // djikstra(0);
//  // cout<<iscyclic()<<endl;
//  // cout<<isconnected()<<endl;
//   //cout<<isbipartite()<<endl;
//   // cout<<bfs(0,6)<<endl;
  
// //    vector<string> comps=gcc();
// //    for(int i=0;i<comps.size();i++){
// //        cout<<comps[i]<<" "<<endl;
// //    }
//    //vector<bool> visited (7,false);
//  //  cout<<haspath(0,6,visited)<<endl;
// // string s;
// //  printallpath(0,6,visited,s,0,45);
// //  cout<<"Smallest path "<<sdp<<"@"<<sd<<endl;
// //  cout<<"largest path "<<ldp<<"@"<<ld<<endl;
// //  cout<<"ceil path "<<cdp<<"@"<<cd<<endl;
// //  cout<<"floor path "<<fdp<<"@"<<fd<<endl;
//     // hamitonian(0,visited,s,0,0,0);

//     //ASTRONOUT QUESTION
 int n=10;
 vector<int> v1={9,5,2,3,6,1};
 vector<int> v2={4,3,0,7,8,4};

for(int v=0;v<n;v++){
    graph.push_back(vector<Edge>());
}

for(int e=0;e<v1.size();e++){
    addEdge(v1[e],v2[e],1);
}
display();
int teams=0;
vector<string> nations=gcc();  //first find no of different nations
for(int n1=0;n1<nations.size();n1++){
    for(int n2=n1+1;n2<nations.size();n2++){
        teams+=nations[n1].size()*nations[n2].size();
    }
}
// //  cout<<teams<<endl;
}