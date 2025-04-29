class Solution {
    public long countSubarrays(int[] nums, int k) {
          int max = 0;
          for (int val : nums)
             max = Math.max(max,val);
          int count = 0; 
          int start = 0, end = 0;
          long ans = 0;
          while(end < nums.length){
            if (nums[end] == max)
               count += 1;
            if (count >= k){
                while (start <= end && count >= k){
                ans += nums.length - end;
                if (nums[start] == max)
                   count -= 1;
                start += 1; 
                }
            }
            end += 1;
          }
          return ans;
    }
}