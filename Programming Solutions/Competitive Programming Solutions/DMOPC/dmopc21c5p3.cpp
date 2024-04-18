#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main(){
    vector<int> primes;
		for(int i = 2; i<=100003; i++) {
			for(int j = 2; j<=(int)sqrt(i); j++) {
				if(i%j==0)goto out;
			}
			primes.push_back(i);
		out:{}
		}
		int win[100001];
		for(int i = 0; i<=100000; i++)win[i]=0;
		for(int i = 1; i<=100000; i++) {
			for(int j = 0; i-primes[j]>0; j++) {
				if(win[i-primes[j]]) {
					win[i]=0;
					goto out2;
				}
			}
			win[i]=1;
		out2:{}
		}
		int T;
		cin>>T;
		for(int i = 0; i<T; i++) {
			int N;
			cin >> N;
			if(N==1||N==2){
				cout<<"-1"<<endl;
				continue;
			}
			if(!win[N]) {
				for(int j = 1; j<N-2; j++)cout<<j<<" ";
				cout<<(N-2)<<" "<<(N-1)<<" "<<N<<endl;
			}
			else if(!win[N-1]) {
				for(int j = 1; j<N-2; j++)cout<<j<<" ";
				cout<<(N-2)<<" "<<N<<" "<<(N-1)<<endl;
			}
			else{
				for(int j = 1; j<N-2; j++)cout<<j<<" ";
				cout<<N<<" "<<(N-2)<<" "<<(N-1)<<endl;
			}
		}
}