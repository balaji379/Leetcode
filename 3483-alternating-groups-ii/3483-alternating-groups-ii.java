class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int start = 0, end = 0, ans = 0, count = 0;
        while (start < colors.length) {
            if (colors[end] != colors[(end + 1) >= colors.length ? 0 : end + 1]) {
                count += 1;
            } else if (end < start)
                break;
            else {
                if (end < start || end + 1 >= colors.length)
                    break;
                else
                    start = end + 1;
                count = 0;
            }
            if (count + 1 == k) {
                ans += 1;
                count -= 1;
                start += 1;
            }
            end += 1;
            if (end >= colors.length)
               end = 0;
        }
        return ans;
    }
}