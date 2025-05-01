class Solution {
    public int[] nextGreaterElements(int[] nums) {
         int[] ans = new int[nums.length];
         solve(new Stack<>(),ans,nums);
         return ans;
    }

    public void solve(Stack<Integer> stack, int[] ans,int[] nums) {
        for (int i = nums.length * 2 - 1; i >= 0; --i)  {
             int pos = i % nums.length;
             if (i >= nums.length && stack.isEmpty()){
                stack.push(nums[pos]);
                // ans[i] = -1;
             }else if (i < nums.length && stack.isEmpty()){
                stack.push(nums[i]);
                ans[i] = -1;
             }
             else if (nums[pos] >= stack.peek()){
                     while (!stack.isEmpty() && nums[pos] >= stack.peek()){
                        stack.pop();
                     }
                     if (stack.isEmpty()){
                        if (i < nums.length)
                            ans[i] = -1;
                        stack.push(nums[pos]);
                     }else{
                        if (i < nums.length){
                            ans[i] = stack.peek();
                        }
                        stack.push(nums[pos]);
                     }
             }else{
                if (i < nums.length){
                    ans[i] = stack.peek();
                }
                stack.push(nums[pos]);
             }
        }
    }
}