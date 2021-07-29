import java.util.*;

public class cf698 {
    //Note-we prefer using LinkedList where multiple inserts are required.
//On the other hand, LinkedList simply adds that value at the tail of the underlying DoublyLinkedList.
//Both have time complexity O(1), but due to the added steps of creating a new array in ArrayList its 
//worst-case complexity reaches to order of N, that is why we prefer using LinkedList where multiple 
//inserts are required.
    public static boolean islucky(int num,int d){
        while(num>0){
            int cd=num%10;
            if(cd==d)return true;
            num=num/10;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        long t=scn.nextLong();

       
        // String str=scn.next();
        while(t-->0){
            long q=scn.nextLong();
            int d=scn.nextInt();

            LinkedList<Integer> poss=new LinkedList<>();
            long[] dp=new long[201];
            dp[0]=1;
            for(int i=1;i<=200;i++){
                if(islucky(i, d)){dp[i]=1; poss.add(i);}
            }
            for(int i=1;i<=200;i++){
                for(int j:poss){
                    if(i-j>=0 && dp[i-j]==1){dp[i]=1; break;}
                }
            }  
          
            while(q-->0){
                int num=scn.nextInt();
                if(num>=200){System.out.println("YES"); continue;}
                if(islucky(num, d)){System.out.println("YES"); continue;}
                
                if(dp[num]==1){System.out.println("YES");}
                else{System.out.println("NO");}
            }
            
        }
    }
}



//Ques-2

// bool ok(int j, int d)
// {
// 	while(j)
// 	{
// 		if(j % 10 == d)
// 			return 1;
// 		j /= 10;
// 	}
// 	return 0;
// }
// void test_case()
// { 
// 	int d;
// 	cin >> n >> d;
// 	for(int i = 1; i <= n; i++)
// 	{
// 		cin >> m;
// 		if(m >= 200)
// 		{
// 			cout << "YES\n";
// 			continue;
// 		}
 
// 		vi poss;
// 		for(int j = 1; j <= m; j++)
// 		{
// 			if(ok(j, d))
// 				poss.pb(j);
// 		}
 
// 		vi dp(m + 1, 0);
// 		dp[0] = 1;
 
// 		for(int i = 1; i <= m; i++)
// 		{
// 			for(int j : poss)
// 			{
// 				if(i - j >= 0 and dp[i - j] == 1)
// 				{
// 					dp[i] = 1;
// 					break;
// 				}
// 			}
// 		}
 
// 		cout << (dp[m] ? "YES" : "NO") << '\n';
// 	}
// }






//********************************************************* */

//     void test_case()
// { 
// 	cin >> n;
// 	map<int,int> m;
 
// 	for(int i = 1; i <= 2 * n; i++)
// 		cin >> a[i], m[a[i]]++;
 
// 	vi v;
 
// 	for(auto it : m)
// 	{
// 		if(it.ss % 2 == 1)
// 		{
// 			cout << "NO\n";
// 			return;
// 		}
 
// 		for(int i = 0; i < (it.ss) / 2; i++)
// 			v.pb(it.ff);
// 	}
 
// 	sort(all(v));
// 	reverse(all(v));
 
// 	int pre = 0;
 
// 	vi ans;
// 	int cnt = 2 * n;
 
// 	for(int i = 0; i < sz(v); i++)
// 	{
// 		int sum = v[i];
// 		sum -= pre;
 
// 		if(sum % cnt != 0 or sum < 0)
// 		{
// 			cout << "NO\n";
// 			return;
// 		}
// 		else
// 		{
// 			ans.pb(sum / cnt);
// 		}
 
// 		cnt -= 2;
// 		pre += 2 * ans.back();
// 	}
 
// 	set<int> s;
// 	for(int i : ans)
// 		s.insert(i), s.insert(-i);
 
// 	if(sz(s) != 2 * n)
// 	{
// 		cout << "NO\n";
// 		return;
// 	}
// 	// cout << '\n';
// 	cout << "YES\n";
// }
    // public static void main(String[] args) {
    //     Scanner scn=new Scanner(System.in);
    //     int t=scn.nextInt();
    //     // String str=scn.next();
    //     while(t-->0){
    //         double n=scn.nextDouble();
    //         // long[] arr=new long[2*n];
    //         HashMap<Double,Double> hm=new HashMap<>();
    //         HashMap<Double,Double> hm1=new HashMap();
    //         double div=2*n;
    //         int ans=1;
    //         double zero=0;
                
    //         for(long i=0;i<(2*n);i++){
    //             double di=scn.nextDouble();
    //             hm1.put(di,hm1.getOrDefault(di,zero)+1);
                
    //             double ai=((di*1.0)/(div));
    //             double freq=hm.getOrDefault(ai,zero)+1.0;
    //             hm.put(ai,freq);
    //         }

    //         // ArrayList<Double> list=new ArrayList<>();

    //         for(double ai:hm.keySet()){ //ai
    //             double freq=hm.get(ai);
    //             System.out.println(ai+" "+freq);
                
    //             if(freq%2==1){
    //                 ans=-1; break;
    //              }

    //             while(freq-->0){
    //                 // double di=(long)(div*key*1.0);
    //                 double di=0;
                    
    //                 for(double aj:hm.keySet()){
    //                     boolean even=true;
    //                     double fy=hm.get(aj);
    //                     while(fy-->0){
    //                         di+=Math.abs(ai-aj);
    //                         aj=-aj;
    //                     }  
    //                 }

    //                 double fq=hm1.getOrDefault(di,zero);
    //                 if(fq==0){ans=-1; 
    //                     System.out.println(ai+" "+freq+"  "+di+"    ");
    //                     //break;
    //                 }
    //                 hm1.put(di,fq-1); 
    //                 ai=-ai;
    //             }

    //           // if(ans==-1){break;}   
    //         }

    //         if(ans==-1){
    //             System.out.println("NO");
    //         }else{
    //             System.out.println("YES");
    //         }
    //         // System.out.println(ans);
    //     }
    // }
// }
