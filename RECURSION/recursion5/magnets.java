import java.util.*;
public class magnets{
    static String pat="";
static int [] left={2,3,0,0,0};
static int [] top={1,0,0,2,1,0};
static int [] bottom={2,0,0,2,0,3};
static int [] right={0,0,0,1,0};
static boolean cpmh(char[][] board,int i,int j,String pat){   //can place magnet horizontally
    if(j-1>=0 && board[i][j-1]==pat.charAt(0)){
        return false;
    }
    else if(i-1>=0 && board[i-1][j]==pat.charAt(0)){
        return false;
    }
    else if(i-1>=0 && j+1<board[0].length && board[i-1][j+1]==pat.charAt(1)){
        return false;
    }
    else if(j+2<board[0].length && board[i][j+2]==pat.charAt(1)){
        return false;
    }
    return true;
}
static boolean cpmv(char[][] board,int i,int j,String pat){   //can place magnet verticaly
    if(j-1>=0 && board[i][j-1]==pat.charAt(0)){
        return false;
    }  
    else if(i-1>=0 && j+1<board[0].length && board[i-1][j]==pat.charAt(0)){
        return false;
    }
    else if(j+1<board[0].length && board[i][j+1]==pat.charAt(0)){
        return false;
    }
    return true;
}
public static void solve(char[][] board,int i,int j){
    if(i==board.length && j==0){
     
        for(int r=0;r<board.length;r++){
            int pcount=0;
            int ncount=0;
        for(int c=0;c<board[0].length;c++){
          if(board[r][c]=='+'){
              pcount++;
          }
          if(board[r][c]=='-'){
            ncount++;
        }
            }
            if(left[r]!=pcount && left[r]!=0){
                return;
            }
            if(right[r]!=ncount && right[r]!=0){
                return;
            }

        }

        for(int c=0;c<board[0].length;c++){
            int pcount=0;
            int ncount=0;
        for(int r=0;r<board.length;r++){
          if(board[r][c]=='+'){
              pcount++;
          }
          if(board[r][c]=='-'){
            ncount++;
        }
            }
            if(top[c]!=pcount && top[c]!=0){
                return;
            }
            if(bottom[c]!=ncount && bottom[c]!=0){
                return;
            }

        }
        for(int ii=0;ii<board.length;ii++){
            for(int jj=0;jj<board[0].length;jj++){
                System.out.print(board[ii][jj]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }else if(j==board[0].length-1){
        if(board[i][j]=='v'){
            //->o1       option -1
            pat="+-";
        if(cpmv(board,i,j,pat)==true){
            board[i][j]='+';
            board[i+1][j]='-';
            solve(board,i+1,0);
            board[i][j]='v';
            board[i+1][j]='v';
        }

        //->o2       option -2
        pat="-+";
        if(cpmv(board,i,j,pat)==true){
            board[i][j]='-';
            board[i+1][j]='+';
            solve(board,i+1,0);
            board[i][j]='v';
            board[i+1][j]='v';   
        }
        //->o3         option -3
        pat="**";
        board[i][j]='*';
        board[i+1][j]='*';
        solve(board,i+1,0);
        board[i][j]='v';
        board[i+1][j]='v';
        
    }else if(board[i][j]=='h'){
                //->o1        option -1
                pat="+-";
            if(cpmh(board,i,j,pat)==true){
                board[i][j]='+';
                board[i][j+1]='-';
                solve(board, i+1,0);
                board[i][j]='h';
                board[i][j+1]='h';
            }

            //->o2      option -2
            pat="-+";
            if(cpmh(board,i,j,pat)==true){
                board[i][j]='-';
                board[i][j+1]='+';
                solve(board, i+1,0);
                board[i][j]='h';
                board[i][j+1]='h';
           
            }
            //->o3      option -3
            pat="**";
            board[i][j]='*';
            board[i][j+1]='*';
            solve(board, i+1,0);
            board[i][j]='h';
            board[i][j+1]='h';
       
    }else{
        solve(board,i+1,0);
    }

    }else{
        if(board[i][j]=='v'){
            //->o1            option -1
            pat="+-";
        if(cpmv(board,i,j,pat)==true){
            board[i][j]='+';
            board[i+1][j]='-';
            solve(board,i,j+1);
            board[i][j]='v';
            board[i+1][j]='v';
        }

        //->o2              option -2
        pat="-+";
        if(cpmv(board,i,j,pat)==true){
            board[i][j]='-';
            board[i+1][j]='+';
            solve(board,i,j+1);
            board[i][j]='v';
            board[i+1][j]='v';   
        }
        //->o3           option -3
        pat="**";
        board[i][j]='*';
        board[i+1][j]='*';
        solve(board,i,j+1);
        board[i][j]='v';
        board[i+1][j]='v';
        
    }else if(board[i][j]=='h'){
                //->o1        option -1
                pat="+-";
            if(cpmh(board,i,j,pat)==true){
                board[i][j]='+';
                board[i][j+1]='-';
                solve(board, i, j+1);
                board[i][j]='h';
                board[i][j+1]='h';
            }

            //->o2         option -2
            pat="-+";
            if(cpmh(board,i,j,pat)==true){
                board[i][j]='-';
                board[i][j+1]='+';
                solve(board, i, j+1);
                board[i][j]='h';
                board[i][j+1]='h';
           
            }
            //->o3      option -3
            pat="**";
            board[i][j]='*';
            board[i][j+1]='*';
            solve(board, i, j+1);
            board[i][j]='h';
            board[i][j+1]='h';
       
    }else{
        solve(board,i,j+1);
    }

}
}
public static void main(String [] args){
    char [][] board={"hhhhvv".toCharArray(),
                     "hhhhvv".toCharArray(),
                     "vvvvhh".toCharArray(),
                    "vvvvvv".toCharArray(),
                    "hhhhvv".toCharArray()};
                    solve(board, 0, 0);
                    
}
}