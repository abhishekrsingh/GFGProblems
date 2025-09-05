/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    public Node reverseKGroup(Node head, int k) {
        // code here
        if (head == null || k == 1) {
            return head;
        }

        Stack<Node> st = new Stack<>();
        Node curr = head;
        Node prev = null;

        while (curr != null) {

            // Terminate the loop when either 
          	// current == null or count >= k
            int count = 0;
            while (curr != null && count < k) {
                st.push(curr);
                curr = curr.next;
                count++;
            }

            // Now pop the elements from the stack one by one
            while (!st.isEmpty()) {
              
                // If the final list has not been started yet
                if (prev == null) {
                    prev = st.pop();
                    head = prev;
                } else {
                    prev.next = st.pop();
                    prev = prev.next;
                }
            }
        }

        // Set the next pointer of the last node to null
        prev.next = null;

        return head;
    }
}