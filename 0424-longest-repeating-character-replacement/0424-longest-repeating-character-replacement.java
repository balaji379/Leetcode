class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, w_s = -1, max_f = -1;
        char[] letters = s.toCharArray();
        int i = 0, j = 0;
        while (j < letters.length) {
            map.put(letters[j], (map.getOrDefault(letters[j], 0) + 1));
            max_f = -1;
            for (int val : map.values())
                max_f = (Math.max(val, max_f));
            w_s = (j - i) + 1;
            int flip = w_s - max_f;
            if (flip <= k)
                max = Math.max(w_s, max);
            else {
                while (flip > k) {
                    map.put(letters[i], map.get(letters[i]) - 1);
                    if (map.get(letters[i]) <= 0) {
                        map.remove(letters[i]);
                    }
                    i += 1;
                    if (!map.isEmpty()) {
                        max_f = -1;
                        for (int val : map.values())
                            max_f = (Math.max(val, max_f));
                        w_s = (j - i) + 1;
                        flip = w_s - max_f;
                        if (flip <= k)
                            max = Math.max(w_s, max);
                    }
                }
            }
            j += 1;
        }
        return max;
    }
}