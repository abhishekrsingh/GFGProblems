//{ Driver Code Starts
//Initial function template for C++

#include<bits/stdc++.h>
using namespace std;
#define ll long long 

// } Driver Code Ends
//User function template for C++

class Solution{
    public:

    //Function to check if two arrays are equal or not.
    bool check(vector<ll> A, vector<ll> B, int n) {
        // Create an unordered_map to store the frequency of elements in array A
        unordered_map<ll,ll> umap;
        
        // Count the frequency of each element in array A
        for(int i=0;i<n;i++)
            umap[A[i]]++;
        
        // Iterate through each element in array B
        for(int i=0;i<n;i++){
            // Get the current element of array B
            ll key = B[i];
            
            // Check if the current element of array B exists in array A
            if(umap.find(key) != umap.end()){
                // If the element exists in array A, decrement its frequency
                auto itr = umap.find(key);
                
                // If the frequency is greater than 0, decrement it
                if(itr->second > 0)
                    itr->second--;
                // If the frequency is already 0, return false as we can't decrement further
                else
                    return false;
            }
            // If the element doesn't exist in array A, return false
            else
                return false;
        }
        
        // If all elements of array B are found in array A with sufficient frequency, return true
        return true;
    }
};

//{ Driver Code Starts.
int main()
 {
    int t;
    cin>>t;
    while(t--) {
        int n;
        cin>>n;
        
        vector<ll> arr(n,0),brr(n,0);
        
        // increase the count of elements in first array
        for(ll i=0;i<n;i++)
            cin >> arr[i];
        
        
        // iterate through another array
        // and decrement the count of elements
        // in the map in which frequency of elements
        // is stored for first array
        for(ll i=0;i<n;i++)
            cin >> brr[i];
        Solution ob;
        cout << ob.check(arr,brr,n) << "\n";
    }
	return 0;
}
// } Driver Code Ends