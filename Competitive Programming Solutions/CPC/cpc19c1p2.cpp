#include <bits/stdc++.h>
#include <iostream>
using namespace std;
deque<int> dq;
vector<int> v;
int N,K,idx,m=0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K;
    for(int i = 0,in; i<N; i++){cin>>in;v.push_back(in);}
    sort(v.begin(),v.end());
    dq.push_back(v[idx++]);
    while(idx<N){
        if(dq.empty())dq.push_back(v[idx++]);
        while(idx<N&&v[idx]-dq.front()<=K)dq.push_back(v[idx++]);
        m=max(m,(int)dq.size());
        dq.pop_front();
    }
    cout<<m<<"\n";
}