/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    // Helper function to check if two subtrees are mirror images
    public boolean isMirror(Node l, Node r) {
        // If both nodes are null, they are mirror images
        if (l == null && r == null) {
            return true;
        }

        // If one is null and the other is not, not mirror images
        if (l == null || r == null) {
            return false;
        }

        // Check if current nodes are equal and subtrees are mirror images
        if ((l.data == r.data) && isMirror(l.left, r.right) && isMirror(l.right, r.left)) {
            return true;
        }

        // Otherwise, not mirror images
        return false;
    }
    
    // Main function to check if the tree is symmetric
    public boolean isSymmetric(Node root) {
        // If tree is empty, it's not symmetric (based on this implementation)
        if (root == null) {
            return false;
        }

        // Check if left and right subtrees are mirror images
        return isMirror(root.left, root.right);
    }
}