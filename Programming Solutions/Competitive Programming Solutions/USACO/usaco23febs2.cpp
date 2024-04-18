#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct p{long long r,c,t;};
bool cmpP(p a, p b){return a.t<b.t;}
int G,N,a,b,c,l,h,m,innocent=0;
vector<p> grazings;
bool able(p a, long long r, long long c, long long t){
    return (a.t-t)*(a.t-t)>=(a.r-r)*(a.r-r)+(a.c-c)*(a.c-c);
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>G>>N;
    for(int i = 0; i<G; i++){
        cin>>a>>b>>c;
        grazings.push_back({a,b,c});
    }
    sort(grazings.begin(), grazings.end(), cmpP);
    for(int i = 0; i<N; i++){
        cin>>a>>b>>c;
        l=0;
        h=G-1;
        while(l<=h){
            m=(l+h)/2;
            if(grazings[m].t>=c)h=m-1;
            else l=m+1;
        }
        int point = h+1;
        if(point==0&&!able(grazings[0],a,b,c))innocent++;
        else if(point==G&&!able(grazings[G-1],a,b,c))innocent++;
        else if(point!=0&&point!=G&&!able(grazings[point-1],a,b,c)||!able(grazings[point],a,b,c))innocent++;
    }
    cout<<innocent<<"\n";
}