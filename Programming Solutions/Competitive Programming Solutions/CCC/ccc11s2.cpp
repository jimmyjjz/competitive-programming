#include <string>
#include <iostream>
using namespace std;
int main() {
    int n;
    cin >> n;
    string s = "";
    for(int i = 0; i<n; i++){
        char c;
        cin >> c;
        s+=c;
    }
    int cnt = 0;
    for(int i = 0; i<n; i++){
        char c;
        cin >> c;
         if(s[i]==c){
             cnt++;
         }
    }
    cout << cnt;
}