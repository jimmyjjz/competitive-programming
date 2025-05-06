#include <bits/stdc++.h>
#include <iostream>
using namespace std;
int main() {
    int fish[3];
    int t;
    cin >> fish[0] >> fish[1] >> fish[2] >> t;
    int a=0,b=0,c=0,total=0;
    while(true){
        while(true){
            while(true){
                c++;
                if((fish[0]*a)+(fish[1]*b)+(fish[2]*c)<=t){
                    cout<<a<<" Brown Trout, "<<b<<" Northern Pike, "<<c<<" Yellow Pickerel"<<endl;
                    total++;
                }
                else break;
            }
            c = 0;
            b++;
            if((fish[0]*a)+(fish[1]*b)<=t){
                cout<<a<<" Brown Trout, "<<b<<" Northern Pike, "<<c<<" Yellow Pickerel"<<endl;
                total++;
            }
            else break;
        }
        b = 0;
        a++;
        if((fish[0]*a)<=t){
            cout<<a<<" Brown Trout, "<<b<<" Northern Pike, "<<c<<" Yellow Pickerel"<<endl;
            total++;
        }
        else break;
    }
    cout<<"Number of ways to catch fish: "<<total;
}