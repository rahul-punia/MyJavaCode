#include<bits/stdc++.h> 
#include<graphics.h> 
  
using namespace std; 
  
void translateLine ( int P[][2], int T[]) 
{ 
    int gd = DETECT, gm, errorcode; 
    initgraph (&gd, &gm, "c:\\tc\\bgi");  
      
    setcolor (2); 
    line(P[0][0], P[0][1], P[1][0], P[1][1]); 
  
    P[0][0] = P[0][0] + T[0]; 
    P[0][1] = P[0][1] + T[1]; 
    P[1][0] = P[1][0] + T[0]; 
    P[1][1] = P[1][1] + T[1]; 
  
    setcolor(3); 
    line(P[0][0], P[0][1], P[1][0], P[1][1]); 
    closegraph(); 
} 
  
int main() 
{ 
    int P[2][2] = {5, 8, 12, 18}; // coordinates of point 
    int T[] = {2, 1}; // translation factor 
    translateLine (P, T); 
    return 0; 
}  