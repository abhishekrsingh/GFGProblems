class Solution {
  public:
    int countOccurence(vector<int>& arr, int k) {
        // code here
        int n = arr.size();
        int count = 0;
        unordered_map<int, int> freq;
        for(auto ele: arr){
            freq[ele]++;
        }
        for(auto it = freq.begin(); it != freq.end(); ++it){
            if(it->second > n/k)count++;
        }
        return count;
    }
};