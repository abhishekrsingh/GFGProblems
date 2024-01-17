#User function Template for python3

class Solution:
    def numberSequence(self, current_value, remaining_steps):
        # Base case: if remaining steps are 0, return 1
        if remaining_steps == 0:
            return 1
       
        # Base case: if current value is less than remaining steps, return 0
        if current_value < remaining_steps:
            return 0

        # Recursive case: calculate the number sequence based on the given formula
        return self.numberSequence(current_value - 1, remaining_steps) + \
               self.numberSequence(current_value >> 1, remaining_steps - 1)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range (t):
        arr = input().split()
        m = int(arr[0])
        n = int(arr[1])
        
        ob = Solution()
        print(ob.numberSequence(m, n))
# } Driver Code Ends