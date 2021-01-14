import java.awt.Point;
import java.util.*;
public class firestorm{
    static class Point{
        int x;    //location
        int y;
        int t;     //time
    }

 static void solve(int [][] arr,int time){
   ArrayDeque<Point> q=new ArrayDeque<>();
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if(arr[i][j]==1){
                Point t0=new Point();    //initially
                t0.x=i;
                t0.y=j;
                t0.t=1;
                q.addLast(t0);
            }
        }
    }
    while(q.size()>0){
        Point rem=q.getFirst();
        q.removeFirst();

        if(rem.t==time+2){     //work
            break;
        }
       if( arr[rem.x][rem.y]<0){
           continue;
       }
       arr[rem.x][rem.y]=-rem.t;

       if(rem.x-1>=0 && arr[rem.x-1][rem.y]==0){
           Point np=new Point();
           np.x=rem.x-1;
           np.y=rem.y;
           np.t=rem.t+1;
           q.addLast(np);
       }

       if(rem.x+1<arr.length && arr[rem.x+1][rem.y]==0){
        Point np=new Point();
        np.x=rem.x+1;
        np.y=rem.y;
        np.t=rem.t+1;
        q.addLast(np);
    }

    if(rem.y-1>=0 && arr[rem.x][rem.y-1]==0){
        Point np=new Point();
        np.x=rem.x;
        np.y=rem.y-1;
        np.t=rem.t+1;
        q.addLast(np);
    }
    if(rem.y+1<arr[0].length && arr[rem.x][rem.y+1]==0){
        Point np=new Point();
        np.x=rem.x;
        np.y=rem.y+1;
        np.t=rem.t+1;
        q.addLast(np);
    }
    }
 }
public static void main(String [] args){
int [][] arr={{1,2,0,2,0,0,0},
              {0,2,0,2,0,1,0},
             {0,0,0,2,0,0,0}
              ,{2,2,2,2,2,2,0}
              ,{0,2,1,0,0,0,0}
               ,{0,2,0,0,0,0,0}
              ,{0,2,0,0,0,0,0}};
            solve(arr,3);
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    System.out.print(arr[i][j]+"\t");
                }
                System.out.println();
            }           
}
}