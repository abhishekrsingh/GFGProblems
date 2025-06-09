/*The Node structure is
class Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x){
        data = x;
        left = NULL;
        right = NULL;
    }
};*/

class Solution {
  public:
     // Helper DFS function to detect dead ends in BST
    bool dfs(Node* root, int min, int max) {
        if (!root) {
            return 0; // base case: empty subtree cannot have dead end
        }

        // if it's a leaf node
        if (!root->left && !root->right) {
            // check if no number can be inserted at or below this leaf
            if (root->data - min == 1 && max - root->data == 1) {
                return 1; // dead end found
            } else {
                return 0; // not a dead end
            }
        }

        // recursively check in left and right subtrees
        return dfs(root->left, min, root->data) ||
               dfs(root->right, root->data, max);
    }

    bool isDeadEnd(Node* root) {
        // Start with min = 0 and max = INT_MAX for root
        return dfs(root, 0, INT_MAX);
    }
};