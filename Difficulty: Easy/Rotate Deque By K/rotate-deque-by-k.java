class Solution {
     // Function to reverse elements in
    // the array between indices start and end
    static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
        
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Function to rotate the deque by k
    // positions using Reversal Algorithm
    static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        
        // If deque is empty, nothing to rotate
        if (n == 0) return;

        // Use modulo to avoid unnecessary full rotations
        k = k % n;
        if (k == 0) return;

        // Convert deque to array for index-based operations
        Integer[] arrObj = dq.toArray(new Integer[0]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = arrObj[i];

        // Right rotation (clockwise)
        if (type == 1) {
            reverseArray(arr, 0, n - 1);
            reverseArray(arr, 0, k - 1);
            reverseArray(arr, k, n - 1);

        // Left rotation (anti-clockwise)
        } else if (type == 2) {
            reverseArray(arr, 0, k - 1);
            reverseArray(arr, k, n - 1);
            reverseArray(arr, 0, n - 1);
        }

        // Clear the deque and update it with rotated elements
        dq.clear();
        for (int val : arr) dq.add(val);
    }
}