import java.util.*;
import java.lang.*;
import java.io.*;



public class cf710 {

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

    public static String func(int st,char[] arr){
        String ostr="";
        int n=arr.length;
        boolean[]vst=new boolean[26];
        for(int i=st;i<n;i++){
            if(vst[arr[i]-'a']){
                // String nstr=arr[i]+"";
                
                StringBuilder sb=new StringBuilder();
                

                for(int j=0;j<ostr.length();j++){
                    if(ostr.charAt(j)!=arr[i]){
                       sb.append(ostr.charAt(j)); //nstr+=ostr.charAt(j); 
                        //  vst[ostr.charAt(j)-'a']=true;
                    }
                }

                sb.append(arr[i]);

                String nstr=sb.toString();
                boolean fg=false;
                for(int j=0;j<ostr.length();j++){
                    if(ostr.charAt(j)<nstr.charAt(j)){  fg=true;  break;}
                    else if(ostr.charAt(j)>nstr.charAt(j)){fg=false; break;}
                }

                // System.out.println(ostr+"    nstr   "+nstr+"  flag   "+fg);
               
                if(fg){
                ostr=nstr;
                }
            }else{    
                vst[arr[i]-'a']=true;
                ostr=ostr+arr[i];
            }
        }

        return ostr;
    }
public static void main(String[] args) throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t= Integer.parseInt(br.readLine());
    
    while(t-->0){
        // int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,x=Long.parseLong(strs[2]);
        String str=(br.readLine()).trim();
        
        boolean[] vst=new boolean[26];
        char[] arr=str.toCharArray();
        int n=str.length();
        int uc=0;

        for(int i=0;i<n;i++){
            if(!vst[(int)(arr[i]-'a')]){uc++; vst[(arr[i]-'a')]=true; }
        }

        char[] lmax=new char[n];
        lmax[0]=arr[0];
        char max=arr[0];
        for(int i=1;i<n;i++){
            lmax[i]=max;
            if(arr[i]>max){max=arr[i]; }
        }

        int[] ruct=new int[n];
        vst=new boolean[26];
        int muct=0;
        for(int i=n-1;i>=0;i--){
            if(!vst[arr[i]-'a']){
                muct++;  vst[arr[i]-'a']=true;
            }
            ruct[i]=muct;
        }

        int st=0;
        max='a';
        String ans="";
        for(int i=1;i<n;i++){
            if(lmax[i]<=arr[i] && arr[i]>=max && ruct[i]>=uc){
                st=i;
                String s=func(st, arr);

                if(ans.length()==0){
                    ans=s;
                }else{
                    boolean fg=false;
                    for(int j=0;j<ans.length();j++){
                        if(ans.charAt(j)<s.charAt(j)){  fg=true;  break;}
                        else if(ans.charAt(j)>s.charAt(j)){fg=false; break;}
                    }
    
                    // System.out.println(ostr+"    nstr   "+nstr+"  flag   "+fg);
                   
                    if(fg){
                    ans=s;
                    }
                }
            }
        }
        // int n=str.length();
        
        System.out.println("a=="+ans);
        // System.out.println(ostr);
        // System.out.println("Ans=="+ostr);
        }
    }
}


// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//         int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         // int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,x=Long.parseLong(strs[2]);
//         // String X=(br.readLine()).trim();

//         boolean[] vst=new boolean[n+1];
//         int[] arr=new int[n];
//         int[] ans=new int[n];
//         int st=1;

//         //Min
//         for(int i=0;i<n;i++){
//             arr[i]=Integer.parseInt(strs[i]);
//             if(i==0){
//                 ans[i]=arr[i];  vst[ans[i]]=true;
//             }else{
//                 if(arr[i-1]!=arr[i]){
//                     ans[i]=arr[i];  vst[ans[i]]=true;
//                 }else{
//                     while(vst[st]){
//                         st++;
//                     }
//                     ans[i]=st;  vst[ans[i]]=true;
//                 }
//             }
//         }

//         for(int i=0;i<n;i++){
//             System.out.print(ans[i]+" ");
//         }


//         //Max
//         int ed=-1;
//         // int max=-1;
//         vst=new boolean[n+1];
//         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());//use pq to avoid TLE

//         for(int i=0;i<n;i++){
//             // arr[i]=Integer.parseInt(strs[i]);
//             if(i==0){
//                 ans[i]=arr[i];  vst[ans[i]]=true;  ed=ans[i]-1;     if(ed>0 && !vst[ed]){pq.add(ed);}
//             }else{
//                 if(arr[i-1]!=arr[i]){
//                     ans[i]=arr[i];  vst[ans[i]]=true;  ed=ans[i]-1;   if(ed>0 &&!vst[ed]){pq.add(ed);}
//                 }else{

//                     // if(max<n){
//                     //     ed=arr[i];
//                     // }

//                     //     while(vst[ed]){
//                     //     ed--;
//                     // }
                
//                       ed=pq.peek();  pq.remove();  
//                     ans[i]=ed;  vst[ans[i]]=true;   ed--;  if(ed>0 &&!vst[ed]){pq.add(ed);} // max=Math.max(ed, max);
//                 }
//             }
//         }  
        
//         // System.out.println("+++++++=");
//         System.out.println();
//         for(int i=0;i<n;i++){
//             System.out.print(ans[i]+" ");
//         }    

//         System.out.println();  //"tt"
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
//         // int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,x=Long.parseLong(strs[2]);
//         // String X=(br.readLine()).trim();

//         // int[] arr=new int[n];
//         HashMap<Integer,Integer> hm=new HashMap<>();

//         for(int i=0;i<n;i++){
//             int val=Integer.parseInt(strs[i]);
//             hm.put(val, hm.getOrDefault(val, 0)+1);
//         }

//         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
//         for(int key:hm.keySet()){
//             pq.add(hm.get(key));
//         }

//         // if(pq.size()==1){
//         //     System.out.println(pq.peek());  continue;
//         // }
//         boolean fg=true;

//         while(true && pq.size()>1){
//             int v1=pq.peek();   pq.remove();
//             int v2=pq.peek();  pq.remove();

//             // if(v1!=0 && v2==0){fg=false;  break;}
//             // else 
//             if(v1==0 || v2==0){fg=false; pq.add(v1);   pq.add(v2); break;}
//             v1--;  v2--;
//             pq.add(v1);   pq.add(v2);

//         }


//         // if(fg){
//             System.out.println(pq.peek());//"A=="+
//         // }
//         }
//     }
// }










//     //Q-3  V.V.Imp
//     public static int LCSubStr(char X[], char Y[],int m, int n){
//     // Create a table to store
//     // lengths of longest common
//     // suffixes of substrings.
//     // Note that LCSuff[i][j]
//     // contains length of longest
//     // common suffix of
//     // X[0..i-1] and Y[0..j-1].
//     // The first row and first
//     // column entries have no
//     // logical meaning, they are
//     // used only for simplicity of program
//     int LCStuff[][] = new int[m + 1][n + 1];

//     // To store length of the longest
//     // common substring
//     int result = 0;

//     // Following steps build
//     // LCSuff[m+1][n+1] in bottom up fashion
//     for (int i = 0; i <= m; i++){
//     for (int j = 0; j <= n; j++){
//     if (i == 0 || j == 0)
//     LCStuff[i][j] = 0;
//     else if (X[i - 1] == Y[j - 1])
//     {
//     LCStuff[i][j]= LCStuff[i - 1][j - 1] + 1;   //v.V.IMp
//     result = Integer.max(result,LCStuff[i][j]);
//     }
//     else
//     LCStuff[i][j] = 0;
//     }
//     }
//     return result;
//     }


//     public static int longComSubString(String x,String y){
//         int n=x.length(),m=y.length();
//         int[][] mat=new int[n+1][m+1];


//         int max=0;
//         for(int i=n-1;i>=0;i--){

//             for(int j=m-1;j>=0;j--){
//                 if(x.charAt(i)==y.charAt(j)){
//                     mat[i][j]=mat[i+1][j+1]+1;
//                     max=Math.max(mat[i][j], max);
//                 }
//             }
//         }

//         return max;
//     }
// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         // String[] strs=(br.readLine()).trim().split(" ");
//         // int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,x=Long.parseLong(strs[2]);
//         String X=(br.readLine()).trim();
//         String Y=(br.readLine()).trim();
//         int m = X.length();
//         int n = Y.length();
        
//         // int max=LCSubStr(X.toCharArray(),Y.toCharArray(), m,n);
//         int max=longComSubString(X, Y);
//         int ans=(m+n)-2*max;
//         System.out.println(ans);

//          }
//     }
// }







//Q2
// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//        int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=(int)Long.parseLong(strs[0]),k=(int)Long.parseLong(strs[1]);//,x=Long.parseLong(strs[2]);
       
//         int st=-1,ed=-1;
//         int idx=0;int ct=0;
//         for(char ch:str.toCharArray()){

//             if(ch=='*' && st==-1){
//                 st=idx; ct++;
//             }else if(ch=='*'){
//                 ed=idx; ct++;
//             }
//             idx++;
//         }


//         if(ct<3){
//             System.out.println(ct);  continue;  //"aa=="+
//         }


//          idx=st;
//         int ans=2;
//         while((idx+k)<ed){
//             if((idx+k)>=ed || (idx+k)>=n)break;

//             int mi=-1;
//             for(int j=idx+1;j<=(idx+k);j++){
//                 if(str.charAt(j)=='*'){
//                     mi=j;
//                 }
//             }

//             if(mi>0){ans++; idx=mi;}
//         }

//         System.out.println(ans);//"aa=="+
//     }
// }
// }






//Q1

// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());
    
//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         long n=Long.parseLong(strs[0]),m=Long.parseLong(strs[1]),x=Long.parseLong(strs[2]);//,k=Integer.parseInt(strs[2]);

//         long row=(x%n);
//         if(row==0){row=(long)n;}
//         long col=(long)Math.ceil((x*1.0)/n);

//         long val=0;

//         // for(int i=1;i<(int)row;i++){
//             val+=m*(row-1);
//         // }

//         val+=col;

//         System.out.println(val);  //"aa="+
//     }
// }

// }