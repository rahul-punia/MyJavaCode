import java.util.*;

public class printperm{
    static int ct=0; 
    public static void printperm1(boolean [] boxes,int co,int to,String psf){
       if(co>to){
           System.out.println(psf); 
           ct++;             //level ma object ya queen  ko rkha
           return;                               //level decide base case
       }
      //node pre
       for(int i=0;i<boxes.length;i++){        //options ma boxes ko rkha
    if(boxes[i]==false){                     // is option valid
     boxes[i]=true;          // Edge pre      if valid use & mark
     printperm1(boxes, co+1, to, psf+"o"+co+"b"+i+" ");
     boxes[i]=false;        // Edge post       unmark
       }
    }
    // node post
    }
    static int ct3=0;
    public static void printperm2(boolean[] items,int cb,int cfb,int tb,String psf){
        if(cb>=4){        //Important Note 
            if(cfb==tb){
            ct3++;
            System.out.println(ct3+" "+psf);
            }
            return;
        }

        printperm2(items,cb+1,cfb, tb, psf);
        for(int i=0;i<items.length;i++){
            if(items[i]==false){
             items[i]=true;
             printperm2(items, cb+1,cfb+1,tb,psf+"item"+i+"box"+cb+"  ");
             items[i]=false;      
            }
        }
    }
    public static void main(String [] args){
        boolean [] boxes=new boolean[4];
        int objects=2;
        printperm1(boxes, 1, objects, "");
        System.out.println(ct);
        boolean[] items=new boolean[3];
       printperm2(items,0,0,3,"");
    }
}

