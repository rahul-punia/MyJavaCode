import java.util.*;

public class lecture3{

    public static int countbinary(int n){
        int c0=1;
        int c1=1;
      
    
        for(int i=2;i<=n;i++){
         int newc0=c1;
         int newc1=c0+c1;
         c0=newc0;
         c1=newc1;
        }
       return c0+c1;
    }
    public static int encodings(String str){
        int[] strg=new int[str.length()];
        if(str.charAt(0)=='0'){
            return 0;
        }
        strg[0]=1;
        //strg[1]=2;
        for(int i=1;i<str.length();i++){
        if(i==1){
            if(str.charAt(i)=='1'){strg[i]=strg[0]+1;}
            else if(str.charAt(i-1)<'3' && str.charAt(i)<'6'){
             strg[i]=strg[0]+1;
         }else if(str.charAt(i-1)=='2' && str.charAt(i)>='6'){
            strg[i]=strg[0];
        }else if(str.charAt(i-1)>'3'){
             strg[i]=strg[0];
         }
         }else{
            if(str.charAt(i-1)<'3'&& str.charAt(i-1)!='0'&& str.charAt(i)!='0' && (str.charAt(i)+str.charAt(i-1)-'0')<='0'+26){
                strg[i]=strg[i-1]+strg[i-2];
            }else if(str.charAt(i-1)>='3' && str.charAt(i)!='0'){
               strg[i]=strg[i-1];
            }else if(str.charAt(i)=='0' && str.charAt(i-1)>'3'){
                strg[i]=0;
            }else if(str.charAt(i)=='0'&& str.charAt(i-1)<'3'&& str.charAt(i-1)!='0'){
                strg[i]=strg[i-2];  
            }else if(str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                strg[i]=strg[i-1];
             }
         }
        }

        for(int i=0;i<strg.length;i++){
            System.out.print(strg[i]+" ");
        }
        System.out.println();
        return strg[str.length()-1];
    }
    
    public static int countencoding(int[] arr){
        int[] strg=new int[arr.length];
        if(arr[0]==0){
            return 0;
        }
        strg[0]=1;
    
        if(arr[1]!=0){
            strg[1]=strg[0];
        }
        int num=arr[0]*10+arr[1];
        if(num>=10 && num<=26){
          strg[1]+=1;
        }
        for(int i=2;i<arr.length;i++){
            if(arr[i]!=0){
                strg[i]=strg[i-1];
            }
         num=arr[i-1]*10+arr[i];
        if(num>=10 && num<=26){
          strg[i]+=strg[i-2];
        }
        }
    
        return strg[arr.length-1];
    }
    public static int countss(String str){
        int ca=0;
        int cb=0;
        int cc=0;
    
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'){
                ca=2*ca+1;
            }else if(str.charAt(i)=='b'){
                cb=2*cb+ca;
            }else if(str.charAt(i)=='c'){
                cc=2*cc+cb;
            }
    
        }
    
        return cc;
    }
}