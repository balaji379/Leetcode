class Solution {
    public int maxAscendingSum(int[] nums) {
         int sum = 0,pre = 0,start = 0,len = nums.length,max = 0;
         while(start < len){
            if (pre < nums[start]){
                sum += nums[start];
                // System.out.print(sum + " ");
                pre = nums[start];
                start += 1;
            }else{
                pre = 0;
                max = sum > max ? sum : max;
                sum = 0;
            }
         }
         max = Math.max(max, sum);
         return max;
    }
}