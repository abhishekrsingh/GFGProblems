//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // As the input strings can only have lowercase 
    // characters, the maximum characters will be 26
    const int MAX_CHAR = 26;  
    // Function is to check whether two strings are anagram of each other or not.
    bool areAnagrams(string& s1, string& s2) {
        vector<int> freq(MAX_CHAR, 0);
    
        // Count frequency of each character in string s1
        for(char ch: s1) 
            freq[ch - 'a']++;
      
        // Count frequency of each character in string s2
        for(char ch: s2) 
            freq[ch - 'a']--;
      
        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) 
                return false;
        }
        
        return true;
    }
};

//{ Driver Code Starts.

int main() {

    int t;

    cin >> t;

    while (t--) {
        string c, d;

        cin >> c >> d;
        Solution obj;
        if (obj.areAnagrams(c, d))
            cout << "true" << endl;
        else
            cout << "false" << endl;
        cout << "~" << endl;
    }
}

// } Driver Code Ends