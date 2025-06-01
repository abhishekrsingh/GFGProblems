class Solution {
  public:
    int countPairs(vector<vector<int> >& mat1, vector<vector<int> >& mat2, int x) {
        int n = mat1.size();

        int i = 0;              // pointer for mat1 (from start)
        int j = n * n - 1;      // pointer for mat2 (from end)

        int count = 0;

        while (i <= n * n - 1 && j >= 0) {
            int a = mat1[i / n][i % n];  // Convert 1D index to 2D for mat1
            int b = mat2[j / n][j % n];  // Convert 1D index to 2D for mat2

            int sum = a + b;

            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++; // Need bigger sum
            } else {
                j--; // Need smaller sum
            }
        }

        return count;
    }
};