//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
  public:
    // string smallestNumber(string num)
    // {
    //     int n = num.size();
    //     int rightMin[n], right;
     
    //     // for the rightmost digit, there
    //     // will be no smaller right digit
    //     rightMin[n - 1] = -1;
     
    //     // index of the smallest right digit
    //     // till the current index from the
    //     // right direction
    //     right = n - 1;
     
    //     // traverse the array from second
    //     // right element up to the left
    //     // element
    //     for (int i = n - 2; i >= 1; i--) {
    //         // if 'num[i]' is greater than
    //         // the smallest digit encountered
    //         // so far
    //         if (num[i] >= num[right])
    //             rightMin[i] = right;
     
    //         else {
    //             // for cases like 120000654 or 1000000321
    //             // rightMin will be same for all 0's
    //             // except the first from last
    //             if (num[i] == num[i + 1]) {
    //                 rightMin[i] = right;
    //             }
    //             else {
    //                 rightMin[i] = -1;
    //                 right = i;
    //             }
    //         }
    //     }
     
    //     // special condition for the 1st digit so that
    //     // it is not swapped with digit '0'
    //     int small = -1;
    //     for (int i = 1; i < n; i++)
    //         if (num[i] != '0') {
    //             if (small == -1) {
    //                 if (num[i] < num[0])
    //                     small = i;
    //             }
    //             else if (num[i] <= num[small])
    //                 small = i;
    //         }
     
    //     if (small != -1)
    //         swap(num[0], num[small]);
     
    //     else {
    //         // traverse the 'rightMin[]' array from
    //         // 2nd digit up to the last digit
    //         for (int i = 1; i < n; i++) {
    //             // if for the current digit, smaller
    //             // right digit exists, then swap it
    //             // with its smaller right digit and
    //             // break
    //             if (rightMin[i] != -1 && num[i] != num[rightMin[i]]) {
    //                 // performing the required
    //                 // swap operation
    //                 swap(num[i], num[rightMin[i]]);
    //                 break;
    //             }
    //         }
    //     }
     
    //     // required smallest number
    //     return num;
    // }
    
    
    string smallestNumber(string num) {
    int n = num.size();
    int rightMin[n], right;

    // For the rightmost digit, there
    // will be no smaller right digit
    rightMin[n - 1] = -1;

    // Index of the smallest right digit
    // till the current index from the
    // right direction
    right = n - 1;

    // Traverse the array from the second
    // right element up to the left element
    for (int i = n - 2; i >= 1; i--) {
        // If 'num[i]' is greater than
        // the smallest digit encountered
        // so far
        if (num[i] >= num[right])
            rightMin[i] = right;

        else {
            // For cases like 120000654 or 1000000321
            // rightMin will be the same for all 0's
            // except the first from last
            if (num[i] == num[i + 1]) {
                rightMin[i] = right;
            }
            else {
                rightMin[i] = -1;
                right = i;
            }
        }
    }

    // Special condition for the 1st digit so that
    // it is not swapped with digit '0'
    int small = -1;
    for (int i = 1; i < n; i++)
        if (num[i] != '0') {
            if (small == -1) {
                if (num[i] < num[0])
                    small = i;
            }
            else if (num[i] <= num[small])
                small = i;
        }

    if (small != -1)
        swap(num[0], num[small]);

    else {
        // Traverse the 'rightMin[]' array from
        // 2nd digit up to the last digit
        for (int i = 1; i < n; i++) {
            // If for the current digit, a smaller
            // right digit exists, then swap it
            // with its smaller right digit and
            // break
            if (rightMin[i] != -1 && num[i] != num[rightMin[i]]) {
                // Performing the required
                // swap operation
                swap(num[i], num[rightMin[i]]);
                break;
            }
        }
    }

    // Required smallest number
    return num;
}
 
};

//{ Driver Code Starts.
int main(){
    int t;
    cin >> t;
    while(t--){
       string s;
       cin >> s;
       Solution ob;
       cout <<ob.smallestNumber(s) << endl;
    }
return 0;
}


// } Driver Code Ends