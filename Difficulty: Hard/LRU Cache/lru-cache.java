//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    static void add(Node node)
    {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
    static void remove(Node node)
    {
        Node nextNode = node.next;
        Node prevNode = node.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    static class Node
    {
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value)
        {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    static HashMap<Integer,Node> map ;
    static Node head;
    static Node tail;
    static int cap;
    LRUCache(int cap) {
        this.cap = cap;
        this.map=new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
         if(map.containsKey(key))
         {
             Node oldNode = map.get(key);
             remove(oldNode);
         }
         Node node = new Node(key,value);
         map.put(key,node);
         add(node);
         if(map.size()>cap)
         {
             Node nodeToDelete = tail.prev;
             remove(nodeToDelete);
             map.remove(nodeToDelete.key);
         }
        
    }
}
