class Solution {
  public:
    // Complete this function
    // Function to check whether there is a subarray present with 0-sum or not.
    bool subArrayExists(vector<int>& arr) {
        // Your code here
        int n = arr.size();
        unordered_set<int> seen_sums;
        int prefix_sum = 0;
        for(int i=0; i<n; i++)
        {
            prefix_sum += arr[i];
            if(prefix_sum == 0 || seen_sums.find(prefix_sum) != seen_sums.end()) return true;
            seen_sums.insert(prefix_sum);
        }
        return false;
    }
    
    // bool subArrayExists(vector<int>& arr) {
    //     // Your code here
    //     int n = arr.size();
    //     for(int i=0; i<n; i++)
    //     {
    //         int current_sum = 0;
    //         for(int j=i; j<n; j++)
    //         {
    //             current_sum += arr[j];
    //             if(current_sum == 0) return true;
    //         }
    //     }
    //     return false;
    // }
};