// #include <bits/stdc++.h>
// using namespace std;
// #define ll long long
// #define iton for(int i=0;i<n;i++)
// #define jtom for(int j=0;j<m;j++)
// #define itok for(int i=0;i<k;i++)

// void solve()
// {
//     ll n;
//     cin>>n;
//     unordered_map<int,vector<int>> map;
//     vector<int> v(n+1,0); 
//     int arr1[n],arr2[n];
    
//     iton 
//     {
//         cin>>arr1[i];
//         map[arr1[i]].push_back(i);
//     }
//     iton 
//     {
//         cin>>arr2[i];
//         if(map.find(arr2[i])!=map.end())
//         {
//             for(auto j=0;j<map[arr2[i]].size();j++)
//             {
//                 int kk= map[arr2[i]][j] -i;
//                 if(map[arr2[i]][j] - i < 0 )
//                 kk= kk+n;
//                 v[kk]++;
//             }
//         }
//     }
//     int  maxx = INT_MIN;
//     for(int i=0;i<=n;i++)
//     {   
//         maxx= max(v[i],maxx);
//     }
//     cout<<maxx;
// }
// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);
//     cout.tie(NULL);
    
//         solve();
// }