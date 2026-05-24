class Solution {
  public:
    int coin(vector<int>& arr) {
        // code here
        int left = 0;
        int right = arr.size() - 1;
    
        // Remove one coin in each move
        while (left < right) {
    
            // Greedily remove larger end coin
            if (arr[left] >= arr[right]) {
                left++;
            } else {
                right--;
            }
        }
    
        // Last remaining coin
        return arr[left];
    }
};