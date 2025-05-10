class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
    if (nums.length < 3) return 0; // Less than 3 elements can't form an arithmetic slice

    int count = 0; // Total number of arithmetic slices
    int currentLength = 0; // Length of the current arithmetic slice

    for (int i = 2; i < nums.length; i++) {
        // Check if the current triplet forms an arithmetic slice
        if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
            currentLength++; // Increase the length of the current arithmetic slice
            count += currentLength; // Add the number of new slices formed
        } else {
            currentLength = 0; // Reset the length if the sequence breaks
        }
    }

    return count;
}
}