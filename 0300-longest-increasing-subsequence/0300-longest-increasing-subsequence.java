class Solution {
    public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length + 1];
        getLongestCount(nums,0,Integer.MIN_VALUE,dp);
        int max = -1;
        return dp[0] - 1;
    }
    public int getLongestCount(int[] nums,int index,int pre,int[] dp){
        if (index == nums.length)
              return 1;
        int max = 0;
        if (dp[index] != 0)
             return dp[index];
        for (int i = index; i < nums.length; i++){
            if (pre < nums[i]){
                int ans = getLongestCount(nums,i + 1,nums[i],dp);
                max = Math.max(ans,max);
            }
        }
        dp[index] = max + 1;
        return dp[index];
    }
}