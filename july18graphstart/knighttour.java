import  java.util.*;
public class knighttour{
   // static int counter=0;
    static void solve(int n,int r,int c,int csf,boolean [][] visited,String asf){
        if(csf==n*n){
            visited[r][c]=true;
            counter++;
            asf=asf+r+c;
        System.out.println(counter+"."+asf);
        visited[r][c]=false;
        return;
        }
        visited[r][c]=true;
        if(r-2>=0 && c+1<n && visited[r-2][c+1]==false ){    //smart call -preactive
           // visited[r-2][c+1]=true;       inside true false is wrong b/z first box donot filled & use again & again
            solve(n, r-2, c+1, csf+1, visited, asf+r+c+"]->");
             // visited[r-2][c+1]=false;
            } if(r-2>=0 && c-1>=0 && visited[r-2][c-1]==false){
           // visited[r-2][c-1]=true;
            solve(n, r-2, c-1, csf+1, visited, asf+"["+r+c+"]->");
           // visited[r-2][c-1]=false;
        } if(r-1>=0 && c-2>=0 && visited[r-1][c-2]==false){
            //visited[r-1][c-2]=true;
            solve(n, r-1, c-2, csf+1, visited, asf+"["+r+c+"]->");
           // visited[r-1][c-2]=false;
        } if(r+1<n && c-2>=0 && visited[r+1][c-2]==false){
            //visited[r+1][c-2]=true;
            solve(n, r+1, c-2, csf+1, visited, asf+"["+r+c+"]->");
            //visited[r+1][c-2]=false;
        } if(r-1>=0 && c+2<n && visited[r-1][c+2]==false){
            //visited[r-1][c+2]=true;
            solve(n, r-1, c+2, csf+1, visited, asf+"["+r+c+"]->");
            //visited[r-1][c+2]=false;
        } if(r+1<n && c+2<n && visited[r+1][c+2]==false){
            //visited[r+1][c+2]=true;
            solve(n, r+1, c+2, csf+1, visited, asf+r+c+"->");
            //visited[r+1][c+2]=false;
        } if(r+2<n && c-1>=0 && visited[r+2][c-1]==false){
            //visited[r+2][c-1]=true;
            solve(n, r+2, c-1, csf+1, visited, asf+"["+r+c+"]->");
            //visited[r+2][c-1]=false;
        } if(r+2<n && c+1<n && visited[r+2][c+1]==false){
           // visited[r+2][c+1]=true;
            solve(n, r+2, c+1, csf+1, visited, asf+"["+r+c+"]->");
            //visited[r+2][c+1]=false;
        }
        visited[r][c]=false;
        
        }
     static int counter=0;
      public static void tour(int [][] chess,int r,int c,int n,int move){
        if(r<0 || c<0 || r>=n || c>=n || chess[r][c]!=0){    //base case after stupid calls-reactive calls
            return;               //if(r<0 || c<0 || r>=n|| chess[r][c]!=0 || c>=n ) this is wrong base case
        }
        else if(move==(n*n)){
            counter++;
            chess[r][c]=move;
            System.out.println("*************"+counter+"***************");
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(chess[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("************"+counter+"****************");
            chess[r][c]=0;         //remind-untake karna na bhula
            return;
           
        }
       
        chess[r][c]=move;
        tour(chess, r-2, c+1, n, move+1);
        tour(chess, r-2, c-1, n, move+1);
        tour(chess, r-1, c-2, n, move+1);
        tour(chess, r+1, c-2, n, move+1);
        tour(chess, r-1, c+2, n, move+1);
        tour(chess, r+1, c+2, n, move+1);
        tour(chess, r+2, c-1, n, move+1);
        tour(chess, r+2, c+1, n, move+1);
        chess[r][c]=0;              //remind-untake karna na bhula
       }
    
    public static void main(String [] args){
        int n=8;
    boolean [][] visited=new boolean[n][n];
    //  solve(n, 1, 3, 1, visited, "");
     int [][] chess=new int[n][n];
    // knighttour2(n, 1, 3, visited, "", 1);
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<n;j++){
    //         System.out.print(chess[i][j]+" ");
    //     }
    //     System.out.println();
    // }
    tour(chess, 0, 0, n, 1);
    }
    static int count2=0;
    static void knighttour2(int n,int r,int c,boolean visited[][] ,String asf,int csf){
       
        if(csf==(n*n)){
            visited[r][c]=true;
            count2++;
         System.out.println(count2 +"."+asf+"["+r+c+"]");
         visited[r][c]=false;
         return;
        }
        visited[r][c]=true;
        if(c+1<n && r-2>=0 && visited[r-2][c+1]==false){
        knighttour2(n,r-2,c+1,visited,asf+"["+r+c+"]-->",csf+1);
        }

        if(c-1>=0 && r-2>=0 && visited[r-2][c-1]==false){
            knighttour2(n,r-2,c-1,visited,asf+"["+r+c+"]-->",csf+1);
            }
        

        if(c-2>=0 && r-1>=0 && visited[r-1][c-2]==false){
            knighttour2(n,r-1,c-2,visited,asf+"["+r+c+"]-->",csf+1);
            }

            if(c-2>=0 && r+1<n && visited[r+1][c-2]==false){
                knighttour2(n,r+1,c-2,visited,asf+"["+r+c+"]-->",csf+1);
                }
        
                if(r-1>=0 && c+2<n && visited[r-1][c+2]==false){
                    knighttour2(n,r-1,c+2,visited,asf+"["+r+c+"]-->",csf+1);
                    }

                    if(r+1<n && c+2<n && visited[r+1][c+2]==false){
                        knighttour2(n,r+1,c+2,visited,asf+"["+r+c+"]-->",csf+1);
                        }

                        if(r+2<n && c-1>=0 && visited[r+2][c-1]==false){
                            knighttour2(n,r+2,c-1,visited,asf+"["+r+c+"]-->",csf+1);
                            }
                        if(r+2<n && c+1<n && visited[r+2][c+1]==false){
                            knighttour2(n,r+2,c+1,visited,asf+"["+r+c+"]-->",csf+1);
                        }
                        visited[r][c]=false;
                }
}