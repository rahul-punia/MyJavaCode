import java.util.*;
import java.lang.*;
import java.io.*;

public class Wrongconvexhull {
    
//        Give Wrong Solution
    static class pt{
        double x=0,y=0;
        pt(double x,double y){
            this.x=x;  this.y=y;
        }
    }

    public static boolean check_anticlockwise(pt p,pt q,pt r){
        double difference=((r.x-q.x)*(q.y-p.y))-((q.x-p.x)*(r.y-q.y));

        return difference<0;
    } 

    public static void convex_hull(ArrayList<pt> pts){
        if(pts.size()<=2)return;

        Collections.sort(pts,new Comparator<pt>(){
            public int compare(pt a,pt b){
                if(a.y!=b.y){return (int)Math.ceil(a.y-b.y);}
                return (int)Math.ceil(a.x-b.x);   //doubt    b.x-a.x
            }
        });


        pt pt1=pts.get(0);
        pt pt2=pts.get(1);
        ArrayList<pt> stack=new ArrayList<>();
        stack.add(pt1);    stack.add(pt2);  
        System.out.println(pt1.x+"  "+pt1.y);
        System.out.println(pt2.x+"  "+pt2.y);

        for(int i=2;i<pts.size();i++){

                int peek=stack.size();
                while(peek>=2 && !check_anticlockwise(stack.get(peek-2), stack.get(peek-1), pts.get(i))){
                    stack.remove(peek-1);
                    peek=stack.size();
                }
                stack.add(pts.get(i));
        }

        int top=stack.size();
        while(top>=3 && !check_anticlockwise(stack.get(top-2), stack.get(top-1), pts.get(0))){
            stack.remove(top-1);
            top=stack.size();
        }



        System.out.println("Convex Hull");

        for(pt mpt:stack){
            System.out.println(mpt.x+"   "+mpt.y);
        }
    }
    public static void main(String[] args) {
        //I/P-2
        //Point points[] = {{0, 3}, {1, 1}, {2, 2}, {4, 4},{0, 0}, {1, 2}, {3, 1}, {3, 3}};
        //O/P- (0, 3)  (4, 4)  (3,1)  (0,0) 
        ArrayList<pt> pts=new ArrayList<>();
        
        pts.add(new pt(0,3));
        pts.add(new pt(1,1));
        pts.add(new pt(2,2));
        pts.add(new pt(4,4));
        pts.add(new pt(0,0));
        pts.add(new pt(1,2));
        pts.add(new pt(3,1));
        pts.add(new pt(3,3));
        convex_hull(pts);

        // 0.0  0.0
        // 1.0  1.0
        // Convex Hull
        // 0.0   0.0
        // 3.0   1.0
        // 4.0   4.0
    }
}
