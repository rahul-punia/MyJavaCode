import java.util.*;

public class pap{
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        for(int i=1;i<=n;i++){
            int num=scn.nextInt();
            boolean flag=true;
            for(int div=2;div*div<=num;div++){
                if(num%div==0){
                flag=false;
                break;
                }
            }
            if(flag==false){
                System.out.println(num+"is not prime");
            }else{
                       System.out.println(num+"is  prime");
             
                }
        }
    }
}