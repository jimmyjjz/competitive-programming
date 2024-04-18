#include <string>
#include <iostream>
#include <climits>
using namespace std;
int main() {
    string s;
    int temp;
    cin >> s >> temp;
    int min = INT_MAX;
    string city = "";
    while(s!="Waterloo"){
        if(temp < min){
            min = temp;
            city = s;
        }
        cin >> s >> temp;
    }
    if(temp < min){
        min = temp;
        city = s;
    }
    cout << city;
}