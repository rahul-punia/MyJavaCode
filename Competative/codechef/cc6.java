import java.util.*;

public class cc6 {

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
                long t=scn.nextLong();
                while(t-->0){
                   int n=scn.nextInt();
                   int k=scn.nextInt();
                   
                   for (int i = 1; i < 2 * k - n; ++i)
                   System.out.print(i+" ");
        
                 for (int i = k; i >= 2 * k - n; --i)
                   System.out.print(i+" ");

                System.out.println();   
                }
            }

    }

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
