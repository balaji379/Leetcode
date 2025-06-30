class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));
        int val = solve(dp, nums, 0, nums.length - 1);
        if (val >= 0)
            return true;
        return false;
    }

    public int solve(int[][] dp, int[] nums, int l, int r) {
        
        if (dp[l][r] != -1)
            return dp[l][r];
        if (l == r) {
            return nums[l];
        }
        int left_score = nums[l] - solve(dp, nums, l + 1, r);
        int right_score = nums[r] - solve(dp, nums, l, r - 1);
        dp[l][r] = Math.max(left_score, right_score);
        return dp[l][r];
    }
}