class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        int n = a1.length;
        int maxLen = 0;

        // Hash map to store first occurrence of each difference
        HashMap<Integer, Integer> diffMap = new HashMap<>();

        int prefixSum1 = 0, prefixSum2 = 0;

        for (int i = 0; i < n; i++) {
            prefixSum1 += a1[i];
            prefixSum2 += a2[i];

            int currentDiff = prefixSum1 - prefixSum2;

            // If difference is 0, entire subarray
            // from 0 to i has equal sum
            if (currentDiff == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }

            // If this difference has been seen before
            else if (diffMap.containsKey(currentDiff)) {
                maxLen = Math.max(maxLen, i - diffMap.get(currentDiff));
            } else {

                // Store first occurrence of this difference
                diffMap.put(currentDiff, i);
            }
        }

        return maxLen;
    }
}