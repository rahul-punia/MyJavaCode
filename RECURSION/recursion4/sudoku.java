import java.util.*;
public class sudoku{
    public static boolean isvalid(int [][] board,int r,int c,int op){
        for(int j=0;j<board[0].length;j++){
            if(board[r][j]==op){
              return false;
            }
            }

            for(int i=0;i<board.length;i++){
                if(board[i][c]==op){
                    return false;
                 }
                }

                
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        int rs = (r / 3) * 3+i;//rs-rowstart to check in submatrix
                        int cs = (c / 3) * 3+j;//cs-coloumnstart tocheck in submatrix
                      
                        if(board[rs][cs]==op){
                            return false;
                            }
                        
                    }
                }
                return true;
    }
    public static void fill(int [][] board,int i,int j){
       
        if(i==board.length && j==0 ){
            System.out.println("*******"+(++counter)+"********");
            for(int ii=0;ii<board.length;ii++){
                for(int jj=0;jj<board[0].length;jj++){
                System.out.print(board[ii][jj]+" ");
            }
            System.out.println();
        }
            System.out.println("*******"+(++counter)+"********");
           
           return;
        }else if(j==board[0].length-1){
            if(board[i][j]!=0){
            fill(board, i+1, 0);
            }else{
                for(int op=1;op<=9;op++){
             if(isvalid(board, i, j, op)==true){
                 board[i][j]=op;
                 fill(board, i+1, 0);
                 board[i][j]=0;
             }
                }
            }
        }else{
            if(board[i][j]!=0){
                fill(board, i, j+1);
                }else{
                    for(int op=1;op<=9;op++){
                 if(isvalid(board, i, j, op)==true){
                     board[i][j]=op;
                     fill(board, i, j+1);
                     board[i][j]=0;
                 }
                    }
                }
            }
        }
        
       

        
    
    
    public static void main(String [] args){
          int [][] arr={{3,0,6,5,0,8,4,0,0},
                        {5,2,0,0,0,0,0,0,0},
                        {0,8,7,0,0,0,0,0,0},
                        {0,0,3,0,1,0,0,8,0},
                        {9,0,0,8,6,3,0,0,5},
                        {0,5,0,0,9,0,6,0,0},
                        {1,3,0,0,0,0,2,5,0},
                        {0,0,0,0,0,0,0,7,4},
                        {0,0,5,2,0,6,3,0,0}};
     fill(arr,0,0);
    

    }
}