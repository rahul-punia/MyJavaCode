import java.util.*;

public class lecture1{
    public static  class mpair{
        int i;
        int j;
        String psf;
        mpair(int i,int j,String psf){
            this.i=i;
            this.j=j;
            this.psf=psf;
        }
    }
    public static int climbstairdown(int n,int [] qb){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(qb[n]!=0){
            return qb[n];
        }
          int cnm1=climbstairdown(n-1, qb);
          int cnm2=climbstairdown(n-2, qb);
          int cnm3=climbstairdown(n-3, qb);
          int ans=cnm1+cnm2+cnm3;
          qb[n]=ans;
          return ans;
            }

           
            public static int fibmemo(int n,int[] qb){
                if(n==0 || n==1){
                    return n;
                }
                if(qb[n]!=0){
                    return qb[n];
                }
                int fibnm1=fibmemo(n-1, qb);
                int fibnm2=fibmemo(n-2,qb);
                int fb=fibnm1+fibnm2;
                qb[n]=fb;
                return fb;
            }
            static int path=0;
        
            public static int stairpath2(int[] arr,int[] qb,int n){
                if(n==14){
                    return 1;
                }else if(n>14){
                    return 0;
                }else if(arr[n]==0){
                 return 0;
                }
                if(qb[n]!=0){
                    return qb[n];
                }
            for(int i=1;i<=arr[n];i++){
             path+=stairpath2(arr, qb, n+i);
            }
            qb[n]=path;
            return path;
            }
            public static int countpath(int[] arr){
                int[] strg=new int[arr.length];
        
                strg[strg.length-1]=1;
                for(int i=arr.length-2;i>=0;i--){
                    for(int j=i+1;j<=arr[i]+i && j<arr.length;j++){
                        strg[i]+=strg[j];
                    }
                }
                return strg[0];
            } 
            public static int minjump(int[] arr){
                int[] strg=new int[arr.length];
        
                strg[strg.length-1]=0;
                for(int i=arr.length-2;i>=0;i--){
                    int min=arr.length;
                    for(int j=i+1;j<=arr[i]+i && j<arr.length;j++){
                        min=Math.min(min,strg[j]);
                    }
                    strg[i]=min+1;
                }
                printminpath(arr,strg,0,"0");
           
                return strg[0];
            }
            public static void mazebfs(int[][] strg){
                boolean[][] visited=new boolean[strg.length][strg[0].length];//No need of visited here
                 Queue<mpair> q=new ArrayDeque<mpair>();
                mpair r=new mpair(0, 0, "");
                q.add(r);
        
        
               
                while(q.size()>0){
                    mpair rem=q.peek();
                    q.remove();
            
                    
            if(rem.i==strg.length-1 && rem.j==strg[0].length-1){
                        System.out.println(rem.psf);
                if(q.size()==1){
                    return;
                    }
                    }        
            // if(visited[rem.i][rem.j]==true){
            //     continue;
            // }
            // visited[rem.i][rem.j]=true;
            
                if(rem.i==strg.length-1){
                    mpair np=new mpair(rem.i, rem.j+1, rem.psf+"h");
                    q.add(np);  
                }else if(rem.j==strg[0].length-1){
                    mpair np=new mpair(rem.i+1, rem.j, rem.psf+"v");
                    q.add(np);  
                }else if(strg[rem.i+1][rem.j]<strg[rem.i][rem.j+1]){
                mpair np=new mpair(rem.i+1, rem.j, rem.psf+"v");
                q.add(np);
                }else if(strg[rem.i][rem.j+1]<strg[rem.i+1][rem.j]){
                    mpair np=new mpair(rem.i, rem.j+1, rem.psf+"h");
                    q.add(np);
                }else if(strg[rem.i+1][rem.j]==strg[rem.i][rem.j+1]){
                    mpair np=new mpair(rem.i+1, rem.j, rem.psf+"v");
                    q.add(np); 
                    mpair np1=new mpair(rem.i, rem.j+1, rem.psf+"h");
                    q.add(np1);
                }
              //  visited[rem.i][rem.j]=false;
                }
                
            }
        public static void printminpath(int[] arr,int[] strg,int i,String psf){
            if(i==strg.length-1) {
                System.out.println(psf);
                return;
            }
          
                for(int j=i+1;j<=arr[i]+i && j<arr.length;j++){
                    if(strg[j]+1==strg[i]){
                        printminpath(arr, strg, j, psf+"->"+j);
                    }
                }
            
        }
        public static int mincostmaze(int[][] maze){
          int[][] strg=new int[maze.length][maze[0].length];
          
          for(int i=strg.length-1;i>=0;i--){
              for(int j=strg[0].length-1;j>=0;j--){
                  if(i==strg.length-1 && j==strg[0].length-1){
                    strg[i][j]=maze[i][j];
        
                  }
                  else if(i==strg.length-1){
                    strg[i][j]=maze[i][j]+strg[i][j+1];
                  }else if(j==strg[0].length-1){
                    strg[i][j]=maze[i][j]+strg[i+1][j];
                 
                  }else{
                      int mymin=Math.min(strg[i+1][j],strg[i][j+1]);
                      strg[i][j]=maze[i][j]+mymin;
                  }
              }
          }
         mincostpath(strg, 0, 0, "");
         System.out.println("****************");
          mazebfs(strg);
           return strg[0][0];
        }
        public static void mincostpath(int[][] strg,int i,int j,String psf){
             if(i==strg.length-1 && j==strg[0].length-1){
                 System.out.println(psf);
                 return;
             }
           if(i==strg.length-1){
               mincostpath(strg, i, j+1, psf+"h");
           }else if(j==strg[0].length-1){
            mincostpath(strg, i+1, j, psf+"v");
        }else  if(strg[i][j+1]<strg[i+1][j]){
                 mincostpath(strg, i, j+1, psf+"h");
             }else  if(strg[i+1][j]<strg[i][j+1]){
                mincostpath(strg, i+1, j, psf+"v");
            }else{
                mincostpath(strg, i, j+1, psf+"h");
                mincostpath(strg, i+1, j, psf+"v");
            }
        }
    public static void main(String[] args){

    }
}