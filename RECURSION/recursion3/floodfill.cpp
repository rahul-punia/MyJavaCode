#include<iostream>
#include<vector>
using namespace std;

  void floodsir(vector<vector<int>>& matrix,int sr,int sc,int dr,int dc,string& psf){
      
        if(sr==dr && sc==dc){
            cout<<psf<<endl;
            return;
        }
        
         matrix[sr][sc]=2;    //mark
        if(sc<dc && matrix[sr][sc+1]==0 && matrix[sr][sc+1]!=2){
            psf+="r";
            floodsir(matrix, sr, sc+1, dr, dc,psf);
            psf.erase(psf.length()-1,1);
        }
        if(sr<dr && matrix[sr+1][sc]==0&& matrix[sr+1][sc]!=2){
            psf+="b";
            floodsir(matrix, sr+1, sc, dr, dc,psf);
            psf.erase(psf.length()-1,1);
       }
       if(sc>0 && matrix[sr][sc-1]==0&& matrix[sr][sc-1]!=2){
            psf+="l";
        floodsir(matrix, sr, sc-1, dr, dc,psf);
         psf.erase(psf.length()-1,1);
       }
       if(sr>0 && matrix[sr-1][sc]==0&& matrix[sr-1][sc]!=2){
           psf+="t";
        floodsir(matrix, sr-1, sc, dr, dc,psf);
        psf.erase(psf.length()-1,1);
       }
       matrix[sr][sc]=0;     //unmark
   }
  
int main(int argc,char** argv){
 vector<vector<int>> matrix={{0,1,0,0,0,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,1,1,0,0,0,0},
                          {0,0,0,0,0,0,1,1,1},
                          {0,1,0,1,1,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,0,0,0,0,0,0}};

                          string psf="";
          floodsir(matrix,0,0,matrix.size()-1,matrix[0].size()-1,psf);
}