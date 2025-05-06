#include <bits/stdc++.h>
#include <iostream>
using namespace std;
double x11,y11,x21,y21,x12,y12,x22,y22;
int main() {
    cin>>x11>>y11>>x21>>y21>>x12>>y12>>x22>>y22;
    if(((y21-y11)*(x12-x11)==(y12-y11)*(x21-x11))&&((y21-y11)*(x22-x12)==(y22-y12)*(x21-x11)))cout<<"coincident\n";
    else if((y21-y11)*(x22-x12)==(y22-y12)*(x21-x11))cout<<"parallel\n";
    else if(x11==x21)cout<<setprecision(7)<<x11<<" "<<setprecision(7)<<(y22-y12)/(x22-x12)*(x11-x12)+y12<<"\n";
    else if(x12==x22)cout<<setprecision(7)<<x12<<" "<<setprecision(7)<<(y21-y11)/(x21-x11)*(x12-x12)+y11<<"\n";
    else cout<<setprecision(7)<<((y12-y11)+(x11*(y21-y11)/(x21-x11))-((y22-y12)/(x22-x12)*x12))/((y21-y11)/(x21-x11)-(y22-y12)/(x22-x12))<<" "<<setprecision(7)<<(y21-y11)/(x21-x11)*(((y12-y11)+(x11*(y21-y11)/(x21-x11))-((y22-y12)/(x22-x12)*x12))/((y21-y11)/(x21-x11)-(y22-y12)/(x22-x12))-x11)+y11<<"\n";
}