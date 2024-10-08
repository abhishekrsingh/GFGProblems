//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to reverse words in a given string.
    string reverseWords(string S) 
    { 
        // code here 
        string reversedString = "";
        string currentWord = "";
    
        for(int i = S.length() - 1; i >= 0; i--)
        {
            if(S[i] != '.')
            {
                currentWord = S[i] + currentWord;
            }
            else
            {
                reversedString += currentWord + ".";
                currentWord = "";
            }
        }
    
        reversedString += currentWord;
    
        return reversedString;
    } 
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.reverseWords(s) << endl;
    }
}
// } Driver Code Ends