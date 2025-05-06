#include <bits/stdc++.h>
#include <iostream>
#include <queue>
using namespace std;
int main() {
    	int N,Q,up = 0,group = 0;
        cin>>N>>Q;
        int belong[N];
        memset(belong, 0, sizeof(belong));
        vector<int> connected[N];
		for(int i = 0; i<N; i++){
            int in;
            cin>>in;
            connected[in-1].push_back(i);
        }
        queue<int> q;
		while(true) {
			if(q.size()==0) {
				group++;
				for(; up<N; up++)if(belong[up]==0) {
					q.push(up);
					break;
				}
			}
			if(q.size()==0)break;
			int poll = q.front();
            q.pop();
			if(belong[poll]==0) {
				belong[poll]=group;
				for(int v : connected[poll])if(belong[v]==0)q.push(v);
			}
		}
		int set[N], groups[N], cur[N];
        memset(set, 0, sizeof(set));
        memset(groups, 0, sizeof(groups));
        memset(cur, 0, sizeof(cur));
		for(int i = 1; i<=Q; i++) {
			int M, cut = 0, used = 0;
            cin>>M;
			for(int j = 0; j<M; j++) {
				int in;
                cin>>in;
				set[in-1]=i;
				if(groups[belong[in-1]]!=i) {
					used++;
					groups[belong[in-1]]=i;
				}
				cur[j]=in-1;
			}
			for(int j = 0; j<M; j++) {
				for(int k : connected[cur[j]]) {
					if(set[k]!=i) {
						cut++;
						break;
					}
				}
			}
			cout<<group+cut-used-1<<endl;
		}
}