//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution
{
  public:
  
        string reverseWithSpacesIntact (string s)
        {
            // for ( size_t l{}, r{ s.size()-1 }; l < r; )
            //     if      ( s[ l ] == ' ' ) ++l;
            //     else if ( s[ r ] == ' ' ) --r;
            //     else swap( s[ l++ ], s[ r-- ] );
            // return s;
            
            
            
            int len=s.length()-1;
            int i=0;
            while(i<len){
                
                if(s[i]==' ')
                 i++;
                else if(s[len]==' ')
                    len--;
                else {
                    swap(s[i],s[len]);
                
                i++;
                len--;
                }
            }
            return s;
        }
      

};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    cin.ignore ();
    while (t--)
    {
        string s;
        getline (cin, s);
        Solution ob;
        cout << ob.reverseWithSpacesIntact (s) << endl;
    }
    return 0;
}
// Contributed By: Pranay Bansal

// } Driver Code Ends