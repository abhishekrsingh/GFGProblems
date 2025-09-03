/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        // code here
        if (head == null) return head;

        // Count length
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // if k is more than length, no swap
        if (k > n) return head;

        // if kth from start and end are same, no swap
        if (2 * k - 1 == n) return head;

        // find kth node from start and its prev
        Node prevX = null;
        Node x = head;
        for (int i = 1; i < k; i++) {
            prevX = x;
            x = x.next;
        }

        // find kth node from end and its prev
        Node prevY = null;
        Node y = head;
        for (int i = 1; i < n - k + 1; i++) {
            prevY = y;
            y = y.next;
        }

        // adjust previous pointers
        if (prevX != null) prevX.next = y;
        if (prevY != null) prevY.next = x;

        // swap next pointers
        Node tempNext = x.next;
        x.next = y.next;
        y.next = tempNext;

        // change head if needed
        if (k == 1) head = y;
        if (k == n) head = x;

        return head;
    }
}
