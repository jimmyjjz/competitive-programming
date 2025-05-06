#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int binarysearchfirst(vector<int> piles, int n) {
	    int low = 0, high = piles.size()-1;
	    while(low<=high){
	        int mid=(low+high)/2;
	        if(piles[mid]>=n&&(piles[mid-1]<n||mid==0))return mid;
	        if(piles[mid]<n)low=mid+1;
	        else high = mid-1;
	    }
	    return high+1;
	}
int main() {
    int N,M;
	cin>>N;
	int dex[1000001];
	for(int i = 0; i<=1000000; i++)dex[i]=-1;
	for(int i = 0; i<N; i++){
		int in;
		cin>>in;
		dex[in]=i;
	}
    cin>>M;
	vector<int> piles;
	for(int i = 0; i<M; i++) {
		int cur;
        cin>>cur;
		if(dex[cur]==-1)continue;
		cur=dex[cur];
		if(piles.empty()||cur>=piles[piles.size()-1])piles.push_back(cur);
        else {int bs = binarysearchfirst(piles,cur);
		piles[bs]=cur;
		}
	}
	cout<<piles.size()<<endl;
}