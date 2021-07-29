import java.util.*;
import java.io.*;
import java.lang.*;

public class kmpApplication {

    public static void allOccurance(String t,String s){
        String nstr=s+"#"+t;
        int n=s.length();

        int[] pi=new int[n];

        char[] ns=nstr.toCharArray();

        int lpi=0;  //last i pi value
        for(int i=1;i<ns.length;i++){
            int j=lpi;

            while(j>0 && ns[i]!=ns[j]){
                j=pi[j-1];
            }

            if(ns[i]==ns[j]){j++;}

            if(i<n){pi[i]=j;}

            lpi=j;
            if(j==n){
                System.out.println((i-(2*n)));
            }
        }
    }

    //Compressing a string
    //Given a string s of length n. We want to find the shortest "compressed" representation of the string, 
    //i.e. we want to find a string t of smallest length such that s can be represented as a concatenation of one or more copies of t.


    public static int[] prefix_function(String str){
        int n=str.length();
        int[] pi=new int[n];

        char[] s=str.toCharArray();

        for(int i=1;i<n;i++){
            int j=pi[i-1];
            
            while(j>0 && s[i]!=s[j]){
                j=pi[j-1];
            }

            if(s[i]==s[j]){j++;}

            pi[i]=j;
        }

        return pi;
    }

    public static void compressString(String str){

        int[] pi=prefix_function(str);
        int n=str.length();
        int k=n-pi[n-1];

        String ans=str;
        if(n%k==0){
            ans=str.substring(0, k);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {

        allOccurance("abcdabcdabcdrrryryryryrabcd", "abcd");

        compressString("aaaaaaaaaaaaaaa");//abcdabcdabcdabcd
    }
}
