import java.util.*;

public class crossword{
    static boolean cpwv(char [][] board,int r,int c,String word){
      for(int i=0;i<word.length();i++){
       if(r+i==board.length){
        return false;
      }
      char chw=word.charAt(i);
      char chb=board[r+i][c];
    
       if(chb!='-'&& chb!=chw){
         return false;
       }
      }
      if(r-1>=0 && board[r-1][c]!='+'){//d
        return false;
       }
      else if(r+word.length()<board.length && board[r+word.length()][c]!='+'){
         return false;
       }
      return true;
    }


    static boolean cpwh(char [][] board,int r,int c,String word){
       for(int j=0;j<word.length();j++){
        if(c+j==board.length){
         return false;
       }
       char chw=word.charAt(j);
       char chb=board[r][c+j];
     
        if(chb!='-'&& chb!=chw){
          return false;
        } }
       if(c-1>=0 && board[r][c-1]!='+'){    //doubt
        return false;
       }
      else if(c+word.length()<board.length && board[r][c+word.length()]!='+'){
         return false;
       }
       return true;
     }


     static boolean [] pwv(char [][] board,int r,int c,String word){
       boolean [] dipit =new boolean[word.length()];
       for(int i=0;i<word.length();i++){
        char chw=word.charAt(i);
        char chb=board[r+i][c];
        
        if(chb=='-' ){
          board[r+i][c]=chw;
          dipit[i]=true;
        }
       }
       return dipit;
     }
     static boolean [] pwh(char [][] board,int r,int c,String word){
      boolean [] dipit =new boolean[word.length()];
      for(int j=0;j<word.length();j++){
       char chw=word.charAt(j);
       char chb=board[r][c+j];
       
       if(chb=='-'){
         board[r][c+j]=chw;
         dipit[j]=true;
       }
      }
      return dipit;
    } 
    static void upwv(char [][] board,int r,int c,boolean [] dipit){
     for(int i=0;i<dipit.length;i++){
      if(dipit[i]==true){
       board[r+i][c]='-';
      }
     }
    }
    static void upwh(char [][] board,int r,int c,boolean [] dipit){
      for(int j=0;j<dipit.length;j++){
       if(dipit[j]==true){
        board[r][c+j]='-';
       }
      }
     }
    public static void solve(char [][] board,String [] words,int widx){
      if(widx==words.length){
      for(int i=0;i<board.length;i++){
          for(int j=0;j<board[0].length;j++){
            System.out.print(board[i][j]+" ");
          }
          System.out.println();
        }    
      System.out.println("***************************");
      return;//
      }
      String word=words[widx];
    for(int i=0;i<board.length;i++){
      for(int j=0;j<board[i].length;j++){
           if(cpwv(board,i,j,word)==true){
            boolean [] dipit=pwv(board,i,j,word);
               solve(board,words,widx+1);
              upwv(board,i,j,dipit); 
           } 
           if(cpwh(board,i,j,word)==true){
            boolean [] dipit=pwh(board,i,j,word);
               solve(board,words,widx+1);
              upwh(board,i,j,dipit); 
           }
        }
}
}
  
    public static void main(String [] args){
    String [] words2={"+++++++++C",
    "P++++++++H",
    "HISTORY++E",
    "Y++++++++M",
    "S++++++++I",
    "I++++MATHS",
    "CIVICS+++T",
    "S++++++++R",
    "+GEOGRAPHY",
    "++++++++++"};
        char [][] board2={{'+','+','+','+','+','+','+','+','+','-'},
                    {'-','+','+','+','+','+','+','+','+','-'},
                    {'-','-','-','-','-','-','-','+','+','-'},
                    {'-','+','+','+','+','+','+','+','+','-'},
                    {'-','+','+','+','+','+','+','+','+','-'},
                    {'-','+','+','+','+','-','-','-','-','-'},
                    {'-','-','-','-','-','-','+','+','+','-'},
                    {'-','+','+','+','+','+','+','+','+','-'},
                    {'+','-','-','-','-','-','-','-','-','-'},
                    {'+','+','+','+','+','+','+','+','+','+'}};

                    char[][] board = {
                      "+-++++++++".toCharArray(),
                      "+-++++++++".toCharArray(),
                      "+-------++".toCharArray(),
                      "+-++++++++".toCharArray(),
                      "+-++++++++".toCharArray(),
                      "+------+++".toCharArray(),
                      "+-+++-++++".toCharArray(),
                      "+++++-++++".toCharArray(),
                      "+++++-++++".toCharArray(),
                      "++++++++++".toCharArray(),
                  };
                  String[] words = {"agra", "england", "gwalior", "norway"};
                              
            solve(board2,words2,0);
    }
}