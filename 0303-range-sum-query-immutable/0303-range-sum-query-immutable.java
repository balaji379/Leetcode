class NumArray {
       int[] nums;
    public NumArray(int[] nums) {
         this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
           for(int l = left; l <= right; l++){
               sum += nums[l];
           }
           return sum ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */