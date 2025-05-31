/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    public int findMaxFork(Node root, int k) {
        // code here.
         int result = -1; // Initialize result with -1 in case no value ≤ k is found

        while (root != null) {
            if (root.data <= k) {
                result = root.data;     // Valid candidate, update result
                root   = root.right;    // Try to find a bigger candidate on the right
            } else {
                root = root.left;       // Too big, go left to find smaller value
            }
        }

        return result; // Return the closest value ≤ k
    }
}