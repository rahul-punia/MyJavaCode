import java.util.*;

public class allalphcodes{
    public static void Encodings(String str,int idx,String psf){
   if(idx==str.length()-1){
     
   }
       for(int i=0;i<str.length()-1;i++){
           for(int j=i+1;j<str.length();j++){
            str.substring(i, i+1);
            str.substring(i+1,str.length());
           }
        }

    }
    public static void main(String [] args){
       Encodings("1123",0,"");
    }
}