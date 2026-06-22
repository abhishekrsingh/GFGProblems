class Solution {
  public:
    int maxArea(vector<int> &height) {
        int start = 0, end = height.size() - 1; 
        int maxArea = 0; // 1. Changed to track maximum area
    
        while (start < end) {
            // 2. Width is simply the distance between pointers
            int width = end - start - 1; 
            
            // 3. Get the height of the shorter wall
            int currentHeight = min(height[start], height[end]); 
            
            // 4. Update maxArea if the current container holds more water
            maxArea = max(maxArea, currentHeight * width);
            
            // 5. Move the pointer pointing to the shorter line
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        
        return maxArea;
    }
};