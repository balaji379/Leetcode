class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         int start = 0, end = 0;
         Set<Integer> set = new HashSet();
         long sum = 0,max = 0;
         while (end < nums.length){
               if (set.contains(nums[end])){
                   while (start <= end && set.contains(nums[end])){
                    sum -= nums[start];
                    set.remove(nums[start]);
                    start += 1;
                   }
                   sum += nums[end];
                   set.add(nums[end]);
               }else{ 
                set.add(nums[end]);
                sum += nums[end];
               }
               if ((end - start) + 1 == k){
                 max = Math.max(max,sum);
                 sum -= nums[start];
                 set.remove(nums[start]);
                 start += 1;
               }
               end += 1;
         }
         return max;
    }
}