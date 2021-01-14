import java.util.*;

public class myhm<K,V>{
    private class Pair{
        K key;
        V value;
        Pair(){}
        Pair(K key,V value){
            this.key=key;
            this.value=value;
        }
    };
    private LinkedList<Pair>[] buckets;
    private int size=0;
    public myhm(){
        buckets=new LinkedList[4];
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
        }
    }
   public void  display(){
    System.out.println("--------------------");
     for(int bi=0;bi<buckets.length;bi++){
         System.out.print(bi+"->");
         for(Pair p:buckets[bi]){
           System.out.print("["+p.key+"-"+p.value+"]");
         }
         System.out.println();
     }
   }
    
    private int hashfunction(K key){
        int hc=key.hashCode();    //hashcode
        int bi=Math.abs(hc)%buckets.length;   //bucketindex
        return bi;
    }
    private int  findwithinbuck(K key,int bi){
        int di=0;    //data index
        for(Pair p:buckets[bi]){
            if(p.key.equals(key)){
                return di;
            }
            di++;
        }
        return -1;       //if data do not exist before then return -1
    }

    private void rehash(){
        LinkedList<Pair>[] obuckets=buckets;
  
        buckets=new LinkedList[obuckets.length*2];
  
        for(int i=0;i<buckets.length;i++){
            buckets[i]=new LinkedList<>();
        }
        size=0;
        for(int bi=0;bi<obuckets.length;bi++){
            for(Pair p:obuckets[bi]){
                put(p.key,p.value);
            }
        }
    }
    public void put(K key,V value){
      int bi=hashfunction(key);
      int di=findwithinbuck(key,bi);
      //System.out.println(di);
      if(di==-1){
          Pair p2a=new Pair(key, value);
          buckets[bi].add(p2a);
          size++;
      }else{
          Pair p2u=buckets[bi].get(di);
          p2u.value=value;
      }
      double lambda=(size*1.0)/buckets.length;
      if(lambda>2.0){
       rehash();
      }
    }
    public boolean containsKey(K key){
        int bi=hashfunction(key);
        int di=findwithinbuck(key,bi);
  
        if(di==-1){
            return false;
        } else{
            return true;
        } 
    }

    public V get(K key){
        int bi=hashfunction(key);
        int di=findwithinbuck(key,bi);
  
        if(di==-1){
            return null;
        } else{
            Pair p2g=buckets[bi].get(di);
            return p2g.value;
        } 
    }

    public V remove(K key){
        int bi=hashfunction(key);
        int di=findwithinbuck(key,bi);
  
        if(di==-1){
            return null;
        } else{
            Pair p2r=buckets[bi].remove(di);
            size--;
            return p2r.value;
        } 
    }
    public ArrayList<K> keyset(){
        ArrayList<K> keys=new ArrayList<>();

        for(int vi=0;vi<buckets.length;vi++){
            for(Pair p:buckets[vi]){
                keys.add(p.key);
            }
        }
        return keys;
    }
  
};