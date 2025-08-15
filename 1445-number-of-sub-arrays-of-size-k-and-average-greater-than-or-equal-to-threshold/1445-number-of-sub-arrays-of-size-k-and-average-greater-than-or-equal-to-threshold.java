class Solution {
    public int numOfSubarrays(int[] nums, int k, int threshold) {
        int ans = 0;
        int sum = 0, n = nums.length;
        for(int i = 0; i < k; i++) sum += nums[i];
        if(sum/k >= threshold) ans++;
        for(int i = k; i < n; i++){
            sum -= nums[i-k];
            sum += nums[i];
            if(sum/k >= threshold) ans++;
        } 
        return ans;
    }
}