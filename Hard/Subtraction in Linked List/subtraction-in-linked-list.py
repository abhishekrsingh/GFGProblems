#User function Template for python3

class Solution:
    def subLinkedList(self, list1, list2):
        # Helper function to convert linked list to decimal value
        def linkedListToDecimal(head):
            decimal_value = 0

            while head:
                decimal_value = (decimal_value * 10) + head.data
                head = head.next

            return decimal_value

        # Calculate the absolute difference of decimal values
        difference = abs(linkedListToDecimal(list1) - linkedListToDecimal(list2))

        # Convert the difference to a string for easy iteration
        difference_str = str(difference)

        # Initialize head and temp pointers for the result linked list
        result_head = result_temp = None

        # Iterate through each digit of the difference to create the result linked list
        for digit in difference_str:
            if not result_head:
                result_head = result_temp = Node(int(digit))
            else:
                result_temp.next = Node(int(digit))
                result_temp = result_temp.next

        return result_head



#{ 
 # Driver Code Starts
#Initial Template for Python 3

# Node Class
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

# Linked List Class
class LinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    # creates a new node with given value and appends it at the end of the linked list
    def insert(self, val):
        if self.head is None:
            self.head = Node(val)
            self.tail = self.head
        else:
            self.tail.next = Node(val)
            self.tail = self.tail.next

# prints the elements of linked list starting with head
def printList(n):
    while n:
        print(n.data,end='')
        n = n.next
    print()

if __name__ == '__main__':
    for _ in range(int(input())):
        
        n = int(input())
        arr1 = ( int(x) for x in input() )
        LL1 = LinkedList()
        for i in arr1:
            LL1.insert(i)
        
        m = int(input())
        arr2 = ( int(x) for x in input() )
        LL2 = LinkedList()
        for i in arr2:
            LL2.insert(i)
        
        ob = Solution()
        res = ob.subLinkedList(LL1.head, LL2.head)
        printList(res)
# } Driver Code Ends