 import java.util.*;
 public class mytrie {
    static class Node{  //Node have three property
        char data;
        int terminating; //eow
        HashMap<Character,Node> Children;//Here 'Character' act as key to search that char node
        //in childrens HashMap that's why we are storing it at two places i.e as a key and as a data
        Node(char data){
            this.data=data; this.terminating=0; this.Children=new HashMap<>(); 
        }
    }

    public static void add(Node root,String str){
        if(str.length()==0){
            root.terminating+=1;
            return;
        }
        char ch=str.charAt(0);
        String ros=str.substring(1);

        Node child=root.Children.get(ch);
        if(child==null){  //if child not present then add child
            child=new Node(ch);
            root.Children.put(ch,child);
            add(child,ros);
        }else{
            add(child, ros);
        }
    }

    public static void delete(Node root,String str){
        if(str.length()==0){
            root.terminating-=1;
            return ;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);
        Node child=root.Children.get(ch);
        
        if(child==null)return;
        else{
        delete(child, ros);
        if(child.terminating==0 && child.Children.size()==0){//Removing character is not end part character 
            //of other word && also removing character is not a mid part of other word
                root.Children.remove(ch);//remove key from above node of below Node(child).
        }
    }
    }

    public static boolean search(Node root,String str){
        if(str.length()==0){
            return root.terminating>0;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);
        Node child =root.Children.get(ch);

        if(child==null){
            return false;
        }else{
            return search(child, ros);
        }
    }

    public static void display(Node root){
        if(root==null)return ;
        
        System.out.print(root.data+"->");
        for(char key:root.Children.keySet()){
            System.out.print(key);
            Node nroot=root.Children.get(key);
           if(nroot.terminating>0)System.out.println("*,");   
           else  System.out.println(","); 
        }
        System.out.println(".");
        
        for(char key:root.Children.keySet()){
            Node nroot=root.Children.get(key);
            display(nroot);
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
        display(root);
        // System.out.println(search(root, "seena"));
        // delete(root, "seen");
        // display(root);
    }
}
