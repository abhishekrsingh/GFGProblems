class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int totSum = Arrays.stream(arr).sum();
        int curSum = 0;
        
        for (int i = 0; i < n; i++) {
            curSum += arr[i];
            totSum -= arr[i];
            
            if (curSum == totSum) return true;
        }
        
        return false;
    }
}