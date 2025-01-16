//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        long sum = 0;
        Map<Long, Integer> map1 = new HashMap<>();
        int maxlen = 0;

        // Initialize the map with a base case: sum = 0 at index -1
        map1.put(0L, -1);

        for (int i = 0; i < n; i++) {
            sum += arr[i];  // Add the current element to the sum

            // Check if there's a previous sum that, if subtracted from current sum, gives k
            if (map1.containsKey(sum - k)) {
                maxlen = Math.max(maxlen, i - map1.get(sum - k)); // Update maxlen
            }

            // Only add the current sum to map1 if it's not already present
            // (store the first occurrence of the sum)
            if (!map1.containsKey(sum)) {
                map1.put(sum, i); // Store the index of the first occurrence of this sum
            }
        }
        
        return maxlen;
    }
}
