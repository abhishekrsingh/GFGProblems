class Solution {
	public:
	void segregateElements(vector<int>& arr) {
		// code here
		int n = arr.size();
		vector<int> positive;
		vector<int> negative;
		for (int i = 0; i<n; i++) {
			if (arr[i] >= 0)positive.push_back(arr[i]);
			else
				negative.push_back(arr[i]);
		}
		// Step 2: Copy all positive elements back to arr
		int i = 0;
		for (int j = 0; j < positive.size(); j++) {
			arr[i] = positive[j];
			i++;
		}
		
		// Step 3: Copy all negative elements back to arr right after positive ones
		for (int j = 0; j < negative.size(); j++) {
			arr[i] = negative[j];
			i++;
		}
	}
};
