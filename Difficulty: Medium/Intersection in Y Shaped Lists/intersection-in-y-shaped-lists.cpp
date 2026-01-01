/*
class Node {
public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
  public:
    // reverses a linked list
    Node* reverse(Node* node) {
        Node *prev = nullptr, *curr = node;
        while (curr) {
            Node *temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    // finds the intersection point of two
    // linked lists
    Node* intersectPoint(Node* head1, Node* head2) {
        if (!head1 || !head2) return nullptr;
    
        // reverse the second list
        Node* revHead2 = reverse(head2);
    
        // attach reversed second list to the
        // end of the first
        Node* temp = head1;
        while (temp->next)
            temp = temp->next;
        temp->next = revHead2;
    
        // detect cycle using Floyd’s algorithm
        Node* slow = head1;
        Node* fast = head1;
    
        while (fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
    
            if (slow == fast) { 
                slow = head1;
                while (slow != fast) {
                    slow = slow->next;
                    fast = fast->next;
                }
                return slow;
            }
        }
    
        return nullptr;
    }
};