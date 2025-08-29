class Solution
{
    public:
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    string smallestWindow (string s, string p)
    {
        int len1 = s.length();  // Length of main string S
        int len2 = p.length();  // Length of pattern string P
        
        // If main string is shorter than pattern, no window possible
        if (len1 < len2)
            return "";  // Return empty string
        
        // Frequency arrays for characters (ASCII has 256 characters)
        vector<int> countP(256, 0);  // Frequency count of characters in pattern P
        vector<int> countS(256, 0);  // Frequency count of characters in current window of S
        
        // Store occurrence/frequency of each character in pattern P
        for (int i = 0; i < len2; i++)
            countP[p[i]]++;  // Increment count for each character in pattern
        
        int start = 0;        // Left pointer of sliding window
        int start_idx = -1;   // Starting index of minimum window found
        int min_len = INT_MAX; // Length of minimum window found (initialize to maximum possible)
        
        int count = 0;  // Count of characters from pattern that are currently matched in window
        
        // Right pointer j moves through the string S
        for (int j = 0; j < len1; j++) {
            // Add current character to window frequency count
            countS[s[j]]++;
            
            // If current character exists in pattern AND we haven't exceeded required frequency
            if (countP[s[j]] != 0 && countS[s[j]] <= countP[s[j]]) {
                count++;  // We found a useful character that contributes to matching
            }
            
            // When we have matched all characters of pattern in current window
            if (count == len2) {
                // Try to minimize the window from left side by moving start pointer
                // While current start character is either:
                // 1. Not needed (countP[s[start]] == 0), OR
                // 2. Present in excess (countS[s[start]] > countP[s[start]])
                while (countS[s[start]] > countP[s[start]] || 
                       countP[s[start]] == 0) {
                    // If character is in excess, reduce its count
                    if (countS[s[start]] > countP[s[start]]) {
                        countS[s[start]]--;
                    }
                    start++;  // Move left pointer forward to shrink window
                }
                
                // Calculate current window length
                int len = j - start + 1;
                
                // Update minimum window if current one is smaller
                if (min_len > len) {
                    min_len = len;       // Update minimum length
                    start_idx = start;   // Update starting index of minimum window
                }
            }
        }
        
        // If no valid window was found
        if (start_idx == -1)
            return "";  // Return empty string
        
        // Return the smallest substring window
        return s.substr(start_idx, min_len);
    }
};
