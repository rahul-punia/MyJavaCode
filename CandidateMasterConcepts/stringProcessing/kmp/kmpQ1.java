import java.util.*;

public class kmpQ1 {
    //Quest-1 Given a text t and a string s, 
   //we want to find and display the positions of all occurrences of the string s in the text t ?
    
  //for Space optimization
//   As already mentioned in the description of the prefix function computation, if we know that the prefix 
//   values never exceed a certain value, then we do not need to store the entire string and the entire 
//   function, but only its beginning. In our case this means that we only need to store the string s+# 
//   and the values of the prefix function for it. We can read one character at a time of the string t 
//   and calculate the current value of the prefix function

   public static ArrayList<Integer> prefixfun(String p,String t){
    String nstr=p+"@"+t;   
    char[] s=nstr.toCharArray();
    int n=s.length;
    int[] pi=new int[n];
    pi[0]=0;
    ArrayList<Integer> list=new ArrayList<>();

    for(int i=1;i<n;i++){
        int j=pi[i-1];
        while(j>0 && s[j]!=s[i]){j=pi[j-1];}
        if(s[i]==s[j]){j++;}
        pi[i]=j;
        if(pi[i]==p.length()){list.add(i-(2*p.length())+1);}
    }

    return list;
}

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        // String str=scn.next();
      String p="abc"; //pattern
      String t="abcdabceabcd";  //text
      
      ArrayList<Integer> list=prefixfun(p, t);
        System.out.println(list);
    }    
}
