class Solution {
    public int[] applyOperations(int[] nums) {
          for (int i = 0; i < nums.length - 1; i++)   {
            if (nums[i] == nums[i + 1]){
               nums[i] = nums[i] * 2;
               nums[i+1] = 0;
            }
          }
          int[] ans = new int[nums.length];
          int i = 0;
          for (int val : nums)
             if (val != 0)
                 ans[i++] = val;
          return ans;
    }
}