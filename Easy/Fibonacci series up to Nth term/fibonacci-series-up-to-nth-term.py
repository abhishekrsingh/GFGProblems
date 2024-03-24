#User function Template for python3

class Solution:
     def series(self, n):
        if n == 0 : return [0]
        mod = 10**9 +7
        l = [0,1]
        for i in range(2,n+1):
            l.append((l[i-1]+l[i-2])%mod)
        return l


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N = int(input())
        ob = Solution()
        result = ob.series(N)
        print(*result)
# } Driver Code Ends