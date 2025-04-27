class Solution {
    public int countSubarrays(int[] nums) {
        int start = 0 , end = 0,count = 0;
        while (end < nums.length){
            if ((end - start ) + 1 == 3){
                int sum = nums[start] + nums[end];
                int second = nums[end - 1];
                if (second - sum == sum)
                    count += 1;
                start += 1;
            }
            end += 1;
        }
        return count;
    }
}