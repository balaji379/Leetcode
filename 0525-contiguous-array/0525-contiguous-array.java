class Solution {
    public int findMaxLength(int[] nums) {
         HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        int pre = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + pre;
            pre = nums[i];
            if (nums[i] == 0) {
                maxLength = Math.max(maxLength, i + 1);
                if (!map.containsKey(nums[i]))
                    map.put(nums[i], i);
            }
            if (map.containsKey(nums[i])) {
                maxLength = Math.max(maxLength, i - (map.get(nums[i])));
            } else
                map.put(nums[i], i);
        }
        return maxLength;
    }
}