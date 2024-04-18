#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct p{int a,b;};
bool sp(p a, p b){return a.a==b.a?a.b>b.b:a.a<b.a;}
int main() {
		int N, max = 0, maxdex = -1;
        cin>>N;
        int bit[1000001][2] = {0}, backtrack[N];
        p intervals[N];
		for(int i = 0; i<N; i++)cin>>intervals[i].a>>intervals[i].b;
        sort(intervals, intervals+N, sp);
		for(int i = 0; i<N; i++) {
			int best = 0, bestdex = i;
			for(int j = -intervals[i].b+1000001; j>0; j-=j&-j) {
				if(bit[j][0]>best) {
					best=bit[j][0];
					bestdex=bit[j][1];
				}
			}
			if(best>max) {
				max=best;
				maxdex=i;
			}
			backtrack[i]=bestdex;
			for(int j = -intervals[i].b+1000001; j<=1000000; j+=j&-j) {
				if(bit[j][0]<best+1) {
					bit[j][0]=best+1;
					bit[j][1]=i;
				}
			}
		}
        cout<<max+1<<endl;
		int back = maxdex;
		while(back!=backtrack[back]) {
            cout<<intervals[back].a<<" "<<intervals[back].b<<endl;
			back=backtrack[back];
		}
            cout<<intervals[back].a<<" "<<intervals[back].b<<endl;
}