#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,n[150000],fre[300002]={0},mid=150001,shift=150001;
long long total = 0;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
	for(int i = 0; i<N; i++) {
		cin>>n[i];
		mid+=n[i]==1?1:-1;
        for(int j = mid; j<=300001; j+=j&-j)fre[j]++;
	}
	long total = 0;
	for(int i = 0; i<N; i++) {
        for(int j = 300001; j>0; j-=j&-j)total+=fre[j];
        for(int j = shift; j>0; j-=j&-j)total-=fre[j];
		shift+=n[i]==1?1:-1;
        for(int j = shift; j<=300001; j+=j&-j)fre[j]--;
	}
	cout<<total<<"\n";
}