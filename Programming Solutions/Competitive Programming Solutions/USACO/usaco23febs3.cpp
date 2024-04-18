#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct flight{int ut,v,vt;};
struct des{int d,t;};
bool cmpf(flight a, flight b){return a.ut<b.ut;}
vector<flight> flights[200001];
int N,M,layover[200001],best[200001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    int visit[200001];
    for(int i = 0,a,b,c,d; i<M; i++){
        cin>>a>>b>>c>>d;
        flights[a].push_back({b,c,d});
    }
    for(int i = 1; i<=N; i++){
        cin>>layover[i];
        sort(flights[i].begin(),flights[i].end(), cmpf);
        visit[i]=flights[i].size()-1;
        best[i]=INT_MAX;
    }
    queue<des> q;
    q.push({1,-layover[1]});
    while(!q.empty()){
        des poll = q.front();
        q.pop();
        best[poll.d]=min(best[poll.d],poll.t);
        poll.t+=layover[poll.d];
        while(visit[poll.d]>=0&&flights[poll.d][visit[poll.d]].ut>=poll.t){
            q.push({flights[poll.d][visit[poll.d]].v,flights[poll.d][visit[poll.d]].vt});
            visit[poll.d]--;
        }
    }
    best[1]=0;
    for(int i = 1; i<=N; i++){
        if(best[i]==INT_MAX)cout<<-1<<"\n";
        else cout<<best[i]<<"\n";
    }
}