class Solution {
    public int numOfWays(int n, int m) {
        // code here
        int totalSquares = n * m;

        // Total ways to place one black and one white knight
        int totalPlacements = totalSquares * (totalSquares - 1);

        // Attacking placements:
        // Every 3×2 rectangle contributes 2 attacking pairs.
        // Since knights are distinguishable (black/white),
        // each pair contributes 2 arrangements => 2 * 2 = 4.

        int attackingPlacements =
       4 * Math.max(0, n - 2) * Math.max(0, m - 1) + // 3×2 rectangles
       4 * Math.max(0, n - 1) * Math.max(0, m - 2);  // 2×3 rectangles

        return totalPlacements - attackingPlacements;
    }
}