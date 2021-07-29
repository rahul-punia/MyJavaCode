#include <stdio.h>
using namespace std;

int n;
int sieve[1000001];

int ctp[1000001]; //count of prime

void fact(int n){
        for(int i=2;i<=n;i++){
            ctp[i]=ctp[i-1];
            if(sieve[i]==0){ctp[i]++;}
        }
}      
    
    void SOE(int n){
        // sieve=new int[n+1];

        for(int x=2;x<=n;x++){
            if(sieve[x]!=0){continue;}
            for(int u=2*x;u<=n;u+=x){
                sieve[u]=x;
            }
        }
    }

int main(){
    int t,x,y;
    // cin >> t;
    scanf("%d", t);
    SOE(1000000);
    fact(1000000);
    while(t-->0){
        scanf("%d %d", x,y);

        int prime=ctp[x];
            
            if(prime>y){
                printf("Divyam");
            }else{
                printf("Chef");
            }
    }
   
}           




    