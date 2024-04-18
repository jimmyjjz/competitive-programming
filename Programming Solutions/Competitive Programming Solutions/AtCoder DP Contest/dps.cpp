#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
string K;
int D, dp[10000][100][2];
struct s{int d, r; bool limited;};
queue<s> q;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>K>>D;
    memset(dp, -1, sizeof(dp));
    for(int i = 0; i<=K[0]-'0'; i++){
        if(dp[0][i%D][i==K[0]-'0']==-1){
            dp[0][i%D][i==K[0]-'0']=0;
            q.push({0,i%D,i==K[0]-'0'});
        }
        dp[0][i%D][i==K[0]-'0']++;
    }
    while(!q.empty()){
        s poll=q.front();q.pop();
        if(poll.d==K.length()-1)continue;
        for(int i = 0; i<=(poll.limited?K[poll.d+1]-'0':9); i++){
            if(dp[poll.d+1][(poll.r+i)%D][poll.limited&&i==K[poll.d+1]-'0']==-1){
                q.push({poll.d+1,(poll.r+i)%D,poll.limited&&i==K[poll.d+1]-'0'});
                dp[poll.d+1][(poll.r+i)%D][poll.limited&&i==K[poll.d+1]-'0']=0;
            }
            dp[poll.d+1][(poll.r+i)%D][poll.limited&&i==K[poll.d+1]-'0']=(dp[poll.d+1][(poll.r+i)%D][poll.limited&&i==K[poll.d+1]-'0']+dp[poll.d][poll.r][poll.limited])%1000000007;
        }
    }
    cout<<((ll)(dp[K.length()-1][0][0]+(dp[K.length()-1][0][1]==-1?0:dp[K.length()-1][0][1])-1)+1000000007)%1000000007<<"\n";
}