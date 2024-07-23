//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Class to store information about the subtree
    static class Info {
        int size; // Size of the subtree
        int max; // Maximum value in the subtree
        int min; // Minimum value in the subtree
        int ans; // Size of the largest BST subtree found so far
        boolean isBST; // Whether the subtree is a BST

        Info(int size, int max, int min, int ans, boolean isBST) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.ans = ans;
            this.isBST = isBST;
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        return largestBstHelper(root).ans;
    }

    static Info largestBstHelper(Node node) {
        // Base case: an empty tree is a BST of size 0
        if (node == null) {
            return new Info(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);
        }

        // Recursively get info about the left and right subtrees
        Info leftInfo = largestBstHelper(node.left);
        Info rightInfo = largestBstHelper(node.right);

        // Create a new Info object for the current node
        Info curr = new Info(0, 0, 0, 0, false);

        // Calculate the size of the current subtree
        curr.size = 1 + leftInfo.size + rightInfo.size;

        // Check if the current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST && node.data > leftInfo.max && node.data < rightInfo.min) {
            curr.min = Math.min(leftInfo.min, node.data);
            curr.max = Math.max(rightInfo.max, node.data);
            curr.ans = curr.size;
            curr.isBST = true;
            return curr;
        }

        // If not a BST, set the current node's answer to the maximum of the left and right subtree answers
        curr.ans = Math.max(leftInfo.ans, rightInfo.ans);
        curr.isBST = false;
        return curr;
    }
    
}