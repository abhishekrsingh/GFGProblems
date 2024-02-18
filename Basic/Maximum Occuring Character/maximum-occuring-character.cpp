//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution
{
    public:
    //Function to find the maximum occurring character in a string.
    char getMaxOccuringChar(string str)
    {
        unordered_map<char, int> umap;
    
        // Count the frequency of each character
        for (char x : str) {
            umap[x]++;
        }
        
        char result = '\0'; // Initialize to null character
        int maxFrequency = 0;
        char smallestChar = 'z' + 1; // Initialize to a character greater than 'z'
        
        // Find the character with the highest frequency
        for (auto& pair : umap) {
            if (pair.second > maxFrequency || (pair.second == maxFrequency && pair.first < smallestChar)) {
                maxFrequency = pair.second;
                smallestChar = pair.first;
                result = pair.first;
            }
        }
        
        return result;
    }

};

//{ Driver Code Starts.

int main()
{
   
    int t;
    cin >> t;
    while(t--)
    {
        string str;
        cin >> str;
    	Solution obj;
        cout<< obj.getMaxOccuringChar(str)<<endl;
    }
}
// } Driver Code Ends