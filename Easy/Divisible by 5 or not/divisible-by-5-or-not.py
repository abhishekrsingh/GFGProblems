#User function Template for python3

class Solution:

    def isDivisibleBy5(self, Bin):
        # code here
        x = 0
        for e in Bin:
            x = (x+int(e))*2%5
        return "Yes" if x == 0 else "No" 


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':

    t = int(input())

    for _ in range(t):
        Bin = input()

        solObj = Solution()

        print(solObj.isDivisibleBy5(Bin))
# } Driver Code Ends