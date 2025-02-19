class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] res = new int[nums.length];
         for (int i = 0; i < nums.length; i++){
            int step = nums[i];
            if (step < 0){
                  step = Math.abs(step);
                  int index = i;
                  while(step != 0){
                       index -= 1;
                       step -= 1;
                       if (index < 0)
                           index = nums.length - 1;
                  }
                  res[i] = nums[index];
            }
            else if (step > 0){
               step += i;
               if (step < nums.length)
                   res[i] = nums[step];
               else{
                step = step % nums.length;
                res[i] = nums[step];
               }
            }
            else res[i] = nums[i];
         }
         return res;
    }
}