//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
        void sortHalves (int A[], int n)
        {
            // your code here
            int half_i = 0; // starting index of second half 
  
            // Temp Array store sorted resultant array 
            int temp[n]; 
          
            // First Find the point where array is divide 
            // into two half 
            for (int i = 0; i < n - 1; i++) { 
                if (A[i] > A[i + 1]) { 
                    half_i = i + 1; 
                    break; 
                } 
            } 
          
            // If Given array is all-ready sorted 
            if (half_i == 0) 
                return; 
          
            // Merge two sorted arrays in single sorted array 
            int i = 0, j = half_i, k = 0; 
            while (i < half_i && j < n) { 
                if (A[i] < A[j]) 
                    temp[k++] = A[i++]; 
                else
                    temp[k++] = A[j++]; 
            } 
          
            // Copy the remaining elements of A[i to half_! ] 
            while (i < half_i) 
                temp[k++] = A[i++]; 
          
            // Copy the remaining elements of A[ half_! to n ] 
            while (j < n) 
                temp[k++] = A[j++]; 
          
            for (int i = 0; i < n; i++) 
                A[i] = temp[i]; 
        }
};

//{ Driver Code Starts.

int main ()
{
    int t; cin >> t;
    while (t--)
    {
        int n; cin >> n;
		int arr[n];

		for (int i = 0; i < n; ++i)
			cin >> arr[i];
        
        Solution ob;
        
		ob.sortHalves (arr, n);
		for (int i = 0; i < n; ++i)
			cout << arr[i] << " ";
		cout << endl;
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends