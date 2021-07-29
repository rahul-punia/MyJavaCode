import java.util.*;

public class kmp {
    //space optimization
    // This is an online algorithm, i.e. it processes the data as it arrives - for example, you can read the
    //  string characters one by one and process them immediately, finding the value of prefix function 
    //  for each next character. The algorithm still requires storing the string itself and 
    //  the previously calculated values of prefix function, but if we know beforehand 
    //  the maximum value M the prefix function can take on the string, we can store only 
    //  M+1 first characters of the string and the same number of values of the prefix function.
    public static int[] prefixfun(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int[] pi=new int[n];
        pi[0]=0;

        for(int i=1;i<n;i++){
            int j=pi[i-1];
            while(j>0 && s[j]!=s[i]){j=pi[j-1];}
            if(s[i]==s[j]){j++;}
            pi[i]=j;
        }

        return pi;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        int[] pi=prefixfun(str);

        for(int val:pi){System.out.print(val+" ");}
        System.out.println();

    }
}
