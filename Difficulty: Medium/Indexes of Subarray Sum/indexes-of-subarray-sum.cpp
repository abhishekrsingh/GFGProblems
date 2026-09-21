class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        // code here
        int start=0,currentSum=0;
        for(int end=0; end<arr.size(); end++){
            currentSum += arr[end];
            while(currentSum > target && start < end) currentSum -= arr[start++];
            if(currentSum == target) return {start+1, end+1};
        }
        return {-1};
    }
    
    
    // vector<int> subarraySum(vector<int> &arr, int target) {
    //     // code here
    //     int n = arr.size();
    //     for(int i=0; i<n; i++){
    //         int currentSum = 0;
    //         for(int j=i; j<n; j++){
    //             currentSum += arr[j];
    //             if(currentSum == target){
    //                 return {i+1, j+1};
    //             }
    //         }
            
    //     }
    //     return {-1};
    // }
};