class Solution {
  public:
    vector<int> findUnion(vector<int>& a, vector<int>& b) {
        unordered_set<int> st;
        
        // 'a' ke saare elements set mein daal do
        for(auto x: a) st.insert(x);
        
        // 'b' ke saare elements set mein daal do (duplicates apne aap ignore ho jayenge)
        for(auto x: b) st.insert(x);
        
        // Set ko vector mein convert karke return kar do
        vector<int> result(st.begin(), st.end());
        return result;
    }
};