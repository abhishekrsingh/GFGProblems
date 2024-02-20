//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
  public:
    int thirdLargest(int arr[], int n)
    {
        // if(n < 3) return -1;
        // sort(arr, arr+n);
        // int third = arr[n-3];
        // return third;
        
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
 
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++)
	        cin>>a[i];
	   Solution obj;
	    cout<<obj.thirdLargest(a,n)<<endl;
    }
}   
// } Driver Code Ends