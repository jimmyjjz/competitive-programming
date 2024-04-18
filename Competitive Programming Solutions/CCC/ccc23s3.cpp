#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,M,R,C;
char board[2000][2000];
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M>>R>>C;
    if(R==0&&C==0){
        for(int i = 1; i<N; i++){
            for(int j = 1; j<M; j++)cout<<"a";
            cout<<"b\n";
        }
        for(int j = 1; j<M; j++)cout<<"b";
            cout<<"c\n";
        return 0;
    }
    else if(C==0&&R>0&&R!=N){
        memset(board, 'a', sizeof(board));
        for(int i = 0; i<N-R; i++){
            for(int j = 0; j<M-1; j++)board[i][j]='b';
            board[i][M-1]='c';
        }
    }
    else if(R==0&&C>0&&C!=M){
        memset(board, 'a', sizeof(board));
        for(int i = 0; i<M-C; i++){
            for(int j = 0; j<N-1; j++)board[j][i]='b';
            board[N-1][i]='c';
        }
    }
    else if(R==N&&M%2){
        memset(board, 'a', sizeof(board));
        for(int i = C%2; i*2<=M-C; i++){
            board[0][M/2-i]='b';
            board[0][M/2+i]='b';
        }
    }
    else if(C==M&&N%2){
        memset(board, 'a', sizeof(board));
        for(int i = R%2; i*2<=N-R; i++){
            board[N/2-i][0]='b';
            board[N/2+i][0]='b';
        }
    }
    else if(R==N&&M%2==0){
        memset(board, 'a', sizeof(board));
        if(C%2){
            cout<<"IMPOSSIBLE";
            return 0;
        }
        for(int l=M/2-1,r=M/2; l>=C/2; l--,r++){
            board[0][l]='b';
            board[0][r]='b';
        }
    }
    else if(C==M&&N%2==0){
        memset(board, 'a', sizeof(board));
        if(R%2){
            cout<<"IMPOSSIBLE";
            return 0;
        }
        for(int l=N/2-1,r=N/2; l>=R/2; l--,r++){
            board[l][0]='b';
            board[r][0]='b';
        }
    }
    else if(R==0&&C==M){
        memset(board, 'a', sizeof(board));
        for(int j = 0; j<M; j++)board[0][j]='b';
    }
    else if(R==N&&C==0){
        memset(board, 'a', sizeof(board));
        for(int j = 0; j<N; j++)board[j][0]='b';
    }
    else if(R>0&&C>0&&R<N&&C<M){
        memset(board, 'b', sizeof(board));
        for(int i = 0; i<R; i++){
            for(int j = 0; j<M; j++)board[i][j]='a';
        }
        for(int i = 0; i<C; i++){
            for(int j = 0; j<N; j++)board[j][i]='a';
        }
    }
    else{
        cout<<"IMPOSSIBLE";
        return 0;
    }
    for(int i = 0; i<N; i++){
        for(int j = 0; j<M; j++)cout<<board[i][j];
        cout<<"\n";
    }
}