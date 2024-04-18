#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct E{int u,v,l,c;};
class des{public:int n,l,i;des(int n, int l, int i):n(n),l(l),i(i){}};
class cmpdes {public:bool operator()(des a, des b){return a.l>b.l;}};
bool cmpE(E a, E b){return a.c>b.c;}
bool visited[2001], banished[2001];
int before[2001],after[2001],N,M,a,b,c,d,u;
long long tot = 0;
vector<des> adj[2001]; 
priority_queue<des,vector<des>,cmpdes> pq;
void dijkstra(int val[], int u){
     fill(val,val+2001,INT_MAX);
     memset(visited, false, sizeof(visited));
     pq.push(des(u,0,-1));
     while(!pq.empty()){
        des poll = pq.top();
        pq.pop();
        if(!visited[poll.n]&&(poll.i==-1||!banished[poll.i])){
            visited[poll.n]=true;
            val[poll.n]=poll.l;
            for(des v : adj[poll.n])pq.push(des(v.n,v.l+poll.l,v.i));
        }
     }
}
int main() {
    cin.sync_with_stdio(0); 
    cin.tie(0);
    memset(banished, false, sizeof(banished));
    cin>>N>>M;
    E edges[M];
    for(int i = 0; i<M; i++){
        cin>>a>>b>>c>>d;
        tot+=d;
        edges[i]={a,b,c,d};
    }
    sort(edges,edges+M,cmpE);
    for(int i = 0; i<M; i++){
        E e = edges[i];
        adj[e.u].push_back(des(e.v,e.l,i));
        adj[e.v].push_back(des(e.u,e.l,i));
    }
    for(int i = 0; i<M; i++){
        dijkstra(before,edges[i].u);
        banished[i]=true;
        dijkstra(after,edges[i].u);
        bool dif = false;
        for(int j = 1; j<=N; j++){
            if(before[j]!=after[j]){
                dif=true;
                break;
            }
        }
        if(!dif)tot-=edges[i].c;
        else banished[i]=false;
    }
    cout<<tot;
}