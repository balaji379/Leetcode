class Solution {
    public int longestConsecutive(int[] nums) {
        int count = 0, maxcount = -1;
        Arrays.sort(nums);
        int left = 0, right = 0;
        while (right < nums.length) {
            if (right == left) {
                count += 1;
                right += 1;
            } else if ((nums[left] + 1) == nums[right]) {
                count += 1;
                left += 1;
                right += 1;
            } else if (nums[left] == nums[right]) {
                right += 1;
                left += 1;
            } else {
                maxcount = Math.max(maxcount, count);
                count = 0;
                left = right;
            }

        }
        return Math.max(maxcount, count);
          }
}