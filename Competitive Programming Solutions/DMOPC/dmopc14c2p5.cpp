#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,M;
double chances[1000001];
vector<int> flow[1000001];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
	for(int i = 0,a,b; i<M; i++){
        cin>>a>>b;
        flow[a].push_back(b);
    }
    memset(chances, 0, sizeof(chances));
    chances[1]=1;
	for(int n = 1; n<=N; n++) {
		for(int i : flow[n])chances[i]+=chances[n]/(double)(flow[n].size());
	}
	for(int i = 1; i<=N; i++)if(flow[i].empty())cout<<setprecision(9)<<chances[i]<<"\n";
}