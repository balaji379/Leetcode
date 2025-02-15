class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            List<Integer> digits = new ArrayList<>();
            int temp = sq;
            while (temp > 0) {
                digits.add(0, temp % 10);
                temp /= 10;
            }
            if (canPartition(i, digits, 0, 0)) {
                sum += sq;
            }
        }
        return sum;
    }

    public  boolean canPartition(int target, List<Integer> digits, int index, int currentSum) {
        if (currentSum > target) {
            return false;
        }
        if (index == digits.size()) {
            return currentSum == target;
        }

        int num = 0;
        for (int i = index; i < digits.size(); i++) {
            num = num * 10 + digits.get(i);
            if (canPartition(target, digits, i + 1, currentSum + num)) {
                return true;
            }
        }
        return false;
    }
}