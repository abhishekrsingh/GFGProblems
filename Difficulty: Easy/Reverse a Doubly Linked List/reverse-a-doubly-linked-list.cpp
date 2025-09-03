/*
class Node {
  public:
    int data;
    Node *next;
    Node *prev;
    Node(int val) {
        data = val;
        next = NULL;
        prev = NULL;
    }
};

*/
class Solution {
  public:
    Node *reverse(Node *head) {
        // code here
        if(!head && head->next) return head;
        stack<int> st;
        Node* temp = head;
        while(temp)
        {
            st.push(temp->data);
            temp = temp->next;
        }
        temp = head;
        while(temp)
        {
            temp->data = st.top();
            st.pop();
            temp = temp->next;
        }
        return head;
    }
};