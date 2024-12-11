//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int minRemoval(int intervals[][]) {
        if (intervals.length == 0) {
            return 0;
        }

        // Sort intervals based on their end times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1; // At least one interval can be kept
        int lastEndTime = intervals[0][1]; // End time of the last added interval

        // Iterate through the sorted intervals
        for (int i = 1; i < intervals.length; i++) {
            // If the current interval starts after or when the last added interval ends
            if (intervals[i][0] >= lastEndTime) {
                count++; // We can keep this interval
                lastEndTime = intervals[i][1]; // Update the end time
            }
        }

        // The number of intervals to remove is total intervals minus the count of kept intervals
        return intervals.length - count;
    }
}
