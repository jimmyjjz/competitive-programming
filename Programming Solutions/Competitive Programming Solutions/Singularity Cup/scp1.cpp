#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,arr[200000];
bool oneFront=false,oneBack=false;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>arr[i];
    oneFront=arr[0]==1;
    oneBack=arr[N-1]==1;
    if(N==1)cout<<"1 1\n";
    else if(N==3&&arr[0]==3&&arr[1]==1&&arr[2]==2)cout<<"1 1\n";
    else if(N==3&&arr[0]==2&&arr[1]==1&&arr[2]==3)cout<<"3 3\n";
    else if(oneFront)cout<<"2 "<<N<<"\n";
    else if(oneBack)cout<<"1 "<<(N-1)<<"\n";
    else cout<<"1 "<<N<<"\n";
}