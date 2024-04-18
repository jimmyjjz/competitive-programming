#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,s,n[100001],XORall,temp,pre,exist=0;
int main() {
    for(int i = 0; i<100001; i++)n[i]=-1;
    cin>>N;
    s=ceil(N/2.0);
    cout<<"? 1 "<<N<<"\n";
    cin>>XORall;
    cout<<"? 1 "<<(N-1)<<"\n";
    cin>>temp;
    n[N]=temp^XORall;
    pre=temp;
    for(int i = N-2; i>=s; i--){
        cout<<"? 1 "<<i<<"\n";
        cin>>temp;
        n[i+1]=temp^pre;
        pre=temp;
    }
    cout<<"? 2 "<<N<<"\n";
    cin>>temp;
    n[1]=temp^XORall;
    pre=temp;
    for(int i = 3; i<=s; i++){
        cout<<"? "<<i<<" "<<N<<"\n";
        cin>>temp;
        n[i-1]=temp^pre;
        pre=temp;
    }
    for(int i = 1; i<=N; i++)if(n[i]!=-1)exist^=n[i];
    cout<<"!";
    for(int i = 1; i<=N; i++)if(n[i]==-1)cout<<" "<<(XORall^exist);else cout<<" "<<n[i];
    cout<<"\n";
}