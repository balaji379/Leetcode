class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                if (map.get(a) == map.get(b))
                    return a.compareTo(b);
                return map.get(b).compareTo(map.get(a));
            }
        });
        Set<Character> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                queue.add(c);
                set.add(c);
            }
        }
        StringBuilder sb = new StringBuilder("");
        while (!queue.isEmpty()) {
            char c = queue.poll();
            int limit = map.get(c);
            for (int i = 0; i < limit; i++)
               sb.append(c);
        }
        return sb.toString();
    }
}