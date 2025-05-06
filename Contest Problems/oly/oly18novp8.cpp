#include <bits/stdc++.h>
#include <iostream>
using namespace std;
vector<int> stars[32002];
int N, fenwick[32002], level[32000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,a,b; i<N; i++){
        cin>>a>>b;
        stars[b+1].push_back(a+1);
    }
    memset(fenwick,0,sizeof(fenwick));
    memset(level,0,sizeof(level));
    for(int i = 1; i<=32001; i++){
        for(int j : stars[i])for(int k = j; k<=32001; k+=k&-k)fenwick[k]++;
        for(int j : stars[i]){
            int l = -1;
            for(int k = j; k>0; k-=k&-k)l+=fenwick[k];
            level[l]++;
        }
    }
    for(int i = 0; i<N; i++)cout<<level[i]<<"\n";
}