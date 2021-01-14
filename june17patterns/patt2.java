import java.util.*;

public class patt2{
    public static void main(String [] args){
        int n=6;
       
       
        for(int r=0;r<n;r++){
            int nck =1;
            for(int c=0;c<=r;c++){
                System.out.print(nck);
                nck=nck*(r-c)/(c+1);
     
            }
            System.out.println();
        }

    }
}