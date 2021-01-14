import java.util.*;

public class  practiserec{

   static int n=4;
    static boolean[] row=new boolean[n];
    static boolean[] col=new boolean[n];
    static boolean[] daig=new boolean[2*n-1];
    static boolean[] antidaig=new boolean[2*n-1];
    static int ct=0;
public static boolean isqueensafe(int i,int j){
    return row[i]==false && col[j]==false && daig[i+j]==false && antidaig[(i-j)+(n-1)]==false;
 }
 public static void mark(int i,int j){
    row[i]=true;
    col[j]=true;
    daig[i+j]=true;
    antidaig[i-j+(n-1)]=true;
    
 }
 public static void unmark(int i,int j){
    row[i]=false;
    col[j]=false;
    daig[i+j]=false;
    antidaig[(i-j)+(n-1)]=false;
 }

public static void nqueen(int cq,int bn,String asf){
    if(cq==n){
     System.out.println(++ct+asf);
     return;
    }
 
    for(int i=bn;i<n*n;i++){
        int r=i/n;
        int c=i%n;
            if(isqueensafe(r,c)==true){
                mark(r, c);
                nqueen(cq+1,i+1, asf+"->"+r+c+"-");
                unmark(r,c);
                }
        
    }
}

//  Bit masking
static int nq=4;
    static int row_bit=0;
    static int col_bit=0;
    static int daig_bit=0;
    static int antidaig_bit=0;
    static int ct2=0;
public static boolean isqueensafe_bit(int i,int j){
    return (row_bit & (1<<i))==0 && (col_bit & (1<<j))==0 && (daig_bit & (1<<(i+j)))==0 && (antidaig_bit & (1<<((i-j)+(n-1))))==0;
 }
 public static void mark_unmark_bit(int i,int j){
   row_bit^=(1<<i);
   col_bit^=(1<<j);
   daig_bit^=1<<(i+j);
   antidaig_bit^=(1<<((i+j)+(n-1)));
   }
 

public static void nqueen_bit(int cq,int bn,String asf){
    if(cq==n){
     System.out.println(++ct2+asf);
     return;
    }
 
    for(int i=bn;i<n*n;i++){
        int r=i/n;
        int c=i%n;
            if(isqueensafe_bit(r,c)==true){
                mark_unmark_bit(r, c);
                nqueen_bit(cq+1,i+1, asf+"->"+r+c+"-");
                mark_unmark_bit(r,c);
                }
        
    }
}

// public static void nqueen_bestwala(int cq,int row,int bn,String asf){
//     if(cq==n){
//      System.out.println(++ct2+asf);
//      return;
//     }
 
//     for(int col=0;col<n;col++){
//             if(isqueensafe_bit(r,c)==true){
//                 mark_unmark_bit(r, c);
//                 nqueen_bestwala(cq+1,row+1,i+1, asf+"->"+r+c+"-");
//                 mark_unmark_bit(r,c);
//                 }
        
//     }
// }
// public static void nqueen(int cq,int lqi,int lpj,String asf){
//     if(cq==n){
//      System.out.println(++ct+asf);
//      return;
//     }
//     for(int i=lqi;i<n;i++){
//         for(int j=(i==lqi?lpj+1:0);j<n;j++){
//             if(isqueensafe(i, j)==true){
//                 mark(i, j);
//                 nqueen(cq+1, i, j, asf+"->"+i+j+"-");
//                 unmark(i, j);
//                 }
//         }
//     }
// }
public static void main(String[] args){
    // String asf="";
// nqueen(0,0, "");
nqueen_bit(0, 0, "");
}
}