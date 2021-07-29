import java.util.*;
import java.lang.*;
import java.io.*;

public class template {

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

public static void main(String[] args) throws Exception{
    InputStreamReader ip=new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ip);
    int t= Integer.parseInt(br.readLine());
    
    while(t-->0){
    //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
        // String[] strs=(br.readLine()).trim().split(" ");
        // int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

        // strs=(br.readLine()).trim().split(" ");
            // segementTree();
            myTrie();
    }
}

  //***********************************************Algebra-Fundamentals ********************************** */  
    public static long gcd(long a,long b){
        if(b==0)return a;
        else return gcd(b, a%b);
    }

    public static long binexp(long a,long n){
        if(n==0)return 1;

        long res=binexp(a, n/2);

        if(n%2==1){
            return res*res*a;
        }else{
            return res*res;
        }
    }
    static int[] spf;
    public static void primefactorize(int n){
        spf=new int[n+1];

        for(int i=1;i<=n;i++){
            spf[i]=i;
        }

        for(int i=4;i<=n;i+=2){
            spf[i]=2;
        }

        for(int i=3;i<=n;i++){

            if(spf[i]==i){
                long pd=(long)(i)*(long)(i);
                if(pd>(long)(n)){continue;}

                for(long j=i*i;j<=(long)n && j>=0;j+=i){
                    if(spf[(int)j]==(int)j){  spf[(int)j]=(int)i; }
                }
            }
        }

    }


//********************************Data Structure-Segment Tree ********************************************** */  
//For Explaination-https://cp-algorithms.com/data_structures/segment_tree.html
//The procedure for constructing the Segment Tree from a given array a[] looks like this: it is a recursive 
//function with the parameters a[] (the input array), v (the index of the current vertex), 
//and the boundaries tl and tr of the current segment. 
//In the main program this function will be called with the parameters of the root vertex: v=1, tl=0, and tr=n−1.
   
//SegmentTree Queries Important
//Finding range sum,max,min
//Update=->we want to modify a specific element in the array, let's say we want to do the assignment a[i]=x. And we have to rebuild the Segment Tree, such that it correspond to the new, modified array
//Finding the maximum,minimum and the number of times it appears
//Compute the greatest common divisor / least common multiple
//Counting the number of zeros, searching for the k-th zero
//Searching for an array prefix with a given amount
//Searching for the first element greater than a given amount
    static int[] t;//t->tree
    public static void build(int a[], int v, int tl, int tr) {//tl-treeLeft
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(a, v*2, tl, tm);
            build(a, v*2+1, tm+1, tr);
            t[v] = t[v*2] + t[v*2+1];
        }
    }

    public static int sum(int v, int tl, int tr, int l, int r) {
        if (l > r) 
            return 0;
        if (l == tl && r == tr) {  //System.out.println(tl+" "+tr);
            return t[v];
        }
        int tm = (tl + tr) / 2;   //mymistake  tm=(l + r) / 2; 
        return sum(v*2, tl, tm, l, Math.min(r, tm)) + sum(v*2+1, tm+1, tr, Math.max(l, tm+1), r);
    }                          //Here we divide query range only     

    public static void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            t[v] = new_val;
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v*2, tl, tm, pos, new_val);
            else
                update(v*2+1, tm+1, tr, pos, new_val);
            t[v] = t[v*2] + t[v*2+1];
        }
    }
    //For More complex queries
    static class pair{
        int first,second;
        pair(int first,int second){
            this.first=first;  this.second=second;
        }
    }

    static pair[]st; 
    //only combine function changes According to queries like sum,max,min,LCM/GCD,count of zeroes etc
    public static pair combine(pair a, pair b) {//combineForMax
        if (a.first > b.first) 
            return a;
        if (b.first > a.first)
            return b;
        return new pair(a.first, a.second + b.second);
    }

    public static pair combineForMin(pair a, pair b) {
        if (a.first < b.first) 
            return a;
        if (b.first > a.first)
            return b;
        return new pair(a.first, a.second + b.second);
    }

    public static void buildForMax(int a[], int v, int tl, int tr) {
        if (tl == tr) {
            st[v] = new pair(a[tl], 1);
        } else {
            int tm = (tl + tr) / 2;
            buildForMax(a, v*2, tl, tm);
            buildForMax(a, v*2+1, tm+1, tr);
            st[v] = combine(st[v*2], st[v*2+1]); //Imp
        }
    }

    public static pair get_max(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return new pair(Integer.MIN_VALUE, 0);
        if (l == tl && r == tr)
            return st[v];
        int tm = (tl + tr) / 2;
        return combine(get_max(v*2, tl, tm, l, Math.min(r, tm)), 
                       get_max(v*2+1, tm+1, tr, Math.max(l, tm+1), r));
    }
    
    public static void updateForMax(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr) {
            st[v] = new pair(new_val, 1);
        } else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                updateForMax(v*2, tl, tm, pos, new_val);
            else
             updateForMax(v*2+1, tm+1, tr, pos, new_val);
            st[v] = combine(st[v*2], st[v*2+1]);
        }
    }

    //Important-  Range updates (Lazy Propagation)
    //Queries
    //1.Addition on segments(See Code at CP Algorithms)
    //2.Assignment on segments
    //3.Adding on segments, querying for maximum(See Code at CP Algorithms)
    //Practice Problems
    static boolean[] marked;
    static int[] lt;
    
    public static void pushOfLazy(int v) {
        if (marked[v]) {
            lt[v*2] = lt[v*2+1] = lt[v];
            marked[v*2] = marked[v*2+1] = true;
            marked[v] = false;
        }
    }

    public static void buildOfLazy(int a[], int v, int tl, int tr) {
        if (tl == tr) {
            lt[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(a, v*2, tl, tm);
            build(a, v*2+1, tm+1, tr);
            lt[v] = 0;
        }
    }

    public static void updateOfLazy(int v, int tl, int tr, int l, int r, int new_val) {
        if (l > r) 
            return;
        if (l == tl && tr == r) {
            lt[v] = new_val;
            marked[v] = true;
        } else {
            pushOfLazy(v);
            int tm = (tl + tr) / 2;
            updateOfLazy(v*2, tl, tm, l, Math.min(r, tm), new_val);
            updateOfLazy(v*2+1, tm+1, tr, Math.max(l, tm+1), r, new_val);
        }
    }

    public static int getOfLazy(int v, int tl, int tr, int pos) {
        if (tl == tr) {
            return lt[v];
        }
        pushOfLazy(v);
        int tm = (tl + tr) / 2;
        if (pos <= tm) 
            return getOfLazy(v*2, tl, tm, pos);
        else
            return getOfLazy(v*2+1, tm+1, tr, pos);
    }

    public static void segementTree(){
            int[] arr={1,3,-2,8,-7};  ////0 base indexing
            int n=arr.length;  int MAXN=n;
            t=new int[4*MAXN];  //1 base indexing  //1 and 0 base indexing is used in every implementation
            
            build(arr, 1, 0, n-1);
            //sumQuery
            int sum=sum(1, 0, n-1, 2, 4);
            System.out.println(sum);
            //updateQuery
            update(1, 0, n-1, 2, 15);
            //sumQuery
            sum=sum(1, 0, n-1, 2, 4);
            System.out.println(sum);

            //For ComplexQueries
            st=new pair[4*MAXN];
            buildForMax(arr, 1, 0, n-1);
            //Finding the maximum and the number of times it appears
            //Similarly we can do for minimum only combine function changes
            pair maxpr=get_max(1, 0, n-1, 1, 4);
            System.out.println("Max Val="+maxpr.first+"    No of times occur="+maxpr.second);
            //update
            updateForMax(1, 0, n-1, 2, 8);
            //maxQ
            maxpr=get_max(1, 0, n-1, 1, 4);
            System.out.println("Max Val="+maxpr.first+"    No of times occur="+maxpr.second);


            //lazy propogation
            lt=new int[n];
            marked=new boolean[n+1];
            
    }

 //******************************** Data Structure-Disjoint Set Union ********************************************** */     
 //Link- https://cp-algorithms.com/data_structures/disjoint_set_union.html
//  Build an efficient data structure
//  Naive implementation
//  Path compression optimization
//  Union by size / rank
//  Time complexity
// Applications

static int[] parent;

public static void make_set(int v) {
    parent[v] = v;
}

public static int find_set(int v){
    if(parent[v]==v)return v;
    else return find_set(parent[v]);
}

public static void union_sets(int a,int b){
    int la=find_set(a);
    int lb=find_set(b);
    if(la!=lb){
        parent[lb]=la;
    }
}

//However this implementation is inefficient. It is easy to construct an example, so that the trees degenerate into long chains. In that case each call find_set(v) can take O(n) time.
//This is far away from the complexity that we want to have (nearly constant time). Therefore we will consider two optimizations that will allow to significantly accelerate the work.

public static int find_sets_optimize(int v) {
    if (v == parent[v])
        return v;
    return parent[v] = find_set(parent[v]);
}

//The simple implementation does what was intended: first find the representative of the set (root vertex), and then in the process of stack unwinding the visited nodes are attached directly to the representative.

//Union by size / rank
static int[] size;
public static void make_set_optimize(int v) {
    parent[v] = v;
    size[v] = 1;
}

public static void union_sets_optimize(int a,int b){
    int la=find_set(a);
    int lb=find_set(b);

    if(size[la]<size[lb]){int tmp=la; la=lb;  lb=tmp;}
    if(la!=lb){
        parent[lb]=la;
        size[la]+=size[lb];
    }
}

//Time Complexity
//As mentioned before, if we combine both optimizations - path compression with union by size / rank - 
//we will reach nearly constant time queries. It turns out, that the final amortized time complexity is O(α(n)), 
//where α(n) is the inverse Ackermann function, which grows very slowly. In fact it grows so slowly, that it doesn't exceed 4 for all reasonable n (approximately n<10600).

//Applications of DSU
//Connected components in a graph
//This application is quite important, because nearly the same problem appears in Kruskal's algorithm for finding a minimum spanning tree. Using DSU we can improve the O(mlogn+n2) complexity to O(mlogn).



//******************************** Data Structure-Trie  ********************************************** */     
//Trie is used for String Searching in O(m) instead of O(m*n).

static class Node{   //Trie Node Structure Important
    char data;
    int terminating; //eow
    HashMap<Character,Node> Children;
    Node(char data){
        this.data=data; this.terminating=0; this.Children=new HashMap<>(); 
    }
}

public static void addOfTrie(Node root,String str){
    if(str.length()==0){
        root.terminating+=1;
        return;
    }
    char ch=str.charAt(0);
    String ros=str.substring(1);

    Node child=root.Children.get(ch);
    if(child==null){
        child=new Node(ch);
        root.Children.put(ch,child);
        addOfTrie(child,ros);
    }else{
        addOfTrie(child, ros);
    }
}

public static void deleteOfTrie(Node root,String str){
    if(str.length()==0){
        root.terminating-=1;
        return ;
    }

    char ch=str.charAt(0);
    String ros=str.substring(1);
    Node child=root.Children.get(ch);
    
    if(child==null)return;
    else{
        deleteOfTrie(child, ros);
    if(child.terminating==0 && child.Children.size()==0){
            root.Children.remove(ch);
    }
}
}

public static boolean searchInTrie(Node root,String str){
    if(str.length()==0){
        return root.terminating>0;
    }

    char ch=str.charAt(0);
    String ros=str.substring(1);
    Node child =root.Children.get(ch);

    if(child==null){
        return false;
    }else{
        return searchInTrie(child, ros);
    }
}

public static void displayOfTrie(Node root){
    if(root==null)return ;
    
    System.out.print(root.data+"->");
    for(char key:root.Children.keySet()){
        System.out.print(key);
        Node nroot=root.Children.get(key);
       if(nroot.terminating>0)System.out.print("*,");   
       else  System.out.print(","); 
    }
    System.out.println(".");
    
    for(char key:root.Children.keySet()){
        Node nroot=root.Children.get(key);
        displayOfTrie(nroot);
    }
}

public static void myTrie(){
    Node root=new Node('$');
    addOfTrie(root, "are");
    addOfTrie(root, "art");
    addOfTrie(root, "an");
    addOfTrie(root, "and");
    addOfTrie(root, "ant");
    addOfTrie(root, "as");
    addOfTrie(root, "ask");
    addOfTrie(root, "see");
    addOfTrie(root, "sea");
    addOfTrie(root, "seen");
    displayOfTrie(root);
    // System.out.println(search(root, "seena"));
    // delete(root, "seen");
    // display(root);    
}



//******************************** String Processing  ********************************************** */    

    
}
