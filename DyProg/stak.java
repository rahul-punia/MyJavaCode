import java.util.*;

public class stak{
    public static int evalute(int v1,int v2,char op){
        int res=0;
        switch(op){
            case '+':
            res=v1+v2;
            break;
            case '-':
            res=v1-v2;
            break;
            case '/':
            res=v1/v2;
            break;
            case '*':
            res=v1*v2;
            break;
            case '^':
            res=(int)Math.pow(v1, v2);
            break;
        }
        return res;
    }

    public static void postevaluate(String str){
        Stack<Integer> st=new Stack<>();

        for(int i=0;i<str.length();i++){
         char ch=str.charAt(i);
         if(ch>='0' && ch<='9'){
         st.push(ch-48);
         }else{
             int v2=st.pop();
             int v1=st.pop();
             st.push(evalute(v1,v2,ch));
         }
        }
        while(st.size()>0){
            System.out.println(st.pop());
        }
    }
    
    public static void postinfixpre(String str){
        Stack<String> st=new Stack<>();
        Stack<String> st1=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='0'&& ch<='9'){
                st.push(""+ch);
                st1.push(""+ch);
            }else{
                String v2=st.pop();
                String v1=st.pop();
                st.push(v1+ch+v2);
                String v21=st1.pop();
                String v11=st1.pop();
                st1.push(ch+v11+v21);

            }
        }
        while(st.size()>0){
            System.out.println(st.pop());
        }
        while(st1.size()>0){
            System.out.println(st1.pop());
        }
    }
    public static void preevalute(String str){
        Stack<Integer> st=new Stack<>();

        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch>='0' && ch<='9'){
                st.push(ch-48);
            }else{
                int v1=st.pop();
                int v2=st.pop();
                st.push(evalute(v1, v2, ch));
            }
        }
        while(st.size()>0){
            System.out.println(st.pop());
        }
    }
    public static void preinfixpost(String str){
        Stack<String> st=new Stack<>();
        Stack<String> pst=new Stack<>();
        for(int i=str.length()-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch>='0' && ch<='9'){
                st.push(""+ch);
                pst.push(""+ch);
            }else{
             String v1=st.pop();
             String v2=st.pop();
             st.push("("+v1+ch+v2+")");

             String pv1=pst.pop();
             String pv2=pst.pop();
             pst.push(pv1+pv2+ch);
            }
        }
        while(st.size()>0){
            System.out.println(st.pop());
        }
        while(pst.size()>0){
            System.out.println(pst.pop());
        }
        
    }

    public static void main(String[] args){
      postevaluate("243*-");
      postinfixpre("243*-");
      preevalute("-/24^32");
      preinfixpost("-/24^32");

    }
}