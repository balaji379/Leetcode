class Solution {
    public int longestNiceSubarray(int[] nums) {
        int start = 0, end = 0, len = nums.length, sum = 0, max = 0;
        while (end < len) {
            if ((nums[end] & sum) == 0) {
                max = Math.max(max, (end - start)+1);
                sum += nums[end];
            } else {
                sum -= nums[start];
                start += 1;
                continue;
            }
            end += 1;
        }
        return   Math.max(max, (end - start));
    }
}