import java.util.*;

public class kmpQ2 {
    //Here we discuss two problems at once. Given a string s of length n. In the first variation of the 
    // problem we want to count the number of appearances of each prefix s[0…i] in the same string. 
    // In the second variation of the problem another string t is given and we want to count the number 
    // of appearances of each prefix  s[0…i] in t.
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

        int n=str.length();
        int[] ans=new int[n+1];
       // Here for each value of the prefix function we first count how many times it occurs in the array
       // π, and then compute the final answers: if we know that the i length prefix  appears exactly 
       //ans[i] times, then this number must be added to the number of occurrences of its longest suffix 
       //that is also a prefix. At the end we need to add 1 to each result, since we also need to count 
       //the original prefixes also.
        for(int i=0;i<n;i++){
            ans[pi[i]]++;
        }
        for(int i=n-1;i>0;i--){
            ans[pi[i-1]]+=ans[i];  //pi[i-1] bcz string has zero base indexing but i has 1 base indexing
        }

        for(int i=0;i<=n;i++){ans[i]++;}
        System.out.println("prefix           freq");
        for(int i=1;i<=n;i++){
            String prefix=str.substring(0, i);
            System.out.println(prefix+"  "+ans[i]);
        }
        System.out.println();
    }
}
