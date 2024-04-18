#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
string K;
int dp[100000][4][2];
struct s{int d, s; bool limited;};
queue<s> q;
int happen(int s, int x){
    if(s==0&&x==1)return 1;
    if(s==1&&x==0)return 2;
    if(s==2&&x==0)return 3;
    return s;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>K;
    memset(dp, -1, sizeof(dp));
    for(int i = 0; i<=K[0]-'0'; i++){
        if(dp[0][happen(0,i)][i==K[0]-'0']==-1){
            dp[0][happen(0,i)][i==K[0]-'0']=0;
            q.push({0,happen(0,i),i==K[0]-'0'});
        }
        dp[0][happen(0,i)][i==K[0]-'0']++;
    }
    while(!q.empty()){
        s poll=q.front();q.pop();
        if(poll.d==K.length()-1)continue;
        for(int i = 0; i<=(poll.limited?K[poll.d+1]-'0':9); i++){
            if(dp[poll.d+1][happen(poll.s,i)][poll.limited&&i==K[poll.d+1]-'0']==-1){
                q.push({poll.d+1,happen(poll.s,i),poll.limited&&i==K[poll.d+1]-'0'});
                dp[poll.d+1][happen(poll.s,i)][poll.limited&&i==K[poll.d+1]-'0']=0;
            }
            dp[poll.d+1][happen(poll.s,i)][poll.limited&&i==K[poll.d+1]-'0']=(dp[poll.d+1][happen(poll.s,i)][poll.limited&&i==K[poll.d+1]-'0']+dp[poll.d][poll.s][poll.limited])%1000000007;
        }
    }
    cout<<(max(dp[K.length()-1][2][0],0)+max(dp[K.length()-1][2][1],0))%1000000007<<"\n";
}