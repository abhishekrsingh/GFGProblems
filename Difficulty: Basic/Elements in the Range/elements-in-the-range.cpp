class Solution {
  public:
    bool checkElements(int start, int end, vector<int> &arr) {
        // code here
        int n = arr.size();

        // At least (end - start + 1) elements needed
        if (n < end - start + 1)
            return false;
    
        int range = end - start;
    
        // Mark presence using index mapping
        for (int i = 0; i < n; i++)
        {
            int val = abs(arr[i]);
    
            if (val >= start && val <= end)
            {
                int idx = val - start;
    
                if (idx < n && arr[idx] > 0)
                {
                    arr[idx] = -arr[idx];
                }
            }
        }
    
        // Check all required indices
        for (int i = 0; i <= range && i < n; i++)
        {
            if (arr[i] > 0)
                return false;
        }
    
        return true;
    }
};
