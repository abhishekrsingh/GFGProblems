class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;                        // Size of the array
        ArrayList<Integer> result = new ArrayList<>();

        for (int k = 0; k < n; k++) {              // Initialize result with -1s
            result.add(-1);
        }

        Stack<Integer> st = new Stack<>();         // Stack to store indices of waiting elements

        for (int i = 0; i < 2 * n; i++) {          // Traverse twice for circularity
            int idx = i % n;                       // Actual index in arr
            int num = arr[idx];                    // Current number

            // While current num is bigger than arr at the top index
            while (!st.isEmpty() && num > arr[st.peek()]) {
                result.set(st.pop(), num);         // Assign it as the next greater
            }

            if (i < n) {                           // Only push original indices on first pass
                st.push(idx);                      // Add index to stack
            }
        }
        return result;                             // Return filled results
    }
}