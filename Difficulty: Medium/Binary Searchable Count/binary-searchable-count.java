class Solution {
    public int binarySearchable(int[] arr) {
        // code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;
        return countBinarySearchable(arr, 0, length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    // O(N)
    // O(LogN)
    private int countBinarySearchable(int [] arr, int low, int high, int minValue, int maxValue) {
        // base case
        if (low > high) {
            return 0;
        }
        int middle = low + (high - low) / 2;
        // if we satisfies the condition
        int count = 0;
        if (minValue < arr[middle] && arr[middle] < maxValue) {
            count = 1;
        }
        // left tree
        int newMaxValue = Math.min(arr[middle], maxValue);
        count += countBinarySearchable(arr, low, middle - 1, minValue, newMaxValue);
        // right tree
        int newMinValue = Math.max(arr[middle], minValue);
        count += countBinarySearchable(arr, middle + 1, high, newMinValue, maxValue);
        return count;
    }
};