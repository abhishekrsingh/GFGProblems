class Solution {
    public int longestKSubstr(String s, int k) {
        int n = s.length();
        Map<Character, Integer> mp = new HashMap<>(); // map to store frequency of chars in current window

        int i = 0;                                    // left pointer of window
        int j = 0;                                    // right pointer of window

        int result = -1;                              // store max length found

        while (j < n) {
            // include s.charAt(j) in window
            char cj = s.charAt(j);
            mp.put(cj, mp.getOrDefault(cj, 0) + 1);

            // if more than k distinct, shrink from left
            if (mp.size() > k) {
                char ci = s.charAt(i);
                mp.put(ci, mp.get(ci) - 1);         // decrement freq of s.charAt(i)
                if (mp.get(ci) == 0) {              // if freq becomes 0, remove from map
                    mp.remove(ci);
                }
                i++;                                // move left pointer
            }

            // if exactly k distinct, update result
            if (mp.size() == k) {
                result = Math.max(result, j - i + 1);
            }
            j++; // expand right pointer
        }

        return result;
    }
}