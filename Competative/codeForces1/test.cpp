// #include <bits/stdc++.h> 
#include <vector>
#include <iostream>
using namespace std;

int gcd(int a, int b, int& x, int& y) {
    if (b == 0) {
        x = 1;
        y = 0;
        return a;
    }
    int x1, y1;
    int d = gcd(b, a % b, x1, y1);
    x = y1;
    y = x1 - y1 * (a / b);
    return d;
}

int main() 
{ 
    int x=0,y=0;
    gcd(55,80,x,y);
    cout<<x<<" "<<y;
}

