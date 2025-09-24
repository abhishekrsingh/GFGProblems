class Solution {
    public void reverseQueue(Queue<Integer> q) {
        // code here
        if (q.isEmpty()) return;

        // remove front element
        int front = q.peek();
        q.poll();

        // reverse remaining queue
        reverseQueue(q);

        // insert removed element at the rear
        q.add(front);
    }
}