class Solution {
    List<Integer> nums = new ArrayList<>();
    public List<Integer> splitIntoFibonacci(String num) {
        solve(0, num, num.length());
        return nums;
    }
   public  boolean solve(int index, String dig, int len) {
        if (index >= dig.length()) {
            if (nums.size() > 2)
                return true;
            return false;
        }

        long target = -1;
        if (nums.size() >= 2) {
            target = nums.getLast() + nums.get(nums.size() - 2);
        }
        if (target > Integer.MAX_VALUE)
            return false;
        long val = 0;
        for (int i = index; i < len; i++) {
            val += (dig.charAt(i) - '0');
            if (val > Integer.MAX_VALUE)
                return false;
            if (nums.size() >= 2) {
                if (val == target) {
                    nums.add((int) val);
                    if (solve(i + 1, dig, len))
                        return true;
                    nums.removeLast();
                }
                if (val > target) {
                    return false;
                }
            } else {
                nums.add((int) val);
                if (solve(i + 1, dig, len))
                    return true;
                nums.removeLast();
            }
            if (val == 0)
                return false;
            val *= 10;
            if (val > Integer.MAX_VALUE)
                return false;
        }
        return false;
    }


}