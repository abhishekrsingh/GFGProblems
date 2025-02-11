//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

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

class GFG {
    static Node buildTree(String str) {
        // Corner Case
        if (str.length() == 0 || str.equals('N')) return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= s.length) break;
            currVal = s[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
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
        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();

            System.out.println(ob.sumK(root, k));
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


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
    static int countPathsUtil(Node node, int k, int currSum, HashMap<Integer, Integer> prefSums) {
        if (node == null)
            return 0;

        int pathCount = 0;
        currSum += node.data;
        if (currSum == k)
            pathCount++;
        pathCount += prefSums.getOrDefault(currSum - k, 0);
        prefSums.put(currSum, prefSums.getOrDefault(currSum, 0) + 1);

        pathCount += countPathsUtil(node.left, k, currSum, prefSums);
        pathCount += countPathsUtil(node.right, k, currSum, prefSums);
        prefSums.put(currSum, prefSums.get(currSum) - 1);

        return pathCount;
    }
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> prefSums = new HashMap<>();
        return countPathsUtil(root, k, 0, prefSums);
    }
}