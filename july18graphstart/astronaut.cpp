#include<iostream>
#include<vector>
#include<climits>
using namespace std;    
class Edge{       // Edge is a data type having type neighbour & weight
 public:          //public b/z to use anywhere in program
 int nbr;
};
vector<vector<Edge>> graph;  // Edge is a data type

void addEdge(int v1,int v2){
  Edge e1;
  e1.nbr=v2;
  graph[v1].push_back(e1);

  Edge e2;
  e2.nbr=v1;
  graph[v2].push_back(e2);

};
void display(){

    for(int v=1;v<=graph.size();v++){
        cout<<v<<"->";
        for(int n=0;n<graph[v].size();n++){
            Edge ne=graph[v][n];      //nbr edge
            cout<<"["<<ne.nbr<<"]";
        }
        cout<<"."<<endl;
    }
}
int main(int argc,char** argv){
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
    graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
   graph.push_back(vector<Edge>());
    vector<int> v1={1,2,3,4,8}; 
    vector<int> v2={7,6,4,7,2};
   addEdge(2,9);
   addEdge(3,8);
   addEdge(8,7);
   addEdge(1,7);
  addEdge(6,5);
    addEdge(4,2);
   display();
}