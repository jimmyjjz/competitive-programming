#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,M;
vector<int> adj[100001];
queue<int> q;
bool v[100001]={0};
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i = 0,x,y; i<M; i++){
        cin>>x>>y;
        adj[y].push_back(x);
    }
    for(int i : adj[1])q.push(i);
    if(q.empty())v[1]=true;
    while(!q.empty()){
        int poll=q.front();q.pop();
        if(!v[poll]){
            v[poll]=true;
            for(int i : adj[poll])q.push(i);
        }
    }
    for(int i = 1; i<=N; i++)cout<<v[i];
    cout<<"\n";
}