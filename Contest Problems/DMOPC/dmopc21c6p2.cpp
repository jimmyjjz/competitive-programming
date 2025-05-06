#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,K,t=0,c=0,siz;
string s;
vector<int> v;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K>>s;
	for(int i = 0; i<N; i++) {
		if(s[i]=='0')c++;
		else {
			v.push_back(c);
			c=0;
		}
	}
	if(s[N-1]=='0')v.push_back(c);
	sort(v.begin(), v.end());
    siz=v.size();
	K=min(K, siz);
	while(K--!=0){t+=v.back();v.pop_back();}
	cout<<t<<"\n";
}