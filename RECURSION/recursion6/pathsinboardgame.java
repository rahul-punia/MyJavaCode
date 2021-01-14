import java.util.*;

public  class pathsinboardgame{
static int ct=0;
//reactive
public static void pbpreactive(int src,int dest,String psf){
    if(src==dest){
        System.out.println(psf);
        ct++;
        return;
    }
    if(src>dest){
        return;
    }
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
                pbpreactive(inter, dest,psf+dice);
        }
    }
//proactive
public static void pathinbg(int src,int dest,String psf){
if(src==dest){
    System.out.println(psf);
    ct++;
    return;
}
    for(int dice=1;dice<=6;dice++){
        int inter=src+dice;
        if(inter<=dest){
            pathinbg(src+dice, dest,psf+dice);
        }
    }
}
static int ct1=0;
public static void pbpw16opening(int src,int dest,String psf){
    if(src==dest){
        ct1++;
        System.out.println(ct1+"->"+psf);
        return;
    }
    if(src==0){
         pbpw16opening(1, dest, psf+"1");
         pbpw16opening(1, dest, psf+"6");
    }else{
        for(int dice=1;dice<=6;dice++){
            int inter=src+dice;
            if(inter<=dest){
                pbpw16opening(src+dice, dest,psf+dice);
            }
        }
    }
    }

    static int ct2=0;
    public static void pbpw16openingwithladder(int[] ladder,int src,int dest,String psf){
        if(src==dest){
            ct2++;
            System.out.println(ct2+"->"+psf);
            return;
        }
        if(src==0){
            pbpw16openingwithladder(ladder,1, dest, psf+"1");
            pbpw16openingwithladder(ladder,1, dest, psf+"6");
        }else if(ladder[src]!=0){
            pbpw16openingwithladder(ladder,ladder[src], dest, psf+"["+src+"->"+ladder[src]+"]");
        }else{
            for(int dice=1;dice<=6;dice++){
                int inter=src+dice;
                if(inter<=dest){
                    pbpw16openingwithladder(ladder,src+dice, dest,psf+dice);
                }
            }
        }
        }
    
        public static void pbpw16openingwithsnl(int[] snl,int[] moves,int mvidx,int src,int dest){
            if(src==dest){
                ct2++;                    //donot print path b/z infinite paths are possible due to cycles
                System.out.println("win");
                return;
            }
            if(mvidx==moves.length){
                System.out.println(src);
                return;
            }
            if(src==0){
                if(moves[mvidx]==1 || moves[mvidx]==6){
                pbpw16openingwithsnl(snl,moves,mvidx+1,1, dest);
                // pbpw16openingwithsnl(snl,moves,mvidx+1,1, dest);
                }else{
                    pbpw16openingwithsnl(snl, moves, mvidx+1, src, dest);
                }
            }else if(snl[src]!=0){
                pbpw16openingwithsnl(snl,moves,mvidx,snl[src], dest);
            }else{
                    int inter=src+moves[mvidx];
                    if(inter<=dest){
                        pbpw16openingwithsnl(snl,moves,mvidx+1,src+moves[mvidx], dest);
                }else{
                    pbpw16openingwithsnl(snl, moves, mvidx+1, src, dest);
                }
            }
            }
    
public static void main(String[] args){
    // pathinbg(0, 10, "");
    // System.out.println(ct);
    pbpw16opening(0, 10, "");
    System.out.println(ct1);
    int[] ladder=new int[16];
    ladder[2]=13;
    ladder[3]=11;
    ladder[5]=7;
    pbpw16openingwithladder(ladder, 0, 15, "");
    System.out.println(ct2);
    int[] snl=new int[21];
    snl[3]=17;
    snl[7]=11;
    snl[13]=5;
    snl[19]=2;
    int[] moves1={2,5,3,4,6,3,4,3,5,1,2,3};
    int[] moves2={2,5,3,4,6,3,4,3,5,1,1,6,5,2,3,5};
    pbpw16openingwithsnl(snl, moves1, 0, 0, 20); 
}
}