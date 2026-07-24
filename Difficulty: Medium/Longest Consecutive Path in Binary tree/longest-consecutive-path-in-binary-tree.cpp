/* Structure of Binary Tree Node
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = nullptr;
        right = nullptr;
    }
};
*/
class Solution {
  public:
    // DFS traversal while maintaining current consecutive length
    void dfs(Node *currentNode, Node *parentNode, int currentLength, int &longestPath)
    {
        if (currentNode == nullptr)
        {
            return;
        }
    
        // Check whether consecutive sequence continues
        if (parentNode && currentNode->data == parentNode->data + 1)
        {
            currentLength++;
        }
        else
        {
            currentLength = 1;
        }
    
        // Update the best answer found so far
        longestPath = max(longestPath, currentLength);
    
        dfs(currentNode->left, currentNode, currentLength, longestPath);
    
        dfs(currentNode->right, currentNode, currentLength, longestPath);
    }
    
    int longestConsecutive(Node *root)
    {
        if (root == nullptr)
        {
            return -1;
        }
    
        int longestPath = 0;
    
        dfs(root, nullptr, 0, longestPath);
    
        return (longestPath == 1 ? -1 : longestPath);
    }
};