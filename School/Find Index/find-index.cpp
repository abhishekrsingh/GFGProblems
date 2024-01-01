//{ Driver Code Starts
#include <iostream>
#include <bits/stdc++.h> 
#include <vector> 
using namespace std; 

// } Driver Code Ends
class Solution
{
  public:
    vector<int> findIndex(int arr[], int n, int key)
    {
        //code here.
        int max_index = -1;
        int min_index = -1;
        for(int i = n-1; i >= 0; i--)
        {
            if(arr[i] == key)
            {
                max_index = i;
                break;
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == key)
            {
                min_index = i;
                break;
            }
        }
        return {min_index, max_index};
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
        vector<int> res;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++)
            cin>>arr[i];
        int key;
        cin>>key;
        Solution ob;
        res=ob.findIndex(arr, n, key);
        for (int i = 0; i < res.size(); i++) 
        cout << res[i] << " ";
        cout << "\n";
    }
    
    return 0;
}

// } Driver Code Ends