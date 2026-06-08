/* Structure of a Linked List node
class Node {
  public:
    int data;
    Node* next;

    Node(int x) {
        data = x;
        next = nullptr;
    }
};
*/
class Solution {
private:
    // Helper function to reverse a linked list in-place
    Node* reverseList(Node* head) {
        Node* prev = nullptr;
        Node* curr = head;
        Node* nextNode = nullptr;

        while (curr != nullptr) {
            nextNode = curr->next;
            curr->next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

public:
    Node* compute(Node* head) {
        if (!head || !head->next) return head;

        // Step 1: Reverse the linked list
        head = reverseList(head);

        // Step 2: Traverse and remove nodes smaller than max_so_far
        Node* curr = head;
        Node* maxNode = head; // The first node in reversed list is always kept
        
        while (curr != nullptr && curr->next != nullptr) {
            if (curr->next->data < maxNode->data) {
                // The next node is smaller than the max seen so far -> Delete it
                Node* temp = curr->next;
                curr->next = temp->next;
                delete temp; 
            } else {
                // The next node is >= max seen so far -> Update max and move forward
                curr = curr->next;
                maxNode = curr;
            }
        }

        // Step 3: Reverse the list back to its original relative order
        return reverseList(head);
    }
};