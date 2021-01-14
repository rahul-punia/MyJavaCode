import java.util.*;


public class dp{
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
        boolean[][] visited=new boolean[strg.length][strg[0].length];
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
public static int goldmine(int[][] local){
    int max=Integer.MIN_VALUE;
    int[][] strg=new int[local.length][local[0].length];
   
    for(int j=strg[0].length-1;j>=0;j--){
        for(int i=strg.length-1;i>=0;i--){
    
    if(j==local[0].length-1){
       strg[i][j]=local[i][j];
    }
    else if(i==strg.length-1){
        strg[i][j]=Math.max(strg[i-1][j+1],strg[i][j+1])+local[i][j]; 
    }else if(i==0){
        
        strg[i][j]=Math.max(strg[i+1][j+1],strg[i][j+1])+local[i][j];
        if(j==0){
            for(int r=0;r<strg.length;r++){
                max=Math.max(max, strg[r][0]);
            }
        }
    }else{
       strg[i][j]=local[i][j]+Math.max(strg[i+1][j+1],Math.max(strg[i-1][j+1],strg[i][j+1]));
    }
}
} 
for(int r=0;r<strg.length;r++){
    if(max==strg[r][0]){
        goldminepathsir(strg,local, r, 0, "");
    }
} 
    return max;
}
public static void goldminepathsir(int[][] strg,int[][] local,int i,int j,String psf){
    if(j==strg[0].length-1){
        System.out.println(psf);
        return;
    }
    if(i==0){
        if(strg[i][j]-local[i][j]==strg[i][j+1]){
            goldminepathsir(strg,local, i, j+1, psf+"d2"); 
        }
        if(strg[i][j]-local[i][j]==strg[i+1][j+1]){
            goldminepathsir(strg,local, i+1, j+1, psf+"d3");
        }
    }else if(i==strg.length-1){
        if(strg[i][j]-local[i][j]==strg[i-1][j+1]){
            goldminepathsir(strg,local, i-1, j+1, psf+"d1");
        }
        if(strg[i][j]-local[i][j]==strg[i][j+1]){
            goldminepathsir(strg,local, i, j+1, psf+"d2"); 
        }
    }else{
        if(strg[i][j]-local[i][j]==strg[i-1][j+1]){
            goldminepathsir(strg,local, i-1, j+1, psf+"d1");
        }
        if(strg[i][j]-local[i][j]==strg[i][j+1]){
            goldminepathsir(strg,local, i, j+1, psf+"d2"); 
        }
        if(strg[i][j]-local[i][j]==strg[i+1][j+1]){
            goldminepathsir(strg,local, i+1, j+1, psf+"d3");
        }
//         if(strg[i-1][j+1]>strg[i][j+1] &&  strg[i-1][j+1]>strg[i+1][j+1]){
//             goldminepath(strg, i-1, j+1, psf+"d1");
//         }
//         else if(strg[i][j+1]>strg[i+1][j+1] && strg[i][j+1]>strg[i-1][j+1]){
//             goldminepath(strg, i, j+1, psf+"d2");
//         }
//         else if(strg[i+1][j+1]>strg[i][j+1] && strg[i+1][j+1]>strg[i-1][j+1]){
//             goldminepath(strg, i+1, j+1, psf+"d3");
//         }else{
//             if(strg[i-1][j+1]==strg[i][j+1] && strg[i][j+1]==strg[i+1][j+1]){
//                 goldminepath(strg, i-1, j+1, psf+"d1");
//                 goldminepath(strg, i, j+1, psf+"d2");
//                 goldminepath(strg, i+1, j+1, psf+"d3");
//             }else if(strg[i-1][j+1]==strg[i][j+1] ){
//             goldminepath(strg, i-1, j+1, psf+"d1");
//             goldminepath(strg, i, j+1, psf+"d2");
//             }else if(strg[i-1][j+1]==strg[i+1][j+1]){
//                 goldminepath(strg, i-1, j+1, psf+"d1");
//                 goldminepath(strg, i+1, j+1, psf+"d3");
//             }else if(strg[i][j+1]==strg[i+1][j+1] ){
//                 goldminepath(strg, i, j+1, psf+"d2");
//                 goldminepath(strg, i+1, j+1, psf+"d3");
//                 }
//  }
    }
}
public static void goldminepath(int[][] strg,int i,int j,String psf){
    if(j==strg[0].length-1){
        System.out.println(psf);
        return;
    }
    if(i==0){
        if(strg[i][j+1]>strg[i+1][j+1]){
            goldminepath(strg, i, j+1, psf+"d2");
        }
        else if(strg[i][j+1]<strg[i+1][j+1]){
            goldminepath(strg, i+1, j+1, psf+"d3");
        }else{
            goldminepath(strg, i, j+1, psf+"d2");
            goldminepath(strg, i+1, j+1, psf+"d3");
        }
    }else if(i==strg.length-1){
        if(strg[i][j+1]>strg[i-1][j+1]){
            goldminepath(strg, i, j+1, psf+"d2");
        }
        else if(strg[i][j+1]<strg[i-1][j+1]){
            goldminepath(strg, i-1, j+1, psf+"d1");
        }else{
            goldminepath(strg, i, j+1, psf+"d2");
            goldminepath(strg, i-1, j+1, psf+"d1");
        }
    }else{
        if(strg[i-1][j+1]>strg[i][j+1] &&  strg[i-1][j+1]>strg[i+1][j+1]){
            goldminepath(strg, i-1, j+1, psf+"d1");
        }
        else if(strg[i][j+1]>strg[i+1][j+1] && strg[i][j+1]>strg[i-1][j+1]){
            goldminepath(strg, i, j+1, psf+"d2");
        }
        else if(strg[i+1][j+1]>strg[i][j+1] && strg[i+1][j+1]>strg[i-1][j+1]){
            goldminepath(strg, i+1, j+1, psf+"d3");
        }else{
            if(strg[i-1][j+1]==strg[i][j+1] && strg[i][j+1]==strg[i+1][j+1]){
                goldminepath(strg, i-1, j+1, psf+"d1");
                goldminepath(strg, i, j+1, psf+"d2");
                goldminepath(strg, i+1, j+1, psf+"d3");
            }else if(strg[i-1][j+1]==strg[i][j+1] ){
            goldminepath(strg, i-1, j+1, psf+"d1");
            goldminepath(strg, i, j+1, psf+"d2");
            }else if(strg[i-1][j+1]==strg[i+1][j+1]){
                goldminepath(strg, i-1, j+1, psf+"d1");
                goldminepath(strg, i+1, j+1, psf+"d3");
            }else if(strg[i][j+1]==strg[i+1][j+1] ){
                goldminepath(strg, i, j+1, psf+"d2");
                goldminepath(strg, i+1, j+1, psf+"d3");
                }
 }
    }
}

//notice-to concern about optional fec in 3rd sem
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
     if(str.charAt(i-1)<'3'){
         strg[i]=strg[0]+1;
     }
     else if(str.charAt(i-1)>'3'){
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
public static boolean targsubset(int[] arr,int targ){
    boolean[][] strg=new boolean[arr.length][targ+1];

    for(int i=0;i<strg.length;i++){
        for(int j=0;j<strg[0].length;j++){
            if(i==0&&j==0){
                strg[i][j]=true;
            }
            else if(j==0){
                strg[i][j]=true;
            }else if(i==0){
                if(arr[i]==j){
                    strg[i][j]=true;
                }else{
                    strg[i][j]=false;
                }
            }else{
                //batting
                if((j-arr[i])>=0 && strg[i-1][j-arr[i]]==true){
                    strg[i][j]=true;
                }else if((i-1)>=0 && strg[i-1][j]==true){//not batting
                    strg[i][j]=true;
                }else{
                    strg[i][j]=false;
                }
            }
        }
    }
    printsubset(strg, arr,strg.length-1, strg[0].length-1, "", targ);
    return strg[arr.length-1][strg[0].length-1];
}
  public static void printsubset(boolean[][] strg,int[] arr,int i,int j,String psf,int targ){
   if(targ==0){
       System.out.println(psf);
       return;
   }else if(targ==arr[i]){
       System.out.println(arr[i]+psf);
       return;
   }
   else{
    if(strg[i-1][j]==true){
        printsubset(strg,arr, i-1, j, psf,targ);
    }
    if((j-arr[i])>=0 && strg[i-1][j-arr[i]]==true){
        printsubset(strg,arr, i-1, j-arr[i], arr[i]+psf,targ-arr[i]);
    }
  }
  }
  public static int cccperm(int[] coins,int targ){//coinchangepermutation
  int[] strg=new int[targ+1];
  strg[0]=1;
for(int i=1;i<strg.length;i++){
    for(int j=0;j<coins.length;j++){
      if((i-coins[j])>=0){
          strg[i]+=strg[i-coins[j]];
      }
    }
}
    return strg[strg.length-1];
  }

  public static int cccccomb(int[] coins,int targ){//coinchangecombination
    int[] strg=new int[targ+1];
    strg[0]=1;
       for(int j=0;j<coins.length;j++){
        for(int i=1;i<strg.length;i++){
        if((i-coins[j])>=0){
            strg[i]+=strg[i-coins[j]];
        }
      }
  }
      return strg[strg.length-1];
    }
    public static int oknapsack(int[] prices,int[] wt,int cap){
        int[][] strg=new int[prices.length][cap+1];
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                if(i==0&&j==0){
                    strg[i][j]=0;
                }else if(j==0){
                    strg[i][j]=0;
                }else if(i==0){
                    
                        if(j>=wt[i]){
                            strg[i][j]=prices[i];
                        }
                    
                }else{
                    if(j-wt[i]>=0){
                strg[i][j]=Math.max(strg[i-1][j], strg[i-1][j-wt[i]]+prices[i]);
                }
            }
            }
        }
  onknapsackpath(prices, wt, strg.length-1, strg[0].length-1, strg,"");
   return strg[strg.length-1][strg[0].length-1];
    }
    public static void onknapsackpath(int[] prices,int[] wts,int i,int j,int[][] strg,String psf){
        if(i==0 || j==0){
            System.out.println(psf);
            if(j==wts[i]){
              System.out.println(prices[i]+psf);
            }
            return;
        }
          if(strg[i][j]-prices[i]==strg[i-1][j-wts[i]]){
              onknapsackpath(prices, wts, i-1, j-wts[i], strg, psf+prices[i]+" ");
          }
          if(strg[i][j]==strg[i-1][j]){
              onknapsackpath(prices, wts, i-1, j, strg, psf);
          }
        }
    public static int unknapsack(int[] prices,int[] wt,int cap){
        int[] strg=new int[cap+1];
        strg[0]=0;
            for(int j=1;j<strg.length;j++){
               for(int i=0;i<wt.length;i++){
                   if(j-wt[i]>=0){
                       strg[j]=Math.max(strg[j],strg[j-wt[i]]+prices[i]);
                   }
               }
            }
            
   return strg[strg.length-1];
    }
  
  public static int nfriends(int n){
      int[] strg=new int[n+1];
      strg[0]=1;
      strg[1]=1;
      for(int i=2;i<strg.length;i++){
          strg[i]=strg[i-1]+(i-1)*(strg[i-2]);
      }
  return strg[strg.length-1];
  }
  public static int noofwaystoplacetiles(int m,int n){//no of ways to place tiles
      int[] strg=new int[n+1];
      strg[0]=0;
      strg[1]=1;

      for(int j=2;j<strg.length;j++){
          strg[j]=strg[j-1]+strg[j-m];
      }


      return strg[strg.length-1];
  }
  public static int lcs(String s1,String s2){
      int[][] strg=new int[s1.length()+1][s2.length()+1];

      for(int i=strg.length-1;i>=0;i--){
          for(int j=strg[0].length-1;j>=0;j--){
              if(i==strg.length-1){
                  strg[i][j]=0;
              }else if(j==strg[0].length-1){
                  strg[i][j]=0;
              }else{
                  if(s1.charAt(i)==s2.charAt(j)){
                      strg[i][j]=1+strg[i+1][j+1];
                  }else{
                      strg[i][j]=Math.max(strg[i+1][j], strg[i][j+1]);
                  }
              }
          }
      }
      return strg[0][0];
  }
  public static int lps(String str){
      int[][] strg=new int[str.length()][str.length()];

      for(int gap=0;gap<str.length();gap++){
          for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
              if(i==j){
                  strg[i][j]=1;
              }else if(str.charAt(i)==str.charAt(j)){
                  strg[i][j]=strg[i+1][j-1]+2;
              }else{
                  strg[i][j]=Math.max(strg[i][j-1], strg[i+1][j]);
              }
          }
      }
      return strg[0][strg[0].length-1];
  }


  public static int countlps(String str){
    int[][] strg=new int[str.length()][str.length()];

    for(int gap=0;gap<str.length();gap++){
        for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
            if(i==j){
                strg[i][j]=1;
            }else if(str.charAt(i)==str.charAt(j)){
                strg[i][j]=strg[i+1][j-1]+2;
            }else{
                strg[i][j]=Math.max(strg[i][j-1], strg[i+1][j]);
            }
        }
    }
    return strg[0][strg[0].length-1];
}
    public static int countpss(String str){
        int[][] strg=new int[str.length()][str.length()];

        for(int gap=0;gap<strg.length;gap++){
           for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
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
        return strg[0][strg[0].length-1];
    }
    public static void lonpalsubstring(String str){
        boolean[][] strg=new boolean[str.length()][str.length()];
        int ct=0;
        int longest=0;

        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
                if(gap==0){
                    strg[i][j]=true;
                }else if(gap==1){
                    strg[i][j]=str.charAt(i)==str.charAt(j)?true:false;
                }else{
                    if(str.charAt(i)==str.charAt(j)){
                        if(strg[i+1][j-1]==true){
                            strg[i][j]=true;
                        }else{
                            strg[i][j]=false;
                        }
                    }else{
                        strg[i][j]=false;
                    }
                }
                if(strg[i][j]==true){
                    ct++;
                    longest=gap+1;
                }
            }
        }
        System.out.println("count "+ct+" "+"length of longpalsubstring "+longest);
    }
    public static int divibys(String str,int d){
        int[][] strg=new int[str.length()][d];

        for(int i=0;i<strg.length;i++){
            for(int j=0;j<d;j++){
            if(i==0){
                if(i==0 && j==0){
                    strg[i][j]=1;
                }else if(j==(str.charAt(i)-48)%d){
                    strg[i][j]+=1;
                }else{
                    strg[i][j]=0;
                }
            }else{
                strg[i][j]+=strg[i-1][j];
                int num=str.charAt(i)-48;
                strg[i][(j*10+num)%d]+=strg[i-1][j];
            }
        }
    }
    return strg[strg.length-1][0];
    }

    public static int divibysir(String str,int d){
        int[][] strg=new int[str.length()][d];

        strg[0][0]=1;
        strg[0][(str.charAt(0)-48)%d]+=1;

        for(int i=0;i<strg.length-1;i++){
            for(int j=0;j<strg[0].length;j++){
        
                strg[i+1][j]+=strg[i][j];
                int num=str.charAt(i+1)-48;
                strg[i+1][(j*10+num)%d]+=strg[i][j];
            
        }
    }
    return strg[strg.length-1][0];
    }
    public static int minpalcut(String str){
        int[][] strg=new int[str.length()][str.length()];

        for(int gap=0;gap<str.length();gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
                if(gap==0){
                    strg[i][j]=0;
                }else if(gap==1){
                   if( str.charAt(i)==str.charAt(j)){
                       strg[i][j]=0;
                   }else{
                       strg[i][j]=1;
                   }
                }else{
                    if(str.charAt(i)==str.charAt(j) && strg[i+1][j-1]==0){
                        strg[i][j]=0;
               }else{
                int mymin=str.length();
                  for(int r=i;r<j;r++){
                    if(strg[i][r]+strg[r+1][j]<mymin){
                        mymin=strg[i][r]+strg[r+1][j];
                    }
                }   
                strg[i][j]=mymin+1;

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
        return strg[0][strg[0].length-1];
    }

    //  public static int minpalcutsir(String str){
    //     int[][] strg=new int[str.length()][str.length()];

    //     for(int gap=0;gap<str.length();gap++){
    //         for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
    //             if(gap==0){
    //                 strg[i][j]=0;
    //             }else if(gap==1){
    //                if( str.charAt(i)==str.charAt(j)){
    //                    strg[i][j]=0;
    //                }else{
    //                    strg[i][j]=1;
    //                }
    //             }else{
    //                 if(str.charAt(i)==str.charAt(j) && strg[i+1][j-1]==0){
    //                     strg[i][j]=0;
    //            }else{
    //             int mymin=str.length();
    //               for(int k=0;k<gap;k++){
    //                 if(strg[i][r]+strg[r+1][j]<mymin){
    //                     mymin=strg[i][r]+strg[r+1][j];
    //                 }
    //             }   
    //             strg[i][j]=mymin+1;

    //            }
    //             }
    //         }
    //     }
    //     for(int i=0;i<strg.length;i++){
    //         for(int j=0;j<strg[0].length;j++){
    //             System.out.print(strg[i][j]+" ");
    //         }
    //         System.out.println();
    //     }
    //     return strg[0][strg[0].length-1];
    // }
    public static int eggdrop(int e,int f){
        int[][] strg=new int[e+1][f+1];
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                if(i==0 || j==0){
                    strg[i][j]=0;
                }else if(i==1){
                    strg[i][j]=j;
                }else{
                    int mymin=Integer.MAX_VALUE;
                    int mymax=Integer.MIN_VALUE;
                    for(int k=0;k<j;k++){
                     mymax=Math.max(strg[i-1][k], strg[i][j-k-1]);
                     if(mymax<mymin){
                         mymin=mymax;
                     }
                    }
                    strg[i][j]=mymin+1;
                }
            }
        }
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+" ");
            }
            System.out.println();
        }
        eggdroppath(strg, strg.length-1, strg[0].length-1,""+(strg[0].length-1)+" ");
        return strg[strg.length-1][strg[0].length-1];
    }


    public static void eggdroppath(int[][] strg,int i,int j,String psf){
        if(j==1){
            System.out.println(psf);
            return;
        }

        for(int k=0;k<j;k++){
            if((strg[i][j]-1)==Math.max(strg[i-1][k],strg[i][j-k-1])){
                if(strg[i][j]-1==strg[i][j-k-1]){
                    eggdroppath(strg, i, j-k-1, psf+(j-k-1)+" ");
                }
                if(strg[i][j]-1==strg[i-1][k]){
                    eggdroppath(strg, i, k, psf+k+" ");
                     }
            }
        }
    }
    public static int mincostmult(int[] arr){
        int[][] strg=new int[arr.length-1][arr.length-1];

        for(int gap=0;gap<arr.length;gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
                if(gap==0){
                    strg[i][j]=0;
                }else if(gap==1){
                    strg[i][j]=arr[i]*arr[j]*arr[(j+1)];
                }else{
                    int mymin=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        mymin=Math.min(mymin,strg[i][k]+strg[k+1][j]+arr[i]*arr[(j+1)]*arr[(k+1)]);
                    }
                    strg[i][j]=mymin;
                }
            }
        }
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+" ");
            }
            System.out.println();
        }
        return strg[0][strg[0].length-1];
    }
    public static int evencoins(int[] arr){
        int[][] strg=new int[arr.length][arr.length];

        for(int gap=0;gap<strg.length;gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
             if(gap==0){
                 strg[i][j]=arr[i];
             }else if(gap==1){
                 strg[i][j]=Math.max(strg[i][j-1], strg[i+1][j]);
             }else{
                 strg[i][j]=Math.max(Math.min(strg[i][j-2],strg[i+1][j-1])+arr[j],Math.min(strg[i+2][j],strg[i+1][j-1])+arr[i]);
             }
            }
        }
        for(int i=0;i<strg.length;i++){
            for(int j=0;j<strg[0].length;j++){
                System.out.print(strg[i][j]+" ");
            }
            System.out.println();
        }
        return strg[0][strg[0].length-1];
    }

// **************************************************************
    public static int mincostbst(int[] ele,int[] freq){
        int[] freqsum=new int[freq.length];
        freqsum[0]=freq[0];

        for(int i=1;i<freqsum.length;i++){
            freqsum[i]=freqsum[i-1]+freq[i];
        }
        int[][] strg=new int[ele.length][ele.length];

        for(int gap=0;gap<ele.length;gap++){
            for(int i=0,j=gap;j<strg[0].length;i++,j=i+gap){
              if(gap==0){
                  strg[i][j]=freq[j];
              }else if(gap==1){
                  strg[i][j]=Math.min(freq[i]+2*freq[j],2*freq[i]+freq[j]);
              }else{
                  int mymin=Integer.MAX_VALUE;
                  for(int k=i;k<=j;k++){  //imp two finger traverse
                      if(k==i){
                       mymin=Math.min(mymin,0+strg[k+1][j]);
                      }else if(k==(j)){
                        mymin=Math.min(mymin,strg[i][k-1]+0);
                      }else{
                          mymin=Math.min(mymin,strg[i][k-1]+strg[k+1][j]);
                      }
                  }
                  strg[i][j]=mymin+freqsum[j];
                  if(i>0){
                      strg[i][j]-=freqsum[i-1];
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
        return strg[0][strg[0].length-1];
    }
    public static int minsqcut(int w,int h,int[][] qb){
     if(h==w){
         return 1;
     }else if(h==0 || w==0){
         return 0;
     }
     int res=Integer.MAX_VALUE;

     if(qb[w][h]!=0){
         return qb[w][h];
     }

     for(int x=1;x<=Math.min(w, h);x++){
         int lvxw=x;
         int lvxh=h-x;
         int rvxw=w-x;
         int rvxh=h;
         int lvscore=minsqcut(lvxw, lvxh, qb);
         int rvscore=minsqcut(rvxw, rvxh, qb);
         int tvscore=lvscore+rvscore;

         int lhxw=w-x;
         int lhxh=x;
         int rhxw=w;
         int rhxh=h-x;
         int lhscore=minsqcut(lhxw, lhxh, qb);
         int rhscore=minsqcut(rhxw, rhxh, qb);
         int thscore=lhscore+rhscore;

         res=Math.min(res, Math.min(thscore, tvscore));
     }
     res++;
     qb[w][h]=res;
     return res;

    }
    public static void lis(int[] arr){
        int[] strg=new int[arr.length];

        strg[0]=1;
    for(int i=1;i<strg.length;i++){
            int mymax=0;
      for(int j=0;j<i;j++){
          if(arr[j]<arr[i]){
         mymax=Math.max(mymax, strg[j]);
         }
      }
      strg[i]=mymax+1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<strg.length;i++){
         if(strg[i]>max){
             max=strg[i];
         }
        }
        //for(int i=strg.length-1;i>=0;i--){
        //     if(strg[i]==max){
        //     printlis(strg,i);
        //      }
        //    }
        System.out.println(max);
    }
    // public static void printlis(int[] strg,int i,String psf){
     
    // }
    public static void lds(int[] arr){
        int[] strg=new int[arr.length];
        int omax=0;
        for(int i=strg.length-1;i>=0;i--){
            int mymax=0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    mymax=Math.max(mymax, strg[j]);
                }
            }
        strg[i]=mymax+1;
        if(strg[i]>omax){
            omax=strg[i];
        }
        }
        System.out.println(omax);
    }
    public static int rodcut(int[] prices){
        int[] strg=new int[prices.length];
        strg[0]=prices[0];
        strg[1]=prices[1];
        for(int i=2;i<strg.length;i++){
            int max=prices[i];
            int le=1;
            int ri=i-1;
            while(le<=ri){
                max=Math.max(max,strg[le]+strg[ri]);
                le++;
                ri--;
            }
            strg[i]=max;
        }
        for(int i=0;i<strg.length;i++)
        System.out.print(strg[i]+" ");
        return strg[strg.length-1];
    }
    public static int adjele(int[] arr){
        int inc=arr[0];
        int exc=0;

        for(int i=1;i<arr.length;i++){
            int ni=exc+arr[i];
            int ne=Math.max(inc, exc);
            inc=ni;
            exc=ne;
        }
        return Math.max(inc, exc);
    }
    static class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;
        }
        public int compareTo(Interval other){
        return this.start-other.start; //for activityselection1
        //return this.end-other.end;   //for activityselection2
        }
    }
    public static void activityselection1(int[] starts,int[] ends){
        Interval[] intvs=new Interval[starts.length];
        for(int i=0;i<intvs.length;i++){
            intvs[i]=new Interval(starts[i],ends[i]);
        }
        Arrays.sort(intvs);

        int[] strg=new int[starts.length];
        strg[0]=1;
        for(int i=1;i<starts.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
            if(intvs[j].end<intvs[i].start){
                
                max=Math.max(max, strg[j]);
            }
            strg[i]=max+1;
        }
        }
     
     System.out.println(strg[strg.length-1]);
    }
    public static void activityselection2(int[] starts,int[] ends){
        Interval[] intvs=new Interval[starts.length];
        for(int i=0;i<intvs.length;i++){
            intvs[i]=new Interval(starts[i],ends[i]);
        }
        Arrays.sort(intvs);
        int count=1;
        int lai=0;
        for(int i=1;i<starts.length;i++){
            if(intvs[i].start>intvs[lai].end){
                count++;
                lai=i;
            }
        }
        System.out.println(count);
    }
    static class product implements Comparable<product>{
        int price;
        int wt;
        double ratio;   //ratio of prices/weight
        product(int price,int wt){
            this.price=price;
            this.wt=wt;
            this.ratio=price*1.0/wt;    // 5/3=1; but 5*1.0/3=1.66
        }
       
        public int compareTo(product other){
            if(this.ratio<other.ratio){
                return -1;
            }else if(this.ratio>other.ratio){
            return 1;
            }else{
                return 0;
            }

        }
    }

    public static void fractionalks(int[] prices,int[] wts,int cap){
        product[] prds=new product[prices.length];
        
        for(int i=0;i<prds.length;i++){
            prds[i]=new product(prices[i],wts[i]);
        }
        Arrays.sort(prds);

        double vib=0;// max value in bag-cost
        int rc=cap;//remaining capacity
        int i=wts.length-1;
        while(rc>0){
            if(prds[i].wt<=rc){
                vib+=prds[i].price;
                rc-=prds[i].wt;
            }else{
            vib+=rc*prds[i].ratio;  //vib+=(rc*1.0/prds[i].wt)*prds[i].price;
                rc=0;
            }
            i--;
        }
        System.out.println(vib);

    }
    public static void train(int[] arrivals,int[] depart){
        Arrays.sort(arrivals);
        Arrays.sort(depart);
       int i=0;
       int j=0;
       int ct=0;
       int max=1;

       while(i<arrivals.length){
        if(arrivals[i]<=depart[j]){
            ct++;
            if(ct>max){
                max=ct;
            }
            i++;
        }else if(arrivals[i]>depart[j]){
                ct--;
                j++;
        }
       }
       System.out.println(max);
        
    }

    static class job implements Comparable<job>{
        char name;
        int pft;
        int dl;

        job(char name,int pft,int dl){
            this.name=name;
            this.pft=pft;
            this.dl=dl;//dead line means last day to do work
        }
        public int compareTo(job other){
            return this.pft-other.pft;    //sort on the basis of profit
        }
    }
    
    public static int jobseq(char[] name,int[] day,int[] money){
        job[] jobs=new job[day.length];
        int max=1;
        for(int i=0;i<jobs.length;i++){
            if(day[i]>max){
                max=day[i];
            }
            jobs[i]=new job(name[i],money[i],day[i]);
        }
        Arrays.sort(jobs);  //sort on profit
        char[] res=new char[max+1];
        
        int profit=0;

        for(int i=jobs.length-1;i>=0;i--){
        int spot=jobs[i].dl;
        while(spot>0){
            if(res[spot]=='\0'){  //means day/spot is empty
                res[spot]=jobs[i].name;
                profit+=jobs[i].pft;
                break;
            }else{
                spot--;
            }
        }
        }
        
        // for(int i=jobs.length-1;i>=0;i--){
        // int spot=jobs[i].dl;
        // while(spot>0){
        //    if(res[spot]=='\0'){
        //        res[spot]=jobs[i].name;
        //        profit+=jobs[i].pft;
        //        break;
        //    }else{
        //        spot--;
        //    }
        // }
        // }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println(".");
        return profit;
        }
        public static void largsquare(int[][] mat){
        int[][] strg=new int[mat.length][mat[0].length];

        int max=1;
        for(int i=strg.length-1;i>=0;i--){
            for(int j=strg[0].length-1;j>=0;j--){
               if(i==strg.length-1 && j==strg[0].length-1){
                   strg[i][j]=mat[i][j];
               }else if(i==strg.length-1){
                   strg[i][j]=mat[i][j];
               }else if(j==strg[0].length-1){
                   strg[i][j]=mat[i][j];
               }else{
                   if(mat[i][j]==0){
                       strg[i][j]=0;
                   }else{
                       strg[i][j]=Math.min(strg[i][j+1],Math.min(strg[i+1][j+1], strg[i+1][j]))+1;
                   }
               }
               if(strg[i][j]>max){
                   max=strg[i][j];
               }
            }
        }
        System.out.println(max);
        }
        public static void longevenlength(String str){

            for(int i=0;i<str.length()-1;i++){
             for(int j=0;j<str.length()-1;j++){
            
             }
            }
        }

    
    public static void main(String [] args){
        int[][] mat={{1,0,0,1,0,0,1,0},
                     {1,1,1,1,1,1,1,1},
                     {1,1,0,1,1,1,1,1},
                     {1,0,1,1,1,1,1,0},
                     {0,1,1,1,1,1,1,1}
                     ,{1,0,1,0,1,1,0,1},
                     {1,0,0,1,1,1,1,1}};
        largsquare(mat);
        char[] name={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o'};
        int[] days={4,2,3,2,4,5,1,1,2,3,5,2,3,5,4};
        int[] money={37,64,98,70,80,40,54,76,42,89,27,92,38,77,46};
        System.out.println(jobseq(name, days, money));
        int[] arrival={900,940,950,1100,1500,1800};
        int[] depart={910,1200,1120,1130,1900,2000};
        train(arrival, depart);
        int[] prices5={10,40,20,30};
        int[] value={60,40,100,120};
        int capacity=50;//capacity of bag
        fractionalks(value,prices5,capacity);

        int[]starts={12,2,6,7,9,1,3};
        int[]ends={14,5,8,10,11,4,7};
       // activityselection1(starts, ends);
       // activityselection2(starts, ends);
        int[] arrt={5,6,10,100,10,5};
        
       // System.out.println(adjele(arrt));
        int[] prices1={0,3,5,6,15,10,25,12,24};
      //  System.out.println(rodcut(prices1));
        int[] arr9={10,21,9,33,22,50,41,60,80,1};
        lis(arr9);
        lds(arr9);
        int[][]qb=new int[37][31];
       // System.out.println(minsqcut(36, 30, qb));
        int[] freq={2,1,4,1,1,3,5};
        int[] ele={10,20,30,40,50,60,70};
//System.out.println(mincostbst(ele, freq));
        int[] dim={10,20,30,40,50,60};
        int[] coins1={20,30,2,2,2,10};
       System.out.println(evencoins(coins1));
      //  System.out.println(mincostmult(dim));
      //  System.out.println(eggdrop(2, 10));
      //  System.out.println(minpalcut("abccbc"));
      //  System.out.println(divibys("235168",6));
        //System.out.println(divibysir("235168",6));
       
       // lonpalsubstring("abccbc");
       // System.out.println(countpss("abckycbc"));
        String s1="abcd";
        String s2="aebd";
        String str="abckycbc";
        //System.out.println(lps(str));
        //System.out.println(lcs(s1, s2));
        int[] prices={15,14,10,45,30};
        int[] wt={2,5,1,3,4};
        int cap=7;
        int m=10;
        int n1=2;
     //  System.out.println(noofwaystoplacetiles(2, 10));
        //System.out.println(nfriends(4));
       // System.out.println(oknapsack(prices, wt, cap));
      //  System.out.println(unknapsack(prices, wt, cap));

    int n=0;
    int targ=8;
    int[] arr={2,1,6,5,9};
    int[] coins={2,3,5,6};
    int amt=7;
    
   // System.out.println(cccperm(coins,7));
   // System.out.println(ccccomb(coins, 7));
   // int[] arr={10,3,2,5,8};
   // System.out.println(targsubset(arr, targ));
   // System.out.println(encodings("1123"));
//    System.out.println(encodings("12132612014"));
//     int[] arr1={1,2,1,3,2,6,1,2,0,1,4};
//     System.out.println(countencoding(arr1));
   
    //  System.out.println(countss("abcabc"));
  //  System.out.println(countbinary(5));
    
    // int path=climbstairdownMemo(n, qb);
    // System.out.println(path);
    //int ans=fibmemo(n, qb);
    //System.out.println(ans);
 //   int[] arr={4,2,0,0,3,3,6,5,1,0,1,2,3,1,1};
    // int ans=countpath(arr);
    // System.out.println(ans);
    //int ans=minjump(arr);
    //System.out.println("min jumps "+ans);
    
    // int [] qb=new int[arr.length];
    
    // int path=stairpath2(arr, qb, n);
    // System.out.println(path);
    int[][] maze1={{2,4,3,8,0,3,7},
                   {4,0,1,2,4,3,4},
                   {3,8,5,9,0,8,1},
                   {1,6,0,4,5,5,2},
                   {6,2,9,5,7,0,6},
                   {0,8,7,9,6,3,0},
                   {1,3,5,0,5,1,0}    };
  int[][] maze2={{1,5,1,0,3},{1,4,0,2,3},{4,0,1,3,2},{2,4,0,4,1},{1,2,3,2,0}};
 //   System.out.println(mincostmaze(maze2));
    // int[][] gold={{1,5,1,0,3},
    //             {1,4,0,2,3},
    //             {4,0,1,3,2},
    //             {2,4,0,4,1},
    //             {1,2,3,2,0}};
    //             System.out.println(goldmine(gold));
    }
}