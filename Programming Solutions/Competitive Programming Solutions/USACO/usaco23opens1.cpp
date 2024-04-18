#include <bits/stdc++.h>
#include <iostream>
using namespace std;
long long t=0,N,Q,ori[150000],sorted[150000],presum[150001];
long long bsearch(long long x){
    int l=0,h=N-1;
    while(l<=h){
        int m=(l+h)/2;
        if(sorted[m]>x)h=m-1;
        else l=m+1;
    }
    return h+1;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++){cin>>ori[i];sorted[i]=ori[i];}
    sort(sorted, sorted+N);
    for(int i = 0; i<N; i++)t+=sorted[i]*(i+1);
    presum[N]=0;
    for(int i = N-1; i>=0; i--)presum[i]=presum[i+1]+sorted[i];
    cin>>Q;
    for(int i = 0,a,b; i<Q; i++){
        cin>>a>>b;
        long long tempA = bsearch(ori[a-1]), tempB = bsearch(b);
        if(ori[a-1]>=b)cout<<t+(-ori[a-1]*tempA-presum[tempA]+b*(tempB+1)+presum[tempB]-ori[a-1])<<"\n";
        else cout<<t+(-ori[a-1]*tempA-presum[tempA]+b*tempB+presum[tempB])<<"\n";
    }
}