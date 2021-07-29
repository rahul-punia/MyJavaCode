import java.util.*;

public class Trie{
     static class Node{      //Node have three property
        char data;
        HashMap<Character,Node> children;  //Right bcz parent is one 
        boolean eow;  //end of word
        Node(char data){
            this.data=data;
            this.children=new HashMap<>();
            this.eow=false;
        }
    }
    public static void add(Node node,String word){
        if(word.length()==0){
            node.eow=true;
            return ;
        }
        char ch=word.charAt(0);
        String row=word.substring(1);
        Node child=node.children.get(ch);  //ch-key & child-value(address of next character)
        if(child==null){        //if child not present then add child
            child=new Node(ch);
            node.children.put(ch,child);
            add(child, row);
        }else{
            add(child, row);
        }
        
    }
    public static boolean search(Node node,String word){
       if(word.length()==0){
           return node.eow;
       }
       
       char ch=word.charAt(0);
       String row=word.substring(1); //rest of word
       Node child=node.children.get(ch);
       if(child==null){
         return false;
       }else{
         return search(child,row);
       }
    }
    //V.Important
    public static void remove(Node node,String word){
        if(word.length()==0){
            node.eow=false;
            return;
        }
        char ch=word.charAt(0);
        String row=word.substring(1);
        Node child=node.children.get(ch);

      if(child==null){
          return;
      }else{
          remove(child, row);               //remove in post order
          if(child.eow==false && child.children.size()==0){       //Removing character is not end part character 
                                        //of other word && also removing character is not a mid part of other word
              node.children.remove(ch);  //remove key from above node of below Node(child).
          }
      }
    }
    public static void display(Node node){
        String str=node.data+"->";
        ArrayList<Character> keys=new ArrayList<>(node.children.keySet()); // use to run loop
       for(Character key:keys){
           Node child=node.children.get(key);
           str+=child.data+(child.eow==true?"*":"")+",";
       }
       str+=".";
       System.out.println(str);
       for(Character key:keys){
        Node child=node.children.get(key);
        display(child);
       }
    }
    public static void displayAllwords(Node node,String wsf){
        if(node.eow==true){
        System.out.println(wsf);      //No need to write return;
        }
       ArrayList<Character> keys=new ArrayList<>(node.children.keySet());
       for(Character key:keys){
           Node child=node.children.get(key);
           displayAllwords(child,wsf+key);
       }
    }
    static int[] getlps(String pat){ //Pi table
        int i=1;
        int j=0;
        
        int[]lps=new int[pat.length()];
        lps[0]=0;
        while(i<pat.length()){
            if(pat.charAt(i)==pat.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else if(j==0){      //eg-aaaay
                    lps[i]=0;
                    i++;
            }else{
                j=lps[j-1];
                }
        }
        return lps;
    }

    
    static void KMP(String src,String pat){
        int[] lps=getlps(pat);         //longest proper suffix
        int i=0;       //traverse on source
        int j=0;      //traverse on  pattern
        while(i<src.length()){
            if(src.charAt(i)==pat.charAt(j)){
                i++;
                j++;
                if(j==pat.length()){
                    System.out.println("Found at "+(i-pat.length()));
                    j=lps[j-1];     //not j=0;(test case)(String src="abhnramramramnkcjjcnramramramjcrahulnjenrahulwramramramccccrahec";
                }                               //String pat="ramram";)
            }else if(j>0){
                 j=lps[j-1];
            }else{               //if(j==0)
                 i++;
               }
            
        }
    }

  
    public static void main(String[] args){
        Node root=new Node('$');
        add(root, "are");
        add(root, "art");
        add(root, "an");
        add(root, "and");
        add(root, "ant");
        add(root, "as");
        add(root, "ask");
        add(root, "see");
        add(root, "sea");
        add(root, "seen");
        System.out.println(search(root,"art"));
        // remove(root, "seen");
        display(root);
        System.out.println("------------");
        // displayAllwords(root, "");
        // remove(root, "art");
        // System.out.println("------------");
        // display(root);
        // System.out.println("------------");
        // displayAllwords(root, "");
        // String src="abhnramramramnkcjjcnramramramjcrahulnjenrahulwramramramccccrahec";
        // String pat="ramram";         
        // KMP2(src, pat);

    }
}