import java.util.*;
public class waterjug{
    static class Pair{
        int j1;
        int j2;
        int level;
        String psf;
    }


public static void main(String [] args){
int j1=3;
int j2=5;
int m=4;
boolean[][] visited=new boolean[j1+1][j2+1];
ArrayDeque<Pair> q=new ArrayDeque<>();
Pair t0=new Pair();

t0.j1=0;     //initially both jugs are empty
t0.j2=0;
t0.level=0;
t0.psf="";
q.addLast(t0);

while(q.size()>0){
Pair rem=q.getFirst();
q.removeFirst();

if(visited[rem.j1][rem.j2]==true){
    continue;
}
if(rem.j1==m || rem.j2==m){
    System.out.println(rem.psf+"  minimum step-"+rem.level);
    return;
}
visited[rem.j1][rem.j2]=true;
//q.addLast(rem);
//note- j1-capacity of jug1,j2-capacity of jug2,rem.j1-water present in j1,rem.j2-water present in j2
//to fill 3-j1
if(rem.j1<j1 && visited[j1][rem.j2]==false){
    Pair np=new Pair();
   np.j1=j1;
   np.j2=rem.j2;
   np.level=rem.level+1;
   np.psf=rem.psf+"f"+j1+"->";
   q.addLast(np);
 }

//to fill 5-j2
if(rem.j2<j2 && visited[rem.j1][j2]==false){
    Pair np=new Pair();
   np.j2=j2;
   np.j1=rem.j1;
   np.level=rem.level+1;
   np.psf=rem.psf+"f"+j2+"->";
   q.addLast(np);
   }

//ej1
if(rem.j1>0 && visited[0][rem.j2]==false){
    Pair np=new Pair();
   np.j1=0;
   np.j2=rem.j2;
   np.level=rem.level+1;
   np.psf=rem.psf+"e"+j1+"->";
   q.addLast(np);
   }

//ej2
if(rem.j2>0 && visited[rem.j1][0]==false){
    Pair np=new Pair();
   np.j2=0;
   np.j1=rem.j1;
   np.level=rem.level+1;
   np.psf=rem.psf+"e"+j2+"->";
   q.addLast(np);
 }

//mj1toj2
if(rem.j2<j2 && rem.j1>0 ){
int space=j2-rem.j2;
if(space>rem.j1 && visited[0][rem.j2+rem.j1]==false){
    Pair np=new Pair();
    np.j2=rem.j2+rem.j1;
    np.j1=0;
    np.level=rem.level+1;
    np.psf=rem.psf+"m"+j1+j2+"->";
    q.addLast(np);
}else{
    if( rem.j1-space>=0 && visited[rem.j1-space][j2]==false){
   Pair np=new Pair();
    np.j2=j2;
    np.j1=rem.j1-space;
    np.level=rem.level+1;
    np.psf=rem.psf+"m"+j1+j2+"->";
    q.addLast(np);
    }
}
  
}

//mj2toj1
if(rem.j1<j1 && rem.j2>0 ){
    int space=j1-rem.j1;
    if(space>rem.j2 && visited[rem.j1+rem.j2][0]==false){
        Pair np=new Pair();
        np.j1=rem.j1+rem.j2;
        np.j2=0;
        np.level=rem.level+1;
        np.psf=rem.psf+"m"+j2+j1+"->";
        q.addLast(np);
    }else{
        if(rem.j2-space>=0 && visited[j1][rem.j2-space]==false){
        Pair np=new Pair();
        np.j1=j1;
        np.j2=rem.j2-space;
        np.level=rem.level+1;
        np.psf=rem.psf+"m"+j2+j1+"->";
        q.addLast(np);
    }
}
}
}
}
}  


