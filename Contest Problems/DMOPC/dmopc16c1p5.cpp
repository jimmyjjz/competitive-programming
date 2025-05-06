#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N;
long long inversions = 0, fenwick[500001]={0};
deque<int> dq;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
	for(int i = 0,in,query; i<N; i++) {
        cin>>in;query=0;
        for(int j = in; j>0; j-=j&-j)query+=fenwick[j];
		if(query>i-query)dq.push_back(in);
		else dq.push_front(in);
		for(int j = in; j<=500000; j+=j&-j)fenwick[j]++;
	}
	for(int i = 0; i<N; i++) {
        for(int j = dq.front(); j<=500000; j+=j&-j)fenwick[j]--;
        for(int j = dq.front(); j>0; j-=j&-j)inversions+=fenwick[j];
        dq.pop_front();
	}
	cout<<inversions<<"\n";
}