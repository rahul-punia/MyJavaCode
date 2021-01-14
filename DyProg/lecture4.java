import java.util.*;

public class lecture4{
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
//    DP
      public static int noofwaystoplacetiles(int m,int n){//no of ways to place tiles
          int[] strg=new int[n+1];
          strg[0]=1;//b/z if n==m then 2 ways vertical or horizontal
          strg[1]=1;
    
          for(int j=2;j<strg.length;j++){
              strg[j]=strg[j-1]+strg[j-m];
          }
    
    
          return strg[strg.length-1];
      }
    //  RECURSION
      public static int countoftilingfloor(int n,int m){
        if(n==0){
            return 0;  
        }else if(n<m){
            return 1;
        }else if(n==m){//b/z if n==m then 2 ways vertical or horizontal
            return 2;
        }
        int vertical=countoftilingfloor(n-1, m);
        int horizontal=countoftilingfloor(n-m, m);
        return vertical+horizontal;
    
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
            System.out.println("count "+ct+" "+"lonpalsubstring "+longest);
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
}