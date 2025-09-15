class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
        int n = gas.length;
        int startIdx = 0;

        // Initially tank is empty
        int currGas = 0;

        for (int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];

            // If currGas becomes less than zero, then
            // It's not possible to proceed with this startIdx
            if (currGas < 0) {
                startIdx = i + 1;
                currGas = 0;
            }
        }

        // Checking if startIdx can be a valid 
    	// starting point for the Circular tour
        currGas = 0;
        for (int i = 0; i < n; i++) {

            // Circular Index
            int idx = (i + startIdx) % n;
            currGas = currGas + gas[idx] - cost[idx];
            if (currGas < 0)
                return -1;
        }

        return startIdx;
    }
}