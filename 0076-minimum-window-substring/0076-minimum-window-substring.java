class Solution {
    public String minWindow(String s, String t) {
    Map<Character, Integer> map = new HashMap<>();
    Map<Character, Integer> targetMap = new HashMap<>();
    int mins = -1, mine = -1, count = 0, target = 0, start = 0, len = s.length(), min = Integer.MAX_VALUE;

    for (char c : t.toCharArray())
        targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
    target = targetMap.size();

    for (int i = 0; i < len; ++i) {
        char c = s.charAt(i);
        if (targetMap.containsKey(c)) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c).equals(targetMap.get(c))) {
                count++;
            }
        }

        while (count == target) {
            int cur = (i - start) + 1;
            if (cur < min) {
                mins = start;
                mine = i;
                min = cur;
            }
            char pre = s.charAt(start);
            if (targetMap.containsKey(pre)) {
                map.put(pre, map.get(pre) - 1);
                if (map.get(pre) < targetMap.get(pre)) {
                    count--;
                }
            }
            start++;
        }
    }

    if (mins == -1 || mine == -1) 
        return "";
    return s.substring(mins, mine + 1);
}

}