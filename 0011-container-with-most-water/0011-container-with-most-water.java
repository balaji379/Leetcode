class Solution {
    public int maxArea(int[] nums) {
      int left = 0 , right = nums.length-1,max = -2,cur =0;
           while(left<right){
            if(nums[left]<=nums[right]){
                    cur = (nums[left] *(right-left));
                    max = Math.max(max, cur);
                    left += 1;
            }else{
                cur = (nums[right] * (right-left));
                max = Math.max(max, cur);
                right -= 1;
            }
           }
           return max;   

    }
}