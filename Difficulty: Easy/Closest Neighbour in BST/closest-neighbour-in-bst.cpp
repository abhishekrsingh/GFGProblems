/*
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
}; */

class Solution {
  public:
    int findMaxFork(Node* root, int k) {
        int result = -1;  // Initialize result to -1 assuming no element found <= k

        while (root != NULL) {
            if (root->data <= k) {
                result = root->data;        // Current node is a valid candidate (<= k)
                root   = root->right;       // Try finding a bigger candidate on the right
            } else {
                root = root->left;          // Current node > k, go left to find smaller value
            }
        }

        return result; // Will hold the largest node value ≤ k, or -1 if no such value exists
    }
};