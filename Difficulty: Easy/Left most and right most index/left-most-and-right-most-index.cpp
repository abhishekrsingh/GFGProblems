//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    public:
    pair<long,long> indexes(vector<long long> arr, long long x)
    {
        pair<long, long> pairIndex = {-1, -1}; 
        int s = 0, e = arr.size() - 1;
    
        // Finding the first occurrence
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == x) {
                pairIndex.first = mid;
                e = mid - 1;  // Continue searching left for the first occurrence
            } else if (arr[mid] > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
    
        s = 0, e = arr.size() - 1;
    
        // Finding the last occurrence
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == x) {
                pairIndex.second = mid;
                s = mid + 1;  // Continue searching right for the last occurrence
            } else if (arr[mid] > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
    
        return pairIndex;
        
    }
};

//{ Driver Code Starts.

int main()
 {
    long long t;
    cin>>t;
    while(t--)
    {
        long long n, k;
        vector<long long>v;
        cin>>n;
        for(long long i=0;i<n;i++)
        {
            cin>>k;
            v.push_back(k);
        }
        long long x;
        cin>>x;
        Solution obj;
        pair<long,long> pair = obj.indexes(v, x);
        
        if(pair.first==pair.second and pair.first==-1)
        cout<< -1 <<endl;
        else
        cout<<pair.first<<" "<<pair.second<<endl;

    
cout << "~" << "\n";
}
	return 0;
}

// } Driver Code Ends