class Solution {
  public:
    void nearlySorted(vector<int> &arr, int k) {
        int n = arr.size();
        
        // WHY: Create min-heap to always have access to smallest element in current window
        priority_queue<int, vector<int>, greater<int>> pq;
    
        // WHY: Push first k elements to initialize the sliding window
        // Each element can be at most k positions away from its sorted position
        for (int i = 0; i < k; i++)
            pq.push(arr[i]);
    
        int i;
        
        // WHY: Process remaining elements using sliding window approach
        // For each new element, we push it and pop the smallest to its correct position
        for (i = k; i < n; i++) {
            pq.push(arr[i]);  // Expand window to include current element
            
            // WHY: Heap now has k+1 elements, smallest among them goes to (i-k) position
            // This is because element at position (i-k) can only be influenced by next k elements
            arr[i - k] = pq.top();
            pq.pop();
        }
    
        // WHY: Process remaining k elements in heap after main loop
        while (!pq.empty()) {
            arr[i - k] = pq.top();  // Place smallest remaining element
            pq.pop();
            i++;  // WHY: Move pointer to maintain correct indexing
        }
    }
};