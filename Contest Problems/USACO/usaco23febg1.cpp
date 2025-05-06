#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct s{int l,r;long long t;};
bool cmp(s a, s b){return a.t>b.t;}
bool works(s a, s b, int i){return ((i>=a.l&&i<=a.r)+(i>=b.l&&i<=b.r))%2;}
int N,SAsize;
long long nums[500];
vector<s> subarrays;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>nums[i];
    for(int i = 0; i<N; i++){
        for(int j=i; j<N; j++){
            long long sum = 0;
            for(int k = i; k<=j; k++)sum+=nums[k];
            subarrays.push_back({i,j,sum});
        }
    }
    sort(subarrays.begin(),subarrays.end(),cmp);
    SAsize=subarrays.size();
    for(int i = 0; i<N; i++){
        long long best = LONG_LONG_MAX;
        for(int j = 1; j<SAsize; j++)if(works(subarrays[j-1],subarrays[j],i))best=min(best,subarrays[j-1].t-subarrays[j].t);
        cout<<best<<"\n";
    }
}