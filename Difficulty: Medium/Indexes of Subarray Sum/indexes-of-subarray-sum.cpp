class Solution {
  public:
    vector<int> subarraySum(vector<int> &arr, int target) {
        // code here
        int n=arr.size();
        int i=0, j=0, current_sum=0;
        while(j<n)
        {
            current_sum += arr[j];
            while(current_sum > target && i<j)
            {
                current_sum -= arr[i];
                i++;
            }
            if(current_sum == target){
                return {i+1, j+1};
            }
            j++;
        }
        
        return {-1};
    }
    
    //O(n^2)
    // vector<int> subarraySum(vector<int> &arr, int target) {
    //     // code here
    //     int n=arr.size();
    //     vector<int> result;
    //     for(int i=0; i<n; i++){
    //         int currentSum = 0;
    //         for(int j=i; j<n; j++)
    //         {
    //             currentSum += arr[j];
    //             if(currentSum == target){
    //                 result.push_back(i+1);
    //                 result.push_back(j+1);
    //                 return result;
    //             }
    //         }
    //     }
    //     return {-1};
    // }
};