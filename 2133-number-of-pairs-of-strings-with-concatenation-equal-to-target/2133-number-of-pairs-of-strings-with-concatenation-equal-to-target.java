class Solution {
    public int numOfPairs(String[] nums, String target) {
        int ans = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && target.equals(nums[i]+nums[j])) ans+=1;
            }
        }
        return ans;
    }
}