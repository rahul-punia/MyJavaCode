import java.util.*;

public class subseq{
    public static void main(String [] args){
        String str="abcd";
       ArrayList<String> list=getss(str);
       System.out.println(list);
    }
   public static ArrayList<String> getss(String str){
       if(str.length()==0){
        ArrayList<String> bres=new ArrayList<>();
        bres.add("");
        return bres;
       }
       char ch=str.charAt(0);
       String ros=str.substring(1,str.length());
       ArrayList<String> rres=getss(ros);
       ArrayList<String> mres=new ArrayList<>();

       for(int i=0;i<rres.size();i++){
           String rstr=rres.get(i);
           mres.add("_"+rstr);
           mres.add(ch+rstr);

       }
      return mres;
   }
}