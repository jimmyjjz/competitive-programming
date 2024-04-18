#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int arr[2000][2000]={0}, N,K;
bool values[4000001]={0};
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>K;
    for(int i = N*N,j=0; i>N*N-K; i--,j++){
        arr[j][j]=i;
        values[i]=true;
    }
    for(int i = 0,k=N*N; i<N; i++){
        for(int j = 0; j<N; j++){
            if(arr[i][j]!=0)continue;
            while(values[k])k--;
            arr[i][j]=k;
            k--;
        }
    }
    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++)cout<<arr[i][j]<<" ";
        cout<<"\n";
    }
}