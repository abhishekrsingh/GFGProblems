//{ Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

/* Link list node */
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};

/* Function to print linked list */
void printList(struct Node *head)
{
	struct Node *temp = head;
	while (temp != NULL)
	{
		printf("%d ", temp->data);
		temp = temp->next;
	}
}




// } Driver Code Ends
//User function Template for C++

/*Link list node
struct Node {
	int data;
	struct Node *next;
	Node(int x) {
		data = x;
		next = NULL;
	}
};*/

class Solution
{
    public:
    Node* insertionSort(struct Node* ptr)
    {
        if(ptr==NULL || ptr->next==NULL){
            return ptr;
        }
        struct Node *dummy=new Node(0);
        dummy->next=ptr;
        struct Node *toInsert,*preInsert=NULL;
        while(ptr!=NULL && ptr->next!=NULL){
            if(ptr->data<=ptr->next->data){
                ptr=ptr->next;
            }else{
                toInsert=ptr->next;
                preInsert=dummy;
                while(preInsert->next->data < toInsert->data){
                    preInsert=preInsert->next;
                }
                ptr->next=toInsert->next;
                toInsert->next=preInsert->next;
                preInsert->next=toInsert;
            }
        }
        return dummy->next;
    }
    
};

//{ Driver Code Starts.
int main()
{
	int T;
	cin >> T;

	while (T--)
	{
		int n;
		cin >> n;

		Node *head = NULL;
		Node *temp = head;

		for (int i = 0; i < n; i++) {
			int data;
			cin >> data;
			if (head == NULL)
				head = temp = new Node(data);
			else
			{
				temp->next = new Node(data);
				temp = temp->next;
			}
		}

        Solution ob;

		head = ob.insertionSort(head);
		printList(head);

		cout << "\n";



	}
	return 0;
}
// } Driver Code Ends