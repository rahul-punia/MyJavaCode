import java.util.*;

public class HMrev{
    static void hfc(String str){
        HashMap<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
            }else{
                hm.put(ch, 1);
            }
        }
        char mfc=str.charAt(0);          //max frequency character
        for(char ch:str.toCharArray()){
            if(hm.get(ch)>hm.get(mfc)){
                mfc=ch;
            }
        }
        System.out.println(mfc);
    }

    public static void main(String[] args){
      String str="aghhsshcjldkcncss";
      hfc(str);
    }
}
