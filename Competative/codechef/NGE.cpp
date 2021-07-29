#include<bits/stdc++.h>
using namespace std;
 
#define int long long
 
const int mxN=1e5+5;
int a[mxN];
int n;
int lft[mxN];
int rght[mxN];
 
int32_t main()
{
  ios_base::sync_with_stdio(0);
  cin.tie(0);
 
  int t;
  cin>>t;
 
  while(t--)
  {
    cin>>n;
 
    for(int i=1;i<=n;i++)
    {
      cin>>a[i];
    }
 
    set <int> ans;
 
    stack <int> s;
 
    for(int i=1;i<=n;i++)
    {
      while(s.size()>0 && s.top()<a[i])  //NGE on left
        s.pop();
 
      if(s.size()>0)
        lft[i]=s.top();
      else
        lft[i]=-1;
 
      s.push(a[i]);
    }
 
    while(s.size()>0)
      s.pop();
 
    for(int i=n;i>=1;i--)
    {
      while(s.size()>0 && s.top()<a[i])  //NGE on right  //v.imp to find NGE 
        s.pop();                        //v.sort code
 
      if(s.size()>0)
        rght[i]=s.top();
      else
        rght[i]=-1;
 
      s.push(a[i]);
    }
 
    for(int i=1;i<=n;i++){  //v.imp
      if(lft[i]!=-1)
        ans.insert(lft[i]-a[i]);
      if(rght[i]!=-1)
        ans.insert(rght[i]-a[i]);
    }
 
    cout<<ans.size()<<"\n";
  }
 
return 0;
}


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

//Template

// public static void main(String[] args) throws Exception{
//     InputStreamReader ip=new InputStreamReader(System.in);
//     BufferedReader br = new BufferedReader(ip);
//     int t= Integer.parseInt(br.readLine());

//     while(t-->0){
//     //    int n=Integer.parseInt(br.readLine());//Integer.parseInt(strs[0]);
//         String[] strs=(br.readLine()).trim().split(" ");
//         int n=Integer.parseInt(strs[0]),k=Integer.parseInt(strs[1]);//,k=Integer.parseInt(strs[2]);

//         // String str=(br.readLine()).trim();
        
//     }
// }
// }