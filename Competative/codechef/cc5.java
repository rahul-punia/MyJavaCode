import java.util.*;


public class cc5 {
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
                long t=scn.nextLong();
        
                
        		while(t-->0){
                    int n=scn.nextInt();
                    // int m=scn.nextInt();

                  String red=scn.next();
                  String blue=scn.next();
                  
                //   int[] rarr=new int[10];
                //   ArrayList<Integer> list1=new ArrayList<>();
                //   ArrayList<Integer> list2=new ArrayList<>();
                  int rwin=0,bwin=0;

                  for(int i=0;i<red.length();i++){
                      if(red.charAt(i)>blue.charAt(i)){
                          rwin++;
                      }else if(red.charAt(i)<blue.charAt(i)){
                        bwin++;
                    }
                  }

                         if(rwin>bwin){
                                System.out.println("RED");
                              }else if(bwin>rwin){
                                System.out.println("BLUE");
                              }else{
                                System.out.println("EQUAL");
                              } 
                            }
                    }
        }

        //           int[] barr=new int[10];
        //           for(int i=0;i<red.length();i++){
        //               list2.add(blue.charAt(i)-'0');
        //             barr[blue.charAt(i)-'0']++;
        //           }

        //           Collections.sort(list1);
        //           Collections.sort(list2);
                 
        //           for(int i=0;i<n;i++){
        //               if(list1.get(i)>list2.get(i)){rwin++;}else if(list1.get(i)<list2.get(i)){bwin++;}
        //           }
        //         //   for(int i=9;i>=n;i--){
        //         //       if(rarr[i]>barr[i]){
        //         //         rwin+=rarr[i];//-barr[i];
        //         //       }else{
        //         //         bwin+=barr[i];//-rarr[i];
        //         //       }
        //         //     if(rwin==n || bwin==n){break;}
        //         //   }

        //           if(rwin>bwin){
        //             System.out.println("RED");
        //           }else if(bwin>rwin){
        //             System.out.println("BLUE");
        //           }else{
        //             System.out.println("EQUAL");
        //           }

        //         //   System.out.println(ans);
        //         }
        //     }
        // }


    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 int n=scn.nextInt();
    //                 int m=scn.nextInt();

    //               ArrayList<Integer> klist=new ArrayList<>();
    //               ArrayList<Integer> clist=new ArrayList<>();  
    //               for(int i=0;i<n;i++){klist.add(scn.nextInt());}

    //               for(int i=0;i<m;i++){clist.add(scn.nextInt());}

    //               Collections.sort(klist);

    //               int i=n-1;
    //               long ans=0;
    //               boolean[] visited=new boolean[n];
    //               int vt=0;
    //               while(i>=0){
    //                   int k=klist.get(i--)-1;
    //                   if(vt<=k){
    //                       ans+=clist.get(vt++);
    //                   }else{
    //                       ans+=clist.get(k);
    //                   }
    //                 //   System.out.println(ans);  
    //               }
                  
    //               System.out.println(ans);
    //             }
    //         }
    //     }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 int n=scn.nextInt();
    //                 long x=scn.nextLong();
    //                 ArrayList<long []> list=new ArrayList<>();

    //                 for(int i=0;i<n;i++){
    //                     long val=scn.nextLong();
    //                     list.add(new long[]{val,1});
    //                 }
    //                 int i=0;
    //                 long ans=0;
                
    //                 while(true){
    //                     long[] arr=list.get(i);
    //                     if(arr[0]%x==0){
    //                         if(i<n){ans+=arr[0];}
    //                         // ans+=(arr[0]/x)*(arr[1]*x);
    //                         ans+=(arr[0])*(arr[1]);
    //                         list.add(list.size(),new long[]{arr[0]/x,(arr[1]*x)});
    //                     }else{
    //                         break;
    //                     }
    //                     i++;
    //                 }
    //                 while(i<n){
    //                     long[] arr=list.get(i);
    //                     ans+=arr[0];
    //                     i++;
    //                 }

    //                 System.out.println(ans);
    //             }
    //         }
    //     }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 int n=scn.nextInt();
    //                 int x=scn.nextInt();
    //                 long maxb=0;
    //                 long sum=0;
    //                 for(int i=0;i<n;i++){
    //                     int val=scn.nextInt();
    //                     sum+=val;
    //                     maxb+=(long)Math.ceil((val*1.0)/x);
    //                 }

    //                 long minb=(long)Math.ceil((sum*1.0)/x);

    //                 System.out.println(minb+" "+maxb);
    //             }
    //         }
        
    //     }
   
   
   
    // public static void mysolve() {
    //     /*String s = sc.nextLine();
    //     char[] c = s.toCharArray();
    //     int n = c.length;*/
    //     Scanner sc=new Scanner(System.in);
        
    //     int n = sc.nextInt();
    //     int[] res = new int[n];
    //     // int[][] a = new int[n][3];
    //     PriorityQueue <int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] != a2[0] ? a1[0] - a2[0] : a1[1] - a2[1]);
    //     //min  pq
    //     TreeMap <Integer, Integer> map = new TreeMap();  //sorted HashMap
    //     for(int i = 1; i <= n; i++){
    //         int h = sc.nextInt(), w = sc.nextInt();
    //         if(h > w){
    //             int tmp = w;  w = h; h = tmp;
    //         }
    //         pq.add(new int[]{h, w, i});
    //     }
 
    //     while(!pq.isEmpty()){
    //         int[] tmp = pq.poll();
    //         Integer ind = map.lowerKey(tmp[1]);
    //         if(ind == null) res[tmp[2] - 1] = -1;
    //         else res[tmp[2] - 1] = map.get(ind);
    //         while(!pq.isEmpty() && pq.peek()[0] == tmp[0]){
    //             int[] tmp2 = pq.poll();
    //             Integer ind2 = map.lowerKey(tmp2[1]);
    //             if(ind2 == null) res[tmp2[2] - 1] = -1;
    //             else res[tmp2[2] - 1] = map.get(ind2);
    //         }
    //         map.put(tmp[1], map.getOrDefault(tmp[1], tmp[2]));
    //     }
    //     for(int i : res) System.out.print(i + " ");
    //     System.out.println();
    // }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 mysolve();
    //             }
    //         }
    //     }
    
            //         int n=scn.nextInt();
            //         int[] wt=new int[n];
            //         int[] ht=new int[n];

            //         int mht=0,mwt=0;
            //         for(int i=0;i<n;i++){

            //             wt[i]=scn.nextInt();
            //             ht[i]=scn.nextInt();
            //             if(i>0){
            //                 if(wt[i]<wt[mwt] && ht[i]<ht[mht]){
            //                     mht=i; mwt=i;
            //                 }else if(ht[i]<wt[mwt] && wt[i]<ht[mht]){
            //                     mht=i; mwt=i;
            //                 }
            //             }
            //         }

            //         int[] strg=new int[n];
            //         Arrays.fill(strg,-1);
            //         for(int j=0;j<n;j++){
            //             if(ht[mht]<ht[j] && wt[mwt]<wt[j]){
            //                 strg[j]=mht+1; 
            //             }else if(ht[mht]<wt[j] && wt[mwt]<ht[j]){
            //                 strg[j]=mht+1;
            //              }
            //             }

            //                 for(int j=0;j<n;j++){
            //                     System.out.print(strg[j]+" ");
            //                 }
            //                 System.out.println();
            //             }
            //         }
            // }
                        // for(int i=0;i<n;i++){
                        //     if(ht[i]<ht[j] && wt[i]<wt[j]){
                        //         strg[j]=i+1; break;
                        //     }else if(ht[i]<wt[j] && wt[i]<ht[j]){
                        //         strg[j]=i+1;
                        //         break;
                        //     }
                        // }
        //             }

        //             for(int j=0;j<n;j++){
        //                 System.out.print(strg[j]+" ");
        //             }
        //             System.out.println();
        //         }
        //     }
        // }

    //                 PriorityQueue<Integer> epq=new PriorityQueue<>(Collections.reverseOrder());
    //                 PriorityQueue<Integer> opq=new PriorityQueue<>(Collections.reverseOrder());
                    
    //                 for(int i=0;i<n;i++){
    //                     int val=scn.nextInt();
    //                     if(val%2==1){
    //                         opq.add(val);
    //                     }else{  
    //                         epq.add(val);
    //                     }
    //                 }

    //                 boolean turn=true;
    //                 long alice=0,bob=0;
    //                 while(opq.size()>0 && epq.size()>0){
    //                      if(turn){
    //                         if(epq.peek()>opq.peek()){alice+=epq.remove();}else{opq.remove();}
    //                      }else{
    //                         if(opq.peek()>epq.peek()){bob+=opq.remove();}else{epq.remove();}
    //                      }
    //                      turn=!turn;
    //                 }
    //                 while(opq.size()>0 || epq.size()>0){
    //                     if(turn){
    //                        if(epq.size()>0){alice+=epq.remove();}else{opq.remove();}
    //                     }else{
    //                        if(opq.size()>0){bob+=opq.remove();}else{epq.remove();}
    //                     }
    //                     turn=!turn;
    //                }

    //                 if(alice>bob){
    //                     System.out.println("Alice");
    //                 }else if(alice<bob){System.out.println("Bob");
    //                 }else{System.out.println("Tie");}
    //             }
    //         }
    // }



    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 int n=scn.nextInt();
    //                 long[] arr=new long[n];


    //                 for(int i=0;i<n;i++){
    //                     arr[i]=scn.nextLong();
    //                 }

    //                 long[] strg=new long[n];
    //                 long max=0;
    //                 for(int i=0;i<n;i++){

    //                     if((i+arr[i])<n){
    //                         int idx=(int)(i+arr[i]);
    //                         strg[idx]=Math.max(strg[idx],strg[i]+arr[i]);
    //                     }
    //                     max=Math.max(max,strg[i]+arr[i]);
    //                 }

    //                 System.out.println(max);
    //             }
    //         }
    // }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             long t=scn.nextLong();
        
                
    //     		while(t-->0){
    //                 int n=scn.nextInt();

    //                 // int[] arr=new int[n];
    //                 int ct1=0,ct2=0;
    //                 for(int i=0;i<n;i++){
    //                     int val=scn.nextInt();
    //                     if(val==1){ct1++;}else{ct2++;}
    //                 }

    //                 if((ct1%2==0 && ct2%2==0)){
    //                     System.out.println("YES");
    //                 }else if((ct1%2==0 && ct2%2==1 && ct1>0)){
    //                     System.out.println("YES");
    //                 }else{
    //                     System.out.println("NO");    
    //                 }
    //             }
    //         }
    //     }
//                     long w=scn.nextLong();
//                     long h=scn.nextLong();
//                     long n=scn.nextLong();
                    
//                     long ans=1; long ct=1;
//                     while(ans<n){

//                         if(w%2==0){
//                             w=w/2;
//                             ans=2*ans;
//                             // ct++;
//                         }else if(h%2==0){
//                             h=h/2;
//                             ans=2*ans;
//                             // ct++;
//                         }else{
//                             break;
//                         }
//                     }
//                    if(ans>=n){
//                        System.out.println("YES");
//                    }else System.out.println("NO"); 

//                 }
//     }
// }
