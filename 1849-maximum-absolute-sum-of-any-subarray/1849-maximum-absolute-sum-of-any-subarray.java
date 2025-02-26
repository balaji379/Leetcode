class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
              int d = max[i-1] + nums[i];
              if (d > nums[i])
                 max[i] = d;
              else
                 max[i] = nums[i];
              d = min[i - 1] + nums[i];
              if (d < nums[i])
                 min[i] = d;
              else 
                 min[i] = nums[i];
        
    }
       int high = Math.abs(Arrays.stream(max).max().getAsInt());
       int low = Math.abs(Arrays.stream(min).min().getAsInt());
        return Math.max(high,low);
    }
}