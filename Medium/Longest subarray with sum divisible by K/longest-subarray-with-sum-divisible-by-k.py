class Solution:
    def longSubarrWthSumDivByK(self, nums, length, k):
        # Dictionary to store the remainder and its corresponding index
        remainder_index_map = {0: -1}
        current_remainder_sum, max_length = 0, 0

        for i in range(length):
            # Calculate the cumulative remainder sum
            current_remainder_sum = (current_remainder_sum + nums[i]) % k

            # Check if the current remainder has been seen before
            if current_remainder_sum in remainder_index_map:
                # Update the maximum length if the current subarray is longer
                max_length = max(max_length, i - remainder_index_map[current_remainder_sum])
            else:
                # Store the index of the current remainder if it's encountered for the first time
                remainder_index_map[current_remainder_sum] = i

        return max_length




#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

	for _ in range(0,int(input())):
		n, K = map(int ,input().split())
		arr = list(map(int,input().strip().split()))
		ob = Solution()
		res = ob.longSubarrWthSumDivByK(arr, n, K)
		print(res)




# } Driver Code Ends