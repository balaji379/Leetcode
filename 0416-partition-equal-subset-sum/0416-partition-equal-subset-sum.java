import java.util.Arrays;

public class Solution {
    private int[][] mem;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }

        mem = new int[nums.length + 1][sum / 2 + 1];
        for (int[] row : mem) {
            Arrays.fill(row, -1);
        }

        return subsetSum(nums, nums.length, 0, sum / 2);
    }

    private boolean subsetSum(int[] nums, int n, int pos, int sum) {
        if (sum == 0) {
            return true; // Sum found
        } else if (pos >= n || sum < 0) {
            return false; // Out of bounds
        }

        if (mem[pos][sum] != -1) {
            return mem[pos][sum] == 1;
        }

        boolean result = subsetSum(nums, n, pos + 1, sum - nums[pos]) || subsetSum(nums, n, pos + 1, sum);
        mem[pos][sum] = result ? 1 : 0;
        return result;
    }
}