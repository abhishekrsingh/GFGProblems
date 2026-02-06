class Solution {
  public:
    vector<int> smallestDiff(vector<int>& a, vector<int>& b, vector<int>& c) {
        // Sort all three arrays for efficient traversal
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        sort(c.begin(), c.end());
        
        int i = 0, j = 0, k = 0;  // Pointers for arrays a, b, c
        int n = a.size();         // All arrays have same size
        int minDiff = INT_MAX;    // Track minimum difference found
        int minSum = INT_MAX;     // Track smallest sum for ties
        vector<int> result(3);    // To store the best triplet
        
        // Iterate until any array is exhausted
        while (i < n && j < n && k < n) {
            // Get current values from all three arrays
            int valA = a[i];
            int valB = b[j];
            int valC = c[k];
            
            // Calculate current min and max values
            int currMin = min({valA, valB, valC});
            int currMax = max({valA, valB, valC});
            int currDiff = currMax - currMin;
            int currSum = valA + valB + valC;
            
            // Check if current triplet is better than what we have
            if (currDiff < minDiff || (currDiff == minDiff && currSum < minSum)) {
                minDiff = currDiff;
                minSum = currSum;
                
                // Store values in the order they'll be output (decreasing)
                vector<int> temp = {valA, valB, valC};
                sort(temp.begin(), temp.end(), greater<int>()); // Sort in descending order
                result = temp;
            }
            
            // Move the pointer pointing to the smallest value
            // This greedy approach helps minimize the range
            if (valA <= valB && valA <= valC) {
                // a[i] is the smallest, move i forward
                i++;
            } else if (valB <= valA && valB <= valC) {
                // b[j] is the smallest, move j forward
                j++;
            } else {
                // c[k] is the smallest, move k forward
                k++;
            }
        }
        
        return result;
    }
};