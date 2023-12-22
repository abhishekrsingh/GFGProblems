//{ Driver Code Starts


#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
  public:
    int subArraySum(int arr[], int n, int sum)
    {
    	// Create a prefix sum array to store cumulative sums
        unordered_map<int, int> prefixSum;
        
        int currentSum = 0; // To store the current sum of elements
        
        int count = 0; // To store the count of subarrays with the given sum
        
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            
            // If the current sum is equal to the target sum, increment count
            if (currentSum == sum) {
                count++;
            }
            
            // If there is a subarray with sum (currentSum - sum), increment count
            if (prefixSum.find(currentSum - sum) != prefixSum.end()) {
                count += prefixSum[currentSum - sum];
            }
            
            // Increment the count of current sum in the prefix sum array
            prefixSum[currentSum]++;
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
	    int n,sum=0;
	    cin>>n;
	    int arr[n];
	    for(int i=0;i<n;i++)
	    cin>>arr[i];
	    cin>>sum;
	    Solution ob;
	    cout<<ob.subArraySum(arr, n, sum);
	    cout<<'\n';
	}
	return 0;
}
// } Driver Code Ends