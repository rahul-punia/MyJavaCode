import java.util.*;

public class crypto{
    static int counter=0;
    static int getnum(String s,int [] map){
        int num=0;
        int pv=1;//place value
        for(int i=s.length()-1;i>=0;i--){
         num+=pv*map[s.charAt(i)-97];
         pv*=10;
        }
        return num;
    }
    static String unique(String s1,String s2,String s3){
        boolean[] duplicates=new boolean[26];
         String ans="";

         for(char ch:s1.toCharArray()){
          if(duplicates[ch-97]==false){      //97='a'
              ans+=ch;
              duplicates[ch-97]=true;
          }
         }

         for(char ch:s2.toCharArray()){
            if(duplicates[ch-97]==false){
                ans+=ch;
                duplicates[ch-97]=true;
            }
           }
           for(char ch:s3.toCharArray()){
            if(duplicates[ch-97]==false){
                ans+=ch;
                duplicates[ch-97]=true;
            }
           }
     return ans;
    }
    static void generatemapping(String unique,int [] map, boolean [] takennumber){
        if(unique.length()==0){
            int n1=getnum(s1, map);
            int n2=getnum(s2, map);
            int n3=getnum(s3, map);
         if(n1+n2==n3){
           System.out.print(++counter+". ");
           for(int i=0;i<map.length;i++){
               if(map[i]!=-1){
                   System.out.print((char)(i+97)+" = "+map[i]+", ");
               }//here we donot do (num-1) like encoding to change in character b/z we start mapping from zero index
           }
           System.out.println();
         }
         return;
        }
        char ch=unique.charAt(0);
        String ros=unique.substring(1,unique.length());
       for(int op=0;op<=9;op++){     //loop on option
           if(takennumber[op]==false){
               map[ch-97]=op;
               takennumber[op]=true;
               generatemapping(ros, map,takennumber);
               takennumber[op]=false;
               map[ch-97]=-1;
           }
       }
    }
    static String s1,s2,s3;
    public static void main(String [] args){
        Scanner scn=new Scanner(System.in);
        s1=scn.next();
        s2=scn.next();
        s3=scn.next();
        String unique=unique(s1,s2,s3);
        int [] map=new int[26];
        Arrays.fill(map, -1);
        boolean [] takenumber=new boolean[10];
        generatemapping(unique,map,takenumber);
        
    }
}