import java.util.*;
import java.lang.*;
import java.io.*;

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

public class cf705 {

   
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t= Integer.parseInt(br.readLine());

        while(t-->0){
        //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
            String[] strs=(br.readLine()).trim().split(" ");
            int n=Integer.parseInt(strs[0]),c0=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
            int c1=Integer.parseInt(strs[2]),h=Integer.parseInt(strs[3]);

            String str=(br.readLine()).trim();
            
            long ans=0;
            for(char ch:str.toCharArray()){

                 if(ch=='0' && (c0)>=(c1+h)){
                    ans+=c1+h;
                }else if(ch=='0' && (c0)<(c1+h)){
                    ans+=c0;
                }
                if(ch=='1' && (c1)>=(c0+h)){
                    ans+=c0+h;
                }else if(ch=='1' && (c1)<(c0+h)){
                    ans+=c1;
                }
                // if(ch=='0' && c0<c1){
                //     ans+=c0;
                // }else

            }

            System.out.println(ans);//"a="+
        }
    }
}

//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//             int mp=(int)Math.ceil(n/2.0);
//             strs=(br.readLine()).trim().split(" ");
//             long[] arr=new long[(n*k)+1];
//             int tl=(n*k);    
//             for(int i=1;i<=tl;i++){
//                 arr[i]=Long.parseLong(strs[i-1]);
//             }

//             long sum=0;
//             int lv=(mp-1)*k;
//             int jp=n-(mp-1);
//             for(int i=lv+1;i<=tl;i+=jp){
//                 sum+=arr[i];
//             }

//             System.out.println(sum);//
//         }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//            int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             // String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//             if(n==1){System.out.println(0);   continue;  }
//             int ans=0;
//             if(n%2==1){n--; ans++;   }

//             if(n>2){n=2; ans++;}

//             System.out.println((ans+1));
//         }
//     }
// }


//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
//             String a=(br.readLine()).trim();
//             String b=(br.readLine()).trim();
//             int[] arr1=new int[26];
//             int[] arr2=new int[26];

//             for(char ch:a.toCharArray()){
//                 arr1[ch-'a']++;
//             }
//             boolean f1=true;
//             for(char ch:b.toCharArray()){
//                 if(arr1[ch-'a']>0){arr1[ch-'a']--; }
//                 else{f1=false; arr2[ch-'a']++;}
//             }
//             if(f1){System.out.println("YES"); continue;}

//             boolean of=true;
//             for(int i=25;i>=0;i--){
//                 if(arr2[i]==0){continue;}
//                 boolean fg=false;
//                 for(int j=i-1;j>=0;j--){
//                     // if(arr1[j]==arr2[i] && arr1[j]==k){arr1[j]=0;  arr2[i]=0;  fg=true;}
//                     while(arr1[j]>=k && arr2[i]>=k){
//                         arr1[j]-=k;  arr2[i]-=k;
//                     }

//                     if(arr2[i]==0){fg=true; break;}
//                 }
//                 if(!fg){of=false; break;}
//             }

//             if(of){System.out.println("YES");}
//             else{System.out.println("NO");}
//         }
//     }
// }



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]),q=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
//             String str=(br.readLine()).trim();

//             int[] l=new int[n+1];
//             int[] r=new int[n+1];
//             int[] l0=new int[n+1];
//             int[] r0=new int[n+1];
//             // int i=0;
//             for(int i=1;i<=n;i++){
//                 l[i]=l[i-1];  l0[i]=l0[i-1];
//                 if(str.charAt(i-1)=='1'){l[i]++;}else{  l0[i]++;}
//             }
//             for(int i=n;i>=1;i--){
//                 if(i<n){r[i]=r[i+1];   r0[i]=r0[i+1];}
//                 if(str.charAt(i-1)=='1'){r[i]++;}else{ r0[i]++; }
//             }

//             for(int i=0;i<q;i++){
//                 strs=(br.readLine()).trim().split(" ");
//                 int li=Integer.parseInt(strs[0]),ri=Integer.parseInt(strs[1]);

//                 boolean f=false;
//                 // int rl=n-ri;

//                 if((li-1)>0 && str.charAt(li-1)=='1'){
//                     if(l[li-1]>0){f=true;}
//                 }
//                 if((ri+1)<=n && str.charAt(ri-1)=='1'){
//                     if(r[ri+1]>0){f=true;}
//                 }

//                 if((li-1)>0 && str.charAt(li-1)=='0'){
//                     if((l0[li-1])>0){f=true;}
//                     // if((li-1-l[li-1])>0){f=true;}
//                 }
//                 if((ri+1)<=n && str.charAt(ri-1)=='0'){
//                     // if((rl-r[ri+1])>0){f=true;}
//                     if((r0[ri+1])>0){f=true;}
//                 }

//                 if(f){
//                     System.out.println("YES");
//                 }else{
//                     System.out.println("NO");
//                 }
//             }
//         }
//     }
// }



//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
//             ArrayList<ArrayList<Integer>> gp=new ArrayList<>();

//             for(int i=0;i<=n;i++){gp.add(new ArrayList<>());}
//            for(int i=0;i<m;i++){
//              strs=(br.readLine()).trim().split(" ");
//              int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);
//              gp.get(u).add(v);  gp.get(v).add(u);      
//            } 
//            HashMap<ArrayList<Integer>,Integer> hm=new HashMap<>();
//            for(int i=1;i<=n;i++){
//             ArrayList<Integer> list=(gp.get(i));  Collections.sort(list);
//             hm.put(list, hm.getOrDefault(list, 0)+1);   //v.imp  get same list vertexes list properly
//            }                                            //i.e equals function work properly    

//         //    for(ArrayList<Integer> list:hm.keySet()){
//         //        System.out.print(list);  System.out.print(hm.get(list));   System.out.println();;
//         //    }     
//         //    int ans=-1;
//            int ct=0;

//            int[] arr=new int[n+1];
//            Arrays.fill(arr, 1);
//            for(ArrayList<Integer> list:hm.keySet()){
//                if((list.size()+hm.get(list))==n){
//                     ct++;
//                }else{
//                 continue;  //mymistake if(list.size()+hm.get(list))!=n) && ct==1 it will run below if statement
//              }              //i.e it will put '0' to some  positions of '1'    
//                if(ct==1){
//                   for(int val:list){arr[val]=0;}  //setb
//                }
//            }

//            System.out.println(ct);
                
//            if(ct==0){
//                for(int i=0;i<n;i++){System.out.print(0);}  
//            }else{
//                 for(int i=1;i<=n;i++){
//                 System.out.print(arr[i]);    
//                 }
//            }
//            System.out.println();
//         }
//     }
// }





    //Explaintion-https://www.youtube.com/watch?v=zZUY54SU1BI
//     public static int get(int val,int k){
//         return (k-val%k)%k;   //(4-5%4)%4=3
//     }
//     public static void main(String[] args) throws Exception{
//         InputStreamReader ip=new InputStreamReader(System.in);
//         BufferedReader br = new BufferedReader(ip);
//         // Scanner scn=new Scanner(System.in);
//         int t= Integer.parseInt(br.readLine());

//         while(t-->0){
//         //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//             String[] strs=(br.readLine()).trim().split(" ");
//             // // String strs=(br.readLine()).trim();
//             int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//            String str=(br.readLine()).trim();

//            if(n%k!=0){System.out.println(-1); continue;}  //beautiful string doesnot exist

//            int[] cnt=new int[26];

//            for(char ch:str.toCharArray()){
//                cnt[ch-'a']++;
//            }

//            int sum=0;   //No of extra each char req to make each occurance of char divisible by k 

//            for(int i=0;i<26;i++){
//                sum+=get(cnt[i],k);
//            }

//            if(sum==0){
//                System.out.println(str);  continue;
//            }
//            char[] s=str.toCharArray();
//            boolean f=true;

//            for(int i=n-1;i>=0 && f;i--){
//             sum-=get(cnt[s[i]-'a'],k);
//             cnt[s[i]-'a']--;
//             sum+=get(cnt[s[i]-'a'],k);

//             for(int j=(s[i]-'a')+1;j<26 && f;j++){  //v.imp   && flag no need to write break; any where
//                 int osum=sum;
//                 sum-=get(cnt[j],k);
//                 cnt[j]++;
//                 sum+=get(cnt[j],k);

//                 if(sum<=(n-(i+1))){
//                     for(int r=0;r<i;r++){
//                         System.out.print(s[r]);  //mymistake  s[i]
//                     }
//                     //mymistake I didnot use StringBuilder bcz adding a char in string is o(n) operation but in sb o(1) 
//                     System.out.print((char)('a'+j));  //v.imp
//                     // String add="";
//                     StringBuilder sb=new StringBuilder();
//                     for(int r=0;r<26;r++){
//                         int req=get(cnt[r], k);
//                         char ch=(char)('a'+r);
//                         while(req-->0){
//                             sb.append(ch);//add+=ch;//System.out.print(ch);
//                         }
//                     }
                    
//                     int cta=(n-(i+1))-sum;//sum =sb.length();
                    
//                     while(cta-->0){sb.append('a');}//add+='a';}

//                     String add=sb.toString();      
//                     char[] aarr=add.toCharArray();

//                     Arrays.sort(aarr);

//                     for(char c1:aarr){System.out.print(c1);}

//                     System.out.println();
//                     f=false;
//                     break;
//                 }
//                 cnt[j]--;
//                 sum=osum;
//             }
//            }
//         }
//     }
// }
