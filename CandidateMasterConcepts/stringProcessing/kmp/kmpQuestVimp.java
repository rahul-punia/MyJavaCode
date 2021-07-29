import java.util.*;

public class kmpVimp {
    
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int w=scn.nextInt();
        int i=0,j=0;
        int[] a=new int[n],b=new int[w];

        for(i=0;i<n;i++){a[i]=scn.nextInt();}
        for(i=0;i<w;i++){b[i]=scn.nextInt();}
        
        int[] c=new int[n-1],d=new int[w-1];

        for(i=0;i<n-1;i++){
            c[i]=a[i+1]-a[i];
        }
        for(i=0;i<w-1;i++){
            d[i]=b[i+1]-b[i];
        }
        if(w==1){
            System.out.println(n); return;
        }
        int[] pi=new int[w-1];
        // System.out.println("Rahul");
       
        for(i=1;i<w-1;i++){
             j=pi[i-1];
            while(j>0 && d[i]!=d[j]){j=pi[j-1];}
            if(d[i]==d[j]){j++;}  //v.v.imp
            pi[i]=j;
        }
        // or 
        // for(i=1;i<w-1;i++){
        //     int k=pi[i-1];
        //     while(true){
        //         if(d[i]==d[k]){
        //             pi[i]=k+1; break;
        //         }
        //         if(k==0) break;
        //         k=pi[k-1];
        //     }
        // }
        // System.out.println("Rahul");


        int ans=0;
        j=0;
        for(i=0;i<n-1;i++){
            if(j==(w-1)){j=pi[j-1]; ans++;}

            if(c[i]==d[j]){j++; continue;}
            if(j==0){continue;};

            j=pi[j-1];
            i--; //keep i at same position
        }

        if(j==(w-1)){j=pi[j-1]; ans++;}

        System.out.println(ans);
    }
}
