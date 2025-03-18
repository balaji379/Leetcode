class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] count = new int[10];
        int sum = 0;
        if (n == 0)
         return 1;
        for (int i = 1; i <= n; i++) {
            sum += solve("", count, i, i, 0);
        }
      return sum;
    }

    public static int solve(String s, int[] count, int place, int target, int sum) {
        if (place == 0)
            return sum + 1;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= 9; i++) {
            if (target != 1 && target == place && i == 0)
                continue;
            if (count[i] == 0) {
                sb.append(i);
                count[i] = 1;
                sum = solve(sb.toString(), count, place - 1, target, sum);
                count[i] = 0;
                sb.deleteCharAt(sb.length() - 1);
            }

        }
        return sum;
    }
}
