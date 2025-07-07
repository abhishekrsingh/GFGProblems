class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        int n = a.length;

        // Sort both arrays in descending order
        Arrays.sort(a);
        reverseArray(a);
        Arrays.sort(b);
        reverseArray(b);

        // Max-heap storing {sum, {i, j}}
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Set<String> visited = new HashSet<>();

        // Seed with the largest pair (0,0)
        pq.offer(new int[]{a[0] + b[0], 0, 0});
        visited.add(0 + "," + 0);

        ArrayList<Integer> result = new ArrayList<>();

        while (result.size() < k && !pq.isEmpty()) {
            int[] top = pq.poll();
            int sum = top[0];
            int i = top[1];
            int j = top[2];

            result.add(sum);

            // Push neighbor (i, j+1) if within bounds and not seen
            if (j + 1 < n && !visited.contains(i + "," + (j + 1))) {
                pq.offer(new int[]{a[i] + b[j + 1], i, j + 1});
                visited.add(i + "," + (j + 1));
            }
            // Push neighbor (i+1, j) if within bounds and not seen
            if (i + 1 < n && !visited.contains((i + 1) + "," + j)) {
                pq.offer(new int[]{a[i + 1] + b[j], i + 1, j});
                visited.add((i + 1) + "," + j);
            }
        }

        return result;
    }

    private void reverseArray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}