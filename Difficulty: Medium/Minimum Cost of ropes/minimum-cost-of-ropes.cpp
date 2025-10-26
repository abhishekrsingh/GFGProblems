class Solution {
  public:
    int minCost(vector<int>& arr) {
        // code here
        int n = arr.size();
        int cost = 0;
        
        // Correct priority_queue declaration
        priority_queue<int, vector<int>, greater<int>> pq(arr.begin(), arr.end());
        
        while(pq.size() != 1) {
            int a = pq.top(); pq.pop();
            int b = pq.top(); pq.pop();
            
            int sum = a + b;
            cost += sum;
            pq.push(sum);
        }
        return cost;
    }
};