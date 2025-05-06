#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int findrep(int disjoint[][3], int n) {
		while(disjoint[n][0]!=n)n=disjoint[n][0];
		return n;
	}
int main() {
        int N,Q;
        cin>>N>>Q;
		int disjoint[N+1][3];
		for(int i = 1; i<=N; i++) {
			disjoint[i][0]=i;
			disjoint[i][2]=1;
		}
		for(int i = 0; i<Q; i++) {
			int op;
            cin>>op;
			if(op==1) {
                int a,b;
                cin>>a>>b;
				a = findrep(disjoint, a);
                b = findrep(disjoint, b);
				if(a==b)continue;
				if(disjoint[a][1]>=disjoint[b][1]) {
					disjoint[a][1]++;
					disjoint[b][0]=a;
					disjoint[a][2]+=disjoint[b][2];
				}
				else{
					disjoint[b][1]++;
					disjoint[a][0]=b;
					disjoint[b][2]+=disjoint[a][2];
				}
			}
			else{
                int n;
                cin>>n;
                cout<<disjoint[findrep(disjoint,n)][2]<<endl;
		}
}
}