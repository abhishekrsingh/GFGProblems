/*
class Node {
public:
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/
class Solution {
  public:
    //Using priority_queue 
    Node* mergeSort(Node* head) {
        if (!head || !head->next) return head;
        
        // Create a min-heap (priority queue)
        priority_queue<int, vector<int>, greater<int>> pq;
        
        // Push all elements into the priority queue
        Node* temp = head;
        while (temp) {
            pq.push(temp->data);
            temp = temp->next;
        }
        
        // Extract elements from priority queue in sorted order
        temp = head;
        while (!pq.empty()) {
            temp->data = pq.top();
            pq.pop();
            temp = temp->next;
        }
        
        return head;
    }
    // Node* mergeSort(Node* head) {
    //     // code here
    //     vector<int> v;
    //     Node* temp = head;
    //     while(temp)
    //     {
    //         v.push_back(temp->data);
    //         temp = temp->next;
    //     }
    //     sort(v.begin(), v.end());
    //     temp = head;
    //     int i = 0;
    //     while(temp)
    //     {
    //         temp->data = v[i];
    //         temp = temp->next;
    //         i++;
    //     }
    //     return head;
    // }
};