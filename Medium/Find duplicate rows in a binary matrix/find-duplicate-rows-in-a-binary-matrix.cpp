//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

// } Driver Code Ends
//User function Template for C++

class Solution
{   
    public:
    // vector<int> repeatedRows(vector<vector<int>> matrix, int M, int N) 
    // { 
    //     // Your code here
    //     vector<int> ans;
    //     unordered_map<string,int> mm;
    //     for(int i=0;i<M;i++){
    //         string temp="";
    //         for(int j=0;j<N;j++){
    //             if(matrix[i][j])temp+='1';
    //             else temp+='0';
    //         }
    //         if(mm[temp]){
    //             ans.push_back(i);
    //         }
    //         else{
    //             mm[temp]=1;
    //         }
    //     }
    //     return ans;
    // } 
    
    
    vector<int> repeatedRows(vector<vector<int>> &matrix, int M, int N) 
    { 
        vector<int> ans;  // Vector to store the indices of repeated rows
        set<vector<int>> st;  // Set to store unique rows using vector<int>
    
        // Loop through each row of the matrix
        for(int i = 0; i < M; i++) {
            // Check if the current row is already in the set (indicating repetition)
            if(st.find(matrix[i]) != st.end()) {
                ans.push_back(i);  // If yes, add the index of the current row to the ans vector.
            } else {
                st.insert(matrix[i]);  // If no, insert the current row into the set to keep track of unique rows.
            }
        }
    
        return ans;  // Return the vector containing indices of repeated rows.
    }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin>>t;
    while(t--) 
    {
        int row, col;
        cin>> row>> col;
        vector<vector<int> > matrix(row); 
        for(int i=0; i<row; i++)
        {
            matrix[i].assign(col, 0);
            for( int j=0; j<col; j++)
            {
                cin>>matrix[i][j];
            }
        }
        
        Solution ob;
        vector<int> ans = ob.repeatedRows(matrix, row, col);


        for (int i = 0; i < ans.size(); ++i)
        {
            cout<<ans[i]<<" ";
        }
        cout<<endl;
    }
    return 0;
}



// } Driver Code Ends