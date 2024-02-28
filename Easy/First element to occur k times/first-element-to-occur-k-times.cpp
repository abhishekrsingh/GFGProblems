//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
    public:
    int firstElementKTime(int arr[], int n, int k)
    {
        vector<int> v(201, 0); // since a[i] <= 200, we need an array of size 201
        int first = -1;
        for (int i = 0; i < n; i++) {
            v[arr[i]]++;
            if (v[arr[i]] == k && (first == -1 || i < first)) {
                first = i;
            }
        }
        return (first != -1) ? arr[first] : -1;
    }
};

//{ Driver Code Starts.

int main() {
	int t;
	cin >> t;
	while(t--){
	    int n, k;
	    cin >> n >> k;
	    int a[n];
	    for(int i = 0;i<n;i++){
	        cin >> a[i];
	    }
	    Solution ob;
	    cout<<ob.firstElementKTime(a, n, k)<<endl;
	}
	
	return 0;
}
// } Driver Code Ends