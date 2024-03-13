//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
/*You are required to complete this method */

class Solution{
  public:
    vector<int> matrixDiagonally(vector<vector<int>>&mat)
    {
        int n = mat.size();
        vector<int> adj[n+n-1];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                adj[i + j].push_back(mat[i][j]);
            }
        }
        
        vector<int> res;
        for(int i=0; i<n+n-1; i++) {
            if(i % 2 == 0)
                reverse(adj[i].begin(), adj[i].end());
            for(auto x: adj[i])
                res.push_back(x);
        }
        
        return res;
    }
};


//{ Driver Code Starts.
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n;
        int k=0;
        //cin>>k;
        cin>>n;
        vector<vector<int>>mat(n, vector<int>(n));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                cin >> mat[i][j];
            }
        }
        Solution obj;
        vector<int>ans = obj.matrixDiagonally(mat);
        for(auto i: ans)cout << i << " ";
        cout << "\n";
        
       
    }
}
// } Driver Code Ends