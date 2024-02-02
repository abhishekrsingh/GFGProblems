//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;
string isDivisibleBy5(string bin);

int main(){
    int t;
    cin >> t;
    while(t--){

        string s;
        cin >> s;
        cout << isDivisibleBy5(s) << endl;

    }

return 0;
}


// } Driver Code Ends


//User function Template for C++

string isDivisibleBy5(string bin){
    // long sum = 0;
    // int j = 0;

    // for (int i = bin.size() - 1; i >= 0; i--) {
    //     int digit = bin[i] - '0';

    //     // Calculate power of 2 without using pow
    //     sum += (digit << j); // equivalent to digit * pow(2, j)
    //     j++;
    // }

    // if (sum % 5 == 0) {
    //     return "Yes";
    // } else {
    //     return "No";
    // }
    
    long long sum = 0;

    for (char digit : bin) {
        sum = (sum << 1) + (digit - '0');
        sum %= 5;
    }

    return (sum == 0) ? "Yes" : "No";
}