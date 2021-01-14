import java.util.*;

public class subseq{

    public static void sseq(String ques,String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch=ques.charAt(0);
        String roq=ques.substring(1,ques.length());

        sseq(roq,ans+"-");
        sseq(roq,ans+ch);
    }
    public static void main(String [] args){
       sseq("abc","");
       
    }
}