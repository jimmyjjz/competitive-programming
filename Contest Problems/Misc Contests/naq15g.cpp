#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,s[15],best[1<<15][2];
bool visited[1<<15][2]={0};
struct pos{int b,p;};
class cmp {public:bool operator()(pos a, pos c){return best[a.b][a.p]>best[c.b][c.p];}};
priority_queue<pos, vector<pos>, cmp> pq;
void r(int b, int p, int v){
    if(best[b][p]<=v)return;
    best[b][p]=v;
    cout<<b<<" "<<p<<" "<<v<<"\n";
    if(p==0){
        for(int i = 0; i<N; i++){
            if(!((1<<i)&b))
                for(int j = i; j<N; j++){
                    if(!((1<<j)&b)){
                        r((b|(1<<i))|(1<<j),1,v+max(s[i],s[j]));
                    }
                }
        }
    }
    else{
        for(int i = 0; i<N; i++){
            if((1<<i)&b)
                for(int j = i; j<N; j++){
                    if(((1<<j)&b)){
                        r((b&~(1<<i))&~(1<<j),0,v+max(s[i],s[j]));
                    }
                }
        }
    }
} 
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>s[i];
    for(int i = 0; i<(1<<N); i++)for(int j = 0; j<2; j++)best[i][j]=INT_MAX;
    best[0][0]=0;
    pq.push({0,0});
    while(!pq.empty()){
        pos top = pq.top();pq.pop();
        if(visited[top.b][top.p])continue;
        visited[top.b][top.p]=true;
        if(top.p==0){
            for(int i = 0; i<N; i++){
                if(!((1<<i)&top.b))
                    for(int j = i; j<N; j++){
                        if(!((1<<j)&top.b)){
                            best[(top.b|(1<<i))|(1<<j)][1]=min(best[(top.b|(1<<i))|(1<<j)][1],best[top.b][top.p]+max(s[i],s[j]));
                            pq.push({(top.b|(1<<i))|(1<<j),1});
                        }
                    }
            }
        }
        else{
            for(int i = 0; i<N; i++){
                if((1<<i)&top.b)
                    for(int j = i; j<N; j++){
                        if(((1<<j)&top.b)){
                            best[(top.b&~(1<<i))&~(1<<j)][0]=min(best[(top.b&~(1<<i))&~(1<<j)][0],best[top.b][top.p]+max(s[i],s[j]));
                            pq.push({(top.b&~(1<<i))&~(1<<j),0});
                        }
                    }
            }
        }
    }
    cout<<best[(1<<N)-1][1]<<"\n";
}