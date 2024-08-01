//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> spirallyTraverse(vector<vector<int> > &matrix) {
vector<int>ans;
        int m= matrix.size();
        int n=matrix[0].size();
        int total_elements = m*n;

        int startingRow  = 0;
        int endingCol = n-1;
        int endingRow = m-1;
        int startingCol = 0;

        int count = 0;
        while(count < total_elements){

            // print  startingRow 
            for(int i= startingCol; i<= endingCol && count<total_elements; i++){
                ans.push_back(matrix[startingRow][i]);
                count++;

            }
            startingRow++;

            //printing endingCol
            for(int i=startingRow; i<=endingRow && count<total_elements;i++){
                ans.push_back(matrix[i][endingCol]);
                count++;
            }
            endingCol--;

            // printing endingRow

            for(int i=endingCol; i>=startingCol && count<total_elements;i--){
                ans.push_back(matrix[endingRow][i]);
                count++;
            }
            endingRow--;

            // printing startingCol

            for(int i=endingRow; i>= startingRow && count<total_elements;i--){
                ans.push_back(matrix[i][startingCol]);
                count++;
            }
            startingCol++;


        }
         
        return ans;
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int r, c;
        cin >> r >> c;
        vector<vector<int>> matrix(r, vector<int>(c, 0));

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                cin >> matrix[i][j];
            }
        }

        Solution ob;
        vector<int> result = ob.spirallyTraverse(matrix);
        for (int i = 0; i < result.size(); ++i)
            cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends