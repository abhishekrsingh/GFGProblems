class Solution {
  public:
    int maxLen(vector<int> &arr) {
        int n = arr.size();
        if(n < 1) return 0;
        
        unordered_map<int, int> storeFirstIndex;
        int prefixSum = 0;
        int longestCountSubarray = 0;
        
        for(int i = 0; i < n; i++)
        {
            // 0 ko -1 ki tarah treat kiya, 1 ko +1 ki tarah
            prefixSum += (arr[i] == 0) ? -1 : 1;
            
            // Agar sum 0 ho gaya, matlab starting se lekar 'i' tak equal 0s aur 1s hain
            if(prefixSum == 0) {
                longestCountSubarray = i + 1;
            }
            // Agar yeh prefixSum pehle dikh chuka hai, toh beech ka sum 0 hai
            else if(storeFirstIndex.find(prefixSum) != storeFirstIndex.end()) {
                longestCountSubarray = max(longestCountSubarray, i - storeFirstIndex[prefixSum]);
            }
            // Agar pehli baar aaya hai, toh hi iska index store karo (Longest rakhne ke liye)
            else {
                storeFirstIndex[prefixSum] = i;
            }
        }
        
        return longestCountSubarray;
    }
    // int maxLen(vector<int> &arr) {
    //     // Your code here
    //     int n=arr.size();
    //     if(n < 1) return 0;
    //     int longestCountSubarray = 0;
    //     for(int i=0; i<n; i++){
    //         int countZeros = 0;
    //         int countOnes = 0;
    //         for(int j=i; j<n; j++)
    //         {
    //             (arr[j] == 0) ? countZeros++ : countOnes++;
    //             if(countZeros == countOnes){
    //                 longestCountSubarray = max(longestCountSubarray, j - i + 1);
    //             }
    //         }
    //     }
    //     return longestCountSubarray;
    // }
};