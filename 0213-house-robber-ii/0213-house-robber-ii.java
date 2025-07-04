class Solution {
    
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        int first = solve(nums,dp,nums.length - 1,false);
        Arrays.fill(dp,Integer.MIN_VALUE);
        int seconde = solve(nums,dp,nums.length - 2,true);
        int ans =  Math.max(seconde,first);
        return ans == 0 ? nums[0] : ans;
    }

    public  int solve(int[] money, int[] dp, int index,boolean flag) {
        if (index == 0) {
            if (flag)
                return money[0];
            else return 0;
        } else if (index < 0)
            return 0;
        if (dp[index] != Integer.MIN_VALUE)
            return dp[index];


        int pick = money[index] + solve(money, dp, index - 2,flag);
        int unpick = solve(money, dp, index - 1,flag);
        dp[index] = Math.max(pick, unpick);
        return dp[index];
    }
}