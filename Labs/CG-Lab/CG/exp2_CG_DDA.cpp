#include<stdio.h>
#include<graphics.h>
#include<conio.h>
#include<math.h>

int main(){
	int gd = DETECT, gm;
	initgraph(&gd, &gm, "C:\\TC\\BGI");
	int x1, x2, y1, y2;

	cout << "DDA Line\n";
	cout << "Initial Pixel : "; //first point
	cin >> x1 >> y1;
	cout << "\nFinal Pixel   : "; //second point
	cin >> x2 >> y2;

	float xk = x1, yk = y1, xk1, yk1;
	int x = x1, y = y1;

	float m;
	m = (float)(y2 - y1) / (x2 - x1);

	if (m > 1){
		putpixel(x, y, 4);
		while (x < x2 && y < y2){
			xk1 = xk + (1 / m);
			x = floor(xk1);
			if ((xk1 - floor(xk1)) >= 0.5)x = x + 1;
			
			yk1 = yk + 1; y = yk1;
			xk = xk1; yk = yk1;
			putpixel(x, y, 4);
		}
	}
	else if (m < 1){
		putpixel(x, y, 4);
		while (x < x2 && y < y2){
			yk1 = yk + m; y = floor(yk1);
			if ((yk1 - floor(yk1)) >= 0.5)y = y + 1;
			xk1++; x = xk1;
			
			xk = xk1; yk = yk1;
			putpixel(x, y, 4);
		}
	}else{
		putpixel(x, y, 4);
		while (x < x2 && y < y2){
			xk1++; x = xk1;
			yk1++; y = yk1;
			xk = xk1; yk = yk1;
			putpixel(x, y, 4);
		}
	}

	getch();
	closegraph();
	return 0;
}
