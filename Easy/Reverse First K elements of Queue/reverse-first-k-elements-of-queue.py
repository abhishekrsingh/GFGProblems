#User function Template for python3
'''
Function Arguments :
		@param  : q ( given queue to be used), k(Integer )
		@return : list, just reverse the first k elements of queue and return new queue
'''

from collections import deque

class Solution:
    def modifyQueue(self, queue, k):
        # Create a temporary deque to store the first k elements
        temp_queue = deque()

        # Pop the first k elements from the input queue and append them to the temporary queue
        for _ in range(k):
            temp_queue.append(queue.pop(0))

        # Insert the elements from the temporary queue to the start of the input queue
        for _ in range(k):
            queue.insert(0, temp_queue.popleft())

        return queue


#{ 
 # Driver Code Starts
#Initial Template for Python 3
import atexit
import io
import sys

#Contributed by : Nagendra Jha

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER

@atexit.register

def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())

if __name__ == '__main__':
    test_cases = int(input())
    for cases in range(test_cases) :
        n,k = map(int,input().strip().split())
        a = list(map(int,input().strip().split()))

        queue = [] # our queue to be used
        for i in range(n):
            queue.append(a[i]) # enqueue elements of array in our queue
        
        ob = Solution()
        print(*ob.modifyQueue(queue,k))
        
# } Driver Code Ends