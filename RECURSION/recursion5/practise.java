import java.util.*;

public class practise{
    static int getnumber(String s,int [] map){
        int num=0;
        int pv=1;
        for(int i=s.length()-1;i>=0;i--){
        num+=pv*map[s.charAt(i)-97];
        pv*=10;
        }
        return num;
    }
    static String unique(String s1,String s2,String s3){
       boolean [] duplicates=new boolean [26];
        String ans="";
        for(char ch:s1.toCharArray()){
        if(duplicates[ch-97]==false){
            duplicates[ch-97]=true;
            ans+=ch;
        }
        }
        for(char ch:s2.toCharArray()){
            if(duplicates[ch-97]==false){
                duplicates[ch-97]=true;
                ans+=ch;
            }
            }
            for(char ch:s3.toCharArray()){
                if(duplicates[ch-97]==false){
                    duplicates[ch-97]=true;
                    ans+=ch;
                }
                }
        return ans;
    }
    static int counter=0;

    static void generatemaping(int [] map,boolean [] takennumber,String unique){
        if(unique.length()==0){
            int n1=getnumber(s1, map);
            int n2=getnumber(s2, map);
            int n3=getnumber(s3, map);
            if(n1+n2==n3){
                System.out.print(++counter+".");
        
                for(int i=0;i<map.length;i++){
                if(map[i]!=-1){
                System.out.print((char)(i+97)+"="+map[i]+", ");
            }
        }
        System.out.println();
        
        }
         return;
        }
        
       char ch=unique.charAt(0);
       String roq=unique.substring(1, unique.length());
       for(int op=0;op<=9;op++){
           if(takennumber[op]==false){
        //   if(map[ch-97]!=op){
            takennumber[op]=true;
               map[ch-97]=op;
               generatemaping(map, takennumber, roq);
               takennumber[op]=false;
               map[ch-97]=-1;
             
     //      }
       }
    }
} 
static boolean isvalid(int [][] board,int r,int c,int op){
   
    for(int j=0;j<board.length;j++){
        if(board[r][j]==op){
        return false;
        }
    }

    for(int i=0;i<board.length;i++){
        if(board[i][c]==op){
        return false;
        }
    }
    int rs=r/3*3;
    int cs=c/3*3;
    for(int ii=rs;ii<rs+3;ii++){
        for(int jj=cs;jj<cs+3;jj++){
            if(board[ii][jj]==op){
                return false;
                }   
        }
    }
    return true;
} 
public static void fill(int [][] board,int i,int j){
    if(i==board.length && j==0){
        System.out.println("*******"+(++counter)+"********");
        for(int ii=0;ii<board.length;ii++){
            for(int jj=0;jj<board[0].length;jj++){
            System.out.print(board[ii][jj]+" ");
        }
        System.out.println();
       }
       System.out.println("*******"+(++counter)+"********");
       return;
    }else if(j==board.length-1){
        if(board[i][j]!=0){
            fill(board, i+1, 0);
        }else{
            for(int op=0;op<=9;op++){
            if(isvalid(board,i,j,op)==true){
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
            for(int op=0;op<=9;op++){
            if(isvalid(board,i,j,op)==true){
                board[i][j]=op;
                fill(board, i, j+1);
                board[i][j]=0;
            }
            }}
    }
}
    static String s1,s2,s3;
    public static void main(String [] args){
     Scanner scn=new Scanner(System.in);
    //  s1=scn.next();
    //  s2=scn.next();
    //  s3=scn.next();
    // String unique=unique(s1, s2, s3);
    // System.out.println(unique);
     int [] map=new int[26];
     Arrays.fill(map, -1);
     boolean [] takennumber=new boolean[10];
    // generatemaping(map, takennumber, unique);
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