class Solution {
  public:
    vector<int> countLessEq(vector<int>& a, vector<int>& b) {
        int n = a.size();                 // number of elements in a
        int m = b.size();                 // number of elements in b

        vector<int> result(n);            // answer array

        sort(b.begin(), b.end());         // sort b to enable binary search

        // For each a[i], upper_bound returns iterator to first element > a[i]
        // distance from b.begin() gives count of elements ≤ a[i]
        for (int i = 0; i < n; i++) {
            result[i] = upper_bound(b.begin(), b.end(), a[i]) - b.begin();
        }

        return result;
    }
};