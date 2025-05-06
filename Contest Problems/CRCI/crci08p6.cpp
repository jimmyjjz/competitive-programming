#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
		int N,L,R,placed[1000001],bit[1000001];
        cin>>N;
        for(int i = 0; i<1000001; i++){
            placed[i]=0;
            bit[i]=0;
        }
		for(int i = 0; i<N; i++) {
            cin>>L>>R;
            int l = 0, r = 0;
            for(int j = L; j>0; j=j-(j&-j))l+=bit[j];
            for(int j = R; j>0; j=j-(j&-j))r+=bit[j];
			cout<<l-placed[L]+r-placed[R]<<endl;
			placed[L]=l;
			placed[R]=r;
            for(int j = L+1; j<1000001; j+=j&-j)bit[j]++;
            for(int j = R; j<1000001; j+=j&-j)bit[j]--;
	}
}