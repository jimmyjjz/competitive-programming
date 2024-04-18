#include <bits/stdc++.h>
#include <iostream>
using namespace std;
using ll = long long;
struct s{int d,cur,pre,prepre; bool limited;};
ll a,b;
ll toN(string N){
    if(N=="-1")return 0;
    ll dp[19][10][11][11][2]={0};
    bool visited[19][10][11][11][2]={0};
    queue<s> q;
    for(int i = 0; i<=(N[0]-'0'); i++){
        dp[0][i][10][10][i==N[0]-'0']=1;
        q.push({0,i,10,10,i==N[0]-'0'});
    }
    while(!q.empty()){
        s poll=q.front();q.pop();
        if(poll.d==N.length()-1||poll.cur==poll.pre||poll.cur==poll.prepre)continue;
        for(int i = 0; i<=(poll.limited?N[poll.d+1]-'0':9); i++){
            if(poll.cur==0&&poll.pre==10){
                q.push({poll.d+1,i,10,10,poll.limited&&i==N[poll.d+1]-'0'});
                dp[poll.d+1][i][10][10][poll.limited&&i==N[poll.d+1]-'0']+=dp[poll.d][poll.cur][poll.pre][poll.prepre][poll.limited];
                continue;
            }
            if(!visited[poll.d+1][i][poll.cur][poll.pre][poll.limited&&i==N[poll.d+1]-'0']){
                visited[poll.d+1][i][poll.cur][poll.pre][poll.limited&&i==N[poll.d+1]-'0']=true;
                q.push({poll.d+1,i,poll.cur,poll.pre,poll.limited&&i==N[poll.d+1]-'0'});
            }
            dp[poll.d+1][i][poll.cur][poll.pre][poll.limited&&i==N[poll.d+1]-'0']+=dp[poll.d][poll.cur][poll.pre][poll.prepre][poll.limited];
        }
    }
    ll cnt=0;
    for(int i = 0; i<=9; i++)
        for(int j = 0; j<=10; j++)
            for(int k = 0; k<=10; k++)if(i!=j&&i!=k)cnt+=dp[N.length()-1][i][j][k][0]+dp[N.length()-1][i][j][k][1];
    return cnt;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>a>>b; 
    cout<<toN(to_string(b))-toN(to_string(a-1))<<"\n";
}