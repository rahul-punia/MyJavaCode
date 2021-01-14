import java.util.*;

public class wave{
    public static void main(String [] args){
        int [][] arr={{11,12,13,14,15},{21,22,23,24,25},{31,32,33,34,35}};
        int r=0;
        int c=0;
        // while(c<arr[0].length && r<arr.length){
        //     while(r<arr[0].length){
        //         System.out.print(arr[r][c]+" ");
        //         r++;
        //         if(r==arr.length){
        //             c++;
        //             r--;
        //         }}
        //         while(r>=0){
        //             System.out.print(arr[r][c]+" ");
        //             r--;
        //             if(r==0){
        //                 c++;
        //             }

             //   }}
             for(int j=0;j<arr[0].length;j++){
                 if(j%2==0){
                     for(int i=0;i<arr.length;i++){
                         System.out.print(arr[i][j]+" ");
                     }
                 }
                 else if(j%2==1){
                     for(int i=arr.length-1;i>=0;i--){
                         System.out.print(arr[i][j]+" ");
                     }
                 }
             }
            


        

    }
}