import java.util.*;
import java.lang.*;
import java.io.*;

public class Commontemplate {

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
            // myTrie();
            // kmp();

            convex_hull_main();
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

//1.Knuth-Morris-Pratt(kmp) algorithm

    public static int[] prefix_function(String str){
        int n=str.length();
        char[] s=str.toCharArray();
        int[] pi=new int[n];

        for(int i=1;i<n;i++){
            int j=pi[i-1];

            while(j>0 && s[i]!=s[j]){
                j=pi[j-1];
            }

            if(s[i]==s[j]){j++;}
            
            pi[i]=j;
        }
        return pi;
    }

    public static void kmp(){
        int[] pi=prefix_function("aabaaab");

        System.out.println(Arrays.toString(pi));
       //Arrays.toString() is a static method of the array class which belongs to the java.util package. It returns a string representation of the contents of the specified array. We can print one-dimensional arrays using this method. 
    }


//2.Z-Algorithm
    public static int[] zfunction(String str){
        char[] s=str.toCharArray();
        int n=str.length();
        int[] z=new int[n];
        int l=0,r=0;  
  
        for(int i=1;i<n;i++){
          if(i>r){
              l=i;r=i;
              while(r<n && s[r-l]==s[r]){r++;}
              z[i]=r-l; r--;
          }else{
              int k=i-l;
              if(z[i-l]<(r-i+1)){z[i]=z[k];} //imp remember //or  z[k]<(r-i+1)
              else{
                  l=i; 
                  while(r<n && s[r-l]==s[r]){r++;}
                  z[i]=r-l; r--;
              }
          }
        }
  
        return z;
    }



//******************************** Geometry Start ********************************************** */    

//1.Oriented area of a triangle
//2. Convex Hull
//3.Sweep Line
    static class pt{
        double x=0,y=0;
        pt(double x,double y){ this.x=x;  this.y=y; }
    }

    // static boolean cmp(pt a, pt b) {  //compare function for cpp
    //     return a.x < b.x || (a.x == b.x && a.y < b.y);
    // }

    // static boolean cw(pt a, pt b, pt c) {   //clockwise
    //     return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) < 0;
    // }

    // static boolean ccw(pt a, pt b, pt c) { //counter clockwise
    //     return a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y) > 0;
    // }

//Easy to Understand
// The algorithm first finds the leftmost and rightmost points A and B. In the event multiple such points exist, the lowest among the left (lowest Y-coordinate) is taken as A, and the highest among the right (highest Y-coordinate) is taken as B. Clearly, A and B must both belong to the convex hull as they are the farthest away and they cannot be contained by any line formed by a pair among the given points.
// Now, draw a line through AB. This divides all the other points into two sets, S1 and S2, where S1 contains all the points above the line connecting A and B, and S2 contains all the points below the line joining A and B. The points that lie on the line joining A and B may belong to either set. The points A and B belong to both sets. Now the algorithm constructs the upper set S1 and the lower set S2 and then combines them to obtain the answer.
// To get the upper set, we sort all points by the x-coordinate. For each point we check if either - the current point is the last point, (which we defined as B), or if the orientation between the line between A and the current point and the line between the current point and B is clockwise. In those cases the current point belongs to the upper set S1. Checking for clockwise or anticlockwise nature can be done by checking the orientation.
// If the given point belongs to the upper set, we check the angle made by the line connecting the second last point and the last point in the upper convex hull, with the line connecting the last point in the upper convex hull and the current point. If the angle is not clockwise, we remove the most recent point added to the upper convex hull as the current point will be able to contain the previous point once it is added to the convex hull.
// The same logic applies for the lower set S2. If either - the current point is B, or the orientation of the lines, formed by A and the current point and the current point and B, is counterclockwise - then it belongs to S2.
// If the given point belongs to the lower set, we act similarly as for a point on the upper set except we check for a counterclockwise orientation instead of a clockwise orientation. Thus, if the angle made by the line connecting the second last point and the last point in the lower convex hull, with the line connecting the last point in the lower convex hull and the current point is not counterclockwise, we remove the most recent point added to the lower convex hull as the current point will be able to contain the previous point once added to the hull.
    public static boolean cw(pt p,pt q,pt r){   //check IsClockwise
        double difference=((r.x-q.x)*(q.y-p.y))-((q.x-p.x)*(r.y-q.y));

        return difference>0;
    }
    public static boolean ccw(pt p,pt q,pt r){  //check IsAnticlockwise
        double difference=((r.x-q.x)*(q.y-p.y))-((q.x-p.x)*(r.y-q.y));

        return difference<0;
    }


    static void convex_hull(ArrayList<pt> a) {
        System.out.println("Convex Hull");
        if (a.size() == 1)
            return;
    
      //The algorithm first finds the leftmost and rightmost points A and B. In the event multiple such points 
      //exist, the lowest among the left (lowest Y-coordinate) is taken as A, and the highest among the right (highest Y-coordinate) is taken as B.       
        // sort(a.begin(), a.end(), &cmp);
        Collections.sort(a,new Comparator<pt>(){
            public int compare(pt a,pt b){
                if(a.x!=b.x)return (int)Math.ceil(a.x-b.x);
                return  (int)Math.ceil(a.y-b.y);
            }
        });

        pt p1 = a.get(0), p2 = a.get(a.size()-1);
        // vector<pt> up, down;
        ArrayList<pt> up=new ArrayList<>(),down=new ArrayList<>();

        up.add(p1);
        down.add(p1);
        for (int i = 1; i < (int)a.size(); i++) {
            if (i == a.size() - 1 || cw(p1, a.get(i), p2)) {  //Imp
                while (up.size() >= 2 && !cw(up.get(up.size()-2), up.get(up.size()-1), a.get(i))){
                    up.remove(up.size()-1);
                }
                    
                up.add(a.get(i));
            }
            if (i == a.size() - 1 || ccw(p1, a.get(i), p2)) {
                while(down.size() >= 2 && !ccw(down.get(down.size()-2), down.get(down.size()-1), a.get(i))){
                    down.remove(down.size()-1);
                }
                    
                down.add(a.get(i));
            }
        }
    
        a.clear();
    
        for (int i = 0; i < (int)up.size(); i++)
            a.add(up.get(i));
        for (int i = down.size() - 2; i > 0; i--)
            a.add(down.get(i));

       
        System.out.println("Convex Hull Coodinates-");
        
        for(pt xy:a){
            System.out.println(xy.x+"  "+xy.y);
        }

    }


    public static void convex_hull_main(){
        ArrayList<pt> pts=new ArrayList<>();
        
        //I/P-1
        // pts.add(new pt(0, 0));
        // pts.add(new pt(0, 2));
        // pts.add(new pt(1, 2));
        // pts.add(new pt(0, 4));
        // pts.add(new pt(3, 0));
        // pts.add(new pt(4, 0));
        // pts.add(new pt(5, 0));
        // pts.add(new pt(2, 1));
        
        //I/P-2
        //Point points[] = {{0, 3}, {1, 1}, {2, 2}, {4, 4},{0, 0}, {1, 2}, {3, 1}, {3, 3}};
        //O/P- (0, 3)  (4, 4)  (3,1)  (0,0) 
        
        pts.add(new pt(0,3));
        pts.add(new pt(1,1));
        pts.add(new pt(2,2));
        pts.add(new pt(4,4));
        pts.add(new pt(0,0));
        pts.add(new pt(1,2));
        pts.add(new pt(3,1));
        pts.add(new pt(3,3));
        convex_hull(pts);
    }
    

    //Note
    //Convex hull Java code Impl. possible hai
    //Not Possible-> V.V.V.difficult implementation Sweep-line Java code Impl. take  help from nitesh    //https://github.com/FernandoFong/ComputationalGeometry
                                                           //https://github.com/valenpe7/bentley-ottmann/tree/master/bentley-ottmann/src/bentley_ottmann 
    //Elementary operations Java code Impl. possible hai
    //Polygons Java code Impl. possible hai



    
}
