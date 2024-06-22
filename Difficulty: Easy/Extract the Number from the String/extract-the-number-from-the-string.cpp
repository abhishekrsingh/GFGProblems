//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    long long ExtractNumber(std::string sentence) {
        std::istringstream stream(sentence);
        std::string word;
        std::vector<long long> validNumbers;
    
        // Split the sentence into words
        while (stream >> word) {
            // Check if the word is a number
            bool isNumber = true;
            for (char c : word) {
                if (!isdigit(c)) {
                    isNumber = false;
                    break;
                }
            }
    
            if (isNumber) {
                // Check if the number contains '9'
                if (word.find('9') == std::string::npos) {
                    // Convert to number and store
                    validNumbers.push_back(std::stoll(word));
                }
            }
        }
    
        // Find the maximum number without '9'
        if (validNumbers.empty()) {
            return -1;
        } else {
            return *std::max_element(validNumbers.begin(), validNumbers.end());
        }
    }
};

//{ Driver Code Starts.
int main() {

    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    string tc;
    getline(cin, tc);
    t = stoi(tc);
    while (t--) {
        string s;
        getline(cin, s);

        Solution ob;
        cout << ob.ExtractNumber(s) << "\n";
    }

    return 0;
}

// } Driver Code Ends