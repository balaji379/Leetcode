class Solution {
    public int findUnsortedSubarray(int[] nums) {
         Stack<Integer> forward_pass = new Stack<>();
        forward_pass.push(Integer.MIN_VALUE);
        Stack<Integer> backward_pass = new Stack<>();
        backward_pass.push(Integer.MAX_VALUE);
        int minstart = Integer.MAX_VALUE, maxend = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (forward_pass.peek() == Integer.MIN_VALUE)
                forward_pass.push(i);
            else {
                boolean pop = false;
                while (forward_pass.peek() != Integer.MIN_VALUE && nums[forward_pass.peek()] > nums[i]) {
                    pop = true;
                    forward_pass.pop();
                }
                if (forward_pass.peek() != Integer.MIN_VALUE) {
                    if (pop)
                        minstart = Math.min(forward_pass.peek() + 1, minstart);
                    forward_pass.push(forward_pass.peek() + 1);
                } else {
                    minstart = 0;
                    break;
                }
            }
        }
        if (minstart == Integer.MAX_VALUE)
            return 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (backward_pass.peek() == Integer.MAX_VALUE)
                backward_pass.push(i);
            else {
                var pop = false;
                while (backward_pass.peek() != Integer.MAX_VALUE && nums[backward_pass.peek()] < nums[i]) {
                    pop = true;
                    backward_pass.pop();
                }
                if (backward_pass.peek() != Integer.MAX_VALUE) {
                    if (pop)
                        maxend = Math.max(maxend, backward_pass.peek() - 1);
                    backward_pass.push(backward_pass.peek() - 1);
                } else {
                    maxend = nums.length - 1;
                    break;
                }
            }
        }
        System.out.println("the  min value is :" + minstart + " " + "the max value is :" + maxend);
        return (maxend - minstart) + 1;
    }
}