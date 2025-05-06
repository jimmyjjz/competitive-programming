#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct ss{int b,v;};
int N,n[20],m=INT_MAX,idx=-1,s;
vector<ss> sets;
bool cmp(ss a, ss b){return a.v<b.v;}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>n[i];
    for(int j = 1; j<(1<<N); j++){
        int sum = 0;
        for(int k = 0; k<N; k++)if(((1<<k)&j)!=0)sum+=n[k];
        sets.push_back({j,sum});
    }
    sort(sets.begin(),sets.end(),cmp);
    s=sets.size();
    for(int i = 0; i<s-1; i++){
        if((sets[i].b&sets[i+1].b)==0&&m>sets[i+1].v-sets[i].v){
            m=sets[i+1].v-sets[i].v;
            idx=i;
        }
    }
    for(int i = 0; i<N; i++)if((sets[idx].b&(1<<i))!=0)cout<<(i+1)<<" ";
    cout<<"\n";
    for(int i = 0; i<N; i++)if((sets[idx+1].b&(1<<i))!=0)cout<<(i+1)<<" ";
    cout<<"\n";
}