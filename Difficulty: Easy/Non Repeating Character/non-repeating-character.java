//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String st = sc.next();

            char ans = new Solution().nonRepeatingChar(st);

            if (ans != '$')
                System.out.println(ans);
            else
                System.out.println(-1);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static final int MAX_CHAR = 26;

    static char nonRepeatingChar(String s) {
        int[] vis = new int[MAX_CHAR];
        Arrays.fill(vis, -1);

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {

            // If the character is seen for the first time,
            // store its index
            if (vis[s.charAt(i) - 'a'] == -1)
                vis[s.charAt(i) - 'a'] = i;

            // If the character is seen again, mark it as -2
            else
                vis[s.charAt(i) - 'a'] = -2;
        }

        int idx = Integer.MAX_VALUE;

        // Find the smallest index among all non-repeating 
        // characters
        for (int i = 0; i < MAX_CHAR; i++) {
            if (vis[i] >= 0)
                idx = Math.min(idx, vis[i]);
        }

        // If non-repeating character is found, return it 
        // Else return '$'
        return (idx == Integer.MAX_VALUE ? '$' : s.charAt(idx));
    }
}
