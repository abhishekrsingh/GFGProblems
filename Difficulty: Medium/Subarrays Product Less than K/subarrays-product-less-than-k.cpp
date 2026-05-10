

class Solution {
  public:
    long long countSubArrayProductLessThanK(
    const vector<int>& arr,
    int n,
    long long k)
    {
        /*
           Edge Case
    
           Product of positive integers
           can never become less than 1.
    
           So if k <= 1,
           answer is always 0.
        */
        if(k <= 1)
        {
            return 0;
        }
    
        // Left boundary of sliding window
        int left = 0;
    
        // Stores product of current window
        long long product = 1;
    
        // Stores final answer
        long long count = 0;
    
        // Expand window using right pointer
        for(int right = 0; right < n; right++)
        {
            // Include current element into window product
            product *= arr[right];
    
            /*
               If product becomes invalid,
               shrink window from left side.
    
               Why?
    
               Because removing elements
               decreases product.
            */
            while(product >= k)
            {
                // Remove left element contribution
                product /= arr[left];
    
                // Move left boundary forward
                left++;
            }
    
            /*
               IMPORTANT LOGIC
    
               Current window:
               arr[left ... right]
    
               All subarrays ending at 'right'
               are valid.
    
               Example:
    
               Window = [5,2,6]
    
               Valid subarrays:
               [6]
               [2,6]
               [5,2,6]
    
               Count:
               right-left+1
            */
    
            count += (right - left + 1);
        }
    
        // Return total valid subarrays
        return count;
    }
};