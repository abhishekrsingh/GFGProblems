class Solution {
	public:
	vector<int> arrangeOddAndEven(vector<int>& arr) {
		vector<int> ev, od; // even aur odd elements alag rakhne ke liye
		for (int x : arr) { // array ke har element ko check karo
			if (x % 2 == 0) // agar even hai
				ev.push_back(x); // to ev list me daalo
			else // agar odd hai
				od.push_back(x); // to od list me daalo
		}
		
		vector<int> res; // final answer store karne ke liye
		int i = 0, j = 0; // i -> ev ka pointer, j -> od ka pointer
		
		for (int k = 0; k < arr.size(); k++) { // result ki har position fill karo
			if (k % 2 == 0) { // agar position even hai
				if (i < ev.size()) { // agar ev me element bacha hai
					res.push_back(ev[i]); // use daal do
					i++; // pointer aage badhao
				} else { // agar ev khatam ho gaya
					res.push_back(od[j]); // to od se leftover daal do
					j++;
				}
			} else { // agar position odd hai
				if (j < od.size()) { // agar od me element bacha hai
					res.push_back(od[j]); // use daal do
					j++;
				} else { // agar od khatam ho gaya
					res.push_back(ev[i]); // to ev se leftover daal do
					i++;
				}
			}
		}
		
		return res; // final arranged array return karo
	}
};
