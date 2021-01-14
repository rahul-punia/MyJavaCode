import java.util.*;

public class inverse{
    public static void main(String [] args){
        int n=316245;
        int sum=0;
        int ct=0;
        while(n!=0){
            int rem=n%10;
            n=n/10;
            ct++;
            sum+=ct*Math.pow(10, rem-1);


        }
        System.out.println(sum);
    }
}