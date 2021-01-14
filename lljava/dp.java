import java.util.*;
public class dp {
    
    public static long fibonacci(int n){
        if(n==0 ||n==1){
            return n;
        }
        long fnm1=fibonacci(n-1);;
        long fnm2=fibonacci(n-2);
        long fn=fnm1+fnm2;
        return fn;
    }
    public static long fibonaccimemo(int n,long[] qb){
        if(n==0 ||n==1){
            return n;
        }
        if(qb[n]!=0){
            return qb[n];
        }
        long fnm1=fibonaccimemo(n-1,qb);;
        long fnm2=fibonaccimemo(n-2,qb);
        long fn=fnm1+fnm2;
        qb[n]=fn;
        return fn;
    }
   
    public static long climbstair(int n){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        
        long pfnm1=climbstair(n-1);
        long pfnm2=climbstair(n-2);
        long pfnm3=climbstair(n-3);

        long pfn=pfnm1+pfnm2+pfnm3;  //same as fibonacci
        return pfn;
    }

    public static long climbstairmemo(int n,long[] qb){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(qb[n]!=0)return qb[n];

        long pfnm1=climbstairmemo(n-1,qb);
        long pfnm2=climbstairmemo(n-2,qb);
        long pfnm3=climbstairmemo(n-3,qb);

        long pfn=pfnm1+pfnm2+pfnm3;  //same as fibonacci
        qb[n]=pfn;
        return pfn;
    }


    public static void climbupltr(int[] arr){
        int[] strg=new int[arr.length];
        strg[0]=1;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<=arr[i];j++){
                if((i+j)<arr.length){
                    strg[i+j]+=strg[i];
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(strg[i]+" ");
        }
    }

    public static void climbuprtl(int[] arr){
        int n=arr.length;
        int[] strg=new int[n];
        strg[n-1]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=arr[i];j++){
                if((i+j)<arr.length){
                    strg[i]+=strg[i+j];
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(strg[i]+" ");
        }
    }

    public static void climbuprtlMinstep(int[] arr){
        int n=arr.length;
        int[] strg=new int[n];
        strg[n-1]=0;

        for(int i=n-2;i>=0;i--){
            int mins=n;
            for(int j=1;j<=arr[i];j++){
                if((i+j)<arr.length){
                    mins=Math.min(strg[i+j],mins);
                }
            }
            strg[i]=mins+1;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(strg[i]+" ");
        }
        ArrayList<Integer> list=new ArrayList<>();
        list.add(0);
        printAllPath(arr,strg,0,list);
    }

    public static void printAllPath(int[] arr,int[] strg,int idx,ArrayList<Integer> list){
       if(idx==strg.length-1){
           System.out.println(list);
           return;
       }

       for(int j=idx+1;(j<=idx+arr[idx] && j<arr.length);j++){
           if(strg[idx]-1==strg[j]){
               list.add(j);
               printAllPath(arr,strg, j, list);
               list.remove(list.size()-1);
           }
       }
    }

    public static void mincost(int[][] cost){
        int m=cost.length;
        int n=cost[0].length;
        int[][] strg=new int[m][n];

        for(int i=strg.length-1;i>=0;i--){
            for(int j=strg[0].length-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    strg[i][j]=0;
                }else
                if(i==m-1){
                    strg[i][j]=strg[i][j+1]+cost[i][j];
                }else if(j==n-1){
                    strg[i][j]=strg[i+1][j]+cost[i][j];
                }else{
                    strg[i][j]=Math.min(strg[i+1][j], strg[i][j+1])+cost[i][j];
                }
            }
        }
        // printmincostPath(strg,cost,i,j);
    }
  static class bfsPair{
      int i,j;
      String path;
      bfsPair(int i,int j,String path){
          this.i=i; this.j=j; this.path=path;
      }
    }
    public static void printmincostPath(int[][] strg,int[][] cost,int i,int j,String psf){
       if(i==strg.length-1 && j==strg[0].length-1){
           System.out.println(psf);
           return;
       }
    //using backtracking
       if((i+1)<strg.length && strg[i][j]-cost[i][j]==strg[i+1][j]){
           printmincostPath(strg, cost, i+1, j, psf+"->"+cost[i][j]);
       }
       if((j+1)<strg[0].length && strg[i][j]-cost[i][j]==strg[i][j+1]){
        printmincostPath(strg, cost, i+1, j, psf+"->"+cost[i][j]);
    }

   //using bfs
   Queue<bfsPair> queue=new LinkedList<>();
   bfsPair bp=new bfsPair(i,j, psf+cost[i][j]); 

    while(queue.size()>0){
        bfsPair rem=queue.peek(); queue.remove();

        if(rem.i==strg.length-1 && j==strg[0].length-1){
            System.out.println(rem.path);
        }

        if((i+1)<strg.length && strg[i][j]-cost[i][j]==strg[i+1][j]){
            queue.add(new bfsPair(rem.i+1, rem.j,rem.path+cost[i][j]));
            // printmincostPath(strg, cost, i+1, j, psf+"->"+cost[i][j]);
        }
        if((j+1)<strg[0].length && strg[i][j]-cost[i][j]==strg[i][j+1]){
            queue.add(new bfsPair(rem.i, rem.j+1,rem.path+cost[i][j]));
        //  printmincostPath(strg, cost, i+1, j, psf+"->"+cost[i][j]);
     }
     }
    }

    public static void targetSumSubset(int[] arr,int targ){
        boolean[][] strg=new boolean[arr.length][targ+1];
        
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                if(j==0){
                    strg[i][j]=true;
                }else if(i==0){
                    if(j==arr[i])strg[i][j]=true;
                }else{
                    if(strg[i-1][j]){
                        strg[i][j]=true;
                    }else if(j-arr[i]>=0){
                        if(strg[i-1][j-arr[i]]){
                            strg[i][j]=true;
                        }    
                    }
                }
            }
        }

        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+"  ");
            }
            System.out.println();
        }
    }



    public static void longPaldSubseq(String str){
        int[][] strg=new int[str.length()][str.length()];

        for(int gap=0;gap<strg.length;gap++){
           for(int i=0,j=gap;j<strg[0].length;i++,j++){
                if(gap==0){
                    strg[i][j]=1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        strg[i][j]=strg[i+1][j-1]+2;
                    }else{
                        strg[i][j]=Math.max(strg[i+1][j],strg[i][j-1]);
                    }
                }
            }
        }
        System.out.println(strg[0][strg[0].length-1]);
    }

    public static void countsspld(String str){
        int[][] strg=new int[str.length()][str.length()];

        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j++){
                if(gap==0){
                    strg[i][j]=1;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        strg[i][j]=strg[i][j-1]+strg[i+1][j]+1;
                    }else{
                        strg[i][j]=strg[i][j-1]+strg[i+1][j]-strg[i+1][j-1];
                    }
                }
            }
        }
        System.out.println(strg[0][strg[0].length-1]);
    }

    public static void longestpld(String str){
        boolean[][] strg=new boolean[str.length()][str.length()];
        int ans=1;
        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j++){
               if(gap==0){
                   strg[i][j]=true;
               }else if(gap==1){
                if(str.charAt(i)==str.charAt(j)){
                    strg[i][j]=true;
                }
               }else{
                   if(str.charAt(i)==str.charAt(j) && strg[i+1][j-1]){
                        strg[i][j]=true;
                        ans=gap+1;
                   }
               }
            }
        }


        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }


    public static void countdistss(String str){
        int[] strg=new int[str.length()];
        int[] lastch=new int[26];
        lastch[(int)str.charAt(0)-'a']=1;
        strg[0]=2;
        for(int i=1;i<strg.length;i++){
            char ch=str.charAt(i);
            strg[i]=2*strg[i-1];
            int j=i-1;
            // while(j>0){
            //     if(str.charAt(j)==ch){
            //     strg[i]-=strg[j-1];  break;
            //     }
            //     j--;
            // }
            strg[i]-=lastch[(int)ch-'a'];
            lastch[(int)ch-'a']=strg[i-1];
        }
        for(int i=0;i<strg.length;i++){
        System.out.print(strg[i]+"  ");
        }
    }
     public static void main(String[] args) {
        int n=7;
    //     long st=System.currentTimeMillis();
    //     System.out.println(fibonacci(n)); 
    //    long[] qb=new long[n+1];
    //     System.out.println(fibonaccimemo(n, qb));
    //    long ed=System.currentTimeMillis();
    //     System.out.println(ed-st);
    //    System.out.println(climbstair(7));
    //    long[] qb=new long[n+1];
    //    System.out.println(climbstairmemo(n, qb));
    //    int[] arr={4,2,0,0,2,4,6,3,1,0,1,2,3,1,1};
    //    climbupltr(arr);
    //    System.out.println();
    //    climbuprtl(arr);
    //    System.out.println();
    //    climbuprtlMinstep(arr);
    //    int[] arr1={2,1,6,5,9};
    //    targetSumSubset(arr1,9);

       longPaldSubseq("abckycbc");
       String str="abckycbc";
       countsspld(str);
       longestpld("abccbc");

       countdistss("gfg");//ans-7
    }
}