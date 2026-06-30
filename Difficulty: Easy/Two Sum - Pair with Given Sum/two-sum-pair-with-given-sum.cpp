class Solution {
  public:
    bool twoSum(vector<int>& arr, int target) {
        // code here
        unordered_set<int> st;
    
        for(auto x: arr) {
            int remaining = target - x;
            
            // Agar (target - x) pehle se set mein hai, toh pair mil gaya!
            if(st.count(remaining)) {
                return true;
            }
            
            // Agar nahi mila, toh current element ko set mein daal do
            st.insert(x); // FIX: st[x]++ ki jagah .insert() use kiya
        }
        return false;
    }
    
    // bool twoSum(vector<int>& arr, int target) {
    //     // code here
    //     for(int i=0; i<arr.size(); i++)
    //     {
    //         for(int j=i+1; j<arr.size(); j++)
    //         {
    //             if(arr[i] + arr[j] == target) return true; 
    //         }
    //     }
    //     return false;
    // }
};