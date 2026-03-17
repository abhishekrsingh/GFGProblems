/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public int countAllPaths(Node root, int k) {
        if (root == null) return 0;

        return countFromNode(root, k) 
             + countAllPaths(root.left, k) 
             + countAllPaths(root.right, k);
    }

    int countFromNode(Node node, int k) {
        if (node == null) return 0;

        int count = 0;

        if (node.data == k)
            count++;

        count += countFromNode(node.left, k - node.data);
        count += countFromNode(node.right, k - node.data);

        return count;
    }
}