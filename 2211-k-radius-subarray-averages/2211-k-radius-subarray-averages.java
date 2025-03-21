class Solution {
    public int[] getAverages(int[] nums, int k) {
           
           long[] prefix = new long[nums.length + 1];
           for (int i = 1; i < prefix.length; i++){
             prefix[i]  = nums[i-1] + prefix[i - 1];
           }
        //    [0, 7, 11, 14, 23, 24, 32, 37, 39, 45]
           int[] ans = new int[nums.length];
           Arrays.fill(ans,-1);
           for (int i = k; i < nums.length - k; i++){
               int left = i - k;
               int right = i + k;
               if (left < 0 || right >= prefix.length)
                    ans[i] = -1;
                else {
                       ans[i] = (int)((prefix[right + 1] - prefix[left]) / ((right - left) + 1));
                }
           }
            return ans;
    } 
}