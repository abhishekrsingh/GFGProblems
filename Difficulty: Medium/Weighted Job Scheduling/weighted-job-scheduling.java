class Solution {
    // binary search to find idx for next job
    public int findNextJob(int[][] jobs, int i){
        int low=0;
        int high=jobs.length;
        while(low < high){
            int mid = (low+high)/ 2;
            if(jobs[mid][0] < jobs[i][1]) low = mid+1;
            else high = mid;
        }
        return low;
    }

    public int recursion(int[][] jobs, int i, int[] dp) {
        if (i == jobs.length) {
            return 0;
        }

        if (dp[i] != -1) { // if already evaluated
            return dp[i]; // directlty return it
        }

        // find next job whose start time >= endTime[i]
        int nextJob = findNextJob(jobs, i);

        // take this job
        int option1 = jobs[i][2] + recursion(jobs, nextJob, dp);
        // not take this job
        int option2 = recursion(jobs, i+1, dp);

        dp[i] = Math.max(option1, option2); // take best option

        return dp[i];
    }
    
    public int maxProfit(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // sort on the basis of start time
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(jobs, 0, dp);
    }
}