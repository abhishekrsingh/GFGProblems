class Solution {
  public:
    vector<int> getMinMax(vector<int> &arr) {
        // code here
        int maxi = *max_element(arr.begin(), arr.end());
        int mini = *min_element(arr.begin(), arr.end());
        return {mini, maxi};
    }
};