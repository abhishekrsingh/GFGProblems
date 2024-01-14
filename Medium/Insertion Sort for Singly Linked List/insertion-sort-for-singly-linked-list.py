#User function Template for python3

'''
# Node Class
class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None
'''

class Solution:
    def insertionSort(self, head):
        # Check if the linked list is empty or has only one element
        if not head or not head.next:
            return head

        # Initialize pointers and a dummy node
        previous_node, current_node_to_insert = None, None
        dummy_head = Node(-1)
        dummy_head.next = head

        # Traverse the linked list
        while head and head.next:
            # If the current node's value is less than or equal to the next node's value, move to the next node
            if head.data <= head.next.data:
                head = head.next
            else:
                # Set pointers to the dummy node and the node to be inserted
                previous_node, current_node_to_insert = dummy_head, head.next

                # Find the correct position for insertion
                while previous_node.next.data < current_node_to_insert.data:
                    previous_node = previous_node.next

                # Update pointers to perform the insertion
                head.next = head.next.next
                current_node_to_insert.next = previous_node.next
                previous_node.next = current_node_to_insert

        # Return the sorted linked list starting from the dummy node
        return dummy_head.next


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
    
# Node Class
INF = float("inf")
class Node:
    def __init__(self, data):   # data -> value stored in node
        self.data = data
        self.next = None

def printList(head):
    if head is None:
        print(' ')
        return
    curr_node = head
    while curr_node:
        print(curr_node.data,end=" ")
        curr_node=curr_node.next
    print(' ')
    
if __name__ == '__main__':
    t=int(input())
    for cases in range(t):
        n = int(input())
        a = Node(INF)
        nodes = list(map(int, input().strip().split()))
        ptr = a
        for x in nodes:
            ptr.next = Node(INF)
            ptr = ptr.next
            ptr.data = x
        a = a.next
        ob=Solution()
        head = ob.insertionSort(a)
        printList(head)
# } Driver Code Ends