//{ Driver Code Starts
// driver code

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int min_sprinklers(int gallery[], int n) {
        vector<pair<int, int>> vec;
        
        for(int i = 0; i < n; i++) {
            if(gallery[i] == -1) 
                continue;
            
            int left  = max(0, i-gallery[i]);
            int right = min(n-1, i+gallery[i]);
            
            vec.push_back({left, right});
        }
        
        sort(begin(vec), end(vec));
        
        int count    = 0;
        int i        = 0;
        int target   = 0;
        
        while(target < n) {
            
            int maxEnd = -1;
            while(i < vec.size()) {
                if(vec[i].first > target)
                    break;
                
                maxEnd = max(maxEnd, vec[i].second);
                i++;
            }
            
            if(maxEnd < target) {
                return -1;
            }
            
            count++;
            target = maxEnd + 1;
        }
        
        return count;
    }
};


//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        
        int gallery[n];
        for(int i=0; i<n; i++)
            cin>> gallery[i];
        Solution obj;
        cout<< obj.min_sprinklers(gallery,n) << endl;
    }
	return 1;
}

// } Driver Code Ends