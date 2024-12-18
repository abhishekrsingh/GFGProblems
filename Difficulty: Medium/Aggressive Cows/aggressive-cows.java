//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // If there are fewer stalls than cows, it's not possible to allocate
        if (stalls.length < k) {
            return -1;
        }

        // Sort the stalls to determine valid positions
        Arrays.sort(stalls);

        int start = 0; // Minimum possible distance
        int end = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int ans = 0; // Start with 0 as the minimum valid answer

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // If the current distance is possible, try for a larger minimum distance
            if (isAllocationPossible(stalls, mid, k)) {
                ans = mid; // Store the maximum valid distance found so far
                start = mid + 1; // Try for a larger distance
            } else {
                end = mid - 1; // Try for a smaller distance
            }
        }

        return ans;
    }

    static boolean isAllocationPossible(int[] stalls, int minDistance, int k) {
        int cowsCount = 1; // Place the first cow
        int lastCowPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            // Check if the current stall maintains the minimum distance
            if (stalls[i] - lastCowPosition >= minDistance) {
                cowsCount++;
                lastCowPosition = stalls[i]; // Place the next cow
            }

            // If all cows are placed successfully
            if (cowsCount >= k) {
                return true;
            }
        }

        return false; // Not all cows could be placed
    }
}