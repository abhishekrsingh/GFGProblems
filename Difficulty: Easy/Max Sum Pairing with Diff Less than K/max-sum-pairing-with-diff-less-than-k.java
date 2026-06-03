class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int ans = 0;

        int i = n - 1;

        while (i > 0) {
            if (arr[i] - arr[i - 1] < k) {
                ans += arr[i] + arr[i - 1];
                i -= 2; 
            } else {
                i--;    
            }
        }

        return ans;
    }
}