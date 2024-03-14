//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int largestSubsquare(int n, vector<vector<char>> a) {
        vector<vector<int>> v(n,vector<int>(n,0));
        
        // col
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=n-1;j>=0;j--)
            {
                if(a[i][j]=='O')
                {
                    sum=0;
                    v[i][j]=0;
                }
                else
                {
                    sum++;
                    v[i][j]=sum;
                }
            }
        }
        
        // rows
        int maxi=10002;
        for(int j=0;j<n;j++)
        {
            int sum=0;
            for(int i=n-1;i>=0;i--)
            {
                if(a[i][j]=='O')
                sum=0;
                else
                {
                    sum++;
                    int ori=v[i][j];
                    int ne=maxi*sum;
                    v[i][j]=(ne+ori);
                }
            }
        }
        
        
        //finding max submatrix
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(a[i][j]=='O')
                continue;
                
                int maxCol=v[i][j]%maxi;
                int maxRow=v[i][j]/maxi;
                
                int size=min(maxCol,maxRow);
                
                while(size>ans)
                {
                    if((v[i+size-1][j]%maxi)>=size and (v[i][j+size-1]/maxi)>=size)
                    ans=size;
                    
                    size--;
                }
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<char>> a(n, vector<char>(n));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) cin >> a[i][j];
        }
        Solution ob;
        cout << ob.largestSubsquare(n, a) << "\n";
    }
}
// } Driver Code Ends