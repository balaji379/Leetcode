class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = 0;
        int min = nums[0];
        int max = 0;
        int sub = 0,count = 0;
        while (end < nums.length)   {
              sub = Math.abs(nums[end] - nums[start]);
              if (sub > k){
                  count += 1;
                  start = end;
                  continue;
              }
              end += 1;
        }
        return count + 1;
    }
}