class Solution {
    public int maxProfit(int[] nums) {
          int buy = 0 ,max = 0 ,profit =0;
     for(int i = 1 ; i < nums.length ;i++){
        if(nums[max]<=nums[i]){
            max = i;
        }else{
            profit += nums[max] - nums[buy];
            max = i;
            buy = i;
        }
     }
     if(max != buy){
        profit += nums[max] - nums[buy];
     }
     return profit ;
    }
}