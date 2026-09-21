class Solution {
	public:
	vector<int> removeDuplicates(vector<int> &arr) {
		int n = arr.size(); // array ka size
		if (n <= 1) return arr; // 0 ya 1 element, as it is return karo
		
		int idx = 1; // unique elements ka pointer (2nd position se start)
		for (int i = 1; i < n; i++) // 2nd element se traverse karo
			if (arr[i] != arr[i - 1]) arr[idx++] = arr[i]; // agar previous se different hai, to copy karo
		
		return vector<int>(arr.begin(), arr.begin() + idx);
	}
	
	
	// 	vector<int> removeDuplicates(vector<int> &arr) {
	// 		// code here
	// 		if (arr.empty())
	// 			return {};
	
	// 		vector<int> result;
	// 		// Always include the first element
	// 		result.push_back(arr[0]);
	
	// 		for (int i = 1; i < arr.size(); i++) {
	// 			// Compare current element with previous element
	// 			if (arr[i] != arr[i - 1]) {
	// 				result.push_back(arr[i]);
	// 			}
	// 		}
	
	// 		return result;
	// 	}
	
	// O(n) - time and space
	// vector<int> removeDuplicates(vector<int> &arr) {
	//     // code here
	//     set<int> unique(arr.begin(), arr.end());
	//     vector<int> result(unique.begin(), unique.end());
	//     return result;
	// }
};
