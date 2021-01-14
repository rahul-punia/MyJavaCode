import java.util.*;

public class recursionpractise{
  //subsequence abc
  public static void printsubseq(String str,String ans){
   if(str.length()==0){
       System.out.println(ans);
       return;
   }
   char ch=str.charAt(0);
   String ros=str.substring(1);
   printsubseq(ros, ans+"-");
   printsubseq(ros, ans+ch);
  }
  //lo
  public static void subseq(String str,String ans){
      if(str.length()==0){
          System.out.println(ans);
          return;
      }
      char ch=str.charAt(0);
      String ros=str.substring(1);
      subseq(ros, ans+ch);
      subseq(ros, ans+"-");
  }
//stairpath
static int ct=0;
public static int stairpath(int n){
    if(n==0){
      ct++;
      return ct;
    }
    if(n-1>=0){
        stairpath(n-1);
    }
    if(n-2>=0){
        stairpath(n-2);
    }
    if(n-3>=0){
        stairpath(n-3);
    }
    return ct;
}
//mazepath-1
    public static void mazepath(int sr,int sc,int dr,int dc,String ans){
    if(sr==dr && sc==dc){
    System.out.println(ans);
    return;
    }
    if(sr==dr){
    mazepath(sr, sc+1, dr, dc, ans+"H");
    }else if(sc==dc){
    mazepath(sr+1, sc, dr, dc, ans+"V");
    }else{
    mazepath(sr, sc+1, dr, dc, ans+"H");
        
    mazepath(sr+1, sc, dr, dc, ans+"V");    
    }
    }

    //mazepath-2
    public static ArrayList<String> multimove(int sr,int sc,int dr,int dc){
     if(sr==dr && sc==dc){
         ArrayList<String> ba=new ArrayList<>();
         ba.add("");
         return ba;
     }
     ArrayList<String> tp=new ArrayList<>();

    for(int step=1;step<=(dc-sc);step++){
        ArrayList<String> hp=multimove(sr, sc+step, dr, dc);

      for(int i=0;i<hp.size();i++){
       tp.add("h"+step+hp.get(i));
      }

     }
    
     for(int step=1;step<=(dc-sc) && step<=(dr-sr);step++){
        ArrayList<String> dp=multimove(sr+step, sc+step, dr, dc);

      for(int i=0;i<dp.size();i++){
       tp.add("d"+step+dp.get(i));
      }
     }

     for(int step=1;step<=(dr-sr);step++){
        ArrayList<String> vp=multimove(sr+step, sc, dr, dc);

      for(int i=0;i<vp.size();i++){
       tp.add("v"+step+vp.get(i));
      }

     }
     return tp;
    }
    //stairpath-2
    static int cp=0;
    public static void stairpath2(int[] arr,int idx,String ans){
     if(idx==arr.length-1){
     cp++;
     System.out.println(ans);
     return;
     }

     for(int step=1;step<=arr[idx];step++){
     if( step+idx<(arr.length) && arr[idx+step]!=0){
       stairpath2(arr, idx+step,ans+step);
     }
     }}
    
     //Nokia kpc
     static int nst=0;
     static String codes[]={".","abc","def","ghi","jklm","no","pqrs","tu","vwxy","ez"};
     public static ArrayList<String> nokiakpc(String ques){
     if(ques.length()==0){
     ArrayList<String> bp=new ArrayList<>();
     bp.add("");
     nst++;
     return bp;
     }
    char ch=ques.charAt(0);
    String roq=ques.substring(1);
    int idx=ch-'0';
    ArrayList<String> tp=new ArrayList<>();
     for(int i=0;i<codes[idx].length();i++){
         ArrayList<String> rec=nokiakpc(roq);

         for(int j=0;j<rec.size();j++){
             tp.add(codes[idx].charAt(i)+rec.get(j));
         }
     }
     return tp;
     }
    
     public static void floodfill(int[][] grid,boolean[][] visited,int sr,int sc,String ans){
       if(sr==grid.length-1 && sc==grid[0].length-1){
        System.out.println(ans);
        return;
       }

       //top
       if(sr-1>=0 && grid[sr][sc]==0 && visited[sr-1][sc]==false){
        visited[sr-1][sc]=true;
        floodfill(grid, visited, sr-1, sc,ans+"t");
        visited[sr-1][sc]=false;
       }

       //left
       if(sc-1>=0 && grid[sr][sc]==0 && visited[sr][sc-1]==false){
        visited[sr][sc-1]=true;
        floodfill(grid, visited, sr, sc-1,ans+"l");
        visited[sr][sc-1]=false; 
       }
       //down
       if((sr+1)<grid.length && grid[sr][sc]==0 && visited[sr+1][sc]==false){
           visited[sr+1][sc]=true;
           floodfill(grid, visited, sr+1, sc,ans+"d");
           visited[sr+1][sc]=false;
       }
       //right
       if(sc+1<grid[0].length && grid[sr][sc]==0 && visited[sr][sc+1]==false){
           visited[sr][sc+1]=true;
           floodfill(grid, visited, sr, sc+1,ans+"r");
           visited[sr][sc+1]=false;
       }

     }
     static int pct=0;
     public static void permutation(int obj,int cobj,String ans,boolean[] visited){
      if(cobj==obj){
       System.out.println(ans);
       pct++;
       return;
      }

      for(int op=0;op<visited.length;op++){
          if(visited[op]==false){
              visited[op]=true;
              permutation(obj, cobj+1, ans+"obj-"+cobj+" box-"+op+" ", visited);
              visited[op]=false;
          }
      }
     }

     public static void permutation2(int cb,int tb,int ab,boolean[] obj,String ans){
      if(cb==tb){
          if(ab==2){
        System.out.println(ans);
         pct++;
          }
        return;
      }
      for(int i=0;i<2;i++){
          if(obj[i]==false){
            obj[i]=true;
            permutation2(cb+1, tb, ab+1, obj, ans+"ob "+i+" box"+cb+" ");
            obj[i]=false;
          }
      }
      permutation2(cb+1,tb, ab, obj, ans);   
     }
     public static void combination(int lib,int obj,int cobj,String ans,boolean[] visited){
        if(cobj==obj){
         System.out.println(ans);
         pct++;
         return;
        }
  
        for(int op=0;op<visited.length;op++){
            if(lib<op && visited[op]==false){
                visited[op]=true;
                combination(op,obj, cobj+1, ans+"obj-"+cobj+" box-"+op+" ", visited);
                visited[op]=false;
            }
        }
       }

       public static void combination2(int tb,int r,int issf,int cb,String bssf){
       if(cb==tb){
           if(issf==r){
               System.out.println(bssf);
           }
           return;
       }
       combination2(tb, r, issf+1, cb+1, bssf+"b-"+cb+"obj-"+issf+" ");
       combination2(tb, r, issf, cb+1, bssf);
       }

       //coin change

       public static void coinchangeper(int[] arr,String ans,int amt){
          if(amt==0){
              System.out.println(ans);
              return;
          }
          for(int i=0;i<arr.length;i++){
              if(amt>=arr[i]){
                  coinchangeper(arr, ans+arr[i], amt-arr[i]);
              }
          }
       }
       public static void coinchangecomb(int[] arr,String ans,int amt,int li){
        if(amt==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(amt>=arr[i] && i>=li){
                coinchangecomb(arr, ans+arr[i], amt-arr[i],i);
            }
        }
     }



     //WRONG B/Z KNIGHT MOVE ONLY 2.5 STEP BUT QUEEN MOVE ANY NO OF STEP IN 8 DIRECTION
     public static boolean WRONGisknightsafe(boolean[][] chess,int r,int c){
         int i=r;
         int j=c;
         while(i>=0 && j>=0){
             if(chess[i][j]==true){
                 return false;
             }
             i=i-2;
             j=j-1;
         }

         while(i>=0 && j>=0){
             if(chess[i][j]==true){
                 return false;
             }
             i=i-1;
             j=j-2;
         }

         while(i>=0 && j<chess[0].length){
            if(chess[i][j]==true){
                return false;
            }
            i=i-2;
            j=j+1;
        }

        while(i>=0 && j<chess[0].length){
            if(chess[i][j]==true){
                return false;
            }
            i=i-1;
            j=j+2;
        }
        return true;
     }
     public static boolean isqueensafe(boolean[][] chess,int r,int c){
         for(int i=0;i<=r;i++){
             if(chess[i][c]==true){
                 return true;
             }
         }

         for(int j=0;j<=c;j++){
             if(chess[r][j]==true){
                 return true;
             }
         }
         int i=r;
         int j=c;
         while(i>=0 && j>=0){
             if(chess[i][j]==true){
                 return true;
             }
             i--;
             j--;
         }
         
         i=r;
         j=c;
         while(i>=0 && j<chess[0].length){
            if(chess[i][j]==true){
                return true;
            }
            i--;
            j++;
        }
        return false;
     }
    static int nqct=0;
     public static void nqueen(boolean[][] chess,int cq,String str,int lqx,int lqy){
         if(cq==chess.length){
           System.out.println(str);
           nqct++;
           return;
         }
       for(int i=lqx;i<chess.length;i++){
           for(int j=(i==lqx)?lqy+1:0;j<chess[0].length;j++){
           if(chess[i][j]==false && isqueensafe(chess, i, j)==false){
               chess[i][j]=true;
              nqueen(chess, cq+1, str+"box-"+i+","+j+" queen-"+cq+" ",i,j);
              chess[i][j]=false;
           }  
           }
         }
     }
     public static boolean isknightsafe(boolean [][] chess,int r,int c){
        if(r>=1 && c>=2 && chess[r-1][c-2]==true){
            return false;
        }
       else if(r>=2&& c>=1 && chess[r-2][c-1]==true){
            return false;
        }
        else if(r>=2 && c<chess.length-1 && c<chess.length && chess[r-2][c+1]==true){
            return false;
        }
        else if(r>=1 && c<chess.length-2 && chess[r-1][c+2]==true){
            return false;
        }
        else {
            return true;
        }
    }

     static int nkct=0;
     public static void nknight(boolean[][] chess,int cq,String str,int lqx,int lqy){
         if(cq==chess.length){
           System.out.println(str);
           nkct++;
           return;
         }
       for(int i=lqx;i<chess.length;i++){
           for(int j=(i==lqx?lqy+1:0);j<chess[0].length;j++){
           if(isknightsafe(chess, i, j)==true){
               chess[i][j]=true;
              nknight(chess, cq+1, str+"box-"+i+","+j+" knight-"+cq+" ",i,j);
              chess[i][j]=false;
           }  
           }
         }
     }
    
    static  int kc=0;
     public static void nknightcomb(int i,int j,int ck,boolean[][] chess,String ans){
         if(i==chess.length && j==0){
             if(ck==chess.length){
             System.out.println(ans);
             kc++;
             }
             return;
         }else if(j==chess[0].length-1){
             nknightcomb(i+1, 0, ck, chess, ans);
             if(isknightsafe(chess, i, j)){
                 chess[i][j]=true;
                 nknightcomb(i+1,0,ck+1,chess,ans+"k-"+ck+" box-"+i+","+j+" ");
                 chess[i][j]=false;
             }
             
         }else{
             nknightcomb(i, j+1, ck, chess, ans);
             if(isknightsafe(chess, i, j)){
                chess[i][j]=true;
             nknightcomb(i, j+1,ck+1,chess,ans+"k-"+ck+" box-"+i+","+j+" ");
                chess[i][j]=false;
             }
         }
     }

    //  Encodings
     public static void encodings(String ques,String ans){
         if(ques.length()==0){
             System.out.println(ans);
             return ;
         }else if(ques.length()==1){
         char ch0=ques.charAt(0);
         String roq0=ques.substring(1);
         if(ch0!='0'){
            int num=ch0-'0';
            num--;
            char code=(char)('a'+(num)); 
         encodings(roq0, ans+code);
         }
        }else{
                char ch0=ques.charAt(0);
                String roq0=ques.substring(1);
                if(ch0!='0'){
                   int num=ch0-'0';
                   num--;
                   char code=(char)('a'+num); 
                encodings(roq0, ans+code);
                }
                char ch1=ques.charAt(1);
                String roq1=ques.substring(2);
                if(ch0!='0'){
                    int num=(ch0-'0')*10+(ch1-'0');
                    if(num>=10 && num<=26){
                        num--;
                    char code=(char)('a'+num);
                    encodings(roq1, ans+code);
                    }
                }

             }
         }
         public static boolean contains(String prefix,String[] dic){
          for(int i=0;i<dic.length;i++){
              if(prefix.equals(dic[i])){   //To check two strings are equal or not
                // System.out.println("rahul");
                  return true;
              }
          }
          return false;
         }
        
         public static void wordbreak(String ques,String ans,String[] dic){
             if(ques.length()==0){
                 System.out.println(ans);
                 return;
             }
                // System.out.println("rahul");
             for(int i=1;i<=ques.length();i++){
                 String prefix=ques.substring(0,i);
                //  System.out.println(prefix);
                 if(contains(prefix, dic)==true){    //prefix must be a word
                     String roq=ques.substring(i);
                    //  System.out.print(roq);
                     wordbreak(roq, ans+"-"+prefix, dic);
                 }
             }

         }
     
    public static void main(String[] args){
            int[][] grid={{0,1,0,0,0,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,1,1,0,0,0,0},
                          {0,0,0,0,0,0,1,1,1},
                          {0,1,0,1,1,0,0,0,0},
                          {0,1,0,1,1,1,1,1,0},
                          {0,1,0,0,0,0,0,0,0}};
          boolean[][] visited=new boolean[grid.length][grid[0].length];
        //   floodfill(grid, visited, 0, 0, "");
          boolean[] visited2=new boolean[4];
          //coinchangeper(new int[]{2,3,5,6}, "", 7);
        //   coinchangecomb(new int[]{2,3,5,6}, "", 7,-1);
          boolean[][] chess=new boolean[3][3];
          String[] dic={"i","like","samsung","sam","sung","mango","man","go"};
         wordbreak("ilikesamsungmango", "", dic);
        //   nqueen(chess, 0,"",0,-1);
        // nknight(chess, 0, "", 0, 0);  //why not lqj=-1
        // System.out.println(nkct);
        // encodings("1023", "");
        // nknightcomb(0, 0, 0, chess, "");
        // System.out.println(kc);
        //   System.out.println(nqct);
        //   permutation(2, 0, "", visited2);
        //   System.out.println(pct);
        //   boolean[] obj=new boolean[2];
        //   permutation2(0, 5, 0, obj, "");
        //   System.out.println(pct);
        //   combination(-1, 3, 0, "", visited2);
        //   combination2(4, 3, 0, 0,"");
        // System.out.println(nokiakpc("835"));
        // System.out.println(nst);
    //    int[] jarr={3,2,0,4,1,2,0,2,3,0,1};
    //    stairpath2(jarr, 0,"");
    //    System.out.println(cp);
    //    ArrayList<String> ans=multimove(0, 0, 3,4);
     //  System.out.println(ans);
    //    System.out.println(ans.size());
    // mazepath(0, 0, 3, 4, "");
    // printsubseq("abc", "");
   
    // System.out.println(stairpath(7));
    }
}