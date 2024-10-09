class Solution {
    public int minStartValue(int[] nums) {
         int pre = 0;
         int index = 0;
         int[] stepans = new int[nums.length];
         int minstartval = 0;
         while( index < nums.length ){
           stepans[index] = pre + nums[index];
           if( stepans[index] <= 0){
                minstartval += Math.abs(stepans[index]) + 1;
                stepans[index] = 1;
           }
           pre = stepans[index++];
         }
         if( minstartval != 0)
             return minstartval;
         return 1;
    }
}