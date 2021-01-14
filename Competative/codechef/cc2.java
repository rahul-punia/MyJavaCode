import java.util.*;

public class cc2 {

    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        long t=scn.nextLong();


        while(t-->0){
            int n=scn.nextInt();
            ArrayList<ArrayList<Integer>> nlist=new ArrayList<>();
            ArrayList<ArrayList<Integer>> plist=new ArrayList<>();
            
            long ans=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<n;i++){
                int m=scn.nextInt();
                ArrayList<Integer> nline=new ArrayList<>();
                ArrayList<Integer> pline=new ArrayList<>();
                int cn=0,cp=0;
            
                for(int j=0;j<m;j++){
                    int val=scn.nextInt();
                    hm.put(Math.abs(val), hm.getOrDefault(Math.abs(val), 0)+1);
                    //My mistake  

                    if(val<0){nline.add(0,val); cn++;}else{ pline.add(val); cp++;}
                }
                nlist.add(nline);
                plist.add(pline);

                if(n==1){
                    while(cn>0 && cp>0){
                        ans+=(cn+cp)-1;
                        cn--; cp--;
                    }
                }
             }

             if(n==1){System.out.println(ans); continue;}

             HashSet<Integer> hset=new HashSet<>();
             for(int i=0;i<n;i++){
                ArrayList<Integer> nline=nlist.get(i);
                ArrayList<Integer> pline=plist.get(i);
                

                int j=0;
                while(j<nline.size() || j<pline.size()){
                    boolean flag=true;
                     if(pline.size()>0 && nline.size()>0 && Math.abs(nline.get(j))<=pline.get(j)  && hm.get(Math.abs(nline.get(j)))>1){
                        int val=Math.abs(nline.get(j));
                        ans+=(nline.size()-1);
                        if(!hset.contains(val)){ans++; hset.add(val);}
                        nline.remove(0);  flag=false;
                     }
                     if(pline.size()>0 && nline.size()>0 && Math.abs(nline.get(j))>=pline.get(j) && hm.get(pline.get(j))>1){
                        ans+=(pline.size()-1);
                        if(!hset.contains(pline.get(j))){ans++; hset.add(pline.get(j));}
                        pline.remove(0);  flag=false;
                     }
                     
                     if(pline.size()==0 && nline.size()>0   && hm.get(Math.abs(nline.get(j)))>1){
                        int val=Math.abs(nline.get(j));
                        ans+=(nline.size()-1);
                        if(!hset.contains(val)){ans++; hset.add(val);}
                        nline.remove(0);  flag=false;
                     }
                     if(pline.size()>0 && nline.size()==0 &&   hm.get(pline.get(j))>1){
                        ans+=(pline.size()-1);
                        if(!hset.contains(pline.get(j))){ans++; hset.add(pline.get(j));}
                        pline.remove(0);  flag=false;
                     }

                     if(flag){
                         if(nline.size()>0 && pline.size()>0){
                            ans+=(nline.size()-1)+(pline.size()-1)+1; 
                            nline.remove(0); 
                            pline.remove(0);  flag=false;
                         }else if(nline.size()>0){
                            nline.remove(0);
                         }else if(pline.size()>0){
                            pline.remove(0);
                         }
                     }

                    //  System.out.println(ans);
                }
             }




            System.out.println(ans); 
        }
    }
}










// import java.util.*;

// public class cc2 {

//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();


//         while(t-->0){
//             int n=scn.nextInt();
//             ArrayList<ArrayList<Integer>> nlist=new ArrayList<>();
//             ArrayList<ArrayList<Integer>> plist=new ArrayList<>();
            
//             long ans=0;
//             HashMap<Integer,Integer> hm=new HashMap<>();
//             for(int i=0;i<n;i++){
//                 int m=scn.nextInt();
//                 ArrayList<Integer> nline=new ArrayList<>();
//                 ArrayList<Integer> pline=new ArrayList<>();
//                 int cn=0,cp=0;
            
//                 for(int j=0;j<m;j++){
//                     int val=scn.nextInt();
//                     hm.put(Math.abs(val), hm.getOrDefault(val, 0)+1);

//                     if(val<0){nline.add(0,val); cn++;}else{ pline.add(val); cp++;}
//                 }
//                 nlist.add(nline);
//                 plist.add(pline);

//                 if(n==1){
//                     while(cn>0 && cp>0){
//                         ans+=(cn+cp)-1;
//                         cn--; cp--;
//                     }
//                 }
//              }

//              if(n==1){System.out.println(ans); continue;}

//              HashSet<Integer> hset=new HashSet<>();
//              for(int i=0;i<n;i++){
//                 ArrayList<Integer> nline=nlist.get(i);
//                 ArrayList<Integer> pline=plist.get(i);
                
//                 int j=0;
//                 while(j<nline.size() || j<pline.size()){
//                     boolean flag=true;
//                      if(pline.size()>0 && nline.size()>0 && Math.abs(nline.get(j))<=pline.get(j)  && hm.get(Math.abs(nline.get(j)))>1){
//                         int val=Math.abs(nline.get(j));
//                         ans+=(nline.size()-1);
//                         if(!hset.contains(val)){ans++; hset.add(val);}
//                         nline.remove(0);  flag=false;
//                      }
//                      if(pline.size()>0 && nline.size()>0 && Math.abs(nline.get(j))>=pline.get(j) && hm.get(pline.get(j))>1){
//                         ans+=(pline.size()-1);
//                         if(!hset.contains(pline.get(j))){ans++; hset.add(pline.get(j));}
//                         pline.remove(0);  flag=false;
//                      }
                     
//                      if(pline.size()==0 && nline.size()>0   && hm.get(Math.abs(nline.get(j)))>1){
//                         int val=Math.abs(nline.get(j));
//                         ans+=(nline.size()-1);
//                         if(!hset.contains(val)){ans++; hset.add(val);}
//                         nline.remove(0);  flag=false;
//                      }
//                      if(pline.size()>0 && nline.size()==0 &&   hm.get(pline.get(j))>1){
//                         ans+=(pline.size()-1);
//                         if(!hset.contains(pline.get(j))){ans++; hset.add(pline.get(j));}
//                         pline.remove(0);  flag=false;
//                      }

//                      if(flag){
//                          if(nline.size()>0 && pline.size()>0){
//                             ans+=(nline.size()-1)+(pline.size()-1)+1; 
//                             nline.remove(0); 
//                             pline.remove(0);  flag=false;
//                          }else if(nline.size()>0){
//                             nline.remove(0);
//                          }else if(pline.size()>0){
//                             pline.remove(0);
//                          }
//                      }
                     
//                     //  System.out.println(ans);
//                 }
//              }


//             System.out.println(ans); 
//         }
//     }
// }














//     public static void main(String[] args){

//         Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();
    

//         while(t-->0){
//             String str=scn.next();

//             if(str.length()%2==1){
//                 System.out.println(-1);
//             }else{
//                 // Stack<Character> st=new Stack<>();
//                 int ct1=0,ct0=0;
//                 for(int i=0;i<str.length();i++){
//                     char ch=str.charAt(i);
//                     if(ch=='1')ct1++;
//                     else ct0++;
//                  }

//                  if(ct0==0 || ct1==0){
//                      System.out.println(-1);
//                  }else{
//                     System.out.println(str.length()/2-Math.min(ct0,ct1));
//                  }
//             }

//         }
//             // int x=scn.nextInt();
//             // int y=scn.nextInt();
//             // int k=scn.nextInt();
//             // int n=scn.nextInt();
            
//             // int max=Math.max(x,y);
//             // int min=Math.min(x,y);
            
//             // int diff=Math.abs(x-y);
//             // if(diff%k==0 && (diff/k)%2!=0){
//             //     System.out.println("NO");
//             // }else{
//             //     System.out.println("YES");
//             // }
//         // }

//         // while(t-->0){
//         //     int n=scn.nextInt();

//         //     String str=scn.next();
//         //     int p=0;
//         //     for(int i=0;i<str.length();i++){
//         //         if(str.charAt(i)=='1')p++;
//         //     }

//         //     int tp=p+(120-n);

//         //     double per=((tp*1.0)/120)*100.0;

//         //     if(per>=75){
//         //         System.out.println("YES");
//         //     }else{
//         //         System.out.println("NO");
//         //     }
//         // }
//     }
// }
