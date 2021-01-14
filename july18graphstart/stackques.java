import java.util.*;
public class stackques{

    static void printsmall(String str){
        Stack<Character> st=new Stack<>();
        int ct=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='d'){
                ct++;
                st.push(str.charAt(i));
            }else if(str.charAt(i)=='i'){
                ct++;
                int p=ct;
                st.push(str.charAt(i));
                
              while(st.size()>0){
                System.out.print(p);
                st.pop();
                 p--;

              }
             }
        }
        int p=str.length();
                while(st.size()>0){
                    System.out.print(p);
                    st.pop();
                     p--;
    
                  }
    }

public static void main(String [] args){
    Scanner scn=new Scanner(System.in);
    String str=scn.nextLine();
    printsmall(str);
}
}