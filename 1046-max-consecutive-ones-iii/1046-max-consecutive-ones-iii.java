class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, max = Integer.MIN_VALUE;
        while (j < nums.length) {
            if (nums[j] == 0)
                k -= 1;
            if (k >= 0)
                max = Math.max(max, j - i);
            if (k == -1) {
                while (nums[i] == 1 && i < nums.length)
                    i += 1;
                if (nums[i] == 0) {
                    k += 2;
                    i += 1;
                }

                continue;
            }
            j += 1;
        }
        System.out.println("the j value is :" + j);
        // max = Math.max(max, (j) - i);
        return max + 1;
    }
}