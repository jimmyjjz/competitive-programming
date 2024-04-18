#include <bits/stdc++.h>
#include <iostream>
struct pos{int x,y;};
bool Y(pos a, pos b){return a.y<b.y;}
using namespace std;
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>
using namespace __gnu_pbds;
#define ordered_set tree<int, null_type,less<int>, rb_tree_tag,tree_order_statistics_node_update>
int main() {
    int N,M,x,y;
    cin>>N>>M;
    pos roomba[N],cords[M];
    for(int i = 0; i<N; i++){
        cin>>x>>y;
        roomba[i].x=x;
        roomba[i].y=y;
    }
    for(int i = 0; i<M; i++){
        cin>>x>>y;
        cords[i].x=x;
        cords[i].y=y;
    }
    sort(roomba, roomba+N, Y);
    sort(cords, cords+M, Y);
    ordered_set good;
    long long cnt = 0;
    int top = M-1;
    for(int i = N-1; i>=0; i--){
        while(top>=0&&cords[top].y>=roomba[i].y){
            good.insert(cords[top].x);
            top--;
        }
        cnt+=good.order_of_key(roomba[i].x+1);
    }
    cout<<cnt<<endl;
    return 0;
}