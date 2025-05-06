#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,arr[5000],best[5001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<=5000; i++)best[i]=INT_MAX;
    for(int i = 0; i<N; i++)cin>>arr[i];
    for(int i = 0; i<N; i++){
        int cur = 0;
        for(int j = 0; i+j<N&&i-j>=0; j++){
            cur+=abs(arr[i-j]-arr[i+j]);
            best[j*2+1]=min(best[j*2+1],cur);
        }
    }
    for(int l = 0, r = 1; r<N; l++,r++){
        int cur = 0;
        for(int j = 0; r+j<N&&l-j>=0; j++){
            cur+=abs(arr[l-j]-arr[r+j]);
            best[j*2+2]=min(best[j*2+2],cur);
        }
    }
    for(int i = 1; i<=N; i++)cout<<best[i]<<" ";
}