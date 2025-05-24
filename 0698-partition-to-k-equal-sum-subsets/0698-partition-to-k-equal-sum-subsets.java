class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
         int total = Arrays.stream(nums).sum();
         if (total % k != 0) 
           return false;
         int target = total / k;
         boolean[] path = new boolean[nums.length];
        return solve(path,target,k,nums,0,0);
        
    }
    public boolean solve(boolean[] path,int target,int k,int[] nums,int index,int sum){

        if (k == 0)
           return true;
        if (sum > target)
           return false;
        if (sum == target)
           return solve(path,target,k - 1,nums,0,0);

        for(int i = index; i < nums.length; ++i){
            if(path[i])
               continue;
            if (sum + nums[i] > target)
               continue;
            path[i] = true;
            if(solve(path,target,k,nums, i + 1,sum + nums[i]))
                return true;
            path[i] = false;
        }
        return false;
    }
}