import java.util.*;

public class cc4 {


    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int t=scn.nextInt();

        while(t-->0){
        int n=scn.nextInt();

        int[] arr=new int[n];

        for(int i=0;i<n;i++){arr[i]=scn.nextInt();}

        long iv=0;

        int ct=0;
        int max=0;
        for(int i=1;i<(n-1);i++){

            if(arr[i-1]<arr[i] && arr[i]>arr[i+1]){
                iv++;
                ct++;
                max=Math.max(ct,max);

                
            }else if(arr[i-1]>arr[i] && arr[i]<arr[i+1]){
                iv++;
                ct++;
               
                if(i+2<n && arr[i+2]>arr[i+1]){ct--;}
                max=Math.max(ct,max);
            }else{
                ct=0;
            }
            
        }

        if(max>=3)iv=iv-3;
        else if(max>=2)iv=iv-2;
        else{iv=iv-1;}

        if(iv<0){iv=0;}

        System.out.println(iv);
        }
    }
}
//         if(n==1){
//             System.out.println("9");
//         }else if(n==2){
//             System.out.println("98");
//         }else{
//             String str="";
//             int ct=0,i=0;
//             while(i<=9 && i<(n-3)){
//                 str+=""+ct;
//                 ct=(ct+1);
//                 i++;
//             }

//             while(str.length()<(n-3)){
//                 if((2*str.length())<=(n-3)){
//                     str+=str;
//                 }else{
//                     str+=str.substring(0,n-3-str.length());
//                 }
//             }
            
//             System.out.println("989"+str);
//         }
//         }
//     }
// }

//     public static void main(String[] args){
//         PriorityQueue<int[]> pq=new PriorityQueue<>((p1,p2)->p2[0]-p1[0]);
//         pq.add(new int[]{6,2}); 
//         pq.add(new int[]{1,2}); 
        
//         System.out.println((pq.remove())[0]);
//         Scanner scn=new Scanner(System.in);
//         int t=scn.nextInt();

//         while(t-->0){
//         int n=scn.nextInt();
//         int m=scn.nextInt();

//         int[][] arr=new int[n][m];
        
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 arr[i][j]=scn.nextInt();
//             }
//         }

//         int q=scn.nextInt();
//         int[][] query=new int[q][3];
//         for(int i=0;i<q;i++){
//             query[i][0]=scn.nextInt();
//             query[i][1]=scn.nextInt();
//             query[i][2]=scn.nextInt();
//         }

//         ArrayList<Boolean> list1=new ArrayList<>();
//         ArrayList<Boolean> list2=new ArrayList<>();

//         for(int gap=0;gap<n;gap++){
//             int pval=Integer.MAX_VALUE;
//             boolean flag=true;
//             for(int i=gap,j=0;i<n && j<m;i++,j++){
//                 if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
//                 else{pval=arr[i][j];}
//             }
//             list1.add(gap,flag);
//         }
//         for(int gap=1;gap<m;gap++){
//             int pval=Integer.MAX_VALUE;
//             boolean flag=true;
//             for(int i=0,j=gap;i<n && j<m;i++,j++){
//                 if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
//                 else{pval=arr[i][j];}
//             }
//             list2.add(gap-1,flag);
//         }


//         for(int k=0;k<q;k++){
//             int r=query[k][0]-1,c=query[k][1]-1;
//             arr[r][c]=query[k][2];

//             if(r>=c){
//                 int gap=r-c;//Math.max(r,c)-Math.min(r,c);
//                 int pval=Integer.MAX_VALUE;
//                 boolean flag=true;//"Yes";
//                 for(int i=gap,j=0;i<n && j<m;i++,j++){
//                     if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
//                     else{pval=arr[i][j];}
//                 }
//                 list1.set(gap, flag);
//             }else{
//                 int gap=c-r;//Math.max(r,c)-Math.min(r,c);//c;
//                 int pval=Integer.MAX_VALUE;
//                 boolean flag=true;//"Yes";
//                 for(int i=0,j=gap;i<n && j<m;i++,j++){
//                     if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
//                     else{pval=arr[i][j];}
//                 }
//                 list2.set(gap-1,flag);
//             }

//             String ans="Yes";

//             for(int i=0;i<list1.size();i++){
//                 if(list1.get(i)==false){ans="No"; break;}
//             }

//             if(ans.equals("No")){System.out.println(ans);  continue;}

//             for(int i=0;i<list2.size();i++){
//                 if(list2.get(i)==false){ans="No"; break;}
//             }

//             System.out.println(ans);
//         }

//         }
//     }
// }

//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);
//                 int t=scn.nextInt();

//                 while(t-->0){
//                 int n=scn.nextInt();
//                 int[] arr=new int[n];
//                 HashMap<Integer,Integer> hm=new HashMap<>();   
//                 for(int i=0;i<n;i++){
//                     arr[i]=scn.nextInt();
//                     hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
//                 }
//                 int ans=0;
//                 for(int key:hm.keySet()){
//                     if(hm.get(key)%2==1){ans++;}
//                 }
//                 System.out.println(ans);
//                 }
//     }
// }

    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             int t=scn.nextInt();

    //             while(t-->0){
    //             int n=scn.nextInt();
    //             int m=scn.nextInt();

    //             int[][] arr=new int[n][m];
                
    //             for(int i=0;i<n;i++){
    //                 for(int j=0;j<m;j++){
    //                     arr[i][j]=scn.nextInt();
    //                 }
    //             }

    //             int q=scn.nextInt();
    //             int[][] query=new int[q][3];
    //             for(int i=0;i<q;i++){
    //                 query[i][0]=scn.nextInt();
    //                 query[i][1]=scn.nextInt();
    //                 query[i][2]=scn.nextInt();
    //             }


    //             // ArrayList<Boolean> list=new ArrayList<>();
        
    //             // for(int gap=0;gap<n;gap++){
    //             //     int pval=Integer.MAX_VALUE;
    //             //     boolean flag=true;
    //             //     for(int i=gap,j=0;i<n && j<m;i++,j++){
    //             //         if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
    //             //         else{pval=arr[i][j];}
    //             //         System.out.print(arr[i][j]+"  ");
    //             //     }
    //             //     list.add(0,flag);
    //             //     System.out.println();
    //             // }
    //             // for(int gap=1;gap<m;gap++){
    //             //     int pval=Integer.MAX_VALUE;
    //             //     boolean flag=true;
    //             //     for(int i=0,j=gap;i<n && j<m;i++,j++){
    //             //         if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag=false; break;}
    //             //         else{pval=arr[i][j];}
    //             //         System.out.print(arr[i][j]+"  ");
    //             //     }
    //             //     list.add(flag);
    //             //     System.out.println();
    //             // }


    //             for(int k=0;k<q;k++){
    //                 int r=query[k][0]-1,c=query[k][1]-1;
    //                 arr[r][c]=query[k][2];

    //                 if(r>=c){
    //                     int gap=r;
    //                     int pval=Integer.MAX_VALUE;
    //                     String flag="Yes";
    //                     for(int i=gap,j=0;i<n && j<m;i++,j++){
    //                         if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag="No"; break;}
    //                         else{pval=arr[i][j];}
    //                     }
    //                     System.out.println(flag); 
    //                 }else{
    //                     int gap=c;
    //                     int pval=Integer.MAX_VALUE;
    //                     String flag="Yes";
    //                     for(int i=0,j=gap;i<n && j<m;i++,j++){
    //                         if(pval!=Integer.MAX_VALUE && pval!=arr[i][j]){ flag="No"; break;}
    //                         else{pval=arr[i][j];}
    //                         // System.out.print(arr[i][j]+"  ");
    //                     }
    //                     System.out.println(flag);
    //                 }

    //             }

                
        


    //             }
    //         }
    //     }
    
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);
    //             int t=scn.nextInt();

    //             while(t-->0){
    //             String str=scn.next();
    //             int[] arr=new int[26];
    //             int n=str.length();

    //             for(int i=0;i<n;i++){
    //                 arr[str.charAt(i)-'a']++;
    //             }

    //             PriorityQueue<Integer> maxpq=new PriorityQueue<>(Collections.reverseOrder());
    //             PriorityQueue<Integer> minpq=new PriorityQueue<>();

    //             for(int i=0;i<26;i++){
    //                 if(arr[i]!=0){maxpq.add(arr[i]);  minpq.add(arr[i]);}
    //             }
    //             int ans=0;

    //             while(maxpq.size()>0 && maxpq.peek()>=2){
    //                 int m1=maxpq.remove();
    //                 minpq.remove(m1);

    //                 int m2=0;
    //                 if(minpq.size()>0){m2=minpq.remove(); maxpq.remove(m2);}

    //                 if(m1<2 || (m1+m2)<3)break;

    //                 if(m1>=2 && m2>=1){
    //                     if(m1-2>0){maxpq.add(m1-2); minpq.add(m1-2);}  
    //                     if(m2-1>0){maxpq.add(m2-1); minpq.add(m2-1);} 
    //                     ans++;}
    //                 else if(m1>=3){
    //                     if(m1-3>0){
    //                         maxpq.add(m1-3);
    //                         minpq.add(m1-3);
    //                     } ans++;
    //                 }else{
    //                     break;
    //                 }
    //             }

    //             System.out.println(ans);

    //             }
    //         }
    // }





        // Scanner scn=new Scanner(System.in);
        // int t=scn.nextInt();

        // while(t-->0){
        //     int n=scn.nextInt();

        //     String str1=scn.next();
        //     String str2=scn.next();
            
        //     int p0=0,p1=0,s0=0,s1=0;
        //     int ct1=0;
        //     boolean flag=true;
        //     for(int i=0;i<n;i++){
        //         if(str1.charAt(i)=='1'){
        //             s1++;
        //         }else{s0++;}

        //         if(str2.charAt(i)=='1'){
        //             p1++;
        //         }else{p0++;}

        //         if(str1.charAt(i)!=str2.charAt(i)){
        //             if(str1.charAt(i)=='1'){ct1++;}
        //             else{ct1--;}

        //             if(ct1<0){System.out.println("No"); flag=false; break;}
        //         }
        //     }

        //     if(p0!=s0 || p1!=s1){
        //         System.out.println("No");    
        //     }else if(flag){
        //         System.out.println("Yes");
        //     }

            

        // }
//     }
// }
