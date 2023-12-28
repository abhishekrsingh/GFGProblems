//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

// Complete this function
string isPrime(int n) {
    // Base case: 1 is not a prime number
    if (n == 1) {
        return "No";
    }

    // Loop to check for factors from 2 to the square root of n
    for (int i = 2; i <= sqrt(n); ++i) {
        // If n is divisible by any number in the loop, it is not prime
        if (n % i == 0) {
            return "No";
        }
    }

    // If no factors were found, the number is prime
    return "Yes";
}

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << isPrime(n) << endl;
    }
    return 0;
}
// } Driver Code Ends