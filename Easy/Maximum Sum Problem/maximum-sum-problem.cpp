//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
    public:
        int maxSum(int n) {
            // Base case: if n is 0, return 0
            if (n == 0) {
                return 0;
            }
            
            // Create a vector to store maximum sums for each number from 0 to n
            vector<int> maxi(n + 1, 0);
            
            // Iterate from 1 to n
            for (int i = 1; i <= n; ++i) {
                // Calculate the maximum sum for current 'i' based on the condition
                maxi[i] = max(i, maxi[i / 2] + maxi[i / 3] + maxi[i / 4]);
                // The maximum sum at i is either i itself or the sum of max(i/2), max(i/3), and max(i/4)
            }
            
            // Return the maximum sum for n
            return maxi[n];
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
        Solution ob;
        cout<<ob.maxSum(n)<<"\n";
    }
    return 0;
}
// } Driver Code Ends