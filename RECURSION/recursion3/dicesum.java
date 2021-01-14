import java.util.*;

public class dicesum{
    static int [] arr={1,2,3,4,5,6};
   public static void main(String[] args) {
        dice(0, 6, "");
    }
    public static void dice(int sum,int targ,String psf){
   if(sum==targ){

       System.out.println(psf);
       sum=0;
       return;
   }else if(sum>targ){
       sum=0;
       return;
   }

   
   for(int i=0;i<arr.length;i++){
    if(sum<targ){
       dice(sum+arr[i], targ, psf+arr[i]);
   }
}
    }
}
