import java.util.*;

public class lecture1{

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
}