import java.util.*;

public class kmpQ3 {
    //problem- https://www.spoj.com/problems/DISUBSTR/
    //Given a string s of length n. We want to compute the number of different substrings appearing in it
    public static int prefixfun(String str){
        char[] s=str.toCharArray();
        int n=s.length;
        int[] pi=new int[n];
        pi[0]=0;
        int pimax=0;
        for(int i=1;i<n;i++){
            int j=pi[i-1];
            while(j>0 && s[j]!=s[i]){j=pi[j-1];}
            if(s[i]==s[j]){j++;}
            pi[i]=j;
            pimax=Math.max(pimax, pi[i]);
        }

        return pimax;
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        int ans=0;
        int n=str.length();
        String ss="";
        for(int i=n-1;i>=0;i--){
            ss=str.charAt(i)+ss;
            int pimax=prefixfun(ss);
            ans+=ss.length()-pimax;
        }

        System.out.println(ans);
    }
}
