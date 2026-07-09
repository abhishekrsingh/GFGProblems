class Solution {
  public:
    int countKdivPairs(vector<int>& arr, int k) {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by k
        vector<int> freq(k, 0);
    
        // Count occurrences of all remainders
        for (int i = 0; i < arr.size(); i++)
            ++freq[arr[i] % k];
    
        // If both pairs are divisible by 'k'
        int res = freq[0] * (freq[0] - 1) / 2;
    
        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= k / 2 && i!= (k - i); i++)
            res += freq[i] * freq[k - i];
    
        // If k is even
        if (k % 2 == 0)
            res += (freq[k / 2] * (freq[k / 2] - 1) / 2);
    
        return res;
    }
};