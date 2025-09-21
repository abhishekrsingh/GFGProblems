class Solution {
    public static int longestSubarray(int[] arr) {
        // code here 
        int max = 0;
        int n = arr.length;
        int[] ng = new int[n];
        int[] pg = new int[n];
        
        ng[n-1] = n;
        pg[0] = -1;
        
        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            
            ng[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }
        
        s = new Stack<>();
        s.push(0);
        for(int i = 1; i < n; i++){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            
            pg[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        
        for(int i = 0; i < n; i++){
            int size = ng[i] - pg[i] - 2 + 1;
            
            if(size >= arr[i]) max = Math.max(max,size);
        }
        
        return max;
    }
}