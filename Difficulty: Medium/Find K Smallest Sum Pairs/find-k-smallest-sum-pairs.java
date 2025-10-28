class Solution {
    public ArrayList<ArrayList<Integer>> kSmallestPair(int[] arr1, int[] arr2, int k) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        if (arr1.length == 0 || arr2.length == 0 || k <= 0) return ans;

        // Min-heap to keep track of current smallest sum and indices
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Set<String> my_set = new HashSet<>();

        // Push initial pair (arr1[0] + arr2[0]) with indices (0,0)
        pq.offer(new int[]{arr1[0] + arr2[0], 0, 0});
        my_set.add("0,0");

        while (k > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            int sum = temp[0], i = temp[1], j = temp[2];

            // Add the current smallest pair to the answer
            ans.add(new ArrayList<>(Arrays.asList(arr1[i], arr2[j])));
            k--;

            // Push next element in arr1 (if not already used)
            if (i + 1 < arr1.length) {
                String key1 = (i + 1) + "," + j;
                if (!my_set.contains(key1)) {
                    pq.offer(new int[]{arr1[i + 1] + arr2[j], i + 1, j});
                    my_set.add(key1);
                }
            }

            // Push next element in arr2 (if not already used)
            if (j + 1 < arr2.length) {
                String key2 = i + "," + (j + 1);
                if (!my_set.contains(key2)) {
                    pq.offer(new int[]{arr1[i] + arr2[j + 1], i, j + 1});
                    my_set.add(key2);
                }
            }
        }

        return ans;
    }
}
