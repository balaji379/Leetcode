class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1 , i = 0, j = 0, subArrCount = 0;
        if (k == 0) return 0;
        while (j < nums.length){
            product *= nums[j];
            while (product >= k && i < j) {
                product /= nums[i++];
            }
            if (product < k )
               subArrCount += (j-i) + 1;
            j += 1;
        }
        return subArrCount;
    }
}