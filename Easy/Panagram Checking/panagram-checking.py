#User function Template for python3

class Solution:
    def checkPangram(self,s):
        #code here
        a="abcdefghijklmnopqrstuvwxyz"
        c=("".join("".join(s.split()).split(','))).lower()
        if len(c)<26:
            return False
        else:
            for i in c:
                if i in a:
                    a=a[:a.index(i)]+a[a.index(i)+1:]
            if a=="":
                return True
            else:
                return False


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__=='__main__':
    t = int(input())
    for i in range(t):
        s=str(input())
        obj = Solution()
        if(obj.checkPangram(s)):
            print(1)
        else:
            print(0)
# } Driver Code Ends