#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
struct e{int d,i;};
int N,M;
vector<e> adj[201];
vector<vector<int>> cycles[201];
bool visited[1000]={0}, printed[201]={0};
void r(int u, int start, vector<int> path, bool starting){
    if(!starting)path.push_back(u);
    if(!starting&&u==start){
        cycles[u].push_back(path);
        for(int i : path)r(i,i,vector<int>{},true);
        return;
    }
    for(e v : adj[u]){
        if(visited[v.i])continue;
        visited[v.i]=true;
        r(v.d,start,path,false);
    }
}
void printAns(int u){
    printed[u]=true;
    for(vector<int> v : cycles[u]){
        for(int n : v){
            cout<<n<<" ";
            if(!printed[n])printAns(n);
        }
    }
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i = 0,a; i<N; i++)cin>>a;
    for(int i = 0,a,b; i<M; i++){
        cin>>a>>b;
        adj[a].push_back({b,i});
        adj[b].push_back({a,i});
    }  
    r(1,1,vector<int>{},true);
    cout<<M<<"\n1 ";
    printAns(1);
}