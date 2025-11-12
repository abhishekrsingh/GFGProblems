class Solution {
    public static int minSuperSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // If chars match
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];

                // Else, take max from top or left
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            // Move current row to previous
            prev = curr.clone();
        }

        int lcsLen = prev[n];

        // SCS length = total - common part (LCS)
        return m + n - lcsLen;
    }
}