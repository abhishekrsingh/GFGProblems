//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to return k largest elements from an array.
    vector<int> kLargest(int arr[], int n, int k)
    {
        // Priority queue to store the k largest elements
        priority_queue<int, vector<int>, greater<int>> minHeap;
    
        // Iterate through the array
        for (int i = 0; i < n; ++i) {
            // If the heap size is less than k, push the current element
            if (minHeap.size() < k) {
                minHeap.push(arr[i]);
            } 
            // If the current element is greater than the smallest element in the heap,
            // replace the smallest element with the current element
            else if (arr[i] > minHeap.top()) {
                minHeap.pop();
                minHeap.push(arr[i]);
            }
        }
    
        // Store the k largest elements from the heap into a vector
        vector<int> result;
        while (!minHeap.empty()) {
            result.push_back(minHeap.top());
            minHeap.pop();
        }
        
        // Reverse the vector to get the elements in descending order
        reverse(result.begin(), result.end());
    
        return result;
    }
    
    
    // vector<int> kLargest(int arr[], int n, int k)
    // {
    //     // code here
    //     vector<int> v;
    //     sort(arr, arr+n);
    //     for(int i = n-1; i >=n-k; i--)
    //     {
    //         v.push_back(arr[i]);
    //     }
    //     return v;
    // }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin >> t;
    while(t--){
        int n, k;
        cin >> n >> k;
        
        int arr[n];
        for(int i = 0; i < n;i++)
            cin>>arr[i];
        Solution ob;
        vector<int> result = ob.kLargest(arr, n, k);
        for (int i = 0; i < result.size(); ++i)
            cout<<result[i]<<" ";
        cout << endl;
        
    }
    return 0;
}

// } Driver Code Ends