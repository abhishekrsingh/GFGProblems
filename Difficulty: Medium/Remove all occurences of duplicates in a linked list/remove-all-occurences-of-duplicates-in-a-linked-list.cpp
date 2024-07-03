//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node {
    int data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};


// } Driver Code Ends
// User function Template for C++

/* Linked List node structure

struct Node {
    int data;
    struct Node *next;
};

*/

class Solution {
  public:
    Node* removeAllDuplicates(struct Node* head) {
        // Initialize pointers
        Node *prev = NULL, *curr = head;
        // This variable will keep track of the last duplicate number we encountered
        int num = -1e9;
        
        // Traverse the linked list
        while (curr) {
            // If the current node and the next node have the same data, it's a duplicate
            if (curr->next && curr->data == curr->next->data) {
                // Skip the next node
                curr->next = curr->next->next;
                // Store the duplicate number
                num = curr->data;
            } 
            else {
                // If the current node's data matches the last duplicate number, remove it
                if (num == curr->data) {
                    // If there's no previous node, update the head to the next node
                    if (!prev) {
                        head = curr->next;
                    } 
                    else {
                        // Otherwise, link the previous node to the next node
                        prev->next = curr->next;
                    }
                    // Reset the duplicate number
                    num = -1e9;
                    // Move to the next node
                    curr = curr->next;
                } 
                else {
                    // If it's not a duplicate, move the previous pointer to the current node
                    prev = curr;
                    // Move to the next node
                    curr = curr->next;
                }
            }
        }
        // Return the modified head of the linked list
        return head;
    }
};

//{ Driver Code Starts.
/* Function to print linked list */
void printList(struct Node *head) {
    struct Node *temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
}

// Driver program to test above functions
int main() {
    int T;
    cin >> T;

    while (T--) {
        int N;

        cin >> N;

        Node *head = NULL;
        Node *temp = head;

        for (int i = 0; i < N; i++) {
            int data;
            cin >> data;
            if (head == NULL)
                head = temp = new Node(data);
            else {
                temp->next = new Node(data);
                temp = temp->next;
            }
        }

        Solution ob;
        head = ob.removeAllDuplicates(head);
        printList(head);

        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends