import java.util.*;

public class pract {

    public static int stair(int n,int[] qb){
        if(n==0)return 1;
        if(n<1)return 0;
        if(qb[n]!=0)return qb[n];

        int fn1=stair(n-1, qb);
        int fn2=stair(n-2, qb);
        int fn3=stair(n-3, qb);

        return qb[n]=fn1+fn2+fn3;
    }
    public static void main(String[] args){
        System.out.println(stair(7,new int[8]));
    }
}
