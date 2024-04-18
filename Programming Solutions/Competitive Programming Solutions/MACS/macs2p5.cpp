#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct line{long long x1,y1,x2,y2;};
vector<line> ori,h,v;
vector<long long> setup;
bool SXcmp(line a, line b){return a.x1<b.x1;}
class EXcmp {public:bool operator()(line a, line b){return a.x2>b.x2;}};
priority_queue<line, vector<line>, EXcmp> pq;
unordered_map<long long, int> compress;
int N,siz,BIT[1600003]={0},Vsize,Hsize;
long long a,b,c,d,t=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>a>>b>>c>>d;
        ori.push_back({a,b,c,d});
        setup.push_back(a);setup.push_back(b);setup.push_back(c);setup.push_back(d);
    }
    siz=setup.size();
    sort(setup.begin(),setup.end());
    for(int i = 0,up=2; i<siz; i++)if(compress.count(setup[i])==0)compress[setup[i]]=up++;
    for(line l : ori){
        if(l.x1==l.x2)v.push_back(l);
        else h.push_back(l); 
    }
    sort(h.begin(), h.end(), SXcmp);
    sort(v.begin(), v.end(), SXcmp);
    Vsize=v.size();Hsize=h.size();
    for(int i = 0,j = 0; i<Vsize; i++){
        for(; j<Hsize&&h[j].x1<=v[i].x1; j++){
            for(int k = compress[h[j].y1]; k<1600003; k+=k&-k)BIT[k]++;
            pq.push(h[j]);
        }
        while(!pq.empty()&&pq.top().x2<v[i].x1){
            for(int k = compress[pq.top().y1]; k<1600003; k+=k&-k)BIT[k]--;
            pq.pop();
        }
        for(int k = max(compress[v[i].y2],compress[v[i].y1]); k>0; k-=k&-k)t+=BIT[k];
        for(int k = min(compress[v[i].y2],compress[v[i].y1])-1; k>0; k-=k&-k)t-=BIT[k];
    }
    cout<<t<<"\n";
}