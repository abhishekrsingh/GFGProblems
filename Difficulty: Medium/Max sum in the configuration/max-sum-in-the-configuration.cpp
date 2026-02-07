class Solution {
  public:
    int maxSum(vector<int> &arr) {
        // code here
        int n = arr.size();
        int arrSum = 0;
        int curSum = 0;
        
        for (int i=0; i<n; i++) {
            arrSum += arr[i];
            curSum += i*arr[i];
        }
        
        int res = curSum;
        
        // checking for n-1 clockwise rotations
        for (int i=1; i<n; i++) {
            curSum = curSum + arrSum - n*arr[n-i];
            res = max(res, curSum);
        }
        
        return res;
    }
};