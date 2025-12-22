class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, int[]> position = new HashMap<>();

        int key = arr[0];
        int l = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != key) {
                position.put(key, new int[]{l, i - 1});
                key = arr[i];
                l = i;
            }
        }
        position.put(key, new int[]{l, arr.length - 1});

        for (int[] q : queries) {
            int ql = q[0];
            int qr = q[1];
            int x = q[2];

            if (!position.containsKey(x)) {
                result.add(0);
                continue;
            }

            int[] range = position.get(x);

            int overlap =
                Math.max(0,
                    Math.min(qr, range[1]) -
                    Math.max(ql, range[0]) + 1);

            result.add(overlap);
        }
        return result;
    }
}