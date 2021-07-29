import java.util.*;

public class gfgs {
    static class arrComparator implements Comparator<int[]>{
        public int compare(int[] cp1,int[] cp2){
            return cp1[0]-cp2[0];//ascending order
           // return cp2[0]-cp1[0];//descending order
        }
    }









    static double mhr=0;
    public static void recursion(int n){
        if(n==1){
            return ;
        }
      //   else if(p1==1 && p2==2){
      //       return 2;
      //   }else if(p1==2 && p2==1){
      //       return 2;
      //   }
        
        mhr+=0.5;
        if(n%2==1){
            n=n/2+1;
        }else{
            n=n/2;
        }
        recursion(n);
    }


    public static int minflip(String str){
        int ct0=0;
        int ct1=0;
         if(str.charAt(0)=='1'){
             ct1++;
         }else{ct0++;}
    
        for(int i=1;i<str.length();i++){
            if(str.charAt(i-1)!=str.charAt(i)){
                if(str.charAt(i)=='1'){
                    ct1++;
                }else{
                    ct0++;
                }
            }
        }
        int ans=Math.min(ct1, ct0);
        return ans;
    }
    
	public static void main (String[] args) {
        Scanner scn=new Scanner(System.in);
		// int t=scn.nextInt();
		System.out.println(minflip("000110000111000111001010100"));
		// for(int r=0;r<t;r++){
        //  String str=scn.next();

        //  boolean[] visited=new boolean[26];
        //  int ct=0;
        //  for(int i=0;i<str.length();i++){
        //      if(visited[str.charAt(i)-'a']==false){
        //          ct++;  
        //          visited[str.charAt(i)-'a']=true;
        //     }else{
        //         ct--;
        //         visited[str.charAt(i)-'a']=false; 
        //     }
        //  }


        //  if(ct>0 && str.length()%2==0){
        //     System.out.println(-1);
        //  }else if(ct>1 && str.length()%2==1){
        //     System.out.println(-1);
        // }else{
        //     HashMap<Character,ArrayList<Integer>> hm=new HashMap<>();
        //     // int single=-1; 
        //     int len=str.length();
        //     for(int i=0;i<str.length();i++){
        //         char key=str.charAt(i);
        //         if(hm.containsKey(key)){
        //             ArrayList<Integer> list=hm.get(key);
        //             list.add(i); 
        //             // if(list.size()%2==1){single=i;}
        //             hm.put(key, list);
        //         }else{
        //             ArrayList<Integer> list=new ArrayList<>();
        //             list.add(i);
        //             // if(list.size()%2==1){single=i;}
        //             hm.put(key,list);
        //         }
        //     }
        //     String perm=" ";//take space initially
        //     if((len%2)==0){  //even length
        //       for(char key:hm.keySet()){
        //           ArrayList<Integer> list=hm.get(key);
        //           int sz=list.size();
        //           int j=0;
        //           while(j<sz){
        //             // if(perm=="")perm=" "+list.get(j)+" "+list.get(j+1)+" ";
        //             // else 
        //             perm=" "+list.get(j)+perm+list.get(j+1)+" ";
                      
        //             j+=2;
        //           }
        //       }
        //       String[] arr=perm.split(" ");
        //     for(int i=0;i<arr.length;i++){
        //         System.out.print(arr[i]+" ");
        //     }
        //     }else{      //odd length
        //         String sgl="";
        //         for(char key:hm.keySet()){
        //             ArrayList<Integer> list=hm.get(key);
        //             int sz=list.size();  int j=0;
                  
        //             if(sz%2==0){
        //             while(j<sz){
        //                 // if(perm=="")perm=" "+list.get(j)+" "+list.get(j+1)+" ";
        //                 // else 
        //                 perm=" "+list.get(j)+perm+list.get(j+1)+" ";
                        
        //                 j+=2;
        //             }
        //           }else{
        //             while(j<(sz-1)){
        //                 // if(perm=="")perm=" "+list.get(j)+" "+list.get(j+1)+" ";
        //                 // else 
        //                 perm=" "+list.get(j)+perm+list.get(j+1)+" ";
                        
        //                 j+=2;
        //               }
        //             //   int end=perm.length()/2;
        //               sgl=list.get(list.size()-1)+"";
        //             //   perm=perm.substring(0,end)+list.get(list.size()-1)+perm.substring(end); 
        //           }
        //         }
        //         perm.trim();
        //         String[] arr=perm.split(" ");
        //         for(int i=0;i<arr.length;i++){
        //             if(i==(arr.length/2)){
        //                 System.out.print(sgl+" ");
        //                 System.out.print(arr[i]+" ");
        //             }else{
        //                 System.out.print(arr[i]+" ");
        //             }
        //         }
                
        //     }
        //   }
        // }
		//     int n=scn.nextInt();
		//     int[] arr=new int[n];
		    
		//     for(int j=0;j<n;j++){
		//         arr[j]=scn.nextInt();
		//     }
		    
		//     Arrays.sort(arr,new Comparator<Integer>(){
		//       //  @Override
		//         public int compare(Integer a1,Integer a2){
		//             Integer b1=Integer.bitCount(a1);
		//             Integer b2=Integer.bitCount(a2);
		//             return b1-b2;
		//         }
		//         });
		//         for(int j=0;j<n;j++){
		//             System.out.print(arr[j]+" ");
		//         }
		//     System.out.println();      
		// }


    // Scanner scn=new Scanner(System.in);
    // int n=scn.nextInt();
    // int[] arr=new int[n];
    // for(int i=0;i<n;i++){
    //     arr[i]=scn.nextInt();
    // }
    // int x=scn.nextInt();
    // int lo=0,hi=n;

    // while(lo<=hi){
    //     int mid=(lo+hi)/2;
        
    //     if(arr[mid]==x){
    //         System.out.println("floor="+arr[mid]+"  ceil="+arr[mid]);
    //         break;
    //     }
    //     if(lo==hi){
    //         System.out.println("floor="+arr[lo-1]+"  ceil="+arr[lo]);
    //         break;
    //     }

    //     if(x<arr[mid]){
    //         hi=mid-1;
    //     }else if(x>arr[mid]){
    //         lo=mid+1;
    //     }
    // }



        // Scanner scn=new Scanner(System.in);
        // int n=scn.nextInt();
        // int x=scn.nextInt();
        // int mhr=0;
        // while(n>1){
        //     mhr++;
        //     n=n/2;
        // }
        //  int p1=0;
        //  int p2=0;  
        //  double minhr=0; 
        // if(n%2==0){
        //     n=n/2;  mhr=0.5;
        // }else{
        //     n=n/2+1; mhr=0.5;
        // }
        
        // double minhr=(double)(p1*p1)/2;
        // System.out.println(minhr);
        // recursion(n);
        // if(mhr<=x){
        //     System.out.println("1");
        // }else{
        //     System.out.println("0");
        // }



		//code
        // ArrayList<int[]> list2=new ArrayList<>();
        // list2.add(new int[]{1,2});
        // list2.add(new int[]{1,5});
        // list2.add(new int[]{1,4});
        // list2.add(new int[]{1,3});

        // int[] arr1={1,7,11};
        // int[] arr2={2,4,6};

        // for(int i=0;i<arr1.length;i++){
        //     for(int j=0;j<arr2.length;j++){
        //         list2.add(new int[]{arr1[i],arr2[j]});
        //     }
        // }


        // Collections.sort(list2,new Comparator<int[]>(){
        //     public int compare(int[] arr1,int[] arr2){
        //         int val1=arr1[0]+arr1[1];
        //         int val2=arr2[0]+arr2[1];
        //         return val1-val2;
        //     }
        // });
        
        // for(int i=0;i<3;i++){
        //     System.out.println("["+list2.get(i)[0]+" "+list2.get(i)[1]+"]");
        // }

        // Scanner scn=new Scanner(System.in);
		// int t=scn.nextInt();
		
		// for(int r=0;r<t;r++){
		//     int n=scn.nextInt();
		//     int[][] intervals=new int[n][2];
		//     for(int i=0;i<n;i++){
		//         intervals[i][0]=scn.nextInt();
		//         intervals[i][1]=scn.nextInt();
		//     }
        //     Arrays.sort(intervals,new arrComparator());

        //     ArrayList<int[]> list=new ArrayList<>();
        //     int[] newinterval=intervals[0];
        //     list.add(newinterval);

        //     for(int[] interval:interval){
        //         if(interval[0]<=newinterval[1]){
        //             newinterval[1]=Math.max(newinterval[1],interval[1]);
        //         }else{
        //             newinterval=interval;
        //             list.add(newinterval);
        //         }
        //     }
        //     int[][] narr=list.toArray();

        //     for(int i=0;i<n;i++){
        //         System.out.println(intervals[i][0]+"  "+intervals[i][1]);
        //     }
		// }
	}
}