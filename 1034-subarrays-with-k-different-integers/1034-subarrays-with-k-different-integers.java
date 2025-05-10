class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
          return Math.abs(solve(k,nums) - solve(k - 1,nums));
    }   
    public int solve(int k ,int...nums){
        int start = 0 , count = 0,ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            int cur = nums[i];
            map.put(cur,map.getOrDefault(cur,0) + 1);
            if (map.get(cur) == 1)
               count += 1;
            while (count > k && start <= i){
                int pre = nums[start];
                map.put(pre,map.get(pre) - 1);
                if (map.get(pre) == 0){
                    count -= 1;
                    map.remove(pre);
                }
                start += 1;
            }
            ans += (i - start) + 1;
        }
        return ans;
    }
}