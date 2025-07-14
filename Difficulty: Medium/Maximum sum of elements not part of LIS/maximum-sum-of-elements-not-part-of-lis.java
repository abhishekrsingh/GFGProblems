class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n     = arr.length;                         // number of elements
        int total = 0;                                  // sum of all elements

        for (int v : arr) {
            total += v;
        }

        int[] dp       = new int[n];                    // dp[i] = length of LIS ending at i (min 1)
        int[] dpMinSum = new int[n];                    // dpMinSum[i] = min sum of an LIS of length dp[i] ending at i
        for (int i = 0; i < n; i++) {
            dp[i]       = 1;                            // each element alone is LIS length 1
            dpMinSum[i] = arr[i];                       // sum initialized to the element itself
        }

        int maxLIS    = 1;                              // global max LIS length
        int minLISsum = arr[0];                         // min sum among LIS of length maxLIS

        // build dp[] and dpMinSum[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    int currLen = dp[j] + 1;            // potential new LIS length
                    int currSum = dpMinSum[j] + arr[i]; // corresponding sum

                    if (currLen > dp[i]) {
                        dp[i]       = currLen;          // update LIS length at i
                        dpMinSum[i] = currSum;          // update min sum for this new length
                    } else if (currLen == dp[i]) {
                        // if same length, keep the smaller sum
                        dpMinSum[i] = Math.min(dpMinSum[i], currSum);
                    }
                }
            }
            // update global maxLIS and its min sum
            if (dp[i] > maxLIS) {
                maxLIS    = dp[i];
                minLISsum = dpMinSum[i];
            } else if (dp[i] == maxLIS) {
                minLISsum = Math.min(minLISsum, dpMinSum[i]);
            }
        }

        return total - minLISsum;                      // sum of elements not in any minimal‑sum LIS
    }
}