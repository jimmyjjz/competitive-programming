#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,M,K,t[1000006],m=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M>>K;
    for(int i = 3; i<=N+2; i++)cin>>t[i];
    t[0]=0;
    t[1]=0;
    t[2]=0;
    t[N+3]=M+1;
    t[N+4]=M+1;
    t[N+5]=M+1;
    for(int i = 2; i<=N+3; i++){
        if(t[i-1]-K<t[i-2])m=max(m,t[i]-t[i-2]);
        else m=max(m,t[i]-(t[i-1]-K));
        if(t[i+1]+K>t[i+2])m=max(m,t[i+2]-t[i]);
        else m=max(m,t[i+1]+K-t[i]);
    }
    cout<<m-1<<"\n";
}