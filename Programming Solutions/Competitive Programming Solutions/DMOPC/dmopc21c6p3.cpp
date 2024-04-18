#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct pos{int x,y;};
int N,M,K;
int board[1501][1501][2]={0};
queue<pos> cur;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
	cin>>N>>M>>K;
    K++;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
                cin>>board[i][j][0];
				if(board[i][j][0]!=0) {
					board[i][j][1]=K;
					cur.push({i-1,j});
					cur.push({i,j-1});
					cur.push({i,j+1});
					cur.push({i+1,j});
				}
			}
		}
		while(!cur.empty()&&--K>0){
			int fixed = cur.size();
			while(fixed-->0){
				pos p = cur.front();
                cur.pop();
				if(p.x<N&&p.y<M&&p.x>=0&&p.y>=0&&board[p.x][p.y][0]==0) {
					int m = INT_MAX;
					if(p.x+1<N&&p.y<M&&p.x+1>=0&&p.y>=0)m=min(m,(board[p.x+1][p.y][1]==K||board[p.x+1][p.y][0]==0)?m:board[p.x+1][p.y][0]);
					if(p.x-1<N&&p.y<M&&p.x-1>=0&&p.y>=0)m=min(m,(board[p.x-1][p.y][1]==K||board[p.x-1][p.y][0]==0)?m:board[p.x-1][p.y][0]);
					if(p.x<N&&p.y+1<M&&p.x>=0&&p.y+1>=0)m=min(m,(board[p.x][p.y+1][1]==K||board[p.x][p.y+1][0]==0)?m:board[p.x][p.y+1][0]);
					if(p.x<N&&p.y-1<M&&p.x>=0&&p.y-1>=0)m=min(m,(board[p.x][p.y-1][1]==K||board[p.x][p.y-1][0]==0)?m:board[p.x][p.y-1][0]);
					board[p.x][p.y][0]=m;
					board[p.x][p.y][1]=K;
					cur.push({p.x+1,p.y});
					cur.push({p.x-1,p.y});
					cur.push({p.x,p.y+1});
					cur.push({p.x,p.y-1});
				}
			}
        }
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)cout<<board[i][j][0]<<" ";
			cout<<"\n";
		}
}