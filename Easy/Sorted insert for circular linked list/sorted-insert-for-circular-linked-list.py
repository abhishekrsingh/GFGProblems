#User function Template for python3

'''
class Node: 
    # Constructor to initialize the node object 
    def __init__(self, data): 
        self.data = data 
        self.next = None
  '''
class Solution:
    def sortedInsert(self, head, data):
        new_node = Node(data)

        # If the linked list is empty, insert the new node and return it as the head.
        if not head:
            new_node.next = new_node
            return new_node

        # If the data to be inserted is smaller than or equal to the head, insert at the beginning.
        if head.data >= data:
            curr = head
            while curr.next != head:
                curr = curr.next
            new_node.next, curr.next = head, new_node
            return new_node
        else:
            # Traverse the linked list to find the correct position for insertion.
            curr = head
            while True:
                # Insert the new node when the next node has greater or equal data, or we reach the end.
                if curr.next.data >= data or curr.next == head:
                    new_node.next, curr.next = curr.next, new_node
                    return head
                curr = curr.next


#{ 
 # Driver Code Starts
#contributed by RavinderSinghPB
class Node: 
    # Constructor to initialize the node object 
    def __init__(self, data): 
        self.data = data 
        self.next = None
  
class LinkedList: 
  
    # Function to initialize head 
    def __init__(self): 
        self.head = None
        self.last=None
  
    # Function to insert a new node  
    def push(self, data):
        if not self.head:
            nn=Node(data)
            self.head=nn
            self.last=nn
            nn.next=nn
            return
        nn=Node(data)
        nn.next=self.head
        self.last.next=nn
        self.last=nn 
  

# Utility function to print the linked LinkedList

def printList(head):
    if not head:
        return
    temp = head 
    print (temp.data,end=' ') 
    temp = temp.next
    while(temp != head): 
        print (temp.data,end=' ') 
        temp = temp.next
  
    
if __name__ =='__main__':
    t=int(input())
    for tcs in range(t):
        n=int(input())
        arr=[int(x) for x in input().split()]
        data=int(input())

        cll=LinkedList()
        for e in arr:
            cll.push(e)
            
        reshead=Solution().sortedInsert(cll.head,data)
        printList(reshead)
        print()
        


# } Driver Code Ends