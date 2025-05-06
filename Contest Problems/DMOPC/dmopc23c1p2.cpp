#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,board[2050][2050]={0};
bool visited[2050][2050]={0};
void r(int i, int j){
    if(visited[i][j]||i<0||j<0||i>2000||j>2000)return;
    visited[i][j]=true;
    board[i][j]=1;
    board[i+1][j]=1;
    board[i][j+1]=1;
    board[i+1][j+1]=1;
    r(i+5,j);
    r(i,j+5);
}
void r2(int i, int j){
    if(visited[i][j]||i<0||j<0||i>2000||j>2000)return;
    visited[i][j]=true;
    board[i][j]=1;
    r2(i+5,j);
    r2(i,j+5);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    r(2,2);
    r2(0,0);
    //9,10,11
    //8,12
    if(N%5==2){
        for(int i = 2; i<N; i+=5)board[N-2][i]=1;
        for(int i = 2; i<N; i+=5)board[i][N-2]=1;
        for(int i = 3; i<N; i+=5)board[N-2][i]=1;
        for(int i = 3; i<N; i+=5)board[i][N-2]=1;
        board[N-1][N-1]=1;
        //for(int i = 0; i<N; i++)if(i!=1&&i%4!=0)board[N-2][i]=1;
        //for(int i = 0; i<N; i++)if(i!=1&&i%4!=0)board[i][N-2]=1;
    }
    else if(N%5==3){
        for(int i = 2; i<N; i+=5)board[N-2][i]=1;
        for(int i = 2; i<N; i+=5)board[i][N-2]=1;
        for(int i = 3; i<N; i+=5)board[N-2][i]=1;
        for(int i = 3; i<N; i+=5)board[i][N-2]=1;
        for(int i = 0; i<N; i++)board[N-3][i]=0;
        for(int i = 0; i<N; i++)board[i][N-3]=0;
        board[N-1][N-2]=0;
        board[N-2][N-1]=0;
        board[N-3][N-3]=1;
        board[N-3][0]=0;
        board[0][N-3]=0;
        board[N-2][N-2]=1;
        //for(int i = 0; i<N; i++)if(i!=1&&i%4!=0)board[N-2][i]=1;
        //for(int i = 0; i<N; i++)if(i!=1&&i%4!=0)board[i][N-2]=1;
    }
    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++)cout<<board[i][j]<<" ";
        cout<<"\n";
    }
}