import java.util.*;
import java.lang.*;
import java.io.*;

public class bs {

    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
 
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] str = (br.readLine()).trim().split(" ");
            // int[] arr = new int[n];
            int[][] arr=new int[n][2];

			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(str[i]);
			}
			str = (br.readLine()).trim().split(" ");
			// pair[] brr = new pair[n];
			for (int i = 0; i < n; i++) {
				arr[i][1] = Integer.parseInt(str[i]);
				// int v = arr[i];
				// brr[i] = new pair(v,u);
            }
            
           

        // Scanner scn=new Scanner(System.in);
        // long t=scn.nextLong();
        // while(t-->0){
        //     int n=scn.nextInt();
        //     // long n=scn.nextLong();
        //     // long[] a=new long[n];
        //     // long[] b=new long[n];
        //     int[][] arr=new int[n][2];

        //     long sum=0; long max=0;
        //     for(int i=0;i<n;i++){arr[i][0]=scn.nextInt();}// max=Math.max(arr[i][0], max);};
        //     for(int i=0;i<n;i++){arr[i][1]=scn.nextInt();}// sum+=arr[i][1];}

            // long lo=1,hi=Math.min(max, sum);
           
            if(n==1){System.out.println(Math.min(arr[0][0],arr[0][1])); continue;}
           
            long ans=Integer.MAX_VALUE;

            Arrays.sort(arr,(a,b)->{
                return b[0]-a[0];
            });
            
            long cost=0;
            for(int i=0;i<(n);i++){
                if((cost+arr[i][1])<arr[i][0]){
                    cost+=arr[i][1];
                    ans=cost;//Math.min(cost,(long)arr[i][0]);
                }else{
                    ans=Math.max(cost,arr[i][0]);
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
            // while(lo<=hi){
            //     long mid=lo+(hi-lo)/2;

            //     //is valid
            //     long cost=0;

            //     // for(int i=0;i<n;i++){
            //         int i=n-1;
            //        while(i>=0 && arr[i][0]>mid){
            //         cost+=arr[i][1];
            //         if(cost>mid){break;}
            //         i--;
            //      }
            //     //  System.out.println("ra "+cost);
            //     if(cost<=mid){
            //         ans=mid;
            //         hi=mid-1;
            //     }else{
            //         lo=mid+1;
            //     }
            // }

//             System.out.println(ans);
//         }
//     }
// }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     long q=scn.nextLong();
    //     while(q-->0){
    //         long k=scn.nextLong();
    //         long n=scn.nextLong();
    //         long a=scn.nextLong();
    //         long b=scn.nextLong();

    //         long lo=0,hi=n;
    //         long ans=-1;
    //         while(lo<=hi){
    //             long mid=lo+(hi-lo)/2;
    //             // long cost
    //             if(((a*mid)+((n-mid)*b))<k){
    //                 ans=mid;
    //                 lo=mid+1;
    //             }else{
    //                 hi=mid-1;
    //             }
    //         }

    //         System.out.println(ans);
    //      }
    //     }
    // }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     // long t=scn.nextLong();
    //     // while(t-->0){
    //         int n=scn.nextInt();
    //         long k=scn.nextLong();
    //         int[] arr=new int[n];
    //         for(int i=0;i<n;i++){arr[i]=scn.nextInt();}
    //         long mod=10000_00007;
    //         Arrays.sort(arr);
    //         long sum=0L;
    //         int mid=n/2;
    //         for(int i=mid;i<n;i++){sum+=(long)arr[i]; sum=sum%mod;}

    //         long ans=((sum)/(long)(mid+1))+((k)/(long)(mid+1));
    //         ans+=(((sum)%(long)(mid+1))+((k)%(long)(mid+1)))/(long)(mid+1);

    //         System.out.println(ans);
    //     }
    // }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     // long t=scn.nextLong();
    //     // while(t-->0){
    //         int n=scn.nextInt();
    //          HashMap<Integer,Integer> hm=new HashMap<>();
    //          int[] arr=new int[n];
    //          for(int i=0;i<n;i++){  arr[i]=scn.nextInt();}
    //             //  hm.put(val, hm.getOrDefault(val, 0)+1);
    //             // }

    //         //  int[][] arr=new int[hm.size()][2];
             
    //         //  int j=0;
    //         //  for(int key:hm.keySet()){
    //         //      arr[j][0]=key; arr[j][1]=hm.get(key);  j++;
    //         //  }

    //          Arrays.sort(arr);  //(a,b)->a[0]-b[0]
    //          int[] ans=new int[n];
    //          int p1=0,p2=n-1;   
    //          for(int i=0;i<n;i++){
    //                 if(i%2==0){ans[p1++]=arr[i];}
    //                 else{ans[p2--]=arr[i]; }
    //           }

    //           for(int i=0;i<n;i++){
    //             System.out.print(ans[i]+" ");
    //           }
    //         //  for(int i=arr.length-1;i>=0;i--){
    //         //     while( arr[i][1]>0){System.out.print(arr[i][0]+" "); arr[i][1]--;}
    //         // }

    //         System.out.println();
    //     }
    // }



//     static int[][] psum;
//     public static void precal(String str){

//         for(int i=0;i<str.length();i++){
//             char ch=str.charAt(i);
//             psum[i+1][ch-'a']++;

//             for(int j=0;j<26;j++){psum[i+1][j]+=psum[i][j];}
//         }
//     }
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         // long t=scn.nextLong();
//         // while(t-->0){
//             int n=scn.nextInt();
//             String str=scn.next();
//             psum=new int[n+1][26];
//             precal(str);
//             int m=scn.nextInt();

//             for(int i=0;i<m;i++){
//                 int[] arr=new int[26];
//                 String nm=scn.next();
                
//                 int nl=nm.length();
//                 for(char ch:nm.toCharArray()){
//                     arr[ch-'a']++;
//                 }

//                 int ct=0;
//                 // int[] arr2=new int[26];
//                 int ans=0;

//                 int lo=1,hi=n;

//                 while(lo<=hi){
//                     int mid=lo+(hi-lo)/2;
//                     int[] carr=psum[mid];
//                     int cct=0;
//                     for(int j=0;j<26;j++){
//                         if(arr[j]>0){cct+=Math.min(arr[j],carr[j]);}
//                     }

//                     if(cct>=nl){ ans=mid;
//                         hi=mid-1;
//                     }else{lo=mid+1;}
//                 }
//                 //Time limit excedded due to this
//                 // for(int j=0;j<n;j++){
//                 //     char ch=str.charAt(j);
//                 //     if(arr2[ch-'a']<arr[ch-'a']){ct++; arr2[ch-'a']++;}
//                 //     if(ct==nl){ans=j+1;break;}
//                 // }
//                 System.out.println(ans);
//             }
//         // }
//     }
// }

    // public static void main(String[] args){
    //     // int[] arr={1,2,3,4};
    //     Scanner scn=new Scanner(System.in);
    //     long t=scn.nextLong();
    //     // long val=(long)(922337203685477580L);    
    //     while(t-->0){
    //         double n=scn.nextDouble();
    //         // int[] arr=new int[n];

    //         int sr=(int)Math.sqrt(n);// (int)(Math.ceil(Math.log(n)/Math.log(2)))+1;

    //         ArrayList<Integer> list=new ArrayList<>();
    //         HashSet<Integer> hs=new HashSet<>();
    //         int prev=1;
    //         for(int i=0;i<=sr;i++){
    //             if(hs.add(i))list.add((i));
    //             // if(i>0 && hs.add((int)(n/i)))list.add((int)(n/i));
    //         }

    //         // Collections.sort(list);
    //         ArrayList<Integer> list2=new ArrayList<>();
    //         for(int i=1;i<=sr;i++){
    //             if(hs.add((int)(n/i)))list2.add((int)(n/i));
    //         }
    //         System.out.println((list.size()+list2.size()));
            
    //         for(int v:list){
    //             System.out.print(v+" ");
    //         }

    //         for(int i=list2.size()-1;i>=0;i--){
    //             System.out.print(list2.get(i)+" ");
    //         }

    //         System.out.println();
    //     }
    // }
    // 0 1 2 3 4 5 6 7 8 9 10 11 12 14 16 20 25 33 50 100
    // 0 1 33 2 3 4 100 5 6 7 8 9 10 11 12 14 16 50 20 25
    // public static void main(String[] args){
    //     // int[] arr={1,2,3,4};
    //     Scanner scn=new Scanner(System.in);
    //     long t=scn.nextLong();
    //     // long val=(long)(922337203685477580L);    
    //     while(t-->0){
    //         int n=scn.nextInt();
    //         int[] arr=new int[n];

    //         long sum=0;
    //         int max=0;
    //         for(int i=0;i<n;i++){arr[i]=scn.nextInt(); max=Math.max(max, arr[i]); sum+=arr[i];}

    //         long k=(long)Math.max(max,(long)Math.ceil(sum*1.0/(n-1)));//(sum+(n-2))/(n-1));//(int)Math.ceil(sum*1.0/(n-1)));
    //         long ans=(k*(long)(n-1))-sum;   //(int)Math.ceil(sum*1.0/(n-1))); //
    //         System.out.println(ans);
    //     }
    // }
// }
//     public static void main(String[] args){
//         // int[] arr={1,2,3,4};
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();
        
//         while(t-->0){
//             int n=scn.nextInt();
//             int s=scn.nextInt();

//             int[] arr=new int[n];

//             for(int i=0;i<n;i++){arr[i]=scn.nextInt();}

//             PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
//                 public int compare(int[] a,int[] b){
//                     return b[0]-a[0];
//                 }
//             });
//             long rsum=0;
//             boolean flag=true;

//             for(int i=0;i<n;i++){
//                 rsum+=arr[i];
//                 pq.add(new int[]{arr[i],i});
                    
//                     int ct=0;
//                     int ii=-1;
//                     if(rsum>s && pq.size()>0){
//                         int idx=(pq.peek())[1];
//                         pq.remove();

//                             flag=false;
//                             System.out.println(idx+1);
//                          break;
//                         }
                    
//                     if(!flag)break;
//             }
//             if(flag)System.out.println(0);
//         }
//     }
// }
    // public static void main(String[] args){
    //     // int[] arr={1,2,3,4};
    //     Scanner scn=new Scanner(System.in);
    //     long t=scn.nextLong();
        
    //     while(t-->0){
    //         int a=scn.nextInt();
    //         int b=scn.nextInt();
            
    //         if(a>b){int tmp=a; a=b; b=tmp;}

    //         if((2*a)==b){System.out.println("YES"); continue;}
    //         // else if(a==b){System.out.println("NO");}
    //         else{
    //             int lo=1,hi=a;
    //             boolean flag=true;
    //             while(lo<=hi){
    //                 int x=lo+(hi-lo)/2;

    //                 if((a-x)==(2*(b-(2*x)))){
    //                     System.out.println("YES"); flag=false; break;
    //                 }
                    
    //                 if((a-x)<(2*(b-(2*x)))){
    //                     lo=x+1;
    //                 }else{hi=x-1;}
    //             }

    //             if(flag){System.out.println("NO");}
    //         }
    //      }
    //     }
    // }

//     public static void main(String[] args){
//         // int[] arr={1,2,3,4};
//         Scanner scn=new Scanner(System.in);
//         // long t=scn.nextLong();
        
//         // while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt();
//             int[] arr=new int[n];
//             for(int i=0;i<n;i++){arr[i]=scn.nextInt();}

//             int i=0,j=0; //sliding window or 2 pointer
//             long rsum=0;
//             int ans=0;

//             while(i<n && j<n){
//                 rsum+=arr[j]; j++;
//                 if(rsum<=k){
//                     ans=Math.max(ans, (j-i));
//                 }
//                 while(rsum>k){
//                     rsum-=arr[i];
//                     i++;
//                 }
//             }

//             System.out.println(ans);
//         // }
//     }
// }

    // public static void main(String[] args){
    //     // int[] arr={1,2,3,4};
    //     Scanner scn=new Scanner(System.in);
    //     long t=scn.nextLong();
        
    //     while(t-->0){
    //         long n=scn.nextLong();
    //         long k=scn.nextLong();

    //         long lo=1;long hi=1999999999;
    //             long ans=0;
    //             long targ=k;

    //             while(lo<=hi){
    //                 long mid=lo+(hi-lo)/2;
                    
    //                 if(mid%n==0 && (mid-(mid/n))==targ){hi--; continue;} //lo++; is wrong test case 
    //                 if((mid-(mid/n))==targ){ans=mid; break;}             //hi--; 2 5    

    //                 if((mid-(mid/n))<targ){
    //                     lo=mid+1;
    //                 }else{
    //                     hi=mid-1;
    //                 }
    //             }
    //             System.out.println(ans);
    //     }
    //     }
    // }


//     public static void main(String[] args){
//         // int[] arr={1,2,3,4};
//         Scanner scn=new Scanner(System.in);
//         // long t=scn.nextLong();
        
//         // while(t-->0){
//             int n=scn.nextInt();
//             int[] a=new int[n];

//             for(int i=0;i<n;i++){a[i]=scn.nextInt(); 
//             if(i>0){a[i]+=a[i-1];}}
//             int m=scn.nextInt();

//             int[] b=new int[m];
//             for(int i=0;i<m;i++){b[i]=scn.nextInt();}

//             for(int i=0;i<m;i++){
//                 int targ=b[i];
//                 int lo=0,hi=n-1;
//                 int ans=0;
//                 while(lo<=hi){
//                     int mid=lo+(hi-lo)/2;
//                     if(a[mid]==targ){ans=mid+1; break;}
//                     if(a[mid]<targ){
//                         lo=mid+1;
//                     }else{
//                         ans=mid+1;
//                         hi=mid-1;
//                     }
//                 }
//                 System.out.println(ans);
//             }
//         // }
//     }
// }


//     static int[] sieve=new int[1000_0001];

//     public static void SOE(){

//         for(int x=2;x<sieve.length;x++){
//             if(sieve[x]==0){

//                 for(int u=2*x;u<sieve.length;u+=x){
//                     sieve[u]=x;
//                 }
//             }
//         }
//     }
//     public static void main(String[] args){
//         // int[] arr={1,2,3,4};
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();
//         SOE();
//         while(t-->0){
//             double n=scn.nextDouble();
//             int ct=0;
//             // int on=n;
//             // while(n%2==0){n=n/2; ct++; if(ct>2){break;}}
//             if(n==1){System.out.println("NO"); continue;}

//              long sr=(long)(Math.sqrt((n)));
//              if((sr*sr)==n && sieve[(int)(sr)]==0){System.out.println("YES");}
//              else{System.out.println("NO");}
//             // if(ct>2 || n==on){System.out.println("NO");}
//             // else if(n>1 && ct>0){System.out.println("NO");}
//             // else{System.out.println("YES");}
//         }
//     }
// }
    // public static void main(String[] args){
    //     // int[] arr={1,2,3,4};
    //     Scanner scn=new Scanner(System.in);
    //     // long t=scn.nextLong();

    //     // while(t-->0){
    //         int n=scn.nextInt();
    //         int l=scn.nextInt();
    //         int[] arr=new int[n];

    //         for(int i=0;i<n;i++){arr[i]=scn.nextInt();}

    //         Arrays.sort(arr);
    //         double mmax=0;

    //         mmax=Math.max(mmax,arr[0]-0);
    //         mmax=Math.max(mmax,l-arr[n-1]);
            
    //         for(int i=1;i<n;i++){
    //             mmax=Math.max(mmax,(arr[i]-arr[i-1])/2.0);
    //         }

    //         System.out.println(mmax);
    //     // }
    // }
// }


