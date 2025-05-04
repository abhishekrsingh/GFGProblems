//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    Node primeList(Node head) {
        // code here
        int max=Integer.MIN_VALUE;
        Node cur=head;
        while(cur!=null){
            max=Math.max(cur.val,max);
            cur=cur.next;
        }
        boolean prime[]=new boolean[max+100];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<prime.length;i++){
            if(prime[i]){
                for(int j=i*i;j<prime.length;j+=i){
                    prime[j]=false;
                }
            }
        }
        cur=head;
        while(cur!=null){
            if(!prime[cur.val]){
                int left=cur.val-1;
                int right=cur.val+1;
                while(true){
                    if(left>=2 && prime[left]){
                        cur.val=left;
                        break;
                    }
                    if(right<prime.length && prime[right]){
                        cur.val=right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            cur=cur.next;
        }
        return head;
    }
}