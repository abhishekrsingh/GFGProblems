class Solution {
  public:
    bool validgroup(vector<int>& arr, int k) {
        int n = arr.size();                   // total number of balls

        sort(arr.begin(), arr.end());         // bring consecutive numbers together

        for (int i = 0; i < n; i++) {
            if (arr[i] == -1) {                // already used in a previous group
                continue;
            }

            int curr  = arr[i];               // the next expected number in the group
            int count = 0;                    // how many balls have been added to the current group

            for (int j = i; j < n; j++) {
                if (arr[j] == curr) {         // found the next consecutive ball
                    curr++;                   // expect the next number in sequence
                    count++;                  // one more ball added to this group
                    arr[j] = -1;              // mark this ball as used
                }

                if (count == k) {              // the group is complete
                    break;
                }
            }

            if (count != k) {                  // could not form a full group of size k
                return false;
            }
        }
        return true;                          // all balls successfully grouped
    }
};