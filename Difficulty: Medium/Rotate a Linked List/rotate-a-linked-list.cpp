//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

void printList(Node* node) {
    while (node != NULL) {
        cout << node->data << " ";
        node = node->next;
    }
    cout << "\n";
}


// } Driver Code Ends
/*

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/

class Solution {
  public:
    // Function to rotate a linked list.
    Node* rotate(Node* head, int k) {
        if (head == NULL || head->next == NULL || k == 0)
            return head;
        
        // Find the kth node and the last node
        Node* current = head;
        Node* kthNode = NULL;
        int length = 1;
        
        while (current->next != NULL) {
            if (length == k)
                kthNode = current;
            
            current = current->next;
            length++;
        }
        
        // If k equals the length of the list, no rotation needed
        if (k == length)
            return head;
        
        // If k is greater than the length, adjust k
        if (k > length)
            return rotate(head, k % length);
        
        // If kthNode is NULL, k is equal to length
        if (kthNode == NULL)
            kthNode = current;
        
        // Perform the rotation
        current->next = head;  // Connect last node to the original head
        head = kthNode->next;  // New head is the (k+1)th node
        kthNode->next = NULL;  // Set the new last node
        
        return head;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;

        // Read numbers from the input line
        while (ss >> number) {
            arr.push_back(number);
        }

        Node* head = nullptr;

        // Check if the array is empty
        if (!arr.empty()) {
            head = new Node(arr[0]);
            Node* tail = head;
            for (size_t i = 1; i < arr.size(); ++i) {
                tail->next = new Node(arr[i]);
                tail = tail->next;
            }
        }
        int k;
        cin >> k;
        cin.ignore();

        Solution ob;
        head = ob.rotate(head, k);
        printList(head);
    }
    return 1;
}

// } Driver Code Ends