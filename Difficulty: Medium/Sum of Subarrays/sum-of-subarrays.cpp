class Solution {
  public:
    int subarraySum(vector<int>& arr) {
        // code here
        int n = arr.size();
        long long totalSum = 0;
        long long curr = 0;
    
        for (int i = 0; i < n; i++) {
            curr += arr[i] * (i + 1);  // arr[i] contributes (i+1) times in the prefix
            totalSum += curr;
        }
    
        return totalSum;
    }
};