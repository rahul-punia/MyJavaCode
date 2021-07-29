import java.util.*;
import java.lang.*;
import java.io.*;

//Practise Problems
//https://www.codechef.com/MARCH21B/problems/PAPARAZI
// ICPC question: https://www.codechef.com/ACM16CHN/pro...​
//https://cp-algorithms.com/geometry/grahams-scan-convex-hull.html


public class convexhull {

    static class pt{
        double x=0,y=0;
        pt(double x,double y){ this.x=x;  this.y=y; }
    }

    // static boolean cmp(pt a, pt b) {  //compare function for cpp
    //     return a.x < b.x || (a.x == b.x && a.y < b.y);
    // }

    // static boolean cw(pt a, pt b, pt c) {   //clockwise
    //     return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) < 0;
    // }

    // static boolean ccw(pt a, pt b, pt c) { //counter clockwise
    //     return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) > 0;
    // }

//Easy to Understand
// The algorithm first finds the leftmost and rightmost points A and B. In the event multiple such points exist, the lowest among the left (lowest Y-coordinate) is taken as A, and the highest among the right (highest Y-coordinate) is taken as B. Clearly, A and B must both belong to the convex hull as they are the farthest away and they cannot be contained by any line formed by a pair among the given points.
// Now, draw a line through AB. This divides all the other points into two sets, S1 and S2, where S1 contains all the points above the line connecting A and B, and S2 contains all the points below the line joining A and B. The points that lie on the line joining A and B may belong to either set. The points A and B belong to both sets. Now the algorithm constructs the upper set S1 and the lower set S2 and then combines them to obtain the answer.
// To get the upper set, we sort all points by the x-coordinate. For each point we check if either - the current point is the last point, (which we defined as B), or if the orientation between the line between A and the current point and the line between the current point and B is clockwise. In those cases the current point belongs to the upper set S1. Checking for clockwise or anticlockwise nature can be done by checking the orientation.
// If the given point belongs to the upper set, we check the angle made by the line connecting the second last point and the last point in the upper convex hull, with the line connecting the last point in the upper convex hull and the current point. If the angle is not clockwise, we remove the most recent point added to the upper convex hull as the current point will be able to contain the previous point once it is added to the convex hull.
// The same logic applies for the lower set S2. If either - the current point is B, or the orientation of the lines, formed by A and the current point and the current point and B, is counterclockwise - then it belongs to S2.
// If the given point belongs to the lower set, we act similarly as for a point on the upper set except we check for a counterclockwise orientation instead of a clockwise orientation. Thus, if the angle made by the line connecting the second last point and the last point in the lower convex hull, with the line connecting the last point in the lower convex hull and the current point is not counterclockwise, we remove the most recent point added to the lower convex hull as the current point will be able to contain the previous point once added to the hull.
    public static boolean cw(pt p,pt q,pt r){   //check IsClockwise
        double difference=((r.x-q.x)*(q.y-p.y))-((q.x-p.x)*(r.y-q.y));

        return difference>0;
    }
    public static boolean ccw(pt p,pt q,pt r){  //check IsAnticlockwise
        double difference=((r.x-q.x)*(q.y-p.y))-((q.x-p.x)*(r.y-q.y));

        return difference<0;
    }


    static void convex_hull(ArrayList<pt> a) {
        System.out.println("Convex Hull");
        if (a.size() == 1)
            return;
    
      //The algorithm first finds the leftmost and rightmost points A and B. In the event multiple such points 
      //exist, the lowest among the left (lowest Y-coordinate) is taken as A, and the highest among the right (highest Y-coordinate) is taken as B.       
        // sort(a.begin(), a.end(), &cmp);
        Collections.sort(a,new Comparator<pt>(){
            public int compare(pt a,pt b){
                if(a.x!=b.x)return (int)Math.ceil(a.x-b.x);
                return  (int)Math.ceil(a.y-b.y);
            }
        });

        pt p1 = a.get(0), p2 = a.get(a.size()-1);
        // vector<pt> up, down;
        ArrayList<pt> up=new ArrayList<>(),down=new ArrayList<>();

        up.add(p1);
        down.add(p1);
        for (int i = 1; i < (int)a.size(); i++) {
            if (i == a.size() - 1 || cw(p1, a.get(i), p2)) {  //Imp
                while (up.size() >= 2 && !cw(up.get(up.size()-2), up.get(up.size()-1), a.get(i))){
                    up.remove(up.size()-1);
                }
                    
                up.add(a.get(i));
            }
            if (i == a.size() - 1 || ccw(p1, a.get(i), p2)) {
                while(down.size() >= 2 && !ccw(down.get(down.size()-2), down.get(down.size()-1), a.get(i))){
                    down.remove(down.size()-1);
                }
                    
                down.add(a.get(i));
            }
        }
    
        a.clear();
    
        for (int i = 0; i < (int)up.size(); i++)
            a.add(up.get(i));
        for (int i = down.size() - 2; i > 0; i--)
            a.add(down.get(i));

       
        System.out.println("Convex Hull Coodinates-");
        
        for(pt xy:a){
            System.out.println(xy.x+"  "+xy.y);
        }

    }


    public static void convex_hull_main(){
        ArrayList<pt> pts=new ArrayList<>();
        
        //I/P-1
        //OP-1 (0,0) (0,4)  (5,0)
        // pts.add(new pt(0, 0));
        // pts.add(new pt(0, 2));
        // pts.add(new pt(1, 2));
        // pts.add(new pt(0, 4));
        // pts.add(new pt(3, 0));
        // pts.add(new pt(4, 0));
        // pts.add(new pt(5, 0));
        // pts.add(new pt(2, 1));
        

        //I/P-2
        //Point points[] = {{0, 3}, {1, 1}, {2, 2}, {4, 4},{0, 0}, {1, 2}, {3, 1}, {3, 3}};
        //O/P- (0, 3)  (4, 4)  (3,1)  (0,0) 
       
        pts.add(new pt(0,3));
        pts.add(new pt(1,1));
        pts.add(new pt(2,2));
        pts.add(new pt(4,4));
        pts.add(new pt(0,0));
        pts.add(new pt(1,2));
        pts.add(new pt(3,1));
        pts.add(new pt(3,3));
        convex_hull(pts);
    }

    public static void main(String[] args) {
        convex_hull_main();    
    }



    //sweep line algorithm
    static  double EPS = 1E-9;
    static class spt{
        double x=0,y=0;
        spt(double x,double y){ this.x=x;  this.y=y; }
    }

   public static class seg {
        spt p=new spt(0, 0), q=new spt(0, 0);
        int id=0;
    
       public double get_y(double x){
            if (abs(p.x - q.x) < EPS)
                return p.y;
            return p.y + (q.y - p.y) * (x - p.x) / (q.x - p.x);
        }
    };


    public static boolean intersect1d(double l1, double r1, double l2, double r2) {
        if (l1 > r1)
            swap(l1, r1);
        if (l2 > r2)
            swap(l2, r2);
        return max(l1, l2) <= min(r1, r2) + EPS;
    }

    public static int vec(spt a,spt b,spt c) {
        double s = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return abs(s) < EPS ? 0 : s > 0 ? +1 : -1;
    }


    public static bool intersect(seg a,seg b){
        return intersect1d(a.p.x, a.q.x, b.p.x, b.q.x) &&
               intersect1d(a.p.y, a.q.y, b.p.y, b.q.y) &&
               vec(a.p, a.q, b.p) * vec(a.p, a.q, b.q) <= 0 &&
               vec(b.p, b.q, a.p) * vec(b.p, b.q, a.q) <= 0;
    }

    public static  bool operator(seg a,seg b){
        double x = max(min(a.p.x, a.q.x), min(b.p.x, b.q.x));
        return a.get_y(x) < b.get_y(x) - EPS;
    }


    public static class  event {
        double x;
        int tp, id;
    
        // event() {}
        // event(double x, int tp, int id) : x(x), tp(tp), id(id) {}
    
        public boolean operator(event e){
            if (abs(x - e.x) > EPS)
                return x < e.x;
            return tp > e.tp;
        }
    };

    static HashSet<seg> s=new HashSet<>();
    // vector<set<seg>::iterator> where;


    

}
