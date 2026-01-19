class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            
            // While current frequency is greater 
            // than frequency at stack top
            while (!st.isEmpty() && freq.get(arr[i]) >
                                freq.get(arr[st.peek()])) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        // Convert array to ArrayList and return
        ArrayList<Integer> result = new ArrayList<>();
        for (int x : res) {
            result.add(x);
        }
        return result;
    }
}