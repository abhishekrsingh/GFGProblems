//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        int[] lps = new int[s.length()];
        int pre = 0, suf = 1;
        while (suf < s.length()) {
            // Match
            if (s.charAt(pre) == s.charAt(suf)) {
                lps[suf] = pre + 1;
                suf++;
                pre++;
            } else { // Not match
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }
        return lps[s.length() - 1];
    }
}