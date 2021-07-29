import java.util.*;
import java.lang.*;
import java.io.*;

//  HashMap<Integer,ArrayList<Integer>> hm=new HashMap<>();
// HashMap<Integer,Integer> hm=new HashMap<>();
// HashSet<Integer>     
public class cf606 {
    
    static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
    // static HashSet<String> hs=new HashSet<>();
    static ArrayList<String> list=new ArrayList<>();
    public static void dfs(StringBuilder sb,int s,boolean[] vst){
        String s1=sb.toString();
        String s2=(sb.reverse()).toString();
        System.out.println(s1+"   ");
        // if(!hs.contains(s1) && !hs.contains(s2)){
        //     hs.add(s1);
        // }
        // if(!list.contains(s1) && !list.contains(s2)){
        //         list.add(s1);
        // }
        if(sb.length()>1){
            boolean flag=true;
        for(String st:list){
            if(st.equals(s1) || st.equals(s2)){flag=false; break;}
        }
        if(flag){list.add(s1);}
        }
        
            
        for(int nbr:graph.get(s)){
            if(!vst[nbr]){
                vst[nbr]=true;
                sb.append(nbr);
                dfs(sb, nbr,vst);
                sb.delete(sb.length()-1,sb.length());
                // vst[nbr]=false;
            }
        }

        return;
    }
    public static void main(String[] args) throws Exception{
        InputStreamReader ip=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ip);
        // Scanner scn=new Scanner(System.in);
        int t = Integer.parseInt(br.readLine());
       
       while(t-->0){
        int n =Integer.parseInt(br.readLine());
        
        //  int[] arr=new int[n];
        // HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<=n;i++){graph.add(new ArrayList<>());}

        for(int i=0;i<n;i++){
            String[] strs=(br.readLine()).trim().split(" ");
            int u=Integer.parseInt(strs[0]);
             int v=Integer.parseInt(strs[1]);
            (graph.get(u)).add(v);     (graph.get(v)).add(u);
        }
            
         for(int i=1;i<=n;i++){
            boolean[] vst=new boolean[n+1];
            StringBuilder sb=new StringBuilder();
            sb.append(i);
            vst[i]=true;
            dfs(sb,i, vst);
            vst[i]=false;
         }
         
         System.out.println("rr  "+list.size());
       }
    }
     
}
