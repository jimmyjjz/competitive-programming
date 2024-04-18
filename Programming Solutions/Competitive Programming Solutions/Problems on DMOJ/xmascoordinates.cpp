#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct pos{int x,y;};
struct mov{int x,y,m;};
int main() {
    int n,m;
    pos a,b,c;
    cin>>n>>m;
    char board[n][m];
    for(int i = 0; i<n; i++){
        string s;
        cin>>s;
        for(int j = 0; j<m; j++){
            board[i][j]=s[j];
            if(s[j]=='O')a={i,j};
            else if(s[j]=='P')b={i,j};
            else if(s[j]=='X')c={i,j};
        }
    }
    // for(int i = 0; i<n; i++){
    //     for(int j = 0; j<m; j++)cout<<board[i][j];
    //     cout<<endl;
    // }
    //cout<<a.x<<" "<<a.y<<" - "<<b.x<<" "<<b.y<<" - "<<c.x<<" "<<c.y<<endl;
    queue<mov> cur;
    bool valid[n][m];
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++)valid[i][j]=false;
    }
    cur.push({a.x,a.y,0});
    int moves = 0;
    while(!cur.empty()){
        mov poll = cur.front();
        if(poll.x==b.x&&poll.y==b.y){
            moves+=poll.m;
            goto out1;
        }
        cur.pop();
        if(poll.x>-1&&poll.x<n&&poll.y>-1&&poll.y<m&&!valid[poll.x][poll.y]&&board[poll.x][poll.y]!='#'){
            valid[poll.x][poll.y]=true;
            cur.push({poll.x+1,poll.y,poll.m+1});
            cur.push({poll.x,poll.y+1,poll.m+1});
            cur.push({poll.x-1,poll.y,poll.m+1});
            cur.push({poll.x,poll.y-1,poll.m+1});
        }
    }
    cout<<"-1"<<endl;
    return 0;
    out1:
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++)valid[i][j]=false;
    }
    cur = queue<mov>();
    cur.push({b.x,b.y,0});
    while(!cur.empty()){
        mov poll = cur.front();
        if(poll.x==c.x&&poll.y==c.y){
            moves+=poll.m;
            goto out2;
        }
        cur.pop();
        if(poll.x>-1&&poll.x<n&&poll.y>-1&&poll.y<m&&!valid[poll.x][poll.y]&&board[poll.x][poll.y]!='#'){
            valid[poll.x][poll.y]=true;
            cur.push({poll.x+1,poll.y,poll.m+1});
            cur.push({poll.x,poll.y+1,poll.m+1});
            cur.push({poll.x-1,poll.y,poll.m+1});
            cur.push({poll.x,poll.y-1,poll.m+1});
        }
    }
        cout<<"-1"<<endl;
        return 0;
        out2:
    cout<<moves<<endl;
}