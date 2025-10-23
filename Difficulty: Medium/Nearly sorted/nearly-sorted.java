class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        int n = arr.length;

        // Creating a min heap
        PriorityQueue<Integer> pq =  new PriorityQueue<>();

        // Pushing first k elements in pq
        for (int i = 0; i < k; i++) 
            pq.add(arr[i]);

        int i;
        for (i = k; i < n; i++) {
            pq.add(arr[i]);

            // Size becomes k+1 so pop it
            // and add minimum element in (i-k) index
            arr[i - k] = pq.poll();
        }

        // Putting remaining elements in array
        while (!pq.isEmpty()) {
            arr[i - k] = pq.poll();
            i++;
        }
    }
}
