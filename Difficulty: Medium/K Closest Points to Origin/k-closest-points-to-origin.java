class Solution {
    // Function to calculate squared distance from the origin
    static int squaredDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    // Function to find k closest points to
    // the origin
    static ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {

        // Max heap to store points with their 
        // squared distances
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        // Iterate through each point
        for (int i = 0; i < points.length; i++) {
            int dist = squaredDis(points[i]);
            int[] entry = new int[]{dist, i}; // store index to retrieve point

            if (maxHeap.size() < k) {

                // If the heap size is less than k, 
                // insert the point
                maxHeap.add(entry);
            } else {

                // If the heap size is k, compare with
                // the top element
                if (dist < maxHeap.peek()[0]) {

                    // Replace the top element if the
                    // current point is closer
                    maxHeap.poll();
                    maxHeap.add(entry);
                }
            }
        }

        // Take the k closest points from the heap
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int idx = maxHeap.poll()[1];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(points[idx][0]);
            temp.add(points[idx][1]);
            res.add(temp);
        }

        return res;
    }
}