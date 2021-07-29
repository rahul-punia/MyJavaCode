#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define ld long double
const int nax=1e5+5;
int Next[nax][26];
int lps[nax]={0};

//Let's denote the string obtained by concatenation t + # + s (where # is some dividing character that isn't a part of the alphabet) as ts. 
//Recall that KMP algorithm builds the prefix function for this string.

// We can calculate dp[i][j] on this string, where i is the position in this string and j is the value of prefix function in this position. 
// The value of dp[i][j] is the maximum number of occurences of t found so far (or  - 1 if this situation is impossible). If (i + 1)th character
//  is a Latin letter, then we just recalculate prefix function for this position (the fact that in KMP the value of 
//  prefix function won't exceed |t| allows us to do so). If (i + 1)th character is a question mark, then we check all 26 possible characters and recalculate prefix function for all of these characters (and update the corresponding dp values). The size of s and t is pretty big, so we need to recalculate these values in O(1) time; this can be done by precalculating the values of next[i][j] (i is the value of prefix function, j is a new character and next[i][j] is the value of prefix function after adding this character).

int main(){
	#ifndef ONLINE_JUDGE
    freopen("input.txt","r",stdin);
    freopen("output.txt","w",stdout);
	#endif
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	string s,t;  //s->text, t-> pattern
	cin>>s>>t;
	int n1=t.size();
	int n2=s.size();

	for(int i=1;i<n1;i++){
		int j=lps[i-1];
		while(true){
			if(t[i]==t[j]){
				lps[i]=j+1; break;
			}
			if(j==0) break;
			j=lps[j-1];
		}
	}

	t+='#';

	for(int j=0;j<26;j++){
		Next[0][j]=0;
	}
	Next[0][t[0]-'a']=1;

	for(int i=1;i<=n1;i++){
		for(int j=0;j<26;j++){
			 if(t[i]==j+'a'){
			 	Next[i][j]=i+1;
			 }
			 else{
			 	Next[i][j]=Next[lps[i-1]][j];	
			 }
		}
	}

	int dp[n2][n1+1];
	for(int i=0;i<n2;i++){//patt
		for(int j=0;j<=n1;j++){//text
			dp[i][j]=-1;
		}
	}

	if(s[0]!='?'){
		if(s[0]==t[0]){
			dp[0][1]=0;
			if(n1==1) dp[0][1]++;
		}else{
			dp[0][0]=0;
		}
	}else{
		dp[0][0]=0;
		dp[0][1]=0;
		if(n1==1) dp[0][1]++;
	}
	for(int i=1;i<n2;i++){
		int st=0, end=25;
		if(s[i]!='?'){
			st=s[i]-'a'; end=st;
		}
		for(int j=st;j<=end;j++){
			for(int k=0;k<=n1;k++){
				int precount=dp[i-1][k];
				if(precount==-1) continue;
				dp[i][Next[k][j]]=max(dp[i][Next[k][j]], precount+ (Next[k][j]==n1));
			}
		}
	}
	int ans=0;
	for(int i=0;i<=n1;i++){
		ans=max(ans,dp[n2-1][i]);
	}
	cout<<ans;
}