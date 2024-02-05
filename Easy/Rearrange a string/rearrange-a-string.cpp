//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
  public:
    // string arrangeString(string str)
    // {
    //     string st = "";
    //     int sum = 0;
    //     sort(str.begin(), str.end());
    //     for(int i = 0; i < str.length(); i++)
    //     {
    //         if ('A' <= str[i] && str[i] <= 'Z')
    //             st += str[i];
    //         else
    //             sum += str[i] - '0';
    //     }
    //     string result = to_string(sum);
    //     if(sum == 0)
    //     {
    //         return st;
    //     }else{
    //         return st+result;
    //     }
    // }
    
    string arrangeString(string str) {
        // Variables to store alphabets and the sum of digits
        string alphabets = "";
        int sum = 0;
    
        // Sort the input string
        sort(str.begin(), str.end());
    
        // Traverse the sorted string
        for(int i = 0; i < str.length(); i++) {
            // If the character is an uppercase alphabet, add it to the alphabets string
            if ('A' <= str[i] && str[i] <= 'Z') {
                alphabets += str[i];
            } else {
                // If the character is a digit, add its numeric value to the sum
                sum += str[i] - '0';
            }
        }
    
        // Convert the sum to a string
        string result = to_string(sum);
    
        // If the sum is 0, return only the alphabets, otherwise concatenate the sum to the alphabets
        if(sum == 0) {
            return alphabets;
        } else {
            return alphabets + result;
        }
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
        cout <<ob.arrangeString(s) << endl;
    }
return 0;
}


// } Driver Code Ends