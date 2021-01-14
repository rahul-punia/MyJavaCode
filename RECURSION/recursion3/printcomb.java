import java.util.*;

public class printcomb{
    static int ct=0; 
    public static void printcomb1(boolean [] boxes,int co,int to,String psf,int lib){
       if(co>to){            //current object   to-total object
           System.out.println(psf); 
           ct++;             //level ma object ya queen  ko rkha
           return;                               //level decide base case
       }
      //node pre
       for(int i=lib+1;i<boxes.length;i++){        //options ma boxes ko rkha
    if(boxes[i]==false){                     // is option valid
     boxes[i]=true;          // Edge pre      if valid use & mark
     printcomb1(boxes, co+1, to, psf+"o"+co+"b"+i+" ",i);
     boxes[i]=false;        // Edge post       unmark
       }
    }
    // node post
    }
    public static void printcomb2(int cb,int n,int bssf,int r,String asf){
        if(cb==n){
        if(bssf==r){
            System.out.println(asf);
        }
        return;
    }
    //if box is selected   yes call
    printcomb2(cb+1, n, bssf+1, r, asf+cb);
    //if box is rejected    no call
    printcomb2(cb+1, n, bssf, r, asf);
    }
    public static void printperm2(int cb,int n,int isf,int r,String asf,boolean [] items){
        if(cb==n){
        if(isf==r){
            System.out.println(asf);
        }
        return;
    }
    printperm2(cb+1, n, isf, r, asf, items);  // agar box na kese ko nhi bethaya
    for(int i=0;i<items.length;i++){
        if(items[i]==false){
        items[i]=true;
        printperm2(cb+1, n, isf+1, r, asf+"item"+i+"box"+cb+" ", items);
        items[i]=false;
        }
    }
}
public static void paycoinperm(int targ,int [] coins,int sum,String asf){
    if(sum>=targ){
   if(sum==targ){
       System.out.println(asf);
   }
       return;
   }

   for(int i=0;i<coins.length;i++){
       if(sum<targ){
       paycoinperm(targ, coins, sum+coins[i], asf+coins[i]);
       }
   }
}
public static void paycoincomb(int targ,int [] coins,int sum,String asf,int lc){
    if(sum==targ){
        System.out.println(asf);
        return;
    }
 
    for(int i=lc;i<coins.length;i++){
        
        if(sum<targ){
        paycoincomb(targ, coins, sum+coins[i], asf+coins[i],i);
     }
    
    }
 }
 public static void coinchangeperm(int amt,int [] coins,String asf){
     if(amt==0){
         System.out.println(asf);
         return;
     }

     for(int i=0;i<coins.length;i++){
         if(coins[i]<=amt){
         coinchangeperm(amt-coins[i], coins, asf+coins[i]);
     }}
 }
 public static void coinchangecomb(int amt,int [] coins,String asf,int lci){
    if(amt==0){
        System.out.println(asf);
        return;
    }

    for(int i=lci;i<coins.length;i++){
        if(coins[i]<=amt){
        coinchangecomb(amt-coins[i], coins, asf+coins[i],i);
    }}
}
    public static void main(String [] args){
        boolean [] boxes=new boolean[4];
        int objects=2;
     //   printcomb1(boxes, 1, objects, "",-1);
      //  System.out.println(ct);
  //    printcomb2(0, 4, 0, 2, "");
  int n=4;
  int r=2;
 // printperm2(0, n, 0, r, "", new boolean [r]);    
  int[] coins={2,3,5,6};
    paycoinperm(7,coins,0,"");
    System.out.println();
    paycoincomb(7, coins,0, "", 0);
      //coinchangeperm(7, coins, "");
       System.out.println();
     // coinchangecomb(7, coins, "", 0);
}
}

