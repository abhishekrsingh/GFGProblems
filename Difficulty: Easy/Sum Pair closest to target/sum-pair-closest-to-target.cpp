class Solution {
  public:
    vector<int> sumClosest(vector<int>& arr, int target) {
        // code here
        int n = arr.size();
        if(n < 2) return {};
        sort(arr.begin(), arr.end());
        vector<int> result;
        int minDiffFromTarget = 1e9;
        int maxPairDiff = -1;
        int left=0, right=n-1;
        while(left < right)
        {
            int currentSum = arr[left] + arr[right];
            int currentMinDifference = abs(target - currentSum);
                
            if(currentMinDifference < minDiffFromTarget)
            {
                minDiffFromTarget = currentMinDifference;
                maxPairDiff = arr[right] - arr[left];
                result = {arr[left], arr[right]};
            }
            if(currentMinDifference == minDiffFromTarget)
            {
                if(arr[right] - arr[left] > maxPairDiff){
                    maxPairDiff = arr[right] - arr[left];
                    result = {arr[left], arr[right]};
                }
            }
                
            (currentSum < target)? left++ : right--;
        }
        return result;
    }
};