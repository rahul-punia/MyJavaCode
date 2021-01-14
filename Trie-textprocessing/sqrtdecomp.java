import java.util.*;

public class sqrtdecomp{
    static int sob;
    static int nob;
    static int[] oa;
    static int[] sa;

    public static void build(int[] arr){
        sob=(int)(Math.sqrt(arr.length));
        nob=arr.length/sob;
        oa=arr;
       
        sa=new int[nob];
        for(int i=0;i<arr.length;i++){
            int bi=i/sob;
            sa[bi]+=oa[i];
        }
    }

    public static void update(int val,int idx){
        int oldval=oa[idx];
        int delta=val-oldval;
        int bi=idx/sob;
        sa[bi]+=delta;
        oa[idx]=val;
    }
    public static int query(int l,int r){
        int lbi=l/sob;
        int rbi=r/sob;

        if(lbi==rbi){
            return trivialsum(l,r);
        }
         int sum=0;
        for(int i=l;i/sob==lbi;i++){
          sum+=oa[i];
        }

        for(int i=lbi+1;i<=rbi-1;i++){
            sum+=sa[i];
        }

        for(int i=r;i/sob==rbi;i--){
            sum+=oa[i];
        }
      return sum;
    }

    public static int trivialsum(int l,int r){
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=oa[i];
        }
        return sum;
    }
    public static void main(String[] args){
        int[] arr=new int[49];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(100*Math.random());
        }
        build(arr);
        System.out.println(Arrays.toString(arr));
        System.out.print(query(35, 45)+" ");System.out.println(trivialsum(35, 45));
        System.out.print(query(5, 25)+" ");System.out.println(trivialsum(5, 25));
        update(37, 6);
        System.out.println(Arrays.toString(arr));
        System.out.print(query(5, 25)+" ");System.out.println(trivialsum(5, 25));
        }
}