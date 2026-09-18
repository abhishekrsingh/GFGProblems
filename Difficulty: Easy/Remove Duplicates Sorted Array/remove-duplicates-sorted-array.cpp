class Solution {
  public:
    vector<int> removeDuplicates(vector<int> &arr) {
        // code here
        set<int> unique(arr.begin(), arr.end());
        vector<int> result(unique.begin(), unique.end());
        return result;
    }
};