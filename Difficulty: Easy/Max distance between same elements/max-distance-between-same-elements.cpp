class Solution {
  public:
    int maxDistance(vector<int> &arr) {
        // Code here
        int n = arr.size();
        unordered_map<int, int> first_occ;
        int max_dist = 0;
        for(int i=0; i<n; i++)
        {
            if(first_occ.find(arr[i]) != first_occ.end())
            {
                max_dist = max(max_dist, i - first_occ[arr[i]]);
            }else{
                first_occ[arr[i]] = i;
            }
        }
        return max_dist;
    }
};