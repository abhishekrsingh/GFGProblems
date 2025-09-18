class Solution {
  public:
    vector<int> nextGreater(vector<int> &arr) {
        int n = arr.size();
        vector<int> result(n, -1); // Initialize result with -1 (default when no greater element found)
        stack<int> st; // Stack to keep track of potential next greater elements
        
        // Process the array in circular manner - traverse from right to left twice
        for(int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n; // Convert circular index to actual array index
            
            // Remove all elements from stack that are smaller than or equal to current element
            // We only want to keep elements that are strictly greater than current
            while(!st.empty() && st.top() <= arr[idx]) {
                st.pop();
            }
            
            // If stack is not empty, top element is the next greater element
            if(!st.empty()) {
                result[idx] = st.top();
            }
            
            // Push current element to stack for future comparisons
            st.push(arr[idx]);
        }
        return result;
    }
};