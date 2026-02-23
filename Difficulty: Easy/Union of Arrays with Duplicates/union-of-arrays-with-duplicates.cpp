class Solution {
  public:
    vector<int> findUnion(vector<int>& a, vector<int>& b) {
        unordered_set<int> seen;
        vector<int> result;
        
        // Reserve space to avoid reallocations
        result.reserve(a.size() + b.size());
        
        // Process first array
        for(int x : a) {
            if(seen.find(x) == seen.end()) {
                seen.insert(x);
                result.push_back(x);
            }
        }
        
        // Process second array
        for(int x : b) {
            if(seen.find(x) == seen.end()) {
                seen.insert(x);
                result.push_back(x);
            }
        }
        
        // Sort if order is required
        sort(result.begin(), result.end());
        
        return result;
    }
};