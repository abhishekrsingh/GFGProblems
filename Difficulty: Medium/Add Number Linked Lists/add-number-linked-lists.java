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
    public Node reverseLL(Node head){
        Node past = null;
        Node present = head;
        Node future = null;
        
        while(present != null){
            future = present.next;
            present.next = past;
            past = present;
            present = future;
        }
        return past;
    }
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        
        head1 = reverseLL(head1);
        head2 = reverseLL(head2);
        
        Node head = null;
        Node tail = null;
        int quo = 0;
        int rem = 0;
        
        while((head1 != null) && (head2 != null)){
            int sum = (head1.data + head2.data + quo);
            rem = sum % 10;
            quo = sum / 10;
            if(head == null){
                Node temp = new Node(rem);
                head = temp;
                tail = temp;
            }else{
                Node temp = new Node(rem);
                tail.next = temp;
                tail = temp;
            }
            
            head1 = head1.next;
            head2 = head2.next;
        }
        
        while(head1 != null){
            int sum = (head1.data + quo);
            rem = sum % 10;
            quo = sum / 10;
            if(head == null){
                Node temp = new Node(rem);
                head = temp;
                tail = temp;
            }else{
                Node temp = new Node(rem);
                tail.next = temp;
                tail = temp;
            }
            head1 = head1.next;
        }
        while(head2 != null){
            int sum = (head2.data + quo);
            rem = sum % 10;
            quo = sum / 10;
            if(head == null){
                Node temp = new Node(rem);
                head = temp;
                tail = temp;
            }else{
                Node temp = new Node(rem);
                tail.next = temp;
                tail = temp;
            }
            head2 = head2.next;
        }
        if(quo != 0){
            if(head == null){
                Node temp = new Node(quo);
                head = temp;
                tail = temp;
            }else{
                Node temp = new Node(quo);
                tail.next = temp;
                tail = temp;
            }
        }
        head = reverseLL(head);
        Node finalHead = null;
        
        while((head != null) && (head.data == 0)){
            head = head.next;
        }
        finalHead = head;
        return finalHead;
    }
}