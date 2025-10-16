/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int count=0;
    int kth=-1;
    public void inorder(Node root,int k){
        if(root==null||kth!=-1)return;
        inorder(root.left,k);
        count++;
        if(count==k){
            kth=root.data;
            return;
        }
        inorder(root.right,k);
    }
    public int kthSmallest(Node root, int k) {
        inorder(root,k);
        return kth;
    }
}