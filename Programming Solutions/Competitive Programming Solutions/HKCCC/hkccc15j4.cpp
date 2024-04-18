#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct section{int x,y;};
bool cmp(section a, section b){return a.x<b.x;}
int L,N,best=0;
section presum[100000];
vector<section> merged;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>L>>N;
    for(int i = 0,x,y; i<N; i++){
        cin>>x>>y;
        presum[i]={x,y};
    }
    sort(presum, presum+N, cmp);
    section cur = {-1,-1};
    for(int i = 0; i<N; i++){
        if(presum[i].x<=cur.y)cur.y=max(cur.y,presum[i].y);
        else{
            if(cur.x!=-1)merged.push_back(cur);
            cur=presum[i];
        }
    }
    merged.push_back(cur);
    best=max(best,merged[0].x);
    for(int i = 1; i<merged.size(); i++)best=max(best,merged[i].x-merged[i-1].y);
    best=max(best,L-merged[merged.size()-1].y);
    cout<<best<<"\n";
}