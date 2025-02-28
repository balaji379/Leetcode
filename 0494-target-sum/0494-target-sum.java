class Solution {
    public int findTargetSumWays(int[] nums, int target) {
         return solve(nums,target,0,0,0,0);
    }
   public  int solve(int[] nums,int target,int index,int sum,int val,int count){

        sum += val;
        if (index >= nums.length){
            if (sum == target)
                return count + 1;
            else return count;
        }

        count = solve(nums,target,index+1,sum ,nums[index],count);
        count = solve(nums,target,index+1,sum,nums[index] * -1,count);
        return count;
    }
}