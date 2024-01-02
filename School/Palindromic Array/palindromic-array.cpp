//{ Driver Code Starts
#include<iostream>
#include<string.h>
using namespace std;


// } Driver Code Ends
/*Complete the function below*/

class Solution {
public:
    // Function to check if a number is palindrome
    bool isPalindrome(int num) {
        int originalNum = num;
        int reversedNum = 0;
        
        // Reverse the number
        while (num > 0) {
            int digit = num % 10;
            reversedNum = reversedNum * 10 + digit;
            num /= 10;
        }
        
        // Check if the reversed number is equal to the original number
        return originalNum == reversedNum;
    }
    
    // Function to check if all elements of the array are palindromes
    int PalinArray(int a[], int n) {
        // Iterate through each element of the array
        for (int i = 0; i < n; i++) {
            // Check if the current element is not a palindrome
            if (!isPalindrome(a[i])) {
                return 0; // Return 0 if not a palindrome
            }
        }
        
        return 1; // Return 1 if all elements are palindromes
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
		cin>>n;
		int a[n];
		for(int i = 0; i < n; i++)
			cin>>a[i];
		Solution obj;
		cout<<obj.PalinArray(a,n)<<endl;
	}
}
// } Driver Code Ends