import java.util.*;
public class card {
    static class pair{
        int val,card;
        pair(int val,int card){
            this.val=val; this.card=card;
        }
    }
    static class myComparator implements Comparator<pair>{
        public int compare(pair p1,pair p2){
            if(p1.card<p2.card){
                return -1;
            }else if(p1.card>p2.card){
                return 1;
            }else{
                return p1.val-p2.val;
            }
        }
    }
    public static void myfun(int[] arr){
    pair[] marr=new pair[arr.length];
    
    for(int i=0;i<arr.length;i++){
        String str=Integer.toBinaryString(arr[i]);
        int ct=0;
        for(int j=0;j<str.length();j++){
              if(str.charAt(j)=='1')ct++;  
        }
        marr[i]=(new pair(arr[i],ct));
     }

      Arrays.sort(marr,new myComparator());

      for(int i=0;i<arr.length;i++){
          System.out.print(marr[i].val+" ");
      }      
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4};
       myfun(arr);
    }
}
