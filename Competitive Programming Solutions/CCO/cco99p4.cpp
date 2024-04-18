#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct p{double x,y;};
int N,T;
double total = 0;
vector<p> points,store;
double tempA,tempB;
p anchor={INT_MAX,INT_MAX};
int cw(p a, p b, p c) {
    double d = a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y);
    if(d<0)return 1;
    if(d>0)return -1;
    return 0;
}
double distance(p a, p b){
    return sqrt((b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y));
}
bool cmp(p a, p b){
    int o = cw(anchor, a, b);
    if(o==0)return(anchor.x-a.x)*(anchor.x-a.x)+(anchor.y-a.y)*(anchor.y-a.y)<(anchor.x-b.x)*(anchor.x-b.x)+(anchor.y-b.y)*(anchor.y-b.y);
    return o<0;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int z = 0; z<T; z++){
        points.clear();
        store.clear();
        anchor={INT_MAX,INT_MAX};
        total=0;
        cin>>N;
        for(int i = 0; i<N; i++){
            cin>>tempA>>tempB;
            points.push_back({tempA,tempB});
            if(tempB<anchor.y){
                anchor.y=tempB;
                anchor.x=tempA;
            }
            else if(tempB==anchor.y)anchor.x=min(anchor.x,tempA);
        }
        sort(points.begin(), points.end(), cmp);
        for(int i = 0; i<N; i++) {
            while(store.size()>1&&!(cw(store[store.size()-2],store.back(),points[i])<0))store.pop_back();
            store.push_back(points[i]);
        }
        for(int i = 1; i<store.size(); i++)total+=distance(store[i-1],store[i]);
        total+=distance(store[store.size()-1],store[0]);
        cout<<total<<"\n";
    }
}