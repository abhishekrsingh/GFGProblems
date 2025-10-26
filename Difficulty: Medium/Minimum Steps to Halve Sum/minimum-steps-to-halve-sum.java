class Solution {
    public int minOperations(int[] arr) {
        // Create a max-heap using PriorityQueue with reverse order
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        
        // Add all elements to the heap and calculate sum
        for (int x : arr) {
            sum += x;
            pq.add((double)x);
        }
        
        double target = sum / 2;
        int times = 0;
        
        // Keep reducing the largest element until sum <= target
        while (sum > target) {
            double valueToDecrease = pq.poll();
            double newDecreasedValue = valueToDecrease / 2;
            sum -= newDecreasedValue;
            pq.add(newDecreasedValue);
            times++;
        }
        
        return times;
    }
}