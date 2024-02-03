//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
  public:
    int isdivisible7(string bin) {
        long long sum = 0;

        for (int i = 0; i < bin.size(); i++) {
            if (isdigit(bin[i])) {
                int digit = bin[i] - '0';
                sum = (sum * 10 + digit) % 7;
            }
        }
    
        return (sum == 0) ? 1 : 0;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        Solution ob;
        cout << ob.isdivisible7(s) << endl;
    }
    return 0;
}
// } Driver Code Ends