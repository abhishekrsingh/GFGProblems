//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends


class Solution
{   
    public:
    //Function for finding determinant of matrix.
    int solve(vector<vector<int>> &mat, int n)
    {
        if(n == 2)
        {
            return (mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0]);
        }
        int sum = 0;
        for(int i = 0; i < mat[0].size(); i++)
        {
            int mul = 1;
            if(i % 2 == 1)
            {
                mul = -1;
            }
            
            // Forming the submatrix
            vector<vector<int>> submatrix;
            for(int t1 = 1; t1 < n; t1++)
            {
                vector<int> v;
                for(int t2 = 0; t2 < mat[0].size(); t2++)
                {
                    if(t2 != i)
                    {
                        v.push_back(mat[t1][t2]);
                    }
                }
                submatrix.push_back(v);
            }
            
            sum += mul * mat[0][i] * solve(submatrix, n-1);
        }
        return sum;
    }
    
    public:
    //Function for finding determinant of matrix.
    int determinantOfMatrix(vector<vector<int> > matrix, int n)
    {
        if(n == 1)
        {
            return matrix[0][0];
        }
        if(n == 2)
        {
            return (matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]);
        }
        return solve(matrix, n);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    
    while(t--) 
    {
        int n;
        cin>>n;
        vector<vector<int> > matrix(n); 

        for(int i=0; i<n; i++)
        {
            matrix[i].assign(n, 0);
            for( int j=0; j<n; j++)
            {
                cin>>matrix[i][j];
            }
        }

        Solution ob;
        int result = ob.determinantOfMatrix(matrix, n);
        cout<<result<<endl;
    }
    return 0;
}
// } Driver Code Ends