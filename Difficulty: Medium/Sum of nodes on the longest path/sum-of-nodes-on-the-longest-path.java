/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    int maxLen = 0; // Stores the length of the longest path from root to leaf
    int maxSum = 0; // Stores the maximum sum along the longest path

    // Helper method to perform DFS traversal
    void dfs(Node node, int currLen, int currSum) {
        if (node == null) {
            return; // Base case: if node is null, just return
        }

        currLen += 1;             // Increment path length
        currSum += node.data;     // Add node value to path sum

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            } else if (currLen == maxLen && currSum > maxSum) {
                maxSum = currSum;
            }
            return;
        }

        // Recur for left and right subtree
        dfs(node.left, currLen, currSum);
        dfs(node.right, currLen, currSum);
    }

    public int sumOfLongRootToLeafPath(Node root) {
        dfs(root, 0, 0);  // Start DFS with initial length and sum as 0
        return maxSum;    // Return the max sum found
    }
}