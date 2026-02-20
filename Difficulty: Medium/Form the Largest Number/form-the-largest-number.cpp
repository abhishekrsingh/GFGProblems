class Solution {
  public:
    static bool compare(string a, string b) {
        return (a + b) > (b + a);
    }
    
    string findLargest(vector<int>& nums) {
        // Step 1: Convert all numbers to strings
        vector<string> arr;
        for (int num : nums) {
            arr.push_back(to_string(num));
        }
    
        // Step 2: Sort using our special compare function
        sort(arr.begin(), arr.end(), compare);
    
        // Step 3: If the biggest number is "0", then all are zeros
        if (arr[0] == "0") return "0";
    
        // Step 4: Join all strings to make answer
        string result = "";
        for (string s : arr) {
            result += s;
        }
        return result;
    }
};