class Solution {
    int maxindex = -1;
    public long maximumTripletValue(int... nums) {
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            long a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                long b = nums[j];
                for (int k = j + 1; k < nums.length; k++){
                    max = Math.max((a-b) * nums[k],max);
                }
            }
        }

        return max;
    }
    public int findMax(int start, int end, int... nums) {
        int max = -1;
        int maxi = -1;
        for (int i = start; i < end; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxi = i;
            }
        }
        return maxi;
    }
}