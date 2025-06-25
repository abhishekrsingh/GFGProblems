class Solution {
    public String maxSubseq(String s, int k) {
        int           n        = s.length();
        int           toRemove = k;                   // number of characters we still need to remove
        StringBuilder result   = new StringBuilder(); // acts like a stack to build the answer

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // while we can remove characters, and the current character c is greater
            // than the last in result, pop to make result lexicographically larger
            while (result.length() > 0 && toRemove > 0 && c > result.charAt(result.length() - 1)) {
                result.deleteCharAt(result.length() - 1);
                toRemove--;
            }
            result.append(c); // include current character
        }

        // if we haven't removed enough (e.g., string was non-decreasing), trim from the end
        result.setLength(n - k);
        return result.toString();
    }
}