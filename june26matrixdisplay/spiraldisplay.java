import java.util.*;

public class spiraldisplay{
    public static void main(String [] args){
        int [][] arr={{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35},{41,42,43,44,45}};
        int r=0;
        int c=0;
        int rmn=0;
        int cmn=0;
        int rmx=arr.length-1;
        int cmx=arr[0].length-1;

        int tne=arr.length*arr[0].length;
        int ct=1;
        
        while(ct<=tne){

            //left wall
            for(int i=rmn;i<=rmx;i++){
                System.out.print(arr[i][cmn]+" ");
                ct++;
            }
            cmn++;
        
            //b w
            for(int j=cmn;j<=cmx;j++){
                System.out.print(arr[rmx][j]+" ");
                ct++;
            }   rmx--;
            
            //r w
            for(int i=rmx;i>=rmn;i--){
                System.out.print(arr[i][cmx]+" ");
                ct++;
            }     cmx--;
          
            //t w
            for(int j=cmx;j>=cmn;j--){
                System.out.print(arr[rmn][j]+" ");
                ct++;
            }
            rmn++;
        }

        // while(ct<te){
        //     d=d%4;
        //     //b w
        //     if(d==0){
        //         while(r<i){
        //     System.out.println(arr[r][c]);
        //     r++;
        //     ct++;
        //     }
        //     i--;
        //     d++;
        //    r--;
        //    c++;
        //     }
        //     // r w
        //     if(d==1){
        //         while(c<j){
        //     System.out.println(arr[r][c]);
        //     c++;
        //     ct++;
        //     }
        //     j--;
        //     d++;
        //     c--;
        //     r--;
        //     }
        //     //t w
        //     if(d==2){
        //         while(r>=imn){
        //     System.out.println(arr[r][c]);
        //     r--;
        //     ct++;
        //     }
        //     imn++;
        //     d++;
        //     r++;
        //     c--;
        //     }
        //     //l w
        //     if(d==3){
        //         while(c>=jmn){
        //     System.out.println(arr[r][c]);
        //     c--;
        //     ct++;
        //     }
        //     jmn++;
        //     d++;
        //     c++;



        //     }


        // }
    }}