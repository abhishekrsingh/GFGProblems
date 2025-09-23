class Solution {
  public:
    void reverseQueue(queue<int> &q) {
        // code here
        if (q.empty()) return;

        // remove front element
        int front = q.front();
        q.pop();
    
        // reverse remaining queue
        reverseQueue(q);
    
        // insert removed element at the rear
        q.push(front);
    }
};