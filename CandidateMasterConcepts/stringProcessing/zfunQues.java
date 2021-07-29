import java.util.*;

public class zfunQues {
    
    public static int[] zfunction(char[] s){
        int[] z=new int[s.length];
        int n=s.length;
        int l=0,r=0;
        
        for(int i=0;i<n;i++){
         if(i>r){
             l=i; r=i;
             while(r<n && s[r-l]==s[r]){r++;}
             z[i]=r-l; r--;
         }else{
             int k=i-l;
             if(z[k]<(r-i+1)){z[i]=z[k];}
             else{
                 l=i;
                 while(r<n && s[r-l]==s[r]){r++;}
                 z[i]=r-l; r--;
             }
         }    
        }
        
        return z;
    }
    
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.next();
        
        char[] s=str.toCharArray();
        int[] z=zfunction(s);
        int n=s.length;
        int maxz=0;
        int res=-1;
        for(int i=1;i<n;i++){
            if(z[i]==(n-i) && maxz>=(n-i)){res=n-i; break;}
            maxz=Math.max(maxz,z[i]);
        }
        
        if(res==-1){
            System.out.println("Just a legend");
        }else{
            System.out.println(str.substring(0,res));  
        }
    }
}


//zfunQues