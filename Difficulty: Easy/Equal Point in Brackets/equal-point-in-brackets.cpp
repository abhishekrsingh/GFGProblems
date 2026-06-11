class Solution {
  public:
    int findIndex(string &s) {
        int n = s.length();
        int totalClose = 0;
        
        // Step 1: Count total closing brackets in the entire string
        for (char c : s) {
            if (c == ')') {
                totalClose++;
            }
        }
        
        int countOpen = 0;
        int countClose = totalClose; // Initially, all ')' are on the right side
        
        // Step 2: Traverse and shift the partition line
        for (int k = 0; k < n; k++) {
            // If the current counts match BEFORE consuming s[k], k is our answer
            if (countOpen == countClose) {
                return k;
            }
            
            // Update counts as the cut moves past index k
            if (s[k] == '(') {
                countOpen++;
            } else if (s[k] == ')') {
                countClose--;
            }
        }
        
        // Check for the boundary condition (cut at the very end, k = n)
        if (countOpen == countClose) {
            return n;
        }
        
        return -1; // Fallback, though a valid point always exists
    }
};