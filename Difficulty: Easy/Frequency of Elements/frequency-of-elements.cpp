class Solution {
  public:
    vector<vector<int>> countFreq(vector<int>& arr) {
        // code here
        int n = arr.size();
        vector<vector<int>> res;
        if (n == 0) return res;
    
        // 1. Array ko sort karo
        sort(arr.begin(), arr.end());
    
        int freq = 1;
        for (int i = 1; i < n; i++) {
            // Agar current element padosi ke barabar hai, toh count badhao
            if (arr[i] == arr[i - 1]) {
                freq++;
            } else {
                // Naya element mila, toh puraane ka data save karo
                res.push_back({arr[i - 1], freq});
                freq = 1; // Freq reset karo naye element ke liye
            }
        }
        // Last element ka data save karne ke liye
        res.push_back({arr[n - 1], freq});
    
        return res;
    }
    
    
    // vector<vector<int>> countFreq(vector<int>& arr) {
    //     // code here
    //     int n = arr.size();
    //     unordered_map<int, int> umap;
    //     vector<vector<int>>ans;
    //     for(auto x: arr) umap[x]++;
    //     for(auto &it: umap) ans.push_back({it.first, it.second});
    //     return ans;
    // }
};