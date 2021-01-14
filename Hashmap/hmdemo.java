import java.util.*;

public class hmdemo{

    static void hfc(String words){    //highest frequency character
        HashMap<Character,Integer> fmap=new HashMap<>();
        for(char ch:words.toCharArray()){
            if(fmap.containsKey(ch)==false){
             fmap.put(ch, 1);
            }else{
                fmap.put(ch, fmap.get(ch)+1);
            }
        }
        
        char mfc=words.charAt(0);
        for(char ch:fmap.keySet()){
            if(fmap.get(ch)>fmap.get(mfc)){
                mfc=ch;
            }
        }
        System.out.println(mfc);

    }
     static void gcc1(int[] one,int[] two){
         HashMap<Integer,Integer> fmap=new HashMap<>();
         
         for(int val:one){
             fmap.put(val, fmap.containsKey(val)==false?1:fmap.get(val)+1);
         }
         for(int val:two){
             if(fmap.containsKey(val)){
                 System.out.print(val+" ");
                 fmap.remove(val);
             }
         }
     }

     static void gcc2(int[] one,int[] two){
        HashMap<Integer,Integer> fmap=new HashMap<>();
        
        for(int val:one){
            fmap.put(val, fmap.containsKey(val)==false?1:fmap.get(val)+1);
        }
        for(int val:two){
            if(fmap.containsKey(val) && fmap.get(val)>0){
                System.out.print(val+" ");
                fmap.put(val, fmap.get(val)-1);
            }
        }
    }

    static void longseqconnum(int[] arr){
        HashMap<Integer,Boolean> hm=new HashMap<>();
        int ct=0;
        for(int val:arr){
            hm.put(val, true);
        }
        for(int val:arr){
            if(hm.containsKey(val-1)){
                hm.put(val, false);
            }
        }
        
        int bsp=0;
        int blen=1;
        for(int val:arr){
        int tsp=val;
        int tlen=1;
        while(hm.containsKey(val+tlen)){
            tlen++;
        }
        if(tlen>blen){
            blen=tlen;
            bsp=tsp;
        }
        }
        for(int n=bsp;n<bsp+blen;n++){
            System.out.print(n+" ");
        }
    }

    static void countsubarr(int[] arr,int targ){
        HashMap<Integer,Integer> hm=new HashMap<>();
         hm.put(0,1);
         int presum=0;
         int count=0;
        for(int val:arr){
            presum+=val;
         
             int find=presum-targ;
             if(hm.containsKey(find)){
                 count+=hm.get(find);
               }
               if(hm.containsKey(presum)==false){
                hm.put(presum,1);
            }else{
                hm.put(presum, hm.get(presum)+1);
           }
        }
        System.out.println(count);
    }
    
    static void longsubarr(int[] arr,int targ){
        HashMap<Integer,Integer> hm=new HashMap<>();
         hm.put(0,-1);
         int presum=0;
         int blen=0;
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            presum+=val;
         if(hm.containsKey(presum)==false){
             hm.put(presum,i);
         }
         if(hm.containsKey(presum-targ)){
             int tlen=i-hm.get(presum-targ);
             if(tlen>blen){
                 blen=tlen;
             }
         }
        }
        System.out.println(blen); 
    }



    static void multiplecountsubarr(int[] arr,int targ){
        HashMap<Integer,Integer> hm=new HashMap<>();
         hm.put(0,1);
         int presum=0;
         int count=0;
        for(int val:arr){
            presum+=val;
         
             int find=presum%targ;
             if(find<0){
                 find=find+targ;
             }
             if(hm.containsKey(find)){
                 count+=hm.get(find);
                 hm.put(find, hm.get(find)+1);
               }else{
                hm.put(find,1);
           }
        }
        System.out.println(count);
    }
    
    static void multiplelongsubarr(int[] arr,int targ){
        HashMap<Integer,Integer> hm=new HashMap<>();
         hm.put(0,-1);
         int presum=0;
         int blen=0;
         
        for(int i=0;i<arr.length;i++){
            int val=arr[i];
            presum+=val;
            int find=presum%targ;
             if(find<0){
                 find=find+targ;
             }
         if(hm.containsKey(presum)==false){
             hm.put(presum,i);
         }
         if(hm.containsKey(presum-targ)){
             int tlen=i-hm.get(presum-targ);
             if(tlen>blen){
                 blen=tlen;
             }
         }
        }
        System.out.println(blen); 
    }



    public static void main( String[] args){
        myhm<String,Integer> pmap=new myhm<>();
        
        pmap.put("India", 70);
        pmap.put("china", 80);
        pmap.put("us", 49);
        pmap.put("utopia", 402);
        pmap.put("pak", 44);
        pmap.put("saf", 44);
        pmap.put("eur", 44);
        pmap.put("aus", 44);
        pmap.put("australia", 44);
         //System.out.println(pmap);
        pmap.display();
         System.out.println(pmap.get("us"));
        System.out.println(pmap.remove("aus"));
        System.out.println(pmap.containsKey("pak"));
        pmap.display();
        // String words="aabbcccdtxjxxxg";
        // hfc(words);
        // int[] one={2,1,1,3,5,1,2};
        // int[] two={5,2,4,1,2,2,1};
        // gcc1(one, two);
        // System.out.println();
        // gcc2(one, two);
        // int[] arr={2,12,9,16,10,5,3,20,25,11,1,8,6};
        // System.out.println();
        // longseqconnum(arr);
        // System.out.println();
        // int[] arr2={2,3,-4,1,2,-3,0,1,1,-5,3,0,2,1,2};
        // countsubarr(arr2, 3);
        // longsubarr(arr2, 3);
        // System.out.println();
        // int[] arr3={7,5,3,4,18,9,1,7,-2,4,-15,3};
        // multiplecountsubarr(arr3,5);

    }
}