//Mid point Circle drawing algorithm


#include<stdio.h>
#include<conio.h>
#include<graphics.h>


int main(){
    int gd=DETECT,gm;
    initgraph(&gd, &gm, "C:\\TC\\BGI");
	int x_cent, y_cent,r;

	cout << "MidPoint Circle Drawing\n";
    cout << "Enter radius for circle: "; 
	cin>>r;

	cout << "Enter Pixel for centre: "; 
	cin>>x_cent>>y_cent;
    int x=0,y=r;
    int dp=(i-r);
    
    while(x<y){
    putpixel(x_cent+x,y_cent+y, 4);
    putpixel(x_cent-x, y_cent+y, 4);
    putpixel(x_cent-x,y_cent-y, 4);
    putpixel(x_cent+x,y_cent-y, 4);

    if(dp>=0){
      dp=dp+(2*(x+1))+(2*(y+1))+1;
      y++;
    }else{
         dp=dp+(2*(x+1))+1;
    }
     x+=1;
    }
}