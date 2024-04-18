#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int s,w;
int main() {
    cin.sync_with_stdio(0);
    cin.tie(0);
    cin>>s>>w;
    if((!(s>=20&&s<=23))||(!(w>=6&&w<=9))||(!((24-s+w)>=8&&(24-s+w)<=10)))cout<<"Unhealthy\n";
    else cout<<"Healthy\n";
}