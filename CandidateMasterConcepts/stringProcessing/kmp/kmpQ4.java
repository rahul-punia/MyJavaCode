import java.util.*;
//HackerRank Intern Question => In Visa and Atlansian tests
public class kmpQ4 {
    //Given a string s of length n. We want to find the shortest "compressed" representation of the string, 
    //i.e. we want to find a string t of smallest length such that s can be represented as a concatenation of one or more copies of t.

    //It is clear, that we only need to find the length of t. Knowing the length, the answer to the problem
    // will be the prefix of s with this length
    //Let us compute the prefix function for s. Using the last value of it we define the value k=n−π[n−1]. 
    //We will show, that if k divides n, then k will be the answer, otherwise there doesn't exists an 
    //effective compression and the answer is n.

    //Let n be divisible by k. Then the string can be partitioned into blocks of the length k. 
    //By definition of the prefix function, the prefix of length n−k will be equal with its suffix. 
    //But this means that the last block is equal to the block before. And the block before has to be
    // equal to the block before it. And so on. As a result, it turns out that all blocks are equal, 
    //therefore we can compress the string s to length k


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
        // for(int val:pi){System.out.print(val+" ");}

        int k=n-pi[n-1];
        if(n%k==0 && k<n){
            System.out.println(str.substring(0, k));
        }else{
            System.out.println(str);
        }
        System.out.println();

    }
}
