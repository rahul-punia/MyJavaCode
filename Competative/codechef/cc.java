
import java.util.*;

public class cc {
   public static class pair{
       int c,d;
       pair(int c,int d){this.c=c; this.d=d;}
      
            @Override
        public boolean equals(Object o){
            if(o instanceof pair){
            pair ct = (pair)o;
            return d == ct.d && c == ct.c;
            }
            return false;
        }
   }

     public static void main(String[] args) {

        // int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] arr={{1,2,3,4},{5,6,7,8}};

        int n=arr.length;
        int m=arr[0].length;
        ArrayList<Boolean> list=new ArrayList<>();

        for(int gap=0;gap<n;gap++){
            int pval=Integer.MAX_VALUE;
            boolean flag=true;
            for(int i=gap,j=0;i<n && j<m;i++,j++){
                // if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
                // else{pval=arr[i][j];}
                System.out.print(arr[i][j]+"  ");
            }
            list.add(0,flag);
            System.out.println();
        }
        for(int gap=1;gap<m;gap++){
            int pval=Integer.MAX_VALUE;
            boolean flag=true;
            for(int i=0,j=gap;i<n && j<m;i++,j++){
                // if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
                // else{pval=arr[i][j];}
                System.out.print(arr[i][j]+"  ");
            }
            list.add(flag);
            System.out.println();
        }


        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
            // int n=scn.nextInt();
            int k=scn.nextInt();
            
            // ArrayList<Integer> list=new ArrayList<>();
            PriorityQueue<pair> maxpq=new PriorityQueue<>(
                new Comparator<pair>(){
                    public int compare(pair p1,pair p2){
                        return p2.d-p1.d;
                    }
                }
            );
            PriorityQueue<pair> minpq=new PriorityQueue<>(
                new Comparator<pair>(){
                    public int compare(pair p1,pair p2){
                        return p1.d-p2.d;
                    }
                }
            );

            for(int i=0;i<=n;i++){int d=scn.nextInt();
                pair np=new pair(i, d);
                 maxpq.add(np); 
                 minpq.add(np);
                }


            // Collections.sort(list,(p1,p2)->p1.d-p2.d);

            while(maxpq.size()>0 || minpq.size()>0){
                pair rem=minpq.remove();
                maxpq.remove(rem); //v.imp
                   
                if(rem.d==k){
                    System.out.println(rem.c+" "+rem.d+" "+(n-1)+" "+0);
                    // list.add(rem.c);
                }else if(rem.d>k){
                    pair np=new pair(rem.c,rem.d-k);
                    minpq.add(np);  
                    maxpq.add(np);
                    System.out.println(rem.c+"  "+k+" "+(n-1)+" "+0);
                }else if(maxpq.size()>0){
                    pair rem2=maxpq.remove();
                    minpq.remove(rem2);
                    // System.out.println("size="+minpq.size());
                    if(rem2.d+rem.d>k){
                        pair np=new pair(rem2.c,rem2.d+rem.d-k);
                        minpq.add(np);  
                        maxpq.add(np);
                        // list.add(rem.c);
                    }else{
                        // list.add(rem.c); list.add(rem2.c);
                    }
         System.out.println(rem.c+" "+rem.d+" "+rem2.c+" "+(k-rem.d));

                }
            
            // System.out.println(maxpq.size()+"      "+minpq.size()+"         "+rem.d);
            }
        }
        }
    }







            // int m=scn.nextInt();
            
            // int[] A=new int[n];
            // int[] B=new int[m];
            //     int min=Integer.MAX_VALUE;
            // for(int i=0;i<n;i++){A[i]=scn.nextInt();  min=Math.min(min,A[i]);}
            // int ans=0;
            // for(int i=0;i<m;i++){B[i]=scn.nextInt(); if(B[i]<min){ans+=n;}}
            
            // System.out.println(ans);
//     }
// }
