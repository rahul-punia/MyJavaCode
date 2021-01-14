#include<stdio.h> 
#include<graphics.h> 
  
void DDAline(int X0, int Y0, int X1, int Y1) 
{ 
    int dx = X1 - X0; 
    int dy = Y1 - Y0; 
  
    int steps = abs(dx) > abs(dy) ? abs(dx) : abs(dy); 
  
    float Xinc = dx / (float) steps; 
    float Yinc = dy / (float) steps; 
  
    float X = X0; 
    float Y = Y0; 
    for (int i = 0; i <= steps; i++) 
    { 
        putpixel (X,Y,RED);  
        X += Xinc;            
        Y += Yinc;            
        delay(100);          
    } 
} 


void findNewCoordinate(int s[][2], int p[][1]) 
{ 
    int temp[2][1] = { 0 }; 
  
    for (int i = 0; i < 2; i++) 
        for (int j = 0; j < 1; j++) 
            for (int k = 0; k < 2; k++) 
                temp[i][j] += (s[i][k] * p[k][j]); 
  
    p[0][0] = temp[0][0]; 
    p[1][0] = temp[1][0]; 
} 
  
//Polygon Scaling
void scale(int x[], int y[], int sx, int sy) 
{ 
    DDAline(x[0], y[0], x[1], y[1]); 
    DDAline(x[1], y[1], x[2], y[2]); 
    DDAline(x[2], y[2], x[0], y[0]); 
  
    int s[2][2] = { sx, 0, 0, sy }; 
    int p[2][1]; 
  
    for (int i = 0; i < 3; i++) 
    { 
        p[0][0] = x[i]; 
        p[1][0] = y[i]; 
  
        findNewCoordinate(s, p); 
  
        x[i] = p[0][0]; 
        y[i] = p[1][0]; 
    } 
  
    DDAline(x[0], y[0], x[1], y[1]); 
    DDAline(x[1], y[1], x[2], y[2]); 
    DDAline(x[2], y[2], x[0], y[0]); 
} 
  
int main() 
{ 
    int x[] = { 100, 200, 300 }; 
    int y[] = { 200, 100, 200 }; 
    int sx = 2, sy = 2; 
  
    int gd, gm; 
    detectgraph(&gd, &gm); 
    initgraph(&gd, &gm," "); 
  
    scale(x, y, sx,sy); 
    getch(); 
  
    return 0; 
} 