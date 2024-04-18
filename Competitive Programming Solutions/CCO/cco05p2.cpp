//this is my java solution translated to c++
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
struct des{int n,v;};
class cmp {public:bool operator()(des a, des b){return a.v>b.v;}};
priority_queue<des,vector<des>,cmp> pq;
vector<des> adj[100];
int N;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,w,n; i<=N; i++){
        cin>>w>>n;
        for(int j = 0,x; j<n; j++){
            cin>>x;
            adj[i].push_back({x,w+10});
        }
    }
    pq.push({0,0});
    int v[100];
    memset(v,-1,sizeof(v));
    while(!pq.empty()){
        des d = pq.top();pq.pop();
        if(v[d.n]==-1){
            v[d.n]=d.v;
            for(des node : adj[d.n])pq.push({node.n, node.v+d.v});
        }
    }
    int m = 0;
    for(int i = 1; i<=N; i++){
        int v2[100];
        memset(v2,-1,sizeof(v2));
        priority_queue<des,vector<des>,cmp> pq;
        pq.push({i,v[i]});
        while(!pq.empty()){
            des d = pq.top();pq.pop();
            if(v2[d.n]==-1){
                v2[d.n]=d.v;
                if(d.n==0)break;
                for(des node : adj[d.n])pq.push({node.n, node.v+d.v});
            }
        }
        m=max(m,v2[0]);
    }
    cout<<m<<"\n";
}