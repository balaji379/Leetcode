class Solution {
    public int[] getAverages(int[] nums, int k) { 
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        for(int i = k; i < n-k; i++){
            long sum = 0;
            for(int j = i-k; j <= i+k; j++) sum += nums[j];
            ans[i] = (int)(sum/(k*2+1));
        }
        return ans;
    }
}