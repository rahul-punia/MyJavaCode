import java.util.*;

public class stairpath{
   static String [] codes={".","abc","def","ghi","jklm","no","pqrs","tu","vwxy","ez"};
    public static void spath(int src,String asf){
    if(src==0){
        System.out.println(asf);
        return;
    }
       for(int i=1;i<=3;i++){
           if(src>=i){
        spath(src-i,asf+i);
       }}
         }
    public static void kpc(String str,String asf){
        if(str.length()==0){
            System.out.println(asf);
            return;
        }

         char ch=str.charAt(0);
         String ros=str.substring(1,str.length());
         String code=codes[ch-48];

         for(int i=0;i<code.length();i++){
             kpc(ros,asf+code.charAt(i));
         }

    }
    public static void mazepath1(int sr,int sc,int dr,int dc,String asf){
       if(sr==dr && sc==dc){
           System.out.println(asf);
           return;
       }
        if(sc<dc){
            mazepath1(sr,sc+1,dr,dc,asf+"h");
        }

        if(sr<dr){
            mazepath1(sr+1,sc,dr,dc,asf+"v");
        }

    }
    public static void mazepath2(int sr,int sc,int dr,int dc,String asf){
        if(sr==dr && sc==dc){
            System.out.println(asf);
            return;
        }
         
        for(int i=1;i<=dr-sr;i++){
            mazepath2(sr+i,sc,dr,dc,asf+"v"+i);
        }

        for(int i=1;i<=dc-sc;i++){
            mazepath2(sr,sc+i,dr,dc,asf+"h"+i);
        }

        for(int i=1;i<=dr-sr&&i<=dc-sc;i++){
            mazepath2(sr+i,sc+i,dr,dc,asf+"d"+i);
        }
    }
    public static void stairpath2(int [] arr,int idx,String asf){
       if(idx==arr.length-1){
           System.out.println(asf);
           return;
       }

        for(int i=1;i<=arr[idx];i++){
            int nbr=idx+i;
            if((nbr)<arr.length){
            stairpath2(arr, nbr, asf+i);
            }
        }
    }
    public static void flood(int [][] matrix,int sr,int sc,int dr,int dc,String psf,int [][] visited){
         if(sr==dr && sc==dc){
             System.out.println(psf);
             return;
         }

         if(sc<dc && matrix[sr][sc+1]==0 && visited[sr][sc+1]==0){
             visited[sr][sc+1]=1;
             flood(matrix, sr, sc+1, dr, dc, psf+"r",visited);
             visited[sr][sc+1]=0;
         }
         if(sr<dr && matrix[sr+1][sc]==0&& visited[sr+1][sc]==0){
            visited[sr+1][sc]=1;
             
            flood(matrix, sr+1, sc, dr, dc, psf+"b",visited);
            visited[sr+1][sc]=0;
             
        }
        if(sc>0 && matrix[sr][sc-1]==0&& visited[sr][sc-1]==0){
            visited[sr][sc-1]=1;
             
            flood(matrix, sr, sc-1, dr, dc, psf+"l",visited);
            visited[sr][sc-1]=0;
          
        }
        if(sr>0 && matrix[sr-1][sc]==0&& visited[sr-1][sc]==0){
            visited[sr-1][sc]=1;
             
            flood(matrix, sr-1, sc, dr, dc, psf+"t",visited);
            visited[sr-1][sc]=0;
            
        }
    }
    public static void floodsir(int [][] matrix,int sr,int sc,int dr,int dc,String psf){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return;
        }
         matrix[sr][sc]=2;    //mark
        if(sc<dc && matrix[sr][sc+1]==0 && matrix[sr][sc+1]!=2){
            floodsir(matrix, sr, sc+1, dr, dc, psf+"r");
        }
        if(sr<dr && matrix[sr+1][sc]==0&& matrix[sr+1][sc]!=2){
            floodsir(matrix, sr+1, sc, dr, dc, psf+"b");
       }
       if(sc>0 && matrix[sr][sc-1]==0&& matrix[sr][sc-1]!=2){
        floodsir(matrix, sr, sc-1, dr, dc, psf+"l");
         
       }
       if(sr>0 && matrix[sr-1][sc]==0&& matrix[sr-1][sc]!=2){
        floodsir(matrix, sr-1, sc, dr, dc, psf+"t");
       }
       matrix[sr][sc]=0;     //unmark
   }
        public static void main(String [] args){
        // spath(7,"");
        // kpc("835","");
       //  mazepath1(0,0,2,3,"");
        // mazepath2(0,0,3,3,"");
         int [] arr={3,2,0,4,1,2,0,2,3,0,1};
         int [][] arr1={{1,0,1,0,},{0,0,0,0},{1,0,0,1,0,0}};
        // stairpath2(arr, 0, "");
         int [][] matrix={{0,1,0,0,0,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,1,1,0,0,0,0},
                          {0,0,0,0,0,0,1,1,1},
                          {0,1,0,1,1,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,0,0,0,0,0,0}};
                  int [][] visited=new int[matrix.length][matrix[0].length];
                       //   flood(matrix, 0, 0, matrix.length-1 ,matrix[0].length-1,"",visited);
                          floodsir(matrix, 0, 0, matrix.length-1 ,matrix[0].length-1,"");
    }
}