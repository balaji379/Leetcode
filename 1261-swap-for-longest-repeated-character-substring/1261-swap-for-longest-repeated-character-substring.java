class Solution {
    public int maxRepOpt1(String text) {
        char[] letters = text.toCharArray();
        return findLongestSubString(letters);
    }

    private static int findLongestSubString(char[] letters) {
        int left = 0, max = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : letters) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char pre = letters[0];
        int i = 0;
        while (i < letters.length) {
            while (i < letters.length && pre == letters[i]) {
                left += 1;
                i += 1;
            }
            int temp = i;
            if (left != 0 && temp < letters.length - 1 && pre == letters[temp + 1]) {
                temp += 1;
                while (temp < letters.length && pre == letters[temp]) {
                    right += 1;
                    temp += 1;
                }
            } else {
                if (left < map.get(pre))
                    left += 1;
                max = Math.max(max, left);
            }
            if ((left + right) == map.get(pre)) {
                max = Math.max(max, (left + right));
            } else if (right != 0 && (left + right) < map.get(pre)) {
                max = Math.max(max, (left + right) + 1);
            } else
                max = Math.max(left, max);

            if (i < letters.length) {
                pre = letters[i];
                left = 0;
                right = 0;
            }
        }
        return max;
    }

}
