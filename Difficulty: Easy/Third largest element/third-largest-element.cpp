//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int thirdLargest(vector<int> &arr) {
        int n = arr.size();
        /* There should be atleast three elements */
        if (n < 3) 
        { 
            return -1; 
        } 
      
        // Initialize first, second and third Largest element 
        int first = arr[0], second = INT_MIN, third = INT_MIN; 
      
        // Traverse array elements to find the third Largest 
        for (int i = 1; i < n ; i ++) 
        { 
            /* If current element is greater than first, 
              then update first, second and third */
            if (arr[i] > first) 
            { 
                third  = second; 
                second = first; 
                first  = arr[i]; 
            } 
      
            /* If arr[i] is in between first and second */
            else if (arr[i] > second) 
            { 
                third = second; 
                second = arr[i]; 
            } 
      
            /* If arr[i] is in between second and third */
            else if (arr[i] > third) 
                third = arr[i]; 
        } 
        return third;
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input); // Read the entire line for the array elements
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        cout << ob.thirdLargest(arr) << endl;
        cout << "~" << endl;
    }

    return 0;
}

// } Driver Code Ends