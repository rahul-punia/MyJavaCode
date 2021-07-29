import java.util.*;
import java.lang.*;
import java.io.*;



public class cf674 {
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t= Integer.parseInt(br.readLine());

        while(t-->0){
            String[] strs=(br.readLine()).trim().split(" ");
            int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);

            int[][] arr=new int[(2*n)][2];
            for(int i=0;i<2*n;i++){
                strs=(br.readLine()).trim().split(" ");
                arr[i][0]=Integer.parseInt(strs[0]);
                arr[i][1]=Integer.parseInt(strs[1]);
            }

            if(m%2==1){
                System.out.println("NO");
            }else{
                boolean f=false;
                if(m==2){
                    for(int i=0;i<2*n;i+=2){
                        if(arr[i][1]==arr[i+1][0]){f=true; break;}
                    }
                }

                if(f || m>2){System.out.println("YES");}
                else{System.out.println("NO");}
            }
        }
    }






static  HashMap<Integer,HashSet<Integer>> gp=new HashMap<>();
   
public static void gcc(int s,HashSet<Integer> vst){

    for(int nbr:gp.getOrDefault(s, new HashSet<>())){
        if(vst.add(nbr)){
            gcc(nbr, vst);
        }
    }
}
// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     // Scanner scn=new Scanner(System.in);
//     // int t= Integer.parseInt(br.readLine());

//     // while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),m=Integer.parseInt(strs[1]);

//         boolean fg=false;
        
//         for(int i=0;i<m;i++){
//             strs=(br.readLine()).trim().split(" ");
//             int u=Integer.parseInt(strs[0]),v=Integer.parseInt(strs[1]);
//             // if(u==v){
//                 HashSet<Integer> hs=gp.getOrDefault((u+m), new HashSet<>());
//                 hs.add(i);  gp.put((u+m), hs);
//                 hs=gp.getOrDefault(i, new HashSet<>());
//                 hs.add((u+m));  gp.put(i, hs);
//                 if(hs.size()==m){fg=true;}    
//             // }
//             if((u+m)!=(v+m)){
//                 HashSet<Integer> hs2=gp.getOrDefault((v+m), new HashSet<>());
//                 hs2.add(i);  gp.put((v+m), hs2);
//                 if(hs2.size()==m){fg=true;}
//                 hs2=gp.getOrDefault(i, new HashSet<>());
//                 hs2.add((v+m));  gp.put(i, hs2);
//             }
//         }
   
//         if(fg){System.out.println("YES"); return;}

//         int ct=0;
//         HashSet<Integer> vst=new HashSet<>();
//         for(int key:gp.keySet()){
//             if(vst.add(key)){
//                 gcc(key,vst);
//                 ct++;
//             }
//         }

//         if(ct<=2){System.out.println("YES");}
//         else{System.out.println("NO");}

//     }
}