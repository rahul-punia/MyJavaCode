#include<stdio.h>
#include<conio.h>
#include<graphics.h>

int main()
{
  int gd=DETECT, gm;
  initgraph(&gd, &gm,"C:\\TC\\BGI");
  putpixel(100, 50, 4);
  line(100, 50, 200, 300);
  circle(100, 50, 5);
  getch();
  closegraph();
  return 0;
}