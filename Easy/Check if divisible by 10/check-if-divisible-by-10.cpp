//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    //wrong code
    // int isDivisibleBy10(string bin) {
    //     int n = bin.size();
    //     long long int total = 0;
    //     long count = 0; 
    //     for(int i = n-1; i >= 0; i--)
    //     {
    //         int bit = bin[i] - '0'; // Convert character '0' or '1' to integer 0 or 1
    //         total += bit * pow(2, count);
    //         count++;
    //     }
    //     if(total % 10 == 0)
    //     {
    //         return 1;
    //     } else {
    //         return 0;
    //     }
    // }
    
    int isDivisibleBy10(string bin) {
        int remainder = 0;
        
        // Iterate through each binary digit
        for (int i = 0; i < bin.length(); ++i) {
            // Update remainder by shifting and adding current binary digit
            remainder = (remainder * 2 + (bin[i] - '0')) % 10;
        }
        
        // If remainder is 0, then the decimal representation is divisible by 10
        if (remainder == 0)
            return 1;
        else
            return 0;
    }
};

//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        string bin;
        cin >> bin;
        Solution ob;
        cout << ob.isDivisibleBy10(bin);
        cout << endl;
    }
}
// } Driver Code Ends