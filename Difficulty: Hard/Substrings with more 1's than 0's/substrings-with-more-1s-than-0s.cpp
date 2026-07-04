class Solution {
  public:
    int countSubstring(string& s) {
        // Code Here
        // Length of the string
        int n = s.size();
    
        // Final answer
        int ans = 0;
    
        // "zero" acts as the base index in frequency array
        // We shift indices by n to avoid negative indexing
        int zero = n;
    
        // Stores count of invalid prefix states
        // (where number of 0's >= number of 1's)
        int minus = 0;
    
        // Frequency array to store occurrences
        // of prefix balances
        vector<int> mp(2 * n + 1, 0);
    
        // Current prefix balance
        int cur = zero;
    
        // Step 1: Build prefix balance frequencies
        for (auto i : s)
        {
            // Treat:
            // '1' as +1
            // '0' as -1
            if (i == '0')
                cur--;
            else
                cur++;
    
            // If current balance <= base balance,
            // then substring is invalid
            if (cur <= zero)
            {
                minus++;
            }
    
            // Store frequency of current balance
            mp[cur]++;
        }
    
        // Step 2: Count valid substrings
        for (int i = 0; i < n; i++)
        {
            // Total substrings starting from index i
            // = (n - i)
    
            // Subtract invalid substrings
            ans += (n - i - minus);
    
            // Update values while moving start index
            // Case 1: Current character is '1'
            if (s[i] == '1')
            {
                // Remove old prefix balance frequency
                mp[zero + 1]--;
    
                // Shift base balance
                zero++;
    
                // Update invalid count
                minus += mp[zero];
            }
    
            // Case 2: Current character is '0'
            else
            {
                // Remove old prefix balance frequency
                mp[zero - 1]--;
    
                // Shift base balance
                zero--;
    
                // Current invalid state removed
                minus--;
    
                // Remove additional invalid balances
                minus -= mp[zero + 1];
            }
        }
    
        // Return final answer
        return ans;
    }
};