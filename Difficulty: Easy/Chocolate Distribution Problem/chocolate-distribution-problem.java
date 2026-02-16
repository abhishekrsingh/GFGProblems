// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // Sort the array
        Collections.sort(arr);

        int start = 0;
        int end = m - 1;
        int ans = Integer.MAX_VALUE;

        while (end < arr.size()) {
            ans = Math.min(ans, arr.get(end) - arr.get(start));
            start++;
            end++;
        }

        return ans;
    }
}