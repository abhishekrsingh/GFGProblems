class Solution {
  public:
    bool isProduct(vector<int>& arr, long long target) {
        // code here
        unordered_set<long long> seen;

        for (long long num : arr) {
    
            // Special case when target = 0
            if (target == 0) {
    
                // If current number is 0 and we already saw any number
                if (num == 0 && !seen.empty())
                    return true;
    
                // If current number is non-zero and 0 already exists
                if (num != 0 && seen.count(0))
                    return true;
            }
            else {
    
                // Avoid division by zero
                if (num != 0 && target % num == 0) {
    
                    long long needed = target / num;
    
                    if (seen.count(needed))
                        return true;
                }
            }
    
            seen.insert(num);
        }
    
        return false;
    }
};