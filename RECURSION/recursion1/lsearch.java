import java.util.*;
public class lsearch{
    public static void main(String [] argc){
        int [] arr={10,20,30,20,40,20,50};
       boolean ans= linsrh(arr,0,60);
       System.out.println(ans);
       System.out.println(firstidx(arr,0,20));
       System.out.println(lastidx(arr,0,20));
    //    int res[]=printallidxarr(arr,0,20,-1);
    //    for(int ans1:res){
    //        System.out.print(ans1+" ");
    //    }
       System.out.println(binsrch(arr,0,300,0,arr.length-1));
       int res[]=allidx(arr,20,0,0);
       for(int ans1:res){
           System.out.print(ans1+" ");
       }
       System.out.println();
       reversearr(arr,0,arr.length-1);
       for(int ans2:arr){
        System.out.print(ans2+" ");
    }
    }
    public static boolean binsrch(int [] arr,int idx,int key,int l,int r){
      //  int l=0;
     //   int r=arr.length-1;
        int m=(l+r)/2;
        if(l>r){
            return false;
        }
        
          if(arr[idx]<arr[m]){
          r=m-1;
          }else if(arr[idx]>arr[m]){
              l=m+1;
          }else{
              return true;
          }
       boolean res= binsrch(arr,idx/2,key,l,r);
        
     return res;

    }

    public static int []  printallidxarr(int [] arr,int idx,int key,int cidx){
        if(idx==arr.length){
            int [] strg=new int[cidx+1];
            return strg;
        } 
        if(arr[idx]==key){
            cidx++;
        }
        int [] strg= printallidxarr(arr,idx+1,key,cidx);
         
          if(arr[idx]==key){
              strg[cidx]=idx;
             // sidx--;
          }

          return strg;
        }
    public static boolean linsrh(int [] arr,int idx,int key){
        if(idx==arr.length){
             return false;
            }
          if(arr[idx]==key){
              return true;
          }else{
              boolean lsnm1=linsrh(arr,idx+1,key);
              return lsnm1;
          }       

        // boolean res=linsrh(arr,idx+1,key);
        // if(res==true){
        // return res;
        // }else if(arr[idx]==key){
        //     res= true;
        // }
        // return res;
    }
    
    static int fi=Integer.MAX_VALUE;
    public static int firstidx(int [] arr,int idx,int key){
        if(idx==arr.length){
            return -1;
         }
                  if(arr[idx]==key){
                      return idx;
                  }else{
                      int fisa=firstidx(arr,idx+1,key);
                      return fisa;
                  }       
       
    }
    public static int lastidx(int [] arr,int idx,int key){
        if(idx==arr.length){
            return -1;
         }
                  
              int fisa=lastidx(arr,idx+1,key);
                     if(fisa!=-1){
                          return fisa;
                      }else if(arr[idx]==key){
                        return idx;
                    }else{
                        return -1;
                    }      
       
    }
    public static int[] allidx(int [] arr,int key,int csf,int idx){
        if(idx==arr.length){
            return new int[csf];
        }

        if(arr[idx]==key){
            int [] res=allidx(arr,key,csf+1,idx+1);
            res[csf]=idx;
            return res;
        }else{
            //5k
           int [] res= allidx(arr,key,csf,idx+1);
          return res;
        }
    }
    public static void reversearr(int [] arr,int l,int r){
           if(l>r){
               return;
           }
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            reversearr(arr,l+1,r-1);
    }
}