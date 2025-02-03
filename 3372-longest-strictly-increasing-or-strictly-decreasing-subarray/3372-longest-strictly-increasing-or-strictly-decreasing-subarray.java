class Solution {
    public int longestMonotonicSubarray(int[] nums) {
         int max = Math.max(findMaxSub(true,nums),findMaxSub(false,nums));
        //  System.out.print(max);
         return max;
    }
    public int findMaxSub(boolean flag,int...nums){
              Stack<Integer> stack = new Stack<>();
              int max = 0;
              for (int i = 0; i < nums.length; i++){
                if (stack.isEmpty())
                       stack.push(nums[i]);
                if (flag){
                    if (stack.peek() < nums[i])
                        stack.push(nums[i]);
                    else {
                        max = Math.max(max,stack.size());
                        stack = new Stack<Integer>();
                        stack.push(nums[i]);
                    }
                }
                else {
                      if (stack.peek() > nums[i])
                        stack.push(nums[i]);
                    else {
                        max = Math.max(max,stack.size());
                        stack = new Stack<Integer>();
                        stack.push(nums[i]);
                    }
                }
              }
              max = Math.max(max,stack.size());
              return max;
    }
}