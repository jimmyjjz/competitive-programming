#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
int N, good=0,dp[1000][1<<10][2][2];
ll cnt;
string K;
struct s{int d,b;bool l,z;};
queue<s> q;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0,a; i<N; i++){
        cin>>a;
        good|=(1<<a);
    }
    cin>>K;
    memset(dp, -1, sizeof(dp));
    for(int i = 0; i<=K[0]-'0'; i++){
        if(dp[0][(i==0?0:1<<i)][i==K[0]-'0'][i!=0]==-1){
            dp[0][(i==0?0:1<<i)][i==K[0]-'0'][i!=0]=0;
            q.push({0,(i==0?0:1<<i),i==K[0]-'0',i!=0});
        }
        dp[0][(i==0?0:1<<i)][i==K[0]-'0'][i!=0]++;
    }
    while(!q.empty()){
        s poll=q.front();q.pop();
        if(poll.d==K.length()-1)continue;
        for(int i = 0; i<=(poll.l?K[poll.d+1]-'0':9); i++){
            if(dp[poll.d+1][(i==0?(poll.z?poll.b|(1<<i):poll.b):poll.b|(1<<i))][poll.l&&i==K[poll.d+1]-'0'][poll.z||i!=0]==-1){
                q.push({poll.d+1,(i==0?(poll.z?poll.b|(1<<i):poll.b):poll.b|(1<<i)),poll.l&&i==K[poll.d+1]-'0',poll.z||i!=0});
                dp[poll.d+1][(i==0?(poll.z?poll.b|(1<<i):poll.b):poll.b|(1<<i))][poll.l&&i==K[poll.d+1]-'0'][poll.z||i!=0]=0;
            }
            dp[poll.d+1][(i==0?(poll.z?poll.b|(1<<i):poll.b):poll.b|(1<<i))][poll.l&&i==K[poll.d+1]-'0'][poll.z||i!=0]=(dp[poll.d+1][(i==0?(poll.z?poll.b|(1<<i):poll.b):poll.b|(1<<i))][poll.l&&i==K[poll.d+1]-'0'][poll.z||i!=0]+dp[poll.d][poll.b][poll.l][poll.z])%1000000007;
        }
    }
    for(int i = 0; i<(1<<10); i++){
        if((good&i)!=good)continue;
        cnt=(cnt+(dp[K.length()-1][i][0][0]==-1?0:dp[K.length()-1][i][0][0])+(dp[K.length()-1][i][1][0]==-1?0:dp[K.length()-1][i][1][0])+(dp[K.length()-1][i][0][1]==-1?0:dp[K.length()-1][i][0][1])+(dp[K.length()-1][i][1][1]==-1?0:dp[K.length()-1][i][1][1]))%1000000007;
    }
    if(good==1)cnt=(cnt+1)%1000000007;
    cout<<cnt<<"\n";
}