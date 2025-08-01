class Solution {
  public:
    vector<int> topKSumPairs(vector<int>& a, vector<int>& b, int k) {
        int n = a.size();

        // sort both arrays in descending order
        sort(a.rbegin(), a.rend());                     // O(n log n)
        sort(b.rbegin(), b.rend());                     // O(n log n)

        // max-heap storing {sum, {i, j}}
        priority_queue<pair<int, pair<int, int>>> pq;
        set<pair<int, int>> st;                          // visited index‑pairs

        // seed with the largest pair (0,0)
        pq.push({ a[0] + b[0], { 0, 0 } });
        st.insert({ 0, 0 });

        vector<int> result;
        result.reserve(k);

        while (result.size() < k) {
            auto top = pq.top(); pq.pop();              // pop current max sum
            int  sum = top.first;
            int  i   = top.second.first;
            int  j   = top.second.second;

            result.push_back(sum);                      // record it

            // push neighbor (i, j+1) if within bounds and not seen
            if (j + 1 < n && st.emplace(i, j + 1).second) {
                pq.push({ a[i] + b[j + 1], { i, j + 1 } });
            }
            // push neighbor (i+1, j) if within bounds and not seen
            if (i + 1 < n && st.emplace(i + 1, j).second) {
                pq.push({ a[i + 1] + b[j], { i + 1, j } });
            }
        }
        return result;  // top k sums
    }
};