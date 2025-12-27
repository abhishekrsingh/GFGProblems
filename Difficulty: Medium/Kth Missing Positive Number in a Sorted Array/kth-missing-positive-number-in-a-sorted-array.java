class Solution {
    public int kthMissing(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int missing = 0;
        int count = 1;
       for(int i = 1;i<nums.length;i++){
           if(nums[i] - nums[i-1] == 1){
               count++;
           }
       }
        if(count == nums.length && nums[0] == 1){
                nums[nums.length - 1] = nums[nums.length - 1] + k;
                return nums[nums.length - 1];
        }
        else {
             for (int num : nums) {
                set.add(num);
            }
            int max = Collections.max(set);
            for (int i = 1; i <=max ; i++) {
                if (!set.contains(i)) {
                    list.add(i);
                }
            }
            if(list.size() >= k){
                missing =  list.get(k - 1);
            }
            else{
                missing = max + (k - list.size());
            }
        }
        return missing;
    }
}