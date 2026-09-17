class Solution {
	public int bs(int arr[], int x) {
		if (arr[arr.length - 1]<5*x)
			return - 1;
		int l = 0;
		int h = arr.length - 1;
		int ans = arr.length;
		while (l <= h) {
			int mid = l + (h - l)/2;
			if (arr[mid] >= 5*x) {
				ans = mid;
				h = mid - 1;
				
			} else l = mid + 1;
		}
		return ans;
	}
	public int dominantPairs(int[] arr) {
		// Code here
		int n = arr.length;
		int fh[] = new int[n/2];
		int sh[] = new int[n/2];
		for (int i = 0; i<n/2; i++)
			fh[i] = arr[i];
		for (int i = n/2; i<n; i++)
			sh[i - n/2] = arr[i];
		int ct = 0;
		Arrays.sort(fh);
		for (int i = 0; i<n/2; i++) {
			int id = bs(fh, sh[i]);
			if (id != -1) {
				ct += (n/2) - id;
			}
		}
		return ct;
	}
}
