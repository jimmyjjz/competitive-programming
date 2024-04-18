#include <bits/stdc++.h>
#include <iostream>
using namespace std;
struct o{long long c,m,w;};
o orders[105];
long long T,N,C,M,low,high,mid,upC,upM;
long long a,b,c,t,shift;
bool works(long long up){
    upC=min(C-1,up);
    upM=up-upC;
    for(int i = 0; i<N; i++){
        t=(C-upC)*orders[i].c+(M-upM)*orders[i].m;
        if(t<=orders[i].w)continue;
        if(orders[i].c>=orders[i].m)return false;
        shift=(t-orders[i].w)/(orders[i].m-orders[i].c);
        if((t-orders[i].w)%(orders[i].m-orders[i].c)!=0)shift++;
        upC-=shift;
        upM+=shift;
        if(!((C-upC)>0&&upC>=0&&(M-upM)>0&&upM>=0))return false;
    }
    for(int i = 0; i<N; i++)if(((C-upC)*orders[i].c+(M-upM)*orders[i].m)>orders[i].w)return false;
    //cout<<up<<" "<<upC<<" _ "<<upM<<"\n";
    return true;
}
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>T;
    for(int i = 0; i<T; i++){
        cin>>N>>C>>M;
        for(int j = 0; j<N; j++){
            cin>>a>>b>>c;
            orders[j]={a,b,c};
        }
        low=0;
        high=C+M-2;
        while(low<=high){
            mid=(low+high)/2;
            if(works(mid))high=mid-1;
            else low=mid+1;
        }
        cout<<high+1<<"\n";
    }
}