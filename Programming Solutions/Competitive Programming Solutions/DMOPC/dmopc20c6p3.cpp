#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,M,visitCnt[500001]={0};
bool police[500001], deadend[500001]={0}, visited[500001]={0};
vector<int> adj[500001], flippedadj[500001];
queue<int> q;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i = 1; i<=N; i++)cin>>police[i];
    for(int i = 0,a,b; i<M; i++){
        cin>>a>>b;
        adj[a].push_back(b);
        flippedadj[b].push_back(a);
    }
    for(int i = 1; i<=N; i++)if(adj[i].empty()){q.push(i);deadend[i]=true;}
    while(!q.empty()){
        int poll = q.front();q.pop();
        visitCnt[poll]++;
        if(visitCnt[poll]==adj[poll].size()){
            bool y = true;
            for(int v : adj[poll])y&=deadend[v];
            deadend[poll]=y;
        }
        if(!deadend[poll]||visited[poll])continue;
        visited[poll]=true;
        for(int v : flippedadj[poll]){
            if(police[v]){
                deadend[v]=true;
                q.push(v);
            }
            else q.push(v);
        }
    }
    cout<<deadend[1];
    for(int i = 2; i<=N; i++)cout<<" "<<deadend[i];
    cout<<"\n";
}