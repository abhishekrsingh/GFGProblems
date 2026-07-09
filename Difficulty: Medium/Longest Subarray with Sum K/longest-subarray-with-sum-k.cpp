class Solution {
  public:
    int longestSubarray(vector<int>& arr, int k) {
        // code here
        int n=arr.size();
        unordered_map<int, int> seen;
        int result = 0;
        int prefSum = 0;
        for(int i=0; i<n; i++)
        {
            prefSum += arr[i];
            if(prefSum == k){
                result = i+1;
            }
            else if(seen.find(prefSum - k) != seen.end())
            {
                result = max(result, i - seen[prefSum - k]);
            }
            if(seen.find(prefSum) == seen.end())
            {
                seen[prefSum] = i;
            }
        }
        return result;
    }
    
    
    // int longestSubarray(vector<int>& arr, int k) {
    //     // code here
    //     int n=arr.size();
    //     int maxi = 0;
    //     for(int i=0; i<n; i++)
    //     {
    //         int current_sum = 0;
    //         for(int j=i; j<n; j++)
    //         {
    //             current_sum += arr[j];
    //             if(current_sum == k){
    //                 maxi = max(maxi, j-i+1);
    //             }
    //         }
    //     }
    //     return maxi;
    // }
};