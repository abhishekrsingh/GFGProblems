class SpecialQueue {
    Deque<Integer>dq=new ArrayDeque<>();
    Map<Integer,Integer>mp=new HashMap<>();
    PriorityQueue<Integer>max=new PriorityQueue<>((a,b)->b-a);
    PriorityQueue<Integer>min=new PriorityQueue<>();

    public SpecialQueue() {
        // Define Data Structures
    }

    public void enqueue(int x) {
        // Insert element into the queue
        dq.addLast(x);
        mp.put(x,mp.getOrDefault(x,0)+1);
        max.add(x);
        min.add(x);
    }

    public void dequeue() {
        // Remove element from the queue
        int x=dq.removeFirst();
        mp.put(x,mp.getOrDefault(x,0)-1);
        if(mp.get(x)==0)mp.remove(x);
    }

    public int getFront() {
        // Get front element
        return dq.peekFirst();
    }

    public int getMin() {
        // Get minimum element
        while(!min.isEmpty() && !mp.containsKey(min.peek()))
        {
            min.remove();
        }
        return min.peek();
    }

    public int getMax() {
        // Get maximum element
        while(!max.isEmpty() && !mp.containsKey(max.peek()))
        {
            max.remove();
        }
        return max.peek();
    }
}