import java.util.*;

public class cc6 {
    // static int[] list;
    static ArrayList<Integer> list=new ArrayList<>();
    public static void SOE(int n){
        int[] sieve=new int[n+1];

        // System.out.println("All prime number from 1 to n:-");
        
        for(int x=2;x<=n;x++){
            if(sieve[x]!=0){  //Not prime number
                continue;
            }
            // System.out.print(x+"  ");
            list.add(x);
            for(int u=2*x;u<=n;u+=x){
                sieve[u]=x;
            }
        }
    }

    public  static int bs(int targ){
        int lo=0,hi=list.size()-1;

        while(lo<hi){
            int m=lo+(hi-lo)/2;
            if(list.get(m)==targ){return m;}else
            if(list.get(m)>targ){
                hi=m;
            }else{
                lo=m+1;
            }
        }
        return hi;
    }
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
                long t=scn.nextLong();
                SOE(10000001);

                while(t-->0){
                   int d=scn.nextInt();
                   
                   int tg=d+1;
                   int idx=bs(tg);
                    int val1=list.get(idx);
                    int idx2=bs(val1+d);
                    int val2=list.get(idx2);
                    long ans=(long)((long)val1*(long)val2);

                    // System.out.println(ans+" "+val1+" "+val2);
                    System.out.println(ans);
                }
            }
        }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();

    //             while(t-->0){

    //                int n=scn.nextInt();
    //                String str=scn.next();
    //                 String nstr=""+1;
    //                 int prev=-1;
    //                 int[] arr=new int[n];

    //                 char[] ans=new char[n];
    //             if(str.charAt(0)=='1'){arr[0]+=1;}
                    
    //                arr[0]+=1;
    //                ans[0]='1';
    //                for(int i=1;i<n;i++){
    //                 if(str.charAt(i)=='1'){
    //                     arr[i]=1;
    //                 }
    //                   if(arr[i-1]!=arr[i]+1){
    //                      arr[i]+=1;  ans[i]='1';
    //                   }else{
    //                     // nstr+='0';
    //                     ans[i]='0';
    //                   }
    //                }
    //                StringBuilder sbf = new StringBuilder();
    //                sbf.append(ans);
    //             //    nstr=Arrays.toString(ans);
    //                System.out.println(sbf);
    //             }
    //         }
    //     }







    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
    //             while(t-->0){
    //                int n=scn.nextInt();
    //                int k=scn.nextInt();
                   
    //                for (int i = 1; i < 2 * k - n; ++i)
    //                System.out.print(i+" ");
        
    //              for (int i = k; i >= 2 * k - n; --i)
    //                System.out.print(i+" ");

    //             System.out.println();   
    //             }
    //         }

    // }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
    //             while(t-->0){
    //                int n=scn.nextInt();
    //                int k=scn.nextInt();
                   
    //                for (int i = 1; i < 2 * k - n; ++i)
    //                cout << i << ' ';
        
    //              for (int i = k; i >= 2 * k - n; --i)
    //                cout << i << ' ';

    //                int d=(n-k);
    //                int inv1=(d*(d+1))/2;

    //                if(inv1==0){
    //                    for(int i=1;i<=k;i++){
    //                        System.out.print(i+" ");
    //                    }
    //                }else{
    //                     int[] arr=new int[n+1];
    //                      int ct1=k,ct2=k;   
    //                     for(int i=n;i>=1;i--){
    //                         if(i>k){
    //                             arr[i]=ct1--;
    //                         }else{
    //                             arr[i]=ct2--;
    //                         }
    //                     }

    //                     int d2=n-(k+1);

    //                     int inv2=(d2*(d2+1))/2;
    //                     int st=1;
    //                     while(inv2<inv1){
    //                         int j=k;

    //                         while(j>st && inv2<inv1){
    //                             int temp=arr[j-1]; arr[j-1]=arr[j]; arr[j]=temp;
    //                             inv2++;
    //                             j--;
    //                         }
    //                         st++;
    //                     }


    //                     for(int i=1;i<=k;i++){
    //                         System.out.print(arr[i]+" ");
    //                     }
    //                }

    //                System.out.println();
    //             }
    //         }
    //     }



        // else if(d==(n-1)){
        //     for(int i=k;i>=1;i--){
        //         System.out.print(i+" ");
        //     }
        //    }


    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
    //             while(t-->0){
    //                 String str1=scn.next();
    //                 String str2=scn.next();
    //                 String p=str1;
    //                 String q=str2;

    //                 if(str1.length()>str2.length()){
    //                     if(!str1.startsWith(str2)){
    //                         System.out.println("-1");
    //                         continue;
    //                     }else{

    //                         while(str1.length() !=str2.length()){
    //                             if(str1.length()<str2.length()){
    //                                 str1=str1+p;
    //                             }else{
    //                                 str2+=q;
    //                             }
    //                             // System.out.println("rahul");
    //                         }
    //                     }
    //                 }else if(str1.length()<str2.length()){
    //                     if(!str2.startsWith(str1)){
    //                         System.out.println("-1");
    //                         continue;
    //                     }else{
    //                         while(str1.length() !=str2.length()){
    //                             if(str1.length()<str2.length()){
    //                                 str1+=p;
    //                             }else{
    //                                 str2+=q;
    //                             }
    //                         }
    //                     }
    //                 }
    //                 // else{
    //                     if(str1.equals(str2)){
    //                         System.out.println(str1);
    //                     }else{
    //                         System.out.println("-1");
    //                     }
    //                 // }
    //             }
    //         }
    //     }



    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
    //             while(t-->0){
    //                 int n=scn.nextInt();
    //                 int d=scn.nextInt();
    //                 int[] arr=new int[n];
    //                 boolean flag=true;
    //                 for(int i=0;i<n;i++){
    //                     arr[i]=scn.nextInt();
    //                     if(arr[i]>d){flag=false;}
    //                 }

    //                 if(flag){
    //                     System.out.println("Yes");
    //                 }else{
    //                     Arrays.sort(arr);
    //                     if(n==1){
    //                         System.out.println("No");
    //                     }else{
    //                         if(n>=2 && arr[0]+arr[1]<=d){
    //                             System.out.println("Yes");
    //                         }else{
    //                             System.out.println("No");
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
                
//         		while(t-->0){
//                     int n=scn.nextInt();
//                     ArrayList<ArrayList<Integer>> nlist=new ArrayList<>();
//                     ArrayList<ArrayList<Integer>> plist=new ArrayList<>();
                    
//                     long ans=0;
//                     HashMap<Integer,Integer> hm=new HashMap<>();
//                     for(int i=0;i<n;i++){
//                         int m=scn.nextInt();
//                         ArrayList<Integer> nline=new ArrayList<>();
//                         ArrayList<Integer> pline=new ArrayList<>();
                       
//                         for(int j=0;j<m;j++){
//                             int val=scn.nextInt();
//                             hm.put(Math.abs(val), hm.getOrDefault(Math.abs(val), 0)+1);
//                             //mymistake  hm.put(Math.abs(val), hm.getOrDefault(val, 0)+1);
//                             if(val<0){nline.add(val); }else{ pline.add(val); }
//                         }
//                         nlist.add(nline);
//                         Collections.reverse(pline);
//                         plist.add(pline);
                        
//                      }

//                      for(int key:hm.keySet()){
//                          if(hm.get(key)>1){ans++;}
//                      }

//                      for(int i=0;i<n;i++){
//                         ArrayList<Integer> nline=nlist.get(i);
//                         ArrayList<Integer> pline=plist.get(i);

//                         while(true){
//                             int antNearestToOrigin=0;
//                             // System.out.println("RAhul1");
//                             if(pline.size()==0 && nline.size()==0){
//                                 break;
//                             }else if(nline.size()==0){
//                                 antNearestToOrigin=pline.get(pline.size()-1);
//                             }else if(pline.size()==0){
//                                 antNearestToOrigin=nline.get(nline.size()-1);
//                             }else{
//                                 antNearestToOrigin=(Math.abs(nline.get(nline.size()-1))<pline.get(pline.size()-1))?nline.get(nline.size()-1):pline.get(pline.size()-1);
//                             }
//                             // System.out.println("RAhul"+"  "+antNearestToOrigin);

//                             if(antNearestToOrigin<0){
//                                 if(hm.get(Math.abs(antNearestToOrigin))>1){
//                                     ans+=nline.size()-1;
//                                 }else{
//                                     ans+=pline.size();
//                                 }
//                             }else{
//                                 if(hm.get(antNearestToOrigin)>1){
//                                     ans+=pline.size()-1;
//                                 }else{
//                                     ans+=nline.size();
//                                 } 
//                             }

//                             if(antNearestToOrigin<0){nline.remove(nline.size()-1);}else{pline.remove(pline.size()-1);}
                        
//                         }
//                      }     
                  
//                      System.out.println(ans);
//                 }
//             }

// }   
