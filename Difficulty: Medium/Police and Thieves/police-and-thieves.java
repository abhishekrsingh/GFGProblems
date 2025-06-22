class Solution {
    public int catchThieves(char[] arr, int k) {
        int n     = arr.length;
        int i     = 0;    // pointer to scan for 'P'
        int j     = 0;    // pointer to scan for 'T'
        int count = 0;    // total thieves caught

        while (i < n && j < n) {
            // move i to the next policeman
            while (i < n && arr[i] != 'P') {
                i++;
            }
            // move j to the next thief
            while (j < n && arr[j] != 'T') {
                j++;
            }

            // if both pointers are valid and within k distance, catch!
            if (i < n && j < n && Math.abs(i - j) <= k) {
                count++;
                i++;
                j++;
            }
            // if thief is too far left, move thief pointer right
            else if (j < n && j < i) {
                j++;
            }
            // if policeman is too far left, move policeman pointer right
            else if (i < n && i < j) {
                i++;
            }
        }
        return count;
    }
}