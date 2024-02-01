//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution
{
  public:
    //Function to check if a string is Pangram or not.
    bool checkPangram (string &str) {
        // your code here
        // Create a hash table to mark the characters
        // present in the string
        vector<bool> mark(26, false);
        // For indexing in mark[]
        int index;
        // Traverse all characters
        for (int i = 0; i < str.length(); i++) {
            // If uppercase character, subtract 'A'
            // to find index.
            if ('A' <= str[i] && str[i] <= 'Z')
                index = str[i] - 'A';
            // If lowercase character, subtract 'a'
            // to find index.
            else if ('a' <= str[i] && str[i] <= 'z')
                index = str[i] - 'a';
            // If this character is other than english
            // lowercase and uppercase characters.
            else
                continue;
            mark[index] = true;
        }
     
        // Return false if any character is unmarked
        for (int i = 0; i <= 25; i++)
            if (mark[i] == false)
                return (false);
        // If all characters were present
        return (true);
        
        //2nd Method
        // Initialize a set of characters
        set<char> set;
     
        for (auto ch : str) {
            // If the character is already
            // a lowercase character
            if (ch >= 'a' and ch <= 'z')
                set.insert(ch);
     
            // In case of a uppercase character
            if (ch >= 'A' and ch <= 'Z') {
                // convert to lowercase
                ch = tolower(ch);
                set.insert(ch);
            }
        }
     
        // check if the size is 26 or not
        return set.size() == 26;
    }

};


//{ Driver Code Starts.

// Driver Program to test above functions
int main()
{
    int t;
    cin>>t;
    cin.ignore(INT_MAX, '\n');
    while(t--){
        string s;
        getline(cin, s);
        Solution obj;
        if (obj.checkPangram(s) == true)
            cout<<1<<endl;
        else
            cout<<0<<endl;
    }
    return(0);
}

// } Driver Code Ends