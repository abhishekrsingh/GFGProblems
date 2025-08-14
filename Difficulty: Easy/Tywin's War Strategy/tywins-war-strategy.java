class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n = arr.length;
        int need = (n + 1) / 2;
        int lucky = 0;

        // Min-heap for storing costs to make a troop lucky
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : arr) {
            if (num % k == 0) {
                ++lucky;
            } else {
                pq.add(k - (num % k));
            }
        }

        // If already enough lucky troops, cost is 0
        if (lucky >= need) return 0;

        int total = 0;
        int req = need - lucky;

        // Take smallest `required` costs from heap
        for (int i = 0; i < req && !pq.isEmpty(); ++i) {
            total += pq.poll();
        }

        return total;
    }
}