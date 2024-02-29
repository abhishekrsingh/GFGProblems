//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



// } Driver Code Ends
class Solution{
  public:
    int findUnique(int a[], int n, int k) {
        // Create a count array to store count of
        // numbers that have a particular bit set.
        // count[i] stores count of array elements
        // with i-th bit set.
        int INT_SIZE = 8 * sizeof(unsigned int);
        int count[INT_SIZE];
        memset(count, 0, sizeof(count));
    
        // AND(bitwise) each element of the array
        // with each set digit (one at a time)
        // to get the count of set bits at each
        // position
        for (int i = 0; i < INT_SIZE; i++)
            for (int j = 0; j < n; j++)
                if ((a[j] & (1 << i)) != 0) count[i] += 1;
    
        // Now consider all bits whose count is
        // not multiple of k to form the required
        // number.
        unsigned res = 0;
        for (int i = 0; i < INT_SIZE; i++) res += (count[i] % k) * (1 << i);
        return res;
    }

};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int a[n], i;
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution obj;
        cout << obj.findUnique(a, n, k) << endl;
    }
}
// } Driver Code Ends