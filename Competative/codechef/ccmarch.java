import java.util.*;
import java.lang.*;
import java.io.*;



public class ccmarch {

//HashMap<Integer,Integer> hm=new HashMap<>();
//ArrayList<Integer> list=new ArrayList<>();
//HashSet<Integer> hs=new HashSet<>();
//Stack<Integer> st=new Stack<>();
//Queue<Integer> q=new LinkedList<>();
//PriorityQueue<Integer> pq=new PriorityQueue<>();
// static ArrayList<ArrayList<Integer>> gp=new ArrayList<>();
//int[] arr=new int[n];
//System.out.println("YES");
//1 hr- atleast 2 qs d-2
//Mt_do 3 qs d-2  
//Mt_do 4 qs d-3
//StringBuilder sb=new StringBuilder();


public static long solve(long[] hts){
    long ans=0;
    return ans;
}

static ArrayList<ArrayList<Integer>> gp;
  static long mod=10000_00007;
  static long[] facts=new long[1000_001];
  public static long fact(long n){
    long ans=1;  facts[0]=1;
    facts[1]=1;
    for(int i=2;i<=n;i++){
      facts[i]=((long)facts[i-1]*(long)(i))%mod;  facts[i]=facts[i]%mod;  
    }
    return ans;
  }

  public static long bfs(int s){
    long ans=0;

    Queue<Integer> q=new LinkedList<>();
    q.add(s);
    boolean[] vst=new boolean[gp.size()];
    int ct=0;  
    // System.out.println(s+" ans1=="+ans);
    while(q.size()>0){
      int sz=q.size();  int dgr=0;
      
      while(sz-->0){
      int rem=q.peek();  q.remove();
        
      if(vst[rem])continue;
      vst[rem]=true;
      dgr+=gp.get(rem).size()-1;
      
      // System.out.println("rem="+rem);
      if(gp.get(rem).size()>0)
      for(int nbr:gp.get(rem)){
        if(!vst[nbr]){
          q.add(nbr);
        }
      }
      }
      // System.out.println("dgr="+dgr);
      if(ct==0){ ans=facts[dgr+1];}
      else{ans=(ans*facts[dgr])%mod;}  //long ft=fact(dgr);
      ct++;
    }

    // System.out.println("ans  "+ans);
    return ans;
  }


public static void main(String[] args) throws Exception{
  InputStreamReader ip=new InputStreamReader(System.in);
  BufferedReader br = new BufferedReader(ip);
  int t= Integer.parseInt(br.readLine());
  fact(1000_000);

  while(t-->0){
  //    long n=Long.parseLong(br.readLine());//Integer.parseInt(strs[0]);
      String[] strs=(br.readLine()).trim().split(" ");
      int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,x=Integer.parseInt(strs[2]);
      // int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);
      // String str=(br.readLine()).trim();
        // int[][] edges=new int[n-1][2];
        gp=new ArrayList<>();   //my biggest mistake That I did many times int many intern contests
        for(int i=0;i<=n;i++){
          gp.add(new ArrayList<>());
        }

        for(int i=0;i<(n-1);i++){
          strs=(br.readLine()).trim().split(" ");

          int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
          gp.get(u).add(v);       gp.get(v).add(u);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a1,int []a2){
              if(a1[0]!=a2[0])return a2[0]-a1[0];
              return a2[1]-a1[1];
            }
        });
        // System.out.println(pq.size()+"  Soln  "+gp.size());
        for(int i=1;i<=n;i++){
          int ci=(int)bfs(i);
          System.out.println(ci+" "+i);
          if(pq.size()<2){
            pq.add(new int[]{ci,i});
          }else{
             int[] pr1=pq.remove();  int[] pr2=pq.remove();

             if(pr2[0]<=ci || (pr2[0]==ci && pr2[0]<i)){
               pq.add(new int[]{ci,i});
             }else{
               pq.add(pr2);
             }
             pq.add(pr1);
          }
        }

        if(k==1){
          int[] pr1=pq.remove(); // int[] pr2=pq.remove();
          System.out.println(pr1[1]+" "+pr1[0]);
        }else{
          int[] pr1=pq.remove();  int[] pr2=pq.remove();
          System.out.println(pr2[1]+" "+pr2[0]);
        }
    }
  }
}




// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    long n=Long.parseLong(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int r=Integer.parseInt(strs[0]),c=Integer.parseInt(strs[1]),x=Integer.parseInt(strs[2]);
//         // int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);
//         // String str=(br.readLine()).trim();

//           int[][] mata=new int[r][c];  
//           int[][] matb=new int[r][c];  

//           for(int i=0;i<r;i++){
//             strs=(br.readLine()).trim().split(" ");
//             for(int j=0;j<c;j++){
//                 mata[i][j]=Integer.parseInt(strs[j]);
//             }
//           }

//           boolean fg=true;
//           for(int i=0;i<r;i++){
//             strs=(br.readLine()).trim().split(" ");
//             for(int j=0;j<c;j++){
//                 matb[i][j]=Integer.parseInt(strs[j]);

//                 if(mata[i][j]!=matb[i][j]){fg=false;}
//             }
//           }


//           if(x==1 || fg){
//               System.out.println("Yes");  continue;
//           }

//           boolean fl=true;

//           if(c==x){
//             for(int j=0;j<c;j++){
//             for(int i=0;i<=(r-x);i++){
//               int diff=matb[i][j]-mata[i][j];
                
//                 for(int k=i;diff!=0 && k<(i+x) && k<r;k++){
//                   mata[k][j]+=diff;
//                 }
//               }
//             }


//             for(int i=(r-x)+1;i<(r);i++){
//             for(int j=0;j<=(c-x);j++){
              
//                 int diff=matb[i][j]-mata[i][j];
                  
//                   for(int k=j;diff!=0 && k<(j+x) && k<c;k++){
//                     mata[i][k]+=diff;
//                   }
//                 }
//               }

              
//               for(int i=0;i<r;i++){
//                 for(int j=0;j<c;j++){
//                   if(mata[i][j]!=matb[i][j]){fl=false; break;}
//                 }
//                 if(!fl)break;
//               }

//           }else{
//             for(int i=0;i<(r);i++){
//               for(int j=0;j<=(c-x);j++){
//                 int diff=matb[i][j]-mata[i][j];
                  
//                   for(int k=j;diff!=0 && k<(j+x) && k<c;k++){
//                     mata[i][k]+=diff;
//                   }
//                 }
//               }
  
//               for(int j=(c-x)+1;j<c;j++){
//               for(int i=0;i<=((r-x));i++){
                
//                   int diff=matb[i][j]-mata[i][j];
                    
//                     for(int k=i;diff!=0 && k<(i+x) && k<r;k++){
//                       mata[k][j]+=diff;
//                     }
//                   }
//                 }
  
                
//                 for(int i=0;i<r;i++){
//                   for(int j=0;j<c;j++){
//                     if(mata[i][j]!=matb[i][j]){fl=false; break;}
//                   }
//                   if(!fl)break;
//                 }
//           }

//           if(fl){
//             System.out.println("Yes");
//           }else{
//             System.out.println("No");
//           }


//         }
//     }
// }










// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//        long n=Long.parseLong(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         // int n=Integer.parseInt(strs[0]),e=Integer.parseInt(strs[1]),h=Integer.parseInt(strs[2]);
//         // int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);
//         // String str=(br.readLine()).trim();

       


//         Stack<long[]> st=new Stack<>();
//         long[][] prs=new long[(int)n][2];

//         for(int i=0;i<n;i++){
//             prs[i][1]=Long.parseLong(strs[i]);
//             prs[i][0]=i+1;
//         }

//         if(n==2){
//             System.out.println(1);  continue;
//         }

//         st.push(prs[0]);  st.push(prs[1]);

//         long ans=1; int sz=st.size();

//         for(int i=2;i<n;i++){
//             while(st.size()>=2){
//                 double s1=(((double)st.get(sz-1)[1]-(double)st.get(sz-2)[1]))/(((double)st.get(sz-1)[0]-(double)st.get(sz-2)[0]));
//                 double s2=(((double)prs[i][1]-(double)st.get(sz-1)[1]))/(((double)prs[i][0]-(double)st.get(sz-1)[0]));
//                  //slope  3 points -> two old points already in stack and one new point
//                 if(s1<=s2){ //if new slope greater than or equal to old slope than pop old peek point
//                     st.pop();  sz--; //if new slope is greater than old slope than only we can see the old far point
//                 }else{break;}
//             }
//             st.push(prs[i]);  sz++;
//             ans=Math.max(ans,(st.get(sz-1)[0]-st.get(sz-2)[0]));
//         }
        

//         System.out.println(ans);
//             }
//         }
//     }  

        


//         long[] hts=new long[(int)n];
//         long lmin=Long.MAX_VALUE;  int lmni=0;  //Max height on left
//         long lmax=Long.MIN_VALUE;   int lmxi=0;
//         double mmin=1500;   double mmax=-1500;  //min,max angle
//         // int ri=lmxi;
//         int ans=0;
       
//         //Rule-1

//         for(int i=0;i<n;i++){
//             hts[i]=Long.parseLong(strs[i]);

//             if(hts[i]>lmax){ lmax=hts[i];   mmin=1500;
//                 if((i-lmxi)>0){ans=Math.max(ans, (i-lmxi)); }    lmxi=i; 
//             }
        
//             double ang=Math.atan((hts[lmxi]-hts[i])/((i-lmxi)*1.0));  //180-
//             double xang=Math.atan((hts[lmxi]+1-hts[i])/((i-lmxi)*1.0)); 
//             if(mmin==1500 && i!=lmxi){mmin=ang;  }
//             if(xang<=mmin){ans=Math.max(ans, (i-lmxi)); }
            
//             if(ang<=mmin){ mmin=ang;  }
//         }


//         //R-2

//         for(int i=0;i<n;i++){
//             if(hts[i]<lmin){lmin=hts[i];  lmni=i;  mmax=-1500; }

//             double ang=Math.atan((hts[i]-hts[lmni])/((i-lmni)*1.0));
//             double xang=Math.atan((hts[i]-1-hts[lmni])/((i-lmni)*1.0));
//             if(mmax==-1500 && i!=lmni){ mmax=ang;  }
//             if(xang>=mmax){ ans=Math.max(ans, (i-lmni));}
//             if(ang>=mmax){mmax=ang; }
//         }





//         // System.out.println(ans);
//         //Rule-3
//          mmin=1500;    mmax=-1500;
//          lmin=Long.MAX_VALUE;   lmni=(int)(n-1);
//          lmax=Long.MIN_VALUE;    lmxi=(int)(n-1);
        
//          for(int i=(int)(n-1);i>=0;i--){
//             if(hts[i]>lmax){lmax=hts[i]; 
//                 if((lmxi-i)>0){ ans=Math.max(ans, (lmxi-i)); }     lmxi=i;  mmin=1500;  }
           
//                 //c1
//             double ang=Math.atan((hts[lmxi]-hts[i])/((lmxi-i)*1.0));    //180-
//             double xang=Math.atan((hts[lmxi]+1-hts[i])/((lmxi-i)*1.0));    //180-
//             if(mmin==1500 && i!=lmxi){ mmin=ang;  }
//             if(xang<=mmin && i!=lmxi){ ans=Math.max(ans, (lmxi-i)); }
//             if(ang<=mmin && i!=lmxi){ mmin=ang;    ans=Math.max(ans, (lmxi-i)); }
//           }



//         //R-4
//         for(int i=(int)(n-1);i>=0;i--){
           
//             if(hts[i]<lmin){lmin=hts[i];  lmni=i;   mmax=-1500; }
            
//             double ang=Math.atan((hts[i]-hts[lmni])/((lmni-i)*1.0));
//             double xang=Math.atan((hts[i]-1-hts[lmni])/((lmni-i)*1.0));
//             if(mmax==-1500 && i!=lmni){ mmax=ang;  }
//             if(xang>=mmax){ ans=Math.max(ans, (lmni-i));}
//             if(ang>=mmax){mmax=ang; ans=Math.max(ans, (lmni-i));}
//         }

        
//         System.out.println(ans);  //"a="+
//         }
//     }
// }



















        // // double mmin=-500;
        // int ri=lmxi;
        // for(int r=lmxi+1;r<n;r++){
        //     double ang=180-Math.atan((hts[lmxi]-hts[r])/((r-lmxi)*1.0));
        //     if(mmin==-500){mmin=ang; ri=r;}
        //     if(ang<=mmin){mmin=ang; ri=r;}
        //     // System.out.println(ang);
        // }

        // // int ans=ri-lmxi;
        // double mmax=-500;  ri=lmni;
        // for(int r=lmni+1;r<n;r++){
        //     double ang=Math.atan((hts[r]-hts[lmni])/((r-lmni)*1.0));
        //     if(mmax==-500){mmax=ang; ri=r;}
        //     if(ang>=mmax){mmax=ang; ri=r;}
        //     // System.out.println(ang);
        // }

        //   ans=Math.max(ans, (ri-lmni));
          
        //   System.out.println(ans);  //"a="+

//         }
//     }
// }


// public static long first(int[][] arr,int n,int e,int h,int a,int b,int c){
//     int ti=0;   int i=0;   long ans=0;   int oi=0,msi=0,cci=0;

//     while(ti<n && i<3){
           
//         if(arr[i][1]==2){
//             int min=(e/2);  //if(min==0){break;} 
//             e=e%2;  oi=i; // ans+=((long)min*(long)a);      ti+=min; arr[i][3]=min;
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)a);    arr[i][3]+=(n-ti);  ti+=(n-ti);} //mmistake
//             else{ans+=((long)min*(long)a);  ti+=min;   arr[i][3]+=min;}
//         }else if(arr[i][1]==0){
//             int min=(h/3);   h=h%3;  msi=i;   // ans+=((long)min*(long)b);    arr[i][3]=min;   ti+=min;
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)b);    arr[i][3]+=n-ti;  ti+=(n-ti);}
//             else{ans+=((long)min*(long)b);  ti+=min;    arr[i][3]+=min;}
//         }else if(arr[i][1]==1){
//             int min=Math.min(e, h);   cci=i;
//             // if(min==0){break;}
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)c);   e-=(n-ti);  h-=(n-ti); arr[i][3]+=(n-ti);  ti+=(n-ti);}
//             else{ans+=((long)min*(long)c);  ti+=min;   e-=min;  h-=min; arr[i][3]+=min;}
//         }
//         i++;
//      }

//      return ans;
// }

// public static long third(int[][] arr,int n,int e,int h,int a,int b,int c){
//     int ti=0;   int i=0;   long ans=0;   int oi=0,msi=0,cci=0;

//     while(ti<n && i<3){
           
//         if(arr[i][1]==2){
//             int min=(e/2);  //if(min==0){break;} 
//             e=e%2;  oi=i; // ans+=((long)min*(long)a);      ti+=min; arr[i][3]=min;
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)a);    arr[i][3]+=(n-ti);  ti+=(n-ti);} //mmistake
//             else{ans+=((long)min*(long)a);  ti+=min;   arr[i][3]+=min;}
//         }else if(arr[i][1]==0){
//             int min=(h/3);   h=h%3;  msi=i;   // ans+=((long)min*(long)b);    arr[i][3]=min;   ti+=min;
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)b);    arr[i][3]+=n-ti;  ti+=(n-ti);}
//             else{ans+=((long)min*(long)b);  ti+=min;    arr[i][3]+=min;}
//         }else if(arr[i][1]==1){
//             int min=Math.min(e, h);   cci=i;
//             // if(min==0){break;}
//             if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)c);   e-=(n-ti);  h-=(n-ti); arr[i][3]+=(n-ti);  ti+=(n-ti);}
//             else{ans+=((long)min*(long)c);  ti+=min;   e-=min;  h-=min; arr[i][3]+=min;}
//         }
//         i++;
//      }

//         if(ti>=n){  //right-100% sure
//              return ans;
//          }else{
//              //Imp
//             while(ti<n){
//                 // System.out.println(ti+"  imp1="+ans);
//                 if(e<h && arr[oi][3]>0){
//                     ans-=(long)arr[oi][0];   e+=2; ti--;    arr[oi][3]--;
//                 }else if(e>=h && arr[msi][3]>0){
//                     ans-=(long)arr[msi][0];   h+=3; ti--;   arr[msi][3]--;
//                 }else{
//                     break;
//                 }

//                 int min=Math.min(e, h);
                
//                 if((ti+min)>=n){  //(ti+min)>=n
//                     ans+=(long)(n-ti)*(long)arr[cci][0];
//                     ti+=(n-ti);
//                 }
//                 // System.out.println(ti+" imp2="+ans);
//             }
//          }

//      return ans;
// }






















// // public static long second(int[][] arr,int n,int e,int h,int a,int b,int c){
// //     int ti=0;   int i=0;   long ans=0;   int oi=0,msi=0,cci=0;  int mp=0;
// //     long oans=Integer.MAX_VALUE;


// //     if(arr[0][0]==a){
// //         int ft=arr[0][0],sd=arr[1][0],td=arr[2][0];
// //         mp=(e/2);  e=e%2;  ans=(long)Math.min(n,mp)*(long)ft;
// //         if(mp>=n)return ans;
// //         int oe=e,oh=h;
        
// //         for(int j=0;j<=mp;j++){
// //             int rem=n-(mp-j);    e=oe; h=oh;    
// //             ti=mp-j;  ans=(long)ti*(long)ft;
// //             int ne=e+(j*2);   //1

// //             int cmin=Math.min(ne, h);
// //             if((ti+cmin+((h-cmin)/3))<n){continue;}
    
// //             int min=0;  int oe2=ne,oh2=h;   int orem=rem;  long oa=ans;
// //             if(sd==c){
// //                  min=Math.min(ne, h);  // ne-=min;  h-=min;
// //             }else if(sd==b){
// //                 min=h/3; // h=h%3;
// //             }
           
// //             for(int k=0;k<=Math.min(orem,min);k++){  //loop 2
// //                 ne=oe2; h=oh2;    rem=orem; ans=oa;           //reset all parameters
// //                 if(sd==c){
// //                     ne-=k;  h-=k;
// //                }else if(sd==b){
// //                    h=h-(k*3);
// //                }    

// //             if(k>=rem){
// //                 ans+=(long)rem*(long)sd;    rem=0; //2
// //             }else{
// //                 ans+=(long)k*(long)sd;     rem-=k;  ti+=k;
// //             }
           
// //             // System.out.println(rem+"=aa1="+ans);
// //             if(sd==c && h/3>=rem && rem>=0){
// //                 ans+=(long)rem*(long)td;  rem=0; //  break;
// //                 oans=Math.min(ans, oans);
// //             }else if(sd==b && Math.min(ne, h)>=rem && rem>=0){
// //                 ans+=(long)rem*(long)td;  rem=0; //  break;
// //                 oans=Math.min(ans, oans);
// //             }

// //             if(rem==0){return oans;}
// //         }
// //             // System.out.println(rem+"=aa1="+ans+"  oans= "+oans);
// //         }

// //     }else if(arr[0][0]==b){
// //         int ft=arr[0][0],sd=arr[1][0],td=arr[2][0];
// //         mp=h/3; h=h%3;      ans=(long)Math.min(n,mp)*(long)ft;
// //         if(mp>=n)return ans;
// //         int oe=e,oh=h;

// //         for(int j=0;j<=mp;j++){
// //             int rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
// //             int nh=h+(j*3);
            
// //             // System.out.println(ans);
// //             int cmin=Math.min(e, nh);
// //             if((ti+cmin+((e-cmin)/2))<n){continue;}

// //             int min=0;   int oe2=e,oh2=nh;  int orem=rem;  long oa=ans;
// //             if(sd==a){
// //                 min=e/2;   // e=e%2;  
// //             }else if(sd==c){
// //                  min=Math.min(e, nh);  
// //             }
// //            for(int k=0;k<=Math.min(orem,min);k++){  //loop 2
// //             e=oe2; nh=oh2;  rem=orem; ans=oa;    //reset all parameters
// //             if(sd==a){   //if k>rem
// //                  e=e-(k*2);  
// //             }else if(sd==c){
// //                  e=e-k; nh-=k; 
// //             }

         
// //             if(k>=rem){
// //                 ans+=(long)rem*(long)sd;    rem=0; //2
// //             }else{
// //                 ans+=(long)k*(long)sd;     rem-=k;  ti+=k;
// //             }
           
    
// //             if(sd==c && e/2>=rem && rem>=0){
// //                 ans+=(long)rem*(long)td;   //  break;
// //                 oans=Math.min(ans, oans);   rem=0;
// //             }else if(sd==a && Math.min(e, nh)>=rem && rem>=0){
// //                 ans+=(long)rem*(long)td;   //  break;
// //                 oans=Math.min(ans, oans);  rem=0;
// //             }
// //             if(rem==0){return oans;}
// //             // System.out.println(rem+" ans1="+ans+"  oans="+oans+"  mp="+mp+" j="+j+"   min="+min+" k "+k);
// //            }
// //         }
// //     }else if(arr[0][0]==c){
// //         int ft=arr[0][0],sd=arr[1][0],td=arr[2][0];
// //         mp=Math.min(e, h);   e-=mp; h-=mp;   ans=(long)Math.min(n,mp)*(long)ft;
// //         if(mp>=n)return ans;
// //         int oe=e,oh=h;

// //         for(int j=0;j<=mp;j++){
// //             int rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
// //             int nh=h+(j);  int ne=e+j;
            
// //             // int cmin=Math.min(e, nh);
// //             if((ti+(nh/3)+((ne)/2))<n){continue;}

// //             int min=0;   int oe2=ne,oh2=nh;    int orem=rem;  long oa=ans;
// //             if(sd==a){
// //                 min=ne/2;  //ne=ne%2;
// //             }else if(sd==b){
// //                 min=nh/3;   //nh=nh%2;
// //             }
          
// //             for(int k=0;k<=Math.min(orem,min);k++){  //loop 2
// //                 ne=oe2;  nh=oh2;    rem=orem; ans=oa;          //reset all parameters

// //                 if(sd==a){
// //                       ne=ne-(k*2);
// //                 }else if(sd==b){
// //                       nh=nh-(2*3);
// //                 }
// //                 if(k>=rem){
// //                     ans+=(long)rem*(long)sd;    rem=0; //2
// //                 }else{
// //                     ans+=(long)k*(long)sd;     rem-=k;  ti+=k;
// //                 }
               
        
// //                 if(sd==b && e/2>=rem && rem>=0){
// //                     ans+=(long)rem*(long)td;   //  break;
// //                     oans=Math.min(ans, oans);
// //                 }else if(sd==a && h/3>=rem && rem>=0){
// //                     ans+=(long)rem*(long)td;   //  break;
// //                     oans=Math.min(ans, oans);
// //                 }
// //                 if(rem==0){return oans;}
// //             } 
            
// //         }
// //     } 

// //     return oans;
// // }




    
// public static long second(int[][] arr,long n,long e,long h,long a,long b,long c){
//     long ti=0;    long ans=0; long mp=0;  //int oi=0,msi=0,cci=0;   int i=0; 
//     long oans=Long.MAX_VALUE;  //My Bigest Mistake    long oans=Integer.MAX_VALUE; 
//      long ft=arr[0][0],sd=arr[1][0],td=arr[2][0];
       

//     if(ft==a){
//         mp=(e/2);  e=e%2;  ans=(long)(Math.min(n,mp))*(long)ft;
//         if(mp>=n)return ans;
//         long oe=e,oh=h;
        
//         for(int j=0;j<=mp;j++){
//             long rem=n-(mp-j);    e=oe; h=oh; 
//             ti=mp-j;  ans=(long)ti*(long)ft;
//             long ne=e+(j*2);   //1
            
//             long cmin=Math.min(ne, h);
//             if((ti+cmin+((h-cmin)/3))<n){continue;}  
            
//             long min=0;  long oe2=ne,oh2=h;   long orem=rem;  long oa=ans;
//             if(sd==c){
//                  min=Math.min(ne, h);  // ne-=min;  h-=min;
//             }else if(sd==b){
//                 min=h/3; // h=h%3;
//             }
//             // System.out.println(rem+"=aa="+ans);
//             for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
//                 ne=oe2; h=oh2;    rem=orem; ans=oa;
//                 if(sd==c){
//                     ne-=k;  h-=k;
//                }else if(sd==b){
//                    h=h-(k*3);
//                }    

//             if(k>=rem){
//                 ans+=(long)rem*(long)sd;    rem=0; //2
//             }else{
//                 ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
//             }
           
//             // System.out.println(rem+"=aa1="+ans);
//             if(sd==c && (h/3)>=rem && rem>=0){
//                 ans+=(long)rem*(long)td;   //  break;
//                 oans=Math.min(ans, oans);
//             }else if(sd==b && (Math.min(ne, h))>=rem && rem>=0){
//                 ans+=(long)rem*(long)td;   //  break;
//                 oans=Math.min(ans, oans);  
//             }
//             if(rem==0){return oans;}
//         }
//             // System.out.println(rem+"=aa1="+ans+"  oans= "+oans);
//         }

//     }else if(ft==b){
//         mp=h/3; h=h%3;      ans=(long)(Math.min(n,mp))*(long)ft;
//         if(mp>=n)return ans;
//         long oe=e,oh=h;

//         for(int j=0;j<=mp;j++){
//             long rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
//             long nh=h+(j*3);
            
//             // System.out.println(ans);
//             long cmin=Math.min(e, nh);
//             if((ti+cmin+((e-cmin)/2))<n){continue;}
            
//             long min=0;   long oe2=e,oh2=nh;  long orem=rem;  long oa=ans;
//             if(sd==a){
//                 min=e/2;   // e=e%2;  
//             }else if(sd==c){
//                  min=Math.min(e, nh);  
//             }
//            for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
//             e=oe2; nh=oh2;  rem=orem; ans=oa;
//             if(sd==a){   //if k>rem
//                  e=e-(k*2);  
//             }else if(sd==c){
//                  e=e-k; nh-=k; 
//             }

         
//             if(k>=rem){
//                 ans+=(long)rem*(long)sd;    rem=0; //2
//             }else{
//                 ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
//             }
           
    
//             if(sd==c && (e/2)>=rem && rem>=0){
//                 ans+=(long)rem*(long)td;   //  break;
//                 oans=Math.min(ans, oans);  
//             }else if(sd==a && (Math.min(e, nh))>=rem && rem>=0){
//                 ans+=(long)rem*(long)td;   //  break;
//                 oans=Math.min(ans, oans);
//             }
//             if(rem==0){return oans;}
//             // System.out.println(rem+" ans1="+ans+"  oans="+oans+"  mp="+mp+" j="+j+"   min="+min+" k "+k);
//            }
//         }
//     }else if(ft==c){
//         mp=Math.min(e, h);   e-=mp; h-=mp;   ans=(long)(Math.min(n,mp))*(long)ft;
//         if(mp>=n)return ans;
//         long oe=e,oh=h;

//         for(int j=0;j<=mp;j++){
//             long rem=n-(mp-j);    ti=mp-j;  ans=(long)ti*(long)ft;  e=oe; h=oh; 
//             long nh=h+(j);  long ne=e+j;
            
//             if((ti+(nh/3)+((ne)/2))<n){continue;}
            
//             long min=0;   long oe2=ne,oh2=nh;    long orem=rem;  long oa=ans;
//             if(sd==a){
//                 min=ne/2;  //ne=ne%2;
//             }else if(sd==b){
//                 min=nh/3;   //nh=nh%2;
//             }
          
//             for(int k=(int)Math.min(orem,min);k>=0;k--){  //loop 2
//                 ne=oe2; nh=oh2;    rem=orem; ans=oa;

//                 if(sd==a){
//                       ne=ne-(k*2);
//                 }else if(sd==b){
//                       nh=nh-(k*3);
//                 }
//                 if(k>=rem){
//                     ans+=(long)rem*(long)sd;    rem=0; //2
//                 }else{
//                     ans+=(long)k*(long)sd;     rem-=k; // ti+=k;
//                 }
               
        
//                 if(sd==b && (e/2)>=rem && rem>=0){
//                     ans+=(long)rem*(long)td;   //  break;
//                     oans=Math.min(ans, oans);
//                 }else if(sd==a && (h/3)>=rem && rem>=0){
//                     ans+=(long)rem*(long)td;   //  break;
//                     oans=Math.min(ans, oans);
//                 }
//                 if(rem==0){return oans;}  //if two mincost make 'n' item
//             } 
            
//         }
//     } 

//     return oans;
// }







// public static void main(String[] args) throws Exception{
//     // int v1=1000000; int v2=10000_0;
//     // long res=0; res+=(long)v1+(long)v2;
//     // int ir=v1+v2;
//     // System.out.println(res+"  "+ir);
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),e=Integer.parseInt(strs[1]),h=Integer.parseInt(strs[2]);
//         int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);
//         // String str=(br.readLine()).trim();
        
//         int[][] arr=new int[3][4];
//         arr[0][0]=a;  arr[0][1]=2;   arr[0][2]=0;
//         arr[1][0]=b;  arr[1][1]=0;   arr[1][2]=3;
//         arr[2][0]=c;  arr[2][1]=1;   arr[2][2]=1; 

//         Arrays.sort(arr,(a1,a2)->a1[0]-a2[0]);
         
//         // System.out.println(arr[0][0]+" st  "+arr[1][0]);
//         int mm=Math.min(e, h);
//         int max=mm+((e-mm)/2) +((h-mm)/3);
        
//         if(max<n){System.out.println(-1);  continue;}  //right-90% sure
        
//         if(a==b && b==c){
//             long equal=(long)n*(long)a;
//             System.out.println(equal);  continue; 
//         }

//         int ti=0;   int i=0;   long ans=0;
//         int oi=0,msi=0,cci=0;


//         //Soln Start
//         // if(arr[0][0]==c){
//         //     long mans=first(arr,n, e, h,a,b,c);
//         //     System.out.println(mans);
//         // }else if(arr[1][0]==c){
//             long mans=second(arr,n, e, h,a,b,c);
//             // if(mans==Integer.MAX_VALUE){mans=-1;}
//             System.out.println(mans);
//         // }else if(arr[2][0]==c){
//         //     long mans=third(arr,n, e, h,a,b,c);
//         //     System.out.println(mans);
//         // }

         
//         //  System.out.println(ans);//"a1="+
//         }
//     }
// }




        // i=0;
        //  while(ti<n && i<3){
        //     if(arr[i][1]==2){
        //           oi=i; 
        //     }else if(arr[i][1]==0){
        //           msi=i;  
        //     }else if(arr[i][1]==1){
        //          cci=i;
        //     }
        //     i++;
        //  }

        //  if(ti>=n){  //right-100% sure
        //      System.out.println(ans);  continue;  //"a="+
        //  }else{
        //      //Imp
        //     while(ti<n){
        //         if(e<h && arr[oi][3]>0){
        //             ans-=(long)arr[oi][0];   e+=2; ti--;    arr[oi][3]--;
        //         }else if(e>=h && arr[msi][3]>0){
        //             ans-=(long)arr[msi][0];   h+=3; ti--;   arr[msi][3]--;
        //         }else{
        //             break;
        //         }

        //         int min=Math.min(e, h);
                
        //         if((ti+min)>=n){  //(ti+min)>=n
        //             ans+=(long)(n-ti)*(long)arr[cci][0];
        //             ti+=(n-ti);
        //         }
        //     }
        //  }










// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),e=Integer.parseInt(strs[1]),h=Integer.parseInt(strs[2]);
//         int a=Integer.parseInt(strs[3]),b=Integer.parseInt(strs[4]),c=Integer.parseInt(strs[5]);

//         // String str=(br.readLine()).trim();
//         int[][] arr=new int[3][4];
//         arr[0][0]=a;  arr[0][1]=2;   arr[0][2]=0;
//         arr[1][0]=b;  arr[1][1]=0;   arr[1][2]=3;
//         arr[2][0]=c;  arr[2][1]=1;   arr[2][2]=1; 

//         Arrays.sort(arr,(a1,a2)->a1[0]-a2[0]);
         
//         // System.out.println(arr[0][0]+" st  "+arr[1][0]);
//         int mm=Math.min(e, h);
//         int max=mm+((e-mm)/2) +((h-mm)/3);
        
//         if(max<n){System.out.println(-1);  continue;}  //right-80% sure
        
//         int ti=0;
//         int i=0;
//         long ans=0;
//         int oi=0,msi=0,cci=0;

//          while(ti<n && i<3){
           
//             if(arr[i][1]==2){
//                 int min=(e/2);  //if(min==0){break;} 
//                 e=e%2;  oi=i; // ans+=((long)min*(long)a);      ti+=min; arr[i][3]=min;
//                 if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)a);    arr[i][3]+=(n-ti);  ti+=(n-ti);} //mmistake
//                 else{ans+=((long)min*(long)a);  ti+=min;   arr[i][3]+=min;}
//             }else if(arr[i][1]==0){
//                 int min=(h/3);   h=h%3;  msi=i;   // ans+=((long)min*(long)b);    arr[i][3]=min;   ti+=min;
//                 if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)b);    arr[i][3]+=n-ti;  ti+=(n-ti);}
//                 else{ans+=((long)min*(long)b);  ti+=min;    arr[i][3]+=min;}
//             }else if(arr[i][1]==1){
//                 int min=Math.min(e, h);   cci=i;
//                 // if(min==0){break;}
//                 if((long)((long)ti+(long)min)>=(long)n){ans+=((long)(n-ti)*(long)c);   e-=(n-ti);  h-=(n-ti); arr[i][3]+=(n-ti);  ti+=(n-ti);}
//                 else{ans+=((long)min*(long)c);  ti+=min;   e-=min;  h-=min; arr[i][3]+=min;}
//             }
//             i++;
//          }

//          if(arr[0][0]==c){
//              System.out.println(ans);  continue;
//          }

//          i=0;
//          while(ti<n && i<3){
//             if(arr[i][1]==2){
//                   oi=i; // ans+=((long)min*(long)a);      ti+=min; arr[i][3]=min;
//             }else if(arr[i][1]==0){
//                   msi=i;   // ans+=((long)min*(long)b);    arr[i][3]=min;   ti+=min;
//             }else if(arr[i][1]==1){
//                  cci=i;
//             }
//             i++;
//          }

//          if(ti>=n){  //right-100% sure
//              System.out.println(ans);  continue;  //"a="+
//          }else{
//              //Imp
//             while(ti<n){
//                 // System.out.println(ti+"  imp1="+ans);
//                 if(e<h && arr[oi][3]>0){
//                     ans-=(long)arr[oi][0];   e+=2; ti--;    arr[oi][3]--;
//                 }else if(e>=h && arr[msi][3]>0){
//                     ans-=(long)arr[msi][0];   h+=3; ti--;   arr[msi][3]--;
//                 }else{
//                     break;
//                 }

//                 int min=Math.min(e, h);
                
//                 if((ti+min)>=n){  //(ti+min)>=n
//                     ans+=(long)(n-ti)*(long)arr[cci][0];
//                     ti+=(n-ti);
//                 }
//                 // System.out.println(ti+" imp2="+ans);
//             }
//          }

//          if(ti<n){
//              ans=Integer.MAX_VALUE;
//              if((e/2)>=(n-ti)){
//                  ans=(long)(n-ti)*(long)a;
//              }

//              if((c/3)>=(n-ti)){
//                   ans=Math.min(ans, ((long)(n-ti)*(long)b));  
//              }
//          }

//          System.out.println(ans);//"a1="+
//             //System.out.println(-1);  continue;
//         }
//     }
// }








// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//        int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         // int c=Integer.parseInt(strs[0]);//,k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         // String str=(br.readLine()).trim();
//         int[] arr=new int[n+1];

//         int j=0;
//         for(int i=0;i<n;i++){
//             int idx=Integer.parseInt(strs[i]);  j=Math.max(j, idx);
//             arr[idx]++;
//         }

//         boolean f=true;
        
//         for(int i=n;i>=1;i--){


//             if(j>=i){j=i-1;}

//             while(j>0 && arr[j]<1){
//                 j--;
//             }

            
//             if(arr[i]==0){
//                 if(arr[j]==0 || j<1){break;}
//                 arr[j]--;  arr[i]++;
//                 if((i-j)%2==1){f=!f;}
//             }
//         }

//         if(f){
//             System.out.println("Second");
//         }else{
//             System.out.println("First");
//         }

//         }
//     }
// }




// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int c=Integer.parseInt(strs[0]);//,k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         // String str=(br.readLine()).trim();
        
//         int d=(int)Math.floor(Math.log(c)/Math.log(2.0));
//         d++;
//         // System.out.println(d);

//         String bs=Integer.toBinaryString(c);

//         int nb=bs.length();  //total no of bits
//         int[] arr1=new int[nb];
//         int[] arr2=new int[nb];

//         int i=0;
        
//         for(char ch:bs.toCharArray()){
//             if(ch=='0'){
//                 arr1[i]=1;  arr2[i]=1;
//             }else{
//                 arr1[i]=1;
//             }
//             i++;
//         }

//         int j=nb-1,pw=0;
//         long a=0,b=0;
//         long ans=0;
//         while(j>=0){
//             a+=(long)(arr1[j]*Math.pow(2, pw));
//             b+=(long)(arr2[j]*Math.pow(2, pw));   j--; pw++;
//         }

//         j=nb-1;  pw=0;

//         while(j>=0){
//             ans=Math.max(ans,(a*b));

//             if(arr2[j]==0){
//                 long val=(long)Math.pow(2, pw);
//                 b+=val; a-=val;
//             }
//             j--; pw++;

//             if(j<0)break;
//         }

//         System.out.println(ans);
//     }
//     }

// }
