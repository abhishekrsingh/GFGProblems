/* Node is defined as
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
  public:
    Node* segregate(Node* head) {
        // code here
        int zero = 0, ones = 0, twos = 0;
        Node* curr = head;
    
        // count 0s, 1s, 2s
        while (curr) {
            if (curr->data == 0) zero++;
            else if (curr->data == 1) ones++;
            else twos++;
            curr = curr->next;
        }
    
        // overwrite nodes
        curr = head;
        while (curr) {
            if (zero) {
                curr->data = 0;
                zero--;
            } else if (ones) {
                curr->data = 1;
                ones--;
            } else {
                curr->data = 2;
                twos--;
            }
            curr = curr->next;
        }
    
        return head;
    }
};