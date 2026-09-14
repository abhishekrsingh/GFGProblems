class Solution {
  public:
    int search(vector<int>& arr, int x) {
        auto it = find(arr.begin(), arr.end(), x); // x dhundo
        return it == arr.end() ? -1 : it - arr.begin(); // agar mila to index, warna -1
    }
};