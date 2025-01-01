class Solution {
    public void duplicateZeros(int[] arr) {
        duplicateZero(arr);
    }
   public  void duplicateZero(int... nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count += 1;
            else if (count != 0) {
                modifyArr(count, i - 1, nums);
                i += count;
                i--;
                count = 0;
            }
        }
        // System.out.println("the answer is : " + Arrays.toString(nums));
    }

    private  void modifyArr(int count, int start, int[] nums) {

        int swapPoint = (nums.length - count) - 1;
        if (swapPoint >= 0) {
            for (int i = swapPoint, removeInd = nums.length - 1; i > start; i--, removeInd--) {
                nums[removeInd] = nums[i];
            }
            if (((start + 1) + count) < nums.length) {
                for (int i = start + 1; i < ((start + 1) + count); i++) {
                    nums[i] = 0;
                }
            } else {
                while (start < nums.length) {
                    nums[start++] = 0;
                }
            }
        }
    }
}