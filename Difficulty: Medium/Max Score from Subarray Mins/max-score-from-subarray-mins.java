class Solution {
    public int maxSum(int arr[]) {
        // code here
        int n = arr.length;  // for arrays, use .length
        int result = arr[0] + arr[1];  // array elements accessed with []

        for (int i = 1; i < n - 1; i++) {
            result = Math.max(result, arr[i] + arr[i + 1]);
        }
        return result;
    }
}