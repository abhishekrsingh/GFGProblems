class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        int n = a.length;                              // number of elements in a
        int m = b.length;                              // number of elements in b
        ArrayList<Integer> result = new ArrayList<>(); // answer list

        int maxA = 0;

        for (int val : a) {
            if (val > maxA) {
                maxA = val;                          // find the maximum value in a
            }
        }

        int[] freq = new int[maxA + 1];              // freq[i] = count of i in b (if i <= maxA)

        // Build frequency array for b[]
        for (int i = 0; i < m; i++) {
            if (b[i] <= maxA) {
                freq[b[i]]++;                        // increment count of b[i]
            }
        }

        // Convert freq[] into prefix sum array so freq[i] = count of elements ≤ i
        for (int i = 1; i <= maxA; i++) {
            freq[i] += freq[i - 1];
        }

        // For each element in a, the answer is freq[a[i]] (number of b elements ≤ a[i])
        for (int i = 0; i < n; i++) {
            result.add(freq[a[i]]);
        }

        return result;
        
    }
}