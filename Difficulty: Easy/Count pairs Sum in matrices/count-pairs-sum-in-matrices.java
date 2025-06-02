class Solution {
    public int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;

        int i = 0;
        int j = (n * n) - 1;

        int count = 0;

        while (i <= (n * n) - 1 && j >= 0) {
            int a = mat1[i / n][i % n];  // Convert index to 2D for mat1
            int b = mat2[j / n][j % n];  // Convert index to 2D for mat2

            int sum = a + b;

            if (sum == x) {
                count++;
                i++;
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}