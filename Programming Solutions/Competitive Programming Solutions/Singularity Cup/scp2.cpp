#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int N,cnt=1;
deque<char> dq;
string s;
char pre;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>s;
    if(s[0]!=s[N-1]){
        cout<<N<<"\n";
        return 0;
    }
    for(int i = 0; i<N; i++)dq.push_back(s[i]);
    while(!dq.empty()&&dq.front()==s[0])dq.pop_front();
    while(!dq.empty()&&dq.back()==s[0])dq.pop_back();
    pre=s[0];
    while(!dq.empty()){
        pre=dq.front();
        cnt++;
        while(!dq.empty()&&dq.front()==pre)dq.pop_front();
    }
    cout<<cnt<<"\n";
}