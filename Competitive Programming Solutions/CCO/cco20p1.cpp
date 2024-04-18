//this solution was very strongly inspired by someone
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int N,L,R,Y,t;
struct two{int a,b;};
set<int> s;
unordered_map<int, int> compression;
two offline[100100];
int presum[1000100], classify[1000100], freq[100100];
int main() {
    cin>>N>>L>>R>>Y;
    for(int i = 1,x,v,h;i<=N;++i) {
        cin>>x>>v>>h;
        int change = (h*Y-1)/v;
        offline[i]={x-change,x+change};
        s.insert(x-change-1);s.insert(x-change);s.insert(x-change+1);
        s.insert(x+change-1);s.insert(x+change);s.insert(x+change+1);
    }
    s.insert(L-1);
    s.insert(R);
    for(int i : s){
        if(i>=L-1&&i<=R) {
            compression[i]=++t;
            classify[t]=i;
        }
    }
    for(int i = 1; i<=N; ++i) {
        presum[compression[min(R, max(L-1, offline[i].a))]]++;
        presum[compression[min(R, max(L-1, offline[i].b))]+1]--;
    }
    for(int i = 1; i<=t; ++i)presum[i]+=presum[i-1];
    for(int i = 2; i<=t; ++i)freq[presum[i]]+=classify[i]-classify[i-1];
    for(int i = 0,sum=0; i<=N; i++){
        sum+=freq[i];
        cout<<sum<<'\n';
    }
}