class Solution {
  public:
    int equalSumSpan(vector<int> &a1, vector<int> &a2) {
        int n = a1.size();
        
        // Key: prefix_sum, Value: first seen index
        unordered_map<int, int> mp;
        
        int prefix_sum = 0;
        int max_len = 0;
        
        for(int i = 0; i < n; i++) {
            // 1. diff nikalo dono arrays ka aur prefix sum mein add karo
            prefix_sum += (a1[i] - a2[i]);
            
            // 2. Agar prefix_sum 0 ho gaya, matlab index 0 se i tak ka span valid hai
            if(prefix_sum == 0) {
                max_len = i + 1;
            }
            
            // 3. Agar ye prefix_sum pehle dekh chuke hain, toh beech ka sum 0 hua hoga
            if(mp.find(prefix_sum) != mp.end()) {
                max_len = max(max_len, i - mp[prefix_sum]);
            } 
            else {
                // 4. Pehli baar dikha toh map mein index store karlo (for maximum length)
                mp[prefix_sum] = i;
            }
        }
        
        return max_len;
    }
    // int equalSumSpan(vector<int> &a1, vector<int> &a2) {
    //     // code here
    //     int n = a1.size();
    //     int res = 0;
    //     for(int i=0; i<n; i++)
    //     {
    //         int sum_a1 = 0, sum_a2 = 0;
    //         for(int j=i; j<n; j++)
    //         {
    //             sum_a1 += a1[j];
    //             sum_a2 += a2[j];
                
    //             if(sum_a1 == sum_a2)
    //                 res = max(res, j-i+1);
    //         }
    //     }
    //     return res;
    // }
};