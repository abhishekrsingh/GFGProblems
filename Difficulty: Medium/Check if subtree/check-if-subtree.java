/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        // code here
       StringBuilder s=new StringBuilder();
       StringBuilder t=new StringBuilder();
        
        inOrder(root1,s);
        
       
        inOrder(root2,t);
        return s.toString().contains(t.toString());
           
    }
    
    public void inOrder(Node node, StringBuilder res) {
        if (node == null){
            res.append("#,");
            return;
        }
        res.append(node.data).append(",");
        inOrder(node.left, res);
        
        inOrder(node.right, res);
    }
}