class Solution {
    public int minOperations(int[][] mat, int x) {
        int[] nums = new int[mat.length * mat[0].length];
        int index = 0,remainder = mat[0][0] % x;
        for (int[] arr : mat)
            for (int val : arr) {
                nums[index++] = val;
                if (val % x != remainder) {
                    System.out.println(-1);
                    return -1;
                }
            }
        Arrays.sort(nums);
        int mid = nums[nums.length / 2],step = 0;
        for(int val : nums){
            step += Math.abs((val - mid) / x);
        }
        return step;
    }
}