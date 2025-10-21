class Solution {
  public:
    typedef pair<int, int> p;
    vector<int> topKFreq(vector<int> &arr, int k) {
        // Code here
        priority_queue<p, vector<p>, greater<p>> pq;
        
        unordered_map<int, int> mp;
        for(int i: arr) mp[i]++;
        
        for(auto it: mp)
        {
            pq.push({it.second, it.first});
            if(pq.size() > k)
                pq.pop();
        }
        
        vector<int> result;
        while(!pq.empty()) {
            result.push_back(pq.top().second);
            pq.pop();
        }
        reverse(result.begin(), result.end());
        return result;
    }
};

    
   