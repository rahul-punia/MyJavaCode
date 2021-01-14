import java.util.*;

public class cellrotate{
    public static void main(String [] args){
        int [][] arr={{1,2,3,4,5,26},{6,7,8,9,10,27},{11,12,13,14,15,28},{16,17,18,19,20,29},{21,22,23,24,25,30},{31,32,33,34,35,36}};
        int rt=2;   //rotateby
        int cl=3;      //cell-1,2,3,4,5.....
        int rmn=cl-1;
        int cmn=cl-1;
        int rmx=arr.length-cl;
        int cmx=arr[0].length-cl;
        int te=4*(rmx-rmn);
        int []strg=new int[te];
        int idx=0;

       
            //left wall------------------------------------------------------------------------
            for(int i=rmn;i<=rmx;i++){
                strg[idx]=arr[i][cmn];
                idx++;
            }
            cmn++;
        
            //b w
            for(int j=cmn;j<=cmx;j++){
              strg[idx]=arr[rmx][j];
              idx++;
          
            }   rmx--;
            
            //r w
            for(int i=rmx;i>=rmn;i--){
               strg[idx]=arr[i][cmx];
               idx++;
            }     cmx--;
          
            //t w
            for(int j=cmx;j>=cmn;j--){
              strg[idx]=arr[rmn][j];
           idx++;
            }
            rmn++;
            //----------------------------------------------------
            System.out.println();
            for(int i=0;i<strg.length;i++){
              System.out.print(strg[i]+" ");
            }
            System.out.println();
            
            rotate(strg,rt);
            for(int i=0;i<strg.length;i++){
              System.out.print(strg[i]+" ");
            }
            System.out.println();

          cmn--;rmx++;cmx++;rmn--;
          idx=0;
        //-----------------------------------------------------------------------
          //left wall
            for(int i=rmn;i<=rmx;i++){
              arr[i][cmn]=strg[idx];
              idx++;
          }
          cmn++;
      
          //b w
          for(int j=cmn;j<=cmx;j++){
          arr[rmx][j]=strg[idx];
            idx++;
        
          }   rmx--;
          
          //r w
          for(int i=rmx;i>=rmn;i--){
             arr[i][cmx]=strg[idx];
             idx++;
          }     cmx--;
        
          //t w
          for(int j=cmx;j>=cmn;j--){
            arr[rmn][j]=strg[idx];
         idx++;
          }
          rmn++;
         
           //---------------------------------------------------------------
           
            for(int i=0;i<arr.length;i++){
              for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");

              }
              System.out.println();
            }
        
}
       public static void rotate(int [] strg,int k){
         int n=strg.length;
         k=k%n;
         k=k<0?k+n:k;      //ifk=-2 then k=-2+7=5 sa rotate
        
         reverse(strg,0,n-k-1);
         reverse(strg,n-k,n-1);
         reverse(strg,0,n-1);


       }
       public static void reverse(int [] strg,int l,int r){
         while(l<r){
           swap(strg,l,r );
           l++;
           r--;
         }
       }
       public static void swap(int [] strg,int l,int r){
         int temp=strg[l];
         strg[l]=strg[r];
         strg[r]=temp;
       }
}