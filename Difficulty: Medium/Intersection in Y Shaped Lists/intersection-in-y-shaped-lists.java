/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node intersectPoint(Node head1, Node head2) {
        // code here
        Node node1= head1;
        Node node2= head2;
        while(node1!=node2){
            node1 = (node1==null)?head2:node1.next;
            node2 = (node2==null)?head1:node2.next;
        }
        return node1;
    }
}