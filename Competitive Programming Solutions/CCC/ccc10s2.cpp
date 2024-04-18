#include <string>
#include <iostream>
#include <iterator>
#include <map>
using namespace std;
int main() {
    map<string, string> swap;
    int n;
    cin >> n;
    for(int i = 0; i<n; i++){
        string a,b;
        cin >> a >> b;
        swap.insert(pair<string, string>(b,a));
    }
    string encoded;
    cin >> encoded;
    int len = encoded.length();
    string current = "";
    for(int i = 0; i<len; i++){
        current+=encoded[i];
        if(swap.find(current)!=swap.end()){
            cout<<swap.find(current)->second;
            current = "";
        }
    }
}