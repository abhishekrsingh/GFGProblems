//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    int binary_to_decimal(string binary) {
        // Code here.
        int decimal = 0;

        // Traverse the binary string from right to left
        for (int i = binary.length() - 1; i >= 0; i--) {
            // If the current bit is '1', add 2^position to the decimal value
            if (binary[i] == '1') {
                decimal += pow(2, binary.length() - 1 - i);
            }
        }
    
        return decimal;
    }
};

//{ Driver Code Starts.
int main() {
    int T;
    cin >> T;
    while (T--) {
        string str;
        cin >> str;
        Solution ob;
        int ans = ob.binary_to_decimal(str);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends