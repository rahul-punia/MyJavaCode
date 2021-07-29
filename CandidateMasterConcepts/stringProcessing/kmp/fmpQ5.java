import java.util.*;


public class fmpQ5 {
 
    public static int prefixfun(int[] horac,int[] bear){
        if(horac.length==1){return bear.length;}
        // String nstr=p+"@"+t;   
        // char[] s=nstr.toCharArray();
        int[] narr
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
        String str=scn.next();
      String p="abc"; //pattern
      String t="abcdabceabcd";  //text
      
      ArrayList<Integer> list=prefixfun(p, t);
        System.out.println(list);
    }
}
