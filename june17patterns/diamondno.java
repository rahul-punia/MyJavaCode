import java.util.*;
public class diamondno{
    public static void main(String [] args){
     int n=7;
     int sp=n/2;
     int st=1;
     int no=1;

     for(int r=1;r<=n;r++){
            
            for(int s=1;s<=sp;s++){
                System.out.print(" ");
            }
            for(int sr=1;sr<=st;sr++){

                System.out.print(no); 
                
                if(sr<=st/2){
                    no++;
                }else if(sr<st){
                    no--;
                }
            }
            for(int s=1;s<=sp;s++){
                System.out.print(" ");
            }
           
            if(r<=n/2){
                sp--;
                st+=2;
                no++;
            }else{
                sp++;
                st-=2;
                no--;
            }

        System.out.println();
        
     }
    }
}