#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    if(N%2==0)for(int i = 0,j=0; i<N; i++){
        if(i%4==1)j+=2; 
        else if(i%4==2)j++;
        cout<<((i%4==1||i%4==2)?-(i%2==0?1:j):(i%2==0?1:j))<<" ";
    }
    else for(int i = 0,j=0; i<N; i++){
        if(i%4==0)j++; 
        else if(i%4==2)j+=2;
        cout<<((i%4==2||i%4==3)?-(i%2?1:j):(i%2?1:j))<<" ";
    }
    cout<<"\n";
}