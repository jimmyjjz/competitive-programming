#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,Q,arr[200001],presum[200001];
string drop;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    int N,Q;
    cin>>N>>Q;
    for(int i = 1; i<=N; i++)cin>>arr[i];
    presum[0]=0;
    for(int i = 1; i<=N; i++)presum[i]=arr[i]+presum[i-1];
    for(int i = 0,l,s; i<Q; i++){
        cin>>drop>>l>>s;
        int low = l, r = N;
        while(low<=r){
            int m=(low+r)/2;
            if(presum[m]-presum[l-1]>=s)r=m-1;
            else low=m+1;
        }
        if(r==0||r==N)cout<<N<<"\n";
        else cout<<r+1<<"\n";
    }
}