#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int N,op,a,b,c,size=2010;
    cin>>N;
    long long sum = 0;
    int diags[size][size];
	for(int i = 0; i<size; i++){
        for(int j = 0; j<size; j++)diags[i][j]=0;
    }
    for(int i = 0; i<N; i++){
        cin>>op>>a>>b>>c;
        if(op==1){
            for(int j = a; j<size; j+=(j&-j))diags[a+b][j]+=c;
        }
        else{
            for(int j = a; j>0; j-=(j&-j))sum=(sum+diags[a+b][j])%1000000007;
            for(int j = a-c-1; j>0; j-=(j&-j))sum=(sum-diags[a+b][j])%1000000007;
        }
    }
    cout<<sum<<endl;
}