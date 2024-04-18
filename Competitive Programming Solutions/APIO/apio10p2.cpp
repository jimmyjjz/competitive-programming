//Heavily inspired by bruce's code
#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N, K, diameter, f, pre[100001], d[100001][2],res;
unordered_map<int,int> adj[100001];
void dfs(int u, int p, int d){
    if(d>diameter) { 
        diameter=d; 
        f=u;
    }
    pre[u]=p;
    for(auto[v, w] : adj[u])if(v!=p)dfs(v, u, d+1);
}
void dfs(int u, int p){ 
    d[u][0]=0; 
    d[u][1]=0;
    for(auto[v, w] : adj[u]){
        if(v!=p){
            dfs(v, u);
            if(d[v][0]+w>d[u][0]) { 
                d[u][1]=d[u][0]; 
                d[u][0]=d[v][0]+w;
            }
            else if(d[v][0]+w>d[u][1])d[u][1]=d[v][0]+w;
        }
    }
    diameter=max(diameter, d[u][0]+d[u][1]);
}
int main(){
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K;
    for(int i = 1,a,b; i<N; i++){
        cin>>a>>b;
        adj[a][b]=1;
        adj[b][a]=1;
    }
    diameter=0;dfs(1, -1, 0); 
    diameter=0;dfs(f,-1, 0);
    res=2*(N-1)-diameter+1;
    if(K==1)cout<<res<<"\n";
    else{
        while(pre[f]!=-1){
            adj[f][pre[f]]=-1;  
            adj[pre[f]][f]=-1;
            f=pre[f];
        }
        diameter=0;dfs(1, -1);
        cout<<res-diameter+1<<"\n";
    }
}