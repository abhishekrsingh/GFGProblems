class Solution {
    // Helper function to compare cost at mid vs mid + 1
    public boolean check(int[] heights, int[] cost, int mid) {
        long costMid   = 0;
        long costMidP1 = 0;

        for (int i = 0; i < heights.length; i++) {
            costMid   += (long)Math.abs(heights[i] - mid) * cost[i];
            costMidP1 += (long)Math.abs(heights[i] - (mid + 1)) * cost[i];
        }

        return costMid < costMidP1;  // true if mid gives smaller cost than mid+1 (move left)
    }

    public int minCost(int[] heights, int[] cost) {
        // Define search boundaries for binary search
        int low  = Arrays.stream(heights).min().getAsInt();
        int high = Arrays.stream(heights).max().getAsInt();

        int targetH = 0;  // best height found

        while (low <= high) {
            int mid = (low + high) / 2;

            // Move toward the side with lower cost
            if (check(heights, cost, mid)) {
                targetH = mid;
                high    = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Calculate final cost using chosen target height
        long result = 0;
        for (int i = 0; i < heights.length; i++) {
            result += (long)Math.abs(heights[i] - targetH) * cost[i];
        }

        return (int)result;
    }
}
