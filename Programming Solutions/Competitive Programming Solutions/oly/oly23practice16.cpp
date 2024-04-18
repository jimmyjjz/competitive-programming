#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N,fre[1000001]={0},arr[100000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>arr[i];
    for(int i = 0; i<N; i++)fre[arr[i]]++;
    for(int i = 0; i<N; i++){
        int coins = 0;
        for(int j = 1; j<=sqrt(arr[i]); j++)if(arr[i]%j==0){
            if(j!=arr[i]/j)coins+=fre[j]+fre[arr[i]/j];
            else coins+=fre[j];
        }
        cout<<coins-1<<"\n";
    }
}