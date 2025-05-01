//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

/*you are required to complete this method*/
class Solution {
  public:
    int convertFive(int n) {
        // If number is 0, directly return 5
        if (n == 0) return 5;
    
        int result = 0;
        int place = 1;
    
        // Traverse each digit
        while (n > 0) {
            int digit = n % 10; // Get last digit
            if (digit == 0) {
                digit = 5; // Replace 0 with 5
            }
            result += digit * place; // Add digit at the correct place
            place *= 10;
            n /= 10; // Remove last digit
        }
    
        return result;
    }
};


//{ Driver Code Starts.
int main() {
    int T;
    cin >> T;
    while (T--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.convertFive(n) << endl;

        cout << "~"
             << "\n";
    }
}
// } Driver Code Ends