//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to find the first non-repeating character in a string.
    char nonrepeatingCharacter(string arr)
    {
        //Your code here
        std::unordered_map<char, int> umap;

        for (int i = 0; i < arr.length(); i++) {
            umap[arr[i]]++;
        }
    
        for (int i = 0; i < arr.length(); i++) {
            if (umap.find(arr[i]) != umap.end() && umap[arr[i]] <= 1) {
                return arr[i];
            }
        }
    
        return '$'; // or some default value if no non-repeating character is found
       
    }

};

//{ Driver Code Starts.

int main() {
	
	int T;
	cin >> T;
	
	while(T--)
	{
	
	    string S;
	    cin >> S;
	    Solution obj;
        char ans = obj.nonrepeatingCharacter(S);
        
        if(ans != '$')
	    cout << ans;
        else cout << "-1";
            
        cout << endl;
	    
	}
	
	return 0;
}

// } Driver Code Ends