#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,K,F,cnt = 0, cnt2 = 0, m = 0;
vector<int> adj[1000001];
bool gym[1000001];
void dfs1(int n, int pre, int depth) {
	for(int i : adj[n]) {
		if(i != pre) { 
			dfs1(i, n, depth+1);
			if(gym[i]) { 
				cnt++;
				gym[n]=true; 
			}
		}
	}
	if(gym[n])m=max(m,depth);
}
void dfs2(int n, int pre, int depth) {
	for(int i : adj[n]) {
		if(i != pre) { 
			dfs2(i, n, depth+1);
			if(gym[i]||i==F) { 
				cnt2++;
				gym[n]=true; 
			}
		}
	}
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K>>F;
	for(int i = 0,a; i<K; i++){
        cin>>a;
        gym[a]=true;
    }
	for(int i = 1,a,b; i<N; i++) {
		cin>>a>>b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
		dfs1(1, -1, 0);  
		dfs2(1, -1, 0);
		cout<<min(2*cnt-m, cnt2)<<"\n";
}