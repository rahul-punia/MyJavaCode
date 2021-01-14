import java.util.*;

public class staircase{
  static int myres=0;
    public static int countpath(int s){
        if(s==0 ){
            return 1;
         }else if(s==-1 ||s==-2 ){
          return 0;
         }
      //  if(s>=1){
        int path1=path(s-1);
  //      myres+=path1;
    //    }
    //    if(s>=2){
        int path2=path(s-2);
   //     myres+=path2;
    //    }
      //  if(s>=3){
        int path3=path(s-3);
      //  myres+=path3;
       // }
        return path1+path2+path3;
    }
    static int ct2=0;
    public static void printallpath(int n,String psf){
        if(n==0){
            ct2++;
            System.out.println(ct2+" "+psf);
            return;
        }
        if(n>=1)
        printallpath(n-1, psf+"1");
        if(n>=2)
        printallpath(n-2, psf+"2");
        if(n>=3)
        printallpath(n-3, psf+"3");
    }

    public static void main(String [] args){
       int allpath= countpath(7);
       System.out.println(allpath);
       printallpath(7, "");
    } 
}