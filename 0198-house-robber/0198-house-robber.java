class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        return solve(nums,dp,dp.length - 1);
    }
     public  int solve(int[] money, int[] dp, int index) {
        if (index == 0)
            return money[0];
        else if (index < 0)
            return 0;
        if (dp[index] != Integer.MIN_VALUE)
            return dp[index];
        int pick = money[index] + solve(money, dp, index - 2);
        int unpick = solve(money, dp, index - 1);
        dp[index] = Math.max(pick, unpick);
        return dp[index];
    }
}