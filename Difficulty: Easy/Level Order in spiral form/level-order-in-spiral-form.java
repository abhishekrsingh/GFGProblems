//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

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
            if (i >= ip.length) break;

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

    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            ArrayList<Integer> result = g.findSpiral(root);
            for (int value : result) System.out.print(value + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> findSpiral(Node root) {
        // code here
        Stack<Node> other = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>(); // to fill the resultant list
        
        other.push(root); //intially add root itself
        boolean rtl = true; //initially we should add `right then left`
        while(!other.isEmpty()) {
            other = fill(other, res, rtl);
            rtl = !rtl; // switch alternatively so that we can decide whether to add `left then right` or `right then left`
        }
        return res;
    }
    
    private Stack<Node> fill(Stack<Node> from, ArrayList<Integer> res, boolean rtl) {
        Stack<Node> to = new Stack<>();
        while(!from.isEmpty()) {
            Node top = from.pop();
            res.add(top.data);
            if(rtl) { //either `right then left`
                if(null != top.right) to.push(top.right);
                if(null != top.left) to.push(top.left);    
            } else { //or `left then right`
                if(null != top.left) to.push(top.left);    
                if(null != top.right) to.push(top.right);
            }
            
        }
        return to;
    }
}