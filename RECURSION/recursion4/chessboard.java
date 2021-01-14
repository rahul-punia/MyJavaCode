import java.util.*;

public class  chessboard{
    static int ct=0;
    public static boolean isqueensafe(boolean [][] chess,int i,int j){
    for(int r=i-1;r>=0;r--){       //to check in row
        if(chess[r][j]==true){
            return false;
        }
        }
       for(int c=j-1;c>=0;c--){    //to check in coloumn
        if(chess[i][c]==true){
            return false;
        }
    }
        int d1=i-1;
        int d2=j-1;
        while(d1>=0 && d2>=0){    //to check daigonally
            if(chess[d1][d2]==true){
                return false;
            }
            d1--;
            d2--;
        }

        d1=i-1;                  //to check daigonally
        d2=j+1;
     while(d1>=0 && d2<chess[0].length){
            if(chess[d1][d2]==true){
                return false;
            }
            d1--;
            d2++;
        }
   
     return true;
    }
    public static boolean isknightsafe(boolean [][] chess,int r,int c){
        if(r>=1 && c>=2 && chess[r-1][c-2]==true){
            return false;
        }
       else if(r>=2&& c>=1 && chess[r-2][c-1]==true){
            return false;
        }
        else if(r>=2 && c<chess.length-1 && c<chess.length && chess[r-2][c+1]==true){
            return false;
        }
        else if(r>=1 && c<chess.length-2 && chess[r-1][c+2]==true){
            return false;
        }
        else {
            return true;
        }
    }
    public static void nqueen(boolean [][] chess,int cq,int lqi,int lpj,String asf){
        if(cq==chess.length){
         System.out.println(++ct+asf);
         return;
        }
        for(int i=lqi;i<chess.length;i++){
            for(int j=(i==lqi?lpj+1:0);j<chess[0].length;j++){
                if(chess[i][j]==false && isqueensafe(chess, i, j)==true){
                    chess[i][j]=true;
                    nqueen(chess, cq+1, i, j, asf+"->"+i+j+"-");
                    chess[i][j]=false;
                }
            }
        }
    }
    
    public static void nknight(boolean [][] chess,int ck,int lki,int lkj,String asf){
        if(ck==chess.length){
         System.out.println(++ct+asf);
         return;
        }
        for(int i=lki;i<chess.length;i++){
            for(int j=(i==lki?lkj+1:0);j<chess[0].length;j++){
                if(chess[i][j]==false && isknightsafe(chess, i, j)==true){
                    chess[i][j]=true;
                    nknight(chess, ck+1, i, j, asf+"->"+i+j+"-");
                    chess[i][j]=false;
                }
            }
        }
    }
    //nknight Combination
    public static void nknight2(boolean [][] chess,int i,int j,int ksf,String asf){
        if(i==chess.length && j==0){
            if(ksf==chess.length){
                System.out.println( ++ct+"->"+asf);
            }
        }else if(j==chess[0].length-1){
            //no
            nknight2(chess, i+1, 0, ksf, asf);

            //yes
           if(isknightsafe(chess, i, j)==true){
               chess[i][j]=true;
            nknight2(chess, i+1, 0, ksf+1, asf+i+j+"_");
            chess[i][j]=false;
            }
        }else{
           //no
           nknight2(chess, i,j+1 , ksf, asf);

           //yes
          if(isknightsafe(chess, i, j)==true){
              chess[i][j]=true;
           nknight2(chess, i, j+1, ksf+1, asf+i+j+"_");
           chess[i][j]=false;
           } 
        } 
    }
    
    public static void nqueen2(int [][] boxes,int cb,int r ,int c,String asf){
     
        for(int i=0;i<4;i++){
        nqueen2(boxes, cb+1,r,c, asf+"q"+i+"b"+r+c+"-");
        }
    }
    

    public static void main(String [] args){
    boolean [][] chess=new boolean[4][4];
    // nqueen(chess, 0, 0, -1, "");
//    System.out.println(ct);
  nknight(chess, 0, 0, -1, "");
//    int [][] arr={{3,0,6,5,0,8,4,0,0},
//                  {5,2,0,0,0,0,0,0,0},
//                  {0,8,7,0,0,0,0,0,0},
//                  {0,0,3,0,1,0,0,8,0},
//                  {9,0,0,8,6,3,0,0,5},
//                  {0,5,5,5,0,0,6,0,0},
//                  {1,3,0,0,0,0,2,5,0},
//                  {0,0,0,0,0,0,0,7,4},
//                  {0,0,5,2,0,6,3,0,0}};
             
        //    nknight(chess, 0, 0, 0, "");
                // nknight2(chess, 0, 0, 0, "");
    }}
    