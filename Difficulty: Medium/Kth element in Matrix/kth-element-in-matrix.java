class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        List<Integer> result = new ArrayList<>(); // store all matrix elements

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.add(matrix[i][j]);
            }
        }
        result.sort(null);        // sort ascending
        return result.get(k - 1); // return k-th smallest (1-based)
    }
}