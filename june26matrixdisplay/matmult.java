import java.util.*;

public class matmult{
    public static void main(String [] args){
        int [][] mat1={{1,0,1},{0,1,1}};
        int [][] mat2={{1,0,2,2},{0,1,5,6},{1,2,4,5}};//{{11,12,13,14},{21,22,23,24},{31,32,33,34},{41,42,43,44}};
        int [][] res=new int[mat1.length][mat1[0].length];

        int r1=mat1.length;
        int c1=mat1[0].length;
        int r2=mat2.length;
        int c2=mat2[0].length;

        if(c1!=r2){
            System.out.println("Matrix multipication not possible");
            return;
        }

        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[0].length;j++){
                res[i][j]=0;
                for(int k=0;k<mat2.length;k++){
                    res[i][j]+=mat1[i][k]*mat2[k][j];
                }

            }
        }
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }}