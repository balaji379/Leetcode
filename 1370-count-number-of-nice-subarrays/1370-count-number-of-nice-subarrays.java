class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
          return Math.abs(solve(k,nums)  - solve(k - 1,nums));
    }
    public int solve(int k ,int...nums){
        if (k < 0)
           return 0;
        int ans = 0 , count = 0,start = 0;
        for (int i = 0; i < nums.length; i++){
             if (nums[i] % 2 != 0)
                count += 1;
            
            if (count > k){
               while (count > k && start <= i){
                if (nums[start] % 2 != 0)
                   count -= 1;
                start += 1;
               }
            }
            if (count <= k){
                ans += (start - i) + 1;
            }
        }
        return ans;
    }
}