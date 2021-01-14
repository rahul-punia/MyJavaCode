import java.util.*;

public class tns{

  public static int[] mergetwosortarr(int[] fh,int[] sh){
     int i=0;
     int j=0;
     int k=0;
     int[] fla=new int[fh.length+sh.length];
     while(i<fh.length && j<sh.length){
         if(fh[i]<sh[j]){
             fla[k++]=fh[i++];
         }else{
             fla[k++]=sh[j++];
         }
     }
     while(i<fh.length){
        fla[k++]=fh[i++];
     }

     while(j<sh.length){
        fla[k++]=sh[j++];
     }
    return fla;
   }

   public static int[] mergesort(int lo,int hi,int[] arr){
        if(lo==hi){
            int[] ba=new int[1];
            ba[0]=arr[lo];
            return ba;
        }
        int mid=(lo+hi)/2;
       int[] fh =mergesort(lo, mid, arr);
       int[] sh= mergesort(mid+1, hi, arr);
       int[] fla=mergetwosortarr(fh,sh);
      return fla;
    }
   public static void fun(int x,int n){

       int cof=0;
       int p=x;
       int k=0;
       int sum=0;
       for(int i=n;i>=1;i--){
           //coff=i;
           
           sum+=i*p;
            p=p*x;
       }
       System.out.println((sum));
   }
   static void soe(int n){
       boolean[] arr=new boolean[n+1];
       for(int i=2;i<arr.length;i++){
           arr[i]=true;
       }
       for(int i=2;i*i<=n;i++){
           if(arr[i]==true){
           for(int j=i;i*j<=n;j++){
               if(arr[i*j]==true){
                   arr[i*j]=false;
               }
               }
           }
        }
       for(int i=0;i<arr.length;i++){
           if(arr[i]==true){
               System.out.print(i+" ");
           }
       }
   }

   static int[] getspf(int n){
       int[] res=new int[n+1];
       boolean[] primes=new boolean[n+1];
       Arrays.fill(primes, true);
       primes[0]=false;
       primes[1]=false;
       for(int i=2;i<res.length;i++){
           res[i]=i;
       }
       for(int i=2;i*i<=n;i++){
           for(int j=i;j*i<=n;j++){
               if(primes[i*j]==true){
                primes[i*j]=false;
                res[i*j]=i;
               }
           }
       }
       return res;
   }
    static void factorization(int[] spf,int x){
        System.out.print(x+"=");
        while(x>1){
            System.out.print(spf[x]+"*");
            x=x/spf[x];
        }
        System.out.println();
    } 
    static void setAbit(int x,int k){
        System.out.println(x+"="+Integer.toBinaryString(x));
        int bm=1<<k;
        x=(x|bm);
        System.out.println(x+"="+Integer.toBinaryString(x));
    }

    static void unsetAbit(int x,int k){
        System.out.println(x+"="+Integer.toBinaryString(x));
        int bm=~(1<<k);
        x=(x&bm);
        System.out.println(x+"="+Integer.toBinaryString(x));
    }

    static void toogleAbit(int x,int k){
        System.out.println(x+"="+Integer.toBinaryString(x));
        int bm=(1<<k);
        x=(x^bm);
        System.out.println(x+"="+Integer.toBinaryString(x));
    }
    static int counter=0;
   
    //ncaps problem


    static int countwaysTogoParty(int pidx,ArrayList<Integer>[] pcmap,int mask,int[][] strg){
         if(pidx==pcmap.length){  //person idx    
             return 1;            //mask(bit manipulation) is use to check cap is available or not
         }
         
         if(strg[pidx][mask]!=0){     //without memoization 33 calls but with memoization only 23 calls
             return strg[pidx][mask];
         }
         System.out.println(++counter+"."+pidx+" "+mask);  //used to count no of calls in memoization
         int count=0;
        for(int cap:pcmap[pidx]){
            if((mask&(1<<cap))==0){
               mask=mask^(1<<cap);   //toggle a cap-take
               int cc=countwaysTogoParty(pidx+1, pcmap,mask,strg);
               count+=cc;
               mask=mask^(1<<cap);   //toggle a cap-untake
          }
        }
        strg[pidx][mask]=count;      //store result
        return count;
    }
    static int partioning(int[] arr,int lo,int hi){
     int i=lo;
     int j=lo;
     int pe=arr[hi];

     while(i<=hi){
        if(arr[i]<=pe){    //Agar element chotta ya equal ha to to swap karenga arr[i] & arr[j] then i++,j++
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        i++;
        j++;
        }else{           //Agar element bada ha last pivot element sa to sirf i++
            i++;
        }
     }
     return j-1;
    }
     
   static int quickselect(int[] arr,int k,int lo,int hi){
       int pi=partioning(arr, lo, hi);
       while(lo<=hi){
       if(pi<k){
          partioning(arr, pi+1, hi);
       }else if(pi>k){
         return  quickselect(arr, k, lo, pi-1);
       }else{
           return arr[pi];
       }
    }
    return 0;//doubt
   }
    static void quicksort(int[] arr,int lo,int hi){
        if(lo>=hi){
            return;
        }
        int pi=partioning(arr,lo,hi);
        quicksort(arr, lo, pi-1);
        quicksort(arr, pi+1, hi);
    }
    static int[] countsort(int[] input){
        int n=input.length;
        int r=10;
        int[] fm=new int[r];

        for(int val:input){
            fm[val]++;
        }

        for(int i=1;i<fm.length;i++){
            fm[i]+=fm[i-1];
        }

        int[] output=new int[n];

        for(int i=input.length-1;i>=0;i--){
            int val=input[i];
            fm[val]--;
            output[fm[val]]=val;
        }
    return output;
    }

    static int[] countsortForRS(int[] input,int div){
        int n=input.length;
        int r=10;
        int[] fm=new int[r];

        for(int val:input){
            val=(val/div)%10;
            fm[val]++;
        }
        for(int i=1;i<fm.length;i++){
            fm[i]+=fm[i-1];
        }

        int[] output=new int[n];
         for(int i=input.length-1;i>=0;i--){
            int val=(input[i]/div)%10;
            fm[val]--;
            output[fm[val]]=input[i];
        }
    return output;
    }
    static int[] radixsort(int[] input){
        int max=0;
        for(int val:input){
            max=Math.max(max, val);
        }
        int div=1;
        while(max/div!=0){
            input=countsortForRS(input,div);
            div=div*10;
        }
        return input;
    }
    
    static void highfreqch(String str){
        int[] arr=new int[26];

        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-97]++;
        }
        int mfi=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mfi){
                mfi=i;
            }
        }
        System.out.println(str.charAt(mfi));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int ct=0;
        int[] freq=new int[arr.length];
        
        int[] sarr=mergesort(0,arr.length-1,arr);
        for(int i=0;i<sarr.length;i++)
        System.out.print(sarr[i]+" ");
        System.out.println();
        for(int i=0;i<sarr.length-1;i++){
           if(sarr[i]==sarr[i+1]){
            freq[ct]=freq[ct]+1;
           }else{
               freq[ct]=freq[ct]+1;
               ct++;
           }
        }
        if(sarr[sarr.length-1]!=sarr[sarr.length-2]){
             freq[ct]=freq[ct]+1;
               ct++;
        }else{
            freq[ct]=freq[ct]+1; 
        }
        for(int i=0;i<freq.length;i++)
        System.out.print(freq[i]+" ");

     for(int i=0;i<freq.length;i++){
         for(int j=i+1;j<freq.length;j++){
             if(freq[i]==0){
                 return true;
             }else if(freq[i]==freq[j]){
                 return false;
             }
         }
     }
        return true;
    }
    public static void main(String[] args){
        int[] arrw={1,2,3,3,4,3,2,1,4};
        System.out.println(uniqueOccurrences(arrw));
//      int[] arr={4,3,2,1,5,6,9,8,7};
//      int[] sa=new int[arr.length];
//     // sa=mergesort(0,arr.length-1,arr);
//     // System.out.println(Arrays.toString(sa));
//     // fun(2,3);
//      //soe(9);
//      System.out.println();
//     int[] spf=getspf(10000);
//    // factorization(spf, 360);
//    // factorization(spf, 18);
//      setAbit(57, 2);
//      unsetAbit(57,3);
//      toogleAbit(57,2);
     ArrayList<Integer>[] pcmap=new ArrayList[]{   //person cap map
         new ArrayList<>(Arrays.asList(0,2,4)),
         new ArrayList<>(Arrays.asList(0,1,2,3)),
         new ArrayList<>(Arrays.asList(1,2,3)),
         new ArrayList<>(Arrays.asList(0,4))};
    //   int[] arr={20,50,10,80,60,30,70,40};
    //  int ans=quickselect(arr, 5, 0,arr.length-1);
    //  System.out.println(ans);
    //  quicksort(arr, 0, arr.length-1);
    //  System.out.println(Arrays.toString(arr));
    
    int caps=5;
    int[][] strg=new int[pcmap.length][1<<caps];  //(1<<cap)(11111)-32
    System.out.println("total ways-->"+countwaysTogoParty(0,pcmap,0,strg));
   // int[] input={259,68,347,924,136,425,719,88,463,527,634,725,978};
    // int[] sa=radixsort(input);

    // System.out.println(Arrays.toString(sa));
    // int[] carr={0,1,2,0,5,6,5,7,4,8,9,8,3};
    // String str="aaaaabbcdabccdabbc";
    // highfreqch(str);
    }
}