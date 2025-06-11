class Solution {
    int countStrings(String s) {
        int n = s.length();
        int[] mp = new int[26];         // frequency array
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += (i - mp[s.charAt(i) - 'a']);   // swaps with different chars seen so far
            mp[s.charAt(i) - 'a']++;                 // increment current char freq
        }

        for (int i = 0; i < 26; i++) {
            if (mp[i] > 1) {         // duplicate character found
                result++;            // one extra swap that results in same string
                break;
            }
        }

        return result;
    }
}