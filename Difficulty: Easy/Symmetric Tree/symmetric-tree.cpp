/*
class Node {
public:
    int data;
    Node *left, *right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};
*/
class Solution {
  public:
    // Helper function to check if two subtrees are mirror images
    bool isMirror(Node* l, Node* r) {
        // If both nodes are NULL, they are mirror images
        if (l == NULL && r == NULL) {
            return true;
        }

        // If one is NULL and the other is not, not mirror images
        if (l == NULL || r == NULL) {
            return false;
        }

        // Check if current nodes are equal and subtrees are mirror images
        if ((l->data == r->data) && isMirror(l->left, r->right) && isMirror(l->right, r->left)) {
            return true;
        }

        // Otherwise, not mirror images
        return false;
    }

    // Main function to check if the tree is symmetric
    bool isSymmetric(Node* root) {
        // Empty tree is not symmetric as per this code
        if (!root) {
            return false;
        }

        // Check if left and right subtrees are mirror images
        return isMirror(root->left, root->right);
    }
};