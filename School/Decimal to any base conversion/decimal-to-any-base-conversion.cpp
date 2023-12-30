//{ Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
class Solution
{
public:
    // To return char for a value. For example '2'
    // is returned for 2. 'A' is returned for 10. 'B'
    // for 11
    char reVal(int num)
    {
        if (num >= 0 && num <= 9)
            return (char)(num + '0');
        else
            return (char)(num - 10 + 'A');
    }
    
   
 
    string getNumber(int B, int N)
    {
        int index = 0;  // Initialize index of result
        string res;
        // Convert input number is given base by repeatedly
        // dividing it by base and taking remainder
        while (N > 0)
        {
            res.push_back(reVal(N % B));
            N /= B;
        }
        
        // Reverse the result
        reverse(res.begin(),res.end());
     
        return res;
    }
};



//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int B,N;
        cin>>B>>N;
        Solution ob;
        string ans  = ob.getNumber(B,N);
        cout<<ans<<endl;
    }
    return 0;
}
// } Driver Code Ends