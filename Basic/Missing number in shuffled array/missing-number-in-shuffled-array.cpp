//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends


class Solution{
    public:
    // long long findMissing(long long a[], long long b[], int n)
    // {
    //     long long sumA = 0;
    //     long long sumB = 0;
    //     for(int i = 0; i < n; i++)
    //     {
    //         sumA += a[i];
    //     }
    //     for(int i = 0; i < n - 1; i++) // Assuming b[] has one element less than a[]
    //     {
    //         sumB += b[i];
    //     }
    //     return sumA - sumB;
    // }
    
    long long findMissing(long long a[], long long b[], int n)
    {
        long long suma=0;
        
        // XOR operation to calculate the sum of elements in array a
        for(int i=0;i<n;i++){
          suma^=a[i];
        }
    
        // XOR operation to calculate the sum of elements in array b
        for(int i=0;i<n-1;i++){
          suma^=b[i];
        }
    
        // Return the missing element
        return suma;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        long long a[n], b[n-1];

        for(int i=0;i<n;i++){
          cin>>a[i];
        }
        for(int i=0;i<n-1;i++){
          cin>>b[i];
        }
        Solution ob;
        cout<<ob.findMissing(a, b, n)<<endl;
    }
}


// } Driver Code Ends