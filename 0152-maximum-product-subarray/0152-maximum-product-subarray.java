class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1){
           return nums[0];
        }
        int leftProduct = 1,rightProduct = 1,leftMax = 0 , rightMax = 0;
        for (int start = 0 , end = nums.length - 1; start < nums.length; start++,end-- ){
            leftProduct *= nums[start];
            leftMax = Math.max(leftMax,leftProduct);
            rightProduct *= nums[end];
            rightMax = Math.max(rightMax,rightProduct);
            if (leftProduct == 0)
               leftProduct = 1;
            if (rightProduct == 0)
                rightProduct = 1;
        }
     return Math.max(leftMax,rightMax);
    }
}