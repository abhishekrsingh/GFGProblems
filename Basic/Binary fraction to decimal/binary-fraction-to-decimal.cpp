//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    long double convertToDecimal(string n) {
        // code here
        long double r{ stol( n, nullptr, 2 )};
        n = n.substr( n.find( '.' ) + 1 );
        for ( size_t i{}; i < n.size(); ++i )
            if ( n[ i ]-'0' ) r += 1 / pow( 2, i+1 );
        return r;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string n;
        
        cin>>n;

        Solution ob;
        cout << std::setprecision(100) << ob.convertToDecimal(n) << endl;
    }
    return 0;
}
// } Driver Code Ends