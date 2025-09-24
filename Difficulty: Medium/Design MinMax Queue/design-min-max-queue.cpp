#include <queue>
#include <deque>
using namespace std;

class SpecialQueue {

  public:
    queue<int> q;  // Main queue to store elements
    deque<int> minDeque;  // Deque to track minimum elements
    deque<int> maxDeque;  // Deque to track maximum elements

    void enqueue(int x) {
        // Insert element into the queue
        q.push(x);
        
        // Maintain minDeque: remove elements greater than x from back
        while (!minDeque.empty() && minDeque.back() > x) {
            minDeque.pop_back();
        }
        minDeque.push_back(x);
        
        // Maintain maxDeque: remove elements smaller than x from back
        while (!maxDeque.empty() && maxDeque.back() < x) {
            maxDeque.pop_back();
        }
        maxDeque.push_back(x);
    }

    void dequeue() {
        // Check if queue is empty
        if (q.empty()) return;
        
        // Get the front element about to be removed
        int frontElement = q.front();
        q.pop();
        
        // Remove from minDeque if it's the current minimum
        if (frontElement == minDeque.front()) {
            minDeque.pop_front();
        }
        
        // Remove from maxDeque if it's the current maximum
        if (frontElement == maxDeque.front()) {
            maxDeque.pop_front();
        }
    }

    int getFront() {
        // Get front element
        if (q.empty()) {
            throw runtime_error("Queue is empty");
        }
        return q.front();
    }

    int getMin() {
        // Get minimum element
        if (minDeque.empty()) {
            throw runtime_error("Queue is empty");
        }
        return minDeque.front();  // Front of minDeque is always current min
    }

    int getMax() {
        // Get maximum element
        if (maxDeque.empty()) {
            throw runtime_error("Queue is empty");
        }
        return maxDeque.front();  // Front of maxDeque is always current max
    }
};