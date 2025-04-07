class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        Set<String> set = new HashSet<>();
        Map<String, Integer> same = new HashMap<>();
        int count = 0;
        for (String s : words) {
            if (s.charAt(0) == s.charAt(1)) {
                same.put(s, same.getOrDefault(s, 0) + 1);
                set.add(s);
            } else {
                StringBuilder sb = new StringBuilder(s);
                sb.reverse();
                String r = sb.toString();
                if (!set.contains(r) && map.containsKey(r)) {
                    int first = map.get(s);
                    int second = map.get(r);
                    if (first == second)
                        count += (first + second);
                    else {
                        count += (Math.min(first, second) * 2);
                    }
                    set.add(s);
                    set.add(r);
                }
            }

        }
        int max = 0;
        boolean flag = true;
        for (int f : same.values()) {
            if (f % 2 == 0)
                max += f;
            else if (f % 2 != 0) {
                if (flag) {
                    max += f;
                    flag = false;
                } else
                    max += (f - 1);
            }
        }
        return (count + max) * 2;
    }
}