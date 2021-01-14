import java.util.*;

public class november {
    static int mod=1000000007;
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);

        int t=scn.nextInt();

        while(t-->0){
            int n=scn.nextInt();
            long[] arr=new long[n];
            long[] psum=new long[n];
            ArrayList<Integer> list=new ArrayList<>();
             //A1,A2,…,AN  are pairwise distinct //V.imp It means 1 cannot occur more than 1 time   
            for(int i=0;i<n;i++){
                arr[i]=scn.nextLong();
                
                if(arr[i]==1 && i<(n-1))list.add(i);
                if(arr[i]%2==1 && arr[i]>1 && i<(n-1))arr[i]-=1;
                if(i==(n-1) && arr[i]%2==0 && arr[i]>1)arr[i]-=1;
                if(i==(n-1))list.add(i);

                if(i==0){psum[i]=arr[i];}
                else{ psum[i]=psum[i-1]+arr[i];}
            }
            int q=scn.nextInt();
            
            long[] ans=new long[q];
            
            boolean chefturn=true; //dt
            for(int i=0;i<q;i++){
                int r=scn.nextInt();
                long chef=0; 
                long chefu=0;

                while(r>0){
                    if(r>=n){
                        //  chef=collect(list, psum, chef, chefu, chefturn,n);
                        int li=-1;
                        for(int j=0;j<list.size();j++){
                            int one=list.get(j);
                            if(li>=0){
                                if(chefturn){ chef+=(psum[one]-psum[li]); chef=chef%mod;}
                                else chefu+=psum[one]-psum[li];
                                li=one;
                            }else{
                                if(chefturn){ chef+=(psum[one]); chef=chef%mod;}
                                else chefu+=psum[one];
                                li=one;
                            }
                            chefturn=!chefturn;
                        }
                
                        //  if(!chefturn && li>=0){chef+=psum[n-1]-psum[li]; chef=chef%mod;}
                        //  else if(!chefturn) chef+=psum[n-1];
                
                        r-=n;
                        // System.out.println(chefturn);
                       chefturn=!chefturn;
                    //    System.out.println("chef="+chef+" "+r+" ct"+chefturn);
                    }else{
                        // chef=collect2(list, psum, chef, chefu, chefturn, n,r);
                        int li=-1;
                        // System.out.println(chefturn);
                        for(int j=0;j<list.size();j++){
                            int one=list.get(j);
                            if(one>=r){
                            if(li>=0){
                                if(chefturn){ chef+=(psum[r-1]-psum[li]); chef=chef%mod;}
                                else chefu+=psum[r-1]-psum[li];
                            }else{
                                if(chefturn){chef+=(psum[r-1]); chef=chef%mod;}
                                else chefu+=psum[r-1];
                            }
                            chefturn=!chefturn;
                            r=0;
                            break;
                        }else{
                            if(li>=0){  
                                if(chefturn){ chef+=(psum[one]-psum[li]); chef=chef%mod;}
                                else chefu+=psum[one]-psum[li];
                                li=one;
                            }else{
                                if(chefturn){ chef+=(psum[one]); chef=chef%mod;}
                                else chefu+=psum[one];
                                li=one;
                            } 
                        }
                        chefturn=!chefturn;
                       }
                        r=0;
                    }
                }

                ans[i]=chef%mod;
            }

            for(int i=0;i<q;i++)System.out.println(ans[i]);

        }
    }
}



    
//     public static long collect(ArrayList<Integer> list,long[] psum,long chef,long chefu,boolean chefturn,int n){
//         int li=-1;
//         for(int j=0;j<list.size();j++){
//             int one=list.get(j);
//             if(li>=0){
//                 if(chefturn) chef+=(psum[one]-psum[li]);
//                 else chefu+=psum[one]-psum[li];
//                 li=one;
//             }else{
//                 li=one; 
//                 if(chefturn) chef+=(psum[one]);
//                 else chefu+=psum[one];
//             }
//             chefturn=!chefturn;
//         }

//          if(!chefturn && li>=0)chef+=psum[n-1]-psum[li];
//          else if(!chefturn) chef+=psum[n-1];

//          System.out.println("Outside "+chef+" "+chefturn);
          
//          return chef;
//     }

//     public static long collect2(ArrayList<Integer> list,long[] psum,long chef,long chefu,boolean chefturn,int n,int r){
//         int li=-1;
//         System.out.println(chefturn);
//         for(int j=0;j<list.size();j++){
//             int one=list.get(j);
//             if(one>=r){
//             if(li>=0){
//                 if(chefturn) chef+=(psum[r]-psum[li]);
//                 else chefu+=psum[r]-psum[li];
//             }else{
//                 if(chefturn) chef+=(psum[r]);
//                 else chefu+=psum[r];
//             }
//             chefturn=!chefturn;
//             break;
//         }else{
//             if(li>=0){  
//                 if(chefturn) chef+=(psum[one]-psum[li]);
//                 else chefu+=psum[one]-psum[li];
//                 li=one;
//             }else{
//                 if(chefturn) chef+=(psum[one]);
//                 else chefu+=psum[one];
//                 li=one;
//             } 
//         }
//         chefturn=!chefturn;
          
//        }

//        return chef;
//     }




//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);

//         int t=scn.nextInt();

//         while(t-->0){
//             int n=scn.nextInt();
//             long[] arr=new long[n];
//             long[] psum=new long[n];
//             ArrayList<Integer> list=new ArrayList<>();

//             for(int i=0;i<n;i++){
//                 arr[i]=scn.nextLong();
                
//                 if(arr[i]==1)list.add(i);
//                 if(arr[i]%2==1 && arr[i]>1)arr[i]-=1;

//                 if(i==0){psum[i]=arr[i];}
//                 else psum[i]=psum[i-1]+arr[i];
//             }
//             int q=scn.nextInt();
            
//             long[] ans=new long[q];
            
//             boolean chefturn=true;
//             for(int i=0;i<q;i++){
//                 int r=scn.nextInt();
//                 long chef=0; 
//                 long chefu=0;

//                 while(r>0){
//                     if(r>=n){
//                         //  chef=collect(list, psum, chef, chefu, chefturn,n);
//                         int li=-1;
//                         for(int j=0;j<list.size();j++){
//                             int one=list.get(j);
//                             if(li>=0){
//                                 if(chefturn) chef+=(psum[one]-psum[li]);
//                                 else chefu+=psum[one]-psum[li];
//                                 li=one;
//                             }else{
//                                 if(chefturn) chef+=(psum[one]);
//                                 else chefu+=psum[one];
//                                 li=one;
//                             }
//                             chefturn=!chefturn;
//                         }
                
//                          if(!chefturn && li>=0)chef+=psum[n-1]-psum[li];
//                          else if(!chefturn) chef+=psum[n-1];
                
//                         r-=n;
//                         // System.out.println(chefturn);
//                        chefturn=!chefturn;
//                     //    System.out.println("chef="+chef+" "+r+" ct"+chefturn);
//                     }else{
//                         // chef=collect2(list, psum, chef, chefu, chefturn, n,r);
//                         int li=-1;
//                         // System.out.println(chefturn);
//                         for(int j=0;j<list.size();j++){
//                             int one=list.get(j);
//                             if(one>=r){
//                             if(li>=0){
//                                 if(chefturn) chef+=(psum[r-1]-psum[li]);
//                                 else chefu+=psum[r-1]-psum[li];
//                             }else{
//                                 if(chefturn) chef+=(psum[r-1]);
//                                 else chefu+=psum[r-1];
//                             }
//                             chefturn=!chefturn;
//                             break;
//                         }else{
//                             if(li>=0){  
//                                 if(chefturn) chef+=(psum[one]-psum[li]);
//                                 else chefu+=psum[one]-psum[li];
//                                 li=one;
//                             }else{
//                                 if(chefturn) chef+=(psum[one]);
//                                 else chefu+=psum[one];
//                                 li=one;
//                             } 
//                         }
//                         chefturn=!chefturn;
//                        }
//                         r=0;
//                     }
//                 }

//                 ans[i]=chef;
//             }

//             for(int i=0;i<q;i++)System.out.println(ans[i]);

//         }
//     }
// }


//     public static void main(String[] args){
//         Scanner scn=new Scanner(System.in);

//         int t=scn.nextInt();

//         while(t-->0){
//             int n=scn.nextInt();
//             int k=scn.nextInt();

//             String str=scn.next();

//             int[] sheet=new int[n];
//             int[] blocked=new int[n];
//             for(int i=0;i<n;i++){
//                 char ch=str.charAt(i);
//                 if(ch=='X'){
//                      if(i>0){blocked[i]+=blocked[i-1];  sheet[i]+=sheet[i-1];}
//                      blocked[i]+=1;   
//                 }else if(ch==':'){
//                      if(i>0){sheet[i]+=sheet[i-1]; blocked[i]+=blocked[i-1];}
//                      sheet[i]+=1;   
//                 }
//             }

//             // int i=1,j=0;

//             boolean[] visited=new boolean[n];
//                 int ans=0;
//                 // while(i<n && j<n){
//                 //     // System.out.println("Rahul "+i+" "+j+" "+ans);
//                 //     if(str.charAt(j)=='X')j++;
//                 //     else if(str.charAt(i)=='X')i++; j=i;

//                 //     if(i<=j)i=j+1;

//                 //     if(i==n || j==n)break;
//                 //     if(str.charAt(i)=='M' && str.charAt(j)=='I' && !visited[i] && !visited[j]){
//                 //         int p=k+1-(i-j)-(sheet[i]-sheet[j]);
//                 //         if(p>0){  ans++;
//                 //             visited[i]=true;  visited[j]=true;
//                 //             i++; j++;
//                 //         }else{j++; }
//                 //     }else if(str.charAt(i)=='I' && str.charAt(j)=='M' && !visited[i] && !visited[j]){
//                 //         int p=k+1-(i-j)-(sheet[i]-sheet[j]);
//                 //         if(p>0){  ans++;
//                 //             visited[i]=true;  visited[j]=true;
//                 //             i++; j++;
//                 //         }else{j++;}
//                 //     }else{

//                 //         char chi=str.charAt(i);
//                 //         char chj=str.charAt(j);
//                 //         if(chi!='M' && chi!='I' && chj!='M' && chj!='I'){i++; j++;}
//                 //         else if(chi!='M' && chi!='I')i++;
//                 //         else if(chj!='M' && chj!='I')j++;
//                 //         else if(visited[i])i++;
//                 //         else if(visited[j])j++;
//                 //         else if(chi==chj)i++;
//                 //         else j++;
//                 //     }
//                 // }

//     //             System.out.println(ans);
//     //         }
//     //     }
//     // }

//         ArrayList<ArrayList<Integer>> magnets=new ArrayList<>();       
//         ArrayList<ArrayList<Integer>> irons=new ArrayList<>();
//         ArrayList<Integer> mlist=new ArrayList<>();
//         ArrayList<Integer> ilist=new ArrayList<>();            
//         for(int i=0;i<n;i++){
//             char ch=str.charAt(i);
//             if(ch=='M'){
//                 mlist.add(i);
//             }else if(ch=='I'){
//                 ilist.add(i);
//             }else if(ch=='X'){
//                 magnets.add(mlist);
//                 irons.add(ilist);
//                 mlist=new ArrayList<>();
//                 ilist=new ArrayList<>();
//             }
//         }
//         if(mlist.size()>0 && ilist.size()>0)magnets.add(mlist); irons.add(ilist);

//         for(int i=0;i<magnets.size();i++){
//                 ArrayList<Integer> list1=magnets.get(i);
//                 if(list1.size()==0)continue;
//                 ArrayList<Integer> list2=irons.get(i);
//                 if(list2.size()==0)continue;
                
//                 // for(int l=0;l<l1size;l++){
//                 //     int l1=list1.get(l);
//                 //     for(int m=0;m<l2size;m++){
//                     int l=0,m=0;
//                     int l1size=list1.size(),l2size=list2.size();
                   
//                     int min=Math.min(list1.get(0),list2.get(0));
//                     int max=Math.max(list1.get(l1size-1),list2.get(l2size-1));
//                     int st=sheet[max]-sheet[min];
//                     if(k>(((max-min))+st)){ans+=Math.min(l1size,l2size); continue;}
//                     while(l<l1size && m<l2size){
//                         int l1=list1.get(l);
//                         int m1=list2.get(m);
//                         while(visited[l1]){l++; if(l>=l1size){break;} l1=list1.get(l);}
//                         while(visited[m1]){m++; if(m>=l2size){break;} m1=list2.get(m);}
                        
//                         if(l>=l1size || m>=l2size)break;

//                         int p=k+1-Math.abs(l1-m1)-Math.abs(sheet[l1]-sheet[m1]);
                        
//                         if(!visited[l1] && !visited[m1] && p>0){ans++; visited[l1]=true;  visited[m1]=true; l++; m++;}
//                         if(p<=0){
//                             if(l1<m1){
//                                 l++;
//                             }else{
//                                 m++;
//                             }
//                         }
//                     }
//                         //  int m1=list2.get(m);
//                         // int p=k+1-Math.abs(l1-m1)-Math.abs(sheet[l1]-sheet[m1]);

//                         // if(!visited[l1] && !visited[m1] && p>0){ans++; visited[l1]=true;  visited[m1]=true;}
//                 //     }
//                 // }
//            }

//         System.out.println(ans);
//     }
// }
// }

                    // for(int i=0;i<n;i++){
                    //     if(str.charAt(i)=='X' || str.charAt(i)==':' || str.charAt(i)=='_')continue;
                    //     for(int j=i+1;i<j && j<n && ((j-i)+(sheet[j]-sheet[i]))<(k+1);j++){
                    //         if(str.charAt(j)=='X')break;
                    //         if(str.charAt(i)=='M' && str.charAt(j)=='I' && !visited[i] && !visited[j]){
                    //             int p=k+1-(j-i)-(sheet[j]-sheet[i]);
                    //             if(p>0){  ans++;
                    //                 visited[i]=true;  visited[j]=true;
                    //                 break;
                    //             }
                    //         }else if(str.charAt(j)=='M' && str.charAt(i)=='I' && !visited[i] && !visited[j]){
                    //             int p=k+1-(j-i)-(sheet[j]-sheet[i]);
                    //             if(p>0){  ans++;
                    //                 visited[i]=true;  visited[j]=true;
                    //                 break;
                    //             }
                    //         }
                    //     }
                    // }
    //            System.out.println(ans);
    //         }
    //     }
    // }


    
    
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);

    //     int t=scn.nextInt();

    //     while(t-->0){
    //         int n=scn.nextInt();
    //         HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>(); 
    //         for(int i=0;i<n;i++){
    //             int key=scn.nextInt();
    //             ArrayList<Integer> list=hm.getOrDefault(key, new ArrayList<Integer>());
    //             list.add(i);
    //             hm.put(key,list);
    //         }
    //         int[] A=new int[n];
    //         int val=1;    
    //         for(int k=n;k>=1;k--){
    //             if(hm.containsKey(k)){
    //             ArrayList<Integer> list=hm.get(k);

    //             for(int i=0;i<list.size();i++){
    //                 A[list.get(i)]=val;
    //             }
    //             val++;
    //             }
    //         }

    //         for(int r=0;r<n;r++){
    //             System.out.print(A[r]+" ");
    //         }
    //         System.out.println();
    //         }

    //     }
    // }

    //Question-1
    // public static void main(String[] args){
    //     Scanner scn=new Scanner(System.in);

    //     int t=scn.nextInt();

    //     while(t-->0){
    //         int n=scn.nextInt();
    //         PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());    
    //         for(int i=0;i<n;i++){
    //             pq.add(scn.nextInt());
    //         }

    //         long val1=0;
    //         long val2=0;

    //         boolean flag=true;

    //         while(pq.size()>0){
    //             if(val1<val2){
    //                 val1+=pq.remove();
    //             }else if(val1>val2){
    //                 val2+=pq.remove();
    //             }else{
    //                 val1+=pq.remove();
    //             }
    //             // if(flag){
    //             //     val1+=pq.remove();
    //             //     if(pq.size()>0)val2+=pq.remove();
    //             // }else{
    //             //     val2+=pq.remove();
    //             //     if(pq.size()>0)val1+=pq.remove();
    //             // }
    //             // flag=!flag;
    //         }

    //         long ans=Math.max(val1, val2);
    //         System.out.println(ans);
    //     }
    // }
// }
