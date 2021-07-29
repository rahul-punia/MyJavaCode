#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define ld long double

// question-  https://codeforces.com/problemset/problem/471/D

int main(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
	#endif
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	int n,w;
	cin>>n>>w;
	int a[n],b[w];
	for(int i=0;i<n;i++){
		cin>>a[i];
	}
	for(int i=0;i<w;i++){
		cin>>b[i];
	}
	int c[n-1],d[w-1];
	for(int i=0;i<n-1;i++){
		c[i]=a[i+1]-a[i];
	}
	for(int i=0;i<w-1;i++){
		d[i]=b[i+1]-b[i];
	}
	if(w==1){
		cout<<n; return 0;
	}
	int lps[w-1]={0};
	for(int i=1;i<w-1;i++){
		int k=lps[i-1];
		while(true){
			if(d[i]==d[k]){
				lps[i]=k+1; break;
			}
			if(k==0) break;
			k=lps[k-1];
		}
	}
	int ans=0;
	int j=0;
	for(int i=0;i<n-1;i++){
		if(j==w-1){
			j=lps[j-1]; ans++;
		}
		if(c[i]==d[j]){
			j++; continue;
		}
		if(j==0) continue;
		j=lps[j-1];
		i--;
	}
	cout<<ans+(j==w-1);
}