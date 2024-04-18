#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct m{char act; int d;};
int N,H,Hc,He;
char c;
vector<m> charlie,enemy;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>H;
    Hc=H;He=H;
    charlie.push_back({'A',-1});
    enemy.push_back({'A',-1});
    for(int i = 0,d; i<N; i++){
        cin>>c>>d;
        charlie.push_back({c,d});
    }
    for(int i = 0,d; i<N; i++){
        cin>>c>>d;
        enemy.push_back({c,d});
    }
    for(int i = 1; i<=N; i++){
        if(charlie[i].act=='A'&&enemy[i-1].act=='A')He-=charlie[i].d;
        else if(charlie[i].act=='D'&&enemy[i-1].act=='D')He-=enemy[i-1].d;
        if(He<=0){cout<<"VICTORY\n";return 0;}
        else if(Hc<=0){cout<<"DEFEAT\n";return 0;}
        if(charlie[i].act=='A'&&enemy[i].act=='A')Hc-=enemy[i].d;
        else if(charlie[i].act=='D'&&enemy[i].act=='D')Hc-=charlie[i].d;
        if(He<=0){cout<<"VICTORY\n";return 0;}
        else if(Hc<=0){cout<<"DEFEAT\n";return 0;}
    }
    if(enemy[N].act=='D')He-=enemy[N].d;
    if(He<=0){cout<<"VICTORY\n";return 0;}
    else if(Hc<=0){cout<<"DEFEAT\n";return 0;}
    cout<<"TIE\n";
}