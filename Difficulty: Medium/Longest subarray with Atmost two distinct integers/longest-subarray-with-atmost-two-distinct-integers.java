class Solution {
    public int totalElements(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        int i      = 0;       // left boundary of window
        int j      = 0;       // right boundary of window
        int result = 0;       // best window size seen

        while (j < n) {
            // include arr[j] into the window
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            // if more than two distinct numbers, shrink from left
            while (map.size() > 2) {
                int count = map.get(arr[i]) - 1;
                if (count == 0) {
                    map.remove(arr[i]);     // remove key if freq is zero
                } else {
                    map.put(arr[i], count); // else update freq
                }
                i++;                        // move left boundary right
            }

            // window [i..j] is valid, update result
            result = Math.max(result, j - i + 1);
            j++;                           // expand window to the right
        }

        return result;
    }
}