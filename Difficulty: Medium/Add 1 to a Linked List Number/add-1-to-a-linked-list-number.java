//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class GfG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = str.length;
            Node head = new Node(Integer.parseInt(str[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(str[i]));
                tail = tail.next;
            }
            Solution obj = new Solution();
            head = obj.addOne(head);
            printList(head);
        }
    }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public static Node reverse(Node head){
        Node prev=null;
        Node current=head;
        Node next=null;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
    public static Node addOne1(Node head) 
    { 
       head=reverse(head);
       Node temp=head;
       boolean carry=false;
       boolean add=true;
       while(temp!=null){
           if(temp.next!=null && add==true && temp.data+1>9){
               carry=true;
               temp.data=0;
           }
           else if(add==true){
               carry=false;
               temp.data=temp.data+1;
               add=false;
           }
           temp=temp.next;
       }
       Node temp2=reverse(head);
       return temp2;
    }
    
    public static int helper(Node temp) {
        if(temp==null){
            return 1;
        }
        int carry = helper(temp.next);
        temp.data+=carry;
        if(temp.data<10){
            return 0;
        }
        temp.data=0;
        return 1;
    }

    public static Node addOne(Node head) {
        int x = helper(head);
        if (x != 0) {
            Node newHead = new Node(x);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
}
