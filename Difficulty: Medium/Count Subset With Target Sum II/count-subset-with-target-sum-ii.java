class Solution {
    HashMap<String, Integer> dp; // dp[i][k]
    public int solve(int[] arr, int k, int i){
        if(i>=arr.length){
            if(k==0) return 1; // arr processed and subset found -> 1
            else return 0; // arr processed aand subset not  found -> 0
        }
        
        String key = i+","+k; // we must use hashmap for the dp table, as k can be very large negative or positive that might not be hold by int
        if(dp.containsKey(key)) return dp.get(key);
        
        // take (we dont need to check [k-arr[i]>=0], as numbers can be negative and so the target)
        int include = solve(arr, k-arr[i], i+1);
        // not take
        int exclude = solve(arr, k, i+1);
        
        dp.put(key, include+exclude); // update dp
        return include+exclude;
    }
    public int countSubset(int[] arr, int k) {
        int pos_sum = 0; // positive number sum
        int neg_sum = 0; // negative number sum
        for(int a : arr){
            if(a>0) pos_sum += a;
            else neg_sum += a;
        }
        
        // edge cases
        if(k>pos_sum || k<neg_sum) return 0;
        
        dp = new HashMap<>();
        return solve(arr, k, 0);
    }
}