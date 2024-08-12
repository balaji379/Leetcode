class Solution {
    public int rob(int[] nums) {
        if(nums.length<2)
           return nums[0];
        int[] totalloot = new int[nums.length];
        totalloot[0] = nums[0];
        for(int i =1 ;i<nums.length;i++){
            if(i>=2){
                totalloot[i] = Math.max(totalloot[i-2]+nums[i],totalloot[i-1]);
            }
            else
               totalloot[i] = Math.max(totalloot[0],nums[i]);
        }
        return totalloot[nums.length-1];
    }
}