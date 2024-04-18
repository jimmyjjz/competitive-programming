#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N, arr[10]={100,500,1000,5000,10000,25000,50000,100000,500000,1000000}, tot=1691600,offer;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,n; i<N; i++){
        cin>>n;
        tot-=arr[n-1];
    }
    cin>>offer;
    if(offer>((double)(tot)/(10-N)))cout<<"deal\n";
    else cout<<"no deal\n";
}