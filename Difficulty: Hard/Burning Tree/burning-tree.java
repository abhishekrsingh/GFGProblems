//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
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

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    private static void mapParents(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        parentMap.put(root, null);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
    }
    
    // Method to find the minimum time to burn the tree from the target node
    public static int minTime(Node root, int target) {
        if (root == null) return 0;

        // Find the target node
        Node targetNode = findNode(root, target);
        if (targetNode == null) return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        mapParents(root, parentMap);
        
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.add(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false; // To check if any node burns at this time
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Try to burn left child
                if (current.left != null && !visited.contains(current.left)) {
                    flag = true;
                    visited.add(current.left);
                    queue.add(current.left);
                }
                
                // Try to burn right child
                if (current.right != null && !visited.contains(current.right)) {
                    flag = true;
                    visited.add(current.right);
                    queue.add(current.right);
                }
                
                // Try to burn parent node
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    flag = true;
                    visited.add(parent);
                    queue.add(parent);
                }
            }
            
            if (flag) time++;
        }
        
        return time;
    }
    private static Node findNode(Node root, int target) {
        if (root == null) return null;
        if (root.data == target) return root;
        
        Node left = findNode(root.left, target);
        if (left != null) return left;
        
        return findNode(root.right, target);
    }
}