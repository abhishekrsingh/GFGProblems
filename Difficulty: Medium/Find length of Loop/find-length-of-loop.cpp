/*
class Node {
 public:
    int data;
    Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/

class Solution {
  public:
    int lengthOfLoop(Node *head) {
        // If list is empty, no loop exists
        if(!head) return 0;
        
        Node* slow = head;
        Node* fast = head;
        
        // Phase 1: Detect if loop exists using Floyd's algorithm
        while(fast && fast->next) {
            slow = slow->next;          // Tortoise: moves 1 step
            fast = fast->next->next;    // Hare: moves 2 steps
            
            // If they meet, loop exists
            if(slow == fast) {
                // Phase 2: Measure loop length
                int length = 1;
                Node* temp = slow->next;
                
                // Move one pointer around the loop until it comes back
                while(temp != slow) {
                    length++;
                    temp = temp->next;
                }
                return length;  // Return the counted length
            }
        }
        
        return 0;  // No loop found
    }
};