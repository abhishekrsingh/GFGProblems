
from typing import List


class Solution:
    def max_courses(self, n, total, cost):
        dp = [[None] * (total + 1) for _ in range(n)]

        def helper(arr, n, total, pos):
            if pos == n:return 0
            if dp[pos][total]:return dp[pos][total]
            dp[pos][total] = max(helper(arr, n, total, pos + 1),
                (1+helper(arr, n, total-arr[pos]+int(0.9*arr[pos]), pos+1)) if arr[pos]<=total else 0)
            return dp[pos][total]
        
        return helper(cost, len(cost), total, 0)
        



#{ 
 # Driver Code Starts

class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        
        total = int(input())
        
        
        cost=IntArray().Input(n)
        
        obj = Solution()
        res = obj.max_courses(n, total, cost)
        
        print(res)
        

# } Driver Code Ends