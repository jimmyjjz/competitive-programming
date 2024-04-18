#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct p{long long a,b;};
bool cmp(p a, p b){return a.a<b.a;}
vector<p> things;
long long t = 0, m = 0,a,b;
int N;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){
        cin>>a>>b;
        things.push_back({a,b});
    }
    sort(things.begin(), things.end(), cmp);
    for(p n : things){
        t=(t+(((m*n.b)%1000000007LL)%1000000007LL)+((n.a*((n.b*(n.b+1))/2%1000000007LL)%1000000007LL)%1000000007LL))%1000000007LL;
        m=(m+(n.a*n.b)%1000000007LL)%1000000007LL;
    }
    cout<<t<<"\n";
}