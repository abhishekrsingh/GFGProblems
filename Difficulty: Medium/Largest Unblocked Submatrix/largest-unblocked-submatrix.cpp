class Solution {
  public:
    int largestArea(int n, int m, vector<vector<int>> &arr) {
        int count = 0;
        int maxRow = 0;
        int maxCol = 0;
        unordered_set<int> xRows;
        unordered_set<int> xCols;
        
        // Getting blocked rows and cols
        for(vector<int> &a: arr) {
            xRows.insert(a[0]);
            xCols.insert(a[1]);
        }
        
        // Max row, search cols
        for(int i = 1; i <= m; i++) {
            if(xCols.count(i)) {
                maxRow = max(maxRow, count);
                count = 0;
            }
            else {
                count++;
            }
        }
        
        // Last row and reset
        maxRow = max(maxRow, count);
        count = 0;
    
        // Max col, search rows
        for(int i = 1; i <= n; i++) {
            if(xRows.count(i)) {
                maxCol = max(maxCol, count);
                count = 0;
            }
            else {
                count++;
            }
        }
        
        // Last col
        maxCol = max(maxCol, count);
        
        return maxRow * maxCol;
    }
};