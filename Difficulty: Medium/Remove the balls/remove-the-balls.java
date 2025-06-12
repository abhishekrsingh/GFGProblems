class Solution {
    public int findLength(int[] color, int[] radius) {
        int n = color.length;              // Total number of balls

        Stack<Integer> st = new Stack<>(); // Stack to keep indices of balls

        for (int i = 0; i < n; i++) {
            // Check if current ball matches the top of the stack
            if (!st.isEmpty() &&
                color[i] == color[st.peek()] &&
                radius[i] == radius[st.peek()]) {
                st.pop();   // Remove matching pair
            } else {
                st.push(i); // Keep current ball index
            }
        }

        return st.size(); // Remaining balls after all removals
    }
}