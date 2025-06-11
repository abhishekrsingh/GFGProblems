class Solution {
  public:
    int findLength(vector<int>& color, vector<int>& radius) {
        int n = color.size(); // Total number of balls

        stack<int> st;        // Stack to keep indices of non-removed balls

        for (int i = 0; i < n; i++) {
            // If top of stack has same color and radius → remove both
            if (!st.empty() && color[i] == color[st.top()] && radius[i] == radius[st.top()]) {
                st.pop();   // Remove the matched pair
            } else {
                st.push(i); // Otherwise, keep the current ball
            }
        }

        return st.size(); // Remaining balls after all removals
    }
};