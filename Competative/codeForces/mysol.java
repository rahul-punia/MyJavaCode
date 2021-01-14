import java.util.*;

// 1
// 1
// 10 -7 -6 -5 1 2 3 4 5 6 7

public class mysol {
   static class pair{
        int val;
        char d;
        pair(int val,char d){this.val=val; this.d=d;}
    }
    
    public static void main(String[] args){
                Scanner scn=new Scanner(System.in);
                long t=scn.nextLong();
        

        		while(t-->0){
                    int n=scn.nextInt();
                    ArrayList<ArrayList<pair>> list=new ArrayList<>();
                    
                    long ans=0;
                    int cn=0,cp=0;
                    for(int i=0;i<n;i++){
                        int m=scn.nextInt();
                        ArrayList<pair> line=new ArrayList<>();
                        // pair[] line=new pair[m];
                        for(int j=0;j<m;j++){
                            int val=scn.nextInt();
                            char d='l';
                            if(val<0){d='r';}
                            line.add(new pair(val, d));
                            // if(line[j]<0){cn++;}else{cp++;}
                            //line.add(scn.nextInt());
                        }

                        list.add(line);
                    }


                //solve    
                boolean lflag=true;
                boolean rflag=true;  
                  int ct=0;

                int left=-1,right=1;  
                while(left<right){  
                    // while(lflag && rflag){  
                    lflag=false; rflag=false;
                    left=Integer.MAX_VALUE; right=Integer.MIN_VALUE;
                    int origin=-1; int freq=0; int oa=0;
                    int lidx=-1,aidx=-1;
                    for(int i=0;i<n;i++){
                        ArrayList<pair> line=list.get(i);
                        // pair[] line=new pair[m];
                        int m=line.size();
                        boolean last=true;
                        for(int j=0;j<m-1;j++){
                            char d1=line.get(j).d;
                            char d2=line.get(j+1).d;
                            
                            if((line.get(j+1).val-line.get(j).val)==0 && d1=='r' && d2=='l'){
                                if(line.get(j+1).val==0 || line.get(j).val==0){origin=2; freq++;}
                                ans++;   lflag=true; rflag=true;  
                                left=j; right=j+1;
                               line.get(j).d='l';//line.get(j).d=='l' ? 'r' : 'l';
                                line.get(j+1).d='r';//line.get(j+1).d=='l' ? 'r' : 'l';
                                j++;
                                if(j==m-1){last=false;}
                                // System.out.println("11111111111");
                            }else if((line.get(j+1).val-line.get(j).val)==1 && d1=='r' && d2=='l'){
                                if(line.get(j+1).val==0 || line.get(j).val==0){origin=2; freq++;}
                                ans++;   lflag=true; rflag=true;
                                left=j; right=j+1;
                               line.get(j).d='l';//line.get(j).d=='l' ? 'r' : 'l';
                                line.get(j+1).d='r';//line.get(j+1).d=='l' ? 'r' : 'l';
                                j++;
                                if(j==m-1){last=false;}

                                // System.out.println("11111111111");
                            }else if((line.get(j+1).val-line.get(j).val)==2 && d1=='r' && d2=='l'){
                                if((line.get(j+1).val+line.get(j).val)==0){origin=2; freq++;}
                                ans++;   lflag=true; rflag=true; 
                                left=j; right=j+1;
                                line.get(j).val=line.get(j).val+1;
                                line.get(j+1).val=line.get(j+1).val-1;
                                line.get(j).d='l';//line.get(j).d=='l'?'r':'l';
                                line.get(j+1).d='r';//=line.get(j+1).d=='l'?'r':'l';
                                j++;
                                if(j==m-1){last=false;}
                                // System.out.println("2222222222222222");
                            }
                            
                            else{
                                if(line.get(j).d=='l'){
                                    // System.out.print(line.get(j).val+"  val ");
                                    line.get(j).val=line.get(j).val-1;
                                    // System.out.print(line.get(j).val);
                                    if(line.get(j).val==0 && (origin==1 || origin==2)){
                                        line.get(j).d=line.get(j).d=='l'?'r':'l';   oa=1;
                                    }
                                    // if(line.get(j).val==0){origin=1;}
                                    if(line.get(j).val==0){
                                        if(origin==1 && freq==1){
                                            oa=1;
                                            list.get(lidx).get(aidx).d=list.get(lidx).get(aidx).d=='l'?'r':'l';  
                                        }
                                        origin=1; freq++; lidx=i; aidx=j;}
                                        // System.out.println("lllllllll");
                                    if(rflag)lflag=true;
                                    right=Math.max(right,j);
                                }else if(line.get(j).d=='r'){
                                    // System.out.print(line.get(j).val+"  val ");
                                    line.get(j).val=line.get(j).val+1; 
                                    // System.out.print(line.get(j).val);
                                    rflag=true;
                                if(line.get(j).val==0 && (origin==1 || origin==2)){
                                    line.get(j).d=line.get(j).d=='l'?'r':'l';   oa=1; 
                                }
                                    if(line.get(j).val==0){
                                        if(origin==1 && freq==1){
                                            oa=1;
                                            list.get(lidx).get(aidx).d=list.get(lidx).get(aidx).d=='l'?'r':'l';  
                                        }
                                        origin=1; freq++; lidx=i; aidx=j;}
                                        // System.out.println("rrrr");
                                        left=Math.min(right,j);
                                }
                            }
                        }



                        if(last && line.get(m-1).d=='l'){
                            line.get(m-1).val=line.get(m-1).val-1;
                            if(line.get(m-1).val==0 && (origin==1 || origin==2)){
                                line.get(m-1).d=line.get(m-1).d=='l'?'r':'l';   oa=1;
                            }
                            if(line.get(m-1).val==0){
                                if(origin==1 && freq==1){  oa=1;
                                    list.get(lidx).get(aidx).d=list.get(lidx).get(aidx).d=='l'?'r':'l';  
                                }
                                origin=1; lidx=i; freq++; aidx=m-1;}
                            if(rflag)lflag=true;
                            right=Math.max(right,m-1);
                        }else if(last){
                            line.get(m-1).val=line.get(m-1).val+1; 
                            if(line.get(m-1).val==0 && (origin==1 || origin==2)){
                                line.get(m-1).d=line.get(m-1).d=='l'?'r':'l';  oa=1;
                            }
                                if(line.get(m-1).val==0){ 
                                    if(origin==1 && freq==1){ oa=1;
                                        list.get(lidx).get(aidx).d=list.get(lidx).get(aidx).d=='l'?'r':'l';  
                                    }
                                    origin=1; freq++; lidx=i; aidx=m-1;}
                            rflag=true;
                            left=Math.min(left,m-1);
                        }
                        if(!rflag || !rflag){rflag=false; lflag=false;}
                        
                    }
                    ans+=oa;
                    // System.out.println(ans +" "+lflag+" "+rflag+" "+oa+" ct="+ct); 
                    // ct++;   
                    // if(ct==20)return;
                }


                    // while(cn>0 && cp>0){
                    //     ans+=(cn+cp)-1;
                    //     cn--; cp--;
                    // }

                   System.out.println(ans); 
                }
    }   
}
    //V.V.V.Imp Problem Code: WIPL Watching CPL
    //code start
    /* package codechef; // don't place package name! */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// /* Name of the class has to be "Main" only if the class is public. */
// class Codechef
// {
//     static int[][] dp; 
//     public static int backtrack(int[] arr,int sum1,int sum2,int ci,int k){
//         if(sum1>=k && sum2>=k){
//             return 0;
//         }

//         if(sum1<=4000 && sum2<=4000 && dp[sum1][sum2]!=0)return dp[sum1][sum2];
//         if(ci<0)return 5000;
//         int res=5000;
//         if(sum1<k){
//            res=Math.min(res,backtrack(arr, sum1+arr[ci], sum2, ci-1,k)+1);
//         }
//         if(sum2<k){
//             res=Math.min(res,backtrack(arr, sum1, sum2+arr[ci], ci-1,k)+1);
//         }

//         if(sum1<=4000 && sum2<=4000)dp[sum1][sum2]=res;

//         return res;
//     }
    
// 	public static void main (String[] args) throws java.lang.Exception
// 	{
// 		// your code goes here
// 	 Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

		
// 		while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt();
//             int[] arr=new int[n];
//             long sum=0;
//             for(int i=0;i<n;i++){
//                 int val=scn.nextInt();
//                 sum+=val;
//                 arr[i]=val;
//             }
//             if(sum<(2*k)){
//                 System.out.println(-1);
//                 continue;
//                 }
//             dp=new int[4001][4001];
                
//             Arrays.sort(arr);
//             int ans=backtrack(arr, 0, 0, n-1, k);
//             if(ans>=5000){ans=-1;}
           
//             System.out.println(ans);
//         }
//     }
// }

//******************code end



//     static int[][] dp; 
//     public static int backtrack(int[] arr,int sum1,int sum2,int ci,int ct,int k){
//         if(sum1>=k && sum2>=k){
//             // System.out.println(ct);
//             // ans=Math.min(ans,ct);
//             return 0;
//         }

//         // if(ct>=ans)return;
//         if(sum1<=4000 && sum2<=4000 && dp[sum1][sum2]!=0)return dp[sum1][sum2];
//         if(ci<0)return 5000;
//         int res=5000;
//         if(sum1<k){
//            res=Math.min(res,backtrack(arr, sum1+arr[ci], sum2, ci-1,ct+1,k)+1);
//         }
//         if(sum2<k){
//             res=Math.min(res,backtrack(arr, sum1, sum2+arr[ci], ci-1,ct+1,k)+1);
//         }

//         if(sum1<=4000 && sum2<=4000)dp[sum1][sum2]=res;

//         return res;
//     }
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

		
// 		while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt();
//             // PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
//             int[] arr=new int[n];
//             long sum=0;
//             for(int i=0;i<n;i++){
//                 int val=scn.nextInt();
//                 sum+=val;
//                 arr[i]=val;
//             }
//             if(sum<(2*k)){
//                 System.out.println(-1);
//                 continue;
//                 }
//             // int size=(int)Math.min(sum,100000);    
//             dp=new int[4001][4001];
                
//             Arrays.sort(arr);
//             // System.out.println(arr[n-1]);
//             int ans=backtrack(arr, 0, 0, n-1,0, k);
//             if(ans>=5000){ans=-1;}
           
//             System.out.println(ans);
//         }
//     }
// }


            //     // pq.add(val);
            // }
            
//             if(sum<(2*k)){
//                 System.out.println(-1);
//                 continue;
//             }

//             int sum1=0,sum2=0;
//             int boxes=0;
//             while(pq.size()>0 && (sum1<k || sum2<k)){
//                 int max=pq.remove();

//                 if((k-sum1)>=max){
//                     sum1+=max;
//                 }else if((k-sum2)>=max){
//                     sum2+=max;
//                 }else{
//                     if(sum1<sum2){
//                         sum1+=max;
//                     }else{
//                         sum2+=max;
//                     }
//                 }
//                 boxes++;
//             }

//             if((sum1<k) ||(sum2<k)){boxes=-1;}

//             System.out.println(boxes);
//         }
//     }
// }


//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

		
// 		while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt();

//             int x=scn.nextInt();
//             int y=scn.nextInt();

//             if(x==y){
//                 x=n; y=n;
//                 System.out.println(x+" "+y);
//             }else if(x>y){
//                 int ct=1;
//                 ArrayList<int[]> list=new ArrayList<>();

//                 while(ct<=4 && ct<=k){
//                     if(ct==1 ){
//                         y=y+(n-x);  x=n; 
//                         list.add(new int[]{x,y}); ct++;
//                     }else if(ct==2){
//                         x=x-(n-y);
//                         y=n; 
//                         list.add(new int[]{x,y});  ct++;
//                     }else if(ct==3){
//                         y=y-(x);   x=0;
//                         list.add(new int[]{x,y});  ct++;
//                     }else{
//                         x=x+(y);    y=0;
//                         list.add(new int[]{x,y});  ct++;
//                     }
//                 }
//                 int idx=(k-1)%4;
//                 // System.out.println(idx+"   "+list.size());
                
//                 int[] ans=list.get(idx);
//                 System.out.println(ans[0]+" "+ans[1]);
//             }else{
//                 int ct=1;
//                 ArrayList<int[]> list=new ArrayList<>();
//                 while(ct<=4 && ct<=k){
//                     if(ct==1){
//                         x=x+(n-y);  y=n; 
//                         list.add(new int[]{x,y}); ct++;
//                     }else if(ct==2){
//                         y=y-(n-x);
//                         x=n; 
//                         list.add(new int[]{x,y}); ct++;
//                     }else if(ct==3){
//                         x=x-(y);   y=0;
//                         list.add(new int[]{x,y});  ct++;
//                     }else{
//                         y=y+(x);    x=0;
//                         list.add(new int[]{x,y});  ct++;
//                     }
//                 }
//                 int idx=(k-1)%4;
//                 // System.out.println(list.size());
//                 int[] ans=list.get(idx);
//                 System.out.println(ans[0]+" "+ans[1]);
//             }
//         }
//     }
// }






//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

//         // Scanner scn=new Scanner(System.in);
// 		// int t=scn.nextInt();
		
// 		while(t-->0){
//             int n=scn.nextInt();
//             int m=scn.nextInt();
//             PriorityQueue<Integer> minpq=new PriorityQueue<>();
//             PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
//             long minsum=0,maxsum=0;
            
//             for(int i=0;i<n;i++){
//                 int val=scn.nextInt();
//                 minpq.add(val);
//                 minsum+=val;
//             }
//             for(int i=0;i<m;i++){
//                 int val=scn.nextInt();
//                 maxpq.add(val);
//                 maxsum+=val;
//             }

//             int swap=0;
//             while(minsum<=maxsum && swap<n){

//                 int min=minpq.remove();
//                 int max=maxpq.remove();

//                 if(min>=max)break;

//                 minsum=minsum-min+max;
//                 maxsum=maxsum-max+min;

//                 minpq.add(max);
//                 maxpq.add(min);
//                 swap++;
//             }

//             if(minsum<=maxsum){swap=-1;}

//             System.out.println(swap);
//         }
//     }
// }
// 		    String str=scn.next();
            
//             String ans="";
//             int csum=0;
//             for(int i=0;i<n;i++){
//                 char ch=str.charAt(i);
//                 int bit=0;
//                 if(ch=='1'){
//                     bit=1;
//                 }
//                 csum=csum*2+bit;
//                 if((i+1)%4==0){
//                     ans+=(char)(csum+'a');
//                     csum=0;
//                 }
//             }
		    
            
//             System.out.println(ans);
// 		}
// 	}
// }

//         while(t-->0){
//             String str=scn.next();
//             char[] ch=str.toCharArray();

           
//             long ans=0;
//             boolean flag=true; int ct=1;
//             for(int i=1;i<str.length();i++){
//                 if(str.charAt(i-1)==str.charAt(i)){
//                     ct++;
                    
//                 }
//                 if(str.charAt(i-1)!=str.charAt(i) || i==str.length()-1){
//                     // if(ct>2 && ct%2==1){ans++;}
//                     ct=1;
//                 }
//             }
//             int n=str.length();
//             int[] mark=new int[n];

//             for(int i=1;i<n;i++){
//                 if(ch[i-1]==ch[i] && mark[i-1]==0){
//                     ans++; mark[i]=1;
//                 }

//                 if(i-2>=0 && ch[i-2]==ch[i] && mark[i-2]==0){
//                     ans++; mark[i]=1;
//                 }
//             }
//             System.out.println(ans);
//         }

//     }
// }



            // int[][] strg=new int[n][n];
            // int[] visited1=new int[n];
            // int[] visited2=new int[n];
            // for(int gap=Math.min(3,n)-1;gap>0;gap--){

            //     for(int i=0,j=gap;j<n;i++,j++){
            //         if(gap==0){
            //             // strg[i][j]=1;
            //         }else if(gap==1){
            //             if(arr[i]==arr[j] && (visited1[i]==0 && visited1[j]==0)){ visited1[i]=1; visited1[j]=1; ans++;
            //             visited2[j]=1;}
            //         }else if(gap==2){
            //             if(arr[i]==arr[j] && ((visited1[i]==0 && visited1[j]==0))){
            //                 visited1[i]=1; visited1[j]=1; ans++;  

            //                 if(arr[i]==arr[i+1] && visited1[i+1]==0){
            //                     visited1[i]=1;
            //                 }else if(arr[j]==arr[j] && visited1[j-1]==0){
            //                     visited1[j]=1;
            //                 }else if(i>0 && arr[i]==arr[i-1] && visited1[i-1]==0){
            //                     visited1[i]=1;
            //                 }else if(j<(n-1) && arr[j+1]==arr[j] && visited1[j+1]==0){
            //                     visited1[j]=1;
            //                 }
            //             }
            //         }
            //     }
            // }
            //||(visited2[i]==0 && visited1[j]==0)
//             System.out.println(ans);
//         }

//     }
// }



//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

//         while(t-->0){
//             int n=scn.nextInt();

//             HashMap<Integer,Integer> hm=new HashMap<>();
//             int max=-100;
//             for(int i=0;i<n;i++){
//                 int val=scn.nextInt();
//                 max=Math.max(max,val);
//                 hm.put(val, hm.getOrDefault(val, 0)+1);
//             }

//             ArrayList<int[]> list=new ArrayList<>();

//             for(int key:hm.keySet()){
//                 list.add( new int[]{key,hm.get(key)});
//             }

//             Collections.sort(list,(a,b)->a[0]-b[0]);
//             long ans=0;
//             // int i=0;
//             int carry=0;
//             int s=list.size();
//             for(int i=0;i<list.size();i++){
//                 ans++;
//                 if(list.get(i)[1]>1){carry=1;}
//                 // System.out.println(key);
//                 if((i==s-1) || ((i+1)<s && list.get(i+1)[0]!=((list.get(i)[0])+1))){ans+=carry; carry=0;}

//                 // if(hm.get(key)==1){
//                 //     ans++;
//                 // }else if(hm.get(key)>1 && !hm.containsKey(key+1)){
//                 //     ans+=2;
//                 //     carry=0;
//                 // }else{
//                 //     ans++;
//                 //     carry=1;
//                 // }

//                 // if(key==(max-1) && hm.get(key)>1 && hm.containsKey(key+1) && hm.get(key+1)==1){
//                 //     ans+=carry;
//                 // }

//                 // i++;
//             }

//             System.out.println(ans);
//         }
//     }
// }



//             int n=scn.nextInt();
//             int[] arr=new int[n];
//             HashMap<Integer,Integer> hm=new HashMap<>();
//             int prev=-1;
//             long ans=0;
//             for(int i=0;i<n;i++){
//                 arr[i]=scn.nextInt();
//                 // if(prev!=-1){
//                 //     int freq=hm.getOrDefault((val-prev), 0)+1;
//                 //     hm.put((val-prev),freq);
//                 //     if(freq>1){
//                 //         ans-=freq;
//                 //     }
//                 // }
//                 // prev=val;
//                 // if(i<n)ans+=i;
//             }

//             HashSet<Integer> hset=new HashSet<>();

//             for(int j=n-1;j>0;j--){

//                 for(int i=j-1;i>=0;i--){
//                     hset.add(arr[j]-arr[i]);
//                 }
//             }

//             System.out.println(hset.size());
//         }
//     }
// }
//             int n=scn.nextInt();
//             int k=scn.nextInt();

//             int[] arr=new int[n];
//             for(int i=0;i<n;i++){
//                 arr[i]=scn.nextInt();
//             }

//             int max=0,min=0;
//             for(int i=0;i<n;i++){
//                 int lmax=max,lmin=min;
//                 max=Math.min(max+(k-1),arr[i]+(k-1));
//                 min=Math.max(min-(k-1),arr[i]);

//                 if((arr[i]))
//             }
//         }
//     }
// }
//             int[] red=new int[n];

//             for(int i=0;i<n;i++){
//                 red[i]=scn.nextInt();
//             }

//             int m=scn.nextInt();
//             int[] blue=new int[m];

//             for(int i=0;i<m;i++){
//                 blue[i]=scn.nextInt();
//             }

//             int omax1=0,cmax1=0;
            
//             for(int i=0;i<n;i++){
//                 cmax1+=red[i];

//                 if(cmax1>0){omax1+=cmax1; cmax1=0;}
//             }

//              cmax1=0;

//             for(int i=0;i<m;i++){
//                 cmax1+=blue[i];

//                 if(cmax1>0){omax1+=cmax1; cmax1=0;}
//             }

//             System.out.println(omax1);
//         }
//     }
// }
//            String str=scn.next();

//            if(str.length()%2==1){
//                System.out.println("NO");
//                continue;
//            }else{
//                Stack<Integer> st1=new Stack<>();
//                Stack<Integer> st2=new Stack<>();
               
//                for(int i=0;i<str.length();i++){
//                    char ch=str.charAt(i);

//                    if(ch=='?'){
//                        st2.push(i);
//                    }else{
                       
//                     if(st1.size()>0 && str.charAt(st1.peek())=='(' && ch==')'){
//                         st1.pop();
//                     }else{
//                         st1.push(i);
//                     }
//                    }
//                }

//                boolean flag=true;
//                while(st1.size()>0){

//                 if(str.charAt(st1.peek())==')'){
//                     while(st2.size()>0 && st2.peek()>st1.peek()){
//                         st2.pop();
//                     }
//                     if(st2.size()>0 && st2.peek()<st1.peek()){
//                         st1.pop(); st2.pop();
//                     }else{flag=false; break;}
//                 }else if(str.charAt(st1.peek())=='('){
//                     // while(st2.size()>0 && st2.peek()<st1.peek()){
//                     //     st2.pop();
//                     // }
//                     if(st2.size()>0 && st2.peek()>st1.peek()){
//                         st1.pop(); st2.pop();
//                     }else{flag=false;  break;}
//                 }
//                }

//                if(flag)System.out.println("YES");
//                else System.out.println("NO");
//            }
//         }
//     }
// }
//             int ob=0,cb=0,qm=0;
//             boolean flag=true;
//             for(int i=0;i<str.length();i++){
//                 char ch=str.charAt(i);
//                 if(ch=='(')ob++;
//                 else if(ch==')')cb++;
//                 else qm++;

//                 if(cb>(ob+qm)){flag=false; break;}
//             }
//             if(ob>(cb+qm)){flag=false;}
//             if(cb>(ob+qm)){flag=false;}

//             if(flag)System.out.println("YES");
//             else System.out.println("NO");
//            }
//         }
//     }
// }
//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

//         while(t>0){
//             t--;
//             int n=scn.nextInt();
            // int r=scn.nextInt();
            // String str=scn.next();
//             boolean flag=true;
            
//             for(int i=0;i<(n-1);i++){
//                 if(str.charAt(i)==str.charAt(n-1)){
//                     System.out.println("YES");
//                     flag=false;
//                     break;
//                 }
//             }
//             if(flag)System.out.println("NO");
//         }
//     }
// }
        //     for(int i=(n%2==0?(n/2):((n/2)+1));i<n;i++){
        //     String a=str.substring(0,i);
        //         String b=str.substring(i);
        //     // System.out.println(a+"$"+b+"$");
                
        //         int l1=0,l2=0;
        //         int ct=0; int max=0;
        //         while(l1<a.length() && l2<b.length()){
        //             if(a.charAt(l1)==b.charAt(l2)){
        //                l1++; l2++;   
        //                ct++; 
        //             }else{
        //                 max=Math.max(max, ct);
        //                 ct=0;
        //                l1++;
        //                l2=0;     
        //             }
        //         }
        //         max=Math.max(max, ct);
        //         if(max>=b.length()){
        //             System.out.println("YES");
        //             flag=false;
        //             break;
        //         }
        //     }
        //     if(flag)System.out.println("NO");
        // }
//     }
// }


//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         long t=scn.nextLong();

//         while(t>0){
//             t--;
//             int n=scn.nextInt();
//             String str=scn.next();
//             // System.out.println(str+"rahul");
//             boolean flag=true;
//             for(int i=(n%2==0?(n/2):((n/2)+1));i<n;i++){
//             String a=str.substring(0,i);
//                 String b=str.substring(i);
//             // System.out.println(a+"$"+b+"$");
                
//                 int l1=0,l2=0;
//                 int ct=0; int max=0;
//                 while(l1<a.length() && l2<b.length()){
//                     if(a.charAt(l1)==b.charAt(l2)){
//                        l1++; l2++;   
//                        ct++; 
//                     }else{
//                         max=Math.max(max, ct);
//                         ct=0;
//                        l1++;
//                        l2=0;     
//                     }
//                 }
//                 max=Math.max(max, ct);
//                 if(max>=b.length()){
//                     System.out.println("YES");
//                     flag=false;
//                     break;
//                 }
//             }
//             if(flag)System.out.println("NO");
//         }
//     }
// }
//             long n=scn.nextLong();
//             long k=scn.nextLong();
//             PriorityQueue<Long> minpq=new PriorityQueue<>();
//             PriorityQueue<Long> maxpq=new PriorityQueue<>(Collections.reverseOrder());

//             for(int i=0;i<n;i++){
//                 minpq.add(scn.nextLong());
//             }

//             for(int i=0;i<n;i++){
//                 maxpq.add(scn.nextLong());
//             }

//             for(int i=0;i<k;i++){
//                 long val1=minpq.peek();
//                 long val2=maxpq.peek();

//                 if(val1<val2){
//                     minpq.remove(val1); maxpq.remove(val2);
//                     minpq.add(val2); maxpq.add(val1);
//                 }else break;
//             }
//             // System.out.println(minpq.size());    
            
//             long sum=0;
//             while(minpq.size()>0){sum+=minpq.poll();}
//             // System.out.println(minpq.size());    
//             System.out.println(sum);
//         }
//     }
// }
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //     String str=scn.next();
    //     long ans=0;
    //     long mod=(int)(Math.pow(10, 9))+7;
    //     for(int i=0;i<str.length();i++){
    //         String sstr="";
    //         for(int j=i;j<str.length();j++){     //T.C=O(n^3)
    //             sstr=str.substring(0, i)+str.substring(j+1);
    //         //   System.out.println(sstr);
    //           long num=0;
    //           if(!sstr.equals("")){
    //           num=Long.valueOf(sstr);
    //           }
    //           ans+=num;
    //           ans=ans%mod;
    //         }
    //     }
    //     ans=ans%mod;
    //     System.out.println(ans);
    //     }
    // }
//         public static void deleteSubstring(String s,String t){
//              String s="";
             
//             for(int i=0;i<s.length();i++){
//                 s+=s.charAt(i);
//             }
           
//             for(int i=s.length()-1;i>=0;i--){
//                 s+=s.charAt(i);
//             }

//         }

//   public static long myfun(int[][] grid){
//     long ans=0;

//     int i=0; int j=grid.length-1;

//     while(i<=j){
//         int c1=0; int c2=grid[0].length-1;

//         while(c1<=c2){
//              int val1=grid[i][c1]; int val2=grid[i][c2];
//              int val3=grid[j][c1]; int val4=grid[j][c2];
//              int max=Math.max(Math.max(val1,val2),Math.max(val3,val4));
//              int min=Math.min(Math.min(val1,val2),Math.min(val3,val4));
//              long mcurr=Integer.MAX_VALUE;
//              ArrayList<Integer> list=new ArrayList<>();
//              list.add(val1); list.add(val2);    list.add(val3);  list.add(val4);
//              list.remove(new Integer(max)); list.remove(new Integer(min));
//              int p=((list.get(0)+list.get(1))/2);

//             //  for(int p=min;p<=max;p++){
//                   long lcurr=Math.abs(val1-p);
//                   lcurr+=Math.abs(val2-p);
//                   lcurr+=Math.abs(val3-p);
//                   lcurr+=Math.abs(val4-p);  
//                   mcurr=Math.min(lcurr, mcurr);
//             //  }
//              if(c1==c2 || i==j)mcurr=mcurr/2;

//              ans+=mcurr;
//             c1++; c2--;
//         }
//         i++; j--;
//     }

//     return ans;
//   }

// }



//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//         int tc=scn.nextInt();
//         long[] res=new long[tc];
        
//         for(int i=0;i<tc;i++){
//           int n=scn.nextInt();
//           int m=scn.nextInt();
//           int[][] grid=new int[n][m];

//           for(int j=0;j<n;j++){
//               for(int k=0;k<m;k++){
//                   grid[j][k]=scn.nextInt();
//               }
//           }
// 	     res[i]=myfun(grid);
//         }
//         for(int i=0;i<res.length;i++){
//          System.out.println(res[i]);
//         }
//  }
// }   
