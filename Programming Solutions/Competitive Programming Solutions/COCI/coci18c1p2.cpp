#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int N,up=0,cnt=0;
vector<int> adj[100000];
unordered_map<string,int> m;
string a[50000],b[50000];
bool num[100000]={false},visited[100000]={false};
queue<int> q;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i = 0; i<N; i++)cin>>a[i];
    for(int i = 0; i<N; i++)cin>>b[i];
    for(int i = 0; i<N; i++){
        if(m.count(a[i])==0){
            if(isdigit(a[i][0])!=0)num[up]=true;
            m.insert({a[i],up++});
        }
        if(m.count(b[i])==0){
            if(isdigit(b[i][0])!=0)num[up]=true;
            m.insert({b[i],up++});
        }
        adj[m[a[i]]].push_back(m[b[i]]);
        adj[m[b[i]]].push_back(m[a[i]]);
    }
    for(int i = 0; i<up; i++){
        if(visited[i])continue;
        q.push(i);
        while(!q.empty()){
            int poll = q.front();
            q.pop();
            if(!visited[poll]){
                visited[poll]=true;
                if(num[poll])cnt++;
                for(int j : adj[poll])q.push(j);
            }
        }
        if(cnt>1){
            cout<<"NE\n";
            return 0;
        }
        cnt=0;
    }
    cout<<"DA\n";
}